$('#btnAddBrand').click(function(){
					var vars={};
					var data={};
					var formData=$('#formEdit').serializeArray();
					$.each(formData,function(index,v){
						data[""+v.name+""]=v.value;
					});
					$.ajax({
						type: "POST",
						url: "http://localhost:8080/api/brandsneaker",
						data: JSON.stringify(data),
						dataType: "json",
						contentType:"application/json",

						success: function (response) {
							if(response==1){
								alert('Thêm thương hiệu giày thành công');
								location.reload(true);
							}
							else if(response==2){
								alert('Thương hiệu giày đã tồn tại ');
							}
						},
						error: function (response) {
							console.log('failed');
							console.log(response);
							location.reload(true);
						}
					});
					
				});