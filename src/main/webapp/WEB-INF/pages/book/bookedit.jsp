<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="edit" class="white_content">
        <form  action="${pageContext.request.contextPath}/book/update" method="post" name="editForm" id="editForm" style="size: 500px">
            <fieldset>
                <legend>书本编辑</legend>
                <input id="id_edit" name="id" hidden="hidden">
                <input id="currentPage" name="currentPage" hidden="hidden">
                <div>
                    <label for="bookCode_edit">书本编码:</label>
                    <input type="text" name="bookCode" id="bookCode_edit"  size="18" maxlength="15"  />
                    *<br />
                </div>
                <div>
                    <label for="bookName_edit">书本名称:</label>
                    <input type="text" name="bookName" id="bookName_edit"  size="18" maxlength="15"  /> *<br />
                </div>
                <div>
                    <label for="bookPrice_edit">价格:</label>
                    <input type="text" name="bookPrice" id="bookPrice_edit" size="18" maxlength="15"  />
                    *<br />
                </div>
                <div>
                    <label for="bookNumber_edit">数量:</label>
                    <input type="text" name="bookNumber" id="bookNumber_edit" size="18" maxlength="15"  />
                    *<br />
                </div>
                <div>
                    <label for="bookCategory_edit">类型:</label>
                    <input type="text" name="bookCategory" id="bookCategory_edit" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="bookDate_edit">录入时间:</label>
                    <input type="text" readonly="readonly" name="bookDate" id="bookDate_edit" size="18" maxlength="15"/>
                    *<br />
                </div>
                <div>
                    <label>录入人:</label><p>${sessionScope.get("user").staffName}</p>
                    <input hidden="hidden" type="text" name="staId" id="staId_edit" size="18" maxlength="15" value="${sessionScope.get("userId")}" />
                    <br />
                </div>
                <div class="enter">
                    <input id="updateButton" type="submit" class="Pbuttom" value="提交" onclick="closeEditDialog()"/>
                    <input name="exit" type="button" class="Pbuttom" value="取消" onclick = "closeEditDialog()" />
                </div>
            </fieldset>
        </form>
    </div>
</div>
<div id="fade" class="black_overlay"></div>
