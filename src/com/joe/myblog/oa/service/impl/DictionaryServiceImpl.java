package com.joe.myblog.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.myblog.oa.mapper.TDictionaryMapper;
import com.joe.myblog.oa.po.TDictionary;
import com.joe.myblog.oa.po.TDictionaryExample;
import com.joe.myblog.oa.po.TDictionaryExample.Criteria;
import com.joe.myblog.oa.service.DictionaryService;
@Service
public class DictionaryServiceImpl implements DictionaryService{

	@Autowired
	private TDictionaryMapper dictionaryMapper;
	@Override
	public List<TDictionary> getDictionaries(Map<String, Object> param) {
		Integer typeNum = Integer.parseInt(String.valueOf(param.get("typeNum")));
		TDictionaryExample example = new TDictionaryExample();
		Criteria criteria =  example.createCriteria();
		criteria.andDStatusEqualTo(0);
		criteria.andDTypeEqualTo(typeNum);
		example.setOrderByClause("d_value");
		return dictionaryMapper.selectByExample(example);
	}
	@Override
	public TDictionary geTDictionaryByIdType(Integer articleId, Integer type) {
		TDictionaryExample example = new TDictionaryExample();
		Criteria criteria =  example.createCriteria();
		criteria.andDStatusEqualTo(0);
		criteria.andDTypeEqualTo(type);
		criteria.andDValueEqualTo(articleId);
		List<TDictionary> list =  dictionaryMapper.selectByExample(example);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
		
}
