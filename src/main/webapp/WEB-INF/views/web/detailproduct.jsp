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
							<div class="prod-add">Add to card</div>
						</p>
						<input type="hidden" id="sneakerId" name="sneakerId" value="${sneaker.id}">
					</div>
				</div>
				
			</div>

			<!-- Product Tabs -->
			

		</div>
		<!-- Single Product - end -->

		<!-- Related Products - start -->
		<div class="prod-related">
			<h2><span>Related products</span></h2>
			<div class="prod-related-car" id="prod-related-car">
				<ul class="slides">
					<li class="prod-rel-wrap">
						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/300x311" alt="Adipisci aperiam commodi">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Adipisci aperiam commodi</a></h3>
								<p class="prod-rel-price">
									<b>$59</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>

						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/370x300" alt="Dignissimos eaque earum">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Dignissimos eaque earum</a></h3>
								<p class="prod-rel-price">
									<b>$37</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>



						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/300x345" alt="Porro quae quasi">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Porro quae quasi</a></h3>
								<p class="prod-rel-price">
									<b>$85</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>

					</li>
					<li class="prod-rel-wrap">
						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/378x300" alt="Sunt temporibus velit">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Sunt temporibus velit</a></h3>
								<p class="prod-rel-price">
									<b>$115</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>



						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/300x394" alt="Harum illum incidunt">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Harum illum incidunt</a></h3>
								<p class="prod-rel-price">
									<b>$130</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>



						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/300x303" alt="Reprehenderit rerum">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Reprehenderit rerum</a></h3>
								<p class="prod-rel-price">
									<b>$210</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>



						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/300x588" alt="Quae quasi adipisci alias">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Quae quasi adipisci alias</a></h3>
								<p class="prod-rel-price">
									<b>$85</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>

					</li>
					<li class="prod-rel-wrap">
						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/300x416" alt="Maxime molestias necessitatibus nobis">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Maxime molestias necessitatibus nobis</a></h3>
								<p class="prod-rel-price">
									<b>$95</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>



						<div class="prod-rel">
							<a href="product.html" class="prod-rel-img">
								<img src="http://placehold.it/300x480" alt="Facilis illum">
							</a>
							<div class="prod-rel-cont">
								<h3><a href="product.html">Facilis illum</a></h3>
								<p class="prod-rel-price">
									<b>$150</b>
								</p>
								<div class="prod-rel-actions">
									<a title="Wishlist" href="#" class="prod-rel-favorites"><i class="fa fa-heart"></i></a>
									<a title="Compare" href="#" class="prod-rel-compare"><i class="fa fa-bar-chart"></i></a>
									<p class="prod-i-addwrap">
										<a title="Add to cart" href="#" class="prod-i-add"><i class="fa fa-shopping-cart"></i></a>
									</p>
								</div>
							</div>
						</div>

					</li>
				</ul>
			</div>
		</div>
		<!-- Related Products - end -->

	</section>
</main>
	<script src="<c:url value='/template/web/js/productdetail.js' />"></script>
	</body>

	</html>
	