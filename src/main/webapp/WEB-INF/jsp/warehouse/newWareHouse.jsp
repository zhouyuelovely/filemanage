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
		<title>库房管理_新建库房</title>
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
				width: 85%;
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
							<span class="gong_color">消息提示：</span> 您有
							<span>${messageNum}</span>条
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

				<!-- 主体内容 开始-->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-fluid">
						<div class="layui-row layui-col-space15">
							<div class="layui-card">
								<div class="layui-card-header">
									<div class="font-w">
									<c:if test="${zm:buttenPremission('ha',sessionScope.user.role.authorities) }">
										<a href="${pageContext.request.contextPath}/wareHouseBuild/wareHouseListShow"><i class="fa fa-bars font-i">&nbsp;&nbsp;库房建设&gt;&gt;</i></a><span class="font-w">新建库房</span>
									</c:if>
									</div>
								</div>
								<div class="layui-card-body" style="margin-top: 15px;">
									<div class="layui-row layui-col-space15">
										<form class="layui-form" action="" id="wareHouseForm" lay-filter="component-form-element"  method="post" target="nm_iframe">
											<div class="layui-col-md6">
												<div class="layui-card">
													<div class="layui-card-header font-i">库房属性</div>
													<div class="layui-card-body">
														<div class="layui-form-item">
															<label class="layui-form-label">库房名称：</label>
															<div class="layui-input-block">
																<input type="text" id="wareHouseBuildName" name="wareHouseBuildName" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
															</div>
														</div>
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg5">
																<label class="layui-form-label">库房号：</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildNumber" name="wareHouseBuildNumber" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
																</div>
															</div>
														</div>
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg4">
																<label class="layui-form-label">长：</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildLong" name="wareHouseBuildLong" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put">
																	<div style="float: right;">
																		m
																	</div>
																</div>
															</div>
															<div class="layui-col-lg4">
																<label class="layui-form-label">宽：</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildWidth" name="wareHouseBuildWidth" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put">
																	<div style="float: right;">
																		m
																	</div>
																</div>
															</div>
															<div class="layui-col-lg4">
																<label class="layui-form-label">高：</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildHigh" name="wareHouseBuildHigh" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put">
																	<div style="float: right;">
																		m
																	</div>
																</div>
															</div>
														</div>
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg5">
																<label class="layui-form-label">面积：</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildArea" name="wareHouseBuildArea" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put">
																	<div style="float: right;">
																		m²
																	</div>
																</div>
															</div>
														</div>
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg5">
																<label class="layui-form-label">体积：</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildVolume" name="wareHouseBuildVolume" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put">
																	<div style="float: right;">
																		m²
																	</div>
																</div>
															</div>
														</div>
														<div class="layui-form-item">
															<label class="layui-form-label">门朝向：</label>
															<div class="layui-input-block">
																<input type="radio" name="wareHouseBuildDoor" value="东" title="东">
																<input type="radio" name="wareHouseBuildDoor" value="南" title="南">
																<input type="radio" name="wareHouseBuildDoor" value="西" title="西">
																<input type="radio" name="wareHouseBuildDoor" value="北" title="北">
															</div>
														</div>
														<div class="layui-form-item">
															<label class="layui-form-label">窗户朝向：</label>
															<div class="layui-input-block">
										                        <input type="radio" name="wareHouseBuildWindow" title="东" value="东" lay-skin="primary">
																<input type="radio" name="wareHouseBuildWindow" title="南" value="南" lay-skin="primary">
																<input type="radio" name="wareHouseBuildWindow" title="西" value="西" lay-skin="primary">
																<input type="radio" name="wareHouseBuildWindow" title="北" value="北" lay-skin="primary">
															</div>
														</div>
													</div>
													<div class="layui-card">
														<div class="layui-card-header font-i">温度范围</div>
														<div class="layui-card-body">
															<div class="layui-row layui-col-space10 layui-form-item">
																<div class="layui-col-lg5">
																	<label class="layui-form-label">温度：</label>
																	<div class="layui-input-block">
																		<input type="text" id="wareHouseBuildTemperature" name="wareHouseBuildTemperature" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put">
																		<div style="float: right;">
																			°C
																		</div>
																	</div>
																</div>
																<div class="layui-col-lg5">
																	<label class="layui-form-label">湿度：</label>
																	<div class="layui-input-block">
																		<input type="text" id="wareHouseBuildHumidity" name="wareHouseBuildHumidity" lay-verify="required" placeholder="" autocomplete="off" class="layui-input put">
																		<div style="float: right;">
																			%
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="layui-col-md6">
												<div class="layui-card">
													<div class="layui-card-header font-i">密级架属性</div>
													<div class="layui-card-body">
														<!--密级架定义-->
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg5">
																<label class="layui-form-label">密集架数：</label>
																<div class="layui-input-block">
																	<input type="text"id="wareHouseBuildShelvesNum" name="wareHouseBuildShelvesNum" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
																</div>
															</div>
														</div>
														<div class="layui-form-item">
															<label class="layui-form-label" style="width: 90px;">密集架方向：</label>
															<div class="layui-input-block">
																<input type="radio" name="wareHouseBuildDirection" value="南北" title="南北">
																<input type="radio" name="wareHouseBuildDirection" value="东西" title="东西">
															</div>
														</div>
														<div class="layui-form-item">
															<label class="layui-form-label" style="width: 90px;">命名方向：</label>
															<div class="layui-input-block">
																<input type="radio" name="wareHouseBuildNamingDirection" value="由东到西" title="由东到西">
																<input type="radio" name="wareHouseBuildNamingDirection" value="由西到东" title="由西到东">
																<input type="radio" name="wareHouseBuildNamingDirection" value="由南到北" title="由南到北">
																<input type="radio" name="wareHouseBuildNamingDirection" value="由北到南" title="由北到南">
															</div>
														</div>
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg8">
																<label class="layui-form-label">密集架编号:</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildShelfNumber" name="wareHouseBuildShelfNumber" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
																</div>
															</div>
														</div>
														<!--组数定义-->
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg5">
																<label class="layui-form-label">每个密集架组数：</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildGroupsNum" name="wareHouseBuildGroupsNum" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
																</div>
															</div>
														</div>
														<div class="layui-form-item">
															<label class="layui-form-label" style="width: 90px;">组命名方向：</label>
															<div class="layui-input-block">
																<input type="radio" name="wareHouseBuildGroupNameDirect" value="由东到西" title="由东到西">
																<input type="radio" name="wareHouseBuildGroupNameDirect" value="由西到东" title="由西到东">
																<input type="radio" name="wareHouseBuildGroupNameDirect" value="由南到北" title="由南到北">
																<input type="radio" name="wareHouseBuildGroupNameDirect" value="由北到南" title="由北到南">
															</div>
														</div>
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg8">
																<label class="layui-form-label">组编号:</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildGroupNumber" name="wareHouseBuildGroupNumber" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
																</div>
															</div>
														</div>
														<!--格子数定义-->
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg5">
																<label class="layui-form-label">每组格子数：</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildLatticeNum" name="wareHouseBuildLatticeNum" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
																</div>
															</div>
														</div>
														<div class="layui-form-item">
															<label class="layui-form-label" style="width: 100px;">格子命名方向：</label>
															<div class="layui-input-block">
																<input type="radio" name="wareHouseBuildLattiNameDirect" value="由上到下" title="由上到下">
																<input type="radio" name="wareHouseBuildLattiNameDirect" value="由下到上" title="由下到上">
															</div>
														</div>
														<div class="layui-row layui-col-space10 layui-form-item">
															<div class="layui-col-lg8">
																<label class="layui-form-label">格子编号:</label>
																<div class="layui-input-block">
																	<input type="text" id="wareHouseBuildLatticeNumber" name="wareHouseBuildLatticeNumber" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
																</div>
															</div>
														</div>
														
													</div>
												</div>
											</div>
										<div class="layui-col-md12" style="padding: 20px;text-align: right;">
											<button class="layui-btn layui-btn-danger" onclick="formBut()">确定</button>
										</div>	
										</form>
										<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 主体内容结束-->
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
		<!--[if IE 6]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script>
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
			});
			
			    //根据输入的长宽自动获取面积体积
					//自动获取面积
				$(document).ready(function(){
					$("#wareHouseBuildArea").click(function(){
						var a = $("#wareHouseBuildLong").val();
						var b = $("#wareHouseBuildWidth").val();
						$("#wareHouseBuildArea").val(parseInt(a) * parseInt(b));
					});
				});
					
					//自动获取体积
					$("#wareHouseBuildVolume").click(function(){
						var a = $("#wareHouseBuildLong").val();
						var b = $("#wareHouseBuildWidth").val();
						var c = $("#wareHouseBuildHigh").val();
						$("#wareHouseBuildVolume").val(parseInt(a) * parseInt(b) * parseInt(c));
					});
					
			
			
			function formBut(){
				//var wareHouseBuildId = $("#wareHouseBuildId").val();// 主键
				var wareHouseBuildName  = $("#wareHouseBuildName").val();// 库房号
				var wareHouseBuildNumber  = $("#wareHouseBuildNumber").val();// 库房号
				var wareHouseBuildLong = $("#wareHouseBuildLong").val();// 长
				var wareHouseBuildWidth = $("#wareHouseBuildWidth").val();// 宽
				var wareHouseBuildHigh = $("#wareHouseBuildHigh").val();// 高
				var wareHouseBuildTemperature = $("#wareHouseBuildTemperature").val();// 温度
				var wareHouseBuildHumidity = $("#wareHouseBuildHumidity").val();// 湿度
				var wareHouseBuildShelvesNum = $("#wareHouseBuildShelvesNum").val();// 密集架数目
				var wareHouseBuildShelfNumber = $("#wareHouseBuildShelfNumber").val();// 密集架编号(以；进行分割)
				var wareHouseBuildGroupsNum = $("#wareHouseBuildGroupsNum").val();// 每个密集架的组数
				var wareHouseBuildGroupNumber = $("#wareHouseBuildGroupNumber").val();// 组编号(规则同密集架)
				var wareHouseBuildLatticeNum = $("#wareHouseBuildLatticeNum").val();// 每组格子数
				var wareHouseBuildLatticeNumber = $("#wareHouseBuildLatticeNumber").val();//格子编号
				if(wareHouseBuildName == null || wareHouseBuildName == ""){
					layer.msg("库房名称不能为空",{time:10000});
				}else if(wareHouseBuildNumber == null || wareHouseBuildNumber == ""){
					layer.msg("库房号不能为空",{time:10000});
				}else if(wareHouseBuildLong == null || wareHouseBuildLong == ""){
					layer.msg("长不能为空",{time:10000});
				}else if(wareHouseBuildWidth == null || wareHouseBuildWidth == ""){
					layer.msg("宽不能为空",{time:10000});
				}else if(wareHouseBuildHigh == null || wareHouseBuildHigh == ""){
					layer.msg("高不能为空",{time:10000});
				}else if(wareHouseBuildTemperature == null || wareHouseBuildTemperature == ""){
					layer.msg("温度不能为空",{time:10000});
				}else if(wareHouseBuildHumidity == null || wareHouseBuildHumidity == ""){
					layer.msg("适合度不能为空",{time:10000});
				}else if(wareHouseBuildShelvesNum == null || wareHouseBuildShelvesNum == ""){
					layer.msg("密集架数量不能为空",{time:10000});
				}else if(wareHouseBuildShelfNumber == null || wareHouseBuildShelfNumber == ""){
					layer.msg("密集架编号不能为空",{time:10000});
				}else if(wareHouseBuildGroupsNum == null || wareHouseBuildGroupsNum == ""){
					layer.msg("每个组数不能为空",{time:10000});
				}else if(wareHouseBuildGroupNumber == null || ""){
					layer.msg("组编号不能为空",{time:10000});
				}else if(wareHouseBuildLatticeNum == null || wareHouseBuildLatticeNum == ""){
					layer.msg("每组格子数不能为空",{time:10000});
				}else if(wareHouseBuildLatticeNumber == null || wareHouseBuildLatticeNumber == ""){
					layer.msg("格子编号不能为空",{time:10000});
				}else{
					$.ajax({
						url:"${pageContext.request.contextPath}/wareHouseBuild/addWareHouseInfo",
						type:"post",
						dataType:"text",
						data:$("#wareHouseForm").serialize(),
						async:false,
						success:function(result){
							if(result == 1){
								layer.msg("库房号已存在",{time:3000});
							}else if(result == 2){
								layer.msg("库房名已存在",{time:3000});
							}else if(result == 4){
								layer.msg("库房添加成功",{offset:'auto',time:3000},function(){
									window.location.href = "${pageContext.request.contextPath}/wareHouseBuild/wareHouseListShow";
								});
							}else{
								layer.msg("库房添加失败",{time:3000});
							}
						},
					});
				}
			}
			
		</script>
	</body>
</html>