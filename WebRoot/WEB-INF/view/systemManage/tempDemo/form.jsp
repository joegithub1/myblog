<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo</title>
<style type="text/css">
.showback{
	 
}
.showback h2 a{width:100%;height:100%;}
.showback h2{
	font-size: 22px;
	line-height: 26px;
	font-weight: 600px;
	font-family: Microsoft YaHei', Verdana, Arial;
}
.showback h6{
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
   <div class="showback">
      <h2><i class="fa fa-angle-right"></i> <a href="#">虽然国家网信部门对直播平</a></h2>
      <h6>2017年11月11日&nbsp;|&nbsp;评论：1人&nbsp;|&nbsp;浏览：1人</h6>
      <!-- <div class="intro">
       <a href="javascript:void(0);" style="color: #333;">
       	<p>一种技术从工具属性、从应用层面到社会生活，往往需要经历很长的过程。珍妮纺纱机从一项新技术到改变纺织行业，再到后来被定义为工业革命的肇始，影响东、西方经济格局，其跨度至少需要几十年。互联网也同样。
       	一种技术从工具属性、从应用层面到社会生活，往往需要经历很长的过程。珍妮纺纱机从一项新技术到改变纺织行业，再到后来被定义为工业革命的肇始，影响东、西方经济格局，其跨度至少需要几十年。互联网也同样。
       	</p>
       </a>
      </div> -->
   </div>
   
   <div class="showback">
      <h2><i class="fa fa-angle-right"></i> <a href="#">虽然国家网信部门对直播平</a></h2>
      <h6>2017年11月11日&nbsp;|&nbsp;评论：1人&nbsp;|&nbsp;浏览：1人</h6>
      <!-- <div class="intro">
       <a href="#" style="color: #333;">
       	<p>一种技术从工具属性、从应用层面到社会生活，往往需要经历很长的过程。珍妮纺纱机从一项新技术到改变纺织行业，再到后来被定义为工业革命的肇始，影响东、西方经济格局，其跨度至少需要几十年。互联网也同样。</p>
       </a>
      </div> -->
   </div>
   
 </div>
</div>


<!-- <h1>Hello Word</h1>

<form id="myform" method="get"> 

<table width="50%" border="0"> 
    <tr> 
        <td> 
    姓名：  </td> 
        <td> 
            <input type="text" name="username" /></td> 
        </tr> 
    <tr> 
    <td> 
      书籍：    </td> 
    <td> 
      <input type="checkbox" name="book" value="01"/> 
            jquery 
      <input type="checkbox" name="book" value="02"/> 
         java 
      <input type="checkbox" name="book" value="03"/> 
         oracle    </td> 
        </tr> 
    <tr> 
          <td> 
      性别：    </td> 
    <td> 
      <label> 
      <input type="radio" name="sex" value="boy" /> 
         男</label> 
      <label> 
      <input type="radio" name="sex" value="girl" /> 
         女</label>    </td> 
    </tr> 
    <tr> 
        <td> 
    颜色：  </td> 
        <td>    <label for="select"></label> 
         <select name="color" id="select"> 
        <option>请选择</option> 
        <option value="red">红</option> 
        <option value="green">绿</option> 
        <option value="blue">蓝</option> 
         </select>            </td> 
    </tr> 
    <tr> 
         <td> 
    备注：  </td> 
        <td> 
    <label for="textarea"></label> 
            <textarea name="addition" ></textarea>  </td> 
    </tr> 
    <tr> 
        <td colspan="2"> 
            <input type="button" name="padding" value="填充"/> 
    </td> 
        </tr> 
</table> 


</form> --> 



<script type="text/javascript"> 
    $(document).ready(function(){ 
        // 初始化一个对象 该对象的属性要和form 对应的值对应 
        var obj = new Object(); 
        obj.username ="randy"; 
        obj.book="01"; 
        obj.sex="girl"; 
        obj.color="red"; 
        obj.addition="哥写的不是代码，是寂寞"; 
         
        $(":button").click(function(){ 
             
             for(var attr in obj){ 
            
              if(typeof(obj[attr])=='function'){                     
                continue; 
              } 
              var $input = $("#myform    :input[name='"+attr+"']"); 
              var type = $input.attr("type");                
              if(type=="checkbox" ||type=="radio"){ 
                    
                  var avalues = obj[attr].split(","); 
                    
                  for(var v=0; v<avalues.length;v++){ 
                    $input.each(function(i,n){ 
                        var value = $(n).val();                         
                        if(value == avalues[v]){                        
                          $(n).attr("checked","checked"); 
                        } 
                    }); 
                } 
              }else{ 
                $input.val(obj[attr]); 
              } 
                
            }            
             
             
             
             
        /*    var $input = $("#myform    :input"); 
              $.each($input,function(i,n){ 
                var type = $(n).attr("type");                
                alert(type); 
              }); 
        */ 

        }); 
    }); 

</script> 
<script type="text/javascript">



</script>
</body>
</html>