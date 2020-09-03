<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký </title>
</head>
<body>
	<main>
    <section class="container stylization maincont">
        <h1 class="main-ttl"><span>Chi tiết đơn hàng </span></h1>
       
        <div class="row">
            <div class="col-sm-12">
                <table id="buildingList" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                   
                            <th>Sản phẩm</th>
                            <th>Giá trị </th>
                            <th>Số lượng </th>
                            <th>Size</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${detail}">
                    <tr>
                           
                            <td>${item.sneakerName}</td>
                            <td>${item.price} VNĐ</td>
                            <td>${item.amount}</td>
                            <td>${item.size}</td>
                           
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
    </section>
</main>
	
</body>
</html>