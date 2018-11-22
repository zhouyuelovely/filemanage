<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<%
  String app_url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%
	response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
	response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 
	response.setHeader("Pragma","No-cache"); 
	response.setDateHeader("Expires", 0);
%>
<%   
  if(request.getProtocol().compareTo("HTTP/1.0")==0)   
        response.setHeader("Pragma","no-cache");   
  else   if(request.getProtocol().compareTo("HTTP/1.1")==0)   
        response.setHeader("Cache-Control","no-cache");   
  response.setDateHeader("Expires",0);   
%>
<html>

	<head>
		<meta charset="utf-8">
		<title>综合利用查询系统_档案信息门户</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archivalInformation.css" />
    	<script type="text/javascript" src="${pageContext.request.contextPath}/medire/WdatePicker.js"></script>
		
	</head>
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
						<a href="${pageContext.request.contextPath}/information/godigitalarchives" style="color: #EA5519;">综合利用查询系统</a>
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
					<div class="layui-row" style="margin: 0px 15px;">
						<div class="layui-col-md3" style="padding: 15px;">
							<div class="layui-form jiansuo">
								<label class="layui-form-label" style="margin: 7px 0;color: #EA5519;font-weight: bold;"><i class="fa fa-search-plus" style="padding:0 5px;"></i>档案检索</label>
								<div class="layui-carousel layui-clear" id="test1" style="margin-left: 7px;margin-bottom: 15px;padding-bottom:5px;border-bottom: 1px dashed #CCCCCC;">
									<div carousel-item id="hidde">
									   <c:forEach items="${listpc}" var="listpc">
										<div><a href="${listpc.pcUrl}" _black>
										<img src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>${listpc.pcPhotoAddress}?tang=<%=Math.random() %>" /></a></div>
										</c:forEach>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">发布时间</label>
									<div class="layui-input-block">
										<input  readonly="readonly" onClick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
										type="text" name="iPFormDate" id="iPFormDate" required="" placeholder="请选择时间" autocomplete="off" class="layui-input">
									</div> 
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">信息类型</label>
									<form class="layui-input-block">
										 <select name="iPType" id="iPType" lay-filter="iPType">
											<option value="">请选择</option>
											  <c:forEach items="${listIPType}" var="ipt">
											   <option value="${ipt.iPType}">${ipt.iPType}</option>
											 </c:forEach>
										</select>
									</form>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">关键词</label>
									<div class="layui-input-block">
										<textarea name="queryConditions" id="queryConditions" placeholder="请输入关键词" class="layui-textarea"></textarea>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
									<c:if test="${zm:buttenPremission('lha',sessionScope.user.role.authorities) }">
										<button class="layui-btn  layui-btn-sm" lay-submit lay-filter="formDemo" id="queryInfoConditionBtn">查询</button>
									</c:if>
									</div>
								</div>
							</div>
						</div>
						<div class="layui-col-md9" style="padding: 15px;">
							<div class="jiansuo_tabel layui-tab layui-tab-card">
								<div class="layui-card-header">
									<span style="color: #EA5519;font-weight: bold;"><i class="fa fa-th-list" style="padding: 0 5px;"></i>信息公示</span>
									<div style="float: right;">
									   <c:if test="${user.role.roleName !='公众' }">
										 <button class="layui-btn layui-btn-sm layui-btn-danger" onclick="goarchivalfabu()">信息发布</button>
									  </c:if>
									</div>
								</div>
								<div class="layui-tab-content" style="clear: both;">
									<table  class="layui-hide" id="exchangetabel" lay-filter="exchangetabel" style="color:#000;"> </table>
								</div>
							</div>
						</div>
						<!--<table class="layui-hide" id="exchange_tabel" lay-filter="exchange_tabel"></table>-->
					</div>
					<script type="text/html" id="barDemo">
						<!-- 这里同样支持 laytpl 语法，如： -->
						<a href="#" class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
					</script>
				</div>
			</div>
		</div>
		<!-- 辅助元素，一般用于移动设备下遮罩 -->
		<div class="layadmin-body-shade" layadmin-event="shade"></div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		 <script src="${pageContext.request.contextPath}/layui/lay/date-format.js" type="text/javascript" charset="utf-8"></script>
		 <script id="createTime" type="text/html">
                  {{#   
                      var date = new Date();
                      date.setTime(d.iPFormDate);
                   return date.Format("yyyy-MM-dd"); 
                }} 
    </script>
		<script type="text/javascript">
		
			//轮播图
			layui.use('carousel', function() {
				var carousel = layui.carousel;
				//建造实例
				carousel.render({
					elem: '#test1',
					width: '100%' //设置容器宽度
						,
					arrow: 'always' //始终显示箭头
						,
					interval: 5000
					//,anim: 'updown' //切换动画方式
				});
				
				
			});
			layui.use('table',function() {
				var table = layui.table;
				 var $=layui.$;   	    
				//展示已知数据
				table.render({
					elem: '#exchangetabel',
					url:"${pageContext.request.contextPath}/information/queryAllArchivalInformation"+"?timestamp="+Math.random(),
					height:515,
					cols: [
						[ //标题栏
							{
								field: 'iPIndexNum',
								title: '索引号',
								width: 80,
								unresize: 'false',
								sort: true
							},{
								field: 'iPDocumentNum',
								title: '文号',
								minWidth: 120,
								unresize: 'false',
							},
							{
								field: 'iPType',
								title: '信息类型',
								minWidth: 80,
								unresize: 'false',
							},{
								field: 'iPName',
								title: '信息名称',
								minWidth: 150,
								unresize: 'false',
							},{
								field: 'subjectHeadings',
								title: '主题词',
								width: 120,
								unresize: 'false',
							},
							{
								field: 'iPFormDate',
								title: '发布日期',
								width: 120,
								unresize: 'false',
								templet: '#createTime',
							},
							{
								field: 'right',
								title: '操作',
								width: 100,
								unresize: 'false',
								toolbar: '#barDemo'
							}
						]
					],
					even: true,
					page: true, //是否显示分页
					limit:10,   //默认十条数据一页  
				    limits:[10,20,30,50],//数据分页条  
				});
				//监听工具条
				table.on('tool(exchangetabel)', function(obj) {
					var data = obj.data;
					var tr = obj.tr;
					var IPId=obj.data.iPId;
					if(obj.event === 'detail') {
				       window.location.href="${pageContext.request.contextPath}/information/goarchivaldetail?iPId="+IPId;	
					}
					
					
				});
				
				
			});
			$(function() {
				$(".look-room").click(function() { //#btn为按钮id
					layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
						area: ['800px', '500px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						content: '<div class="add_lb1"></div>'
					});
				})
				
			})

			//关键词条件查询
			$().ready(function(){
				  var table = layui.table;
	     		   var $ = layui.$;
				$("#queryInfoConditionBtn").click(function(){
					 var queryConditions=$("#queryConditions").val();
					 var iPFormDate=$("#iPFormDate").val();
					 var iPType=$("#iPType").val();
					 table.reload('exchangetabel', {
    					  url:'${pageContext.request.contextPath}/information/queryInforByConditions'+"?timestamp="+Math.random(),
    					  where: { //设定异步数据接口的额外参数，任意设
    						  iPFormDate :iPFormDate,
   						       iPType:iPType,
    						   queryConditions: queryConditions,
    					  }
    					  ,page: {
    					    curr: 1 //重新从第 1 页开始
    					  }
    					});
    				console.log(queryConditions);
				})
			})
			//跳转到档案信息门户信息发布页面
			function goarchivalfabu(){
				window.location.href="${pageContext.request.contextPath}/information/goarchivalInfofabu"+"?timestamp="+Math.random();
			}
			
			
			
		</script>
	</body>

</html>