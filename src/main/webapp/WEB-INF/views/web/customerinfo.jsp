<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân </title>
</head>
<body>
	<main>
    <section class="container stylization maincont">
        <h1 class="main-ttl"><span>Thông tin cá nhân </span></h1>
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                <div class="customer-info">
                    <div class="row">
                        <div class="col-sm-12 info-title">
                            Thông tin khách hàng
                        </div>
                    </div>
                    <div class="customer-detail">
                        <div class="row">
                            <div class="col-sm-2 info-detail">Họ và tên </div>
                            <div class="col-sm-5 info-detail">${customerInfo.fullname }</div>
                            <div class="col-sm-2 info-detail">Số điện thoại</div>
                            <div class="col-sm-3 info-detail"></div>
    
                        </div>
                        <div class="row">
                            <div class="col-sm-2 info-detail">Địa chỉ</div>
                            <div class="col-sm-5 info-detail">Số 5 Kiệt 1 Đường Quảng Tế</div>
                            <div class="col-sm-2 info-detail">Tỉnh thành</div>
                            <div class="col-sm-3 info-detail">Thừa Thiên Huế</div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2 info-detail">Email</div>
                            <div class="col-sm-10 info-detail">nguyenthanhhlal123@gmail.com</div>
                        </div>
                        <div class="row">
                            
                            <div class="col-sm-2 info-detail">Quận Huyện</div>
                            <div class="col-sm-4 info-detail">A Lưới</div>
                            <div class="col-sm-2 info-detail">Phường Xã</div>
                            <div class="col-sm-4 info-detail">Trường An</div>
                        </div>
                        <div class="row ">
                        <button type="button" class="btn btn-info cus-update">Update thông tin</button>
                        </div>
                    </div>
                    </div>
                   
                
            </div>
        </div>
    </section>
</main>
	
</body>
</html>