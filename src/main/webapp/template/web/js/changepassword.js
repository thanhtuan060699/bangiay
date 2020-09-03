$(btnChangePassword).click(function () { 
    var data={};
    var formData=$('#formEdit').serializeArray();
    $.each(formData,function(index,v){
        data[""+v.name+""]=v.value;
    });
    $.ajax({
        url: "http://localhost:8080/api/profile/changepassword",
        type: "POST",
        data: JSON.stringify(data),
        contentType:"application/json",
    
        success: function (response) {
            if(response==1){
                alert('Mật khẩu xác nhận không trùng khớp với mật khẩu mới');
            }
            if(response==2){
                alert('Thiếu thông tin !! Vui lòng kiểm tra lại');
                
            }
            if(response==3){
                alert('Mật khẩu cũ không chính xác');
                
            }
            if(response==4){
                alert('Bạn đã thay đổi mật khẩu thành công !! Làm ơn đăng nhập lại');
                window.location.href="/allstore/customer/logout";
            }
            
            
                
        },
        error: function (response) {
            console.log('failed');
            console.log(response);
        }
        });
})