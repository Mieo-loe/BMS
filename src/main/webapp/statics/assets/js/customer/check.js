function customerCheck(id){
    var str={"id":id};
    $.ajax({
        url: ""+path+"/customer/selectById",
        contentType: "application/json;charset=UTF-8",
        //str这个json对象变成json字符串，让springmvc能够解析（springmvc只能解析json字符串，而不是json对象）
        data: JSON.stringify(str),
        dataType: "json",
        type: "post",
        success: function (data) {
            var ls = data.customer;
                $("#id_edit").val(ls.id);
                $("#customerCode_edit").val(ls.customerCode);
                $("#customerName_edit").val(ls.customerName);
                $("#customerPhone_edit").val(ls.customerPhone);
        },
        error: function () {
            alert("错误");
        }
    });
}