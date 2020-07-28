document.addEventListener("DOMContentLoaded",function(){
	var cart_plus=document.getElementsByClassName("cart-plus");
      data={};
      console.log(cart_plus);
      for(var i=0;i<cart_plus.length;i++){
      
      cart_plus[i].onclick=function(){
        data["sneakerName"]=this.getAttribute("data-sneakerName");
        data["nameImage"]=this.getAttribute("data-imageName");
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/plus/amountcart",
            data: JSON.stringify(data),
            dataType: "json",
            contentType:"application/json",
            success: function (response) {
				console.log(response.sneakerName);
                var cart_sum=document.getElementsByClassName('cart-summ');
                for(var j=0;j<cart_sum.length;j++){
                    if(parseInt(cart_sum[j].getAttribute('data-cardId'))==response.idCard){
                        cart_sum[j].innerHTML="<b>"+response.totalOfEachSneaker +" VNĐ</b>";
                    }
                }
                var cart_amountC=document.getElementsByClassName('cart-amountC');
                for(var j=0;j<cart_amountC.length;j++){
                    if(parseInt(cart_amountC[j].getAttribute('data-cardId'))==response.idCard){
                        cart_amountC[j].setAttribute('value',response.amount);
                    }
                }
                
			},
			error: function (response) {
				console.log('failed');
				console.log(response.sneakerName);
				console.log(response);
			}
        });
    }
}
},false) 

document.addEventListener("DOMContentLoaded",function(){
	var cart_down=document.getElementsByClassName("cart-minus");
	  data={};
	  for(var i=0;i<cart_down.length;i++){
    cart_down[i].onclick=function(){
    	 data["sneakerName"]=this.getAttribute("data-sneakerName");
         data["nameImage"]=this.getAttribute("data-imageName");
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/down/amountcart",
            data: JSON.stringify(data),
            dataType: "json",
            contentType:"application/json",
            success: function (response) {
				console.log(response.sneakerName);
                var cart_sum=document.getElementsByClassName('cart-summ');
                for(var i=0;i<cart_sum.length;i++){
                    if(parseInt(cart_sum[i].getAttribute('data-cardId'))==response.idCard){
                        cart_sum[i].innerHTML="<b>"+response.totalOfEachSneaker +" VNĐ</b>";
                    }
                }
                var cart_amountC=document.getElementsByClassName('cart-amountC');
                for(var j=0;j<cart_amountC.length;j++){
                    if(parseInt(cart_amountC[j].getAttribute('data-cardId'))==response.idCard){
                        cart_amountC[j].setAttribute('value',response.amount);
                    }
                }
			},
			error: function (response) {
				console.log('failed');
				console.log(response.sneakerName);
				console.log(response);
			}
        });
       }
	  }
},false) 