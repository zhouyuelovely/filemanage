<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<%
  String app_url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%
    response.setHeader("Pragma","No-cache"); 
    response.setHeader("Cache-Control","no-cache"); 
    response.setDateHeader("Expires", 0); 
    response.flushBuffer();
%>
<html>
<head>
		<meta charset="utf-8">
		<title>库房管理_库房建设</title>
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
			
			#form_catalog {
				background: #FFFFFF;
				height: 100%;
				padding-top: 15px;
				border-radius: 4px;
				box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .1);
				margin: 0 15px;
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
			
			.put-bg {
				background: #CCCCCC;
			}
			
			#dd,#dt{
				display: none;
			}
			.line-h{
				line-height: 36px;
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
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
						您有<span>${messageNum}</span>条
						<a href="${pageContext.request.contextPath}/messageNotification/goNotification" class="gong_color">未读</a>消息，请及时处理！</span>
					</p>
					</c:if>
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						<c:if test="${zm:buttenPremission('ha',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
								<a href="${pageContext.request.contextPath}/wareHouseBuild/wareHouseListShow">库房建设</a>
							</li><span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('hb',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								 <a href="${pageContext.request.contextPath}/wareHouseStorage/fileStorageShow">档案入库</a>
							</li>
						</c:if>
						
					</ul>
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-fluid">
						<div class="layui-row layui-col-space15">
							<div class="layui-col-md9">
								<form class="layui-form" action="">
									<div class="layui-form-item">
										<label class="layui-form-label">密集架数量</label>
										<div class="layui-input-inline">
											<select id="city1" name="city1" lay-filter="city1">
												<option value="">请选择</option>
												<c:forEach items="${shelvesNum}" var="nums">
												<option value="${nums.wareHouseBuildShelvesNum}">${nums.wareHouseBuildShelvesNum}</option>
												</c:forEach>
											</select>
										</div>
										<label class="layui-form-label">组数</label>
										<div class="layui-input-inline">
											<select id="city2" name="wareHouseBuildGroupsNum" lay-filter="city2">
												<option value="">请选择</option>
											</select>
										</div>
									</div>
								</form>
							</div>
							<div class="layui-col-md3">
								<div class="layui-input-inline">
									<input type="text" name="condition" lay-verify="required|phone" id="condition" autocomplete="off" class="layui-input" placeholder="请输入关键字查询">
								</div>
								<c:if test="${zm:buttenPremission('haa',sessionScope.user.role.authorities) }">
								<button class="layui-btn layui-btn-normal" id="find">查询</button>
								</c:if>
							</div>
							<div class="layui-card layui-clear">
								<div class="layui-card-body">
									<table class="layui-hide" id="demo" lay-filter="demo"></table>
								</div>
							</div>
						</div>
					</div>
 
					<script type="text/html" id="barDemo">
						<!-- 这里同样支持 laytpl 语法，如： -->
						<button class="layui-btn layui-btn-xs" lay-event="detail">查看</button>
						<button class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">编辑</button>
						<button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>

					</script>
					<div id="" style="margin: 18px 0;">
						<span style="margin:0 15px;">库房合计：<b id="wareHouseNum">${pageInfo.wareHouseNum}</b>&nbsp间</span>
						<c:if test="${zm:buttenPremission('hae',sessionScope.user.role.authorities) }">
							<a href="${pageContext.request.contextPath}/wareHouseBuild/newWareHouse">
								<button class="layui-btn layui-btn-danger">新建库房</button>
							</a>
						</c:if>	
					</div>
				</div>
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
		<script type="text/html" id="indexTpl">
         {{d.LAY_TABLE_INDEX+1}}
        </script>
		<script>
			layui.use(['upload','form', 'layer','table'], function() {
				var table = layui.table;
				
				form = layui.form,upload = layui.upload;
				var $ = layui.jquery;
				//展示已知数据
				table.render({
					elem: '#demo',
					cellMinWidth: 80,
					url:"${pageContext.request.contextPath}/wareHouseBuild/wareHouseList",
					cols: [
						[ //标题栏
							{
								type: 'checkbox',
								fixed: 'left'
							},
							{
								field: 'numbers',
								title: '序号',
								unresize: 'false',
								sort: false,
								templet: '#indexTpl',
							}, {
								field: 'wareHouseBuildNumber',
								title: '库房号',
								unresize: 'false',
							}, {
								field: 'wareHouseBuildName',
								title: '库房名称',
								unresize: 'false',
							}, {
								field: 'wareHouseBuildShelvesNum',
								title: '密集架数量',
								unresize: 'false',
							}, {
								field: 'wareHouseBuildGroupsNum',
								title: '组数',
								unresize: 'false',
							},
							{
								field: 'wareHouseBuildLatticeNum',
								title: '格子数',
								unresize: 'false',
							},
							{
								field: 'wareHouseBuildTemperature',
								title: '温度',
								unresize: 'false',
							},
							{
								field: 'wareHouseBuildHumidity',
								title: '湿度',
								unresize: 'false',
							},
							{
								field: 'right',
								title: '操作',
								width: 200,
								unresize: 'false',
								toolbar: '#barDemo'
							}
						]
					],
					
						//,skin: 'line' //表格风格
					even: true,
					page: true //是否显示分页
						//,limits: [5, 7, 10]
						,
					limit: 10 //每页默认显示的数量
				});
				//监听工具条
				table.on('tool(demo)', function(obj) {
					var data = obj.data;
					var wareHouseBuildId = obj.data.wareHouseBuildId;
					var tr = obj.tr;
					if(obj.event === 'detail') {
						layer.open({
							type: 1,
							title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
							area: ['1000px', '600px'],
							skin: 'add_label_bg',
							offset: 'auto',
							shade: [0.8, '#393D49'],
							//查看弹出层
							content:'<div>' 
							        +'<div class="layui-fluid"><div class="layui-row layui-col-space15" style="margin: 0;"><div class="layui-card"><div class="layui-card-body" style="margin-top: 15px;"><div class="layui-row layui-col-space15"><div class="layui-col-md6">'
								+'<div class="layui-card"><div class="layui-card-header font-i">库房属性</div><div class="layui-card-body"><div class="layui-form-item">'
								+'<label class="layui-form-label">库房名称：</label><div class="layui-input-block line-h">'+data.wareHouseBuildName+'</div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">库房号：</label><div class="layui-input-block line-h">'+data.wareHouseBuildNumber+'</div></div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg4"><label class="layui-form-label">长：</label><div class="layui-input-block line-h">'+data.wareHouseBuildLong+'<span>m</span></div></div>'
								+'<div class="layui-col-lg4"><label class="layui-form-label">宽：</label><div class="layui-input-block line-h">'+data.wareHouseBuildWidth+'<span>m</span></div></div>'
								+'<div class="layui-col-lg4"><label class="layui-form-label">高：</label><div class="layui-input-block line-h">'+data.wareHouseBuildHigh+'<span>m</span></div></div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">面积：</label><div class="layui-input-block line-h">'+data.wareHouseBuildArea+'<span>m²</span></div></div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">体积：</label><div class="layui-input-block line-h">'+data.wareHouseBuildVolume+'<span>m²</span></div></div></div>'
								+'<div class="layui-form-item"><label class="layui-form-label">门朝向：</label><div class="layui-input-block line-h">'+data.wareHouseBuildDoor+'</div></div>'
							    +'<div class="layui-form-item"><label class="layui-form-label">窗户朝向：</label><div class="layui-input-block line-h">'+data.wareHouseBuildWindow+'</div></div></div>'
								+'<div class="layui-card"><div class="layui-card-header font-i">温度范围</div>'
								+'<div class="layui-card-body"><div class="layui-row layui-col-space10 layui-form-item">'
								+'<div class="layui-col-lg5"><label class="layui-form-label">温度：</label><div class="layui-input-block line-h">'+data.wareHouseBuildTemperature+'<div style="float: right;">°C</div></div></div>'
								+'<div class="layui-col-lg5"><label class="layui-form-label">湿度：</label><div class="layui-input-block line-h">'+data.wareHouseBuildHumidity+'<div style="float: right;">%</div></div></div></div></div></div></div>'
								+'<div class="layui-col-md6"><div class="layui-card"><div class="layui-card-header font-i">密级架属性</div><div class="layui-card-body">'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">密集架数：</label><div class="layui-input-block line-h">'+data.wareHouseBuildShelvesNum+'</div></div></div>'
								+'<div class="layui-form-item"><label class="layui-form-label" style="width: 90px;">密集架方向：</label><div class="layui-input-block line-h">'+data.wareHouseBuildDirection+'<span>方向</span></div></div>'
							    +'<div class="layui-form-item"><label class="layui-form-label" style="width: 90px;">命名方向：</label><div class="layui-input-block line-h">'+data.wareHouseBuildNamingDirection+'</div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg8"><label class="layui-form-label">密集架编号:</label><div class="layui-input-block line-h">'+data.wareHouseBuildShelfNumber+'</div></div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">每个密集架组数：</label><div class="layui-input-block line-h">'+data.wareHouseBuildGroupsNum+'</div></div></div>'
								+'<div class="layui-form-item"><label class="layui-form-label" style="width: 90px;">组命名方向：</label><div class="layui-input-block line-h">'+data.wareHouseBuildGroupNameDirect+'</div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg8"><label class="layui-form-label">组编号:</label><div class="layui-input-block line-h">'+data.wareHouseBuildGroupNumber+'</div></div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">每组格子数：</label><div class="layui-input-block line-h">'+data.wareHouseBuildLatticeNum+'</div></div></div>'
								+'<div class="layui-form-item"><label class="layui-form-label" style="width: 100px;">格子命名方向：</label><div class="layui-input-block line-h">'+data.wareHouseBuildLattiNameDirect+'</div></div>'
								+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg8"><label class="layui-form-label">格子编号:</label><div class="layui-input-block line-h">'+data.wareHouseBuildLatticeNumber+'</div></div></div></div></div></div>'
								+'<div class="layui-col-md12" style="padding: 20px;text-align:center;"><button class="layui-btn layui-btn-danger" id="closeBtn">关闭</button></div></div></div></div></div></div>'+'</div>',
						
						});
						
						$("#closeBtn").click(function(){
							layer.closeAll();
						})
						
						 //全宗的信息带入编辑弹出框中
					       $.ajax({
					    	  url:"${pageContext.request.contextPath}/wareHouseBuild/queryWareHouseInfo",
					    	  type:"post",
					    	  dataType:"json",
					    	  data:{"wareHouseBuildId":wareHouseBuildId},
					    	  success:function(data){
					    		  console.log(data);
					    		  $("#wareHouseBuildId").val(wareHouseBuildId);
					    		  
					    	  },
					      });
				
					} else if(obj.event === 'del') {
						layer.confirm('确定要删除该条记录吗？', {	title: '删除'}, function(index) {
							obj.del();
							layer.close(index);
							$.ajax({
					        	url:"${pageContext.request.contextPath}/wareHouseBuild/deleteOneWareHouseInfo",
					        	type:"post",
					        	dataType:"text",
					        	data:{"wareHouseBuildId":wareHouseBuildId},
					        		success:function(data){
					        			if(data == "true"){
					        				layer.msg("删除成功",{offset:'auto',time:3000},function(){
												 location.reload();
												 });
					        			}else{
					        				layer.msg("该库房中存在已入库的档案，无法删除！");
					        			}
					        		},
					           });
						});
					} else if(obj.event === 'edit') {
						layer.open({
							type: 1,
							title: '<i class="fa fa-bars" style="padding:0 5px"></i>编辑',
							area: ['1300px', '600px'],
							skin: 'add_label_bg',
							offset: 'auto',
							shade: [0.8, '#393D49'],
							//编辑弹出层
							content:'<form class="layui-form"  lay-filter="component-form-element" id="wareInfoForm"  onsubmit="return validate_forms(this)" method="post" target="nm_iframe">' 
								        +'<div class="layui-fluid"><div class="layui-row layui-col-space15" style="margin: 0;"><div class="layui-card"><div class="layui-card-body" style="margin-top: 15px;"><div class="layui-row layui-col-space15">'
										+'<div class="layui-col-md6"><div class="layui-card">'
										+'<div class="layui-card-header font-i">库房属性</div>'
										+'<input type="hidden" id="wareHouseBuildId" name="wareHouseBuildId" value="'+wareHouseBuildId+'">'
										+'<div class="layui-card-body"><div class="layui-form-item"><label class="layui-form-label">库房名称：</label><div class="layui-input-block"><input type="text"  id="wareHouseBuildName" name="wareHouseBuildName" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"></div></div>'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">库房号：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildNumber" name="wareHouseBuildNumber" readonly="readonly"  placeholder="" autocomplete="off" class="layui-input put-bg"></div></div></div>'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg4"><label class="layui-form-label">长：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildLong" name="wareHouseBuildLong" readonly="readonly"  placeholder="" autocomplete="off" class="layui-input put put-bg"><div style="float: right;"></div></div></div>'
										+'<div class="layui-col-lg4"><label class="layui-form-label">宽：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildWidth" name="wareHouseBuildWidth" readonly="readonly"  placeholder="" autocomplete="off" class="layui-input put put-bg"><div style="float: right;">m</div></div></div>'
										+'<div class="layui-col-lg4"><label class="layui-form-label">高：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildHigh" name="wareHouseBuildHigh" readonly="readonly"  placeholder="" autocomplete="off" class="layui-input put put-bg"><div style="float: right;">m</div></div></div></div>'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">面积：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildArea" name="wareHouseBuildArea" readonly="readonly"  placeholder="" autocomplete="off" class="layui-input put put-bg"><div style="float: right;">m²</div></div></div></div>'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">体积：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildVolume" name="wareHouseBuildVolume" readonly="readonly"  placeholder="" autocomplete="off" class="layui-input put put-bg"><div style="float: right;">m²</div></div></div></div>'
										+'<div class="layui-form-item"><label class="layui-form-label">门朝向：</label><div class="layui-input-block">'
										+'<input type="radio" id="wareHouseBuildDoor1" name="wareHouseBuildDoor" value="东" title="东">'
										+'<input type="radio" id="wareHouseBuildDoor2" name="wareHouseBuildDoor" value="南" title="南">'
										+'<input type="radio" id="wareHouseBuildDoor3" name="wareHouseBuildDoor" value="西" title="西">'
										+'<input type="radio" id="wareHouseBuildDoor4" name="wareHouseBuildDoor" value="北" title="北"></div></div>'
										+'<div class="layui-form-item"><label class="layui-form-label">窗户朝向：</label><div class="layui-input-block">'
								        +'<input type="checkbox" id="wareHouseBuildWindow1" name="wareHouseBuildWindow" title="东" value="东" lay-skin="primary">'
										+'<input type="checkbox" id="wareHouseBuildWindow2" name="wareHouseBuildWindow" title="南" value="南" lay-skin="primary">'
										+'<input type="checkbox" id="wareHouseBuildWindow3" name="wareHouseBuildWindow" title="西" value="西" lay-skin="primary">'
										+'<input type="checkbox" id="wareHouseBuildWindow4" name="wareHouseBuildWindow" title="北" value="北" lay-skin="primary"></div></div></div>'
										+'<div class="layui-card"><div class="layui-card-header font-i">温度范围</div><div class="layui-card-body"><div class="layui-row layui-col-space10 layui-form-item">'
										+'<div class="layui-col-lg5"><label class="layui-form-label">温度：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildTemperature" name="wareHouseBuildTemperature" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put"><div style="float: right;">°C</div></div></div>'
										+'<div class="layui-col-lg5"><label class="layui-form-label">湿度：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildHumidity" name="wareHouseBuildHumidity" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put"><div style="float: right;">%</div></div></div></div></div></div></div></div>'
									    +'<div class="layui-col-md6"><div class="layui-card"><div class="layui-card-header font-i">密级架属性</div><div class="layui-card-body">'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">密集架数：</label><div class="layui-input-block"><input type="text" id="wareHouseBuildShelvesNum" name="wareHouseBuildShelvesNum" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"></div></div></div>'
										+'<div class="layui-form-item"><label class="layui-form-label" style="width: 90px;">密集架方向：</label><div class="layui-input-block">'
										+'<input type="radio" id="wareHouseBuildDirection1" name="wareHouseBuildDirection" value="南北" title="南北">'
										+'<input type="radio" id="wareHouseBuildDirection2" name="wareHouseBuildDirection" value="东西" title="东西"></div></div>'
										+'<div class="layui-form-item"><label class="layui-form-label" style="width: 90px;">命名方向：</label><div class="layui-input-block">'
										+'<input type="radio" id="wareHouseBuildNamingDirection1" name="wareHouseBuildNamingDirection" value="由东到西" title="由东到西">'
										+'<input type="radio" id="wareHouseBuildNamingDirection2" name="wareHouseBuildNamingDirection" value="由西到东" title="由西到东">'
										+'<input type="radio" id="wareHouseBuildNamingDirection3" name="wareHouseBuildNamingDirection" value="由南到北" title="由南到北">'
										+'<input type="radio" id="wareHouseBuildNamingDirection4" name="wareHouseBuildNamingDirection" value="由北到南" title="由北到南"></div></div>'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg8"><label class="layui-form-label">密集架编号:</label>'
										+'<div class="layui-input-block"><input type="text" id="wareHouseBuildShelfNumber" name="wareHouseBuildShelfNumber" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"></div></div></div>'
									    +'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">每个密集架组数：</label>'
										+'<div class="layui-input-block"><input type="text" id="wareHouseBuildGroupsNum" name="wareHouseBuildGroupsNum" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"></div></div></div>'
										+'<div class="layui-form-item"><label class="layui-form-label" style="width: 90px;">组命名方向：</label><div class="layui-input-block">'
										+'<input type="radio" id="wareHouseBuildGroupNameDirect1" name="wareHouseBuildGroupNameDirect" value="由东到西" title="由东到西">'
										+'<input type="radio" id="wareHouseBuildGroupNameDirect2" name="wareHouseBuildGroupNameDirect" value="由西到东" title="由西到东">'
										+'<input type="radio" id="wareHouseBuildGroupNameDirect3" name="wareHouseBuildGroupNameDirect" value="由南到北" title="由南到北">'
										+'<input type="radio" id="wareHouseBuildGroupNameDirect4" name="wareHouseBuildGroupNameDirect" value="由北到南" title="由北到南"></div></div>'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg8"><label class="layui-form-label">组编号:</label>'
										+'<div class="layui-input-block"><input type="text" id="wareHouseBuildGroupNumber" name="wareHouseBuildGroupNumber" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"></div></div></div>'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg5"><label class="layui-form-label">每组格子数：</label>'
										+'<div class="layui-input-block"><input type="text" id="wareHouseBuildLatticeNum" name="wareHouseBuildLatticeNum" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"></div></div></div>'
										+'<div class="layui-form-item"><label class="layui-form-label" style="width: 100px;">格子命名方向：</label>'
										+'<div class="layui-input-block"><input type="radio" id="wareHouseBuildLattiNameDirect1" name="wareHouseBuildLattiNameDirect" value="由上到下" title="由上到下">'
										+'<input type="radio" id="wareHouseBuildLattiNameDirect2" name="wareHouseBuildLattiNameDirect" value="由下到上" title="由下到上"></div></div>'
										+'<div class="layui-row layui-col-space10 layui-form-item"><div class="layui-col-lg8"><label class="layui-form-label">格子编号:</label>'
										+'<div class="layui-input-block"><input type="text" id="wareHouseBuildLatticeNumber" name="wareHouseBuildLatticeNumber" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"></div></div></div></div></div></div>'
										+'<div class="layui-col-md12" style="padding: 20px;text-align: right;"><button class="layui-btn layui-btn-danger" type="submit">确定</button></div></div></div></div></div></div>'
										+'</form>'+'<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>',
					
						});
						layui.use('form', function() {
							var form = layui.form;
							var $ = layui.$;
							form.on('checkbox', function(data) {
								console.log(data.elem); //得到checkbox原始DOM对象
								console.log(data.elem.checked); //是否被选中，true或者false
								console.log(data.value); //复选框value值，也可以通过data.elem.value得到
								console.log(data.othis); //得到美化后的DOM对象
							});
							form.on('radio', function(data) {
								console.log(data.elem); //得到radio原始DOM对象
								console.log(data.value); //被点击的radio的value值
							});
							form.render(); //更新全部
							
							//将库房信息带入到编辑框中
							 $.ajax({
						    	  url:"${pageContext.request.contextPath}/wareHouseBuild/queryWareHouseInfo",
						    	  type:"post",
						    	  dataType:"json",
						    	  data:{"wareHouseBuildId":wareHouseBuildId},
						    	  success:function(data){
						    		  console.log(data);
						    		  $("#wareHouseBuildId").val(data.wareHouseBuildId);
						    		  $("#wareHouseBuildNumber").val(data.wareHouseBuildNumber);
						    		  $("#wareHouseBuildName").val(data.wareHouseBuildName);
						    		  $("#wareHouseBuildLong").val(data.wareHouseBuildLong);
						    		  $("#wareHouseBuildWidth").val(data.wareHouseBuildWidth);
						    		  $("#wareHouseBuildHigh").val(data.wareHouseBuildHigh);
						    		  $("#wareHouseBuildArea").val(data.wareHouseBuildArea);
						    		  $("#wareHouseBuildVolume").val(data.wareHouseBuildVolume);
						    		  if(data.wareHouseBuildDoor == "东" ){
						    			  $("#wareHouseBuildDoor1").prop('checked',true);
						    			  form.render(); //更新全部
						    		  }else if(data.wareHouseBuildDoor == "南"){
						    			  $("#wareHouseBuildDoor2").prop('checked',true);
						    			  form.render(); //更新全部
						    			 
						    		  }else if(data.wareHouseBuildDoor == "西"){
						    			  $("#wareHouseBuildDoor3").prop('checked',true);
						    			  form.render(); //更新全部
						    			  
						    		  }else if(data.wareHouseBuildDoor == "北"){
						    			  $("#wareHouseBuildDoor4").prop('checked',true);
						    			  form.render(); //更新全部
						    			  
						    		  }
						    		  
									 //窗户朝向
						    		    var aa=[];
					                      aa=data.wareHouseBuildWindow.split(",");
					                    for(var j=0;j<aa.length;j++){
					                        var unitTypeCheckbox=$("input[name='wareHouseBuildWindow']");
					                        for(var i=0;i<unitTypeCheckbox.length;i++){
					                            if(unitTypeCheckbox[i].value==aa[j]){
					                                unitTypeCheckbox[i].checked=true;
					                            }
					                        }
					                        form.render();  //更新渲染
					                    }       
						    		 
						    		  
						    		  $("#wareHouseBuildTemperature").val(data.wareHouseBuildTemperature);
						    		  $("#wareHouseBuildHumidity").val(data.wareHouseBuildHumidity);
						    		  $("#wareHouseBuildShelvesNum").val(data.wareHouseBuildShelvesNum);
						    		  
						    		  if(data.wareHouseBuildDirection == "南北" ){
						    			  $("#wareHouseBuildDirection1").prop("checked",true);
						    			  form.render();
						    		  }else if(data.wareHouseBuildDirection == "东西"){
						    			  $("#wareHouseBuildDirection2").prop("checked",true);
						    			  form.render();
						    		  }
						    		  
						    		  if(data.wareHouseBuildNamingDirection == "由东到西" ){
						    			  $("#wareHouseBuildNamingDirection1").prop("checked",true);
						    			  form.render();
						    		  }else if(data.wareHouseBuildNamingDirection == "由西到东"){
						    			  $("#wareHouseBuildNamingDirection2").prop("checked",true);
						    			  form.render();
						    		  }else if(data.wareHouseBuildNamingDirection == "由南到北"){
						    			  $("#wareHouseBuildNamingDirection3").prop("checked",true);
						    			  form.render();
						    		  }else if(data.wareHouseBuildNamingDirection == "由北到南"){
						    			  $("#wareHouseBuildNamingDirection4").prop("checked",true);
						    			  form.render();
						    		  }
						    		  
						    		  $("#wareHouseBuildShelfNumber").val(data.wareHouseBuildShelfNumber);
						    		  $("#wareHouseBuildGroupsNum").val(data.wareHouseBuildGroupsNum);
						    		  $("#wareHouseBuildGroupNumber").val(data.wareHouseBuildGroupNumber);
						    		  
						    		  if(data.wareHouseBuildGroupNameDirect == "由东到西" ){
						    			  $("#wareHouseBuildGroupNameDirect1").prop("checked",true);
						    			  form.render();
						    		  }else if(data.wareHouseBuildGroupNameDirect == "由西到东"){
						    			  $("#wareHouseBuildGroupNameDirect2").prop("checked",true);
						    			  form.render();
						    		  }else if(data.wareHouseBuildGroupNameDirect == "由南到北"){
						    			  $("#wareHouseBuildGroupNameDirect3").prop("checked",true);
						    			  form.render();
						    		  }else if(data.wareHouseBuildGroupNameDirect == "由北到南"){
						    			  $("#wareHouseBuildGroupNameDirect4").prop("checked",true);
						    			  form.render();
						    		  }
						    		 
						    		  
						    		  $("#wareHouseBuildLatticeNum").val(data.wareHouseBuildLatticeNum);
						    		  
						    		  if(data.wareHouseBuildLattiNameDirect == "由上到下"){
						    			  $("#wareHouseBuildLattiNameDirect1").attr("checked","checked");
						    			  form.render();
						    		  }else if(data.wareHouseBuildLattiNameDirect == "由下到上"){
						    			  $("#wareHouseBuildLattiNameDirect2").attr("checked","checked");
						    			  form.render();
						    		  }
						    		
						    		  $("#wareHouseBuildLatticeNumber").val(data.wareHouseBuildLatticeNumber);
						    	  },
						      });
						});
						
						
					
					}
				});
				
				
				        //关键词查询
						$("#find").click(function(){
							var table = layui.table;
							var condition=$("#condition").val();
							console.log(condition);
							table.reload('demo', {
								  url: '${pageContext.request.contextPath}/wareHouseBuild/selectWareHouseInfoByConditions'+"?timestamp="+Math.random()
								  ,where: {condition:condition} //设定异步数据接口的额外参数
								  //,height: 300
								  ,page: {
									    curr: 1 //重新从第 1 页开始
								   }  
							});
							$.ajax({
								url:"${pageContext.request.contextPath}/wareHouseBuild/reloadPageInfos"+"?timestamp="+Math.random(),
								data:"condition="+condition,
								type:"get",
								//解决缓存问题
								beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0");
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							    cache:false,
								dataType:"json",
								success:function(page){
									$("#wareHouseNum").text("");
									$("#wareHouseNum").text(page.wareHouseNum);
								},
								/* error:function(){
									layer.msg("接口异常") 
								}*/
							});
						});
						
				
				
				//根据密集架数和组数筛选库房
				layui.use('form', function(){
					 var form = layui.form;
					 form.on('select(city1)', function(data){
						 var wareHouseBuildShelvesNum=data.value;
						 $.ajax({
							 url:"${pageContext.request.contextPath}/wareHouseBuild/listGroupsNum"+"?timestamp="+Math.random(),
							 data:"wareHouseBuildShelvesNum="+wareHouseBuildShelvesNum,
							 type:"get",
							 //解决缓存问题
							 beforeSend :function(xmlHttp){
								 xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							     xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							    cache:false,
							 dataType:"JSON",
							 success:function(data){
								 console.log(data)
								 $("#city2").find("option:gt(0)").remove();
								 $.each(data,function(key,val){
									 var option=$("<option>").val(val.wareHouseBuildGroupsNum).text(val.wareHouseBuildGroupsNum);
									 $("#city2").append(option);
			                          form.render('select');
								 })
							 },
							 error:function(){
								 layer.msg("接口异常")
							 }
						 })
					 });
					 
				})
				
				layui.use('form',function(){
					 var form = layui.form;
					form.on('select(city2)',function(data){
						 var wareHouseBuildGroupsNum=data.value;
						 var wareHouseBuildShelvesNum=$("#city1").val();
						 table.reload('demo', {
							  url: '${pageContext.request.contextPath}/wareHouseBuild/moreConditionFiltrate'
							  ,where: {wareHouseBuildGroupsNum:wareHouseBuildGroupsNum,wareHouseBuildShelvesNum:wareHouseBuildShelvesNum} //设定异步数据接口的额外参数
							  //,height: 300
						});
						$.ajax({
							url:"${pageContext.request.contextPath}/wareHouseBuild/reloadPageInfo"+"?timestamp="+Math.random(),
							data:"wareHouseBuildGroupsNum="+wareHouseBuildGroupsNum+"&wareHouseBuildShelvesNum="+wareHouseBuildShelvesNum,
							type:"get",
							//解决缓存问题
							beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
						    cache:false,
							dataType:"json",
							success:function(page){
								$("#wareHouseNum").text("");
								$("#wareHouseNum").text(page.wareHouseNum);
							},
							error:function(){
								layer.msg("接口异常")
							}
						})
					 });
				})

			});
			

			//编辑库房字段输入内容
			function validate_forms(thisform){
				with(thisform){
					if($.trim($('#wareHouseBuildName').val()).length == 0){
						layer.msg("请输入库房名称");
						return false;
					}else{
						$.ajax({
							url:"${pageContext.request.contextPath}/wareHouseBuild/updateOneWareHouseInfo",
							type:"post",
							dataType:"json",
							data:$("#wareInfoForm").serialize(),
							async:false,
							success:function(result){
								if(result == 3){
									layer.msg("编辑库房信息成功!",{offset:'auto',time:3000},function(){
										location.reload();
									});
								}else if(result==4){
									layer.msg("编辑库房信息失败");
								}
							},
						});
					}
				}
			}
			
		</script>
		
	</body>
</html>