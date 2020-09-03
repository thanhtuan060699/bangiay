function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$(btnPasswordUser).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/api/user/changepassword",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			console.log(response);
			if(response==1){
				alert("Mật khẩu xác nhận không trùng với mật khẩu !!! Hãy nhập lại");
			}
			else if(response==2){
				alert("Mật khẩu cũ sai !!! Vui lòng nhập lại ");
				
			}else if(response==3){
				alert("Thay đổi mật khẩu thành công !!! Vui lòng đăng nhập lại ");
			}else if(response==4){
				window.location.href="/homework/admin-user?signal=PASSWORD&message=samepassword";
			}
			else if(response==5){
				alert("Thay đổi mật khẩu thành công");
				window.location.href="/homework/admin-user?action=LIST";
			}
		},
		error: function (response) {
			console.log('failed');
			console.log(response.value);
		}
	});
	
})