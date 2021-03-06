<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
 String path =request.getContextPath();
%>    
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>黄键博客</title>
<link href="<%=path %>/static/assets/css/bootstrap.css" rel="stylesheet">
<link href="<%=path %>/static/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=path %>/static/assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/static/assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/static/assets/lineicons/style.css">    
<link rel="stylesheet" type="text/css" href="<%=path %>/static/bootstrap-3.3.7/css/bootstrap.min.css">   
<!-- Custom styles for this template -->
<link href="<%=path %>/static/assets/css/style.css" rel="stylesheet">
<link href="<%=path %>/static/assets/css/style-responsive.css" rel="stylesheet">
<link href="<%=path %>/static/css/userDefinedStyle.css" rel="stylesheet">

<script src="<%=path %>/static/assets/js/jquery.js"></script>
<script src="<%=path %>/static/js/jquery-1.11.3.min.js"></script>
<%-- <script type="text/javascript" src="<%=path %>/static/assets/js/jquery-1.8.3.min.js"></script> --%>
<script src="<%=path %>/static/assets/js/chart-master/Chart.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
/* <li class="sub-menu">
<a href="javascript:;" >
    <i class="fa fa-desktop"></i>
    <span>UI Elements</span>
</a>
<ul class="sub">
    <li><a  href="general.html">General</a></li>
    <li><a  href="buttons.html">Buttons</a></li>
    <li><a  href="panels.html">Panels</a></li>
</ul>
</li> */
var data;
function getRightPage(i, j) {
	var urls = data.list[i].menu[j].menuPathname;
	if("" != urls){
		var t=new Date().valueOf();
	    var url = "<%=path%>"+data.list[i].menu[j].menuPathname+"?_time="+t;
	     $.ajax({
	        type:"POST",
	        url:url,
	        cache: false,
	        processData: false,
	        sync:false,
	        dataType:'text',
	        success:function(data){
	            $("#right-page").html(data);
	        }
	    });
	   // document.getElementById("rightContent").src = "<%=path%>" + data.list[i].menu[j].menuPathname;
	}else{
		
	}
}
$(function(){
	data=${sessionScope.userVo.menuJson};
	for(var i=0;i<data.list.length;i++){
		$("#nav-accordion").append("<li id="+i+" class='sub-menu'></li>");
		for(var j=0;j<data.list[i].menu.length;j++){
			if(data.list[i].menu[j].menuIsroot == 1){
				$("#"+i).append('<a onclick="getRightPage('+i+','+j+');" href="javascript:void(0);" ><i class="fa fa-desktop"></i><span>'+data.list[i].menu[j].menuName+'</span></a>     ');
				$("#"+i).append("<ul id='list"+i+"' class='sub'> </ul> ");
			}else{
				$("#list"+i).append("<li><a onclick='getRightPage("+i+","+j+")' href='javascript:void(0);'>"+data.list[i].menu[j].menuName+"</a></li>");
			}
		}
	}
});
</script>
</head>
<body>

<section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="隐藏或显示导航栏"></div>
              </div>
            <!--logo start-->
            <a href="javascript:void(0);" class="logo"><b>DASHGUM FREE</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <!-- <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">DashGum Admin Panel</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Database Update</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Product Development</div>
                                        <div class="percent">80%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Payments Sent</div>
                                        <div class="percent">70%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                            <span class="sr-only">70% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li> -->
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <!-- <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hi mate, how is everything?
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-divya.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Divya Manian</span>
                                    <span class="time">40 mins.</span>
                                    </span>
                                    <span class="message">
                                     Hi, I need your help with this.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-danro.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dan Rogers</span>
                                    <span class="time">2 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Love your new Dashboard.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-sherman.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dj Sherman</span>
                                    <span class="time">4 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Please, answer asap.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">See all messages</a>
                            </li>
                        </ul>
                    </li> -->
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            
            
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <c:if test="${sessionScope.userVo.pattern == 1}">
                    <li><a class="logout" href="<%=path %>/blog/logout">安全退出</a></li>
                    </c:if>
                    <c:if test="${sessionScope.userVo == null || sessionScope.userVo.pattern == 2}">
                    <li><a class="logout" href="javascript:void(0);" onclick="login();">立即登录</a></li>
                    </c:if>
                    
            	</ul>
            	
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="javascript:void(0);"><img src="<%=path %>/static/assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">${sessionScope.userVo.user.backuserName }</h5>
              	  	
                  <!-- <li class="mt">
                      <a class="active" href="index.html">
                          <i class="fa fa-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li> -->
				  
                 <!--  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>UI Elements</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="#">General</a></li>
                          <li><a  href="javascript:void(0);">Buttons</a></li>
                          <li><a  href="javascript:void(0);">Panels</a></li>
                      </ul>
                  </li> -->

                  

              </ul>
               
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
             <!--右侧开始-->
        		<div  class="index-right" id="right-page" >
                   <iframe name="rightContent" id="rightContent" src="" height="100%" width="100%" frameborder="0"></iframe>
        		</div>
        <!--右侧结束-->
          </section>
      </section>

      <!--main content end-->
      <!--footer start-->
     <!--  <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is home
              <a href="index.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer> -->
      <!--footer end-->
  </section>


<!-- js placed at the end of the document so the pages load faster -->
    
    <script src="<%=path %>/static/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="<%=path %>/static/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="<%=path %>/static/assets/js/jquery.scrollTo.min.js"></script>
    <script src="<%=path %>/static/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="<%=path %>/static/assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="<%=path %>/static/assets/js/common-scripts.js"></script>
    
    <script type="<%=path %>/static/text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="<%=path %>/static/text/javascript" src="assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="<%=path %>/static/assets/js/sparkline-chart.js"></script>    
	<script src="<%=path %>/static/assets/js/zabuto_calendar.js"></script>	
	
	
	<script type="text/javascript" src="<%=path %>/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path %>/static/layer/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/static/js/pageHelper.js"></script>
	<script type="text/javascript" src="<%=path %>/static/js/myCheckbox.js"></script>
	<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
	<script type="text/javascript">
		function login(){
			var t=new Date().valueOf();
			window.location.href="<%=path%>/blog/login";
		}
        $(document).ready(function () {
        /* var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'Welcome to Dashgum!',
            // (string | mandatory) the text inside the notification
            text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
            // (string | optional) the image to display on the left
            image: 'assets/img/ui-sam.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: true,
            // (int | optional) the time you want it to be alive for before fading out
            time: '',
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
        });

        return false; */
        });
	</script>
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            }); 
        });
        
        
         function myNavFunction(id) {
        	console.log(id);
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        } 
    </script>
</body>
</html>