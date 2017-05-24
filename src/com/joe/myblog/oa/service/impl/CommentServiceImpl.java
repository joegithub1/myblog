package com.joe.myblog.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.myblog.oa.mapper.TCommentMapper;
import com.joe.myblog.oa.po.TComment;
import com.joe.myblog.oa.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private TCommentMapper commentMapper;
	@Override
	public List<Map<String, Object>> findComment(Map<String, Object> param) {
		 
		return commentMapper.findComment(param);
	}
	@Override
	public Integer saveComment(TComment comment) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		comment.setCreateDate(sdf.format(new Date()));
		int result = commentMapper.insertSelective(comment);
		if(result > 0){
			return comment.getId();
		}
		return result;
	}
	@Override
	public Integer updateComment(TComment comms) {
		
		return commentMapper.updateByPrimaryKeySelective(comms);
	}

}
