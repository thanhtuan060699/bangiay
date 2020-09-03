<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký </title>
</head>
<body>
	<main>
    <section class="container stylization maincont">
        <h1 class="main-ttl"><span>Registration </span></h1>
        <div class="auth-wrap">
            <div class="auth-col">
             
                <form  action="" class="login form-horizontal"  id="formEdit">
               	  <p>
                        <label for="username">Họ và tên <span class="required">*</span></label>
                        <input type="text" id="fullname" name="fullname">
                    </p>
                    <p>
                        <label for="username">E-mail <span class="required">*</span></label>
                        <input type="text" id="email" name="email">
                    </p>
                    <p>
                        <label for="username">Tên tài khoản <span class="required">*</span></label>
                        <input type="text" id="username" name="username">
                    </p>
                    <p>
                        <label for="password">Mật khẩu <span class="required">*</span></label>
                        <input type="password" id="password" name="password">
                    </p>
                    <p>
                        <label for="confirmPassword">Xác nhận mật khẩu <span class="required">*</span></label>
                        <input type="password" id="confirmPassword"  name="confirmPassword">
                    </p>
                    <p class="auth-submit">
             
                         <button type="button" class="btn btn-primary customer-register" id="btnOrder">Đăng ký</button>
                       
                    </p>
                  
                </form>
            </div>
        </div>

    </section>
</main>
	<script src="<c:url value='/template/web/js/customer-register.js' />"></script>
</body>
</html>