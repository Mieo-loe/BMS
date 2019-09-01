<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/pages/common/head.jsp" %>
<script type="text/javascript">
    /*存入给后面的外置js文件取值*/
    /*总的记录数*/
    var totalCount =${totalCount};
    /*当前页面*/
    var cp =${currentPage};
    var path = "${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/customer/D.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/customer/rollpage.js"></script>
<div class="content-wrap">
    <div class="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 p-0">
                    <div class="page-header">
                        <div class="page-title">
                            <div>
                                <label>你现在的位置是：
                                    <a href="#">回收站</a> /
                                    <a href="#">会员信息</a>
                                </label>
                            </div>
                        </div>
                    </div><!-- /# column -->
                    <div class="col-lg-4 p-0">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <div id="div1"></div>
                                </ol>
                            </div>
                        </div>
                    </div><!-- /# column -->
                </div><!-- /# row -->
                <div class="main-content">
                    <div>
                        <form action="${pageContext.request.contextPath}/recycleCustomer/query">
                            <label>会员卡姓名:
                                <input type="text" id="customerName" name="customerName" placeholder="会员姓名"
                                       value="${customerName}"></label>
                            <input type="submit" id="queryButton" value="查询">
                        </form>
                        <p><a href="${pageContext.request.contextPath}/recycleCustomer/remove" onclick="">清空回收站</a></p>
                    </div>
                    <table class="table table-responsive">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>会员编码</th>
                            <th>会员姓名</th>
                            <th>联系电话</th>
                            <th>办理人ID</th>
                            <th>删除时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="list">
                        <c:forEach items="${customers}" var="c">
                            <tr>
                                <td>${c.id}</td>
                                <td>${c.customerCode}</td>
                                <td>${c.customerName}</td>
                                <td>${c.customerPhone}</td>
                                <td>${c.staId}</td>
                                <td>${c.deleteTime}</td>
                                <td>
                                    <a id="bookEdit" href="${pageContext.request.contextPath}/recycleCustomer/restore?id=${c.id}" onclick=""><i class="ti-ti-reload"></i></a>
                                    <a id="bookDelete" href="${pageContext.request.contextPath}/recycleCustomer/restore?id=${c.id}" onclick="delete_confirm()"><i class="ti-close"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="/WEB-INF/pages/common/rollpage.jsp" %>
            </div><!-- /# container-fluid -->
        </div><!-- /# main -->
    </div><!-- /# content wrap -->
    <%@include file="/WEB-INF/pages/common/foot.jsp" %>
