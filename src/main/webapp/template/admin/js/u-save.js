$(btnAddUser).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	var role=$('#role').val();
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/api/admin/user",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			if(response==1){
				var message=document.getElementsByClassName('message')[0];
				message.innerHTML='<div class="alert alert-warning"> Username của bạn đã tồn tại !!! Vui lòng nhập username khác</div> ';
			}
			if(response==2)
			{
				alert('Đã tạo tài khoản thành công');
			}
			if(response==3){
				var message=document.getElementsByClassName('message')[0];
				message.innerHTML='<div class="alert alert-warning"> Mật khẩu xác nhận không chính xác !!! Vui lòng nhập lại</div> ';
			}
			
		},
		error: function (response) {
			console.log('failed');
			console.log(response.val);
		}
	});
	
})