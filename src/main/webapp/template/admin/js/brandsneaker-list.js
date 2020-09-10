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
$('#btnDeleteBrandSneaker').click(function(){
	var sizeIds = $('#brandList').find(
		'tbody input[type=checkbox]:checked').map(function() {
	return $(this).val();
	}).get();
	if(sizeIds.length!=0){
		$('#deleteBrandSneakerModal').modal();
	}
})

$('#btnDeleteBrandCofirm').click(function(){
	var data = {};
	var brandIds = $('#brandList').find(
			'tbody input[type=checkbox]:checked').map(function() {
		return $(this).val();
	}).get();
	data['brandIds'] = brandIds;
	deleteBrand(data);
})
function deleteBrand(data) {
	
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api/brandsneaker",
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