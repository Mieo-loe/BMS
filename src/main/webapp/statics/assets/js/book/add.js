function bookAdd(){
    var str={
        "bookCode":$("#bookCode_add").val(),
        "bookName":$("#bookName_add").val(),
        "bookPrice":$("#bookPrice_add").val(),
        "bookNumber":$("#bookNumber_add").val(),
        "bookCategory":$("#bookCategory_add").val(),
        "bookDate":$("#bookDate_add").val()
    };
    $.ajax({
        url: ""+path+"/book/insert",
        contentType: "application/json;charset=UTF-8",
        //str这个json对象变成json字符串，让springmvc能够解析（springmvc只能解析json字符串，而不是json对象）
        data: JSON.stringify(str),
        dataType: "json",
        type: "post",
        error: function () {
            alert("错误");
        }
    });
}
