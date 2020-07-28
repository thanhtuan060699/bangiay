function showSneaker(brandId){
    var data = {};
    data['id'] = brandId;
    $.ajax({
		type : "POST",
		url : "http://localhost:8080/api/customer/sneaker",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			var  html= '';
			
					
				html+=response;
				html+= ' ttt ';
		
			$('.thu').html(html);
		},
		error : function(response) {
			$.each(response,function(key,values){
			var  html= '';
			
			
			html+=response.id;
			html+= ' ttt ';
	
		$('.thu').html(response);
			})
		}
	});
}