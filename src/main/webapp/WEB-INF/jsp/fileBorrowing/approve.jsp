<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>档案借阅-借阅审核</title>
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
			
			.viewer-container,
			.viewer-fixed,
			.viewer-fade,
			.viewer-transition,
			.viewer-in {
				z-index: 99999999999!important;
				/*弹出层查看图片优先级提升*/
			}
			.font-i {
				color: #EA5519;
				font-weight: bold;
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
							<li class="layui-nav-item">
							 	<a href="${pageContext.request.contextPath}/FileBorrowingController/modeAndView">借阅申请</a>
							</li>
							<span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('bg',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
							 	<a href="${pageContext.request.contextPath}/FileBorrowingController/modeAndView2">借阅审核</a>
							</li>
						</c:if>
					</ul>
				</div>
				<!-- 主体内容 开始-->
				<div class="layui-body" id="LAY_app_body" style="top:180px;padding: 15px;">
					<div class="layui-fluid">
						<div class="layui-row layui-col-space15">	
							<div class="layui-card">
								<div class="layui-card-header">审批借阅</div>
								<hr class="layui-bg-black">
								<div class="layui-card-body">
									<div class="layui-form">
										<div class="layui-form-item">
											<div class="layui-inline">
												<label class="layui-form-label">档案载体</label>
												<div class="layui-input-inline">
													<select name="type" class="borrowRecordsCarrier1" id="borrowRecordsCarrier1" lay-verify="required" lay-filter="borrowRecordsCarrier1">
														<option value="0">请选择</option>
														<option value="1">纸质原件</option>
														<option value="2">复印件</option>
														<option value="3">电子版</option>
													</select>
												</div>
											</div>
											<div class="layui-inline">
												<label class="layui-form-label">状态</label>
												<div class="layui-input-inline">
													<select name="type" class="borrowRecordsStatus1"  id="borrowRecordsStatus1" lay-verify="required" lay-filter="borrowRecordsStatus1">
														<option value="0">请选择</option>
														<option value="1">待审核</option>
														<option value="2">已驳回</option>
														<option value="3">已通过</option>
														<option value="4">已归还</option>
													</select>
												</div>
											</div>
										 	<div class="layui-inline">
										 		<button class="layui-btn layui-btn-sm id="seo">查询</button>
											</div>
										</div>
									</div>
									
									<table class="layui-hide" id="shenpi" lay-filter="shenpi"></table>
									<!-- <table class="layui-table" lay-data="{width: 892, height:332, url:'/demo/table/user/', page:true, id:'idTest'}" lay-filter="demo"> -->
								</div>
								<div class="layui-card-header demoOperation">
								<c:if test="${zm:buttenPremission('gbd',sessionScope.user.role.authorities) }">
									<button class="layui-btn layui-btn-sm layui-btn-normal" data-type="batchPass" id="batchPass" value="1">批量通过</button>
									</c:if>
									<c:if test="${zm:buttenPremission('gbe',sessionScope.user.role.authorities) }">
									<button class="layui-btn layui-btn-sm" data-type="batchRefused" id="batchRefused" value="2">批量拒绝</button>
									</c:if>
								</div>
							</div>
							<script type="text/html" id="barDemo">
								<!-- 这里同样支持 laytpl 语法，如： -->
							{{#  if(d.borrowRecordsStatus == '已通过' || d.borrowRecordsStatus == '已归还' ){  }}
								<a class="layui-btn layui-btn-xs" lay-event="Tdetail">借阅明细</a>
								<a class="layui-bg-gray layui-btn layui-btn-normal layui-btn-xs" lay-event="#">通过</button>
								<a class="layui-bg-gray layui-btn layui-btn-danger layui-btn-xs" lay-event="ju">拒绝</a>
		 					{{#  } else if(d.borrowRecordsStatus == '待审核'){ }}
								<a class="layui-btn layui-btn-xs" lay-event="Tdetail">借阅明细</a>
								<a class="layui-btn layui-btn-xs" lay-event="tg">通过</button>
								<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="ju">拒绝</a>
							{{#  } else if(d.borrowRecordsStatus == '已驳回'){ }}
								<a class="layui-btn layui-btn-xs" lay-event="Tdetail">借阅明细</a>
								<a class="layui-bg-gray layui-btn layui-btn-normal layui-btn-xs" lay-event="#">通过</button>
								<a class="layui-bg-gray layui-btn layui-btn-danger layui-btn-xs" lay-event="#">拒绝</a>
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
				<!-- 主体内容结束-->
			</div>
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/viewer.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/loginout.js" type="text/javascript" charset="utf-8"></script>
		<!--[if IE 6]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script>
			function img_vi() {
				$('.Scanning_Images').viewer();
			}
			var BorrowDetailsFunction = function(data){
				layui.use(['table','form'] , function() {
					var table = layui.table;
					var $ = layui.jquery;
					var form = layui.form;
					//展示已知数据
					table.render({
						cellMinWidth: 80,
						elem: '#shenpi',
						cols: [
							[ //标题栏
								{
									type: 'checkbox',
									fixed: 'left'
								},
								{
									field: 'id',
									title: '序号',
									width: 80,
									unresize: 'false',
									type: 'numbers',
									sort: true
								},
								{
									field: 'borrowRecordsName',
									title: '借阅人姓名',
									unresize: 'false',
								},
								{
									field: 'borrowRecordsBorrowDate',
									title: '借阅日期',
									unresize: 'false',
								},
								{
									field: 'borrowRecordsReturnDate',
									title: '归还日期',
									unresize: 'false',
								},
								{
									field: 'borrowRecordsNumber',
									title: '借阅件数',
									unresize: 'false',
								},
								{
									field: 'borrowRecordsReason',
									title: '借阅事由',
									unresize: 'false',
								},
								{
									field: 'borrowRecordsStatus',
									title: '状态',
									unresize: 'false',
								},
								{
									field: 'right',
									title: '操作',
									unresize: 'false',
									toolbar: '#barDemo'
								}]],
						data:data.data,
						/*skin: 'nob' //表格风格
							,*/
						even: false,
						page: true //是否显示分页
						,limits: [5, 7, 10]
						,limit: 10 //每页默认显示的数量
					});
					 /* 档案记录下拉框多个监听事件 */
				  	 form.on('select', function(data){
				  	  //定义档案载体
					  var borrowRecordsCarrier = null;
					  if(data.elem.id == 'borrowRecordsCarrier1'){
						  borrowRecordsCarrier = data.value;
					  	  //获取审核状态
					  	  var borrowRecordsStatus = null;
						  for (var i = 0; i < $("#borrowRecordsStatus1")[0].length; i++) {
								if($("#borrowRecordsStatus1")[0][i].selected == true){
									borrowRecordsStatus = $("#borrowRecordsStatus1")[0][i].value;
								}
					 		 }	
						  //判断如果是0就为null
						  if(borrowRecordsStatus == "0"){
							  borrowRecordsStatus = null;
							  BorrowRecordsQuery(borrowRecordsCarrier,borrowRecordsStatus);  
						  }else{
							  BorrowRecordsQuery(borrowRecordsCarrier,borrowRecordsStatus); 
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
								  BorrowRecordsQuery(borrowRecordsCarrier,borrowRecordsStatus);  
							  }else{
								  BorrowRecordsQuery(borrowRecordsCarrier,borrowRecordsStatus);
							  }
					  }
					  
					});
				  	
					 //监听表格复选框选择
					  table.on('checkbox(shenpi)', function(obj){
					  console.log(obj);
					 });
					 //
					  var $ = layui.$, active = {
						   batchRefused: function(){ //获取选中数据
						      var checkStatus = table.checkStatus('shenpi')
						      ,data = checkStatus.data;
						    //档案载体
						    console.log(data);
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
							  layer.closeAll();
						      layer.open({
									type: 1,
									title: '<i class="fa fa-bars" style="padding:0 5px"></i>拒绝',
									area: ['550px', '350px'],
									skin: 'add_label_bg',
									offset: 'auto',
									shade: [0.8, '#393D49'],
									content:'<div class="layui-fluid" style="text-align: center;"><div style="padding:15px;"><label for="" style="width: 150px;padding:0 25px;">拒绝原因：</label><textarea name="borrowrecordsReasonrejection" rows="" cols="" id="borrowrecordsReasonrejection" style="margin: 0px;width: 470px;height: 155px"></textarea></div></div>',
									btn: ['确定', '取消']
									,yes: function() {
										/**
										* 使用循环的方式判断一个元素是否存在于一个数组中
										* @param {Object} arr 数组
										* @param {Object} value 元素值
										**/
										function isInArray(arr){
										    for(var i = 0; i < arr.length; i++){
												if("待审核" != arr[i].borrowRecordsStatus){
											    	return false;
											        }
											  }
											return true;
										}
										
										if(data.length == '0'){
											layer.msg("抱歉！您没有选中任何文件！");
										}else{
											if(isInArray(data) == false){
												layer.msg("抱歉！您选中的文件存在’已驳回'或'已归还'文件请从新筛选！");
											}else if(isInArray(data) == true){
												var dateList = [];
												var borrowrecordsReasonrejection = $("#borrowrecordsReasonrejection").val();
												console.log();
												  if($("#batchPass")[0].value == "1"){
													  for (var i = 0; i < data.length; i++) {
														  if(data[i].borrowRecordsStatus == "待审核"){
															  dateList.push({
																borrowrecordsReasonrejection:borrowrecordsReasonrejection,
																borrowRecordsStatus:"1",
																borrowRecordsId:data[i].borrowRecordsId
															});
														  }
														}
													  console.log(dateList);
												  }
													$.ajax({
														url:"${pageContext.request.contextPath}/FileBorrowingController/fileAudit",
														type:"post",
														async:false,
														data:JSON.stringify(dateList),// 指定请求的数据格式为json，实际上传的是json字符串
														contentType: "application/json;charset=UTF-8",
														success:function(data){
															layer.msg("审批成功！！！");
															setTimeout(function(){document.location.reload()}, 1000);
														}
													});
											}
										}
										
									},
									btn2: function() {
										layer.closeAll();
									}
									});
						      
						     
						    },
						    batchPass:function(){
						    	var msg;
						    	var checkStatus = table.checkStatus('shenpi')
							      ,data = checkStatus.data;
						    	
						    	/**
								* 使用循环的方式判断一个元素是否存在于一个数组中
								* @param {Object} arr 数组
								* @param {Object} value 元素值
								**/
								function isInArray(arr){
								    for(var i = 0; i < arr.length; i++){
										if("待审核" != arr[i].borrowRecordsStatus){
									    	return false;
									        }
									  }
									return true;
								}
						    	if(data.length == '0'){
									layer.msg("抱歉！您没有选中任何文件！");
								}else{
									if(isInArray(data) == false){
										layer.msg("抱歉！您选中的文件存在’已驳回'或'已归还'文件请从新筛选！");
									}else if(isInArray(data) == true){
										var dateList = [];
										  if($("#batchPass")[0].value == "1"){
											  for (var i = 0; i < data.length; i++) {
												  if(data[i].borrowRecordsStatus == "待审核"){
													  dateList.push({
														borrowRecordsStatus:"1",
														borrowRecordsId:data[i].borrowRecordsId
													});
												  }
												}
											  console.log(dateList);
										  }
											$.ajax({
												url:"${pageContext.request.contextPath}/FileBorrowingController/filePass",
												type:"post",
												async:false,
												data:JSON.stringify(dateList),// 指定请求的数据格式为json，实际上传的是json字符串
												contentType: "application/json;charset=UTF-8",
												success:function(data){
													layer.msg("审批成功！！！");
													setTimeout(function(){document.location.reload()}, 1000);
												}
											});
									}
								}
							}
					  }; 
							  
					$('.demoOperation .layui-btn').on('click', function(){
					    var type = $(this).data('type');
					    active[type] ? active[type].call(this) : '';
					});
					  //监听工具条
					  table.on('tool(shenpi)', function(obj){
					   var data = obj.data;
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
										//,limits: [5, 7, 10]
										,
									limit: 7 //每页默认显示的数量
								});
								//监听工具条
								table.on('tool(ming)', function(obj) {
									var data = obj.data;
									var tr = obj.tr;
	
									if(obj.event === 'detail') {
										console.log(obj);
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
								});
							});
							/*拒绝按钮绑定弹出层*/
						}else if(obj.event === 'ju'){
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
							
							layer.open({
								type: 1,
								title: '<i class="fa fa-bars" style="padding:0 5px"></i>拒绝',
								area: ['550px', '350px'],
								skin: 'add_label_bg',
								offset: 'auto',
								shade: [0.8, '#393D49'],
								content: $('#jue2').html(),
								btn: ['确定', '取消'],
								yes: function() {
									var dateList = [];
									dateList.push({
									  	borrowrecordsReasonrejection:$("#borrowrecordsReasonrejection")[0].value,
										borrowRecordsStatus:"1",
										borrowRecordsId:obj.data.borrowRecordsId
									});
									if($("#borrowrecordsReasonrejection")[0].value == ""){
										 layer.msg("抱歉！请填写拒绝理由！");
									 }else{
										 console.log(borrowRecordsCarrier,borrowRecordsStatus);
										$.ajax({
											url:"${pageContext.request.contextPath}/FileBorrowingController/fileAudit",
											type:"post",
											async:false,
											data:JSON.stringify(dateList),// 指定请求的数据格式为json，实际上传的是json字符串
											contentType: "application/json;charset=UTF-8",
											success:function(data){
												/* BorrowRecordsQuery(borrowRecordsCarrier,borrowRecordsStatus); */
												layer.msg("审批成功！！！");
												//重新查新页面（定时加载）
												setTimeout(function(){document.location.reload()}, 1000);
											}
										});
									 }
								},
								btn2: function() {
									layer.closeAll();
								}
								});
							
						   }else if(obj.event === 'tg'){
							   var dateList = [];
											  dateList.push({
												borrowRecordsStatus:"1",
												borrowRecordsId:obj.data.borrowRecordsId
											});
									$.ajax({
										url:"${pageContext.request.contextPath}/FileBorrowingController/filePass",
										type:"post",
										async:false,
										data:JSON.stringify(dateList),// 指定请求的数据格式为json，实际上传的是json字符串
										contentType: "application/json;charset=UTF-8",
										success:function(data){
											layer.msg("审批成功！！！");
											setTimeout(function(){document.location.reload()}, 1000);
										}
									});
						   }
					  });
					  
					 
						
				});
			};
			
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
						console.log(data);
						BorrowDetailsFunction(data);
					}
				});
				return datas;	
			}
			BorrowRecordsQuery(borrowRecordsCarrier,borrowRecordsStatus);
			
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
			

		</script>
	<!--批量拒绝弹出层-->
	<script type="text/html" id="jue">
			
	</script>	
	<!--单个拒绝弹出层-->
	<script type="text/html" id="jue2">
			<div class="layui-fluid" style="text-align: center;">
				<div style="padding:15px;">
						<label for="" style="width: 150px;padding:0 25px;">拒绝原因：</label>
						<textarea name="borrowrecordsReasonrejection" rows="" cols="" id="borrowrecordsReasonrejection" style="margin: 0px;width: 470px;height: 155px"></textarea>
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
													<div class="layui-input-block line-h" id="borrowRecordsName2"  style="margin-left: 140px;">张三</div>
												</div>
												<div class="layui-row layui-col-space10 layui-form-item">
													<label class="layui-form-label" style="width: 120px;">借阅人所属部门：</label>
													<div class="layui-input-block line-h" id="borrowRecordsDepartment2"  style="margin-left: 140px;">某某市人事局组织部</div>
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
--									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</script>
<!-- <button class="layui-btn layui-btn-danger">确定</button> -->
	</body>

</html>