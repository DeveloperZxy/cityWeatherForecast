package com.zxy.practiceproject.model.file;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.minio.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Date;

@Service
public class FileService {

    @Value("${spring.cloud.storage.minio.bucket-name}")
    private String bucketName;

    private final MinioClient minioClient;

    public FileService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public String upload(InputStream fileStream, String objectName, String contentType) throws Exception {
        try {
            // 检查桶是否存在，如果不存在则创建
            boolean isBucketExist = minioClient.bucketExists(
                    BucketExistsArgs.builder()
                            .bucket(bucketName)
                            .build()
            );
            if (!isBucketExist) {
                // 使用 MakeBucketArgs 创建桶
                minioClient.makeBucket(
                        MakeBucketArgs.builder()
                                .bucket(bucketName)
                                .build()
                );
            }





            // 上传文件
            ObjectWriteResponse objectWriteResponse = minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(fileStream, fileStream.available(), -1)
                            .contentType(contentType)
                            .build()
            );

//            // 返回文件的访问路径
//            return minioClient.getPresignedObjectUrl(
//                    GetPresignedObjectUrlArgs.builder()
//                            .bucket(bucketName)
//                            .object(objectName)
//                            .build()
//            );
            return null;
        } catch (Exception e) {
            // 捕获并记录异常，便于排查问题
            throw new RuntimeException("文件上传失败: " + e.getMessage(), e);
        }
    }
}
