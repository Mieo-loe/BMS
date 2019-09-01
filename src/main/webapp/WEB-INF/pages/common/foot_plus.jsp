<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<style type="text/css">
    th{
        text-align:center;/** 设置水平方向居中 */
        vertical-align:middle/** 设置垂直方向居中 */
    }
    td{
        text-align:center;/** 设置水平方向居中 */
        vertical-align:middle/** 设置垂直方向居中 */
    }
</style>
<style type="text/css">
    popup{
        font-family: Arial, Helvetica, sans-serif;
        font-size:12px;
        color:#666666;
        background:#fff;
        text-align:center;

    }

    * {
        margin:0;
        padding:0;
    }

    a {
        color:#1E7ACE;
        text-decoration:none;
    }

    a:hover {
        color:#000;
        text-decoration:underline;
    }
    h3 {
        font-size:14px;
        font-weight:bold;
    }

    pre,p {
        color:#1E7ACE;
        margin:4px;
    }
    input, select,textarea {
        padding:1px;
        margin:2px;
        font-size:11px;
    }
    .Pbuttom{
        padding:1px 10px;
        font-size:12px;
        border:1px #1E7ACE solid;
        background:#D0F0FF;
    }
    #formwrapper {
        width:480px;
        margin:15px auto;
        padding:20px;
        text-align:left;
        border:1px #1E7ACE solid;
    }
    #check {
        width:480px;
        margin:15px auto;
        padding:20px;
        text-align:left;
        border:1px #1E7ACE solid;
    }
    #edit {
        width:480px;
        margin:15px auto;
        padding:20px;
        text-align:left;
        border:1px #1E7ACE solid;
    }

    fieldset {
        padding:10px;
        margin-top:5px;
        border:1px solid #1E7ACE;
        background:#fff;
    }

    fieldset legend {
        color:#1E7ACE;
        font-weight:bold;
        width:120px;
        padding:3px 20px 3px 20px;
        border:1px solid #1E7ACE;
        background:#fff;
    }

    fieldset label {
        float:left;
        width:120px;
        text-align:right;
        padding:4px;
        margin:1px;
    }

    fieldset div {
        clear:left;
        margin-bottom:2px;
    }

    .enter{ text-align:center;}
    .clear {
        clear:both;
    }

    .black_overlay{
        display: none;
        position: absolute;
        top: 0%;
        left: 0%;
        width: 100%;
        height: 100%;
        background-color: black;
        z-index:1001;
        -moz-opacity: 0.8;
        opacity:.80;
        filter: alpha(opacity=88);
    }
    .white_content {
        display: none;
        position: absolute;
        top: 18%;
        left: 33%;
        width: 80%;
        height: 50%;
        padding: 20px;
        border: 10px solid orange;
        background-color: white;
        z-index:1002;
        overflow: auto;
    }
</style>
<script type="text/javascript">
    function openDialog(){
        document.getElementById('formwrapper').style.display='block';
        document.getElementById('fade').style.display='block'
    }
    function openCheckDialog(){
        document.getElementById('check').style.display='block';
        document.getElementById('fade').style.display='block'

    }
    function openEditDialog(){
        document.getElementById('edit').style.display='block';
        document.getElementById('fade').style.display='block'
    }
    function closeDialog(){
        document.getElementById('formwrapper').style.display='none';
        document.getElementById('fade').style.display='none'
    }
    function closeCheckDialog(){
        document.getElementById('check').style.display='none';
        document.getElementById('fade').style.display='none'
    }
    function closeEditDialog(){
        document.getElementById('edit').style.display='none';
        document.getElementById('fade').style.display='none'
    }

</script>
<script type="text/javascript">
    function delete_confirm() {
        if (confirm("是否确认删除？")) {
            submit();
        } else {
            return false;
        }
    }
</script>

<script src="${pageContext.request.contextPath}/statics/assets/js/lib/jquery.nanoscroller.min.js"></script><!-- nano scroller -->
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/sidebar.js"></script><!-- sidebar -->
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/bootstrap.min.js"></script><!-- bootstrap -->
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/mmc-common.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/mmc-chat.js"></script>
<!--  Chart js -->
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/chart-js/Chart.bundle.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/chart-js/chartjs-init.js"></script>
<!-- // Chart js -->


<script src="${pageContext.request.contextPath}/statics/assets/js/lib/sparklinechart/jquery.sparkline.min.js"></script><!-- scripit init-->
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/sparklinechart/sparkline.init.js"></script><!-- scripit init-->

<!--  Datamap -->
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/datamap/d3.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/datamap/topojson.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/datamap/datamaps.world.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/datamap/datamap-init.js"></script>
<!-- // Datamap -->-->
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/weather/jquery.simpleWeather.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/weather/weather-init.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/owl-carousel/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/lib/owl-carousel/owl.carousel-init.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/scripts.js"></script><!-- scripit init-->
</body>
</html>

