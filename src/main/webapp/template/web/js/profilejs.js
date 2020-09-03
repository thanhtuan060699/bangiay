$('#btnDeleteOrderCustomer').click(function(e) {
	$('#confirmDeleteModal').modal();
	
});
$('#btnDeleteConfirmOrderCustomer').click(function(){
	var data = {};
	var orderIds = $('#orderList').find(
			'tbody input[type=checkbox]:checked').map(function() {
		return $(this).val();
	}).get();
	data['orderIds'] = orderIds;
	deleteSize(data);
})
function deleteSize(data) {
	
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api/customer/order",
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