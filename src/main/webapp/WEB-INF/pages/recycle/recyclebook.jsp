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
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/book/D.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/book/rollpage.js"></script>
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
                                    <a href="#">书本信息</a>
                                </label>
                            </div>
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
                    <form action="${pageContext.request.contextPath}/recycleBook/query">
                        <label>书本名称:
                            <input type="text" id="bookName" name="bookName" placeholder="书本名称"
                                   value="${bookName}"></label>
                        <label>类型：
                            <select id="bookCategory" name="bookCategory">
                                <option value="">未选择</option>
                                <c:forEach items="${bookCategorys}" var="b">
                                    <option value="${b}">${b}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <input type="submit" id="queryButton" value="查询">
                    </form>
                    <p><a href="${pageContext.request.contextPath}/recycleBook/remove" onclick="">清空回收站</a></p>
                </div>
                <table class="table table-responsive">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>书本编码</th>
                        <th>书本名称</th>
                        <th>类型</th>
                        <th>录入日期</th>
                        <th>价格</th>
                        <th>删除时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="list">
                    <c:forEach items="${books}" var="b">
                        <tr>
                            <td>${b.id}</td>
                            <td>${b.bookCode}</td>
                            <td>${b.bookName}</td>
                            <td>${b.bookCategory}</td>
                            <td>${b.bookDate}</td>
                            <td>${b.bookPrice}</td>
                            <td>${b.deleteTime}</td>
                            <td>
                                <a id="bookDelete" href="${pageContext.request.contextPath}/recycleBook/restore?id=${b.id}" ><i class="ti-close"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <%@include file="/WEB-INF/pages/common/rollpage.jsp" %>
            </div>
        </div><!-- /# container-fluid -->
    </div><!-- /# main -->
</div>
<!-- /# content wrap -->
<%@include file="/WEB-INF/pages/common/foot.jsp" %>