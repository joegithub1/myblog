<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name='viewport' content='user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0' />
<meta name='apple-mobile-web-app-capable' content='yes' /> 
<meta name='apple-mobile-web-app-status-bar-style' content='black' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=path %>/static/css/auth.css" rel="stylesheet">

<title>权限管理</title>
</head>
<body>
<!--main content start-->
<div class="site-min-height">
   <h3><i class="fa fa-angle-right"></i>权限管理</h3>
      <div class="row mt">
         <div class="col-lg-12">
          	<div class="content-panel">
          	  <div class="col-md-12">
          	    <div class="col-md-8"></div>
          	    	<div class="col-md-4">
          	    	  
          	    <button onclick="openModal();" class="btn btn-primary btn-large">添加</button>
          	    
          	    <button onclick="updateOpenModal();" class="btn btn-primary btn-large">修改</button>
          	    
          	    <button onclick="openAllotRole();" class="btn btn-primary btn-large">分配</button>
          	    
          	    <button class="btn btn-primary btn-large" onclick="delRole();">删除</button>
          	    
          	    	</div>
          	     </div>
          	     <section id="unseen">
          	       <table class="table table-bordered table-striped table-condensed">
					 <col width="1%">
					 <col width="10%"> 
					 <col width="10%">   
					 <col width="10%">        	         
          	         <thead>
          	         	<tr>
          	         	 <th>
          	         	   <span class="check"><input id="check_all" name="check_all" type="checkbox" class="checked"></span>
          	         	 </th>
					     <th>角色名称</th>
					     <th>创建时间</th>
					     <th>备注</th>
						</tr>
          	         </thead>
          	         <tbody>
          	           <c:forEach items="${roles.list }" var="role">
					    <tr>
					    <td>
					       <span class="check"><input name="check_name" value="${role.roleId}" type="checkbox" class="checked"></span>
					    </td>
						<td>${role.roleName}</td>
						<td>${role.roleCreatedate }</td>
						<td>${role.roleRemark}</td>
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

<!-- 模态框（Modal）添加角色 -->
<div class="modal fade authManage" id="modalRole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog">
  <div class="modal-content">
    <div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
       <h4 class="modal-title" id="myModalLabel"></h4>
    </div>
    <div class="modal-body">
      <form id="form" class="form-horizontal style-form" method="post">
       <input type="hidden" id="roleId" name="roleId" value="">
       <div class="form-group">
        <label class="col-sm-2 col-sm-2 control-label">角色名称：</label>
        <div class="col-sm-8">
            <input id="" name="roleName"  type="text"  class="form-control" placeholder="请输入角色名称">
        </div>
        <label class="col-sm-2 col-sm-2 control-label">*</label>
       </div>
       <div class="form-group">
        <label class="col-sm-2 col-sm-2 control-label">备注：</label>
        <div class="col-sm-8">
        	<textarea name="roleRemark" rows="" cols=""  placeholder="请输入备注" class="form-control"></textarea>
            <!-- <input id="" name=""  type="text"  class="form-control" placeholder="请输入备注"> -->
        </div>
       </div>
       <div class="form-group">
        <label class="col-sm-2 col-sm-2 control-label">禁用：</label>
        <div class="col-sm-8">
            <input name="roleIsclose" type="radio" value="0"  checked="checked">可用
			<input name="roleIsclose" type="radio" value="1" style="margin-left: 15px;">禁用
        </div>
        <label class="col-sm-2 col-sm-2 control-label">*</label>
       </div>
       <div class="form-group">
         <div class="col-sm-10 menu-list">
           <ul class="firstUL">
            <c:forEach items="${menuVos}" var="ms">
             <li class="active">
               <div class="clean">
                 <div class="authdiv">
                   <span  class="authspan">${ms.menuName}</span>
                 </div>
                 
                 <div class="checkbox authcheckbox">
                    <label>
		              <input type="checkbox" onclick="topClick(this);" name="menuStr" value="${ms.menuId}" />
		            </label>
                 </div>
                 
                 <div class="clean"></div>
                 
                 <ul>
                  <!-- 子代菜单 -->
                   <c:forEach items="${ms.menuVoList}" var="m">
                    <li>
                     <div class="authdiv">
                       <span class="authspan">${m.menuName}</span>
                     </div>
                     
                     <div class="checkbox subcheckbox">
                       <label>
                         <input type="checkbox" name="menuStr" value="${m.menuId}" class="${m.menuId} ${ms.menuId}" onchange="childClick(this);" />
                       </label>
                     </div>
                     
                     <div class="clean"></div>
                     
                     <!-- 孙代菜单 -->
                     <ul>
                       <c:forEach items="${m.authList}" var="auth">
                        <li>
                          <div class="authdiv">
                            <span class="authspan">${auth.authName}</span>
                          </div>
                          
                          <div class="checkbox subsubcheckbox">
                           <label>
                             <input type="checkbox" name="authStr" class="auth_${m.menuId} list_${ms.menuId}" value="${auth.authId}" onchange="authClick(this);"/>
                           </label>
                          </div>
                          
                          <div class="clean"></div>
                          
                        </li>
                       </c:forEach>
                     </ul>
                     
                    </li>
                   </c:forEach>
                 </ul>
               </div>
             </li>
            </c:forEach>
           </ul>
         </div>
       </div>
      </form>
    </div>
     <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
         <button type="button" class="btn btn-primary" onclick="confirmMenu();">确定</button>
     </div>
  </div>
 </div>
