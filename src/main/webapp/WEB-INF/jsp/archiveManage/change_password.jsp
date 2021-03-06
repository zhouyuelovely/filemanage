<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<html>

<head>
<meta charset="utf-8">
<title>系统管理_修改密码</title>
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
	href="${pageContext.request.contextPath}/css/retrieve-password.css" />
<link href="${pageContext.request.contextPath}/css/skin_01.css"
	rel="stylesheet" type="text/css" id="skin">
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
<style type="text/css">
/*.layui-body{overflow-y: scroll;} 滚动条问题*/
/*.layui-nav-item a:hover {
          background-color: #47abd2!important;
          color: #FFFFFF!important;
		}*/
.gong_color {
	color: red;
	font-weight: bold;
}

#nav_system {
	float: left;
	height: 500px;
	margin-left: 60px;
	background: none;
	width: 240px;
	padding: 0 20px;
	border-radius: 2px;
	border-right: 1px solid #000000;
	box-sizing: border-box;
}

#nav_system a, h5 {
	font-size: 20px;
}

#nav_system i {
	font-size: 20px;
	margin-right: 20px;
}

#nav_system li {
	height: 30px;
	text-align: center;
	margin: 20px 0px;
	border-bottom: 1px solid #000000;
}

.nav_one {
	background-color: #47abd2;
	border: none;
}

.nav_one a {
	color: #FFFFFF;
}
/*找回密码*/
#register {
	width: 500px;
	background: #FFFFFF;
	margin: 100px auto;
}

.change_pw {
	float: left;
	margin-top: 8px;
	font-weight: bold;
	margin-left: 50px;
}

.putt {
	float: left;
	width: 60%;
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
				<div class="layui-side-scroll">
					<!--class 个性化设置nav_bg1-->
					<div class="layui-logo nav_bg1" lay-href="#"
						style="margin-top: 80px;">
						<span>档案管理存储系统</span>
					</div>
					<ul class="layui-nav layui-nav-tree" lay-filter="test" id="nav_bar">
						<li class="layui-nav-item  layui-hide-xs"><img
							src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav1.png" /></li>
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
						<li class="layui-nav-item  layui-hide-xs">
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
			<div id="" class="gong" style="left: 220px; text-align: left;">
				<p style="line-height: 38px;">
					<i class="fa fa-volume-up gong_color" style="padding: 0 20px;"></i><span>
						<span class="gong_color">消息提示：</span> 您有<span>${requestScope.messageNum}</span>条<a
						href="#" class="gong_color">未读</a>消息，请及时处理！
					</span>
				</p>
			</div>
			<div class="top_bar">
				<!-- 头部区域 -->
			<ul class="layui-nav" id="top_nav">
					<c:if test="${zm:buttenPremission('ba',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-this">
							<a href="${pageContext.request.contextPath}/archive/archiveListShow">全宗管理</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bc',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/messageNotification/goNotification">消息提醒</a>	
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bd',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/classfication/getAllPrimaryClass">档案自定义</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>	
					</c:if>
					<c:if test="${zm:buttenPremission('bg',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/roleManagement/getRoleList">角色管理</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bh',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/user/getUserList">用户管理</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bi',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
					 		<a href="${pageContext.request.contextPath}/loggingProduce/goSafetyManagement">安全管理</a>
						</li>
							<span class="layui-hide-xs span_color ">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bj',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/systemSetup/goToSystemSetup">系统设置</a>
						</li>
					</c:if>
				</ul>
			</div>



				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					 <div class="layui-inline" style="padding-top: 10px;padding-left:10px;width: 100%;">
					 		<ul  id="nav_system">
							  <li class="nav_one"><a href="#"><i class="fa fa-cog"></i>系统设置</a></li>
							  <li><a href="${pageContext.request.contextPath}/systemSetup/goToSystemSetup"><i class="fa fa-bars"></i>个性设置&nbsp;&nbsp;&nbsp;&gt;</a></li>
							  <li><a href="${pageContext.request.contextPath}/systemSetup/goToChangePassword" style="color:#47ABD2;"><i class="fa fa-unlock-alt"></i>&nbsp;修改密码&nbsp;&nbsp;&nbsp;&gt;</a></li>
							</ul>
					<div style="float: left; width: 60%; margin-left: 50px;">
						<h5>修改密码...</h5>
						<hr class="layui-bg-black" />
						<div
							class="layadmin-user-login-box layadmin-user-login-body layui-form"
							id="register">
							<h3 class="title">
								<span style="font-weight: bold; color: #000000;">修改密码</span>
							</h3>
							<div class="layui-form-item">
								<label for="login-password" class="change_pw">请输入原密码</label> <input
									type="password" name="password" lay-verify="required"
									placeholder="请输入原密码" class="layui-input putt" />
							</div>
							<div class="layui-form-item">
								<label for="login-password1" class="change_pw">请输入新密码</label> <input
									type="password" name="password1" lay-verify="required"
									placeholder="请输入新密码" class="layui-input putt" />
							</div>
							<div class="layui-form-item">
								<label for="login-password2" class="change_pw">请确认新密码</label> <input
									type="password" name="password2" lay-verify="required"
									placeholder="请确认密码" class="layui-input putt" />
							</div>
							<div class="layui-form-item" style="text-align: center;">
								<button class="layui-btn" lay-submit lay-filter="login-submit"
									id="regBtn">确认修改密码</button>
							</div>
						</div>
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
		<!--[if IE 6]>
		<script type="text/javascript" src="../js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->

		<script type="text/javascript">
			//退出登陆
			function loginOut() {
				layer
						.confirm(
								'您确定要退出系统吗?',
								{
									btn : [ '确定', '取消' ]
								//按钮
								},
								function(index) {
									layer.close(index);
									//此处请求后台程序，下方是成功后的前台处理……
									var index = layer.load(0, {
										shade : [ 0.7, '#393D49' ]
									}, {
										shadeClose : true
									}); //0代表加载的风格，支持0-2
									window.location.href = "${pageContext.request.contextPath}/log/logout";
								});
			}

			//修改密码
			$(document)
					.ready(
							function() {
								$("#regBtn")
										.click(
												function() {
													var password = $(
															"input[name='password']")
															.val();
													var password1 = $(
															"input[name='password1']")
															.val();
													var password2 = $(
															"input[name='password2']")
															.val();
													if (password1 == password) {
														layer
																.msg("新密码不能和原密码一致!");
													} else if (password1 != password2) {
														layer
																.msg("确认密码和新密码不一致!");
													} else {
														$
																.ajax({
																	url : "${pageContext.request.contextPath}/systemSetup/changePassword",
																	data : {
																		"userPassword" : password,
																		"userNewPassword" : password2
																	},
																	type : "POST",
																	dataType : "json",
																	success : function(
																			data) {
																		console
																				.log("回调参数:"
																						+ data);
																		if (data == 1) {
																			layer
																					.msg(
																							"密码修改成功!",
																							{
																								time : 2000
																							},
																							function() {
																								offset: [
																										'100px',
																										'100px' ]
																								location.href = "${pageContext.request.contextPath}/log/logout";
																							});
																		} else if (data == 0) {
																			layer
																					.msg("密码修改失败,原密码错误!");
																		}
																	},
																	error : function(
																			e) {
																		console
																				.log(e);
																		layer
																				.msg("未知错误异常,请联系系统管理员!");
																	}
																});
													}
												});
							});
		</script>
</body>
</html>
