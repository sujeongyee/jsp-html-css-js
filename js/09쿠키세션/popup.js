
window.onload = function(){
    var arr = document.cookie.split("; ");
    var bool = true;
    console.log(arr);
    for(var i = 0 ; i < arr.length; i++){        
        if(arr[i].indexOf('cook')!=-1){
            bool = false
        }
    }
    if(bool==true){
        window.open('popup.html','popup','width =300px , height = 300px , left = 300px , top = 300px');
    }
}


function addCookie(name,value){   
    var date = new Date();
    date.setDate(date.getDate()+1);
    var cookie = name+'='+value+'; expires='+date.toUTCString()+"; path=/";
    document.cookie = cookie;
    self.close();
}
    
