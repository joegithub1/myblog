<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情</title>
<style type="text/css">
.clear{
    clear: both;
    padding-top: 4px;
    padding-bottom: 4px;
}
.post-title {
    border-bottom-width: 1px;
    border-bottom-style: solid;
    border-bottom-color: #CCC;
    padding-bottom: 10px;
    border-top-width: 1px;
    border-top-style: solid;
    border-top-color: #CCC;
}
.post-content .content {
    margin: 5px 3px 5px 0px;
    font-size: 18px;
    line-height: 32px;
    margin-bottom: 20px;
}
.post-content .content p {
    padding: 10px 0 20px;
    line-height: 190%;
    text-indent: 2em;
    text-align: justify;
    color: #2A2A2A;
}
p {
    display: block;
    -webkit-margin-before: 1em;
    -webkit-margin-after: 1em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
}
.post-content h1 {
    line-height: 60px;
    padding-bottom: 4px;
    font-family: "Microsoft Yahei";
    font-size: 32px;
}
a {
    color: #333;
    text-decoration: none;
}
.post-title h1 a:hover{color:red;text-decoration:underline;}

.panel a{
	color:red;text-decoration:underline;
}
</style>
</head>
<body>
<div class="row mt">
 <div class="col-lg-8 col-md-12 col-sm-12">
 	<dl class="post-content">
 	  <div class="post-title">
 	  	<h1><a href="javascript:void(0);" onclick="reLoad();">${article.title }</a></h1>
 	  	<h6>${article.readNum}人参与&nbsp;|&nbsp;时间：${article.crateDate }</h6>
 	  </div>
 	  <div class="clear"></div>
 	  <dd class="content">
 	   <p>${article.content}</p>
 	  </dd>
 	</dl>
 	<div class="showback">
 		<div class="row">
 			<div class="col-sm-12">
 			    <div class="panel panel-primary">
					<div class="panel-heading">
						评论专区
					</div>
					<div class="panel-body">
		 			    <form id="form" class="form-horizontal" role="form">
		 			      <input type="hidden" id="articleId" name="articleId" value="${article.id}">
		 			      <div class="form-group">
		         			<label for="plUser" class="col-sm-2 control-label">名&nbsp;称</label>
			     			<div class="col-sm-6">
			                    <input type="text" class="form-control" id="plUser" name="plUser" placeholder="请输入名称">
			    			</div>
			    			<label class="col-sm-2 control-label" style="color:red;">必填</label>
			  			  </div>
		 			      <div class="form-group">
		         			<label for="userUrl" class="col-sm-2 control-label">网&nbsp;址</label>
			     			<div class="col-sm-6">
			                    <input type="text" class="form-control" id="userUrl" name="userUrl" placeholder="请输入网址">
			    			</div>
			    			<label class="col-sm-2 control-label">选填</label>
			  			  </div>			  			  
							<div class="form-group">
							    <textarea id="plContent" name="plContent" class="form-control" rows="6"></textarea>
							</div>
							<div class="form-group" style="text-align: right;">
								<button id="fat-btn" class="btn btn-danger"
								    type="button" onclick="submitComm();">提交评论
								</button>								
							</div>  			   
		  			    </form>
					</div>
				</div>
 			</div>
 		</div>
 	 
  	    <div class="row" id="comment-content">
  	    	<c:forEach items="${comms }" var="c">
  	    		<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="javascript:void(0);"><font>${c.pl_user }</font></a>&nbsp;${c.create_date}
					</div>
					<div class="panel-body">
						${c.pl_content}
					</div>
				</div> 	    	
  	    	  </div>
  	    	</c:forEach>
  	    </div>
    </div>
 </div>
 
</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/bootstrap-3.3.7/js/bootstrapValidator.js"></script>
<script type="text/x-javascript-tmpl" id="commTmpl">
  	    		<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="javascript:void(0);"><font>{{= pl_user }}</font></a>&nbsp;{{= create_date}}
					</div>
					<div class="panel-body">
						{{= pl_content}}
					</div>
				</div> 	    	
  	    	  </div>
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#form").bootstrapValidator({
		fields:{
			plUser:{
				validators:{
					notEmpty:{
						message:'名称必填'
					}
				}
			},
			plContent:{
				validators:{
					notEmpty:{
						message:'评论内容必填'
					}
				}
			}
			
		}
	});
});
function reLoad(){
	var id = $("#articleId").val();
	loadRight("<%=path%>/blog/article/detail", {id:id});
}	
	function submitComm(){
		/* var plUser = $("#plUser").val();
		var plContent = $("#plContent").val();
		var articleId = $("#articleId").val();
		if(plUser == "" || plUser.length <= 0){
			layer.msg("名称必填",{icon:2});
			return false;
		}else if(plContent == "" || plContent.length <= 0){
			layer.msg("评论内容必填",{icon:2});
			return false;
		} */
		$('#form').data('bootstrapValidator').validate();  
	    if(!$('#form').data('bootstrapValidator').isValid()){ 
	        return ;  
	    }
		var data=new FormData($("#form")[0]);
		$.ajax({
			url:'<%=path%>/blog/comment/save',
			type:'post',
			dataType:'json',
			data:data,
			async:false,
			cache:false,
			contentType:false,
			processData:false,
			success:function(data){
				if(data.result > 0){
					layer.msg("评论成功",{icon:1});
					$("#comment-content").html($("#commTmpl").tmpl(data.comment));
					$("#plContent").val("");
				}else{
					layer.msg("评论失败",{icon:2});
				}
			},
			error:function(){
				
			}
		});
		
	}
</script>
</body>
</html>