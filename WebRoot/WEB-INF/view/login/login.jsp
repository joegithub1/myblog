<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path=request.getContextPath();
%>
<!DOCTYPE html >
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>黄键博客 -登录</title>
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
.modal-body {
	position: relative;
    padding: 10px 0px 120px 0px;
}
/* body{
	background: #0BE093;
} */
</style>
</head>
<body>
<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
		      <form id="loginForm" name="loginForm" class="form-login" action="<%=path%>/blog/bloglogin" method="post">
		        <h2 class="form-login-heading">欢迎登录</h2>
		        <div class="login-wrap">
		            <div class="form-group">
		               <input id="backuserMobliePhone" type="text" name="backuserMobliePhone" class="form-control" placeholder="请输入手机号" value="" autofocus>
		            </div>
		            <div class="form-group">
		              <input id="backuserPwd" type="password" name="backuserPwd" class="form-control" placeholder="请输入密码" value="">
		            </div>
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="#myModal">忘记密码</a>
		
		                </span>
		            </label>
		            <div  style="color: #F00;margin:0;padding:0;width: auto;" id="error">${err}</div>
		            <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> 登 录</button>
		            <hr>
		            
		            <div class="login-social-link centered">
		            <p>${err }</p>
		            <!-- <p>or you can sign in via your social network</p>
		                <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
		                <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button>
		            --> </div>
		            <div class="registration">
		                Don't have an account yet?<br/>
		                <a class="" href="<%=path %>/problog/registerpage">
		                   创建一个账户
		                </a>
		            </div>
		            
		
		        </div>
		
    <!-- Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">忘记了密码 ?</h4>
                </div>
                <div class="modal-body">
                	<form id="passForm" name="passForm" class="form-horizontal" role="form">
						<div class="form-group">
						    <!-- <label class="col-sm-2 control-label">聚焦</label> -->
						    <div class="col-sm-12">
						      <div class="col-sm-10">
						       <label for="name" style="color: #ccc;">会给绑定此手机的邮件发送验证码,邮件发送有延迟请耐心等待</label>
						       <input class="form-control" id="mobilePhoneNum" type="text" value="" placeholder="该输入手机号码" autofocus="autofocus">
						      </div>
						    </div>
						</div>
						
						<!-- <div class="form-group" style="margin-top: 80px;">
						    <div class="col-sm-12">
						      <div class="col-sm-5">
						       <input class="form-control col-sm-2" id="verificationCode" type="text" value="" placeholder="请输入验证码">
						      </div>
						      <div class="col-sm-3">
						       <img id="code" title="看不清点击刷新验证码" alt="" src="">
						      </div>
						    </div>
						</div> -->
						
                	</form>
                   
                    
                    
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                    <button id="verify" class="btn btn-theme" onclick="auth(this);" type="button"
                    data-loading-text="60s">确认</button>
                </div>
            </div>
        </div>
    </div>
    <!-- modal -->
		
		      </form>	  	
	  	
	  	</div>
</div>
 
<!-- js placed at the end of the document so the pages load faster -->
<script src="<%=path %>/static/js/jquery-1.9.1.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path %>/static/layer/layer.js"></script>
<script src="<%=path %>/static/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path %>/static/bootstrap-3.3.7/js/bootstrapValidator.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="<%=path %>/static/assets/js/jquery.backstretch.min.js"></script>

<script type="text/javascript">
var timeNum=60;
var inv;
function setNumber(){
	timeNum--;
	if(timeNum <= 0){
		clearInterval(inv);
		$("#verify").button('reset');
	}else{
		inv = setTimeout(setNumber, 1000);
	}
	
}
$.backstretch("<%=path %>/static/assets/img/login-bg.jpg", {speed: 500});
/* 发送验证码 */
function sendCode(){
	var value = $("#mobilePhoneNum").val();
	var reg = /^1[34578]\d{9}$/;
	if(!reg.test(value)){
		layer.msg("请正确输入手机号码",{icon:2});
		return false;
	}
	$("#sendCodeBtn").button('loading').delay(60000).queue(function() {
		$("#sendCodeBtn").button('reset');
	});
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/problog/sednemailcode',
		type:'post',
		dataType:'json',
		data:{
			mobilePhone:value,
			_time:t
		},
		success:function(data){
			var mess = data.message;
			if(data.result > 0){
				var e = data.email;
				layer.alert('发送成功，请登录'+e+'邮件获取验证码');
				/* layer.confirm('发送成功，请登录'+e+'获取验证码', {btn:'确定'}, 
						function(index){
					layer.close(index);
				}); */
			}else{
				
				layer.alert('发送失败,错误原因:'+mess);
				/* layer.msg("发送失败:"+e,{icon:2});
				layer.confirm('发送失败,错误原因:'+e, {btn:'确定'}, 
						function(index){
					layer.close(index);
				}); */
			}
		},
		error:function(){
			
		}
	});
};
//发送邮件
function auth(obj){
	$(obj).button('loading');
	setNumber();
	var value = $("#mobilePhoneNum").val();
	if("" == value){
		layer.msg('手机号码必填',{icon:2});
		return false;
	}
	
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/problog/sednemailcode',
		type:'post',
		dataType:'json',
		data:{
			mobilePhoneNum:value,
			_time:t
		},
		success:function(data){
			var mess = data.message;
			if(data.result > 0){
				var mess = data.message;
				layer.alert(mess);
				//关闭模态框
				$("#myModal").hide();
				$(".modal-backdrop").hide();
			}else{
				layer.alert('发送失败,错误原因:'+mess);
			}
			
		},
		error:function(){
			
		}
	});
};
/* 验证验证码 */
function authTemp(){
	var value = $("#mobilePhoneNum").val();
	var vCode = $("#verificationCode").val();
	if("" == value){
		layer.msg('手机号码必填',{icon:2});
		return false;
	}
	if("" == vCode){
		layer.msg('验证码必填', {icon:2});
		return false;
	}
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/problog/authcode',
		type:'post',
		dataType:'json',
		data:{
			code:vCode,
			mobilePhoneNum:value,
			_time:t
		},
		success:function(data){
			if(data.result > 0){
				var mid = data.mid;
				window.location.href="<%=path%>/problog/repassword/"+mid;
			}else{
				layer.alert(data.message);
			}
		},
		error:function(){
			
		}
	});
}
$(document).ready(function(){
	 $("#loginForm").bootstrapValidator({
		 fields:{
			 backuserMobliePhone:{
				 validators:{
					 notEmpty: {  
	                   message: '手机号码不能为空'  
	                 },
					 regexp:{
				     	regexp:/^1[34578]\d{9}$/,
				     	message : '请输入13,14,15,17,18开头的手机号码'
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
                    	message:'密码长度太短，请输入4到16位密码'
	                 }
				 }
			 }
		 }
	 });
});

</script>
</body>
</html>