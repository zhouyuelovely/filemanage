<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>综合利用查询系统_档案信息门户查看</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archivaldetail.css" />
		
	</head>
		<style>
			#edui1,#edui1_iframeholder{
			width:100%!important;
			}
			 .edui-default .edui-editor-toolbarboxinner{
				display:none;
			}
		 
		</style>
	<body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin">

			<!--class 个性化设置nav_bg1-->
			<div class="copy">
				<!-- 版权所有 -->
				<p>COPYRIGHT&nbsp;&copy;2018
					<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有</p>
			</div>

			<div class="logo_nav" style="border-bottom: 1px dashed #C2C2C2;">
				<!-- 头部区域 -->
				<div>
					<span class="logo_img"><img src="${pageContext.request.contextPath}/imgs/home.gif" width="110" height="50"/></span>
					<div class="logo">
					<c:if test="${zm:buttenPremission('la',sessionScope.user.role.authorities) }">
						<a href="${pageContext.request.contextPath}/information/godigitalarchives" style="color: #EA5519;">综合利用查询系统</a>
						</c:if>
						<a href="${pageContext.request.contextPath}/log/goHome" id="home">返回主页&gt;</a>
					</div>
				</div>

			</div>
			<!-- 主体内容 -->
			
			<div class="layui-body" id="index-bg" style="top:81px;left: 0;">
				<div class="layui-row">
					<div class="exchange_nav layui-col-sm12 layui-col-md12">
						<ul>
							<li>
								<a href="#">电子文件中心</a>
							</li>
							
							<li>
							<c:if test="${zm:buttenPremission('lc',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/AdviceMapperController/modelAndView">交流中心</a>
								</c:if>
							</li>
							<li>
							<c:if test="${zm:buttenPremission('ld',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/readingRoom/publicArchiveShow">电子阅览室</a>
								</c:if>
							</li>
							<li>
							<c:if test="${zm:buttenPremission('lh',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/information/goarchivalInformation" class="a1">档案信息门户</a>
							</c:if>
							</li>
						</ul>
					</div>
					<div class="layui-row" id="archivaldetail_text">
					 	<div style="float: left;">
					 		<span style="line-height: 20px;padding-left: 10px;">
						 		<i class="fa fa-step-forward font_color"></i>
						 		<c:if test="${zm:buttenPremission('lh',sessionScope.user.role.authorities) }">
						 		    <a href="${pageContext.request.contextPath}/information/goarchivalInformation"><span class="font_color">信息列表&nbsp;&gt;&gt;&nbsp;</span></a>
						 		    
					 			</c:if>
					 			<span>信息查看</span>
					 		</span>
					 	</div>
						<div class="layui-col-md12" style="padding: 15px;">
							<div style="border: 1px solid #EA5519;">
								<div style="margin: 0px 15%;">
									<div class="layui-card-header">
										<h1>${information.iPName}</h1>
										<p><span>来源:</span><span>${user.archive.quanzongName}</span>
										
										<span>发布时间:</span><span><fmt:formatDate value="${information.iPFormDate}" pattern="yyyy-MM-dd"/></span></p>
									</div>
									<div style="padding:5px 15px;">
									 <input type="hidden" name="iPId" id="iPId" value="${information.iPId}"/>
									 <textarea name="iPContent" id="iPContent" style="width: 100%;height: 300px;" readonly="readonly" type="text/plain">${information.iPContent}</textarea>
									   
									</div>
									<div style="text-align: right;padding:30px 0px;">
									<c:if test="${zm:buttenPremission('lh',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-sm layui-btn-warm" onclick="goarchivalInformation()">返回</button>
									</c:if>
									</div>
								</div>	
							</div>
						</div>
						
					</div>
					<script type="text/html" id="barDemo">
						<!-- 这里同样支持 laytpl 语法，如： -->
						<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
					</script>
				</div>
			</div>
		</div>
		
		<!-- 辅助元素，一般用于移动设备下遮罩 -->
		<div class="layadmin-body-shade" layadmin-event="shade"></div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!--富文本编辑器-->
		<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript">
		 //返回到档案信息门户列表页面
		  function goarchivalInformation(){
			  window.location.href="${pageContext.request.contextPath}/information/goarchivalInformation";
		  }
		 
		  var editor = new baidu.editor.ui.Editor({initialFrameHeight:600,initialFrameWidth:1000,autoHeightEnabled: false,});
       	 editor.render('iPContent'); 
		 
		</script>
		
	</body>

</html>