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
		data["id"]=getUrlVars()["id"];
		var files=$(uploadImage)[0].files[0];
		
		if(files!=undefined){
			var reader=new FileReader();
			reader.onload=function(e){
				data["base64"]=e.target.result ;
				data["nameImage"]=files.name;
				$.ajax({
					url: "http://localhost:8080/api/sneaker",
					type: "PUT",
					data: JSON.stringify(data),
					contentType:"application/json",
				
					success: function (response) {
						if(response==1){
							alert('Save success');
							location.reload(true);
						}
						if(response==2){
							alert('The name of sneaker existed !!! Please change the name');
							
						}
							
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