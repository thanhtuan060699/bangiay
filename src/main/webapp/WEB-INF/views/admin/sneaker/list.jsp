<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
 <c:url var="userAPI" value="/api-user"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách giày</title>
	</head>

	<body>
		<div class="main-content">
			<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Quản lí thương hiệu giày</a>
							</li>
							<li class="active">Danh sách giày</li>
						</ul><!-- /.breadcrumb -->
					</div>

					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-xs-12 col-sm-12">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">Tìm Kiếm</h4>

													<div class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>
													</div>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														<div class="form-horizontal">
															<form action="${buildingURL}" method="get" id="formSearchBuilding">
															<div class="form-group">
																<div class="col-sm-4">
																	<label for="address">Tên giày</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
																<div class="col-sm-4">
																	<label for="address">Size nhỏ nhất</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
																<div class="col-sm-4">
																	<label for="address">Size lớn nhất</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
															</div>
															<div class="form-group">
																<div class="col-sm-4">
																	<label for="address">Số lượng từ</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
																<div class="col-sm-4">
																	<label for="address">Số lượng đến</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
															</div>
															<div class="form-group">
																<div class="col-sm-4">
																	<label for="address">Số tiền thấp nhất</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
																<div class="col-sm-4">
																	<label for="address">Số lượng cao nhất</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
															</div>
															<div class="form-group">
																	<div class="col-sm-8">
																			<button type="button" class="btn btn-primary" id="btnSearchBuilding">Tìm kiếm</button>
																	</div>		
															</div>
															<input type="hidden" value="LIST" name="action" />
														</form>
														</div>
													</div>
												</div>
											</div>
										</div>
								</div>
	
								</div><!-- /.row -->
								<div class="col-xs-12"> <!--  nut -->
									
										<div class="pull-right">
										<a  href='<c:url value='/admin/sneaker/edit?brandSneakerId=${id}'/>' class="btn btn-white btn-info btn-bold" data-toggle="tolltip" title="Thêm giày">
											<i class="fa fa-plus-circle" aria-hidden="true"></i>
										</a>
										
										<button class="btn btn-white btn-warning btn-bold" data-toggle="tolltip" title="Xóa giày" id="btnDeleteSneaker">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button>
										
										</div>
									
								</div>
					
								<div class="col-xs-12">
										<table id="sneakerList" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th >
												   </th>
													<th>Tên giày</th>
													<th>Giá tiền</th>
													<th>Ảnh</th>
													<th>Thao tác</th>
													
												</tr>
											</thead>
											<tbody>
											<c:forEach var="item" items="${sneakers}">
											<tr>
													<td><input type="checkbox" value="${item.id}" id="check_box1"></td>
													<td>${item.name}</td>
													<td>${item.price}</td>
													<td><img src="/usr/var/thumbnail/${item.nameImage}"  width="70" height="70"></td>
													
													<td>
													<a  href='<c:url value='/admin/sneaker/size/list?id=${item.id}'/>'> 
														<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Size giày"  >
															<i class="fa fa-plus-square-o" aria-hidden="true"></i>
														</button>
													</a>
													
														<a  href='<c:url value='/admin/sneaker/update?id=${item.id}'/>'>
															<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Cập nhật giày" >
															<i class="fa fa-pencil" aria-hidden="true"></i>
															</button>
														</a>
														
												
														
														
													</td>
												</tr>
											</c:forEach>			
											</tbody>
										</table>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
		</div>
		<div id="confirmDeleteModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		  
			  <!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title" style="text-align: center;">Bạn có muốn xóa hay không ?</h4>
				</div>
				
				<div class="modal-footer" style="text-align: center;">
				  <button type="button" class="btn btn-danger" data-dismiss="modal" id="btnConfirmDeleteSneaker">Xóa</button>
				  <button type="button" class="btn btn-info" data-dismiss="modal">Hủy</button>
				</div>
			  </div>
			</div>
		</div>
	<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
 	<script src="<c:url value='/template/admin/js/sneaker-delete.js' />"></script>
	</body>
	
	</html>