<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<title>档案数量统计-件</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css" />
		<link href="${pageContext.request.contextPath}/css/skin_01.css" rel="stylesheet" type="text/css" id="skin">
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
		<style type="text/css">
			/*.layui-body{overflow-y: scroll;} 滚动条问题*/
			
			table tr th div,
			table tr td {
				text-align: center;
			}
			
			body .add_label_bg>.layui-layer-title,
			.btn_color {
				background: #EA5519;
				color: #FFFFFF;
			}
			
			.gong_color {
				color: red;
				font-weight: bold;
			}
			
			.viewer-container,
			.viewer-fixed,
			.viewer-fade,
			.viewer-transition,
			.viewer-in {
				z-index: 99999999999!important;
				/*弹出层查看图片优先级提升*/
			}
			
			#tba {
				padding-left: 10px;
				padding-bottom: 10px;
			}
			
			.a {
				color: #EA5519;
				border: 1px solid #EA5519!important;
				font-weight: bold;
			}
			
			.btn-a:hover {
				color: #EA5519;
				border: 1px solid #EA5519;
			}
			
			.btn-a {
				text-align: center;
				background: none;
				border: 1px solid #000;
				display: inline-block;
				padding: 5px 7px;
				border-radius: 5px;
				margin: 3px;
			}
			
			#bar-but {
				float: right;
			}
			
			#bar-but i {
				font-size: 20px;
				padding: 5px;
				cursor: pointer;
			}
			#demo{
				display: none;
			}
			/*表格隐藏*/
			/* [lay-filter='LAY-table-2'] {
				display: none;
			} */
			
			.layui-table-view{
				display: none;
			}
			.layui-table-view{
				margin: 0 auto!important;
			}
			@media print{ 
			 .notPrint {display:none;} 
			} 

		</style>
	</head>

	<body class="layui-layout-body">
		<div id="LAY_app">
			<div class="layui-layout layui-layout-admin">

				<!--class 个性化设置nav_bg1-->
				<div class="copy">
					<!-- 版权所有 -->
					<p>COPYRIGHT&nbsp;&copy;2018
						<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有</p>
				</div>

				<div class="logo_nav">
					<!-- 头部区域 -->
					<div>
						<span class="logo_img"><img src="${pageContext.request.contextPath}/imgs/home.gif" width="110" height="50"/></span>
						<span class="index_title">
	      				<span><a href="${pageContext.request.contextPath}/login/home.html">数字档案管理平台</a></span>
						</span>
					</div>
					<div class="layui-layout-right" id="nav_help" style="line-height:60px;font-weight:bold;font-size:18px;">
					  <a href="${pageContext.request.contextPath}/log/goHome">返回主页</a>
					</div>
				</div>

				<!-- 侧边菜单 -->
				<!--class 个性化设置nav_bg1-->
				<div class="layui-side layui-side-menu nav_bg1" id="menu_color" style="top:80px">
					<div class="layui-side-scroll nav_bg1">
						<!--class 个性化设置nav_bg1-->
						<div class="layui-logo nav_bg1" lay-href="#" style="margin-top: 80px;">
							<span>档案管理存储系统</span>
						</div>
						<ul class="layui-nav layui-nav-tree" lay-filter="test" id="nav_bar">
							<li class="layui-nav-item  layui-hide-xs"><img
							src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav1.png" /></li>
						<li class="layui-nav-item  layui-hide-xs "><c:if
								test="${zm:buttenPremission('b',sessionScope.user.role.authorities) }">
								<!-- INSERT INTO "SCOTT"."AM_MA_SM_PERMISSION" VALUES ('2', '系统设置', '/archive/archiveListShow', '/archiveManage/archiveManage', 'b'); -->
								<a
									href="${pageContext.request.contextPath}/archive/archiveListShow"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav2.png" />系统管理<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs "><c:if
								test="${zm:buttenPremission('c',sessionScope.user.role.authorities) }">
								<a
									href="${pageContext.request.contextPath}/recordedContent/goCatalog"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav3.png" />档案著录<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('d',sessionScope.user.role.authorities) }">
								<a
									href="${pageContext.request.contextPath}/danganmanage/goboxmanagement"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav4.png" />档案管理<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs "><c:if
								test="${zm:buttenPremission('e',sessionScope.user.role.authorities) }">
								<a
									href="${pageContext.request.contextPath}/fileQuery/goToFileQueryBoxList"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav5.png" />档案查询<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
								test="${zm:buttenPremission('f',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/report/queryByBox"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav6.png" />报表统计<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs ">
								<c:if test="${zm:buttenPremission('fc',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/FileBorrowingController/modeAndView">
									<img src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav7.png" />档案借阅<span>&gt;</span></a>
									</c:if>
							</li>
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('h',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/wareHouseBuild/wareHouseListShow"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav8.png" />库房管理<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('i',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/expiredFile/goDaoQi"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav9.png" />监测预警<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs "><c:if
								test="${zm:buttenPremission('j',sessionScope.user.role.authorities) }">
								<a
									href="${pageContext.request.contextPath}/inventoryManagement/goToInventoryManagement"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav10.png" />盘点管理<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('k',sessionScope.user.role.authorities) }">
								<a
									href="${pageContext.request.contextPath}/editingFile/goBianYan"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav11.png" />档案编研<span>&gt;</span></a>
							</c:if></li>
						</ul>
					</div>
				</div>

				<!--全宗导航-->
				<div id="" class="gong" style="left: 220px;text-align: left;">
					<c:if test="${zm:buttenPremission('bc',sessionScope.user.role.authorities) }">
						<p style="line-height: 38px;"><i class="fa fa-volume-up gong_color" style="padding:0 20px;"></i><span>
							<span class="gong_color">消息提示：</span>
							您有<span>${messageNum}</span>条<a href="${pageContext.request.contextPath}/messageNotification/goNotification" class="gong_color">未读</a>消息，请及时处理！</span>
						</p>
					</c:if>
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
						<ul class="layui-nav" id="top_nav">
						<li class="layui-nav-item layui-this">
							<a href="${pageContext.request.contextPath}/report/queryByBox">档案数量统计</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
						<c:if test="${zm:buttenPremission('fc',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/report/queryBorrow">档案借阅统计</a>
							</li><span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('fd',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/report/queryRejects">档案整理质量统计</a>
							</li>
						</c:if>
						
					</ul>
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-col-md12">
						<div class="layui-card">
							<div class="layui-card-body">
								<div id="tba">
									<a href="${pageContext.request.contextPath}/report/queryByBox" class="btn-a">盒统计</a>
									<a href="${pageContext.request.contextPath}/report/queryByFile" class="btn-a a">件统计</a>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-col-md12">
						<div class="layui-card">
							<div class="layui-card-header" style="text-align: center;">
								<div class="layui-form layui-form-item">
									<label class="layui-form-label">年度：</label>
									<div class="layui-input-inline">
										<select name="anual" id="year" lay-filter="test">
											<option value="">请选择</option>
											<c:forEach var="y" items="${anualList}">
												<option value="${y.anual}">${y.anual}</option>
											</c:forEach>
											<!-- <option value="0">2017</option> -->
										</select>
									</div>
									<span style="font-size: 20px;font-weight: bold;">档案数量统计-件</span>
									<div id="bar-but" class="layui-input-inline">
										<i class="fa fa-bar-chart" aria-hidden="true" id="buta"></i>
										<i class="fa fa-bars" aria-hidden="true" id="butb"></i>
										<i class="fa fa-download" aria-hidden="true" id="butc"></i>
										<i class="fa fa-print" aria-hidden="true" id="print"></i>
									</div>
								</div>

							</div>
							<div class="layui-card-body" style="height: 635px;">
								<div id="container" style="height: 100%;padding:0 20px;"></div>
								<!--startprint-->
									<table class="layui-table" id="demo" lay-filter="demo" style="padding: 0 5%;"></table>
								<!--endprint-->
							</div>
						</div>
					</div>

				</div>
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/echarts.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/messgeNum.js" type="text/javascript" charset="utf-8"></script>
		<!--ie下图表下载需要的库-->
		<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
		<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
         </script>
         
         <script>
		$(document).ready(function() {
			var jkk = 1;
			var dom = document.getElementById("container");
			//图表自适应
			window.onresize = function() {
				myChart.resize()
			}
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			var sert=[]
			
			app.title = '堆叠柱状图';
			myChart.setOption({
				tooltip: {
					show : true,
					trigger: 'axis',
					axisPointer: { // 坐标轴指示器，坐标轴触发有效
						type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				toolbox: {
					show: true,
					feature: {
						//mark : {show: true},
						//myTool2: {  
						//show: true,  
						//title: '报表',  
						//icon: 'image://http://echarts.baidu.com/images/favicon.png',  
						//onclick: function (){  
						//$('#container').hide()
						//} 
						//}, 
						// dataView : {show: true, readOnly: false},//数据视图
						// magicType: {show: true, type: ['line','bar']},//柱状图与折线图切换
						saveAsImage: {show: true} //图表下载jpg
					}
				},
				legend: {
					orient: 'vertical', // 'vertical'竖向显示
					x: 'left', // 'center' | 'left' | {number},
					y: 'center', // 'center' | 'bottom' | {number}
					backgroundColor: '#fff', //背景色
					borderColor: '#ccc', //线条颜色
					borderWidth: 1, //边框线宽
					padding: 15, // [5, 10, 15, 20]
					itemGap: 40, //上下距离
					textStyle: {
						color: '#000'
					}, //文字颜色
					data: []
				},
				dataZoom: [{
						show: true,
						realtime: true,
						start: 0,
						end: 50
					},
					{
						type: 'inside',
						realtime: true,
						start: 65,
						end: 85
					}
				],
				grid: {
					top: '10%',
					left: '10%',
					right: '5%',
					containLabel: true
				},
				xAxis: [{
					type: 'category',
					data: []
				}],
				yAxis: [{
					type: 'value'
				}],
				series: []
			});
			
			var loadEchar = function(anual){
				$.ajax({
					url : "../report/queryByFile22?l="+Math.random(),
					type : "post",
					async : false,
					cache : false,
					data : {"anual":anual},
					success : function(data) {
						console.log(data);
						//清空画布,防止缓存
				        myChart.clear();
						var ss = [];
						var series=[];
						var pcname=[];
						pcname = data.valueArray
						 for (var p=0; p<data.valueArray.length;p++) {
							 ss = data.valueNum[p];
							  series.push({
									name : data.valueArray[p],
									type: 'bar',
									stack: '档案数量统计',
								    data: ss
							 });
						}
							myChart.setOption({
								xAxis : {
									data : data.keyArray,
									triggerEvent : true
								},
								yAxis: [{
									type: 'value'
								}],
								series: series,
								 legend: [ {
									data : pcname
								} ] 
							}); 
						
						myChart.setOption({
							tooltip: {
								show : true,
								trigger: 'axis',
								axisPointer: { // 坐标轴指示器，坐标轴触发有效
									type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							toolbox: {
								show: true,
								feature: {
									//mark : {show: true},
									//myTool2: {  
									//show: true,  
									//title: '报表',  
									//icon: 'image://http://echarts.baidu.com/images/favicon.png',  
									//onclick: function (){  
									//$('#container').hide()
									//} 
									//}, 
									// dataView : {show: true, readOnly: false},//数据视图
									// magicType: {show: true, type: ['line','bar']},//柱状图与折线图切换
									saveAsImage: {show: true} //图表下载jpg
								}
							},
							dataZoom: [{
									show: true,
									realtime: true,
									start: 0,
									end: 50
								},
								{
									type: 'inside',
									realtime: true,
									start: 65,
									end: 85
								}
							],
							grid: {
								top: '10%',
								left: '10%',
								right: '5%',
								containLabel: true
							},
							xAxis : {
								data : data.keyArray,
								triggerEvent : true
							},
							yAxis: [{
								type: 'value'
							}],
							series: {
								barWidth: 300,
							},
							/* series:series, */
							legend: {
								orient: 'vertical', // 'vertical'竖向显示
								x: 'left', // 'center' | 'left' | {number},
								y: 'center', // 'center' | 'bottom' | {number}
								backgroundColor: '#fff', //背景色
								borderColor: '#ccc', //线条颜色
								borderWidth: 1, //边框线宽
								padding: 15, // [5, 10, 15, 20]
								itemGap: 40, //上下距离
								textStyle: {
									color: '#000'
								}, //文字颜色
								data : pcname
							},
						});
					}
				});  
			}
			//loadEchar(anual); 
			if(option && typeof option === "object") {
				myChart.setOption(option, true);
			}
		
		var form = layui.form;
		
			//删除图标点击事件
			$("#buta").click(function() {
				$('#container').show();
				$('#demo').hide();
				$(".layui-table-view").css('display', 'none');
				//要执行一次查询图表的方法
				jkk = 1;
			});
			
			$("#butb").click(function() {
				var values = $("#year").val();
						$('#container').hide();
						$('#demo').show();
						jkk=2
						//var values
						if(jkk==2){
						  form.on('select', function(data){
						  	values=data.value   
							layui.use('table', function() {
							var table = layui.table;
							var  $ = layui.$;
							//展示已知数据
							table.render({
								elem: '#demo',
								width:1000,
								cellMinWidth: 80,
								url: '${pageContext.request.contextPath}/report/queryByFileTable?anual='+values,
								cols: [
									[ //标题栏
										{
											type: 'numbers',
											title: '序号',
											unresize: 'false',
											templet: '#indexTpl',
										}, {
											field: 'quanzongname',
											title: '全宗名称',
											unresize: 'false',
										}, {
											field: 'pcname',
											title: '档案类型',
											unresize: 'false',
										}, {
											field: 'sumnum',
											title: '档案数量-件',
											unresize: 'false',
										},
									]
								],
								even: true,
								page: true //是否显示分页
									//,limits: [5, 7, 10]
									,
								limit: 10 //每页默认显示的数量
							});
						  });
						  if(jkk==2){
							  $(".layui-table-view").css('display', 'block');
						  }else{
							  $(".layui-table-view").css('display', 'none');
						  }
						 });
						}
					}); 
			
			loadEchar('');
			form.on('select(test)', function(data){
				  values=data.value
				  loadEchar(values);
			}); 
		});
		</script>
		
		<script type="text/javascript">
		$(function(){
			$("#butc").click(function() {
				var anual = $("#year").val();
				window.location.href="${pageContext.request.contextPath}/report/fileExportExcel?anual="+anual;
			});
			
			$("#print").click(function(){
				$(".layui-table-page").css("display","none");//打印分页隐藏
				bdhtml=window.document.body.innerHTML; 
				sprnstr="<!--startprint-->"; 
				eprnstr="<!--endprint-->"; 
				prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
				prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
				window.document.body.innerHTML=prnhtml; 
				window.print(); 
				window.location.reload();
			});
		})
		</script>
	</body>

</html>