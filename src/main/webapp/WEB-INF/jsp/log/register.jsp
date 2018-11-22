<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>登入 _注册</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="../layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="../css/login.css" />
		<link rel="stylesheet" type="text/css" href="../css/retrieve-password.css"/>
		
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body>

		<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login">
			<img src="../imgs/logo.gif" width="180" height="80" />
			<div class="layadmin-user-login-main">
				<div class="layadmin-user-login-box layadmin-user-login-header">
					<h1>数字档案管理平台</h1>
				</div>
				<div class="layadmin-user-login-box layadmin-user-login-body layui-form" id="register">
					<h3 class="title"><span style="font-weight: bold;">注册帐号</span></h3>
						<div class="layui-form-item">
							<label class="layadmin-user-login-icon layui-icon layui-icon-username" for="login-username"></label>
							<input type="text" name="userName" id="login-username" lay-verify="required" placeholder="请输入姓名" class="layui-input">
						</div>
						<div class="layui-form-item">
							<label class="layadmin-user-login-icon layui-icon layui-icon-password" for="login-password"></label>
							<input type="password" name="userPassword" id="login-password" lay-verify="required" placeholder="请输入密码" class="layui-input">
						</div>
					<div class="layui-form-item">
						<label class="layadmin-user-login-icon layui-icon layui-icon-password" for="login-password2"></label>
						<input type="password" name="password" id="login-password2" lay-verify="required" placeholder="请确认密码" class="layui-input">
					</div>
					<div class="layui-form-item">
						<button class="layui-btn layui-btn-fluid" id="regBtn" onclick="register()">注册</button>
					</div>
					<div class="layui-form-item bottomBox" style="margin-bottom: 20px;text-align: center;">
						<input type="checkbox"   class="title_color" id="regText" data-type="c">
						<label style="color: #FFFFFF;">
						已同意并阅读&nbsp;<a href="#" class="layadmin-link register_text">&lt;&nbsp;用户注册协议&nbsp;&gt;</a>
						</label>
					</div>
					
				</div>
			</div>

			<div class="layui-trans layadmin-user-login-footer">
				<p>COPYRIGHT&nbsp;&copy;2018&nbsp;<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;&nbsp;版权所有</p>
			</div>

		</div>
		<script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../layui/layui.all.js" type="text/javascript" charset="utf-8"></script>
		<!-- <script src="../js/register.js" type="text/javascript" charset="utf-8"></script> -->
	</body>
<script type="text/javascript">


	
	function register(){
		var x=$("#regText").is(":checked")
		if(x){
			var userName=$("#login-username").val();
			var userPassword=$("input[name='userPassword']").val();
			var passwrod=$("input[name='password']").val();
			if(userName!=""&&userPassword!=""&&passwrod!=""){
				if(passwrod!=userPassword){
					layer.msg("两次密码不一致")
				}else{
					
					$.ajax({
						url:"${pageContext.request.contextPath}/log/registerUser",
						data:{"userName":userName,"passwrod":passwrod},
						type:"post",
						dataType:"json",
						success:function(data){
							if(data==true){
								location.href="${pageContext.request.contextPath}/log/goLogin";
							}else{
								location.reload();//页面刷新
							}
						},
						error:function(){
							layer.msg("注册发生未知错误，请联系管理员")
						}
					})
				}
			}else{
				layer.msg("用户信息不为空")
			}
		}else{
			layer.msg("请阅读《用户注册协议》，阅读后请勾选确认")
		}
	}

</script>
</html>