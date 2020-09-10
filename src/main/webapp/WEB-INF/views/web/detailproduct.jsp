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
	<section class="container">

		<h1 class="main-ttl" data-sneakername="${sneaker.name }"><span>${sneaker.name }</span></h1>
		<!-- Single Product - start -->
		<div class="prod-wrap">

			<!-- Product Images -->
			<div class="prod-slider-wrap">
				<div class="prod-slider">
					<ul class="prod-slider-car" data-image="${sneaker.nameImage}">
						<li>
							
								<img src="/usr/var/thumbnail/${sneaker.nameImage}" alt="">
						
						</li>
					</ul>
				</div>
			</div>

			<!-- Product Description/Info -->
			<div class="prod-cont">
				<div class="row">
					<div class="prod-cont-txt">
						<b style="font-size:20px">Hãng : ${brand.name}</b>
					</div>
				</div>
				<div class="row">
					<div class="prod-cont-sizes" >
						<c:forEach var="item" items="${sizes}">
						<div class="prod-cont-size" data-size="${item.size}" data-amount="${item.amount}">
							<a>Size ${item.size} VN Số lượng ${item.amount}</a>
						</div>
						</c:forEach>
					</div>
				</div>
				<div class="row">
					<div class="prod-info">
						<p class="prod-price" data-price="${sneaker.price }">
							<b class="item_current_price">${sneaker.price} VNĐ</b>
						</p>
						<p class="prod-qnt">
							<input value=1 type="number" class="amount">
							<a href="#" class="prod-plus"><i class="fa fa-angle-up"></i></a>
							<a href="#" class="prod-minus"><i class="fa fa-angle-down"></i></a>
						</p>
						<p class="prod-addwrap">
							<div class="prod-add">Mua</div>
						</p>
						<input type="hidden" id="sneakerId" name="sneakerId" value="${sneaker.id}">
					</div>
				</div>
				
			</div>

			<!-- Product Tabs -->
			

		</div>
		<!-- Single Product - end -->

		<!-- Related Products - start -->
		
		<!-- Related Products - end -->

	</section>
</main>
	<script src="<c:url value='/template/web/js/productdetail.js' />"></script>
	</body>

	</html>
	