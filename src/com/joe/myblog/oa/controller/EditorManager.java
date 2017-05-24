package com.joe.myblog.oa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.joe.myblog.oa.service.ConfigService;
import com.joe.myblog.oa.utils.ConstantVo;
import com.joe.myblog.oa.utils.FileUtil;

import sun.reflect.misc.FieldUtil;

/**
* Title: EditorManager
* Description: 富文本编辑器管理
* @author HuangJian
* @date 2017年5月13日
*
*/
@RequestMapping("/blog")
@Controller
public class EditorManager extends BaseController{

	
	/**
	* Title: EditorManager.java
	* Description: 富文本上传文件
	* @param file
	* @return
	* @author HuangJian
	* @date 2017年5月14日
	*/
	@RequestMapping("/editoruploadimg")
	@ResponseBody
	public String editorUpload(@RequestParam(value="file",required=true) MultipartFile file){
		Map<String, Object> param=new HashMap<>();
		
		if(file.getSize() > 0){
			String vPath = FileUtil.uploadImage(file);//返回虚拟路径
			param.put("link", this.selectValueByKey(ConstantVo.CONFIG_DOMAIN_PR)+vPath);
		}
		return new Gson().toJson(param);
	}
	/**
	* Title: EditorManager.java
	* Description: 根据路径删除图片
	* @param url
	* @return
	* @author HuangJian
	* @date 2017年5月14日
	*/
	@RequestMapping("/editordelimg")
	@ResponseBody
	public String editorDeleteByUrl(String url){
		boolean b = FileUtil.deleteImgByUrl(url);
		return new Gson().toJson(b);
	}
}
