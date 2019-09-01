<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="edit" class="white_content">
        <form action="${pageContext.request.contextPath}/customer/update" method="post" name="editForm" id="editForm">
            <fieldset>
                <legend>会员卡编辑</legend>
                <input id="id_edit"  name="id" hidden="hidden" >
                <div>
                    <label for="customerCode_edit">会员编码:</label>
                    <input type="text" name="customerCode" id="customerCode_edit"  size="18" maxlength="15"  />
                    *<br />
                </div>
                <div>
                    <label for="customerName_edit">会员姓名:</label>
                    <input type="text" name="customerName" id="customerName_edit"  size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="customerPhone_edit">联系电话:</label>
                    <input type="text" name="customerPhone" id="customerPhone_edit" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="staId_edit">录入人ID:</label><p>${sessionScope.get("user").staffName}</p>
                    <input hidden="hidden" type="text" readonly="readonly" name="staId" id="staId_edit" size="18" maxlength="15" value="${sessionScope.get("userId")}" />
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