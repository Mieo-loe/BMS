<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="formwrapper" class="white_content">
        <form action="${pageContext.request.contextPath}/card/insert" method="post" name="apForm" id="apForm">
            <fieldset>
                <legend>添加会员卡</legend>
                <div>
                    <label for="createDate_add">创建时间:</label>
                    <input type="text" name="createDate" id="createDate_add" value="" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="expirationDate_add">截止日期:</label>
                    <input type="text" name="expirationDate" id="expirationDate_add" value="" size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="discount_add">折扣:</label>
                    <input type="text" name="discount" id="discount_add" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="cusId_add">持有人ID:</label>
                    <input type="text" name="cusId" id="cusId_add" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="staId_add">录入人ID:</label><p>${sessionScope.get("user").staffName}</p>
                    <input hidden="hidden" type="text" name="staId" id="staId_add" size="18" maxlength="15" value="${sessionScope.get("userId")}"/>
                    *<br />
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