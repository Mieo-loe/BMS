<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="edit" class="white_content">
        <form action="${pageContext.request.contextPath}/staff/update" method="post" name="editForm" id="editForm">
            <fieldset>
                <legend>员工编辑</legend>
                <input id="id_edit"  name="id" hidden="hidden" >
                <div>
                    <label for="staffCode_edit">员工编码:</label>
                    <input type="text" name="staffCode" id="staffCode_edit"  size="18" maxlength="15"  />
                    *<br />
                </div>
                <div>
                    <label for="staffName_edit">员工姓名:</label>
                    <input type="text" name="staffName" id="staffName_edit"  size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="staffSex_edit">员工性别:</label>
                    <input type="text" name="staffSex" id="staffSex_edit"  size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="staffAddress_edit">员工地址:</label>
                    <input type="text" name="staffAddress" id="staffAddress_edit"  size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="staffUsername_edit">员工账户:</label>
                    <input type="text" name="staffUsername" id="staffUsername_edit"  size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="staffPassword_edit">员工密码:</label>
                    <input type="text" name="staffPassword" id="staffPassword_edit"  size="18" maxlength="15" /> *<br />
                </div>
                <div>
                    <label for="staffPhone_edit">联系电话:</label>
                    <input type="text" name="staffPhone" id="staffPhone_edit" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="startWorktime_edit">上班时间:</label>
                    <input type="text" name="startWorktime" id="startWorktime_edit" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="endWorktime_edit">下班时间:</label>
                    <input type="text" name="endWorktime" id="endWorktime_edit" size="18" maxlength="15" />
                    *<br />
                </div>
                <div>
                    <label for="staffPermission_edit">登陆权限:</label>
                    <input type="text" name="staffPermission" id="staffPermission_edit" size="18" maxlength="15" />
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