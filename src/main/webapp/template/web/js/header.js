document.addEventListener("DOMContentLoaded",function(){
    var nameUser=document.getElementsByClassName('name-user')[0];
    nameUser.onclick=function(){
        var listProfile=document.getElementsByClassName('list-profile')[0];
        listProfile.classList.toggle('display-list-profile');
    }
},false)