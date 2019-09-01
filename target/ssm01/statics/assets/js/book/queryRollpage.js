$(function () {
    Helper.ui.page("#page-3", {
        total: totalCount,
        pageSize: 10,
        showTotal: true,
        showTo: true,
        currentPage: cp,
        change: function (i) {
            /*将当前页面的值存入页面,方便其他的js外部文件获取*/
            $("#currentPage").val(i);
            $("#currentPage_list").val(i);
            var str = {"currentPage": i};
            $.ajax({
                url: ""+path+"/book/queryRollPage",
                contentType: "application/json;charset=UTF-8",
                //str这个json对象变成json字符串，让springmvc能够解析（springmvc只能解析json字符串，而不是json对象）
                data: JSON.stringify(str),
                dataType: "json",
                type: "post",
                success:function (data){
             D (data);
                },
                error: function () {
                    alert("错误");
                }
            });
        }
    });
});