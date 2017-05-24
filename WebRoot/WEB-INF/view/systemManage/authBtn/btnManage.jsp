<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta name='viewport' content='user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0' />
<meta name='apple-mobile-web-app-capable' content='yes' /> 
<meta name='apple-mobile-web-app-status-bar-style' content='black' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限按钮管理</title>
</head>
<body>
<!--main content start-->
<div class="site-min-height">
   <h3><i class="fa fa-angle-right"></i>按钮管理</h3>
      <div class="row mt">
         <div class="col-lg-12">
          	<div class="content-panel">
          	  <div class="col-md-12">
          	    <div class="col-md-8"></div>
          	    	<div class="col-md-4">
          	    	  
          	    <button onclick="openModal();" class="btn btn-primary btn-large">添加</button>
          	    
          	    <button onclick="openUpdateModal();" class="btn btn-primary btn-large">修改</button>
          	    
          	    <button class="btn btn-primary btn-large" onclick="delAuth();">删除</button>
          	    
          	    	</div>
          	     </div>
          	     <section id="unseen">
          	       <table class="table table-bordered table-striped table-condensed">
          	         <col width="2%">
          	         <col width="10%">
          	         <col width="10%">
          	         <col width="10%">
          	         <col width="8%">
          	         <col width="10%">
          	         <thead>
          	          <tr>
          	          	<th>
          	          	 <span class="check"><input id="check_all" name="check_all" type="checkbox" class="checked"></span>
          	          	</th>
          	          	<th>菜单</th>
          	          	<th>名称</th>
          	          	<th>权限标识</th>
          	          	<th>排序</th>
          	          	<th>备注</th>
          	          </tr>
          	         </thead>
          	         <tbody>
          	           <c:forEach items="${auths.list}" var="auth">
          	            <tr>
          	            	<td>
          	            	<span class="check"><input name="check_name" value="${auth.auth_id }" type="checkbox" class="checked"></span>
          	            	</td>
          	            	<td>${auth.menu_name }</td>
          	            	<td>${auth.auth_name }</td>
          	            	<td>${auth.auth_powerid }</td>
          	            	<td>${auth.auth_ordernum }</td>
          	            	<td>${auth.auth_comm }</td>
          	            </tr>
          	           </c:forEach>
          	         </tbody>
          	       </table>
          	     </section>
          	</div>
          	
          	 <!-- BUTTONS NESTING -->
      				<div class="showback">
						<div id="page-group" class="btn-group">
						 
						</div>      					
      				</div><!-- /showback -->
          	
         </div>
      </div>
</div><!--/wrapper -->
<!--main content end-->


<!-- 模态框（Modal） -->
<div class="modal fade" id="authBtnModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
         <h4 class="modal-title" id="myModalLabel"></h4>
    </div>
    <div class="modal-body">
     <form id="form" class="form-horizontal style-form" method="post">
     <input type="hidden" id="authId" name="authId" value="">
     <div class="form-group">
          <label class="col-sm-2 col-sm-2 control-label">菜单：</label>
          <div class="col-sm-8">
          	<select id="" name="authMenuId" class="form-control btn btn-primary">
          	 <option value="-1">请选择</option>
          	 <c:forEach items="${menus}" var="m">
          	 	<option value="${m.menuId}">${m.menuName }</option>
          	 </c:forEach>
          	</select>
          </div>
          <label class="col-sm-2 col-sm-2 control-label">*</label>
      </div>
      <div class="form-group">
          <label class="col-sm-2 control-label">名称：</label>
          <div class="col-sm-8">
             <input id="" name="authName"  type="text"  class="form-control" placeholder="请输入名称">
          </div>
          <label class="col-sm-2 col-sm-2 control-label">*</label>
      </div>
      <div class="form-group">
          <label class="col-sm-2 control-label">权限标识：</label>
          <div class="col-sm-8">
             <input id="" name="authPowerid"  type="text"  class="form-control" placeholder="请输入标识">
          </div>
          <label class="col-sm-2 col-sm-2 control-label">*</label>
      </div>
      <div class="form-group">
          <label class="col-sm-2 control-label">排序：</label>
          <div class="col-sm-8">
             <input id="" name="authOrdernum"  type="text"  class="form-control" placeholder="请输入排序">
          </div>
          <label class="col-sm-2 col-sm-2 control-label">*</label>
      </div>
      <div class="form-group">
          <label class="col-sm-2 control-label">备注：</label>
          <div class="col-sm-8">
             <!-- <input id="" name="authComm"  type="text"  class="form-control" placeholder="请输入备注"> -->
             <textarea rows="" cols="" name="authComm" class="form-control" placeholder="请输入备注"></textarea>
          </div>
          
      </div>
     </form>
    </div>
    <div class="modal-footer">
       
       <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
       <button type="button" onclick="resetForm();" class="btn btn-default">重置表单</button>
       <button type="button" class="btn btn-primary" onclick="confirmAuthBtn();">确定</button>
    </div>
   </div>
  </div>
