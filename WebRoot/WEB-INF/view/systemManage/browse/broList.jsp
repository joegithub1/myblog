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
<title>文章列表</title>
<style type="text/css">
.showback{
	 
}
.showback h2 a{width:100%;height:100%;}
.showback h2{
	margin-top: 0px;
	font-size: 22px;
	line-height: 26px;
	font-weight: 600px;
	font-family: Microsoft YaHei', Verdana, Arial;
	
}
.showback h6{
	margin: 0px;
	font-size: 12px;
	font-weight: normal;
	color: #999;
	line-height: 30px;
	height: 30px;
	
}
.intro p{
	padding: 10px 0px;
	text-align: justify;
	font-size: 14px;
	line-height: 22px;
	margin-top: 5px;
}
.showback h2 a{color:#333;text-decoration:none;}
.showback h2 a:hover{color:red;text-decoration:underline;}
</style>
</head>
<body>
<div class="row mt">
 <div class="col-lg-8 col-md-12 col-sm-12">
   <input id="typeId" value="${typeId}" type="hidden">
   <c:forEach items="${list.list}" var="a">
   	 <div class="showback">
   	   <h2><i class="fa fa-angle-right"></i> <a href="javascript:void(0);" onclick="detail(${a.id});">${a.title }</a></h2>
   	   <h6>${a.crate_date}&nbsp;|&nbsp;评论：${a.commCount}人&nbsp;|&nbsp;浏览：${a.read_num }人</h6>
   	 </div>
   </c:forEach>
   <%-- <c:forEach begin="0" end="0">
     <div class="showback">
      <h2><i class="fa fa-angle-right"></i> <a href="#">虽然国家网信部门对直播平</a></h2>
      <h6>2017年11月11日&nbsp;|&nbsp;评论：1人&nbsp;|&nbsp;浏览：1人</h6>
      <div class="intro">
       <a href="javascript:void(0);" style="color: #333;">
       	<p>一种技术从工具属性、从应用层面到社会生活，往往需要经历很长的过程。珍妮纺纱机从一项新技术到改变纺织行业，再到后来被定义为工业革命的肇始，影响东、西方经济格局，其跨度至少需要几十年。互联网也同样。
       	一种技术从工具属性、从应用层面到社会生活，往往需要经历很长的过程。珍妮纺纱机从一项新技术到改变纺织行业，再到后来被定义为工业革命的肇始，影响东、西方经济格局，其跨度至少需要几十年。互联网也同样。
       	</p>
       </a>
      </div>
   </div>
   </c:forEach> --%>
   
   <div class="showback">
		<div id="page-group" class="btn-group">
		 
		</div>      					
   </div>
 </div>
</div>
<script type="text/javascript">
function pageInfo(pageNum){
	var t=new Date().valueOf();
	var typeId = $("#typeId").val();
	loadRight("<%=path%>/blog/article/list/"+typeId, {_time:t});
}
function detail(id){
	var t=new Date().valueOf();
	loadRight("<%=path%>/blog/article/detail", {id:id,_time:t});
}
$(document).ready(function(){
	var pi={"pageNum":${list.pageNum},"pages":${list.pages}};
	paging("page-group", "pageInfo", pi);
	
	
});
</script>
</body>
</html>