<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
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
<title>文章管理</title>
</head>
<body>
<div class=" site-min-height">
  <h3><i class="fa fa-angle-right"></i>文章管理</h3>
  <div class="row mt">
   <div class="col-lg-12">
     <div class="content-panel">
       <div class="col-md-12">
         <div class="col-md-8"></div>
         <div class="col-md-4">
         	<button onclick="skip(0);" class="btn btn-primary btn-large">添加</button>
          	    
          	<button onclick="skip(1);" class="btn btn-primary btn-large">修改</button>
          	
          	<button onclick="detail();" class="btn btn-primary btn-large">详情</button>    
            <shiro:hasPermission name="article:delete">
            <button class="btn btn-primary btn-large" onclick="del();">删除</button>
            </shiro:hasPermission>
         </div>
       </div>
       <section id="unseen">
        <table class="table table-bordered table-striped table-condensed">
         <col width="3%">
         <col width="5%">
         <col width="10%">
         <col width="10%">
         <col width="15%">
         <col width="10%">
         <col width="10%">
         <thead>
	          <tr>
	            <th>
          	      <span class="check"><input id="check_all" name="check_all" type="checkbox" class="checked"></span>
  	          	</th>
	           <th>ID</th>
	           <th>标题</th>
	           <th>类型</th>
	           <th>发表时间</th>
	          <!--  <th>阅读量</th> -->
	           <th>发表人</th>
	           <th>状态</th>
	           <th>是否删除</th>
	           <th>操作</th>
	         </tr>
         </thead>
         <tbody id="">
           <c:forEach items="${list.list}" var="a">
	          <tr>
	            <td>
          	       <span class="check"><input name="check_name" value="${a.id }" type="checkbox" class="checked"></span>
       			</td>
	            <td>${a.id }</td>
	            <td>${a.title }</td>
	            <td>${a.d_name }</td>
	            <td>${a.crate_date }</td>
	            <%-- <td>${a.read_num }</td> --%>
	            <td>${a.backuser_name }</td>
	            <td>${a.statusName }</td>
	            <td>
	            	<c:if test="${a.is_del == 0}">正常</c:if>
	            	<c:if test="${a.is_del == 1}">已删除</c:if>
	            </td>
	            <td>
	            	<c:if test="${a.status == 0}">
	            	<a href="javascript:void(0);" onclick="updateStatus(${a.id},1);">禁用</a>
	            	</c:if>
	            	<c:if test="${a.status == 1}">
	            	<a href="javascript:void(0);" onclick="updateStatus(${a.id},0);">启用</a>
	            	</c:if>
	            	<c:if test="${a.status == 2}">
	            	  <a href="javascript:void(0);" onclick="updateStatus(${a.id},0);">审核通过</a>
	            	</c:if>
	            </td>
	          </tr>
           </c:forEach>
         </tbody>
        </table>
       </section>
       
       
     </div>
     <div class="showback">
		<div id="page-group" class="btn-group">
		 
		</div>			
	</div>
   </div>
   </div>
</div>
<script type="text/javascript" src="<%=path %>/static/js/myCheckbox.js"></script>
<script type="text/javascript">
	function skip(flag){
		var id = -1;
		if(1 == flag){
			//获取id
			var v=$("input[name=check_name]").checkvalue();
			if(v.length != 1){
				layer.msg("请选择一项");
				return false;
			}else{
				id = v[0];
			}
			
			
		}
		loadRight("<%=path%>/blog/articleadmin/skip", {id:id});
	}
	function pageInfoList(pageNum){
		loadRight("<%=path%>/blog/articleadmin/list", {"pageNum":pageNum});
	}
	/* 设置状态 */
	function updateStatus(id,status){
		var message = status == 1?"确定禁用吗?":"确定启用或审核通过吗?";
		layer.confirm(message,{btn:['确定','取消']},
				function(index){
			$.ajax({
				url:'<%=path%>/blog/articleadmin/saveorupdate',
				dataType:'json',
				type:'post',
				data:{
					id:id,
					status:status
				},
				success:function(data){
					if(data.result > 0){
						layer.msg(data.message,{icon:1});
						loadRight('<%=path%>/blog/articleadmin/list', {});
					}else{
						layer.msg(data.message,{icon:2});
					}
					layer.close(index);
				}
			});
			
		}, function(){
			
		});
	};
	function del(){
		var v=$("input[name=check_name]").checkvalue();
		if(v.length != 1){
			layer.msg("请选择一项");
			return false;
		}else{
			layer.confirm("确定删除数据吗?", {btn:['确定','取消']}, 
					function(index){
				$.ajax({
					url:'<%=path%>/blog/articleadmin/saveorupdate',
					type:'post',
					dataType:'json',
					data:{
						id:v[0],
						isDel:1
					},
					success:function(data){
						if(data.result > 0){
							layer.msg("删除成功",{icon:1});
							layer.close(index);
							loadRight('<%=path%>/blog/articleadmin/list', {});
						}else{
							layer.msg("删除失败",{icon:2});
						}
					}
					
				});
			},function(){
				
			});
		}
		
	}
	/* 详情 */
	function detail(){
		var v=$("input[name=check_name]").checkvalue();
		if(v.length != 1){
			layer.msg("请选择一项");
			return false;
		}else{
			loadRight('<%=path%>/blog/articleadmin/detail',{id:v[0]});
		}
		
		
	}
	$(document).ready(function(){
		var pi={"pageNum":${list.pageNum},"pages":${list.pages}};
		paging("page-group", "pageInfoList", pi);
		
		$("input[name=check_all]").click(function(){
			$("input[name=check_name]").ischeck("check_all");
		});
		
		$("input[name=check_name]").change(function(){
			$("input[name=check_name]").smallchange("check_all");
		});
	});
</script>
</body>
</html>