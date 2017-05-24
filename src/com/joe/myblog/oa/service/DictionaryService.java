package com.joe.myblog.oa.service;

import java.util.List;
import java.util.Map;

import com.joe.myblog.oa.po.TDictionary;

public interface DictionaryService {

	/**
	* Title: DictionaryService.java
	* Description: 获取字典
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年5月3日
	*/
	List<TDictionary> getDictionaries(Map<String, Object> param);
	
	/**
	* Title: DictionaryService.java
	* Description: 根据文章id查询
	* @param articleId 文章ID
	* @param type 类型
	* @return
	* @author HuangJian
	* @date 2017年5月18日
	*/
	TDictionary geTDictionaryByIdType(Integer articleId,Integer type);
}
