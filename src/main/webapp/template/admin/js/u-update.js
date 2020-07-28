function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$(btnUpdateUser).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	data['id']=getUrlVars()["id"];
	var role=$('#role').val();
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/homework/api-user",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			console.log(response);
			if(response==1){
				window.location.href="/homework/admin-user?signal=UPDATE&message=previouspassword";
			}
			else if(response=="cofirm"){
				window.location.href="/homework/admin-user?signal=UPDATE&message=confirmpassword";
			}
			else{
				window.location.href="/homework/admin-user?action=LIST"
			}
		},
		error: function (response) {
			console.log('failed');
			console.log(response.value);
		}
	});
	
})