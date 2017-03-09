<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String pro=request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<!-- about.jsp and book.jsp复用 -->
<aside class="navsidebar">  
    <img class="about_p" src="<%=pro %>/static/images/aboutphoto.jpg"> 
    <div class="geyan"><p>每个作品都有自己的灵魂，只要灵魂发挥极致，那么成功就在眼前！</p></div>
    <div class="about_c">网名：DanceSmile | 即步非烟<br>
      生日：1987-10-30<br>
      籍贯：四川省&mdash;成都市<br>
      现居：天津市&mdash;滨海新区<br>
      职业：网站设计、网站制作<br>
      喜欢的书：《红与黑》《红楼梦》<br>
      喜欢的音乐：《burning》《just one last dance》《相思引》<br>
      作品展示：部分作品<br>
      联系方式：Q Q、Email、MSN</div>    
</aside>
</body>
</html>