</div>


<!-- 分配模态框（Modal） -->
<div class="modal fade authManage" id="allotRole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
         <h4 class="modal-title" id="myModalLabel">角色分配</h4>
    </div>
    <div class="modal-body auth-given">
      <input type="hidden" value="" id="allotRoleId">
      <div class="worker">
        <h4>未分配人员</h4>
        <ul id="noAu">

        </ul>
      </div>
     
     <div class="worker-given">
       <h4>已分配人员</h4>
       <ul id="allocatedAu"></ul>
     </div>
     
    </div>
    <div class="modal-footer">
       <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
       <button type="button" class="btn btn-primary" onclick="confirmMenu();">确定</button>
    </div>
   </div>
  </div>
</div>

<script type="text/javascript" src="<%=path %>/static/js/authManage.js"></script>
<script type="text/x-javascript-tmpl" id="allotTmpl">
<li userId={{= backuser_id}}>{{= backuser_name}}</li>
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("input[name=check_all]").click(function(){
		$("input[name=check_name]").ischeck("check_all");
	});

	$("input[name=check_name]").change(function(){
		$("input[name=check_name]").smallchange("check_all");
	});	
});
/* 清除form */
function clearRoleInfo(){
	var json={roleId:"",
			roleIsclose:"0",
			roleName:"",
			roleRemark:""};
	loadFormData('form', json);
    $("#form").find("input:checkbox[name='authStr']").each(function (index,obj) {
        $(obj).prop("checked",false);
    });
    $("#form").find("input:checkbox[name='menuStr']").each(function (index,obj) {
        $(obj).prop("checked",false);
    });
}
function openModal(){
	clearRoleInfo();
	$("#modalRole").modal();
}
//刷新分配人员
function pushUser(roleId){
	$("#allotRoleId").val(roleId);
	var t=new Date().valueOf();
	$.ajax({
        url: '<%=path%>/blog/auth/selectWorkerAuth',
        type: 'POST',
        dataType : "JSON",
        data:{
        	roleId:roleId,
        	_time:t
        },
        success: function (data) {
        	$("#noAu").html($("#allotTmpl").tmpl(data.haveAuth));
        	$("#allocatedAu").html($("#allotTmpl").tmpl(data.assiAuth));
        	
        	$("#noAu").on('click','li',function(){
        		startAllot(this, 0);
        	});
        	
        	$("#allocatedAu").on('click','li',function(){
        		startAllot(this, 1);
        	});
        }
    });
}
/*打开分配的模态框  */
function openAllotRole(){
	var ids=$("input[name=check_name]").checkvalue();
	if(ids.length != 1){
		layer.msg("请选择一项");
		return false;
	}
	pushUser(ids[0]);
	
	$("#allotRole").modal();
}
/* 开始分配 */
function startAllot(objThis,flag){
	var t=new Date().valueOf();
	
	var userId=$(objThis).attr("userId");
	var roleId=$("#allotRoleId").val();
	
	$.ajax({
		url:'<%=path%>/blog/auth/updateuserrole',
		type:'post',
		dataType:'json',
		data:{
			_time:t,
			userId:userId,
			roleId:roleId,
			flag:flag
		},
		success:function(data){
			//刷新
			pushUser(roleId);
		}
	});
}


