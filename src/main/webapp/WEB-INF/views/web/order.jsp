<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Trang chủ</title>
	</head>
<body>
	<main>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 infoCustomer">Thông tin mua hàng</div>
        </div>
        <div class="row">
            <div class="col-sm-8">
                <form action="" role="form" class="form-horizontal" id="formEdit">
                    <div class="form-group info">
                        <div class="col-sm-8">
                            <input type="text" id="email" class="form-control" name="email" placeholder="Email">
                        </div>
                    </div>
                    
                    <div class="form-group info">

                        <div class="col-sm-8">
                            <input type="text" id="name" class="form-control" name="name" placeholder="Họ và tên">
                        </div>
                    </div>
                    <div class="form-group info">
                            <div class="col-sm-8">
                                <input type="text" id="phoneNumber" class="form-control" name="phoneNumber" placeholder="Số điện thoại">
                            </div>
                    </div>
                    <div class="form-group info">
                            <div class="col-sm-8">
                                <input type="text" id="address" class="form-control" name="address" placeholder="Địa chỉ">
                            </div>
                    </div>

                    <div class="form-group info">
                        <div class="col-sm-8">
                            <select class="form-control" id="province" name="province " onchange="changeFunc();">
                                <option value="" selected>----</option>
                                                            
                            </select>
                        </div>     
                    </div>
                    <div class="form-group info">
                        <div class="col-sm-8">
                            <select class="form-control" id="district" name="district " onchange="changeFuncDistrict();">
                                <option value="" selected>Quận huyện</option>
                                                            
                            </select>
                        </div>     
                    </div>
                     <div class="form-group info">
                        <div class="col-sm-8">
                            <select class="form-control" id="ward" name="ward " aria-placeholder="Quận huyện">
                                <option value="" selected>Phường xã</option>
                                                            
                            </select>
                        </div>     
                    </div>
                    <div class="form-group info">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-8">
                            <button type="button" class="btn btn-primary" id="btnOrder">Đặt hàng</button>
                            
                            </div>
                    </div>
                    
                </form>
            </div>
            <div class="col-sm-4 info-order">
                <div class="row">
                    <div class="col-sm-12 info-order-amount">Đơn hàng(1 sản phẩm)</div>
                </div>
                <c:forEach var="item" items="${sneakersCart}">
                <div class="row">
                    <div class="col-sm-7 info-order-sneaker">
                        <div class="info-order-sneaker-name">${item.sneakerName}</div>
                        <div class="info-order-sneaker-size">Size ${item.size} VN Số lượng ${item.amount}</div>
                    </div>
                    <div class="col-sm-5 info-order-sneaker-price">${item.totalOfEachSneaker} VNĐ</div>
                </div>
                </c:forEach>
                
            </div>
        </div>
    </div>
</main>
	<script src="<c:url value='/template/web/js/order.js' />"></script>
</body>
</html>