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
                <legend>账目信息</legend>
                <div>
                    <label >入账时间:</label>
                </div>
                <div>
                    <label >金额:</label>
                </div>
                <div>
                    <label >利润:</label>
                </div>
                <div>
                    <label >书本ID:</label>
                </div>
                <div>
                    <label >会员卡ID:</label>
                </div>
                <div class="enter">
                    <input name="exit" type="button" class="Pbuttom" value="关闭" onclick = "closeCheckDialog()" />
                </div>
            </fieldset>
        </form>
    </div>
</div>
