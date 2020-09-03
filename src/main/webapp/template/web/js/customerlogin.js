document.addEventListener("DOMContentLoaded",function(){
	 var login=document.getElementsByClassName('customer-login')[0];
	 login.onclick=function(){
			var data={};
			var formData=$('#formEdit').serializeArray();
			$.each(formData,function(index,v){
				data[""+v.name+""]=v.value;
			});
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/customer/login",
				data: JSON.stringify(data),
				dataType: "json",
				contentType:"application/json",

				success: function (response) {
					if(response==1)
						{
						alert("Thông tin đăng nhập không chính xác");
				
						}
					if(response==2)
					{
					
					window.location.href="/allstore/trangchu";
					}
					if(response==3)
					{
						alert("Thông tin đăng nhập không chính xác");
					}
						
					
				},
				error: function (response) {
					console.log('failed');
					console.log(response);
				}
			});
	 }
},false)