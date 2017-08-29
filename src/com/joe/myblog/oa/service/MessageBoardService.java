package com.joe.myblog.oa.service;

import java.util.List;

import com.joe.myblog.oa.po.TMessageBoard;

public interface MessageBoardService {

	/**
	* Title: MessageBoardService.java
	* Description: 查询所有留言根据
	* @param status
	* @return
	* @author HuangJian
	* @date 2017年5月25日
	*/
	public List<TMessageBoard> findMessageBoard(Integer status);
	
	/**
	* Title: MessageBoardService.java
	* Description: 修改留言
	* @param messageBoard
	* @return
	* @author HuangJian
	* @date 2017年5月25日
	*/
	public Integer updateMessageBoard(TMessageBoard messageBoard);
	
	/**
	* Title: MessageBoardService.java
	* Description: 添加留言
	* @param messageBoard
	* @return
	* @author HuangJian
	* @date 2017年5月25日
	*/
	public Integer saveMessageBoard(TMessageBoard messageBoard);
	
	/**
	* Title: MessageBoardService.java
	* Description: 
	* @param status
	* @return
	* @author HuangJian
	* @date 2017年5月26日
	*/
	public Integer updateMessageBoards(Object [] ids,Integer status);
}
