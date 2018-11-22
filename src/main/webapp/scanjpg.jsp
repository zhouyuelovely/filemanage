<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String app_url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript" event="OnUploadBtnClick()" for="scaner1">
	var havingIndex=document.getElementById("scaner1").uploadAllAsEachJpgToServerUrl("<%=app_url%>/text/scanning","123456","desc");
		
</script>

</head>
<body>
	<input type="button" value="扫描" id="btnScan" onclick="scan();" />
	<input type="button" value="按照多页jpg格式上传" id="btnUpload2"
		onclick="upload();" />
	<object classid="clsid:15D142CD-E529-4B01-9D62-22C9A6C00E9B"
		id="scaner1" width="100%" height="600"
		codebase="${pageContext.request.contextPath}/${pageContext.request.contextPath}/cabs/ScanOnWeb.cab#version=1,0,0,10">
		<param name="licenseMode" value="4">
		<param name="key1"
			value="jaI31uGLizEzKHEM1tTAYbu7iJg9pAZo/x3kOPT1yiP2nKVqHyHDotNj6rUwscILG3ZHOcpdJXFE+u0XCmFeRfmsyskjS3YTiqfvldT8lBBBwbZSFuYI/lXF3zG0AGzd1AM=">

	</object>

</html>