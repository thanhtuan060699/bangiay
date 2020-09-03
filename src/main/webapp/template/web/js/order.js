document.addEventListener("DOMContentLoaded",function(){
    var province=document.getElementById("province");
    window.onload=function(){
        $.ajax({
            url: 'https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/province',
            headers: {
                'token':'8706be97-cfd7-11ea-8af3-5a3ad3110ede',
                'Content-Type':'application/json'
            },
            method: 'GET',
            dataType: 'json',
            success: function(response){
            	console.log('succes: ');
              console.log(response.data);
              var str="<option  selected>Tỉnh thành</option> ";
              for(var i=0;i<response.data.length;i++){
                  console.log(response.data[i].ProvinceName);
                  str=str+"<option class='provinceId' data-province='"+response.data[i].ProvinceID+"' >"+response.data[i].ProvinceName
                  +"</option>  "
              }
              province.innerHTML=str;
            }
          });
    }
},false)

function changeFunc() {
    var selectBox = document.getElementById("province");
    var selectedValue = selectBox.options[selectBox.selectedIndex].getAttribute('data-province');
    var district=document.getElementById('district');
    $.ajax({
        url: 'https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district',
        headers: {
            'token':'8706be97-cfd7-11ea-8af3-5a3ad3110ede',
            'Content-Type':'application/json'
        },
        method: 'GET',
        dataType: 'json',
        success: function(response){
          var str="<option  selected>Quận huyện</option> ";
          for(var i=0;i<response.data.length;i++){
              if(response.data[i].ProvinceID==selectedValue)
              str=str+"<option class='districtId' data-district='"+response.data[i].DistrictID+"' >"
              +response.data[i].DistrictName
              +"</option>  "
          }
          district.innerHTML=str;
        }
      });
  
   };
function changeFuncDistrict(){
    var selectBox = document.getElementById("district");
    var selectedValue = selectBox.options[selectBox.selectedIndex].getAttribute('data-district');
    var ward=document.getElementById('ward');
    $.ajax({
        url: 'https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id='+selectedValue,
        headers: {
            'token':'8706be97-cfd7-11ea-8af3-5a3ad3110ede',
            'Content-Type':'application/json'
        },
        method: 'GET',
        dataType: 'json',
        success: function(response){
          var str="<option  selected>Phường xã</option> ";
          for(var i=0;i<response.data.length;i++){
              str=str+"<option class='wardId' data-ward='"+response.data[i].WardCode+"' >"
              +response.data[i].WardName
              +"</option>  "
          }
          ward.innerHTML=str;
        }
      });
}
document.addEventListener("DOMContentLoaded",function(){
    var btnOrder=document.getElementById('btnOrder');
    btnOrder.onclick=function(){
        var data={};
	    var formData=$('#formEdit').serializeArray();
	    $.each(formData,function(index,v){
		    data[""+v.name+""]=v.value;
        });
        var province=document.getElementById('province');
        var valueProvince=province.options[province.selectedIndex].value;
        data['province']=valueProvince;
        var district=document.getElementById('district');
        var valueDistrict=district.options[district.selectedIndex].value;
        data['district']=valueDistrict;
        var ward=document.getElementById('ward');
        var valueWard=ward.options[ward.selectedIndex].value;
        data['ward']=valueWard;
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/checkout",
            data: JSON.stringify(data),
            dataType: "json",
            contentType:"application/json",
            success: function (response) {
            	if(response==1){
            		alert("Bạn đã đặt giày thành công !! Giày sẽ được giao tới bạn sớm nhất !! Cảm ơn bạn");
            		window.location.href="/allstore/trangchu";
            	}
            		
			},
			error: function (response) {
				console.log('failed');
				console.log(response.sneakerName);
				console.log(response);
			}
        });
        
    }
},false)

