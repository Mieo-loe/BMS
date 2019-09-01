<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="formwrapper" class="white_content">
        <form action="${pageContext.request.contextPath}/customer/insert" method="post" name="apForm" id="apForm" style="size: 500px">
            <fieldset>
                <legend>添加书本</legend>
                <div>
                    <label for="customerCode_add">会员编码:</label>
                    <input type="text" name="customerCode" id="customerCode_add" value="" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="customerName_add">会员姓名:</label>
                    <input type="text" name="customerName" id="customerName_add" value="" size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="customerPhone_add">联系电话:</label>
                    <input type="text" name="customerPhone" id="customerPhone_add" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="staId_add">录入人ID:</label><p>${sessionScope.get("user").staffName}</p>
                    <input hidden="hidden" type="text" name="staId" id="staId_add" size="18" maxlength="15" value="${sessionScope.get("userId")}"/>
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
<div id="fade" class="black_overlay"></div>