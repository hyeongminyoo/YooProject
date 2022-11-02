//fileManager.js

let count = 0;
$("#fileAdd").click(function(){
    count++;
    if(count > 5){
        alert("파일첨부는 5개까지만 가능합니다.");
        console.log(count);
        count--;
        console.log(count);
        return;
    }
    let add = '<div class="mb-3">';
    add += '<label for="file" class="form-label">File</label>';
    add += '<input type="file" name="files">';
    add += '<button id="deleteButton" onclick="deleteFile()">X</button>'
    add += '</div>';

    $("#files").append(add);

})

function deleteFile(){
    $("#deleteButton").parent().remove();
    count--;
}


let results = [false,false,false];

$("#writer").blur(function(){
    let result = nullcheck(this.value, "#inputWriterResult", "작성자");
    results[0] = result;
})

$("#title").blur(function(){
    let result = nullcheck(this.value, "#inputTitleResult", "제목");
    results[0] = result;
})



$("#contents").summernote({
    height : 400,
    lang : "ko-KR",
    minHeight : null,
    maxHeight : null,
    focus : true,
    callbacks : {
        onBlur : function(){

            const contents = $("#contents").summernote('code');
            console.log(contents);
            if(contents == "<p><br></p>" || contents == "<p></p>"){
                $("#inputContentsResult").html('<p style="color : red;">내용을 입력해주세요.</p>');
                results[2] = false;
            }else{
                $("#inputContentsResult").empty();
                results[2] = true;
            }
        }
    }
})

// $("#addButton").click(function(){

//     if(results.includes(false)){
//         alert("제목 또는 내용을 입력해주세요");
//     }else{

//     }
// })
