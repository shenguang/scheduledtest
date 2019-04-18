package com.example.scheduledtest.controller;

import com.example.scheduledtest.util.IDUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className updateImage
 * @Description //上传到服务器的某个文件下
 * @Date 2019/4/17 18:42
 * @Author shenguang
 * @Version 1.0
 **/
@RestController
public class updateImageContoller {
    @RequestMapping("/updateimage")
    public Object updateImage(
            @RequestParam("pic") MultipartFile files,
            @RequestParam("username")String username,
            @RequestParam("password") String password) throws IOException {
        String filePath  = "E:/image";
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String date=sdf.format(new Date());
        String path = filePath + date;
        //原始名称
        String oldName = files.getOriginalFilename();
        String newName = IDUtils.genImageName();
        newName = newName + oldName.substring(oldName.lastIndexOf("."));
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        FileOutputStream os = new FileOutputStream(path+newName);
        //拿到上传文件的输入流
        InputStream in = files.getInputStream();
        //以写字节的方式写文件
        int b = 0;
        while((b=in.read()) != -1){
            os.write(b);
        }
        os.flush();
        os.close();
        in.close();
        return path+newName;
    }
}
