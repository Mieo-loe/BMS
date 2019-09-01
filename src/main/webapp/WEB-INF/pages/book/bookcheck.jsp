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
                <legend>录入员工信息</legend>
                <p id="bookCheckDiv"></p>
                <div class="enter">
                    <input id="bookCheckCloseButton" name="exit" type="button" class="Pbuttom" value="关闭" onclick = "closeCheckDialog()" />
                </div>
            </fieldset>
        </form>
    </div>
</div>
