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
            <div class="col-sm-12 infoCustomer">Thông tin khách hàng</div>
        </div>
        <div class="row">
            <div class="col-sm-8">
                <form action="" role="form" class="form-horizontal" id="formEdit">
                    <div class="form-group info">
                        <div class="col-sm-8">
                        <input type="text" id="email" class="form-control" name="email" placeholder="Email" value="${customerInfo.email}">
                        </div>
                    </div>
                    
                    <div class="form-group info">

                        <div class="col-sm-8">
                            <input type="text" id="fullname" class="form-control" name="fullname" placeholder="Họ và tên" 
                            value="${customerInfo.fullname}">
                        </div>
                    </div>
                    <div class="form-group info">
                            <div class="col-sm-8">
                                <input type="text" id="phonenumber" class="form-control" name="phonenumber" placeholder="Số điện thoại"
                                value="${customerInfo.phonenumber}">
                            </div>
                    </div>
                    <div class="form-group info">
                            <div class="col-sm-8">
                                <input type="text" id="address" class="form-control" name="address" placeholder="Địa chỉ"
                                value="${customerInfo.address}">
                            </div>
                    </div>
                    <div class="form-group info">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-8">
                            <button type="button" class="btn btn-primary" id="btnChangeInformation">Chỉnh sửa thông tin</button>
                            
                            </div>
                    </div>
                    
                </form>
            </div>
           
        </div>
    </div>
</main>
	<script src="<c:url value='/template/web/js/jquery-1.11.2.min.js' />"></script>
	<script src="<c:url value='/template/web/js/customerinfoupdate.js' />"></script>

</body>
</html>