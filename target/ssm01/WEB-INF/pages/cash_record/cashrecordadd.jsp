<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="formwrapper" class="white_content">
        <form action="${pageContext.request.contextPath}/cash_record/insert" method="post" name="apForm" id="apForm">
            <fieldset>
                <legend>添加账单</legend>
                <div>
                    <label for="cashDate_add">入账时间:</label>
                    <input readonly="readonly" type="text" name="cashDate" id="cashDate_add" value="" size="18" maxlength="15"  />
                    *<br />
                </div>
                <div>
                    <label for="booId_add">书本ID:</label>
                    <input type="text" name="booId" id="booId_add" size="18" maxlength="15"/>
                    <br />
                </div>
                <div>
                    <label for="booId_add">书本名称:</label>
                    <input type="text" name="bookName" readonly="readonly" id="bookName_add" size="18" maxlength="15"/>
                    <br />
                </div>
                <div>
                    <label for="carId_add">会员卡ID:</label>
                    <input type="text"  name="carId" id="carId_add" size="18" maxlength="15"  />
                    <br />
                </div>
                <div>
                    <label for="discount">会员卡折扣:</label>
                    <input type="text" readonly="readonly" id="discount" size="18" maxlength="15" value="1"  />
                    <br />
                </div>
                <div>
                    <label for="booId_add">书本数量:</label>
                    <input type="text" id="bookNumber_add" name="bookNumber" size="18" maxlength="15" />
                    <br />
                </div>
                <div>
                    <label for="cashAmount_add">应收金额:</label>
                    <input type="text" readonly="readonly" name="cashAmount" id="cashAmount_add" value="" size="18" maxlength="15"  /> *<br />
                </div>
                <div>
                    <label for="cashProfit_add">实际收取:</label>
                    <input type="text" readonly="readonly" name="cashProfit" id="cashProfit_add" size="18" maxlength="15"  />
                    *<br />
                </div>

                <div>
                <label for="carId_add">录入人ID:</label><p>${sessionScope.get("user").staffName}</p>
                <input type="text" hidden="hidden" readonly="readonly" name="staId" id="sta_Id" size="18" maxlength="15" value="${sessionScope.get("userId")}" />
               <br />
                 </div>
                <div class="enter">
                    <input name="submit" type="submit" class="Pbuttom" value="提交" />
                    <input name="exit" type="button" class="Pbuttom" value="取消" onclick = "closeDialog()" />
                </div>
            </fieldset>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var bookPrice=1;
        var discount=1;
        $("#booId_add").blur(function () {
            var str = {
                "id":$("#booId_add").val()
            };
            $.ajax({
                url:"${pageContext.request.contextPath}/cash_record/getBookPrice",
                contentType:"application/json;charset=UTF-8",
                data:JSON.stringify(str),
                dataType:"json",
                type:"post",
                success:function (data) {
                    var book=data.book;
                    $("#bookName_add").val(book.bookName);
                    bookPrice=book.bookPrice;
                },
                error:function (data) {
                    alert("请输入书本号");
                }
            });
        });
        $("#bookNumber_add").blur(function () {
            var str = {
                "id":$("#booId_add").val()
            };
            $.ajax({
                url:"${pageContext.request.contextPath}/cash_record/selectBookNumberById",
                contentType:"application/json;charset=UTF-8",
                data:JSON.stringify(str),
                dataType:"json",
                type:"post",
                success:function (data) {
                    var bookNumber=data.bookNumber;
                    if ($("#bookNumber_add").val()>bookNumber){
                        alert("书籍存货不足");
                    }
                 },
                error:function (data) {
                    alert("请输入书本号");
                }
            });
            discount=$("#discount").val();
            var total=bookPrice*$("#bookNumber_add").val();
          total = total.toFixed(2);  // 输出两位小数
            var totalWithDiscount=bookPrice*$("#bookNumber_add").val()*discount;
            totalWithDiscount =totalWithDiscount.toFixed(2);
            $("#cashAmount_add").val(total);
            $("#cashProfit_add").val(totalWithDiscount);
        });
        $("#carId_add").blur(function () {
            var str = {
                "id":$("#carId_add").val()
            };
            $.ajax({
                url:"${pageContext.request.contextPath}/card/selectById",
                contentType:"application/json;charset=UTF-8",
                data:JSON.stringify(str),
                dataType:"json",
                type:"post",
                success:function (data) {
                    var card=data.card;
                   $("#discount").val(card.discount);
                   if(typeof(data.RT) == "string"){
                       alert("会员卡到期了");
                   }
                },
            });
            discount=$("#discount").val();
            var total=bookPrice*$("#bookNumber_add").val();
            var totalWithDiscount=bookPrice*$("#bookNumber_add").val()*discount;
            $("#cashAmount_add").val(total);
            $("#cashProfit_add").val(totalWithDiscount);
        });
    });
</script>
<div id="fade" class="black_overlay"></div>