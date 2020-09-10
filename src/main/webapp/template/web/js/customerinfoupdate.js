$('#btnChangeInformation').click(function(){
					var vars={};
					var data={};
					var formData=$('#formEdit').serializeArray();
					$.each(formData,function(index,v){
						data[""+v.name+""]=v.value;
					});
					$.ajax({
						type: "PUT",
						url: "http://localhost:8080/api/customer/information",
						data: JSON.stringify(data),
						dataType: "json",
						contentType:"application/json",

						success: function (response) {
							if(response==1){
								alert('Cập nhật thông tin thành công ');
								location.reload(true);
							}
							
						},
						error: function (response) {
							console.log('failed');
							console.log(response);
							location.reload(true);
						}
					});
					
				});