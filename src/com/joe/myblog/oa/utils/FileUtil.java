package com.joe.myblog.oa.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	/**
	* Title: FileUtil.java
	* Description: 获取项目路径
	* @return
	* @author HuangJian
	* @date 2017年5月13日
	*/
	public static String getProjectPath(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		String path = request.getSession().getServletContext().getRealPath("/");
		return path;
	}
	/**
	* Title: FileUtil.java
	* Description: 
	* @param in 
	* @param dir 从这个目录拷贝到realName这个目录
	* @param realName
	* @return
	* @author HuangJian
	 * @throws IOException 
	* @date 2017年5月13日
	*/
	public static String copyFile(InputStream in,String dir,String realName) throws IOException{
		File file = new File(dir,realName);
		if(!file.exists()){
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		FileUtils.copyInputStreamToFile(in, file);
		return realName;
	}
	public static String uploadImage(MultipartFile file){
		String newFileName = String.valueOf(System.currentTimeMillis());//时间戳文件名
		String url="/static/froala_editor_2.6.0/img/";
		String proLocal = getProjectPath();
		String extName="";//扩展名
		try {
			if(file.getOriginalFilename().lastIndexOf(".") > 0){
				extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			}
			
			String vFileName = newFileName + extName;//
			
			copyFile(file.getInputStream(), proLocal+url, vFileName);
			String vPath = url+vFileName;
			System.out.println(vPath);
			return vPath;
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	* Title: FileUtil.java
	* Description: 根据路径删除图片
	* @param url
	* @return
	* @author HuangJian
	* @date 2017年5月15日
	*/
	public static boolean deleteImgByUrl(String url){
		
		File file = new File(url);
		return file.delete();
		
	}
}
