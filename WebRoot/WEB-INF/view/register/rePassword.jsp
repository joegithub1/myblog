<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>重置密码</title>
<link href="<%=path %>/static/assets/css/bootstrap.css" rel="stylesheet">
<link href="<%=path %>/static/bootstrap-3.3.7/css/bootstrapValidator.css" rel="stylesheet">
<link href="<%=path %>/static/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="<%=path %>/static/assets/css/style.css" rel="stylesheet">
<link href="<%=path %>/static/assets/css/style-responsive.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
<div id="login-page">
 <div class="container">
  <form id="reForm" name="reForm" class="form-login" action="" method="post">
    <h2 class="form-login-heading">密码重置</h2>
    <div class="login-wrap">
		<div class="form-group">
		    <input name="pwd" id="pwd" type="password" class="form-control" placeholder="请输入新密码" autofocus="autofocus">
		</div>
		<div class="form-group">
		    <div class="input-group">
		        <input id="rePassword" name="rePassword" type="password" class="form-control" placeholder="确认密码">
		        <span class="input-group-btn">
		            <button class="btn btn-default" type="button" onclick="sUpdate();">修改密码</button>
		        </span>
		    </div>
		</div> 
    </div>
  </form>
 </div>
</div>
<script src="<%=path %>/static/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="<%=path %>/static/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path %>/static/bootstrap-3.3.7/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="<%=path %>/static/layer/layer.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageHelper.js"></script>
<script type="text/javascript" src="<%=path %>/static/assets/js/jquery.backstretch.min.js"></script>

<script type="text/javascript">
$.backstretch("<%=path %>/static/assets/img/login-bg.jpg", {speed: 500});
$(document).ready(function(){
	$("#reForm").bootstrapValidator({
		fields:{
			pwd:{
				validators:{
					notEmpty: {  
                        message: '密码不能为空'  
                    },
                    regexp:{
                    	regexp:/^[0-9a-zA-Z]{4,16}$/,
                    	message:'密码长度太短，请输入4到16位密码'
                    }
				}
			},
			rePassword:{
				validators:{
					notEmpty: {  
                        message: '确认密码不能为空'  
                    },
                    regexp:{
                    	regexp:/^[0-9a-zA-Z]{4,16}$/,
                    	message:'密码长度太短，请输入4到16位密码'
                    },
                    identical:{
                    	field:'pwd',
                    	message:'两次输入的密码不一致'
                    }
				}
			}
		}
	});
});	
function sUpdate(){

	$('#reForm').data('bootstrapValidator').validate();  
    if(!$('#reForm').data('bootstrapValidator').isValid()){ 
        return ;  
    }
   var key = "${key}";
   var newpd = $("#pwd").val();
   var t=new Date().valueOf();
   if(newpd == $("#rePassword").val()){
	   $.ajax({
		   url:'<%=path%>/problog/comrepassword',
		   type:'post',
		   dataType:'json',
		   async:false,
		   cache:false,
		   data:{
			   key:key,
			   npwd:newpd,
			   _time:t
		   },
		   success:function(data){
			   console.log(data);
			   if(data > 0){
				   layer.confirm('修改密码成功,立即登录', {btn:['确定']},function(){
					   window.location.href="<%=path%>/blog/login";
				   });
				    
				  
			   }else{
				   layer.confirm('修改密码失败,尝试重新获取重置密码邮件', {btn:['确定']},function(){
					   window.location.href= window.location
				   });
			   }
			   
		   },
		   error:function(){
			   
		   }
	   });
   }else{
	   
   }
    
}
</script>
</body>
</html>