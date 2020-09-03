<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử mua hàng </title>
</head>
<body>
	<main>
    <section class="container stylization maincont">
        <h1 class="main-ttl"><span>Lịch sử mua hàng </span></h1>
       <div class="pull-right">
		   <button class="btn btn-white btn-warning btn-bold" data-toggle="tolltip" title="Xóa khách  hàng" id="btnDeleteOrderCustomer">
				<i class="fa fa-trash" aria-hidden="true"></i>
		   </button>
		   <br/>					 
		</div>
		
        <div class="row">
            <div class="col-sm-12">
                <table id="orderList" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                        	<th></th>
                        	<th>Địa chỉ</th>
                        	<th>Tỉnh thành</th>
                        	<th>Quận huyện</th>
                        	<th>Phường xã</th>
                        	<th>Số điện thoại</th>
                            <th>Tổng giá trị</th>
                            <th>Số lượng </th>
                   			<th>Thao tác </th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${orders}">
                    <tr>
                            <td><input type="checkbox" value="${item.id}" id="check_box1"></td>
                            <td>${item.address}</td>
                            <td>${item.province} </td>
                            <td>${item.district} </td>
                            <td>${item.ward} </td>
                            <td>${item.phonenumber} </td>
                            <td>${item.totalPrice} VNĐ</td>
                            <td>${item.amount}</td>
                            <td><a href="/allstore/profile/detailorder?orderId=${item.id}">Chi tiết</a></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
    </section>
    <div id="confirmDeleteModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		  
			  <!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title" style="text-align: center;">Bạn có muốn xóa hay không ?</h4>
				</div>
				
				<div class="modal-footer" style="text-align: center;">
				  <button type="button" class="btn btn-danger" data-dismiss="modal" id="btnDeleteConfirmOrderCustomer">Xóa</button>
				  <button type="button" class="btn btn-info" data-dismiss="modal">Hủy</button>
				</div>
			  </div>
			</div>
	</div>
</main>
	
	<script src="<c:url value='/template/web/js/jquery-1.11.2.min.js' />"></script>
	<script src="<c:url value='/template/web/js/profilejs.js' />"></script>
</body>
</html>