<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api-building"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Thêm tòa nhà</title>
	</head>

	<body>
		<div class="main-content">
			<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="">Quản lí nhân sự</a>
							</li>
							<li class="active">Thêm nhân viên</li>
						</ul><!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<c:if test="${not empty message }">
							<div class="alert alert-danger">
								${message}
							</div>
						</c:if>
						<div class="row">
							<div class="col-xs-12">
								<form action="" role="form" class="form-horizontal" id="formEdit">
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label no-padding-right">Họ tên nhân viên</label>
										<div class="col-sm-8">
											<input type="text" id="fullname" class="form-control" name="fullname">
										</div>
									</div>
									
									<div class="form-group">
											<label for="ward" class="col-sm-3 control-label no-padding-right" >Tài khoản</label>
											<div class="col-sm-8">
												<input type="text" id="username" class="form-control" name="username">
											</div>
									</div>
									<div class="form-group">
											<label for="street" class="col-sm-3 control-label no-padding-right">Mật khẩu</label>
											<div class="col-sm-8">
												<input type="password" id="password" class="form-control" name="password">
											</div>
									</div>
									<div class="form-group">
											<label for="street" class="col-sm-3 control-label no-padding-right">Nhập lại mật khẩu</label>
											<div class="col-sm-8">
												<input type="password" id="confirmPassword" class="form-control" name="confirmPassword">
											</div>
									</div>
									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="district">Vai trò</label>
											<div class="col-sm-8">
												<select class="form-control" id="role" name="role">
													<option value="STAFF">Nhân viên</option>
													<option value="MANAGER">Quản lí</option>
																				
												</select>
											</div>
											
											
									</div>
									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"></label>
											<div class="col-sm-8">
											<button type="button" class="btn btn-primary" id="btnAddUser">Thêm người dùng</button>
											<button type="button" class="btn btn-primary">Hủy</button>
											</div>
									</div>
									
								</form>
							</div><!-- /.col -->
						</div><!-- /.row -->
					
			</div><!-- /.page-content -->
		</div>
		</div>
	</body>

	</html>