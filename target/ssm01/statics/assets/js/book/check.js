function bookCheck(id){
    var str={"id":id};
    $.ajax({
        url: ""+path+"/book/selectById",
        contentType: "application/json;charset=UTF-8",
        //str这个json对象变成json字符串，让springmvc能够解析（springmvc只能解析json字符串，而不是json对象）
        data: JSON.stringify(str),
        dataType: "json",
        type: "post",
        success: function (data) {
            var ls=data.book;
            $("#id_edit").val(ls.id);
            $("#bookCode_edit").val(ls.bookCode);
            $("#bookName_edit").val(ls.bookName);
            $("#bookPrice_edit").val(ls.bookPrice);
            $("#bookNumber_edit").val(ls.bookNumber);
            $("#bookCategory_edit").val(ls.bookCategory);
            $("#bookDate_edit").val(ls.bookDate);
        },
        error: function () {
            alert("错误");
        }
    });
}