<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>数字档案管理平台首页</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--自定义css-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css"/>

		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
	</head>

	<body class="layui-layout-body">
		<div>
			<div class="layui-layout layui-layout-admin">
				<!-- 代码 开始 -->
				<div id="header">
					<div class="left_text">
						<img src="${pageContext.request.contextPath}/imgs/home.gif" height="120" />
					</div>
					<div class="riht_text">
						<span class="help">
								您好，<span>${user.userName}</span>
							<span class="mg_p"><i class="fa fa-question-circle"></i>帮助</span>
							<span class="mg_p"><i class="fa fa-check-circle-o"></i>关于</span>
							<span class="mg_p" onclick="loginOut()"><i class="fa fa-power-off"></i>退出</span>
						</span>
					</div>
				</div>
				<div class="content">
					<div class="main">
						<div>
							<h1 style="color: #FFFFFF;">数字档案管理平台</h1>
						</div>
						<ul>
							<c:if test="${zm:pagePremission(sort,sessionScope.user.role.authorities) }">
								<li>
									<a href="${pageContext.request.contextPath}/fileScanning/goFileScanning">
										<img class="img_small" src="${pageContext.request.contextPath}/imgs/home_img/u428.png" />
										<p class="pbg">
											档案收集整理系统
										</p>
									</a>
								</li>
							</c:if>
							<c:if test="${zm:pagePremission(manage,sessionScope.user.role.authorities) }">
								<li>
									<a href="${pageContext.request.contextPath}/archive/archiveListShow">
										<img class="img_small" src="${pageContext.request.contextPath}/imgs/home_img/u419.png" />
								 		<p class="pbg"> 档案管理存储系统 </p>
									</a>
								</li>
							</c:if>
							<c:if test="${zm:pagePremission(arch,sessionScope.user.role.authorities) }">
								<li>
									<a href="${pageContext.request.contextPath}/information/godigitalarchives">
										<img class="img_small" src="${pageContext.request.contextPath}/imgs/home_img/u410.png" />
										<p class="pbg">综合利用查询系统</p>
									</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="footer">
					<!-- 版权所有 -->
					<p>CopyRight&nbsp;&copy;2018
						<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有</p>
				</div>
				<!-- 代码 结束 -->
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
	 <script src="${pageContext.request.contextPath}/js/loginout.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>