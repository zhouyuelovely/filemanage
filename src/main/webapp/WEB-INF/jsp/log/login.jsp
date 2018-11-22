<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>登入 _数字档案管理平台</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body>

		<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login">
			<img src="${pageContext.request.contextPath}/imgs/logo.gif" width="180" height="80" />
			<div class="layadmin-user-login-main">
				<div class="layadmin-user-login-box layadmin-user-login-header">
					<h1>数字档案管理平台</h1>
				</div>
					<form action="${pageContext.request.contextPath}/log/login" id="logForm" method="post">
						<div class="layadmin-user-login-box layadmin-user-login-body layui-form">
							<div class="layui-form-item">
								<label class="layadmin-user-login-icon layui-icon layui-icon-username" for="login-username"></label>
								<input type="text" name="username" id="login-username"  placeholder="姓名/身份证号" class="layui-input">
							</div>
							<div class="layui-form-item">
								<label class="layadmin-user-login-icon layui-icon layui-icon-password" for="login-password"></label>
								<input type="password" name="password" id="login-password"  placeholder="密码" class="layui-input">
							</div>
							<div class="layui-form-item" style="margin-bottom: 20px; height: 30px;">
								<input type="checkbox" name="rememberMe" lay-skin="primary" title="记住密码" class="title_color" value="true">
								<a href="${pageContext.request.contextPath}/log/goResetPassword" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;color:#FFFFFF;">忘记密码？</a>
							</div>
							<div class="layui-form-item">
								<input type="submit" class="layui-btn layui-btn-fluid" lay-submit lay-filter="login-submit" style="background: #EA5519;" value="登 入">
								<div style="color: red;">${error }</div>
							</div>
						</div>
					</form>
					<div class="layui-trans layui-form-item layadmin-user-login-other layadmin-user-login-header">
						<span id="user_name">
          			没有账号？<a href="${pageContext.request.contextPath}/log/goRegister" class="layadmin-link admin_color">注册帐号</a>
          		</span>
					</div>
			</div>

			<div class="layui-trans layadmin-user-login-footer">
				<p>COPYRIGHT&nbsp;&copy;2018&nbsp;<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;&nbsp;版权所有</p>
			</div>

		</div>

		<script src="${pageContext.request.contextPath}/layui/layui.all.js" type="text/javascript" charset="utf-8"></script>

	</body>
</html>