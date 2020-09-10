<%@page import="bandat.dto.SneakerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sneaker</title>
	</head>

	<body>
		<main>
    <section class="container">
	
		
       
        <!-- Latest news -->
        <div class="posts-wrap">
        	<%
        	List<SneakerDTO> sneakerDTOs=(List<SneakerDTO>)request.getAttribute("sneakers");
        	int i=0;
        	if(sneakerDTOs!=null){
    
        	while(i<sneakerDTOs.size()){ %>
            <div class="posts-list">
            	
                <div class="posts-i">
                    <a class="posts-i-img" href="/allstore/detailproduct?id=<%=sneakerDTOs.get(i).getId()%>">
                        <span style="background: url(/usr/var/thumbnail/<%=sneakerDTOs.get(i).getNameImage()%>)"></span>
                    </a>
                    <time class="posts-i-date" datetime="2016-11-09 00:00:00"><span>30</span> Jan</time>
                    <div class="posts-i-info">
                        <a href="" class="posts-i-ctg"><%=sneakerDTOs.get(i).getPrice()%> đ</a>
                        <h3 class="posts-i-ttl">
                            <a href="/allstore/detailproduct?id=<%=sneakerDTOs.get(i).getId()%>"><%=sneakerDTOs.get(i).getName() %></a>
                        </h3>
                    </div>
                </div>
              <%   i=i+1;
				if(i<sneakerDTOs.size()){ %>
              
                 <div class="posts-i">
                    <a class="posts-i-img" href="/allstore/detailproduct?id=<%=sneakerDTOs.get(i).getId()%>">
                        <span style="background: url(/usr/var/thumbnail/<%=sneakerDTOs.get(i).getNameImage()%>)"></span>
                    </a>
                    <time class="posts-i-date" datetime="2016-11-09 00:00:00"><span>30</span> Jan</time>
                    <div class="posts-i-info">
                        <a href="" class="posts-i-ctg"><%=sneakerDTOs.get(i).getPrice()%> đ</a>
                        <h3 class="posts-i-ttl">
                            <a href="/allstore/detailproduct?id=<%=sneakerDTOs.get(i).getId()%>"><%=sneakerDTOs.get(i).getName() %></a>
                        </h3>
                    </div>
                </div>
        		<%} %>
                <%  
                i=i+1;
				if(i<sneakerDTOs.size()){ %>
                 <div class="posts-i">
                    <a class="posts-i-img" href="/allstore/detailproduct?id=<%=sneakerDTOs.get(i).getId()%>">
                        <span style="background: url(/usr/var/thumbnail/<%=sneakerDTOs.get(i).getNameImage()%>)"></span>
                    </a>
                    <time class="posts-i-date" datetime="2016-11-09 00:00:00"><span>30</span> Jan</time>
                    <div class="posts-i-info">
                        <a href="" class="posts-i-ctg"><%=sneakerDTOs.get(i).getPrice()%> đ</a>
                        <h3 class="posts-i-ttl">
                            <a href="/allstore/detailproduct?id=<%=sneakerDTOs.get(i).getId()%>"><%=sneakerDTOs.get(i).getName() %></a>
                        </h3>
                    </div>
                </div>
               <%}
				i=i+1;
				%>
               
            </div>
            <%}} %>
            
        </div>
        <c:if test="${not empty listempty }">
        <div >
        	<p style="font-size: 20px;font-weight: bold;text-align: center;">Hiện tại chưa có sản phẩm</p>
        	<br/>
        	<br/>
        </div>

		</c:if>
        <!-- Testimonials -->
      
        <!-- Quick View Product - start -->
      
    </section>
</main>
	</body>

	</html>