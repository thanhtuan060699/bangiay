$('#btnDeleteSneaker').click(function(e) {
	$('#confirmDeleteModal').modal();
	
});
$('#btnConfirmDeleteSneaker').click(function(){
	var data = {};
	var sneakerIds = $('#sneakerList').find(
			'tbody input[type=checkbox]:checked').map(function() {
		return $(this).val();
	}).get();
	data['sneakerIds'] = sneakerIds;
	deleteSneaker(data);
})
function deleteSneaker(data) {
	
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api/sneaker",
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
