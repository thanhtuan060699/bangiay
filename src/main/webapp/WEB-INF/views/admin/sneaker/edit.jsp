<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api-building"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Thêm giày</title>
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
								<a href="#">Quản lí giày</a>
							</li>
							<li class="active">Thêm giày</li>
						</ul><!-- /.breadcrumb -->
					</div>
					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<form action=""  class="form-horizontal" id="formEdit"
								enctype="multipart/form-data" >
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label no-padding-right">Tên giày</label>
										<div class="col-sm-8">
											<input type="text" id="name" class="form-control" name="name">
										</div>
									</div>
									<div class="form-group">
											<label for="structure" class="col-sm-3 control-label no-padding-right">Giá</label>
											<div class="col-sm-8">
												<input type="text" id="price" class="form-control" name="price">
											</div>
									</div>
					
									<div class="form-group">
											<label for="numberOfBasement" class="col-sm-3 control-label no-padding-right">Ảnh</label>
											<div class="col-sm-8">
												<input type="file" id="uploadImage" class="form-control" name="file">
											</div>
									</div>
									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"></label>
											<div class="col-sm-8">
										
											<button type="button" class="btn btn-primary">Hủy</button>
											<button type="button" class="btn btn-primary"  id="btnAddSneaker" > Thêm giày</button>
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