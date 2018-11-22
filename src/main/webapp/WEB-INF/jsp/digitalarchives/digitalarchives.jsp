<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>综合利用查询系统首页</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/digitalarchives.css"/>
    	
	</head>
	<body class="layui-layout-body">
		<div >
			<div class="layui-layout layui-layout-admin">

				<!--class 个性化设置nav_bg1-->
				<div class="copy">
					<!-- 版权所有 -->
					<p>COPYRIGHT&nbsp;&copy;2018<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有</p>
				</div>

				<div class="logo_nav" style="border-bottom: 1px dashed #C2C2C2;">
					<!-- 头部区域 -->
					<div>
						<span class="logo_img"><img src="${pageContext.request.contextPath}/imgs/home.gif" width="110" height="50"/></span>
						<div class="logo">
							综合利用查询系统
							<a href="${pageContext.request.contextPath}/log/goHome" id="home">返回主页&gt;</a>
						</div>	
					</div>
					
				</div>
				<!-- 主体内容 -->
				<div class="layui-body" id="index-bg" style="top:81px;left: 0;">
					<div class="layui-row">
						<div class="layui-col-sm12 layui-col-md6">
							<ul class="digital_nav">
								<li><a href="#"><img src="${pageContext.request.contextPath}/imgs/digital-1.png" /></a></li>
								<li>
								<c:if test="${zm:buttenPremission('lc',sessionScope.user.role.authorities) }">
									<a href="${pageContext.request.contextPath}/AdviceMapperController/modelAndView">
										<img src="${pageContext.request.contextPath}/imgs/digital-2.png" />
									</a>
									</c:if>
								</li>
								<li>
								<c:if test="${zm:buttenPremission('ld',sessionScope.user.role.authorities) }">
									<a href="${pageContext.request.contextPath}/readingRoom/publicArchiveShow">
										<img src="${pageContext.request.contextPath}/imgs/digital-3.png" />
									</a>
									</c:if>
								</li>
								<li>
								<c:if test="${zm:buttenPremission('lh',sessionScope.user.role.authorities) }">
									<a href="${pageContext.request.contextPath}/information/goarchivalInformation">
										<img src="${pageContext.request.contextPath}/imgs/digital-4.png" />
									</a>
									</c:if>
								</li>
							</ul>
						</div>
						<div class=" layui-col-sm12 layui-col-md6">
							<div id="message">
								<h4><i class="fa fa-list-ul"></i>信息公示</h4>
								<hr class="layui-bg-black">
								<ul class="title-list">
								  <c:forEach items="${listInformation}" var="information">
									<li><i class="fa fa-circle"></i>
									<p onclick="showInformationDetail('${information.iPId}')"><span style="display:inline-block;padding: 0 5px;">[${information.iPType}]</span>${information.iPName}</p>
									<p><fmt:formatDate value="${information.iPFormDate}" pattern="yyyy-MM-dd"/></p>
								   </li>
								</c:forEach>
								</ul>
								<ul class="title-list-t">
								<c:if test="${zm:buttenPremission('lh',sessionScope.user.role.authorities) }">
									<li><p><a href="${pageContext.request.contextPath}/information/goarchivalInformation">查看更多>>></a></p></li>
								</c:if>
								</ul>
								
							</div>
							
						</div>
					</div>	
				</div>
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!-- 图片预览插件 -->
		<script src="${pageContext.request.contextPath}/js/viewer.min.js"></script>
		<script type="text/javascript">
		   //点击信息名称进入信息查看页面
		   function showInformationDetail(id){
			   window.location.href="${pageContext.request.contextPath}/information/goarchivaldetail?iPId="+id;
		   }
		</script>
	</body>

</html>