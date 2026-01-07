package com.github.lowkkid.thewildoasisbackend.minio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface MinioService {

    String uploadFile(MultipartFile file, String objectName);

    void deleteFile(String objectName);

    String generateDownloadUrl(String objectName);

    String generateDownloadUrlWithRetry(String objectName);
}