<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<meta http-equiv="pragma" content="no-cache"> 
     	<meta http-equiv="cache-control" content="no-cache"> 
    	<meta http-equiv="expires" content="0">
		<title>系统管理_安全管理</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
		<link href="${pageContext.request.contextPath}/css/skin_01.css" rel="stylesheet" type="text/css" id="skin">
		<link href="${pageContext.request.contextPath}/css/safety_management.css" rel="stylesheet" type="text/css">
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->

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
					<div class="layui-side-scroll">
						<!--class 个性化设置nav_bg1-->
						<div class="layui-logo nav_bg1" lay-href="#" style="margin-top: 80px;">
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
				<div id="" class="gong" style="left: 220px;text-align: left;">
					<c:if test="${zm:buttenPremission('bc',sessionScope.user.role.authorities) }">
				<p style="line-height: 38px;">
					<i class="fa fa-volume-up gong_color" style="padding: 0 20px;"></i><span>
						<span class="gong_color">消息提示：</span> 您有<span>${messageNum}</span>条<a
						href="${pageContext.request.contextPath}/messageNotification/goNotification"
						class="gong_color">未读</a>消息，请及时处理！
						
					</span>
					
				</p>	
			</c:if></div>
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
					 	<div id="query" style="padding-right: 20px;">
					 		<div class="layui-input-inline">
					        	登录用户
					     	</div>
					 		<div class="layui-input-inline">
					           </label><input type="text" name="name" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入用户名" />
					     	</div>
					     	<div class="layui-input-inline">
					        	从
					     	</div>
					 		<div class="layui-input-inline">
					        	<input type="text" name="begin" lay-verify="required|phone" autocomplete="off" class="layui-input dateone" placeholder="请选择开始时间" />
					     	</div>
					     	<div class="layui-input-inline">
					        	到
					     	</div>
					 		<div class="layui-input-inline">
					 		
					        	<input type="text" name="end" lay-verify="required|phone" autocomplete="off" class="layui-input datetwo" placeholder="请选择结束时间" />
					     	 </div>
					     	 <c:if test="${zm:buttenPremission('bia',sessionScope.user.role.authorities) }">
					     	<button class="layui-btn" data-type="queryCondition">查询</button>
					     	</c:if>
					 	</div> 
					 </div>
					<table class="layui-hide" id="demo" lay-filter="demo" style="width: 1000px;"></table>
					<script type="text/html" id="barDemo">
						<button class="layui-btn layui-btn-normal layui-btn-xs" lay-event="exceptContent">导出</button>
					</script>
					<div id="btn" style="margin: 18px 0;">
					<c:if test="${zm:buttenPremission('bic',sessionScope.user.role.authorities) }">
						<button class="layui-btn layui-btn-warm" data-type="moreExpect">批量导出</button>
						</c:if>
						<c:if test="${zm:buttenPremission('bid',sessionScope.user.role.authorities) }">
						<button class="layui-btn" data-type="oracleBackUp">数据备份</button>
						</c:if>
						<c:if test="${zm:buttenPremission('bie',sessionScope.user.role.authorities) }">
						<button class="layui-btn layui-btn-danger" data-type="oracleRestore">数据恢复</button>
					</c:if>
					</div>	
				</div>
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../layui/layui.all.js"></script>
		<script src="../layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<!--[if IE 6]>
		<script type="text/javascript" src="../js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script>
			layui.use('table', function() {
				var table = layui.table;

				//展示已知数据
				table.render({
					elem: '#demo',
					url:'${pageContext.request.contextPath}/loggingProduce/havingLoggingProduce?meng='+Math.random(),
					method:"post",
					cols: [
						[ //标题
							{
								type: 'checkbox',
								fixed: 'left'
							},
							{
								type: 'numbers',
								title: '序号',
								width: 100,
								unresize: 'false',
								templet: '#indexTpl',
							}, {
								field: 'userIpAddress',
								title: 'IP地址',
								width: 200,
								unresize:'false',
								toolbar:'#userIpAddress',
							}, {
								field: 'userHostName',
								title: '主机名',
								minWidth: 200,
								unresize:'false',
								toolbar:'#userHostName',
							}, {
								field: 'logContent',
								title: '操作内容',
								minWidth: 200,
								unresize:'false',
							}, {
								field: 'logCreateTime',
								title: '操作时间',
								width: 200,
								unresize:'false',
								toolbar:'#logTime'
							},
							{
								field: 'userName',
								title: '登录用户',
								width: 200,
								unresize:'false',
								toolbar:'#userName',
							},
							{
								field: 'right',
								title: '操作',
								width: 100,
								unresize:'false',
								toolbar: '#barDemo'
							}
						]
					],
					data: []
						//,skin: 'line' //表格风格
						,
					even: true,
					page: true //是否显示分页
					//,limits: [5, 7, 10]
					,limit: 10 //每页默认显示的数量
				});
				 //监听工具条
				  table.on('tool(demo)', function(obj){
				    var data = obj.data;
				    var tr = obj.tr;
				    var logId=data.logId
				    if(obj.event=='exceptContent'){
				    	exceptContent(logId)
				    }
				  });
				 
				 
				 
				 
				var $ = layui.$, active ={
					queryCondition:function(){
						var name=$("input[name='name']").val();//获取用户名
						var beginTime=$("input[name='begin']").val();//开始时间
						var endTime=$("input[name='end']").val();//结束时间
						table.reload('demo',{
							url: "${pageContext.request.contextPath}/loggingProduce/findLoggingProduceByCondition?meng="+<%=Math.random() %>,
							where:{name:name,beginTime:beginTime,endTime:endTime}
						});
						
					},
					moreExpect:function(){
						var checkStatus = table.checkStatus('demo')
						,data = checkStatus.data;
						var x=JSON.stringify(data);
						var y=JSON.parse(x);
						var str="";
						if(y.length>0){
							for(var i=0;i<y.length;i++){
								str+=y[i].logId+","
							}
							exceptContent(str)
						}else{
							layer.msg("选择备份的日志数据")
						}
					},
					oracleBackUp:function(){
						$.ajax({
							url:"${pageContext.request.contextPath}/loggingProduce/oracleBackUp?meng="+<%=Math.random() %>,
							dataType:"json",
							success:function(data){
								layer.msg("数据库备份成功")
							}
						})
					},
					oracleRestore:function(){
						$.ajax({
							url:"${pageContext.request.contextPath}/loggingProduce/oracleRestore?meng="+<%=Math.random() %>,
							dataType:"json",
							success:function(data){
								layer.msg("数据库恢复成功")
							}
						})
					}
				
				}
				//监听多选框的内容
				table.on('checkbox(demo)', function(obj){
					 console.log(obj)
				});
				//事件绑定
				$('#btn .layui-btn').on('click', function(){
					    var type = $(this).data('type');
					    active[type] ? active[type].call(this) : '';
				});
				$('#query .layui-btn').on('click', function(){
					    var type = $(this).data('type');
					    active[type] ? active[type].call(this) : '';
				});
				 
			});
			
			
			
			//时间插件
			layui.use(['layer', 'laydate'], function(){ 
				  var layer = layui.layer // 获取layer组件
				  ,laydate = layui.laydate; // 获取laydate组件
				  //执行一个laydate实例
					laydate.render({
					  elem: '.dateone', //指定元素
					  type: 'datetime',//日期时间
					  format: 'yyyy-MM-dd',//日期时间格式
  					  range: false,
					});
				});
			//时间插件
			layui.use(['layer', 'laydate'], function(){ 
				  var layer = layui.layer // 获取layer组件
				  ,laydate = layui.laydate; // 获取laydate组件
				  //执行一个laydate实例
					laydate.render({
					  elem: '.datetwo',//指定元素
					  type: 'datetime',//日期时间
					  format: 'yyyy-MM-dd',//日期时间格式
  					  range: false,
					});
				});
			//退出登录
			function loginOut(){
				layer.confirm('您确定要退出系统吗?', {
		            btn : [ '确定', '取消' ]//按钮
		        }, function(index) {
		            layer.close(index);
		            //此处请求后台程序，下方是成功后的前台处理……
		            var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
		            window.location.href="${pageContext.request.contextPath}/log/logout";
		        }); 
			}

			function exceptContent(str){
				window.location.href="${pageContext.request.contextPath}/loggingProduce/exceptContent?str="+str;
			}

			function dateForm(time){
				var date = new Date(time);
				var year=date.getFullYear();
				var month=(date.getMonth()+1);
				var date=date.getDate();
				if(month<10){
					month="0"+month;
				}
				if(date<10){
					date="0"+date;
				}
				return year+"-"+month+"-"+date;
			}

		</script>
		<script type="text/html" id="logTime">
        	{{ dateForm(d.logCreateTime)}}
    	</script>
    	<script type="text/html" id="userIpAddress">
				{{d.user.userIpAddress}}
		</script>
		<script type="text/html" id="userHostName">
				{{d.user.userHostName}}
		</script>
		<script type="text/html" id="userName">
				{{d.user.userName}}
		</script>
		<script type="text/html" id="indexTpl">
       		{{d.LAY_TABLE_INDEX+1}}
		</script>
	</body>

</html>