function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$('#btnAddListSneaker').click(function(){
					$.ajax({
						type: "GET",
						
						url: "http://localhost:8080/admin/sneaker/edit?brandSneakerId="+getUrlVars()["id"],
						success: function (response) {
							
						},
						error: function (response) {
							console.log('failed');
					
						}
						
					});
					console.log(getUrlVars()["id"]);
					
				});