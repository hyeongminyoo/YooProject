
let results = [false,false,false,false,false]

$("#inputId").blur(function(){
    let result = nullcheck(this.value, "#inputUserNameResult","ID");
    results[0] = result;
})

$("#inputPw").on({
    blur : function(){
        
        let result = nullcheck(this.value, "#inputPasswordResult","비밀번호")
        results[1] = result;
    }
})

$("#inputPwCh").blur(function(){
    let result = equals($("inputPw").val, this.value);
    if(result){

    }else{
        
    }
})