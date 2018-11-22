<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>档案借阅_档案借阅</title>
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
			
			#shenqingjieyue,#guih{
				display: none;
			}
			
			.font-i {
				color: #EA5519;
				font-weight: bold;
				cursor: pointer;
			}
			
			.font-w {
				font-weight: bold;
				cursor: pointer;
			}
			
			.put {
				display: inline-block;
				width: 80%;
			}
			
			.line-h {
				line-height: 36px;
			}
			
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
			.rad{
				padding:0 10px;
			}
			.rad>input{
				cursor: pointer;
			}
			.ltext{
				/* padding: 10px; */
    			font-size: 16px;
   			 	color: #fff;
   			 	cursor: pointer;
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
	      				<span><a href="${pageContext.request.contextPath}/log/goHome">数字档案管理平台</a></span>
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
						<li class="layui-nav-item  layui-hide-xs"><c:if
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
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('e',sessionScope.user.role.authorities) }">
								<a
									href="${pageContext.request.contextPath}/fileQuery/goToFileQueryBoxList"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav5.png" />档案查询<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('f',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/report/queryByBox"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav6.png" />报表统计<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs layui-this">
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
						<li class="layui-nav-item  layui-hide-xs"><c:if
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
							<span class="gong_color">消息提示：</span> 您有
							<span>${requestScope.messageNum}</span>条
							<a href="${pageContext.request.contextPath}/messageNotification/goNotification" class="gong_color">未读</a>消息，请及时处理！</span>
						</p>
					</c:if>
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						<c:if test="${zm:buttenPremission('ga',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
							 	<a href="${pageContext.request.contextPath}/FileBorrowingController/modeAndView">借阅申请</a>
							</li><span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('gb',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
							 	<a href="${pageContext.request.contextPath}/FileBorrowingController/modeAndView2">借阅审核</a>
							</li>
						</c:if>
					</ul>
				</div>
				<!-- 主体内容 开始-->
				<div class="layui-body" id="LAY_app_body" style="top:180px;padding: 15px;">
					<div class="layui-row layui-col-space15">
						<div class="layui-col-md6">
							<div class="layui-card">
								<div class="layui-card-header">借阅申请</div>
								<hr class="layui-bg-black">
								<div class="layui-card-body">
									<div class="layui-form">
										<input type="hidden" id="borrowDatas" value=""/>
										<div class="layui-row layui-col-space10 layui-form-item">
											<div class="layui-col-lg6">
												<label class="layui-form-label">全宗名称：</label>
												<div class="layui-input-block">
													<select name="type" lay-verify="required" lay-filter="quanzongName" id="quanzongName">
														<option value="">请选择</option>
														<c:forEach var="qzList" items="${qzList}">
															<option value="${qzList.borrowdetailsId }">${qzList.quanzongName }</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg6">
												<label class="layui-form-label">档案年度：</label>
												<div class="layui-input-block" id="annual">
													<select name="borrowdetailsAnnual" lay-verify="required" lay-filter="borrowdetailsAnnual" id="borrowdetailsAnnual">
														<option value="">请选择</option>
														<c:forEach var="ndList" items="${ndList}">
															<option value="${ndList.borrowdetailsAnnual }">${ndList.borrowdetailsAnnual }</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg8">
												<label class="layui-form-label">关键词：</label>
												<div class="layui-input-block">
													<input type="text" name="title" id="borrowdetailsTitle" placeholder="请输入关键词" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg4" style="text-align: center;">
											<c:if test="${zm:buttenPremission('gaa',sessionScope.user.role.authorities) }">
												<button class="layui-btn layui-btn-normal" id="qyeryLoanApplication">查询</button>
											</c:if>
											</div>
										</div>
									</div>
									<table class="layui-table" id="demo"></table>
									<div style="text-align: right;padding:15px 0;" class="layui-btn-group demoTable">
									<c:if test="${zm:buttenPremission('gab',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-danger layui-btn-sm" data-type="getCheckData" id="jieyue">申请借阅</button>
									</c:if>
									</div>
								</div>
							</div>
						</div>
						<div class="layui-col-md6">
							<div class="layui-card" id="jySX">
								<div class="layui-card-header">借阅记录</div>
								<hr class="layui-bg-black">
								<div class="layui-card-body">
									<form class="layui-form" action="" lay-filter="component-form-element">
										<div class="layui-row layui-col-space10 layui-form-item">
											<div class="layui-col-lg4">
												<label class="layui-form-label">档案载体：</label>
												<div class="layui-input-block">
													<select name="type" class="borrowRecordsCarrier1" id="borrowRecordsCarrier1" lay-verify="required" lay-filter="borrowRecordsCarrier1">
														<option value="0">请选择</option>
														<option value="1">纸质原件</option>
														<option value="2">复印件</option>
														<option value="3">电子原件</option>
													</select>
												</div>
											</div>
											<div class="layui-col-lg4">
												<label class="layui-form-label">状态：</label>
												<div class="layui-input-block">
													<select name="type" class="borrowRecordsStatus1"  id="borrowRecordsStatus1" lay-verify="required" lay-filter="borrowRecordsStatus1">
														<option value="0">请选择</option>
														<option value="1">待审核</option>
														<option value="2">已驳回</option>
														<option value="3">已通过</option>
														<option value="4">已归还</option>
													</select>
												</div>
											</div>
										</div>
									</form>
									<table class="layui-table" id="demotwo" lay-filter="demotwo"></table>
								</div>
							</div>
							<script type="text/html" id="barDemo">

							{{#  if(d.borrowRecordsStatus == '待审核' || d.borrowRecordsStatus == '已驳回' || d.borrowRecordsStatus == '已归还' ){  }}
								<a class="layui-btn layui-btn-xs" lay-event="Tdetail">借阅明细</a>
								<a class="layui-bg-gray layui-btn layui-btn-normal layui-btn-xs" lay-event="#">归还</a>
								<a class="layui-bg-gray layui-btn layui-btn-danger layui-btn-xs" lay-event="#">续借</a>
		 					{{#  } else if(d.borrowRecordsStatus == '已通过'){ }}
								<a class="layui-btn layui-btn-xs" lay-event="Tdetail">借阅明细</a>
								<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="Treturn">归还</a>
								<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="renew">续借</a>
							{{#  }  }}
							</script>
							<script type="text/html" id="bar">
							{{#  if(d.userId == '1' || d.userId == '2'){  }}
								<a class="layui-bg-gray layui-btn layui-btn-normal layui-btn-xs" lay-event="#">查看</a>
							{{#  } else{ }}
								<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
							{{#  }  }}
							</script>
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
		<script src="${pageContext.request.contextPath}/js/viewer.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/loginout.js" type="text/javascript" charset="utf-8"></script>

<script>
	function img_vi() {
		$('.Scanning_Images').viewer();
	}
	//获取全宗主键
	var quanzongName = $("#quanzongName option:selected").val();
	//获取年度
	var borrowdetailsAnnual = $("#borrowdetailsAnnual option:selected").val();
	//获取关键词
	var borrowdetailsTitle = $("#borrowdetailsTitle").val();
	var qyeryLoanApplication = document.getElementById("qyeryLoanApplication");
	/* 模糊查询 */
	qyeryLoanApplication.onclick = function(quanzongName,borrowdetailsAnnual,borrowdetailsTitle){
		//获取全宗主键
		var quanzongName = $("#quanzongName option:selected").val();
		//获取年度
		var borrowdetailsAnnual = $("#borrowdetailsAnnual option:selected").val();
		//获取关键词
		var borrowdetailsTitle = $("#borrowdetailsTitle").val();
		console.log(quanzongName,borrowdetailsAnnual,borrowdetailsTitle);
		$.ajax({
			url:"${pageContext.request.contextPath}/FileBorrowingController/borrowQueryFile",
			type:"post",
			async:false,
			data:{
				"quanzongName":quanzongName,
				"borrowdetailsAnnual":borrowdetailsAnnual,
				"borrowdetailsTitle":borrowdetailsTitle},
			success:function(data){
				console.log(data);
				BorrowDetailsFunction(data);
			}
		});
	}
	console.log(qyeryLoanApplication);
	
	//档案载体
	var borrowRecordsCarrier;
	for (var i = 0; i < $("#borrowRecordsCarrier1")[0].length; i++) {
		if($("#borrowRecordsCarrier1")[0][i].selected == true){
			borrowRecordsCarrier = $("#borrowRecordsCarrier1")[0][i].value;
		}
	}
	//状态
	var borrowRecordsStatus;
	for (var i = 0; i < $("#borrowRecordsStatus1")[0].length; i++) {
		if($("#borrowRecordsStatus1")[0][i].selected == true){
			borrowRecordsStatus = $("#borrowRecordsStatus1")[0][i].value;
		}
	}
	//借阅记录查询方法
	var BorrowRecordsQuery = function(borrowRecordsCarrier,borrowRecordsStatus){
		var datas;
		$.ajax({
			url:"${pageContext.request.contextPath}/FileBorrowingController/borrowRecordsQuery",
			type:"post",
			async:false,
			data:{
				"borrowRecordsCarrier":borrowRecordsCarrier,
				"borrowRecordsStatus":borrowRecordsStatus
			},
			success:function(data){
				datas = data;
				
			}
		})
		return datas;	
	}
	//借阅记录数据渲染
	var queryborrowrecords = function (borrowRecordsCarrier,borrowRecordsStatus){
		layui.use('table', function() {
			var table = layui.table;
			var form = layui.form;
			//借阅记录渲染
			tabletwoRender(table,borrowRecordsCarrier,borrowRecordsStatus);
		})
	}
	//借阅记录渲染
	var tabletwoRender = function(table,borrowRecordsCarrier,borrowRecordsStatus){
		table.render({
			elem: '#demotwo',
			cellMinWidth: 80,
			/*url: '/api/upload/time=new Date();',*/
			cols: [
				[ //标题栏
					{
						field: 'id',
						title: '序号',
						type: 'numbers', 
						unresize: 'false',
						sort: true
					}, {
						field: 'borrowRecordsBorrowDate',
						title: '借阅日期',
						width: 150,
						unresize: 'false',
					}, {
						field: 'borrowRecordsNumber',
						title: '借阅件数',
						unresize: 'false',
					}, {
						field: 'borrowRecordsCarrier',
						title: '档案载体',
						unresize: 'false',
					}, {
						field: 'borrowRecordsStatus',
						title: '状态',
						event: 'setSign',
						unresize: 'false',
					},
					{
						field: 'right',
						title: '操作',
						width: 200,
						unresize: 'false',
						toolbar: '#barDemo'
					},
				]
			],
			data: BorrowRecordsQuery(borrowRecordsCarrier,borrowRecordsStatus).data,
				//,skin: 'line' //表格风格
			even: true,
			page: true //是否显示分页
			,limits: [5, 7, 10]
			,limit: 5 //每页默认显示的数量
		});
	}
	/* 页面数据渲染封装 */
	var BorrowDetailsFunction = function(data){
		layui.use('table', function() {
			var table = layui.table;
			var form = layui.form;
			var laypage = layui.laypage;
			//展示已知数据
			table.render({
				elem: '#demo',
				cellMinWidth: 80,
				/*url: '/api/upload/time=new Date();',*/
				cols: [
					[ //标题栏
						{
							type: 'checkbox',
							fixed: 'left'
						},
						{
							field: 'id',
							title: '序号',
							type: 'numbers', 
							unresize: 'false',
							sort: true
						}, {
							field: 'quanzongName',
							title: '全宗名称',
							unresize: 'false',
						}, {
							field: 'borrowdetailsAnnual',
							title: '档案年度',
							unresize: 'false',
						}, {
							field: 'borrowdetailsTitle',
							title: '题名',
							unresize: 'false',
						}, {
							field: 'userId',
							title: '密级',
							unresize: 'false',
						},
					]
				],
				data:data.data,
				even: true,
				page: true //是否显示分页
				,limits: [5, 7, 10]
				,limit: 5 //每页默认显示的数量
			});
			/* 借阅记录数据渲染 */
			queryborrowrecords(borrowRecordsCarrier,borrowRecordsStatus);
			table.on('tool(demotwo)', function(obj) {
				var data = obj.data;
				//审核状态
				var dataType = data;
				if(obj.event === 'Tdetail') {
					layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>借阅明细',
						area: ['800px', '600px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						content: $('#mingxi').html(),
					});
					//获取该行的借阅记录主键ID
					var borrowRecordsId = data.borrowRecordsId;
					/* 借阅记录 - 借阅明细功能属性赋值 */
					//借阅人姓名
					$("#borrowRecordsName2")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsName;
					//借阅人所属部门
					$("#borrowRecordsDepartment2")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsDepartment;
					//借阅期限
					$("#borrowRecordsBorrowDate2")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsBorrowDate;
					//归还期限
					$("#borrowRecordsReturnDate2")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsReturnDate;
					console.log($("#borrowRecordsBorrowDate2")[0].textContent);
					console.log($("#borrowRecordsReturnDate2")[0].textContent);
					//档案载体
					$("#borrowRecordsCarrier2")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsCarrier;
					//借阅事由
					$("#borrowRecordsReason2")[0].value = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsReason;
					layui.use('table', function() {
						var table = layui.table;
						//展示已知数据
						table.render({
							elem: '#ming',
							cellMinWidth: 80,
							/*url: '/api/upload/time=new Date();',*/
							cols: [
								[ //标题栏
									{
										field: 'id',
										title: '序号',
										type: 'numbers',
										unresize: 'false',
										sort: true
									}, {
										field: 'quanzongName',
										title: '全宗名称',
										unresize: 'false',
									}, {
										field: 'borrowdetailsAnnual',
										title: '档案年度',
										unresize: 'false',
									}, {
										field: 'borrowdetailsTitle',
										title: '题名',
										unresize: 'false',
									},
									{
										field: 'right',
										title: '操作',
										unresize: 'false',
										toolbar: '#bar'
									},
								]
							],
							data:borrowRecordsLoanDetails(borrowRecordsId)[1].data,
								//,skin: 'line' //表格风格
							even: true,
							page: true //是否显示分页
							,limits: [5, 7, 10]
							,limit: 5 //每页默认显示的数量
						});
						
						//监听工具条
						table.on('tool(ming)', function(obj) {
							var data = obj.data;
							var tr = obj.tr;
							if(dataType.borrowRecordsStatus == '已通过'){
								/* 查看明细中的查看图片 */
								if(obj.event === 'detail') {
									$.ajax({
										url:"${pageContext.request.contextPath}/archiveFileStore/havingFileAttachmentList",
										type:"post",
										data:"archiveFileId="+data.archivefileId,
										dataType:"json",
										success:function(result){
											var text=""
												text+="<div class='add_lb1'><ul class='Scanning_Images' onclick='img_vi()'>"
											for(var i=0;i<result.length;i++){
												var url='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'+result[i].fileAttachmentPath;
												text+="<li><img src='"+url+"?"+Math.random()+"' alt=''><p>"+result[i].fileAttachmentPageNumber+"</p></li>"
											}
											text+="</ul></div>";
											
											layer.open({
												type: 1,
												title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
												area: ['800px', '400px'],
												skin: 'add_label_bg',
												offset: 'auto',
												shade: [0.8, '#393D49'],
												content: text,
											});
										}
									})
								}else if(obj.event === 'edit'){
									window.location.href="${pageContext.request.contextPath}/archiveFileStoreModify/goArchiveFileStoreEdit?archiveFileId="+archiveFileId;
								}
							}else{
								layer.msg("抱歉该文件状态为'"+dataType.borrowRecordsStatus+"'！您没有访问权限！");
							}
						});

					});
				}else if(obj.event === 'Treturn') {
					layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>归还',
						area: ['500px', '400px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						content: $('#guih').html(),
						btn: ['确定', '取消']
						,yes: function() {
							//非空判断
							if($("input[name='set']:checked").length != 0){
								if($("textarea[name='borrowRecordsInstructions']")[1].value == '' || $("textarea[name='borrowRecordsInstructions']")[1].value == null){
									layer.msg("请填写利用效果说明！");	
								}else{
									/* 归还功能 */
									var borrowtype = "1";
									ReturnFunction(borrowtype,data.borrowRecordsId,$("input[name='set']:checked")[0].value,$("textarea[name='borrowRecordsInstructions']")[1].value);
								}
							}else{
								layer.msg("请选择利用效果评价");
							}
							
						},
						btn2: function() {
							layer.closeAll();
						}
					});
				} else if(obj.event === 'renew') {
					layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>续借',
						area: ['800px', '600px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						content: $('#xujie').html(),
						btn: ['确定', '取消']
						,yes: function() {
							//非空判断
							console.log($("#borrowRecordsReturnDate3")[0].value);
							if($("#borrowRecordsReturnDate3")[0].value != ''){
								if($("#borrowRecordsReason3")[0].value != ''){
									/* 续借 */
									var borrowtype = "2";
									
									var starttime = $('#borrowRecordsBorrowDate3')[0].textContent;
									var borrowRecordsReturnDate = $("#borrowRecordsReturnDate3")[0].value;
									var endtime = borrowRecordsReturnDate;
									var start = new Date(starttime.replace("-", "/"));
									var end = new Date(endtime.replace("-", "/"));
									if(end>start){
										ReturnFunction(borrowtype,data.borrowRecordsId,$("#borrowRecordsReturnDate3")[0].value,$("#borrowRecordsReason3")[0].value);
									}else{
										layer.msg("归还时间不得大于借阅时间！ ");
									}
									 
								}else{
									layer.msg("请填写借阅事由！");
								}
							}else{
								layer.msg("请选择归还日期！");
							}
						},
						btn2: function() {
							layer.closeAll();
						}
					});
					//时间控件
					layui.use(['layer', 'laydate'], function(){
						var layer = layui.layer // 获取layer组件
					    ,laydate = layui.laydate; // 获取laydate组件
					    //执行一个laydate实例
						laydate.render({
						  elem: '#borrowRecordsReturnDate3' //指定元素
						});
					}); 
					//获取该行的借阅记录主键ID
					var borrowRecordsId = data.borrowRecordsId;
					/* 借阅记录 - 借阅明细功能属性赋值 */
					//借阅人姓名
					$("#borrowRecordsName3")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsName;
					//借阅人所属部门
					$("#borrowRecordsDepartment3")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsDepartment;
					//借阅期限
					$("#borrowRecordsBorrowDate3")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsBorrowDate;
					console.log($("#borrowRecordsBorrowDate3")[0].textContent);
					//档案载体
					$("#borrowRecordsCarrier3")[0].textContent = borrowRecordsLoanDetails(borrowRecordsId)[0].data[0].borrowRecordsCarrier;
					
					layui.use('table', function() {
						var table = layui.table;
						//展示已知数据
						table.render({
							elem: '#xu',
							cellMinWidth: 80,
							/*url: '/api/upload/time=new Date();',*/
							cols: [
								[ //标题栏
									{
										field: 'id',
										title: '序号',
										type: 'numbers',
										unresize: 'false',
										sort: true
									}, {
										field: 'quanzongName',
										title: '全宗名称',
										unresize: 'false',
									}, {
										field: 'borrowdetailsAnnual',
										title: '档案年度',
										unresize: 'false',
									}, {
										field: 'borrowdetailsTitle',
										title: '题名',
										unresize: 'false',
									},
									{
										field: 'right',
										title: '操作',
										unresize: 'false',
										toolbar: '#bar'
									},
								]
							],
							data:borrowRecordsLoanDetails(borrowRecordsId)[1].data,
								//,skin: 'line' //表格风格
								
							even: true,
							page: true, //是否显示分页
							limits: [5, 7, 10],
							limit: 5 //每页默认显示的数量
						});
						//监听工具条
						table.on('tool(xu)', function(obj) {
							var data = obj.data;
							var tr = obj.tr;
							if(obj.event === 'detail') {
								$.ajax({
									url:"${pageContext.request.contextPath}/archiveFileStore/havingFileAttachmentList",
									type:"post",
									data:"archiveFileId="+data.archivefileId,
									dataType:"json",
									success:function(result){
										console.log(result);
										var text=""
											text+="<div class='add_lb1'><ul class='Scanning_Images' onclick='img_vi()'>"
										for(var i=0;i<result.length;i++){
											var url='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'+result[i].fileAttachmentPath;
											text+="<li><img src='"+url+"?"+Math.random()+"' alt=''><p>"+result[i].fileAttachmentPageNumber+"</p></li>"
										}
										text+="</ul></div>";
										
										layer.open({
											type: 1,
											title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
											area: ['800px', '400px'],
											skin: 'add_label_bg',
											offset: 'auto',
											shade: [0.8, '#393D49'],
											content: text,
										});
									}
								})
							}else if(obj.event === 'edit'){
								window.location.href="${pageContext.request.contextPath}/archiveFileStoreModify/goArchiveFileStoreEdit?archiveFileId="+archiveFileId;
							}
						});

					});
				}else if(obj.event === 'setSign'){
					var tipsi;
					if(obj.data.borrowRecordsStatus  == '已驳回'){
						/* tipsi = layer.tips(obj.data.borrowrecordsReasonrejection,this,{tips: [1, '#3595CC'],area: ['100px'],time: 4000}); */
						tipsi = layer.tips('<span class="ltext">'+obj.data.borrowrecordsReasonrejection+'</span>',this,{tips:[1, '#3595CC'],area:'auto',maxwidth:'280px',time: 4000});
						setTimeout(function(){layer.close(tipsi)}, 2000);//该方法2秒钟之后执行，在这2秒钟之前可以进行其他的操作
					} 
				}
			});
			
			//定义集合并解析
			var demoArray = new Array();
			 //定义参数
		      var archivefileId;
		      var quanzongNumber;
		      var quanzongName;
		      var borrowdetailsAnnual;
		      var borrowdetailsTitle;
		      var borrowrecordsId;
		      var userId;
			//复选框监听
			var $ = layui.$, active = {
				    getCheckData: function(){ //获取选中数据
				      var checkStatus = table.checkStatus('demo')
				      ,data = checkStatus.data;
				      var x = JSON.stringify(data);
				      demoArray = JSON.parse(x);
					  //定义一个数组存储集合
					  var demoList = [];
					  for (var i = 0; i < demoArray.length; i++) {
					  	  demoList.push({
					  		archivefileId:demoArray[i].borrowdetailsId,
							quanzongNumber:demoArray[i].quanzongNumber,
							quanzongName:demoArray[i].quanzongName,
							borrowdetailsAnnual:demoArray[i].borrowdetailsAnnual,
							borrowdetailsTitle:demoArray[i].borrowdetailsTitle,
							borrowrecordsId:demoArray[i].borrowrecordsId,
							userId:demoArray[i].userId
								
						});
					}
					demoListFunction(demoList);
				}
			}
	
		  $('.demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
		  //ajax传递该对象
		  var demoListFunction = function(demoList){
			  $.ajax({
				  url:"${pageContext.request.contextPath}/FileBorrowingController/borrowQueryList",
				  type:"post",
			      async:false,
			      data:JSON.stringify(demoList),// 指定请求的数据格式为json，实际上传的是json字符串
			      contentType: "application/json;charset=UTF-8",
				  success:function(data){
				  	//获取AJAX返回的数据
				  	queryborrowLayer(data);
				  }
				  
			  })
		  }
		  	/* 档案借阅下拉框点击事件 */
		  	form.on('select(quanzongName)', function(data){
		  		var quanzongNumber = data.value;
		  		$("#borrowdetailsAnnual").empty();
		  		$.ajax({
		  			url:"${pageContext.request.contextPath}/FileBorrowingController/annualList",
		  			type:"post",
		  			async:false,
		  			data:{
		  				"quanzongNumber":quanzongNumber
		  			},
		  			success:function(data){
				  		/* var annualSelect = ; */
				  		if(data == '' || data == null){
				  			$("#borrowdetailsAnnual").append("<select name='borrowdetailsAnnual' lay-verify='required' lay-filter='borrowdetailsAnnual' id='borrowdetailsAnnual'><option value=''>请选择</option></select>");
			  				layui.use('form', function() {
			  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  			        form.render();
			  			    });			
				  		}else{
				  			var options;
				  			$("#borrowdetailsAnnual").append("<option value=''>请选择</option>");
				  			console.log(data);
				  			for (var i = 0; i < data.length; i++) {
				  				options = "<option value='"+data[i].borrowdetailsAnnual+"'>"+data[i].borrowdetailsAnnual+"</option>";
				  				$("#borrowdetailsAnnual").append(options);
							}
			  				layui.use('form', function() {
			  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  			        form.render();
			  			    });				  			
				  		}
		  			}
		  		});
		  	})
			/* 档案记录下拉框多个监听事件 */
		  	form.on('select', function(data){
		  	  //定义档案载体
			  var borrowRecordsCarrier = null;
			  if(data.elem.id == 'borrowRecordsCarrier1'){
				  borrowRecordsCarrier = data.value;
				  console.log(borrowRecordsCarrier);
			  	  //获取审核状态
			  	  var borrowRecordsStatus = null;
				  for (var i = 0; i < $("#borrowRecordsStatus1")[0].length; i++) {
						if($("#borrowRecordsStatus1")[0][i].selected == true){
							borrowRecordsStatus = $("#borrowRecordsStatus1")[0][i].value;
							console.log(borrowRecordsStatus);
						}
			 		 }	
				  console.log(borrowRecordsCarrier);
				  console.log(borrowRecordsStatus);
				  //判断如果是0就为null
				  if(borrowRecordsStatus == "0"){
					  borrowRecordsStatus = null;
					  queryborrowrecords(borrowRecordsCarrier,borrowRecordsStatus);  
				  }else{
					  queryborrowrecords(borrowRecordsCarrier,borrowRecordsStatus); 
				  }
				  
			  
			  }
			  //定义审核状态
			  var borrowRecordsStatus = null;
			  if(data.elem.id == 'borrowRecordsStatus1'){
				    borrowRecordsStatus = data.value;
				    //获取档案载体
				    var borrowRecordsCarrier = null;
					for (var i = 0; i < $("#borrowRecordsCarrier1")[0].length; i++) {
						if($("#borrowRecordsCarrier1")[0][i].selected == true){
							borrowRecordsCarrier = $("#borrowRecordsCarrier1")[0][i].value;
						}
					}
					//判断如果是0就为null
					  if(borrowRecordsCarrier == "0"){
						  borrowRecordsCarrier = null;
						  queryborrowrecords(borrowRecordsCarrier,borrowRecordsStatus);  
					  }else{
						  queryborrowrecords(borrowRecordsCarrier,borrowRecordsStatus);
					  }
			  }
			  
			});
		});
	};
	/* 页面数据加载 */
	var modeAjax = function(quanzongNumber,borrowrecordsId){
		$.ajax({
			url:"${pageContext.request.contextPath}/FileBorrowingController/borrowQueryFile",
			type:"post",
			async:false,
			data:{
				"quanzongNumber":quanzongNumber,
				"borrowrecordsId":borrowrecordsId,
				"quanzongName":quanzongName,
				"borrowdetailsAnnual":borrowdetailsAnnual,
				"borrowdetailsTitle":borrowdetailsTitle},
			success:function(data){
				BorrowDetailsFunction(data);
			}
		});
	}
	modeAjax();
	/* 通过封装函数获取后台返回值 */
	var borrow = 1;
	var borrowDatas = queryborrowLayer = function(data){
		//可以这样来存数据（重点）
		$("#borrowDatas").data("result",data)
		//取值方法（重点）
		$("#borrowDatas").data("result");
		return data;
	}
	
			$(function() {
				//须提前判断是否有checkbox勾选，不然则提示请勾选要执行的计划
				$("#jieyue").click(function() { //#btn为按钮id
					layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>申请借阅单',
						area: ['800px', '600px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						content: $('#shenqingjieyue').html(),
					});
					//时间控件
					layui.use(['layer', 'laydate'], function(){
						var layer = layui.layer // 获取layer组件
					    ,laydate = layui.laydate; // 获取laydate组件
					    //执行一个laydate实例
						laydate.render({
						  elem: '#borrowRecordsReturnDate' //指定元素
						});
					}); 
					    
					//取值方法(重点)
					var array = new Array();
					array = $("#borrowDatas").data("result");
					/* 给弹出层赋值（借阅人姓名）  */
					var borrowRecordsName = $("#borrowRecordsName")[0].textContent = array[1].data[0];
					/* 给弹出层赋值（借阅人所属部门） */
					var borrowRecordsDepartment = $("#borrowRecordsDepartment")[0].textContent = array[1].data[1];
					/* 给弹出层赋值（借阅人借阅日期） */
					var myDate = new Date();
					
					//时间格式转换
					var date = myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate() 
					/* var date = myDate.toLocaleDateString(); */
					var borrowRecordsBorrowDate = $("#borrowRecordsBorrowDate")[0].value = date;
					/* 借阅明细/记录添加点击事件 */
					insertDetailsRecords(array[0].data,borrowRecordsName,borrowRecordsDepartment,borrowRecordsBorrowDate);
					layui.use('table', function() {
						var table = layui.table;
						//展示已知数据
						table.render({
							elem: '#demotw',
							cellMinWidth: 80,
							/*url: '/api/upload/time=new Date();',*/
							cols: [
								[ //标题栏
									{
										field: 'id',
										title: '序号',
										unresize: 'false',
										type: 'numbers', 
										sort: true
									}, {
										field: 'quanzongName',
										title: '全宗名称',
										unresize: 'false',
									}, {
										field: 'borrowdetailsAnnual',
										title: '档案年度',
										unresize: 'false',
									}, {
										field: 'borrowdetailsTitle',
										title: '题名',
										unresize: 'false',
									},
								]
							],
							data:array[0].data,
							even: true,
							page: true, //是否显示分页
							limits: [5, 7, 10],
							limit: 5 //每页默认显示的数量
						});
					});
					layui.use('form', function() {
						var form = layui.form;
						var $ = layui.$;
						form.on('select', function(data) {
							/* console.log(data.elem); //得到radio原始DOM对象
							console.log(data.value); //被点击的radio的value值 */
						});
						form.render(); //更新全部
					});

				});
			});
			//定义明细/记录参数
			var BorrowDataListSource;
			/* 借阅明细/记录添加点击事件  */
			var insertDetailsRecords = function(array,borrowRecordsNames,borrowRecordsDepartments,borrowRecordsBorrowDates){
				$("#insertDetailsRecords").click(function(){
					var borrowdatasource = {};
					//借阅明细集合
					borrowdatasource = array;
					//借阅明细文件数量
					var borrowRecordsNumber = array.length; 
					//借阅人姓名
					var borrowRecordsName = borrowRecordsNames;
					//借阅人所属部门
					var borrowRecordsDepartment = borrowRecordsDepartments;
					//借阅日期
					var borrowRecordsBorrowDate = borrowRecordsBorrowDates;
					//归还日期
					var borrowRecordsReturnDate = $("#borrowRecordsReturnDate")[0].value;
					//借阅事由
					var borrowRecordsReason = $("#borrowRecordsReason")[0].value;
					//获取借阅载体下拉框的值 
					var borrowRecordsCarrier;
					for (var i = 0; i < $("#borrowRecordsCarrier")[0].length; i++) {
						if($("#borrowRecordsCarrier")[0][i].selected == true){
							borrowRecordsCarrier = $("#borrowRecordsCarrier")[0][i].value
						}
					}
					console.log(borrowRecordsCarrier);
					//明细/记录参数
					BorrowDataListSource = {
					  		borrowRecordsName:borrowRecordsName,
					  		borrowRecordsDepartment:borrowRecordsDepartment,
					  		borrowRecordsBorrowDate:borrowRecordsBorrowDate,
					  		borrowRecordsReturnDate:borrowRecordsReturnDate,
					  		borrowRecordsReason:borrowRecordsReason,
					  		borrowRecordsCarrier:borrowRecordsCarrier,
					  		borrowdatasource:borrowdatasource,
					  		borrowRecordsNumber:borrowRecordsNumber
						};
					var starttime = $('#borrowRecordsBorrowDate').val();
					var endtime = $('#borrowRecordsReturnDate').val();
					var start = new Date(starttime.replace("-", "/").replace("-", "/"));
					var end = new Date(endtime.replace("-", "/").replace("-", "/"));
					console.log(start);
					console.log(end);
					if(borrowRecordsName != ''){
						if(borrowRecordsDepartment != ''){
							if(borrowRecordsBorrowDate != ''){
								if(borrowRecordsReturnDate != ''){
									if(borrowRecordsCarrier != "0"){
										if(borrowRecordsReason != ''){
											if(borrowdatasource.length != '0'){
												if(end>start){  
													console.log(BorrowDataListSource);
													//开始借阅
													$.ajax({
														url:"${pageContext.request.contextPath}/FileBorrowingController/borrowDetailsAndRecordsInsert",
														type:"post",
														async:false,
														data:JSON.stringify(BorrowDataListSource),// 指定请求的数据格式为json，实际上传的是json字符串,
														contentType:'application/json;charset=utf-8',
														success:function(data){
															layer.closeAll();
															var msg = data.msg;222
															layer.msg(msg,{time:2000});
															//重新查新页面（定时加载）
															layui.use('table', function() {
																var table = layui.table;
																var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
																//借阅记录渲染
																/* form.render(); */
																window.location.reload(true);
																/* $("#jySX").load(queryborrowrecords(borrowRecordsCarrier,borrowRecordsStatus)); */
															})
														}
													})  
												}else{
													layer.msg("抱歉！归还时间不得小于借阅时间！");
												}
											}else{
												layer.msg("抱歉！您没有所借阅的文件！");												
											}
										}else{
											layer.msg("抱歉！借阅事由不能为空");
										}
									}else{
										layer.msg("抱歉！借阅载体不能为空");
									}
								}else{
									layer.msg("抱歉！归还日期不能为空");
								}	
							}else{
								layer.msg("抱歉！借阅日期不能为空");
							}
						}else{
							layer.msg("抱歉！借阅人所属部门不能为空");
						}
					}else{
						layer.msg("抱歉！借阅人姓名不能为空");
					}
				})	
			};
			/* 借阅记录→借阅明细功能 */
			var borrowRecordsLoanDetails = function(borrowRecordsId){
				var datas;
				$.ajax({
					url:"${pageContext.request.contextPath}/FileBorrowingController/borrowRecordsBorrowDetailsSelect",
					type:"post",
					async:false,
					data:{
						"borrowRecordsId":borrowRecordsId
					},
					success:function(data){
						datas = data;
					}
				})
				return datas;
					
			}
			
			number = 'number';
			num = 'number';
			console.log(number==num);
			/* 归还功能 */
			var ReturnFunction = function(borrowtype,borrowRecordsId,borrowRecordsEvaluation,borrowRecordsInstructions){
				//档案载体
				var borrowRecordsCarrier;
				for (var i = 0; i < $("#borrowRecordsCarrier1")[0].length; i++) {
					if($("#borrowRecordsCarrier1")[0][i].selected == true){
						borrowRecordsCarrier = $("#borrowRecordsCarrier1")[0][i].value;
					}
				}
				//状态
				var borrowRecordsStatus;
				for (var i = 0; i < $("#borrowRecordsStatus1")[0].length; i++) {
					if($("#borrowRecordsStatus1")[0][i].selected == true){
						borrowRecordsStatus = $("#borrowRecordsStatus1")[0][i].value;
					}
				}
				var datas;
				$.ajax({
					url:"${pageContext.request.contextPath}/FileBorrowingController/ReturnFunction",
					type:"post",
					async:false,
					data:{
						"borrowtype":borrowtype,
						"borrowRecordsId":borrowRecordsId,
						"borrowRecordsEvaluation":borrowRecordsEvaluation,
						"borrowRecordsInstructions":borrowRecordsInstructions
					},
					success:function(data){
						datas = data;
						console.log(data);
						layer.closeAll();
						var msg = data.msg;
						layer.msg(msg,{time:5000});
						BorrowRecordsQuery(borrowRecordsCarrier,borrowRecordsStatus);
						queryborrowrecords(borrowRecordsCarrier,borrowRecordsStatus);
					}
				})
				return datas;
			}
			
</script>
		<!--借阅申请弹出层-->
<script type="text/html" id="shenqingjieyue">
			<div class="layui-fluid">
				<div class="layui-row layui-col-space15" style="margin: 0;">
					<div class="layui-card">
						<div class="layui-card-body" style="margin-top: 15px;">
							<div class="layui-row layui-col-space15">
								<form class="layui-form" action="">
									<div class="layui-col-md12">
										<div class="layui-card">
											<div class="layui-card-header font-i">借阅人信息</div>
											<div class="layui-card-body">
												<div class="layui-form-item">
													<label class="layui-form-label" style="">姓名：</label>
													<div class="layui-input-block line-h" id="borrowRecordsName" style=""></div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<label class="layui-form-label" style="">所属部门：</label>
													<div class="layui-input-block line-h" id="borrowRecordsDepartment" style=""></div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg6">
														<label class="layui-form-label">借阅日期：</label>
														<div class="layui-input-block">
															<input type="text" readonly="readonly" id="borrowRecordsBorrowDate" placeholder="" autocomplete="off" class="layui-input">
														</div>
													</div>
													<div class="layui-col-lg6">
														<label class="layui-form-label">归还日期：</label>
														<div class="layui-input-block">
															<input type="text" id="borrowRecordsReturnDate" placeholder="" autocomplete="off" class="layui-input">
														</div>
													</div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg12">
														<label class="layui-form-label">档案载体：</label>
														<div class="layui-input-block">
															<select name="city" id="borrowRecordsCarrier" lay-verify="required">
																<option value="0">请选择</option>
																<option value="1">纸质原件</option>
																<option value="2">复印件</option>
																<option value="3">电子原件</option>
															</select>
														</div>
													</div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg12">
														<label class="layui-form-label">借阅事由：</label>
														<div class="layui-input-block">
															<input type="text" placeholder="" id="borrowRecordsReason" autocomplete="off" class="layui-input">
														</div>
													</div>
												</div>
											</div>
											<div class="layui-card">
												<div class="layui-card-header font-i">借阅明细</div>
												<div class="layui-card-body">
													<table class="layui-table" id="demotw" lay-filter="demotw"></table>
												</div>
											</div>
										</div>
									</div>
								</form>
								<div class="layui-col-md12" style="padding: 20px;text-align: right;">
									<button class="layui-btn layui-btn-danger" id="insertDetailsRecords">确定</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</script>
		<!--借阅明细弹出层-->
<script type="text/html" id="mingxi">
			<div class="layui-fluid">
				<div class="layui-row layui-col-space15" style="margin: 0;">
					<div class="layui-card">
						<div class="layui-card-body" style="margin-top: 15px;">
							<div class="layui-row layui-col-space15">
								<form class="layui-form" action="">
									<div class="layui-col-md12">
										<div class="layui-card">
											<div class="layui-card-header font-i">借阅人信息</div>
											<div class="layui-card-body">
												<div class="layui-form-item">
													<label class="layui-form-label" style="width: 110px;">借阅人姓名：</label>
													<div class="layui-input-block line-h" id="borrowRecordsName2" style="margin-left: 140px;"></div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<label class="layui-form-label" style="width: 120px;">借阅人所属部门：</label>
													<div class="layui-input-block line-h" id="borrowRecordsDepartment2" style="margin-left: 140px;"></div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg6">
														<label class="layui-form-label">借阅期限：</label>
														<div class="layui-input-block line-h" id="borrowRecordsBorrowDate2" >
														</div>
													</div>
													<div class="layui-col-lg6">
														<label class="layui-form-label">归还期限：</label>
														<div class="layui-input-block line-h" id="borrowRecordsReturnDate2" >
														</div>
													</div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg12">
														<label class="layui-form-label">档案载体：</label>
														<div class="layui-input-block line-h" id="borrowRecordsCarrier2" >
														</div>
													</div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg12">
														<label class="layui-form-label">借阅事由：</label>
														<div class="layui-input-block">
															<input type="text" readonly="readonly" id="borrowRecordsReason2"  placeholder="" autocomplete="off" class="layui-input" >
														</div>
													</div>
												</div>
											</div>
											<div class="layui-card">
												<div class="layui-card-header font-i">借阅明细</div>
												<div class="layui-card-body">
													<table class="layui-table" id="ming" lay-filter="ming"></table>
												</div>
											</div>
										</div>
									</div>
								</form>
								<div class="layui-col-md12" style="padding: 20px;text-align: right;">
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</script>
<!-- <button class="layui-btn layui-btn-danger">确定</button> -->
		<!--归还弹出层456-->
		<div class="layui-fluid" id="guih" style="text-align: center;">
			<div style="padding: 15px;">
				<label for="" style="width: 150px;padding:0 25px;">利用效果评价：</label>
				<span class="rad"><input type="radio" name="set" value="良好" title="良好" >良好</span>
				<span class="rad"><input type="radio" name="set" value="一般" title="一般" >一般</span>
				<span class="rad"><input type="radio" name="set" value="较差" title="较差" >较差</span>
			</div>
			<div style="padding:15px;">
				<label for="" style="width: 150px;padding:0 25px;">利用效果说明：</label>
				<textarea name="borrowRecordsInstructions" rows="" cols="" id="borrowRecordsInstructions" style="margin: 0px;width: 470px;height: 155px"></textarea>
			</div>
			<div style="padding: 10px;text-align: center;">
				<label for="" class="gong_color">友情提示：纸质档案请至档案管理员处归还！</label>
			</div>
		</div>
		<!--续借弹出层-->
<script type="text/html" id="xujie">
			<div class="layui-fluid">
				<div class="layui-row layui-col-space15" style="margin: 0;">
					<div class="layui-card">
						<div class="layui-card-body" style="margin-top: 15px;">
							<div class="layui-row layui-col-space15">
								<form class="layui-form" action="">
									<div class="layui-col-md12">
										<div class="layui-card">
											<div class="layui-card-header font-i">借阅人信息</div>
											<div class="layui-card-body">
												<div class="layui-form-item">
													<label class="layui-form-label" style="width: 110px;">借阅人姓名：</label>
													<div class="layui-input-block line-h" id="borrowRecordsName3" style="margin-left: 140px;"></div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<label class="layui-form-label" style="width: 120px;">借阅人所属部门：</label>
													<div class="layui-input-block line-h" id="borrowRecordsDepartment3" style="margin-left: 140px;"></div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg6">
														<label class="layui-form-label">借阅日期：</label>
														<div class="layui-input-block line-h" id="borrowRecordsBorrowDate3">
														</div>
													</div>
													<div class="layui-col-lg6">
														<label class="layui-form-label">归还日期：</label>
														<div class="layui-input-block">
															<input type="text" id="borrowRecordsReturnDate3" placeholder="" autocomplete="off" class="layui-input">
														</div>
													</div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg12">
														<label class="layui-form-label">档案载体：</label>
														<div class="layui-input-block line-h" id="borrowRecordsCarrier3">
															
														</div>
													</div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<div class="layui-col-lg12">
														<label class="layui-form-label">续借事由：</label>
														<div class="layui-input-block">
															<input type="text"  placeholder="" id="borrowRecordsReason3" autocomplete="off" class="layui-input">
														</div>
													</div>
												</div>
											</div>
											<div class="layui-card">
												<div class="layui-card-header font-i">借阅明细</div>
												<div class="layui-card-body">
													<table class="layui-table" id="xu" lay-filter="xu"></table>
												</div>
											</div>
										</div>
									</div>
								</form>
								
							</div>
						</div>
					</div>
				</div>
			</div>
</script>
<!-- <div class="layui-col-md12" style="padding: 20px;text-align: right;">
	<button class="layui-btn layui-btn-danger">确定</button>
</div> -->
	</body>

</html>