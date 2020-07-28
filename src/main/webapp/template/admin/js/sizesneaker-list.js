function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$('#btnAddSize').click(function(){
					var vars={};
					var data={};
					var formData=$('#formEdit').serializeArray();
					$.each(formData,function(index,v){
						data[""+v.name+""]=v.value;
					});
					data["sneakerId"]=getUrlVars()["id"];
					$.ajax({
						type: "POST",
						url: "http://localhost:8080/api/sneaker/size",
						data: JSON.stringify(data),
						dataType: "json",
						contentType:"application/json",

						success: function (response) {
							
						},
						error: function (response) {
							console.log('failed');
							console.log(response);
							location.reload(true);
						}
					});
					location.reload(true);
				});