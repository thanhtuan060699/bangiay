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

				console.log(response["totalPrice"]);
				console.log(response["cartDTO"].idCard);
                var cart_sum=document.getElementsByClassName('cart-summ');
                for(var j=0;j<cart_sum.length;j++){
                    if(parseInt(cart_sum[j].getAttribute('data-cardId'))==response["cartDTO"].idCard){
                        cart_sum[j].innerHTML="<b>"+response["cartDTO"].totalOfEachSneaker +" VNĐ</b>";
                    }
                }
                var cart_amountC=document.getElementsByClassName('cart-amountC');
                for(var j=0;j<cart_amountC.length;j++){
                    if(parseInt(cart_amountC[j].getAttribute('data-cardId'))==response["cartDTO"].idCard){
                        cart_amountC[j].setAttribute('value',response["cartDTO"].amount);
                    }
                }
                var cart_total=document.getElementsByClassName('cart-total1');
                cart_total[0].innerHTML=" Tổng tiền: <b>"+response['totalPrice']+" VNĐ </b>";
                
                
			},
			error: function (response) {
				console.log('failed');
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
                var cart_sum=document.getElementsByClassName('cart-summ');
                for(var i=0;i<cart_sum.length;i++){
                    if(parseInt(cart_sum[i].getAttribute('data-cardId'))==response["cartDTO"].idCard){
                        cart_sum[i].innerHTML="<b>"+response["cartDTO"].totalOfEachSneaker +" VNĐ</b>";
                    }
                }
                var cart_amountC=document.getElementsByClassName('cart-amountC');
                for(var j=0;j<cart_amountC.length;j++){
                    if(parseInt(cart_amountC[j].getAttribute('data-cardId'))==response["cartDTO"].idCard){
                        cart_amountC[j].setAttribute('value',response["cartDTO"].amount);
                    }
                }
                var cart_total=document.getElementsByClassName('cart-total1');
                cart_total[0].innerHTML=" Tổng tiền: <b>"+response['totalPrice']+" VNĐ </b>";
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
    var repeatId=parseInt(document.getElementsByClassName('repeat')[0].getAttribute('data-sneakerRepeat'));
    if(repeatId!=null){
        var cart_sneaker=document.getElementsByClassName('cart-sneaker');
        for(var i=0;i<cart_sneaker.length;i++){
            if(repeatId==cart_sneaker[i].getAttribute('data-sneakerId')){
                cart_sneaker[i].classList.add('repeatclass');
                console.log(cart_sneaker[i].offsetTop);
                window.scrollTo(0, cart_sneaker[i].offsetTop);
            }
        }
    }

},false)