//修改需要回显得数据
function setRoleInfo(data){
	var role = data.roleInfo;
	var authArr = data.authIds;
    var menuArr = data.menuIds;
    loadFormData('form', role);
    
    $("#form").find("input:checkbox[name='authStr']").each(function (index,obj) {
        if($.inArray(parseInt($(obj).val()),authArr) != -1){
            $(obj).prop("checked",true);
        }else {
            $(obj).prop("checked",false);
        }
    });
    $("#form").find("input:checkbox[name='menuStr']").each(function (index,obj) {
        if($.inArray(parseInt($(obj).val()),menuArr) != -1){
            $(obj).prop("checked",true);
        }else {
            $(obj).prop("checked",false);
        }
    });
    $("#modalRole").modal();
}
//打开修改模态框
function updateOpenModal(){
	clearRoleInfo();
	var ids = $("input[name=check_name]").checkvalue();
	if(ids.length != 1){
		layer.msg("请选择一项");
		return false;
	}
	var url='<%=path%>/blog/auth/getrolebyid/'+ids[0];
	$.ajax({
        url: url,
        type: 'POST',
        async: false,
        cache: false,
        dataType: "json",
        contentType: false,
        processData: false,
        success: function (data) {
            setRoleInfo(data);
        }
    });
	
}

/* 模态框 确定 */
function confirmMenu(){
	var rId = $("#roleId").val();
	var url="";
	if(rId == ""){
		url="<%=path%>/blog/auth/saverole";
	}else{
		url="<%=path%>/blog/auth/updaterole";
	}
	var data = new FormData($('#form')[0]);
	$.ajax({
        url: url ,
        type: 'POST',
        data: data,
        dataType : "JSON",
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            if(data.status){
            	layer.msg(data.message);
            	$("#modalRole").hide();
            	$(".modal-backdrop").hide();
            	loadRight('<%=path%>/blog/auth/authmanage', {});
            }else{
            	layer.msg(data.message);
            }
        }
    });
}
/* 删除角色 */
function delRole(){
	var ids=$("input[name=check_name]").checkvalue();
	if(ids.length !=1){
		layer.msg("请选择一项");
		return false;
	}
	layer.confirm('确定删除选中的数据吗?', {icon: 3, title:'提示'}, function(index){
		var url = "<%=path%>/blog/auth/deleterole/"+ids[0];
        $.ajax({
            url: url ,
            type: 'POST',
            dataType : "JSON",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
            	if(data.status){
   					layer.msg(data.message);
   					loadRight('<%=path%>/blog/auth/authmanage', {});
   				}else{
   					layer.msg(data.message);
   					
   				}
            }
        });
        layer.close(index);  
		
		
	});
}

//顶级菜单点击事件
function topClick(obj){
	  var valInfo = $(obj).val();
	  if($(obj).is(":checked")){
		  $('.'+valInfo).prop("checked" , true);
		  $('.list_'+valInfo).prop("checked" , true);
	  }else{
		  $('.'+valInfo).removeAttr("checked");
		  $('.list_'+valInfo).removeAttr("checked");
	  }  
}
//子菜单点击事件
function childClick(obj){
	  var topId = $(obj).attr("class");
	  $("input[value='"+ topId +"']").prop("checked" , true);
	  var valInfo = $(obj).attr("class");
	  var bool = true;
	  for(var i = 0; i < $('.'+valInfo).length; i++){
		  if($('.'+valInfo).eq(i).is(":checked")){
			 bool = false; 
		  }
	  }
	  if(bool){
		  $('input[value="'+ valInfo +'"]').removeAttr("checked"); 
	  }
	  var val = $(obj).val();
	  for(var i = 0; i < $(".auth_"+val).length; i++){
		  var authObj = $(".auth_"+val).eq(i);
		  if($(obj).is(":checked")){
			  authObj.prop("checked" , true);
		  }else{
			  authObj.removeAttr("checked");  
		  }
	  }
}
//按钮权限分配改变事件
function authClick(obj){
	  var authClass = $(obj).attr("class");
	  var menuId = authClass.split("_")[1];
	  $("input[value='"+ menuId +"']").prop("checked" , true);
}
</script>
</body>
</html>