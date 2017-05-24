package com.joe.myblog.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.myblog.oa.mapper.TArticleMapper;
import com.joe.myblog.oa.mapper.TCommentMapper;
import com.joe.myblog.oa.po.TArticle;
import com.joe.myblog.oa.po.TComment;
import com.joe.myblog.oa.po.TCommentExample;
import com.joe.myblog.oa.po.TCommentExample.Criteria;
import com.joe.myblog.oa.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private TArticleMapper articleMapper;
	@Autowired
	private TCommentMapper commentMapper;
	public List<Map<String, Object>> result;
	@Override
	public List<Map<String, Object>> findArticleList(Map<String, Object> param) {
		result = articleMapper.findArticleList(param);
		if(result.size() > 0){
			String status="";
			String statusName="--";
			Map<String, Object> temp;
			int commCount = 0;
			TCommentExample example = new TCommentExample();
			Criteria criteria =  example.createCriteria();
			for (int i = 0; i < result.size(); i++) {
				temp = result.get(i);
				
				Integer id = Integer.parseInt(String.valueOf(temp.get("id")));
				//统计评论人数
				criteria.andArticleIdEqualTo(id).andIsDelEqualTo(0).andStatusEqualTo(0);
				commCount = commentMapper.countByExample(example);
				temp.put("commCount",commCount);
				status = String.valueOf(temp.get("status"));
				switch (status) {
				case "0":
					statusName="启用";
					break;
				case "1":
					statusName="禁用";
					break;
				case "2":
					statusName="未审核";
					break;
				default:
					break;
				}
				temp.put("statusName", statusName);
			}
		}
		return result;
	}
	@Override
	public Integer insertArticle(TArticle article) {
		int result = articleMapper.insertSelective(article);
		if(result > 0){
			return article.getId();
		}
		return result;
	}
	@Override
	public Integer updateArticle(TArticle article) {
		 
		return articleMapper.updateByPrimaryKeySelective(article);
	}
	@Override
	public TArticle getArticleById(Integer id) {
		
		return articleMapper.selectByPrimaryKey(id);
	}

}
