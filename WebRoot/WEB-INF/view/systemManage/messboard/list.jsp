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
<title>留言板列表</title>
</head>
<body>
<div class="row mt">
 <div class="col-lg-8 col-md-12 col-sm-12">
   <div class="showback">
    <div class="row" id="messboard-content">
    	<c:forEach items="${mbs.list}" var="c">
    		<div class="col-sm-12">
    		 <div class="panel panel-default">
				<div class="panel-heading">
					<a href="javascript:void(0);"><font>${c.messageUser }</font></a>&nbsp;${c.messageDate}
				</div>
				<div class="panel-body">
						${c.messageContent}
				</div>
    		 </div>
    		</div>
    	</c:forEach>
	   <div class="showback">
			<div id="page-group" class="btn-group">
			 
			</div>      					
	   </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
       <div class="panel panel-primary">
         <div class="panel-heading">
			留言专区
		</div>
		<div class="panel-body">
		 <form id="form" class="form-horizontal" role="form">
		      <div class="form-group">
       			<label for="plUser" class="col-sm-2 control-label">名&nbsp;称</label>
    			<div class="col-sm-6">
                   <input type="text" class="form-control" id="messageUser" name="messageUser" placeholder="请输入名称">
   				</div>
   				<label class="col-sm-2 control-label" style="color:red;">必填</label>
 			  </div>
 			  <div class="form-group">
				<textarea id="messageContent" name="messageContent" class="form-control" rows="6"></textarea>
			  </div>
			<div class="form-group" style="text-align: right;">
				<button id="fat-btn" class="btn btn-danger"
				    type="button" onclick="submitComm();">提交留言
				</button>								
			</div>
		 </form>
		</div>
       </div>
      </div>
    </div>
    
    
   </div>
 </div>
</div>
</body>
<script src="<%=path %>/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/bootstrap-3.3.7/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/x-javascript-tmpl" id="lyTmpl">
    		<div class="col-sm-12">
    		 <div class="panel panel-default">
				<div class="panel-heading">
					<a href="javascript:void(0);"><font>{{= messageUser}}</font></a>&nbsp;{{= messageDate}}
				</div>
				<div class="panel-body">
						{{= messageContent}}
				</div>
    		 </div>
    		</div>
</script>
<script type="text/javascript">
function pageInfoList(pageNum){
	
	loadRight('<%=path%>/blog/messboardlist', {"pageNum":pageNum});
}
$(document).ready(function(){
	var pageNum=${mbs.pageNum};
	var pages = ${mbs.pages};
	var pi={"pageNum":pageNum,"pages":pages};
	paging("page-group", "pageInfoList", pi);
});
function submitComm(){
	var data = new FormData($("#form")[0]);
	$.ajax({
		url:'<%=path%>/blog/messboardsave',
		dataType:'json',
		type:'post',
		data:data,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success:function(data){
			console.log(data);
			if(data.result > 0){
				$("#messageContent").val("");
				layer.alert("留言成功",{icon:1});
				$("#messboard-content").html($("#lyTmpl").tmpl(data.lys.list));
				paging("page-group", "pageInfoList", data.lys);
			}
		},
		error:function(){
			
		}
	});
}
</script>
</html>