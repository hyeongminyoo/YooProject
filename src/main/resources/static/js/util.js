function nullcheck(data, dest, kind){
    if(data==null || data == ''){
        $(dest).html(kind+"은(는) 필수 입력사항 입니다.");
        return false;
    }else{
        $(dest).html('<p style="color : blue;">성공</p>');
        return true;
    }
}

function equals(pw, pwch){
    if(pw == pwch){
        return true;
    }else{
        return false;
    }
}