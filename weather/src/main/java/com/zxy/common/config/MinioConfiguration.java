package com.zxy.common.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfiguration {

    @Value("${spring.cloud.storage.minio.endpoint}")
    private String minioEndpoint;

    @Value("${spring.cloud.storage.minio.access-key}")
    private String minioAccessKey;

    @Value("${spring.cloud.storage.minio.secret-key}")
    private String minioSecretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioEndpoint)
                .credentials(minioAccessKey, minioSecretKey)
                .build();
    }
}