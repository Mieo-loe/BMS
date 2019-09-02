<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="edit" class="white_content">
        <form action="${pageContext.request.contextPath}/card/update" method="post" name="editForm" id="editForm">
            <fieldset>
                <legend>会员卡编辑</legend>
                <input id="id_edit" name="id" hidden="hidden">
                <div>
                    <label for="createDate_edit">创建时间:</label>
                    <input type="text" name="createDate" id="createDate_edit"  size="18" maxlength="15"  />
                    *<br />
                </div>
                <div>
                    <label for="expirationDate_edit">截止日期:</label>
                    <input type="text" name="expirationDate" id="expirationDate_edit"  size="18" maxlength="15"  /> *<br />
                </div>
                <div>
                    <label for="discount_edit">折扣:</label>
                    <input type="text" name="discount" id="discount_edit" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="cusId_edit">持有人ID:</label>
                    <input type="text" name="cusId" id="cusId_edit" size="18" maxlength="15"/>
                    *<br />
                </div>
                <div>
                    <label for="staId_edit">录入人ID:</label><p>${sessionScope.get("user").staffName}</p>
                    <input type="text" hidden="hidden" name="staId" id="staId_edit" size="18" maxlength="15" value="${sessionScope.get("userId")}"/>
                    *<br />
                </div>
                <div class="enter">
                    <input name="submit" type="submit" class="Pbuttom" value="提交" />
                    <input name="exit" type="button" class="Pbuttom" value="取消" onclick = "closeEditDialog()" />
                </div>

            </fieldset>
        </form>
    </div>
</div>
<div id="fade" class="black_overlay"></div>