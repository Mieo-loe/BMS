<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/26
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="popup">
    <div id="check" class="white_content">
        <form action="" method="post" name="checkForm" id="checkForm">
            <fieldset>
                <legend>会员信息</legend>
                <div>
                    <label >ID:</label>
                </div>
                <div>
                    <label >编码:</label>
                </div>
                <div>
                    <label >姓名:</label>
                </div>
                <div>
                    <label >联系电话:</label>
                </div>
                <div>
                    <label >办理人ID:</label>
                </div>
                <div class="enter">
                    <input name="exit" type="button" class="Pbuttom" value="关闭" onclick = "closeCheckDialog()" />
                </div>

            </fieldset>
        </form>
    </div>
</div>
