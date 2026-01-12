package com.github.lowkkid.lodgecore.minio.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    private final String minioEndpoint;
    private final String accessKey;
    private final String secretKey;

    public  MinioConfig(@Value("${minio.endpoint}") String minioEndpoint,
                        @Value("${minio.access-key}") String accessKey,
                        @Value("${minio.secret-key}") String secretKey) {
        this.minioEndpoint = minioEndpoint;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                        .endpoint(minioEndpoint)
                        .credentials(accessKey, secretKey)
                        .build();
    }
}
