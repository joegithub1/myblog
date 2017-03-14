<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
</head>
<body>
<section id="container" >
 <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
	                  	  	  <h4><i class="fa fa-angle-right"></i>权限列表</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th>角色名称</th>
								  <th>备注</th>
								  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${roles.list }" var="role">
					<tr>
						<td>${role.roleName}</td>
						<td>${role.roleRemark}</td>
						<td>
							<a id="modal" onclick="giveAuth(${role.roleId})" href="#modal-container1" role="button" class="gym_authmanage_giverole" data-toggle="modal">分配权限</a>
							<a id="modal" onclick="getRoleinfo(${role.roleId},'${role.roleName}','${role.roleRemark}',${role.roleIsclose})" href="#modal-container0" role="button" class="gym_authmanage_giverole" data-toggle="modal">修改</a>
							<a href="javascript:void(0)" class="gym_authmanage_del" onclick="delRole(${role.roleId},'${role.roleName}')">删除</a>
							
							<button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                            <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                            <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
							
							
	                       </td>
					</tr>
				</c:forEach>
                              <tr>
                                  <td><a href="basic_table.html#">Company Ltd</a></td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>12000.00$ </td>
                                  <td><span class="label label-info label-mini">Due</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Dashgum co
                                      </a>
                                  </td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>17900.00$ </td>
                                  <td><span class="label label-warning label-mini">Due</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Another Co
                                      </a>
                                  </td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>14400.00$ </td>
                                  <td><span class="label label-success label-mini">Paid</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Dashgum ext
                                      </a>
                                  </td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>22000.50$ </td>
                                  <td><span class="label label-success label-mini">Paid</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td><a href="basic_table.html#">Total Ltd</a></td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>12120.00$ </td>
                                  <td><span class="label label-warning label-mini">Due</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                      </div><!-- /content-panel -->
                      
                      
                      <! -- BUTTONS NESTING -->
      				<div class="showback">
      					
						<div class="btn-group">
						  <button type="button" class="btn btn-theme">Theme</button>
						  <button type="button" class="btn btn-success">1</button>
						  <button type="button" class="btn btn-default">2</button>
						  <button type="button" class="btn btn-theme">Theme</button>
						</div>      					
      				</div><!-- /showback --> 
                  </div><!-- /col-md-12 -->
              </div><!-- /row -->
      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is 權限管理
              <a href="#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
</section>

</body>
</html>