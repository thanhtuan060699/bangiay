function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$(btnAddSneaker).click(function () { 

		var data={};
		var formData=$('#formEdit').serializeArray();
		$.each(formData,function(index,v){
			data[""+v.name+""]=v.value;
		});
		data["brandSneakerId"]=getUrlVars()["brandSneakerId"];
		var files=$(uploadImage)[0].files[0];
		
		if(files!=undefined){
			var reader=new FileReader();
			reader.onload=function(e){
				data["base64"]=e.target.result ;
				data["nameImage"]=files.name;
				$.ajax({
					url: "http://localhost:8080/api/sneaker",
					type: "POST",
					data: JSON.stringify(data),
					contentType:"application/json",
				
					success: function (response) {
						console.log('success');
							
					},
					error: function (response) {
						console.log('failed');
						console.log(response);
					}
					});
			}
	
			reader.readAsDataURL(files);
			
		}
      
    
});