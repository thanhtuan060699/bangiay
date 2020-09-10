<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
 <c:url var="customerURL" value="/admin-customer"/>
 <c:url var="userAPI" value="/api-user"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách đơn hàng</title>
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
								<a href="#">Danh sách đơn hàng</a>
							</li>
							
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
															<form action="${customerURL}" method="get" id="formSearchUser">
															<div class="form-group">
																<div class="col-sm-4">
																	<label for="name">Tên người dùng </label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
																<div class="col-sm-4">
																	<label for="numberPhone">Username</label>
																	<input type="text" id="phoneNumber" class="form-control" name="phoneNumber">
																</div>
																<div class="col-sm-4">
																	<label for="numberOfBasement">Địa chỉ</label>
																	<input type="text" id="address" class="form-control" name="address">
																</div>
															</div>
															
															<div class="form-group">
																	<div class="col-sm-8">
																	<c:forEach var="item" items="${buildingTypes}" >
																		<label class="checkbox-inline">
																		
																		</label>
																	</c:forEach>									
																	</div>
															</div>
															<div class="form-group">
																	<div class="col-sm-8">
																			<button type="button" class="btn btn-primary" id="btnSearchCustomer">Tìm kiếm</button>
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
										<c:if test="${not empty role }">
										<a  href='<c:url value='/admin-user?signal=EDIT'/>' class="btn btn-white btn-info btn-bold" data-toggle="tolltip" title="Thêm khách hàng">
											<i class="fa fa-plus-circle" aria-hidden="true"></i>
										</a>
										
										
										</c:if>
										<button class="btn btn-white btn-warning btn-bold" data-toggle="tolltip" title="Xóa đơn hàng" id="btnDeleteOrder">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button>
									
									</div>
									
								</div>
					
								<div class="col-xs-12">
										<table id="orderList" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th >
												   </th>
													<th>Họ tên</th>
													<th>Tài khoản</th>
													<th>Địa chỉ</th>
													<th>Tỉnh thành</th>
													<th>Quận huyện</th>
													<th>Phường xã</th>
													<th>Tổng giá trị đơn</th>
													<th>Số điện thoại</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="item" items="${orders}">
											<tr>
													<td><input type="checkbox" value="${item.id}" id="check_box1"></td>
													<td>${item.customerName}</td>
													<td>${item.customerUsername}</td>
													<td>${item.address}</td>
													<td>${item.province}</td>
													<td>${item.district}</td>
													<td>${item.ward}</td>
													<td>${item.totalPrice}</td>
													<td>${item.phonenumber}</td>
													<td>
														<a href="/admin/orderdetail/list?orderId=${item.id}">Chi tiết</a>
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
		<div id="confirmDeleteOredModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		  
			  <!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title" style="text-align: center;">Bạn có muốn xóa hay không ?</h4>
				</div>
				
				<div class="modal-footer" style="text-align: center;">
				  <button type="button" class="btn btn-danger" data-dismiss="modal" id="btnDeleteOrderSneaker">Xóa</button>
				  <button type="button" class="btn btn-info" data-dismiss="modal">Hủy</button>
				</div>
			  </div>
			</div>
		</div>
	</body>

	</html>