package com.example.scheduledtest.controller;

import java.io.IOException;
import java.io.InputStream;

import com.example.scheduledtest.pojo.User;
import com.example.scheduledtest.service.UserService;
import com.example.scheduledtest.util.FtpUtil;
import com.example.scheduledtest.util.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/* *
 * @Author shenguang
 * @Description //FTP上传图片
 * @Date 11:06 2019/4/18
 * @Param
 * @return
 **/
@Controller
public class UserContrller {

	@Value("${FTP.ADDRESS}")
	private String host;
	// 端口
	@Value("${FTP.PORT}")
	private int port;
	// ftp用户名
	@Value("${FTP.USERNAME}")
	private String userName;
	// ftp用户密码
	@Value("${FTP.PASSWORD}")
	private String passWord;
	// 文件在服务器端保存的主目录
	@Value("${FTP.BASEPATH}")
	private String basePath;
	// 访问图片时的基础url
	@Value("${IMAGE.BASE.URL}")
	private String baseUrl;

	@Autowired
	private UserService userService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(
			@RequestParam("pic") MultipartFile uploadFile,
			@RequestParam("username")String username,
			@RequestParam("password") String password) {
		try {
			//1、给上传的图片生成新的文件名
			//1.1获取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//1.2使用IDUtils工具类生成新的文件名，新文件名 = newName + 文件后缀
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//1.3生成文件在服务器端存储的子目录
			String filePath = new DateTime().toString("/yyyy/MM/dd");

			//2、把前端输入信息，包括图片的url保存到数据库
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setPicture(baseUrl + filePath + "/" + newName);
			userService.insertUser(user);
			
			//3、把图片上传到图片服务器
			//3.1获取上传的io流
			InputStream input = uploadFile.getInputStream();
			
			//3.2调用FtpUtil工具类进行上传
			boolean result = FtpUtil.uploadFile(host, port, userName, passWord, basePath, filePath, newName, input);
			if(result) {
				return "success";
			}else {
				return "false";
			}
		} catch (IOException e) {
			return "false";
		}
	}

}
