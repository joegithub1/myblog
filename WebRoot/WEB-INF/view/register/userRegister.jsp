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
<title>个人注册</title>
<!-- Bootstrap core CSS -->
<link href="<%=path %>/static/assets/css/bootstrap.css" rel="stylesheet">
<link href="<%=path %>/static/bootstrap-3.3.7/css/bootstrapValidator.css" rel="stylesheet">
<!--external css-->
<link href="<%=path %>/static/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="<%=path %>/static/assets/css/style.css" rel="stylesheet">
<link href="<%=path %>/static/assets/css/style-responsive.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<style type="text/css">
.login-wrap .txt-impt{
	margin: 4px 4px;
}
.login-wrap .txt-impt{
	color: #C00;
}

/*LOGIN CONFIGURATION PAGE*/
.form-login {
	max-width: 330px;
	margin: 20px auto 0;
	background: #fff;
	border-radius: 5px;
	-webkit-border-radius: 5px;
}
</style>
</head>
<body>
<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

<div id="login-page">
  	<div class="container">
	      <form id="form" class="form-login form-horizontal" action="" method="post" onsubmit="return false;">
	        <h2 class="form-login-heading">欢迎注册&nbsp;|&nbsp;
	        <span style="font-size: 14px;">已有账号</span>
	        <span><a style="color:#000000;" href="<%=path%>/blog/login">请登录?</a></span></h2>
	        <div class="login-wrap">
				<div class="form-group">
				    <label for="backuserName"><span class="txt-impt">*</span>用户名</label>
				    <input name="backuserName" type="text" class="form-control" placeholder="请输入用户名" autofocus="autofocus">
				</div>
				<div class="form-group">
				    <label for="backuserMobliePhone"><span class="txt-impt">*</span>手机号码</label>
				    <input name="backuserMobliePhone" type="text" class="form-control" placeholder="请输入手机号码">
				</div>
				<div class="form-group">
				    <label for="backuserPwd"><span class="txt-impt">*</span>密码</label>
				    <input name="backuserPwd" type="password" class="form-control" placeholder="请输入密码">
				</div>
				<div class="form-group">
				    <label for="rePassword"><span class="txt-impt">*</span>确认密码</label>
				    <input name="rePassword" type="password" class="form-control" placeholder="请输入确认密码">
				</div>
				<div class="form-group">
				    <label for="userEmail"><span class="txt-impt">*</span>邮件地址 &nbsp;&nbsp;&nbsp;
				    <span style="color: #C2C2C2;">忘记密码时，通过邮箱找回密码</span>
				    </label>
				    <input name="userEmail" type="text" class="form-control" placeholder="请输入邮件地址 ">
				</div>
				<!-- <div class="form-group">
				    <label for=""></label>
				    <input name="" type="text" class="form-control" placeholder="请输入">
				</div> -->
				<div class="form-group">
				    <button type="button" onclick="save();" class="btn btn-danger btn-lg btn-block">立即注册</button>
				</div>
	        </div>
	      </form>	  	
  	</div>
</div>
<%-- <script src="<%=path %>/static/assets/js/jquery-1.8.3.min.js" type="text/javascript"></script>
 --%>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=path %>/static/bootstrap-3.3.7/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="<%=path %>/static/layer/layer.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageHelper.js"></script>
<script src="<%=path %>/static/assets/js/bootstrap.min.js" type="text/javascript"></script>
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="<%=path %>/static/assets/js/jquery.backstretch.min.js"></script>
<script type="text/javascript">
$.backstretch("<%=path %>/static/assets/img/login-bg.jpg", {speed: 500});
$(document).ready(function(){
	$("#form").bootstrapValidator({
		fields:{
			backuserName: {  
                validators: {  
                    notEmpty: {  
                        message: '用户名不能为空'  
                    },
                    regexp:{
                    	regexp:/^[0-9a-zA-Z]{4,16}$/,
                    	message:'用户名长度4到16位之间字母或数字'
                    },
                    callback:{
                    	message:'此用户名已注册',
                    	callback:function(value){
                    		var res = false;
                    		$.ajax({
                    			url:'<%=path%>/problog/isexistun',
                    			type:'post',
                    			dataType:'json',
                    			data:{
                    				userName:value
                    			},
                    			async:false,
                    			cache:false,
                    			success:function(data){
                    				if(data > 0){
                    					res = false;
                    				}else{
                    					res = true;
                    				}
                    			},
                    			error:function(){
                    				
                    			}
                    		});
                    		
                    		return res;
                    	}
                    }
                }
            },
            backuserMobliePhone:{
            	validators:{
            		notEmpty: {
                        message: '手机号不能为空'  
                    },
                    regexp:{
                    	regexp:/^1[34578]\d{9}$/,
                    	message : '请输入13,14,15,17,18开头的手机号码'
                    },
                    callback:{
                    	message:'手机号码已经注册',
                    	callback:function(value){
                    		var res = false;
                    		$.ajax({
                    			url:'<%=path%>/problog/isexismp',
                    			type:'post',
                    			dataType:'json',
                    			data:{
                    				mobilePhone:value
                    			},
                    			async:false,
                    			cache:false,
                    			success:function(data){
                    				if(data > 0){
                    					res = false;
                    				}else{
                    					res = true;
                    				}
                    			},
                    			error:function(){
                    				
                    			}
                    		});
                    		return res;
                    	}
                    }
            	}
            },
            backuserPwd:{
            	validators:{
            		notEmpty: {  
                        message: '密码不能为空'  
                    },
                    regexp:{
                    	regexp:/^[0-9a-zA-Z]{4,16}$/,
                    	message:'密码长度4到16位之间'
                    }/* ,
                    identical:{
                    	field:'rePassword',
                    	message:'两次密码不一致'
                    } */
            	}
            },
            rePassword:{
            	validators:{
            		notEmpty: {  
                        message: '确认密码不能为空'  
                    },
                    regexp:{
                    	regexp:/^[0-9a-zA-Z]{4,16}$/,
                    	message:'密码长度4到16位之间'
                    },
                    identical:{
                    	field:'backuserPwd',
                    	message:'两次密码不一致'
                    }
            	}
            },
            userEmail:{
            	validators:{
            		notEmpty: {  
                        message: '邮件地址不能为空'  
                    },
                    regexp:{
                    	regexp:/^\w+@([0-9a-zA-Z]+[-0-9a-zA-Z]*)(\.[0-9a-zA-Z]+[-0-9a-zA-Z]*)+$/,
                    	message:'请正确输入邮件地址 例如my@126.com'
                    }
            	}
            }
            
		}
	});
});
function save(){
	$('#form').data('bootstrapValidator').validate();  
    if(!$('#form').data('bootstrapValidator').isValid()){ 
        return ;  
    }
    var data = new FormData($("#form")[0]);
    $.ajax({
    	url:'<%=path%>/problog/register',
    	type:'post',
    	dataType:'json',
    	data:data,
    	async:false,
    	cache:false,
    	contentType:false,
    	processData:false,
    	success:function(data){
    		if(data > 0){
    			layer.confirm('注册成功，立即去登录?',{btn:['确定']},
    					function(index){
    				var t=new Date().valueOf();
    				window.location.href="<%=path%>/blog/login?_time="+t;
    				layer.close(index);
    				
    			});
    		}else{
    			layer.msg("注册失败",{icon:2});
    		}
    	},
    	error:function(){
    		layer.msg("系统异常",{icon:2});
    	}
    });
    
    
};
</script>
</body>
</html>