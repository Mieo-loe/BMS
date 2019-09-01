<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- font files -->
    <link href="http://fonts.googleapis.com/css?family=Wallpoet" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Hind" rel="stylesheet">
    <!-- /font files -->
    <!-- css files -->
    <link href="${pageContext.request.contextPath}/statics/assets/css/404style.css" rel="stylesheet" type="text/css"
          media="all"/>
    <!-- /css files -->
<body>
<div class="w3layouts-bg">
    <h1 class="header-w3ls">Artistic Error Page</h1>
    <div class="agileits-content">
        <h2><span>${msg.expectionMessage}</span></h2>

    </div>
    <div class="w3layouts-right">
        <div class="w3ls-text">
            <h3>we're sorry!</h3>
            <h4 class="w3-agileits2">the page you requested could not be found.</h4>
            <p>Please go back to the <a href="#">Home</a> page or contact us at <a href="mailto:support@example.com">support@w3l.com</a>
            </p>
        </div>
    </div>
    <div class="clearfix"></div>
</div>

</body>
</html>