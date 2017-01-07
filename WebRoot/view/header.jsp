<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
%> 
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="<%=path %>/static/css/base.css" rel="stylesheet">
<link href="<%=path %>/static/css/index.css" rel="stylesheet">

<link href="<%=path %>/static/css/main.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="<%=path %>/static/js/modernizr.js"></script>
<![endif]-->
</head>
<body>
<figure><p><a class="emails" target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&amp;email=HHh9cn95b3F1cHVye1xtbTJ-c3E" title="有话对我说"></a>
<a class="rssdy" target="_blank" href="/e/web/?type=rss2"  title="rss订阅"></a></p></figure>
<header>
 <img src="<%=path %>/static/images/logo.jpg" alt="杨青个人网站-杨青博客"> 
  <h1><a href="/">杨青个人博客网站</a></h1>
  <p>个人原创博客，提供本站博客div+css源码分享，喜欢的朋友可以直接下载。如果需要整站asp代码，请到留言版留下你的邮箱.......</p>
</header>
<div id="nav">
     <ul>
       <li><a href="<%=path %>/index.jsp">网站首页</a></li>
       <li><a href="<%=path %>/view/about.jsp">关于我</a></li>
       <li><a href="moodlist.html">碎言碎语</a></li>
       <li><a href="newlist.html">技术探讨</a></li>
       <li><a href="newlist.html">慢生活</a></li>
       <li><a href="ablumlist.html">我的相册</a></li>
       <li><a href="book.html">留言版</a></li>
     </ul>
</div>
<div class="blank"></div>



</body>
</html>