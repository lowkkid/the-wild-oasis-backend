package com.github.lowkkid.thewildoasisbackend.service.impl;

import com.github.lowkkid.thewildoasisbackend.service.MinioService;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.http.Method;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MinioServiceImpl implements MinioService {

    private static final int EXPIRY_OF_MINIO_FILES_IN_HOURS = 48;
    private final MinioClient minioClient;
    private final String applicationBucket;


    public MinioServiceImpl(MinioClient minioClient, @Value("${minio.bucket}") String applicationBucket) {
        this.minioClient = minioClient;
        this.applicationBucket = applicationBucket;
    }

    @Override
    public String uploadFile(MultipartFile file, String objectName) {
        try {
            var args = PutObjectArgs.builder()
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .bucket(applicationBucket)
                    .object(objectName)
                    .contentType(resolveContentType(file.getOriginalFilename()))
                    .build();
            minioClient.putObject(args);
            return generateDownloadUrl(objectName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    @Override
    public void deleteFile(String objectName) {
        try {
            var args = RemoveObjectArgs.builder()
                    .bucket(applicationBucket)
                    .object(objectName)
                    .build();
            minioClient.removeObject(args);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete file", e);
        }
    }


    @Override
    public String generateDownloadUrl(String objectName) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(applicationBucket)
                            .object(objectName)
                            .expiry(EXPIRY_OF_MINIO_FILES_IN_HOURS, TimeUnit.HOURS)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate download URL", e);
        }
    }

    @Retryable(
            retryFor = RuntimeException.class,
            backoff = @Backoff(delay = 500, multiplier = 2)
    )
    @Override
    public String generateDownloadUrlWithRetry(String objectName) {
        return generateDownloadUrl(objectName);
    }


    private String resolveContentType(String filename) {
        String extension = StringUtils.getFilenameExtension(filename);
        if (extension == null) {
            return "application/octet-stream";
        }

        return switch (extension.toLowerCase()) {
            case "jpg", "jpeg" -> "image/jpeg";
            case "png" -> "image/png";
            case "gif" -> "image/gif";
            case "bmp" -> "image/bmp";
            case "webp" -> "image/webp";
            case "svg" -> "image/svg+xml";
            default -> "application/octet-stream";
        };
    }
}
