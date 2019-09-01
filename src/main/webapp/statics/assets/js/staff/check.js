function staffCheck(id){
    var str={"id":id};
    $.ajax({
        url: ""+path+"/staff/selectById",
        contentType: "application/json;charset=UTF-8",
        //str这个json对象变成json字符串，让springmvc能够解析（springmvc只能解析json字符串，而不是json对象）
        data: JSON.stringify(str),
        dataType: "json",
        type: "post",
        success: function (data) {
            var ls = data.staff;
            $("#id_edit").val(ls.id);
            $("#staffCode_edit").val(ls.staffCode);
            $("#staffName_edit").val(ls.staffName);
            $("#staffSex_edit").val(ls.staffSex);
            $("#staffAddress_edit").val(ls.staffAddress);
            $("#staffUsername_edit").val(ls.staffUsername);
            $("#staffPassword_edit").val(ls.staffPassword);
            $("#staffPhone_edit").val(ls.staffPhone);
            $("#staffPermission_edit").val(ls.staffPermission);
            $("#startWorktime_edit").val(ls.startWorktime);
            $("#endWorktime_edit").val(ls.endWorktime);
        },
        error: function () {
            alert("错误");
        }
    });
}