<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập </title>
</head>
<body>
	<main>
    <section class="container stylization maincont">
        <h1 class="main-ttl"><span>Login </span></h1>
        <div class="auth-wrap">
            <div class="auth-col">
             
                <form  action="" class="login form-horizontal"  id="formEdit">
                    <p>
                        <label for="username">Tên tài khoản <span class="required">*</span></label>
                        <input type="text" id="username" name="username">
                    </p>
                    <p>
                        <label for="password">Mật khẩu <span class="required">*</span></label>
                        <input type="password" id="password" name="password" >
                    </p>
                 
                    <p class="auth-submit">
             
                         <button type="button" class="btn btn-primary customer-login" id="btnCustomerLogin">Đăng nhập</button>
                       
                    </p>
                  
                </form>
            </div>
        </div>


	
    </section>
</main>
	<script src="<c:url value='/template/web/js/customerlogin.js' />"></script>
</body>
</html>