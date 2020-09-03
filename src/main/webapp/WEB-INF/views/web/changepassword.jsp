<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi mật khẩu </title>
</head>
<body>
	<main>
    <section class="container stylization maincont">
        <h1 class="main-ttl"><span>Thay đổi mật khẩu </span></h1>
        <div class="auth-wrap">
            <div class="auth-col">
             
                <form  action="" class="login form-horizontal"  id="formEdit">
                   <p>
                        <label for="password">Mật khẩu cũ <span class="required">*</span></label>
                        <input type="password" id="oldPassword" name="oldPassword">
                    </p>
                    <p>
                        <label for="password">Mật khẩu mới <span class="required">*</span></label>
                        <input type="password" id="password" name="password">
                    </p>
                    <p>
                        <label for="confirmPassword">Xác nhận mật khẩu  <span class="required">*</span></label>
                        <input type="password" id="confirmPassword"  name="confirmPassword">
                    </p>
                    <p class="auth-submit">
             
                         <button type="button" class="btn btn-primary customer-register" id="btnChangePassword">Đổi mật khẩu</button>
                       
                    </p>
                  
                </form>
            </div>
        </div>



    </section>
</main>
	<script src="<c:url value='/template/web/js/jquery-1.11.2.min.js' />"></script>
	<script src="<c:url value='/template/web/js/changepassword.js' />"></script>
</body>

</html>