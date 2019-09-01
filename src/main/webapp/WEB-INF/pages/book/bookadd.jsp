<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="formwrapper" class="white_content">
        <form action="${pageContext.request.contextPath}/book/insert" method="post" name="apForm" id="apForm" style="size: 500px">
            <fieldset>
                <legend>添加书本</legend>
                <div>
                    <label for="bookCode_add">书本编码:</label>
                    <input type="text" name="bookCode" id="bookCode_add" value="" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="bookName_add">书本名称:</label>
                    <input type="text" name="bookName" id="bookName_add" value="" size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="bookPrice_add">价格:</label>
                    <input type="text" name="bookPrice" id="bookPrice_add" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="bookNumber_add">数量:</label>
                    <input type="text" name="bookNumber" id="bookNumber_add" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="bookCategory_add">类型:</label>
                    <input type="text" name="bookCategory" id="bookCategory_add" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="bookDate_add">录入时间:</label>
                    <input type="text" name="bookDate" id="bookDate_add" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="staId_add">录入人ID:</label><p>${sessionScope.get("user").staffName}</p>
                    <input hidden="hidden" type="text" name="staId" id="staId_add" size="18" maxlength="15"  value="${sessionScope.get("userId")}"/>
                    *<br />
                </div>
                <div class="enter">
                    <input name="submit" type="submit" class="Pbuttom" value="提交"  onclick = "closeDialog()"/>
                    <input name="exit" type="button" class="Pbuttom" value="取消" onclick = "closeDialog()" />
                </div>
            </fieldset>
        </form>
    </div>
</div>
<div id="fade" class="black_overlay"></div>