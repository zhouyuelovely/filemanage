<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<%
	String app_url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<%
	response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
	// 	response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	response.setHeader("Pragma", "No-cache");
	response.setDateHeader("Expires", 0);
%>
<%
	if (request.getProtocol().compareTo("HTTP/1.0") == 0)
		response.setHeader("Pragma", "no-cache");
	else if (request.getProtocol().compareTo("HTTP/1.1") == 0)
		response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<html>

<head>
<meta charset="utf-8">
<title>盘点管理_计划列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/layui/css/layui.css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css" media="all">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/viewer.min.css" />
<link href="${pageContext.request.contextPath}/css/skin_01.css"
	rel="stylesheet" type="text/css" id="skin">
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
<style type="text/css">
/*.layui-body{overflow-y: scroll;} 滚动条问题*/
table tr th div, table tr td {
	text-align: center;
}

body .add_label_bg>.layui-layer-title, .btn_color {
	background: #EA5519;
	color: #FFFFFF;
}

.gong_color {
	color: red;
	font-weight: bold;
}

.viewer-container, .viewer-fixed, .viewer-fade, .viewer-transition,
	.viewer-in {
	z-index: 99999999999 !important;
	/*弹出层查看图片优先级提升*/
}

/*计划详情弹出层的样式*/
#jihua {
	padding: 15px;
}

