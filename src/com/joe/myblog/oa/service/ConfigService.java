package com.joe.myblog.oa.service;

import com.joe.myblog.oa.po.TConfig;

public interface ConfigService {

	/**
	* Title: ConfigService.java
	* Description: 根据名称查询配置
	* @param name
	* @return
	* @author HuangJian
	* @date 2017年5月14日
	*/
	public TConfig selectConfigByName(String name);
	
	/**
	* Title: ConfigService.java
	* Description: 根据名称查询value
	* @param name
	* @return
	* @author HuangJian
	* @date 2017年5月14日
	*/
	public String selectValueByKey(String name);
}
