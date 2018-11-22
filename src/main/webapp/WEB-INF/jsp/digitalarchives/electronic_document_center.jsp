<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<html>

	<head>
		<meta charset="utf-8">
		<title>综合利用查询系统_电子文件中心</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css" />
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
		<style type="text/css">
			/*导航样式*/
			
			body .add_label_bg>.layui-layer-title,
			.btn_color {
				background: #EA5519;
				color: #FFFFFF;
			}
			
			.exchange_nav ul li a {
				width: 10%;
				display: inline-block;
				height: 38px;
				line-height: 38px;
				padding: 0 10px;
				background-color: #009688;
				color: #fff;
				white-space: nowrap;
				text-align: center;
				font-size: 14px;
				border: none;
				border-radius: 100px;
				cursor: pointer;
				float: left;
				margin: 20px 6%;
			}
			
			.exchange_nav ul li .a1 {
				background: #f0f2f9;
				color: #009688;
				border: 1px solid #009688;
			}
			
			.exchange_nav ul {
				height: 40px;
			}
			/*主体样式*/
			
			table tr th div,
			table tr td {
				text-align: center;
			}
			
			.layui-table-page {
				text-align: right;
			}
			/*检索*/
			
			.jiansuo,
			.jiansuo_tabel {
				background: #FFFFFF;
				padding-right: 15px;
				border: 1px solid #FFFFFF;
				border-radius: 8px;
				margin-top: 0px;
				box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .1);
			}
			/*预览图*/
			
			.nav_imgs li {
				float: left;
				width: 14%;
				margin: 15px 3%;
				text-align: center;
			}
			
			.nav_imgs li img {
				width: 100%;
				height: 100%;
			}
			/*查看*/
			
			.Scanning_Images {
				width: 100%;
				min-height: 400px;
				background: #FFFFFF;
			}
			
			.Scanning_Images li {
				float: left;
				width: 100px;
				height: 150px;
				background: #FFFFFF;
				margin-left: 28px;
				margin-top: 15px;
				text-align: right;
				box-shadow: 0.5px 1px 3px #000;
			}
			
			.Scanning_Images li img {
				width: 100%;
				height: 80%;
			}
			
			.Scanning_Images li button {
				border: none;
				outline: none;
				background: none;
				cursor: pointer;
			}
			
			.Scanning_Images li p {
				text-align: center;
			}
			
			.viewer-container,
			.viewer-fixed,
			.viewer-fade,
			.viewer-transition,
			.viewer-in {
				z-index: 99999999999!important;
				/*弹出层查看图片优先级提升*/
			}
			
			.btn1,
			.btn2 {
				margin: 30px 0;
				color: #ff9700;
				font-weight: bold;
				background: #f0f2f9;
				display: inline-block;
				height: 38px;
				width: 100%;
				line-height: 38px;
				padding: 0 18px;
				white-space: nowrap;
				text-align: center;
				font-size: 14px;
				border: none;
				border-radius: 100px;
				box-shadow: 0 2px 5px 0 #3d3d3d;
				cursor: pointer;
			}
			
			.btn1 i,
			.btn2 i {
				margin: 0 5px;
			}
		</style>
	</head>

	<body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin">

			<!--class 个性化设置nav_bg1-->
			<div class="copy">
				<!-- 版权所有 -->
				<p>COPYRIGHT&nbsp;&copy;2018
					<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有</p>
			</div>

			<div class="logo_nav" style="border-bottom: 1px dashed #C2C2C2;">
				<!-- 头部区域 -->
				<div>
					<span class="logo_img"><img src="../imgs/home.gif" width="110" height="50"/></span>
					<div class="logo">
					<c:if test="${zm:buttenPremission('la',sessionScope.user.role.authorities) }">
						<a href="${pageContext.request.contextPath}/information/godigitalarchives" style="color: #EA5519;">综合利用查询系统</a>
						</c:if>
						<a href="${pageContext.request.contextPath}/log/goHome" id="home">返回主页&gt;</a>
					</div>
				</div>

			</div>
			<!-- 主体内容 -->
			<div class="layui-body" id="index-bg" style="top:81px;left: 0;">
				<div class="layui-row">
					<div class="exchange_nav layui-col-sm12 layui-col-md12">
						<ul>
							<li>
								<a href="electronic_document_center.html" class="a1">电子文件中心</a>
							</li>
							<li>
								<a href="exchange.html">交流中心</a>
							</li>
							<li>
								<a href="reading-room.html">电子阅览室</a>
							</li>
							<li>
								<a href="archival-information.html">档案信息门户</a>
							</li>
						</ul>
					</div>
					<div class="layui-row" style="margin: 0px 15px;">
						<div class="layui-col-md3" style="padding: 15px;">
							<div class="layui-form jiansuo">
								<div style="text-align: center;width: 60%;margin: auto;">
									<button class="btn1"><i class="fa fa-download"></i>接收文件</button><br>
									<button class="btn2" id="test3"><i class="fa fa-upload"></i>导入文件</button>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">全宗名称</label>
									<div class="layui-input-block">
										<select name="city" lay-verify="required">
											<option value="">请选择</option>
											<option value="0">某某市安监局</option>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">文件年度</label>
									<div class="layui-input-block">
										<select name="city" lay-verify="required">
											<option value="">请选择</option>
											<option value="0">2017</option>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">接收/导入</label>
									<div class="layui-input-block">
										<input name="title" class="layui-input" required="" type="text" placeholder="开始时间" autocomplete="off"> 起
										<input name="title" class="layui-input" required="" type="text" placeholder="结束时间" autocomplete="off"> 止
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn  layui-btn-sm layui-btn-normal" lay-submit lay-filter="formDemo">查询</button>
									</div>
								</div>
							</div>
						</div>
						<div class="layui-col-md9" style="padding: 15px;">
							<div class="jiansuo">
								<div class="layui-card-header">
									<span style="color: #EA5519;font-weight: bold;"><i class="fa fa-th-list" style="padding: 0 5px;"></i>档案列表</span>
								</div>
								<div style="clear: both;">
									<div class="layui-tab-item layui-show">
										<table class="layui-hide" id="exchange_tabel" lay-filter="exchange_tabel"></table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--<table class="layui-hide" id="exchange_tabel" lay-filter="exchange_tabel"></table>-->
				</div>
				<script type="text/html" id="barDemo">
					<!-- 这里同样支持 laytpl 语法，如： -->
					<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
				</script>
			</div>
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!-- 图片预览插件 -->
		<script src="${pageContext.request.contextPath}/js/viewer.min.js"></script>
		<script type="text/javascript">
			layui.use('upload', function() {
				var $ = layui.jquery,
					upload = layui.upload;
				upload.render({
					elem: '#test3',
					url: '/upload/',
					accept: 'file' //普通文件
						,
					exts: 'docx',
					done: function(res) {
						console.log(res)
					}
				});
			});

			function img_vi() {
				$('.Scanning_Images').viewer();
			}
			layui.use('table', function() {
				var table = layui.table;

				//展示已知数据
				table.render({
					elem: '#exchange_tabel',
					cols: [
						[ //标题栏
							{
								field: 'id',
								title: '序号',
								width: 80,
								unresize: 'false',
								sort: true
							},
							{
								field: 'Quanzong_number',
								title: '全宗号',
								width: 120,
								unresize: 'false',
							},
							{
								field: 'Quanzong_name',
								title: '全宗名称',
								width: 120,
								unresize: 'false',
							},
							{
								field: 'Archivefile_anual',
								title: '文件年度',
								width: 100,
								unresize: 'false',
							},
							{
								field: 'Archivefile_createtime',
								title: '文件日期',
								width: 120,
								unresize: 'false',
							},
							{
								field: 'Archivefile_responsible',
								title: '责任人',
								width: 120,
								unresize: 'false',
							},
							{
								field: 'Archivefile_referencenumber',
								title: '文号',
								minWidth: 120,
								unresize: 'false',
							},
							{
								field: 'Archivefile_title',
								title: '题名',
								width: 300,
								unresize: 'false',
							},
							{
								field: 'Receiving_time',
								title: '接受/导入时间',
								width: 150,
								unresize: 'false',
							},
							{
								field: 'right',
								title: '操作',
								width: 100,
								unresize: 'false',
								toolbar: '#barDemo'
							}
						]
					],
					data: [{
						"id": "1",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "2",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "3",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "4",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "5",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "6",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "7",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "8",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "9",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "10",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "11",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, {
						"id": "12",
						"Quanzong_number": "021",
						"Quanzong_name": "某某市安监局",
						"Archivefile_anual": "2017",
						"Archivefile_createtime": "20170101",
						"Archivefile_responsible": "某某市安监局",
						"Archivefile_referencenumber": "某安发[2017]29号",
						"Archivefile_title": "某某市安监局关于认真落实环境保护计划的问题",
						"Receiving_time": "2018/01/01 00:00",
					}, ],
					skin: 'nob' //表格风格
						,
					even: false,
					page: true //是否显示分页
						//,limits: [5, 7, 10]
						,
					limit: 9 //每页默认显示的数量
				});
				//监听工具条
				table.on('tool(exchange_tabel)', function(obj) {
					var data = obj.data;
					var tr = obj.tr;

					if(obj.event === 'detail') {
						//layer.msg('ID：'+ data.id + ' 的查看操作');
						layer.open({
							type: 1,
							title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
							area: ['800px', '500px'],
							skin: 'add_label_bg',
							offset: 'auto',
							shade: [0.8, '#393D49'],
							content: '<div class="add_lb1">' +
								'<ul class="Scanning_Images" onclick="img_vi()">' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'<li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li>' +
								'</ul><div style="text-align:center;clear: both;">' +
								'<span>共<span>1000</span>件</span>' +
								'<span>第<select name="">' +
								'<option value="">1</option>' +
								'</select>页</span>' +
								'<span>共<span>12</span>页</span>' +
								'<span class="layui-btn layui-btn-xs">上一页</span>' +
								'<span class="layui-btn layui-btn-xs">下一页</span>' +
								'</div></div>'
						});
					}
				});
			});
		</script>
	</body>

</html>