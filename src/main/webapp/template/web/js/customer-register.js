document.addEventListener("DOMContentLoaded",function(){
	 var register=document.getElementsByClassName('customer-register')[0];
	 register.onclick=function(){
			var data={};
			var formData=$('#formEdit').serializeArray();
			$.each(formData,function(index,v){
				data[""+v.name+""]=v.value;
			});
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/register",
				data: JSON.stringify(data),
				dataType: "json",
				contentType:"application/json",

				success: function (response) {
					if(response==1)
						{
						alert("You register successfull");
						window.location.href="/allstore/trangchu";
						}
					if(response==2)
					{
					alert("Wrong confirm password");
				
					}
					if(response==3)
					{
					alert("Tên đăng nhập đã tồn tại");
				
					}
					if(response==4)
					{
					alert("Email đã tồn tại");
				
					}
					if(response==5)
					{
					alert("Thiếu thông tin đăng ký !! Làm ơn kiểm tra");
				
					}
						
					
				},
				error: function (response) {
					console.log('failed');
					console.log(response);
				}
			});
	 }
},false)