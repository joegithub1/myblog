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
<title>菜单管理</title>
<style type="text/css">

</style>
</head>
<body>
<!--main content start-->
<div class=" site-min-height">
   <h3><i class="fa fa-angle-right"></i>菜单管理</h3>
      <div class="row mt">
         <div class="col-lg-12">
          	 <div class="content-panel">
          	     <div class="col-md-12">
          	    	<div class="col-md-8"></div>
          	    	<div class="col-md-4">
          	    	  
          	    <button onclick="openModal(1);" class="btn btn-primary btn-large">添加</button>
          	    
          	    <button onclick="openUpdateModal();" class="btn btn-primary btn-large">修改</button>
          	    
          	    <button class="btn btn-primary btn-large" onclick="delMenu();">删除</button>
          	    
          	    	</div>
          	     </div>
          	    <section id="unseen">
          	      <table class="table table-bordered table-striped table-condensed">
                      <thead>
                         <tr>
                              	  <th>
                              	  <span class="check"><input id="check_all" name="check_all" type="checkbox" class="checked"></span>
                              	  </th>
                              	  <th>序号</th>
                                  <th>名称</th>
                                  <th>接口名称</th>
								  <th>排序</th>
						          <th>是否可见</th>
						          <th>操作</th>
                          </tr>
                       </thead>
                       <tbody>
                       <c:forEach items="${menus.list}" var="menu">
					<tr>
					<td>
				       <span class="check"><input name="check_name" value="${menu.menuId }" type="checkbox" class="checked"></span>
					</td>
					<td>${menu.menuId}</td>
						<td <c:if test="${menu.menuIsroot == 1}">style="text-align:center"</c:if>  <c:if test="${menu.menuIsroot == 0}">style="text-align:right"</c:if>   >${menu.menuName}</td>
						<td>${menu.menuPathname }</td>
						<td>${menu.menuOrdernum}</td>
						<td>
						<c:if test="${menu.menuIsshow == 1}">可见</c:if>
						<c:if test="${menu.menuIsshow == 0}">隐藏</c:if>
						</td>
						<td>
						
						   <c:if test="${menu.menuIsroot == 1}">
						    <%--  <a href="javascript:void(0)" id="${menu.menuId}" class="btn detail-btn addmenu">添加子菜单</a>
						    data-toggle="modal" href="#example"
						    --%>
						    <button onclick="openModal(0,${menu.menuId},'${menu.menuName}');"  class="btn btn-primary btn-xs">添加子菜单</button>
						   </c:if>
						   
						</td>
					</tr>
					   <c:forEach items="${menu.menuVoList}" var="child">
						<tr>
						<td>
				           <span class="check"><input name="check_name" value="${child.menuId }" type="checkbox" class="checked"></span>
					    </td>
					    	<td>${child.menuId}</td>
							<td <c:if test="${child.menuIsroot == 1}">style="text-align: center;"</c:if> <c:if test="${child.menuIsroot == 0}">style="text-align: right;"</c:if> >${child.menuName}</td>
							<td>${child.menuPathname }</td>
							<td>${child.menuOrdernum }</td>
							<td>
							 <c:if test="${child.menuIsshow == 1}">可见</c:if>
							 <c:if test="${child.menuIsshow == 0}">隐藏</c:if>
							</td>
							<td>
						
							</td>
						</tr>
					   </c:forEach>
				   </c:forEach>

                       </tbody>       
                                      
          	      </table>
          	    </section>
          	    
          	    
          	    
          	 </div><!-- /content-panel -->
          	 <!-- BUTTONS NESTING -->
      				<div class="showback">
						<div id="page-group" class="btn-group">
						 
						</div>      					
      				</div><!-- /showback --> 
          	 
          	 
         </div>
      </div>
</div><!--/wrapper -->
<!--main content end-->	




