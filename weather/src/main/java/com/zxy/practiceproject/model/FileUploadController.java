package com.zxy.practiceproject.model;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.io.file.PathUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.zxy.common.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

@RestController
//@RequestMapping("/admin/file")
public class FileUploadController {

    @Value("${spring.cloud.storage.minio.urlPrefix}")
    private String urlPrefix;


    @PostMapping("/upload/img")
    public Result uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            Result.success("文件为空，请选择文件后重新上传！");
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        String originalFilename = file.getOriginalFilename();
        String mainName = FileNameUtil.mainName(originalFilename);
        String extName = FileNameUtil.extName(originalFilename);


        /**
         * 年/月/日/小时/年月日小时分钟秒随机值.扩展名
         */
        Date date = new Date();
        String yyyy = DateUtil.format(date, "yyyy");
        String MM = DateUtil.format(date, "MM");
        String dd = DateUtil.format(date, "dd");
        String HH = DateUtil.format(date, "HH");
        String yyyyMMddHHmmssSSS = DateUtil.format(date, "yyyyMMddHHmmssSSS");
        int randomInt = RandomUtil.randomInt(100000, 999999);
        String newFileName = StrUtil.format("{}_{}.{}", yyyyMMddHHmmssSSS, randomInt, extName);


        Path relativeDirPath = Path.of(yyyy, MM, dd, HH);
        Path absoluteDirPath = Path.of(System.getProperty("user.dir"), "uploads", relativeDirPath.toString());
        if (!FileUtil.exist(absoluteDirPath.toString())) {
            FileUtil.mkdir(absoluteDirPath);
        }

        /**
         * 相对路径：  2025/03/18/20/20250318200000000000001.jpg
         * 绝对路径：  D:\Java\ReferenceCode\practice-project\\uploads\2025\03\18\20\20250318200000000000001.jpg
         * 绝对访问路径：  http://www.test.com/upload/2025/03/18/20/20250318200000000000001.jpg
         */

        Path relativeFilePath = Path.of(relativeDirPath.toString(), newFileName);
        Path absoluteFilePath = Path.of(absoluteDirPath.toString(), newFileName);



        // 保存文件
        file.transferTo(new File(absoluteFilePath.toString()));



        /**
         * 临时文件删除,不知道为什么此处报错
         */
        try{
            Resource resource = file.getResource();
            resource.getFile().deleteOnExit();
        }catch (Exception e){

        }



        String acccurlUrl = StrUtil.format("{}{}", urlPrefix, relativeFilePath);
        acccurlUrl= StrUtil.replace(acccurlUrl, "\\", "/");
        acccurlUrl=    StrUtil.replace(acccurlUrl, "\\\\", "/");
        return Result.success(acccurlUrl);

    }
}