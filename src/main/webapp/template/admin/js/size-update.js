function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$('#btnUpdateSize').click(function(){
					var vars={};
					var data={};
					var formData=$('#formEdit').serializeArray();
					$.each(formData,function(index,v){
						data[""+v.name+""]=v.value;
					});
					data["id"]=getUrlVars()["id"];
					$.ajax({
						type: "PUT",
						url: "http://localhost:8080/api/sneaker/size",
						data: JSON.stringify(data),
						dataType: "json",
						contentType:"application/json",

						success: function (response) {
							if(response==1){
								alert('Cập nhật size thành công');
								location.reload(true);
							}
							else if(response==2){
								alert('Size giày đã tồn tại !!! Vui lòng nhập lại ');
							}
						},
						error: function (response) {
							console.log('failed');
							console.log(response);
							location.reload(true);
						}
					});
					
				});