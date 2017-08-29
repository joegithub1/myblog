<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name='viewport' content='user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0' />
<meta name='apple-mobile-web-app-capable' content='yes' /> 
<meta name='apple-mobile-web-app-status-bar-style' content='black' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台-留言管理</title>
</head>
<body>
<div class=" site-min-height">
 <h3><i class="fa fa-angle-right"></i>留言管理</h3>
 <div class="row mt">
  <div class="col-lg-12">
   <div class="content-panel">
     <div class="col-md-12">
      <div class="col-md-8"></div>
      <div class="col-md-4">
       <button onclick="mute(1);" class="btn btn-primary btn-large">批量启用</button>
       
       <button onclick="mute(0);" class="btn btn-primary btn-large">批量禁用</button>
      </div>
     </div>
     <section id="unseen">
      <table class="table table-bordered table-striped table-condensed">
      	<col width="1%">
      	<col width="1%">
      	<col width="2%">
      	<col width="10%">
      	<col width="2%">
      	<col width="2%">
      	<thead>
      		<tr>
      			<th>
      				<span class="check"><input id="check_all" name="check_all" type="checkbox" class="checked"></span>
      			</th>
      			<th>ID</th>
      			<th>留言时间</th>
      			<th>留言内容</th>
      			<th>用户名称</th>
      			<th>状态</th>
      		</tr>
      	</thead>
      	<tbody>
      	<c:forEach items="${mbs.list}" var="m">
      		<tr>
      			<td>
      			<span class="check"><input name="check_name" value="${m.messageId }" type="checkbox" class="checked"></span>
      			</td>
      			<td>${m.messageId }</td>
      			<td>${m.messageDate }</td>
      			<td>${m.messageContent }</td>
      			<td>${m.messageUser }</td>
      			<td>
      				<c:if test="${m.messageStatus == 0}">禁用</c:if>
      				<c:if test="${m.messageStatus == 1}">生效</c:if>
      			</td>
      		</tr>
      	</c:forEach>
      	</tbody>
      </table>
     </section>
   </div>
     <div class="showback">
		<div id="page-group" class="btn-group">
		 
		</div>
	 </div>   
  </div>
 </div>
 
</div>
<script type="text/javascript">
function pageInfoList(pageNum){
	
	loadRight('<%=path%>/blog/messboards', {"pageNum":pageNum});
}
/* 禁用 */
function mute(sn){
	var v=$("input[name=check_name]").checkvalue();
	if(v.length < 0){
		layer.msg("请选择一项");
		return false;
	}
	
	  
	var f = sn == 0?"禁用":"启用"
	layer.confirm('确定'+f+'操作吗?', {btn:['确定','取消']}, function(index){
		 
		$.ajax({
			url:'<%=path%>/blog/updatemsstatus',
			type:'post',
			dataType:'json',
			data:{
				status:sn,
				ids:JSON.stringify(v)
			},
			success:function(data){
				console.log(data);
				if(data > 0){
					layer.msg(f+"成功",{icon:1});
					loadRight('<%=path%>/blog/messboards', {});
				}else{
					layer.alert(f+"失败",{icon:2});
				}
			},
			error:function(){
				
			}
		});
	},function(index){
		//取消
	});
	
	
}
$(document).ready(function(){
	var pageNum = ${mbs.pageNum};
	var pages = ${mbs.pages};
	var pi={"pageNum":pageNum,"pages":pages};
	paging("page-group", "pageInfoList", pi);
	
	$("input[name=check_all]").click(function(){
		$("input[name=check_name]").ischeck("check_all");
	});
	
	$("input[name=check_name]").change(function(){
		$("input[name=check_name]").smallchange("check_all");
	});
});
</script>
</body>
</html>