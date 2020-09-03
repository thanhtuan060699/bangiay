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
							if(response==1){
								alert('Bạn đã thêm size thành công ');
								location.reload(true);
							}
							if(response==2){
								alert('Size của bạn đã tồn tại');
								location.reload(true);
							}
						},
						error: function (response) {
						
						}
					});
					
				});
$('#btnDeleteSize').click(function(e) {
	$('#confirmDeleteModal').modal();
	
});
$('#btnDeleteSizeSneaker').click(function(){
	var data = {};
	var sizeIds = $('#sizeList').find(
			'tbody input[type=checkbox]:checked').map(function() {
		return $(this).val();
	}).get();
	data['sizeIds'] = sizeIds;
	deleteSize(data);
})
function deleteSize(data) {
	
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api/sneaker/size",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			if(response==1){
				alert("Bạn đã xóa thành công");
				location.reload(true);
			}
		},
		
	});
	
	
}
