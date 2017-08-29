package com.joe.myblog.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.joe.myblog.oa.mapper.TMessageBoardMapper;
import com.joe.myblog.oa.po.TMessageBoard;
import com.joe.myblog.oa.po.TMessageBoardExample;
import com.joe.myblog.oa.po.TMessageBoardExample.Criteria;
import com.joe.myblog.oa.service.MessageBoardService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
/**
* Title: MessageBoardServiceImpl
* Description: 留言
* @author HuangJian
* @date 2017年5月25日
*
*/
@Service
public class MessageBoardServiceImpl implements MessageBoardService{

	@Autowired
	private TMessageBoardMapper messageBoardMapper;
	@Override
	public List<TMessageBoard> findMessageBoard(Integer status) {
		TMessageBoardExample example = new TMessageBoardExample();
		
		Criteria criteria =  example.createCriteria();
		if(status > 0){
			criteria.andMessageStatusEqualTo(1);
		}else{
			
		}
		example.setOrderByClause("message_date desc");
		return messageBoardMapper.selectByExample(example);
	}

	@Override
	public Integer updateMessageBoard(TMessageBoard messageBoard) {
		
		return messageBoardMapper.updateByPrimaryKeySelective(messageBoard);
	}

	@Override
	public Integer saveMessageBoard(TMessageBoard messageBoard) {
		messageBoardMapper.insertSelective(messageBoard);
		return messageBoard.getMessageId();
	}

	@Override
	public Integer updateMessageBoards(Object[] ids, Integer status) {
		messageBoardMapper.updateMessageBoardsStatus(ids, status);
		
		return 1;
	}

	 

}
