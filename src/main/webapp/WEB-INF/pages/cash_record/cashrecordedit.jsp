<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="edit" class="white_content">
        <form action="" method="post" name="editForm" id="editForm">
            <fieldset>
                <legend>账目编辑</legend>
                <div>
                    <label for="cashDate_edit">入账时间:</label>
                    <input type="text" name="cashDate" id="cashDate_edit"  size="18" maxlength="15" value="初始值" />
                    *<br />
                </div>
                <div>
                    <label for="cashAmount_edit">金额:</label>
                    <input type="text" name="cashAmount" id="cashAmount_edit"  size="18" maxlength="15" value="初始值" /> *<br />
                </div>
                <div>
                    <label for="cashProfit_edit">利润:</label>
                    <input type="text" name="cashProfit" id="cashProfit_edit" size="18" maxlength="15" value="初始值" />
                    *<br />
                </div>
                <div>
                    <label for="booId_edit">书本ID:</label>
                    <input type="text" name="booId" id="booId_edit" size="18" maxlength="15" value="初始值" />
                    *<br />
                </div>
                <div>
                    <label for="carId_edit">会员ID:</label>
                    <input type="text" name="carId" id="carId_edit" size="18" maxlength="15" value="初始值" />
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