<!-- 模态框（Modal）添加父菜单 -->
<div class="modal fade" id="example" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">
             <form id="form" class="form-horizontal style-form" method="post">
                 <input id="menuPid" name="menuPid" value="" type="hidden">
                 <input id="menuId" name="menuId" value="" type="hidden">
                 <input id="menuIsroot" name="menuIsroot" value="" type="hidden">
                 <div class="form-group">
                     <label class="col-sm-2 col-sm-2 control-label">上级菜单：</label>
                     <div class="col-sm-8">
                        <input id="menuPname" name="menuPname"  type="text"  class="form-control" placeholder="请输入顶级菜单">
                     </div>
                     <label class="col-sm-2 col-sm-2 control-label">*</label>
                 </div>
                 <div class="form-group">
                     <label class="col-sm-2 col-sm-2 control-label">菜单名称：</label>
                     <div class="col-sm-8">
                        <input name="menuName" type="text"  class="form-control" placeholder="请输入菜单名称">
                     </div>
                     <label class="col-sm-2 col-sm-2 control-label">*</label>
                 </div>
                 <div class="form-group">
                     <label class="col-sm-2 col-sm-2 control-label">接口名称：</label>
                     <div class="col-sm-8">
                        <input id="menuPathname" name="menuPathname" type="text"  class="form-control" placeholder="请输入接口名称">
                     </div>
                     <label class="col-sm-2 col-sm-2 control-label">*</label>
                 </div>
                 <div class="form-group">
                     <label class="col-sm-2 col-sm-2 control-label">排序：</label>
                     <div class="col-sm-8">
                        <input name="menuOrdernum" type="text"  class="form-control" placeholder="请输入排序">
                     </div>
                     <label class="col-sm-2 col-sm-2 control-label">*</label>
                 </div>
                 <div class="form-group">
                     <label class="col-sm-2 col-sm-2 control-label">权限标识：</label>
                     <div class="col-sm-8">
                        <input name="menuPowerid" type="text"  class="form-control" placeholder="请输入权限标识">
                     </div>
                     <label class="col-sm-2 col-sm-2 control-label">*</label>
                 </div>
                 <div class="form-group">
                     <label class="col-sm-2 col-sm-2 control-label">是否可见:</label>
                     <div class="col-sm-8">
                        <!-- <input name="menuIsshow" type="checkbox" checked="checked" /> -->
                        <input name="menuIsshow" type="radio" value="1"  checked="checked">可见
						<input name="menuIsshow" type="radio" value="0" style="margin-left: 15px;">隐藏
                     </div>
                 </div>
             </form>
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="confirmMenu();">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript" src="<%=path %>/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
function pageInfoList(pageNum){
	var url='<%=path%>/menu/menumanage';
	loadRight(url, {"pageNum":pageNum});
}
$(document).ready(function(){
	var pi={"pageNum":${menus.pageNum},"pages":${menus.pages} };
	paging('page-group', 'pageInfoList', pi);
	
	$("input[name=check_all]").click(function(){
		$("input[name=check_name]").ischeck("check_all");
	});
	
	$("input[name=check_name]").change(function(){
		$("input[name=check_name]").smallchange("check_all");
	});
});
/* 打开窗体 */
function openModal(isRoot,pid,pName){
	document.getElementById("form").reset();
	//子菜单
	if(0 == isRoot){
		$("#menuPname").attr({"readonly":"readonly"});
		$("#menuPathname").removeAttr("readonly");
		
		//父id
		$("#menuPid").val(pid);
		//父name
		$("#menuPname").val(pName);
	//根菜单
	}else if(1 == isRoot){
		$("#menuPname").attr({"readonly":"readonly"});
		$("#menuPathname").attr({"readonly":"readonly"});
		$("#menuPid").val("");
		$("#menuPname").val("");
	}
	$("#menuIsroot").val(isRoot);
	$("#example").modal();
}
/* 修改 */
function openUpdateModal(mId){
	document.getElementById("form").reset();
	var v = $("input[name=check_name]").checkvalue();
	if(v.length != 1){
		alert("只能选中一项");
		return false;
	}
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/menu/getmenubyid',
		type:'post',
		dataType:'json',
		data:{mId:v[0],_time:t},
		success:function(data){
			$("#menuPname").attr({"readonly":"readonly"});
			var m = data.menu;
			if(m.menuIsroot == 0){
				m["menuPname"]=data.pMenu.menuName;
			}else if(m.menuIsroot == 1){
				
			}
			
			loadFormData("form",m);
			
		}
	});
	
	
	$("#example").modal();
}
function confirmMenu(){
	var data = new FormData($('#form')[0]);
	var isRoot = $("#menuIsroot").val();
	var rowId = $("#menuId").val();
	var url;
	if("" == rowId){
		url='<%=path%>/menu/savemenu';
	}else{
		url='<%=path%>/menu/updatemenu'
	}
	
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
        	alert(result.message);
        	if(result.status > 0){
        		$("#example").hide();
        		$(".modal-backdrop").hide();
        		var t=new Date().valueOf();
        		loadRight('<%=path%>/menu/menumanage',{});
        	}
        }
	});
	
}

/* var v=["1","2","3"];
$.ajax({
	data:{m:v}
})
 */
/* 删除 */
function delMenu(){
	var v = $("input[name=check_name]").checkvalue();
	if(v.length > 0){
		layer.confirm('确定删除选中的数据吗?', {icon: 3, title:'提示'}, function(index){
			  var t=new Date().valueOf();
			  $.ajax({
				  url:'<%=path%>/menu/deletebyid',
				  data:{mids:v,_time:t},
				  type:'post',
				  dataType:'json',
				  success:function(data){
					  if(data > 0){
						  layer.msg("删除成功");
						  loadRight('<%=path%>/menu/menumanage', {});
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