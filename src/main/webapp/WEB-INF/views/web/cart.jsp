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
    <section class="container stylization maincont">


        <ul class="b-crumbs">
            <li>
                <a href="index.html">
                    Home
                </a>
            </li>
            <li>
                <span>Cart</span>
            </li>
        </ul>
        <h1 class="main-ttl"><span>Cart</span></h1>
        <!-- Cart Items - start -->
        <form action="#">

            <div class="cart-items-wrap">
                <table class="cart-items">
                    <thead>
                    <tr>
                        <td class="cart-image">Ảnh sản phẩm</td>
                        <td class="cart-ttl">Thông tin</td>
                        <td class="cart-price">Giá</td>
                        <td class="cart-quantity">Số lượng</td>
                        <td class="cart-summ">Thành tiền</td>
                        <td class="cart-del">&nbsp;</td>
                    </tr>
                    </thead>
                    <tbody>
                    <div class="repeat" data-sneakerRepeat="${repeatId}"></div>
                    <c:forEach var="item" items="${carts}">
                   
                    <tr class="cart-sneaker" data-sneakerId="${item.sneakerId}">
       
                        <td class="cart-image" >
                            <img src="/usr/var/thumbnail/${item.nameImage}" alt="Quod soluta corrupti">
                        </td>
                        <td class="cart-ttl">
                            <a href="product.html">${item.sneakerName}</a>
                            <p>Size : ${item.size}</p>
                        </td>
                        <td class="cart-price">
                            <b>${item.price} VNĐ</b>
                        </td>
                        
                        <td class="cart-quantity">
                            <div class="cart-qnt"> 
                                <input class="cart-amountC" data-cardId="${item.idCard}" value="${item.amount} " type="text">
                                <div class="cart-plus" data-sneakerName="${item.sneakerName}"
                                data-imageName="${item.nameImage}"><i class="fa fa-angle-up"></i>
                                </div>
                            
                                <div class="cart-minus" data-sneakerName="${item.sneakerName}"
                                data-imageName="${item.nameImage}"><i class="fa fa-angle-down"></i></div>
                                
							</div>
                        </td>
                        <td class="cart-summ" data-cardId="${item.idCard}">
                            <b >${item.totalOfEachSneaker} VNĐ</b>
                            
                        </td>
                        <td class="cart-del">
                            <a href="#" class="cart-remove"></a>
                        </td>
                     
                    </tr>
                   
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <ul class="cart-total">
                <li class="cart-summ cart-total1">Tổng tiền: <b>${totalPrice} VNĐ</b></li>
            </ul>
            <div class="cart-submit">
                <a href="/allstore/checkout" class="cart-submit-btn">Checkout</a>
                <a href="#" class="cart-clear">Clear cart</a>
            </div>
        </form>
        <!-- Cart Items - end -->

    </section>
</main>
<!-- Main Content - end -->
	<script src="<c:url value='/template/web/js/jquery-1.11.2.min.js' />"></script>
	<script src="<c:url value='/template/web/js/cart.js' />"></script>
	
	</body>
	</html>