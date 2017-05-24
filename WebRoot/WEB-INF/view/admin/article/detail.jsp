<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>文章详情</title>
</head>
<body>
<div class="site-min-height">
 <h3><i class="fa fa-angle-right"></i>文章详情</h3>
 <div class="row mt">
   <div class="col-lg-12">
   		<div class="content-panel">
   		   <section id="unseen">
   		     <input type="hidden" value="${article.id}" id="articleId" name="">
   		     <table class="table table-bordered table-striped table-condensed">
   		     	<col width="1%">
   		     	<col width="5%">
   		     	<tr>
   		     		<td>标题</td>
   		     		<td>${article.title }</td>
   		     	</tr>
   		     	<tr>
   		     		<td>摘要</td>
   		     		<td>${article.smaillTitle }</td>
   		     	</tr>
   		     	<tr>
   		     		<td>类型</td>
   		     		<td>
   		     		 ${dictionary.dName }
   		     		</td>
   		     	</tr>
   		     	<tr>
   		     		<td>内容</td>
   		     		<td>${article.content }</td>
   		     	</tr>
   		     	<tr>
   		     		<td>发表日期</td>
   		     		<td>${article.crateDate }</td>
   		     	</tr>
   		     	<tr>
   		     		<td></td>
   		     		<td></td>
   		     	</tr>
   		     </table>
   		   </section>
   		</div>
   </div>
 </div>
 <div class="row mt">
   <div class="col-lg-12">
     <div class="content-panel">
       <section id="unseen">
         <table class="table table-bordered table-striped table-condensed">
         	<col width="2%">
         	<col width="3%">
         	<col width="10%">
         	<col width="5%">
         	<col width="2%">
         	<col width="2%">
         	<thead>
         		<tr>
         		<th>ID</th>
         		<th>评论人 </th>
         		<th>评论内容 </th>
         		<th>评论日期</th>
         		<th>状态</th>
         		<th>操作</th>
         		</tr>
         	</thead>
         	<tbody>
         		<c:forEach items="${comms}" var="c">
         		 <tr>
         		 	<td>${c.id }</td>
         		 	<td>${c.pl_user }</td>
         		 	<td>${c.pl_content }</td>
         		 	<td>${c.create_date }</td>
         		 	<td>
         		 	<c:if test="${c.status == 0}">
         		 		启用
         		 	</c:if>
         		 	<c:if test="${c.status == 1}">
         		 		禁用
         		 	</c:if>
         		 	<c:if test="${c.status == 2}">
         		 		未审核
         		 	</c:if>
         		 	</td>
         		 	<td>
         		 	 <c:if test="${c.status == 0}">
         		 	 	<a href="#" onclick="setStatus(${c.id},1);">禁用</a>
         		 	 </c:if>
         		 	 <c:if test="${c.status == 1}">
         		 	 	<a href="#" onclick="setStatus(${c.id},0);">启用</a>
         		 	 </c:if>
         		 	 <c:if test="${c.status ==2}">
         		 	 	<a href="#" onclick="setStatus(${c.id},2);">审核通过</a>
         		 	 </c:if>
         		 	</td>
         		 </tr>
         		</c:forEach>
         	</tbody>
         	<tfoot></tfoot>
         </table>
       </section>
     </div>
   </div>
 </div>
</div>
<script type="text/javascript" src="<%=path %>/static/layer/layer.js"></script>
<script type="text/javascript">
function setStatus(id,status){
	layer.confirm('确定操作吗?',{btn:['确定','取消']},
			function(index){
		
		var aId = $("#articleId").val();
		var t=new Date().valueOf();
		$.ajax({
			url:'<%=path%>/blog/commadmin/updatestatus',
			dataType:'json',
			type:'post',
			data:{
				id:id,
				status:status,
				_time:t
			},
			success:function(data){
				layer.close(index);
				if(data > 0){
					layer.msg('操作成功');
					loadRight('<%=path%>/blog/articleadmin/detail', {id:aId});
				}else{
					layer.alert('操作失败',{icon:2});
				}
			},
			error:function(){
				layer.alert("异常");
			}
		});
		
		
	},function(){
		
	});
	
}
</script>
</body>
</html>