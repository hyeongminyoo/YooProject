function nullcheck(data, dest, kind){
    if(data==null || data == ''){
        $(dest).html(kind+"은(는) 필수 입력사항 입니다.");
        return false;
    }else{
        $(dest).html("");
        return true;
    }
}