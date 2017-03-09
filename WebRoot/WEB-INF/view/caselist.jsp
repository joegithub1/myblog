<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的相册</title>
<style>
.caselist{width:700px; float:left; overflow:hidden}
.caselist h2{ border-bottom:#AC0B0B 3px solid; line-height:40px; font-size:12px; font-weight:normal}
.caselist h2 a{ color:#666}
.caselist ul { padding:20px; list-style:none }
.caselist ul img{ width:300px; height:240px}
.caselist ul li img{  width:310px; height:230px;border:#323232 5px solid; display:inline;float:left; margin-bottom:5px;}
.caselist ul li{ width:320px; float:left; margin:0 10px 15px 0; position:relative;text-align:center; font-size:14px; line-height:40px;}
.caselist ul li a{ display:block;}
.caselist ul li a:hover{ color:#F00; opacity:0.7}
</style>
</head>
<body>
<article>
<div class="caselist">
  <h2>您当前的位置：<a href="/" target="_blank">首页</a> > <a href="/" target="_blank">我的相册</a></h2>
     <ul>
        <li><a href="/"><img src="<%=path %>/static/images/201303152210276757.jpg">邻水县检察院</a></li>
        <li><a href="/"><img src="<%=path %>/static/images/201303152210276757.jpg">邻水县检察院</a></li>
        <li><a href="/"><img src="<%=path %>/static/images/201303152210276757.jpg">邻水县检察院</a></li>
   </ul>
   <div class="blank"></div>
   
   <ul class="page"><a href="#"><b>72</b></a><a href="#">首页</a><a href="#">上一页</a><a href="#">1</a><b>2</b><a href="#">3</a><a href="#">下一页</a><a href="#">尾页</a></ul>
   
</div>
<div class="boxr"> 
   <script>
  (function() {
    var cx = '014611787770111005237:y0o6ob8futa';
    var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
    gcse.async = true;
    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
        '//www.google.com/cse/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(gcse, s);
  })();
</script>
<gcse:search></gcse:search>
   <nav>
      <ul>
       <li class="ab"><a href="#" >关于我</a></li>
       <li class="sy"><a href="#">碎言碎语</a></li>
       <li class="js"><a href="#">技术探讨</a></li>
       <li class="msh"><a href="#">慢生活</a></li>
       <li class="xc"><a href="#">我的相册</a></li>
       <li class="ly"><a href="#">留言版</a></li>
     </ul>      
    </nav>
    <div class="blank"></div>
   <div class="newbolg">
       <h2>点击排行</h2>
       <ul>         
        <li><a title="不要在上司肩上哭泣" href="/content/?373.html"  target="_blank">[欣赏]不要在上司肩上哭泣</a></li>  
        <li><a title="房前种菜，屋后栽花" href="/content/?372.html"  target="_blank">[欣赏]房前种菜，屋后栽花</a></li>  
        <li><a title="为了躲避失望，我们习惯隐身" href="/content/?306.html"  target="_blank">[欣赏]为了躲避失望，我们习惯隐身</a></li>  
        <li><a title="三月游石象湖赏郁金香小记" href="/content/?256.html"  target="_blank">[游记]三月游石象湖赏郁金香小记</a></li>  
        <li><a title="all in dance , all in smile" href="/content/?255.html"  target="_blank">[情感]all in dance , all in smile</a></li>  
        <li><a title="工作是为了生计，但不要为薪水而工作" href="/content/?430.html"  target="_blank">[欣赏]工作是为了生计，但不要为薪水而工作</a></li> 
        <li><a title="all in dance , all in smile" href="/content/?255.html"  target="_blank">[情感]all in dance , all in smile</a></li>  
        <li><a title="工作是为了生计，但不要为薪水而工作" href="/content/?430.html"  target="_blank">[欣赏]工作是为了生计，但不要为薪水而工作</a></li>   
       </ul>   
    </div>
<script type="text/javascript">
var cpro_id = "u1299033";
</script>
<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>    
</div>
</article>
<div class="blank"></div>

<%@ include file="footer.jsp" %>

<script src="js/silder.js"></script>
</body>
</html>