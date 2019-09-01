<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/pages/common/head_plus.jsp"%>
<script type="text/javascript">
    /*存入给后面的外置js文件取值*/
    var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/staff/D.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/staff/check.js"></script>
<div class="content-wrap">
    <div class="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 p-0">
                    <div class="page-header">
                        <div class="page-title">
                            <div>
                                <label>你现在的位置是：
                                    <a href="#">员工管理</a></label>
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
                    <form  action="${pageContext.request.contextPath}/staff/staffQuery">
                        <label>员工卡姓名:
                            <input type="text" id="staffName" name="staffName" placeholder="员工姓名"  value="${staffName}"></label>
                        <input type="submit" id="queryButton" value="查询">
                    </form>
                    <p><a href = "JavaScript:void(0)" onclick = "openDialog()">添加员工信息</a></p>
                </div>
                <table class="table table-responsive">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>员工编码</th>
                        <th>员工姓名</th>
                        <th>性别</th>
                        <th>住址</th>
                        <th>电话</th>
                        <th>上班时间</th>
                        <th>下班时间</th>
                        <th>账号</th>
                        <th>密码</th>
                        <th>登录权限</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="list">
                    <c:forEach items="${staffs}" var="c">
                        <tr>
                            <td>${c.id}</td>
                            <td>${c.staffCode}</td>
                            <td>${c.staffName}</td>
                            <td>${c.staffSex}</td>
                            <td>${c.staffAddress}</td>
                            <td>${c.staffPhone}</td>
                            <td>${c.startWorktime}</td>
                            <td>${c.endWorktime}</td>
                            <td>${c.staffUsername}</td>
                            <td>${c.staffPassword}</td>
                            <td>${c.staffPermission}</td>
                            <td>
                                <a href = "JavaScript:void(0)" onclick = "staffCheck(${c.id});openEditDialog()"><i class="ti-pencil"></i></a>
                                <a href="${pageContext.request.contextPath}/staff/delete?id=${c.id}" onclick = "delete_confirm()"><i class="ti-close"></i></a>
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
<%@include file="/WEB-INF/pages/staff/staffadd.jsp" %>
<%@include file="/WEB-INF/pages/staff/staffcheck.jsp" %>
<%@include file="/WEB-INF/pages/staff/staffedit.jsp" %>
<%@include file="/WEB-INF/pages/common/foot_plus.jsp" %>
