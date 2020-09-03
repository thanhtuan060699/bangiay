function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$('#btnUpdateBrand').click(function(){
					var vars={};
					var data={};
					var formData=$('#formEdit').serializeArray();
					$.each(formData,function(index,v){
						data[""+v.name+""]=v.value;
					});
					data["id"]=getUrlVars()["id"];
					$.ajax({
						type: "PUT",
						url: "http://localhost:8080/api/brandsneaker",
						data: JSON.stringify(data),
						dataType: "json",
						contentType:"application/json",

						success: function (response) {
							if(response==1){
								alert('Cập nhật thương hiệu giày thành công');
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