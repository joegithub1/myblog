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
<title>添加文章</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=path %>/static/froala_editor_2.6.0/css/froala_editor.css">
  <link rel="stylesheet" href="<%=path %>/static/froala_editor_2.6.0/css/froala_style.css">
  <link rel="stylesheet" href="<%=path %>/static/froala_editor_2.6.0/css/plugins/code_view.css">
  <link rel="stylesheet" href="<%=path %>/static/froala_editor_2.6.0/css/plugins/image_manager.css">
  <link rel="stylesheet" href="<%=path %>/static/froala_editor_2.6.0/css/plugins/image.css">
  <link rel="stylesheet" href="<%=path %>/static/froala_editor_2.6.0/css/plugins/table.css">
  <link rel="stylesheet" href="<%=path %>/static/froala_editor_2.6.0/css/plugins/video.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
</head>
<body>
<div class="site-min-height">
  <h3><i class="fa fa-angle-right"></i>文章管理</h3>
  <div class="row mt">
    <div class="col-lg-12">
		  <form id="form" class="form-horizontal" role="form" onsubmit="return false;">
			  <input type="hidden" id="id" name="id" value="${article.id }">
			  <div class="form-group">
			    <label for="" class="col-sm-1 control-label">文章类型</label>
			    <div class="col-sm-5">
			       <select name="articleType" class="form-control">
				      <c:forEach items="${dics}" var="d">
				      
				        <option  <c:if test="${article.articleType == d.dValue}">selected="selected"</c:if>   value="${d.dValue }">${d.dName}</option>
				      </c:forEach>
				      
				    </select>
			    </div>
			    <label class="xing">*</label>
			  </div>
			  <div class="form-group">
			    <label for="title" class="col-sm-1 control-label">标题</label>
			    <div class="col-sm-5">
			      <input type="text" name="title" value="${article.title }" class="form-control" placeholder="请输入标题 ">
			    </div>
			    <label class="xing">*</label>
			  </div>
			  <div class="form-group">
			    <label for="smaillTitle" class="col-sm-1 control-label">摘要</label>
			    <div class="col-sm-5">
			      <textarea class="form-control" rows="5" name="smaillTitle" placeholder="请输入摘要 ">${article.smaillTitle }</textarea>
			    </div>
			    
			  </div>
			  <div class="form-group">
			    <label for="content" class="col-sm-1 control-label">正文</label>
			    <div class="col-sm-10">
			      <!-- 此处正文 -->
			      <textarea id="froala-editor" class="form-control" rows="5"  name="content" placeholder="请输入标正文">${article.content }</textarea>
			    </div>
			    <label class="xing">*</label>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="button" class="btn btn-primary" onclick="com();">确定</button>
			    </div>
			  </div>
		</form>
    </div>
  </div>
</div>
  <script type="text/javascript" src="<%=path %>/static/js/jquery-1.9.1.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/froala_editor.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/align.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/code_beautifier.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/code_view.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/draggable.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/image.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/image_manager.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/link.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/lists.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/paragraph_format.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/paragraph_style.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/table.min.js"></script>
  <%-- <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/video.min.js"></script> --%>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/url.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/plugins/entities.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/froala_editor_2.6.0/js/languages/zh_cn.js"></script>
<script type="text/javascript">
	function com(){
		var data = new FormData($("#form")[0]);
		$.ajax({
			url:'<%=path%>/blog/articleadmin/saveorupdate',
			type:'post',
			dataType:'json',
			data:data,
			async:false,
			contentType:false,
			processData:false,
			success:function(data){
				if(data.result > 0){
					layer.msg(data.message,{icon:1});
					loadRight("<%=path%>/blog/articleadmin/list", {});
				}else{
					layer.msg(data.message,{icon:2});
				}
				
			},
			error:function(){
				
			}
		});
	}
	/*imageEditButtons 'imageDisplay', 'imageAlign', 'imageInfo',imageRemove  */
	$(document).ready(function(){
		$("#froala-editor").froalaEditor({
			"imageUploadURL":"<%=path%>/blog/editoruploadimg",
			imageAllowedTypes: ["jpeg", "jpg", "png", "gif"],
			height:300,
			language: "zh_cn"
		}).on('froalaEditor.image.removed',function(e, editor, $img){
			 var src= $img.attr('src');
	         var t=new Date().valueOf();
	         console.log(src);
	         $.ajax({
	        	 url:'<%=path%>/blog/editordelimg',
	        	 type:'post',
	        	 dataType:'json',
	        	 async:false,
	        	 data:{
	        		 url:src,
	        		 _time:t
	        	 },
	        	 success:function(res){
	        		 console.log(res);
	        	 },
	        	 error:function(){
	        		 
	        	 }
	         });
		});
	});
</script>
</body>
</html>