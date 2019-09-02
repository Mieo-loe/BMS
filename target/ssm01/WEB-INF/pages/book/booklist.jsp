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
    $(function () {
        var bookName = document.getElementById("bookName").value;
        var value = document.getElementById("bookCategory");
        var index = value.selectedIndex; // 选中索引
        var bookCategory = value.options[index].value; // 选中值
    });
    var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/book/check.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/book/D.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/book/update.js"></script>
<c:set var="bookName" value="${bookName}"/>
<c:if test="${bookName!=null}">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/book/queryRollpage.js"></script>
</c:if>
<c:if test="${bookName==null}">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/book/rollpage.js"></script>
</c:if>
<div class="content-wrap">
    <div class="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 p-0">
                    <div class="page-header">
                        <div class="page-title">
                            <div>
                                <label>你现在的位置是：
                                    <a href="#">书本清单</a></label>
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
                    <form action="${pageContext.request.contextPath}/book/bookQuery">
                        <label>书本名称:
                            <input type="text" id="bookName" name="bookName" placeholder="书本名称" value="${bookName}"></label>
                        <label>类型：
                            <select id="bookCategory" name="bookCategory">
                                <option value="">未选择</option>
                                <c:set var="bookCategory" value="${bookCategory}"/>
                                <c:forEach items="${bookCategorys}" var="b">
                                    <c:if test="${b==bookCategory}">
                                        <option value="${b}" selected="selected">${b}</option>
                                    </c:if>
                                    <c:if test="${b!=bookCategory}">
                                        <option value="${b}">${b}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </label>
                        <input type="submit" id="queryButton" value="查询">
                    </form>
                    <p><a href="JavaScript:void(0)" onclick="openDialog()">添加书本</a></p>
                </div>
                <table class="table table-responsive">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>书本编码</th>
                        <th>书本名称</th>
                        <th>类型</th>
                        <th>剩余数量</th>
                        <th>录入日期</th>
                        <th>价格</th>
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
                            <td>${b.bookNumber}</td>
                            <td>${b.bookDate}</td>
                            <td>${b.bookPrice}元</td>
                            <td>
                                <a id="bookEdit" href="JavaScript:;" onclick="bookCheck(${b.id});openEditDialog();"><i class="ti-pencil"></i></a>
                                <a id="bookDelete" href="${pageContext.request.contextPath}/book/recycle?id=${b.id}"  ><i class="ti-close"></i></a>
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
<script type="text/javascript">
    function delete_confirm(id,currentPage) {
        if (confirm("是否确认删除？")) {
            window.location("${pageContext.request.contextPath}/book/recycle?id="+id+"&currentPage"+currentPage+"");
        } else {
            return false;
        }
    }
</script>
<!-- /# content wrap -->
<%@include file="/WEB-INF/pages/book/bookadd.jsp" %>
<%@include file="/WEB-INF/pages/book/bookcheck.jsp" %>
<%@include file="/WEB-INF/pages/book/bookedit.jsp" %>
<%@include file="/WEB-INF/pages/common/foot.jsp" %>
