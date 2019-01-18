package com.ruicheng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件上传
 *
 * @author chenxin@chensanjin.xin
 * @date 2019/1/18 20:55
 */
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String fileUpload(MultipartFile file) {
        if (file == null) {
            return "文件为空";
        }
        try {
            byte[] img = file.getBytes();
            File f = new File("D:\\" + file.getOriginalFilename());
            FileOutputStream fops = new FileOutputStream(f);
            fops.write(img);
            fops.flush();
            fops.close();
            System.out.println("文件已经写入到D盘");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getOriginalFilename();
    }
}
