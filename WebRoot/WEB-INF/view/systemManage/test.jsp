<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板</title>
</head>
<body>
<!--main content start-->
<div class="site-min-height">
   <h3><i class="fa fa-angle-right"></i> Blank Page</h3>
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
          	         <thead></thead>
          	         <tbody></tbody>
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
<div class="modal fade" id="example" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
         <h4 class="modal-title" id="myModalLabel"></h4>
    </div>
    <div class="modal-body">
     <form id="form" class="form-horizontal style-form" method="post">
      <div class="form-group">
          <label class="col-sm-2 control-label">：</label>
          <div class="col-sm-8">
             <input id="" name=""  type="text"  class="form-control" placeholder="请输入">
          </div>
          <label class="col-sm-2 col-sm-2 control-label">*</label>
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

                <!-- <div>
                   <div class="form-group">
                    <div class="col-sm-5">
                      <input type="text" class="form-control" id="" placeholder="请输入按钮名称">
                    </div>
                    <div class="col-sm-5">
                      <input type="text" class="form-control" id="" placeholder="请输入按钮权限标识">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-5">
                      <input type="text" class="form-control" id="" placeholder="请输入按钮名称">
                    </div>
                    <div class="col-sm-5">
                      <input type="text" class="form-control" id="" placeholder="请输入按钮权限标识">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-5">
                      <input type="text" class="form-control" id="" placeholder="请输入按钮名称">
                    </div>
                    <div class="col-sm-5">
                      <input type="text" class="form-control" id="" placeholder="请输入按钮权限标识">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-5">
                      <input type="text" class="form-control" id="" placeholder="请输入按钮名称">
                    </div>
                    <div class="col-sm-5">
                      <input type="text" class="form-control" id="" placeholder="请输入按钮权限标识">
                    </div>
                  </div>
                 </div> -->
</body>
</html>