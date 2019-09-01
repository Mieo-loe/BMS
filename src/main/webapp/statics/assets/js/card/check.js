function cardCheck(id){
    var str={"id":id};
    $.ajax({
        url: ""+path+"/card/selectByIdForCheck",
        contentType: "application/json;charset=UTF-8",
        //str这个json对象变成json字符串，让springmvc能够解析（springmvc只能解析json字符串，而不是json对象）
        data: JSON.stringify(str),
        dataType: "json",
        type: "post",
        success: function (data) {
            var ls = data.card;
            $("#id_edit").val(ls.id);
            $("#createDate_edit").val(ls.createDate);
            $("#expirationDate_edit").val(ls.expirationDate);
            $("#discount_edit").val(ls.discount);
            $("#cusId_edit").val(ls.cusId);
        },
        error: function () {
            alert("错误");
        }
    });
}