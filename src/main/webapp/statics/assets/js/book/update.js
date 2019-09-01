function bookUpdate(){

    var str={"id":$("#id_edit").val(),
            "bookCode":$("#bookCode_edit").val(),
            "bookName":$("#bookName_edit").val(),
            "bookPrice":$("#bookPrice_edit").val(),
            "bookNumber":$("#bookNumber_edit").val(),
            "bookCategory":$("#bookCategory_edit").val(),
            "bookDate":$("#bookDate_edit").val()
                };
    $.ajax({
        url: ""+path+"/book/update",
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

function bookRollpage() {
    var i=$("#currentPage").val();
    var st = {"currentPage":i};
    $.ajax({
        url: ""+path+"/book/rollPage",
        contentType: "application/json;charset=UTF-8",
        //str这个json对象变成json字符串，让springmvc能够解析（springmvc只能解析json字符串，而不是json对象）
        data: JSON.stringify(st),
        dataType: "json",
        type: "post",
        success:function (data){
        },
        error: function () {
            alert("错误");
        }
    });
}