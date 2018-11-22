<%@ page language="java" pageEncoding="UTF-8" isErrorPage="true"%>
<%
String path=request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>404</title>
</head>
<body>
	<img width="1900px" height="800px" src="${pageContext.request.contextPath}/errorInfor/404.jpg">
	<a style="position: absolute;top: 678px;left: 895px;font-size: 30px;color: red;" href="${pageContext.request.contextPath}/log/goHome">返回首页</a>
</body>
</html>