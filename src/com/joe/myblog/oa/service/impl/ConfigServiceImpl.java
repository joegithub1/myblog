package com.joe.myblog.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.myblog.oa.mapper.TConfigMapper;
import com.joe.myblog.oa.po.TConfig;
import com.joe.myblog.oa.po.TConfigExample;
import com.joe.myblog.oa.service.ConfigService;
@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private TConfigMapper configMapper;
	@Override
	public TConfig selectConfigByName(String name) {
		TConfigExample example = new TConfigExample();
		example.createCriteria().andTStatusEqualTo(1)
		.andTNameEqualTo(name);
		List<TConfig> list =  configMapper.selectByExample(example);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public String selectValueByKey(String name) {
		TConfigExample example = new TConfigExample();
		example.createCriteria().andTStatusEqualTo(1)
		.andTNameEqualTo(name);
		List<TConfig> list =  configMapper.selectByExample(example);
		if(list.size() > 0){
			return list.get(0).gettValue();
		}
		return null;
	}

}