</div>
<script type="text/javascript">
function pageInfoList(pageNum){
	loadRight('<%=path%>/auth/btnmanage', {"pageNum":pageNum});
}
$(document).ready(function(){
	
	var pi={"pageNum":${auths.pageNum},"pages":${auths.pages} };
	paging('page-group', 'pageInfoList', pi);
	
	$("input[name=check_all]").click(function(){
		$("input[name=check_name]").ischeck("check_all");
	});
	
	$("input[name=check_name]").change(function(){
		$("input[name=check_name]").smallchange("check_all");
	});
});
function openModal(){
	$("#authId").val("");
	document.getElementById("form").reset();
	
	
	$("#authBtnModal").modal();
}
function openUpdateModal(){
	var v=$("input[name=check_name]").checkvalue();
	if(v.length != 1){
		layer.msg("请选择一项");
		return false;
	}
	$("#authId").val("");
	document.getElementById("form").reset();

	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/authbtn/getauthbyid',
		type:'post',
		dataType:'json',
		data:{authId:v[0],_time:t},
		success:function(data){
			loadFormData("form",data);
			
		}
	});
	$("#authBtnModal").modal();
}

<%-- layer.confirm(result.message, {
	  btn: ['确定', '取消', '确定并重置表单'] //可以无限个按钮
	  ,btn3: function(index, layero){
		document.getElementById("form").reset();  
		layer.close(index);
	  },
	  btn2: function(index, layero){
		  $("#authBtnModal").hide();
    	  $(".modal-backdrop").hide();
		  loadRight('<%=path%>/auth/btnmanage', {});
		  layer.close(index);
      },btn1: function(index, layero){
    	  loadRight('<%=path%>/auth/btnmanage', {});
    	  layer.close(index);
	  }
   }); --%>
/* 确定保存权限按钮 */
function confirmAuthBtn(){
	var url='';
	var id=$("#authId").val();
	if("" == id){
		url='<%=path%>/authbtn/saveauth';
	}else{
		url='<%=path%>/authbtn/updateauth';
	}
	var data = new FormData($('#form')[0]);
	$.ajax({
		url:url,
		data:data,
		type:'POST',
		dataType:'JSON',
		cache: false,  
        processData: false, 
        contentType: false, 
        async : false,
        success:function(result){
        	if(result.status > 0){
        		if(result.flag == 0){//保存操作
        			layer.msg(result.message);
        			$("#authBtnModal").hide();
    	        	$(".modal-backdrop").hide();
    				loadRight('<%=path%>/auth/btnmanage', {});
        			
        		}else{//修改操作
        			layer.msg(result.message);
        			$("#authBtnModal").hide();
    	        	$(".modal-backdrop").hide();
        			loadRight('<%=path%>/auth/btnmanage', {});
        		}
        	}else{
        		layer.msg(result.message);
        	}
        	
        	
        }
	});
	
}
//重置表单
function resetForm(){
	layer.confirm('确定重置表单吗?', {icon: 3, title:'提示'}, function(index){
		document.getElementById("form").reset();
		layer.close(index);
	});
}

function delAuth(){
	var v=$("input[name=check_name]").checkvalue();
	if(v.length > 0){
		layer.confirm('确定删除选中项吗?', {icon: 3, title:'提示'}, function(index){
			var t=new Date().valueOf();
			$.ajax({
				url:'<%=path%>/authbtn/delauth',
				type:'post',
				dataType:'json',
				data:{ids:v,_time:t},
				success:function(data){
					if(data > 0){
						layer.msg("删除成功");
						loadRight('<%=path%>/auth/btnmanage', {});
					}else{
						layer.msg("删除失败");
					}
				}
			});
			layer.close(index);
		});
	}
	
}
</script>
</body>
</html>