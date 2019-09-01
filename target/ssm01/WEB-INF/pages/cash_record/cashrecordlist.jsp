<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" %>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<script type="text/javascript">
    /*存入给后面的外置js文件取值*/
    /*总的记录数*/
    var totalCount =${totalCount};
    /*当前页面*/
    var cp =${currentPage};
    var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/cash_record/D.js"></script>
<c:set value="${cashDate}" var="cashDate"/>
<c:if test="${cashDate==null}">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/cash_record/rollpage.js"></script>
</c:if>
<c:if test="${cashDate!=null}">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/assets/js/cash_record/queryRollpage.js"></script>
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
                                    <a href="#">账目清单</a></label>
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
                    <form action="${pageContext.request.contextPath}/cash_record/cashrecordQuery">
                        <label>入账时间:
                            <input type="text" id="cashDate" name="cashDate" placeholder="入账时间" value="${cashDate}" ></label>
                        <input type="submit" id="queryButton" value="查询">
                    </form>
                    <p><a href = "JavaScript:void(0)" onclick = "openDialog()">添加账单</a></p>
                </div>
                <table class="table table-responsive">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>入账时间</th>
                        <th>会员卡号</th>
                        <th>书本名称</th>
                        <th>金额</th>
                        <th>利润</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="list">
                    <c:forEach items="${cashrecords}" var="c">
                        <tr>
                            <td>${c.id}</td>
                            <td>${c.cashDate}</td>
                            <td>${c.carId}</td>
                            <td>${c.book.bookName}</td>
                            <td>${c.cashAmount}</td>
                            <td>${c.cashProfit}</td>
                            <td>
                                <a id="bookDelete" href="${pageContext.request.contextPath}/cash_record/recycle?id=${c.id}"><i class="ti-close"></i></a>
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
<%@include file="/WEB-INF/pages/cash_record/cashrecordadd.jsp" %>
<%@include file="/WEB-INF/pages/cash_record/cashrecordcheck.jsp" %>
<%@include file="/WEB-INF/pages/cash_record/cashrecordedit.jsp" %>
<%@include file="/WEB-INF/pages/common/foot.jsp" %>
