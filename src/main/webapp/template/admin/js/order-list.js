$('#btnDeleteOrder').click(function(e) {
	$('#confirmDeleteOredModal').modal();
	
});
$('#btnDeleteOrderSneaker').click(function(){
	var data = {};
	var sizeIds = $('#orderList').find(
			'tbody input[type=checkbox]:checked').map(function() {
		return $(this).val();
	}).get();
	data['orderIds'] = sizeIds;
	deleteOrder(data);
})
function deleteOrder(data) {
	
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api/admin/order",
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