.font-s {
	padding-top: 15px;
	font-weight: bold;
	color: #000000;
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
				<p>
					COPYRIGHT&nbsp;&copy;2018 <a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有
				</p>
			</div>

			<div class="logo_nav">
				<!-- 头部区域 -->
				<div>
					<span class="logo_img"><img
						src="${pageContext.request.contextPath}/imgs/home.gif" width="110"
						height="50" /></span> <span class="index_title"> <span><a
							href="${pageContext.request.contextPath}/log/goHome">数字档案管理平台</a></span>
					</span>
				</div>
				<div class="layui-layout-right" id="nav_help"
					style="line-height: 60px; font-weight: bold; font-size: 18px;">
					<a href="${pageContext.request.contextPath}/log/goHome">返回主页</a>
				</div>
			</div>

			<!-- 侧边菜单 -->
			<!--class 个性化设置nav_bg1-->
			<div class="layui-side layui-side-menu nav_bg1" id="menu_color"
				style="top: 80px">
				<div class="layui-side-scroll nav_bg1">
					<!--class 个性化设置nav_bg1-->
					<div class="layui-logo nav_bg1" lay-href="#"
						style="margin-top: 80px;">
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
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
						<li class="layui-nav-item  layui-hide-xs "><c:if
								test="${zm:buttenPremission('fc',sessionScope.user.role.authorities) }">
								<a
									href="${pageContext.request.contextPath}/FileBorrowingController/modeAndView">
									<img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav7.png" />档案借阅<span>&gt;</span>
								</a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('h',sessionScope.user.role.authorities) }">
								<a
									href="${pageContext.request.contextPath}/wareHouseBuild/wareHouseListShow"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav8.png" />库房管理<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('i',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/expiredFile/goDaoQi"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav9.png" />监测预警<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
			<div id="" class="gong" style="left: 220px; text-align: left;">
				<c:if
					test="${zm:buttenPremission('bc',sessionScope.user.role.authorities) }">
					<p style="line-height: 38px;">
						<i class="fa fa-volume-up gong_color" style="padding: 0 20px;"></i><span>
							<span class="gong_color">消息提示：</span> 您有 <span>${requestScope.messageNum}</span>条
							<a
							href="${pageContext.request.contextPath}/messageNotification/goNotification"
							class="gong_color">未读</a>消息，请及时处理！
						</span>
					</p>
				</c:if>
			</div>
			<div class="top_bar">
				<!-- 头部区域 -->
				<ul class="layui-nav" id="top_nav">
					<c:if test="${zm:buttenPremission('ja',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item">
							<a href="${pageContext.request.contextPath}/inventoryManagement/goToInventoryManagement">盘点计划</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('jb',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-this">
							<a href="${pageContext.request.contextPath}/inventoryManagement/goToInventoryPlansList">计划列表</a>
						</li>
					</c:if>
				</ul>
			</div>

			<!-- 主体内容 -->
			<div class="layui-body" id="LAY_app_body" style="top: 180px;">
				<div style="padding: 15px;">
					<!--盘点计划改动-->
					<div class="layui-form" style="padding-top: 15px;">
						<div class="layui-col-md9">
							<div class="layui-form-item">
								<label class="layui-form-label">盘点人</label>
								<div class="layui-input-inline">
									<select name="planPerson" lay-filter="planPerson"
										id="planPerson">
										<option value="">请选择</option>
										<c:forEach items="${planPerson}" var="inventoryPlan">
											<option value="${inventoryPlan.planPerson}">${inventoryPlan.planPerson}</option>
										</c:forEach>
									</select>
								</div>
								<label class="layui-form-label">盘点状态</label>
								<div class="layui-input-inline">
									<select name="city" id="planStatus">
										<option value="">请选择</option>
										<option value="1">待盘点</option>
										<option value="2">盘点中</option>
										<option value="3">已盘点</option>
									</select>
								</div>
							</div>
						</div>
						<div class="layui-col-md3">
							<div class="layui-input-inline">
								<input type="text" name="phone" id="condition"
									lay-verify="required|phone" autocomplete="off"
									class="layui-input" placeholder="请输入关键字查询">
							</div>
							<c:if
								test="${zm:buttenPremission('jba',sessionScope.user.role.authorities) }">
								<button class="layui-btn layui-btn-normal" id="queryPlan">查询</button>
							</c:if>
						</div>
					</div>
					<table class="layui-table" id="demo" lay-filter="demo"></table>
					<script type="text/html" id="barDemo">
							<a class="layui-btn layui-btn-xs" lay-event="detail">详情</a>
							<button class="layui-btn layui-btn-xs" lay-event="download">下载</button>
							<button class="layui-btn layui-btn-xs" id="uploadPlan" lay-event="upload">上传</button>
						</script>
				</div>
			</div>
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
	<script
		src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.lqper.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/cookie.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/viewer.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/loginout.js"
		type="text/javascript" charset="utf-8"></script>
	<!--[if IE 6]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
	<script>
			layui.use('table', function() {
						var table = layui.table;
						//展示已知数据
						table.render({
							elem: '#demo',
							cellMinWidth: 80,
							url:"/filemanage/inventoryManagement/queryInventoryPlanInfo"+"?timestamp="+Math.random(),
							method:'post',
							cols: [
								[ //标题栏
									{
										field: 'numbers',
										title: '序号',
										unresize: 'false',
										templet: '#indexTpl',
										sort: true
									},{
										field: 'planBoxNumber',
										title: '盒数',
										unresize:'false',
									},{
										field: 'planMakingDate',
										title: '计划制作日期',
										unresize: 'false',
									},{
										field: 'planStartdate',
										title: '计划实施日期',
										unresize: 'false',
									},{
										field: 'planEnddate',
										title: '计划完成日期',
										unresize: 'false',
									},{
										field: 'planMakingPerson',
										title: '制作人',
										unresize: 'false',
									},{
										field: 'planPerson',
										title: '盘点人',
										unresize:'false',
									},{
										field: 'planStatus',
										title: '盘点状态',
										unresize:'false',
									},{
										field: 'right',
										title: '操作',
										unresize:'false',
										toolbar: '#barDemo'
									}]
								],
							
								//,skin: 'line' //表格风格
							even: true,
							page: true //是否显示分页
								//,limits: [5, 7, 10]
								,
							limit:5 //每页默认显示的数量
						});
						
						//select盘点人 ，盘点状态 查询
						layui.use('form', function() {
							var form = layui.form;
							var $ = layui.$;
							form.on('select', function(data){
								var planPerson=$("#planPerson").val();
								var planStatus=$("#planStatus").val();
								var jsonObj={"planPerson":planPerson,
											"planStatus":planStatus,
										};
									table.reload('demo', {
									  url: "${pageContext.request.contextPath}/inventoryManagement/queryInventoryPlanInfoByCondition"+"?timestamp="+Math.random()
									  ,where: {planPerson:planPerson,
										  	   planStatus:planStatus} //设定异步数据接口的额外参数
									  //,height: 300
									  ,method:'post',
								});
						  	})
						});
						
						//计划列表的按条件查询
						$("#queryPlan").bind("click",function(){
							var planPerson=$("#planPerson").val();
							var planStatus=$("#planStatus").val();
							var condition=$("#condition").val();
							table.reload('demo', {
								  url: "${pageContext.request.contextPath}/inventoryManagement/queryInventoryPlanInfoByCondition"+"?timestamp="+Math.random()
								  ,where: {planPerson:planPerson,
									  	   planStatus:planStatus,
									  	   condition:condition} //设定异步数据接口的额外参数
								  //,height: 300
								  ,method:'post',
							});
						});	
						
							 //监听工具条
						  table.on('tool(demo)', function(obj){
						    var data = obj.data;
						    var tr = obj.tr;
						    var planId=data.planId;
						    var planStatus=data.planStatus;
						    if(obj.event === 'detail'){
			//			      layer.msg('ID：'+ data.id + ' 的查看操作');
						      layer.open({
								type: 1,
								title:'<i class="fa fa-bars" style="padding:0 5px"></i>计划详情',
								area: ['800px', '600px'],
								skin: 'add_label_bg',
								offset: 'auto',
								shade: [0.8, '#393D49'],
								content:'<div id="jihua">'+
										'<div class="font-s">计划拟定表</div>'+
										'<div style="padding-top:15px;font-weight: bold;color:red;">注:制作人，盘点人列出现省略号，请点击查看详情！</div>'+
										'<table class="layui-table" id="demotree" lay-filter="demotree"></table>'+
										'<div class="font-s">盘点计划表</div>'+
								        '<table class="layui-table" id="demotwo" lay-filter="demotwo"></table>'+
										'</div>'
								  });
								table.render({
									elem: '#demotree',
									cellMinWidth: 80,
									url:"/filemanage/inventoryManagement/queryPlanInfoByPlanId"+"?planId="+planId+"&timestamp="+Math.random(),
									method:'post',
									cols: [
										[ //标题栏
										{
											field: 'planMakingPerson',
											title: '制作人',
											unresize: 'false',
										},{
											field: 'planPerson',
											title: '盘点人',
											unresize:'false',
										},{
											field: 'planMakingDate',
											title: '计划制作日期',
											unresize: 'false',
										},{
											field: 'planStartdate',
											title: '计划实施日期',
											unresize: 'false',
										},
										{
											field: 'planEnddate',
											title: '计划完成日期',
											unresize: 'false',
										},
										{
											field: 'planBoxNumber',
											title: '盘点盒数',
											unresize: 'false',
										},{
											field: 'sjsstime',
											title: '实际实施时间',
											unresize: 'false',
										},{
											field: 'sjwctime',
											title: '实际完成时间',
											unresize: 'false',
										},{
											field: 'pdjg',
											title: '盘点结果',
											unresize: 'false',
										},
										]
									],
									
										//,skin: 'line' //表格风格
									even: true,
									page: false //是否显示分页
								});
								table.render({
									elem: '#demotwo',
									cellMinWidth: 80,
									url:"/filemanage/inventoryManagement/queryBoxInfoByPlanId"+"?planId="+planId+"&zhuangtai="+zhuangtai+"&timestamp="+Math.random(),
									method:'post',
									cols: [
										[ //标题栏
											{
											type: 'numbers',
											title: '序号',
											unresize: 'false',
											templet: '#indexTpl',
											sort: true
										},{
											field: 'boxSericalNumber',
											title: '盒编号',
											unresize: 'false',
										},{
											field: 'pcName',
											title: '档案类型',
											unresize:'false',
										},{
											field: 'boxStartNumber',
											title: '起件号',
											unresize: 'false',
										},{
											field: 'boxEndNumber',
											title: '止件号',
											unresize: 'false',
										},
										{
											field: 'storageRacknumber',
											title: '位置',
											unresize: 'false',
										},{
											field: 'juider',
											title: '盘点结果',
											unresize: 'false',
										},]
										],
										//,skin: 'line' //表格风格
									even: true,
									page: true //是否显示分页
										//,limits: [5, 7, 10]
										,
									limit:5 //每页默认显示的数量
								});
						     }else if(obj.event === 'download'){
						    	 if(planStatus=='待盘点'){
					 				window.location.href="${pageContext.request.contextPath}/inventoryManagement/downPlan?planId="+planId;
					 				setTimeout(function(){ 
					 					downloadPlan(planId);
					 				}, 5000);
						    	 }else{
						    		layer.msg("请下载待盘点的计划!");
						    	 }
						     }else if(obj.event === 'upload'){
					    		 if(planStatus=='盘点中'){
					    			 layer.open({
											type: 1,
											title: '<i class="fa fa-bars" style="padding:0 5px"></i>上传文件',
											area: ['400px', '240px'],
											skin: 'add_label_bg',
											offset: 'auto',
											shade: [0.8, '#393D49'],
											content: '<button type="button" class="layui-btn layui-btn-sm  layui-btn-normal" id="test10">选择文件</button>'
										});
							    	 layui.use('upload', function(){
							    		  var $ = layui.jquery
							    		  ,upload = layui.upload;
							    		  upload.render({
												elem: '#test10',
												url: '${pageContext.request.contextPath}/inventoryManagement/upload', //后台接口
												accept: 'file', //普通文件
												auto: true,
									    		exts: 'xls|xlsx', //只允许上传Excel文件
												data:{planId:planId},
												done: function(res) {
													console.log(res);
													 if(res['msg']=='ok'){
														layer.msg("上传成功",{time:2000,offset: 'auto',anim: 1},function(){
															location.reload();
														})
												      }else if(res['msg']=='failure'){
												    	  layer.msg("文件上传异常,请联系系统管理员!",{time:2000,offset: 'auto',anim: 1},function(){
																location.reload();
														  })
												      }else if(res['msg']=='输入的盘点结果必须是数字类型'){
												    	  layer.msg("输入的盘点结果必须是数字",{time:2000,offset: 'auto',anim: 1},function(){
																location.reload();
														  })
												      }
												}
											});
							    	 })
						    	 }else{
						    		layer.msg("请上传盘点中状态下的计划!");
						    	 }
						     }
						    
						  });
							
					});
			
			function downloadPlan(planId){
				$.ajax({
		 			url:"${pageContext.request.contextPath}/inventoryManagement/updatePlanStatusByPlanId",
		 			data:"planId="+planId,
		 			async:true,
		 			type:'post',
		 			dataType:"json",
		 			success : function(data) {
		 				if(data==true){
			 				location.reload();
		 				}else{
		 					layer.msg("更新盘点状态失败!");
		 				}
		 			},
		 			error : function(e) {
		 				layer.msg("服务端异常,请联系系统管理员!");
		 			}
		 		});
			}
			 var zhuangtai=null;	
		        $("body").on("mouseover", ".layui-table-cell",aa );
				function aa(){
					zhuangtai = $(this).parent().prev().find(".laytable-cell-1-planStatus").text();
 				 }
		
				
		</script>
	<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
         </script>
</body>

</html>