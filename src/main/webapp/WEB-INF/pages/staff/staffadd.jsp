<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="formwrapper" class="white_content">
        <form action="${pageContext.request.contextPath}/staff/insert" method="post" name="apForm" id="apForm" style="size: 500px">
            <legend>员工卡编辑</legend>
            <div>
                <label for="staffCode_add">员工编码:</label>
                <input type="text" name="staffCode" id="staffCode_add"  size="18" maxlength="15"  />
                *<br />
            </div>
            <div>
                <label for="staffName_add">员工姓名:</label>
                <input type="text" name="staffName" id="staffName_add"  size="18" maxlength="15" /> *<br />
            </div>
            <div>
                <label for="staffSex_add">员工性别:</label>
                <input type="text" name="staffSex" id="staffSex_add"  size="18" maxlength="15" /> *<br />
            </div>
            <div>
                <label for="staffAddress_add">员工地址:</label>
                <input type="text" name="staffAddress" id="staffAddress_add"  size="18" maxlength="15" /> *<br />
            </div>
            <div>
                <label for="staffUsername_add">员工账户:</label><div id="msg"></div>
                <input type="text" name="staffUsername" id="staffUsername_add"  size="18" maxlength="15" /> *<br />
            </div>
            <div>
                <label for="staffPassword_add">员工密码:</label>
                <input type="text" name="staffPassword" id="staffPassword_add"  size="18" maxlength="15" /> *<br />
            </div>
            <div>
                <label for="staffPhone_add">联系电话:</label>
                <input type="text" name="staffPhone" id="staffPhone_add" size="18" maxlength="15" />
                *<br />
            </div>
            <div>
                <label for="startWorktime_add">上班时间:</label>
                <input type="text" name="startWorktime" id="startWorktime_add" size="18" maxlength="15" />
                *<br />
            </div>
            <div>
                <label for="endWorktime_add">下班时间:</label>
                <input type="text" name="endWorktime" id="endWorktime_add" size="18" maxlength="15" />
                *<br />
            </div>
            <div>
                <label for="staffPermission_add">登陆权限:</label>
                <input type="text" name="staffPermission" id="staffPermission_add" size="18" maxlength="15" />
                *<br />
            </div>
            <div>
                <label for="staId_add">录入人:</label><p>${sessionScope.get("user").staffName}</p>
                <input hidden="hidden" type="text" readonly="readonly" name="staId" id="staId_add" size="18" maxlength="15" value="${sessionScope.get("userId")}" />
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
<script type="text/javascript">
    $(function () {
        $("#staffUsername_add").blur(function () {
            var str={"username":$("#staffUsername_add").val()};
            $.ajax({
                url: ""+path+"/changePassword/verifyUsername",
                contentType: "application/json;charset=UTF-8",
                //str这个json对象变成json字符串，让springmvc能够解析（springmvc只能解析json字符串，而不是json对象）
                data: JSON.stringify(str),
                dataType: "json",
                type: "post",
                success: function (data) {
                   $("#msg").html(data.msg);
                },
                error: function () {
                    alert("错误");
                }
            })
        })
    })
</script>