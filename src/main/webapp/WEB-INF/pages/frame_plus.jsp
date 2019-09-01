<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/pages/common/head_plus.jsp"%>
<div class="content-wrap">
    <div class="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 p-0">
                    <div class="page-header">
                        <div class="page-title">
                            <div>
                                <label>你现在的位置是：
                                    <a href="#">主页</a></label>
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
                <div>
                    欢迎来到书店管理系统！
                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                    <div id="echarts" style="width: 1400px; height: 600px;"></div>
                </div>
            </div><!-- /# row -->
        </div><!-- /# container-fluid -->
    </div><!-- /# main -->
</div><!-- /# content wrap -->
<!-- 引入 echarts.js -->
<script src="${pageContext.request.contextPath}/statics/assets/js/echarts.min.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echarts'));
    //这个option的json格式是官方提供的，只需要按照这个格式写就行了
    option = {
        title: {
            text: '营业额记录图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['营业额','纯利润']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name:'营业额',
                type:'line',
                stack:'总量'
            },
            {
                name:'纯利润',
                type:'line',
                stack:'总量'
            }
        ]
    };

    //调用load函数，用于从后台获得数据并且传给option中的xAxis以及series（这两个用于显示柱状图）
    load(option);
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    //利用ajax技术从后台获取数据并且给option
    function load(option) {
        $.ajax({
            type : "post",
            async : false, //同步执行
            url : "${pageContext.request.contextPath}/echarts/lineChart", //后台处理的servlet路径
            data : {},
            dataType : "json", //返回数据形式为json
            success : function(result) { //如果ajax成功则后台json返回到result中
                if (result) {
                    //初始化数据
                    option.xAxis.data=[];
                    option.series[0].data = [];
                    option.series[1].data = [];
                    for (var i = 0; i < result.length; i++) {
                        option.xAxis.data.push(result[i].cashDate);
                        option.series[0].data.push(result[i].cashAmount);
                        option.series[1].data.push(result[i].cashProfit);
                    }
                }
            },
            error:function () {
                alert("错误");
            }
        });
    }
</script>

<%@include file="/WEB-INF/pages/common/foot_plus.jsp" %>
