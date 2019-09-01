<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
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
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/owl.carousel.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/owl.theme.default.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/weather-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/mmc-chat.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/sidebar.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/assets/css/lib/simdahs.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/assets/css/style.css" rel="stylesheet">
    <%--rollpage--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/assets/css/easyhelper.min.css">
    <script src="${pageContext.request.contextPath}/statics/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/assets/js/jquery.transit.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/assets/js/es6-shim.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/assets/js/easyhelper.min.js"></script>
    <%--rollpage--%>
</head>
<body>
<div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
    <div class="nano">
        <div class="nano-content">
            <ul>
                <li class="label">功能列表</li>
                <li ><a href="${pageContext.request.contextPath}/book/booklist"><i class="ti-book"></i>书本管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/cash_record/cashrecordlist"><i class="ti-layout-column3"></i> 账目管理 </a></li>
                <li ><a href="${pageContext.request.contextPath}/card/cardlist"><i class="ti-id-badge"></i> 会员卡办理 </a></li>
                <li ><a href="${pageContext.request.contextPath}/customer/customerlist"><i class="ti-user"></i> 会员管理 </a></li>
                <li><a class="sidebar-sub-toggle"><i class="ti-layout-tab"></i>回收站<span class="sidebar-collapse-icon ti-angle-down"></span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/recycleBook/booklist">书本信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/recycleCashRecord/cashrecordlist">账目信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/recycleCard/cardlist">会员卡信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/recycleCustomer/customerlist">会员信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div><!-- /# sidebar -->




<div class="header">
    <div class="pull-left">
        <div class="logo" id="sideLogo">
            <a href="${pageContext.request.contextPath}/WEB-INF/pages/frame.jsp">
                <img class="full-logo" src="${pageContext.request.contextPath}/statics/assets/images/logo-big.png" alt="SimDahs">
                <img class="small-logo" src="${pageContext.request.contextPath}/statics/assets/images/logo-small.png" alt="SimDahs">
            </a>
        </div>
        <div class="hamburger sidebar-toggle">
            <span class="ti-menu"></span>
        </div>
    </div>

    <div class="pull-right p-r-15">
        <ul>
            <li class="header-icon dib"> <span class="user-avatar">${sessionScope.get("user").staffName}<i class="ti-angle-down f-s-10"></i></span>
                <div class="drop-down dropdown-profile">
                    <div class="dropdown-content-body">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/changePassword.jsp"><i class="ti-lock"></i> <span>修改密码</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/login.jsp"><i class="ti-close"></i> <span>退出系统</span></a></li>
                        </ul>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>


</body>
</html>
