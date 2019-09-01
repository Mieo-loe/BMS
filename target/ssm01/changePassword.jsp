<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Widget</title>

    <!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">

    <!-- Styles -->
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/simdahs.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/assets/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/statics/assets/js/lib/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#submitButton").hover(function () {
                var p1=$("#userPassword").val();
                var p2=$("#confirmUserPassword").val();
                    if (p1==p2){
                        $("#msg").html("<font color=\"green\" size=\"3px\">密码一致</font>");
                    } else{
                        $("#msg").html("<font color=\"red\" size=\"3px\">两次密码不一致</font>");
                    }
            });
        });
    </script>
</head>

<body class="bg-primary">

<div class="unix-login">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <div class="login-content">
                    <div class="login-logo">
                        <span>修改密码</span>
                    </div>
                    <div class="login-form">
                        <h4>Login</h4>
                        <form action="${pageContext.request.contextPath }/changePassword/changePassword"  name="actionForm" id="actionForm"  method="post">
                            <input id="id" hidden="hidden" name="id" value="${sessionScope.get("user").id}">
                            <div class="form-group">
                                <div id="msg"> <div>${msg}</div></div>
                                <label>用户:</label>
                                <input id="username" readonly="readonly" name="staffUsername" type="text" class="form-control" value="${sessionScope.get("user").staffName}">
                            </div>
                            <div class="form-group">
                                <label>密码:</label>
                                <input id="userPassword" name="staffPassword" type="password" class="form-control" placeholder="请输入密码">
                            </div>
                            <div class="form-group">
                                <label>确认密码:</label>
                                <input id="confirmUserPassword" name="Password" type="password" class="form-control" placeholder="请再次输入密码">
                            </div>
                            <button id="submitButton" type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">提交</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
