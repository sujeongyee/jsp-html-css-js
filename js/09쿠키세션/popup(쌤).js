

function addCookie(name,value){
    var cookie = "";

    //시간설정
    var date = new Date();
    date.setDate(date.getDate()+1);
    date.setHours(0);
    date.setMinutes(0);
    date.setSeconds(0);
    console.log(date);
    cookie+= name+'='+value+'; expires='+date.toUTCString+'; path=/';

    document.cookie = cookie;

}

// 쿠키 확인하기
function getCookie(name){
    var arr = document.cookie.split('; ');

    if(arr.length!=0){
        for(var i = 0 ; i < arr.length ; i++){
            if(arr[i].indexOf(name+'=')!=-1){
                return true;
            }
        }
    }


}