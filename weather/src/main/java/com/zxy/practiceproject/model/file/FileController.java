package com.zxy.practiceproject.model.file;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.zxy.common.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/file")
public class FileController {
    @Value("${spring.cloud.storage.minio.urlPrefix}")
    private String urlPrefix;

    @Value("${spring.cloud.storage.minio.bucketName}")
    private String bucketName;

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload/img")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        try (InputStream inputStream = file.getInputStream()) {
            String objectName = file.getOriginalFilename();
            String contentType = file.getContentType();

            /**
             * 文件名：年月日小时分钟秒_随机值.扩展名
             * 路径：年/月/日/小时
             * 年/月/日/小时/年月日小时分钟秒_随机值.扩展名
             *
             * 访问路径：http://localhost:9000/bucketName/年/月/日/小时/年月日小时分钟秒_随机值.扩展名
             */
            String extName = FileNameUtil.extName(objectName);
            Date date = new Date();
            String yyyy = DateUtil.format(date, "yyyy");
            String MM = DateUtil.format(date, "MM");
            String dd = DateUtil.format(date, "dd");
            String HH = DateUtil.format(date, "HH");
            String yyyyMMddHHmmssSSS = DateUtil.format(date, "yyyyMMddHHmmssSSS");
            int randomInt = RandomUtil.randomInt(100000, 999999);
            String newFileName = StrUtil.format("{}_{}.{}", yyyyMMddHHmmssSSS, randomInt, extName);


            String relationPath = StrUtil.format("{}/{}/{}/{}/{}", yyyy,MM, dd,HH,newFileName);

            fileService.upload(inputStream, relationPath, contentType);
            return Result.success( StrUtil.format("{}{}/{}", urlPrefix,bucketName,relationPath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    @PostMapping("/upload/imgs")
    public Result<List<String>> uploadFile(@RequestParam("files") MultipartFile[] files) throws Exception {
        if (files == null || files.length == 0) {
            return Result.error("No files provided");
        }

        List<String> acccurlUrls = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }

            try (InputStream inputStream = file.getInputStream()) {
                String objectName = file.getOriginalFilename();
                String contentType = file.getContentType();

                /**
                 * 文件名：年月日小时分钟秒_随机值.扩展名
                 * 路径：年/月/日/小时
                 * 年/月/日/小时/年月日小时分钟秒_随机值.扩展名
                 *
                 * 访问路径：http://localhost:9000/bucketName/年/月/日/小时/年月日小时分钟秒_随机值.扩展名
                 */
                String extName = FileNameUtil.extName(objectName);
                Date date = new Date();
                String yyyy = DateUtil.format(date, "yyyy");
                String MM = DateUtil.format(date, "MM");
                String dd = DateUtil.format(date, "dd");
                String HH = DateUtil.format(date, "HH");
                String yyyyMMddHHmmssSSS = DateUtil.format(date, "yyyyMMddHHmmssSSS");
                int randomInt = RandomUtil.randomInt(100000, 999999);
                String newFileName = StrUtil.format("{}_{}.{}", yyyyMMddHHmmssSSS, randomInt, extName);


                String relationPath = StrUtil.format("{}/{}/{}/{}/{}", yyyy, MM, dd, HH, newFileName);

                fileService.upload(inputStream, relationPath, contentType);
                String url = StrUtil.format("{}{}/{}", urlPrefix, bucketName, relationPath);
                acccurlUrls.add(url);
            } catch (IOException e) {
                throw new RuntimeException("Failed to upload file", e);
            }
        }

        return Result.success(acccurlUrls);
    }
}