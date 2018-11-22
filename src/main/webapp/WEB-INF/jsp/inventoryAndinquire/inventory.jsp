<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
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
		<title>盘点管理_盘点计划</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css" />
		<link href="${pageContext.request.contextPath}/css/skin_01.css" rel="stylesheet" type="text/css" id="skin">
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
		<style type="text/css">
			/*.layui-body{overflow-y: scroll;} 滚动条问题*/
			
			table tr th div,
			table tr td {
				text-align: center;
			}
			
			body .add_label_bg>.layui-layer-title,
			.btn_color {
				background: #EA5519;
				color: #FFFFFF;
			}
			.gong_color{
				color: red;
				font-weight: bold;
			}
			.viewer-container,
			.viewer-fixed,
			.viewer-fade,
			.viewer-transition,
			.viewer-in {
				z-index: 99999999999!important;
				/*弹出层查看图片优先级提升*/
			}
			
			#form_catalog {
				background: #FFFFFF;
				height: 100%;
				padding-top: 15px;
				border-radius: 4px;
				box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .1);
				margin: 0 15px;
			}
			
		</style>
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
					<div class="layui-side-scroll nav_bg1">
						<!--class 个性化设置nav_bg1-->
						<div class="layui-logo nav_bg1" lay-href="#" style="margin-top: 80px;">
							<span>档案管理存储系统</span>
						</div>
						<ul class="layui-nav layui-nav-tree" lay-filter="test" id="nav_bar">
								<li class="layui-nav-item  layui-hide-xs"><img
							src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav1.png" /></li>
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
						<li class="layui-nav-item  layui-hide-xs ">
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
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
					<p style="line-height: 38px;"><i class="fa fa-volume-up gong_color" style="padding:0 20px;"></i><span>
						<span class="gong_color">消息提示：</span> 您有
						<span>${requestScope.messageNum}</span>条
						<a href="${pageContext.request.contextPath}/messageNotification/goNotification" class="gong_color">未读</a>消息，请及时处理！</span>
					</p>
					</c:if>
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						<c:if test="${zm:buttenPremission('ja',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
								<a href="${pageContext.request.contextPath}/inventoryManagement/goToInventoryManagement">盘点计划</a>
							</li>
							<span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('jb',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/inventoryManagement/goToInventoryPlansList">计划列表</a>
							</li>
						</c:if>
						
					</ul>
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;padding: 15px;">
					<div class="layui-row layui-col-space15">
						<div class="layui-col-md6">
							<div class="layui-card">
					          <div class="layui-card-header">制作盘点计划</div>
					          <div class="layui-card-body">
					          	<form class="layui-form" action="" lay-filter="component-form-element">
					              <div class="layui-row layui-col-space10 layui-form-item">
					                <div class="layui-col-lg6">
					                  <label class="layui-form-label">全宗名称：</label>
					                  <div class="layui-input-block">
					                    <select name="type" lay-verify="required" lay-filter="quanzongName" id="quanzongName">
					                      <option value="">请选择</option>
					                      <c:forEach items="${quanzongNameList}" var="quanzong">
						                      <option value="${quanzong.quanzongName}">${quanzong.quanzongName}</option>
					                      </c:forEach>
					                    </select>
					                  </div>
					                </div>
					                <div class="layui-col-lg6">
					                  <label class="layui-form-label">年度：</label>
					                  <div class="layui-input-block">
					                    <select name="boxAnual" lay-verify="required" lay-filter="boxAnual" id="boxAnual">
					                      <option value="" id="boxAnualOption">请选择</option>
					                    </select>
					                  </div>
					                </div>
					                 <div class="layui-col-lg6">
					                  <label class="layui-form-label">档案类型：</label>
					                  <div class="layui-input-block">
					                    <select name="pcName" lay-verify="required" lay-filter="pcName" id="pcName">
					                      <option value="" id="pcNameOption">请选择</option>
					                    </select>
					                  </div>
					                </div>
					                 <div class="layui-col-lg6">
					                  <label class="layui-form-label">保管期限：</label>
					                  <div class="layui-input-block">
					                    <select name="retentionperiodname" lay-verify="required" lay-filter="retentionperiodname" id="retentionperiodname">
					                      <option value="" id="retentionperiodnameOption">请选择</option>
					                    </select>
					                  </div>
					                </div>
					              </div>
					            </form>
					            <table class="layui-table" id="demo"></table>
					             <div style="text-align: right;padding:15px 0;">
					             <c:if test="${zm:buttenPremission('jaa',sessionScope.user.role.authorities) }">
					             	<button class="layui-btn layui-btn-danger layui-btn-sm file_boxes">加入计划</button>
					             </c:if>
					             </div>
					          </div>
					        </div>
						</div>
						<div class="layui-col-md6">
							<div class="layui-card">
					          <div class="layui-card-header">盘点计划预览</div>
					          <div class="layui-card-body">
					          	<div style="padding: 30px 0;">
						          	<hr class="layui-bg-black">
						          	<hr class="layui-bg-orange">
						          	<hr class="layui-bg-black">
					          	</div>
					            <table class="layui-table" id="demotwo" lay-filter="demotwo"></table>
						         <div style="padding: 29px 0;">
							        <div class="layui-col-md6">
										<label for="">盘点合计：</label><span id="boxNumberId">${boxNumber}</span>盒
							        </div>
									<div class="layui-col-md6" style="text-align: right;">
									<c:if test="${zm:buttenPremission('jab',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-danger layui-btn-sm" id="plan">提交计划</button>
									</c:if>
									</div>
					            </div>
					            
					          </div>
					        </div>
					        <script type="text/html" id="barDemo">
								<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
							</script>
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
		<script src="${pageContext.request.contextPath}/js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/viewer.min.js" type="text/javascript" charset="utf-8"></script>
		 <script src="${pageContext.request.contextPath}/js/loginout.js" type="text/javascript" charset="utf-8"></script>
		<!--[if IE 6]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script>
			//加入计划
			$(function() {
				$(".file_boxes").click(function() {
					layui.use('table', function() {
						var table = layui.table;
						var checkStatus = table.checkStatus('demo')
						,data = checkStatus.data;
						var x=JSON.stringify(data);
						var y=JSON.parse(x);
						if(y.length>0){
							var boxIdList = new Array();
							for(var i=0;i<y.length;i++){
								boxIdList.push(y[i].boxId);	
							}
							$.ajax({
								url:"${pageContext.request.contextPath}/inventoryManagement/updateJoinPlanByBoxIdList"+"?timestamp="+Math.random(),
					  			async:false,
					  			data:"boxIdList="+boxIdList,
					  			type:"post",
					  			dataType:"json",
					  			success:function(data){
					  				if(data=true){
					  					layer.msg("加入计划成功!",{time:2000})
					  					setTimeout(function(){
					  						location.reload(); 
					  						}, 2000);
					  					
					  				}else{
					  					layer.msg("加入计划失败,请联系系统管理员!")
					  				}
					  			},error:function(){
									layer.msg("接口异常")
								}
							});
							
						}else{
							layer.msg("请勾选需要加入的计划!")
						}
					});
				});
			})
			
			
		
			//根据全宗名称查询年度
			layui.use('form', function() {
				var form = layui.form;
				var $ = layui.$;
				form.on('select(quanzongName)', function(data){
					var quanzongName = data.value;
					var jsonObj={"quanzongName":quanzongName};
			  		$.ajax({
			  			url:"${pageContext.request.contextPath}/inventoryManagement/queryBoxAnualByQuanzongName"+"?timestamp="+Math.random(),
			  			async:false,
			  			data:JSON.stringify(jsonObj),
			  			type:"post",
			  			dataType:"json",
			  			contentType:"application/json;chartset=utf-8",
			  			beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
			  			success:function(data){
			  			    var list=data.length;
			  			  	$("#boxAnualOption").nextAll().remove();
			  				for (var i = 0; i < list; i++) {
			  					$("#boxAnualOption").after("<option value="+data[i].boxAnual+">"+data[i].boxAnual+"</option>'");
			  				}
			  				layui.use('form', function() {
			  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  			        form.render();
			  			    }); 
			  			},error:function(){
							layer.msg("接口异常")
						}
			  		});
			  	})
			});
			
			//根据全宗名称、年度查询档案类型
			layui.use('form', function() {
				var form = layui.form;
				var $ = layui.$;
				form.on('select(boxAnual)', function(data){
					var quanzongName=$("#quanzongName").val();
					var boxAnual = data.value;
					var jsonObj={"quanzongName":quanzongName,"boxAnual":boxAnual};
			  		$.ajax({
			  			url:"${pageContext.request.contextPath}/inventoryManagement/queryPcNameByQuanzongNameAndBoxAnual"+"?timestamp="+Math.random(),
			  			async:false,
			  			data:JSON.stringify(jsonObj),
			  			type:"post",
			  			dataType:"json",
			  			contentType:"application/json;chartset=utf-8",
			  			beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
			  			success:function(data){
			  			    var list=data.length;
			  			  	$("#pcNameOption").nextAll().remove();
			  				for (var i = 0; i < list; i++) {
			  					$("#pcNameOption").after("<option value="+data[i].pcName+">"+data[i].pcName+"</option>'");
			  				}
			  				layui.use('form', function() {
			  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  			        form.render();
			  			    }); 
			  			},error:function(){
							layer.msg("接口异常")
						}
			  		});
			  	})
			});
			
			//根据全宗名称、年度、档案类型查询档案类型
			layui.use('form', function() {
				var form = layui.form;
				var $ = layui.$;
				form.on('select(pcName)', function(data){
					var quanzongName=$("#quanzongName").val();
					var	boxAnual=$("#boxAnual").val();
					var pcName = data.value;
					var jsonObj={"quanzongName":quanzongName,"boxAnual":boxAnual,"pcName":pcName};
			  		$.ajax({
			  			url:"${pageContext.request.contextPath}/inventoryManagement/queryRetentionperiodName"+"?timestamp="+Math.random(),
			  			async:false,
			  			data:JSON.stringify(jsonObj),
			  			type:"post",
			  			dataType:"json",
			  			contentType:"application/json;chartset=utf-8",
			  			beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
			  			success:function(data){
			  			    var list=data.length;
			  			  	$("#retentionperiodnameOption").nextAll().remove();
			  				for (var i = 0; i < list; i++) {
			  					$("#retentionperiodnameOption").after("<option value="+data[i].retentionperiodname+">"+data[i].retentionperiodname+"</option>'");
			  				}
			  				layui.use('form', function() {
			  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  			        form.render();
			  			    });
			  			},error:function(){
							layer.msg("接口异常")
						}
			  		});
			  	})
			});
			
			layui.use('form', function() {
				var form = layui.form;
				var $ = layui.$;
				var table = layui.table;
				form.on('select(retentionperiodname)', function(data){
					var quanzongName=$("#quanzongName").val();
					var	boxAnual=$("#boxAnual").val();
					var pcName = $("#pcName").val();
					var retentionperiodname=data.value;
					table.reload('demo', {
						  url: "${pageContext.request.contextPath}/inventoryManagement/queryBoxInfoByCondition"+"?timestamp="+Math.random()
						  ,where: {quanzongName:quanzongName,
							  	   boxAnual:boxAnual,
							  	   pcName:pcName,
							  	   retentionperiodname:retentionperiodname} //设定异步数据接口的额外参数
						  //,height: 300
						  ,method:'post',
					});
			  	})
			});
			
			layui.use('table', function() {
						var table = layui.table;
					
						//展示已知数据
						table.render({
							elem: '#demo',
							cellMinWidth: 80,
							/*url: '/api/upload/time=new Date();',*/
							cols: [
								[ //标题栏
									{
										type: 'checkbox',
										fixed: 'left'
									},
									{
										field: 'numbers',
										title: '序号',
										unresize: 'false',
										sort: true,
										templet: '#indexTpl',
									},{
										field: 'boxSericalNumber',
										title: '盒编号',
										unresize: 'false',
									},{
										field: 'pcName',
										title: '档案类型',
										unresize:'false',
									},{
										field: 'boxStartNumber',
										title: '起件号',
										unresize: 'false',
									},{
										field: 'boxEndNumber',
										title: '止件号',
										unresize: 'false',
									},
									{
										field: 'storageRacknumber',
										title: '位置',
										unresize: 'false',
									},]
								],
							
								//,skin: 'line' //表格风格
							even: true,
							page: true //是否显示分页
								//,limits: [5, 7, 10]
								,
							limit:5 //每页默认显示的数量
						});
						table.render({
								elem: '#demotwo',
								cellMinWidth: 80,
								url:"/filemanage/inventoryManagement/queryBoxInfo"+"?timestamp="+Math.random(),
								method:'post',
								cols: [
									[ //标题栏
										{
											field: 'numbers',
											title: '序号',
											unresize: 'false',
											templet: '#indexTpl',
											sort: true
										},{
											field: 'boxSericalNumber',
											title: '盒编号',
											width: 150,
											unresize: 'false',
										},{
											field: 'pcName',
											title: '档案类型',
											unresize:'false',
										},{
											field: 'boxStartNumber',
											title: '起件号',
											unresize: 'false',
										},{
											field: 'boxEndNumber',
											title: '止件号',
											unresize: 'false',
										},
										{
											field: 'storageRacknumber',
											title: '位置',
											unresize: 'false',
										},
										{
											field: 'right',
											title: '操作',
											unresize:'false',
											toolbar: '#barDemo'
										}]
									],
								
									//,skin: 'line' //表格风格
								even: true,
								page: true //是否显示分页
									//,limits: [5, 7, 10]
									,
								limit:5 //每页默认显示的数量
							});
							//删除计划
							table.on('tool(demotwo)', function(obj){
								 var data = obj.data;
								  if(obj.event === 'del'){
								      layer.confirm('真的删除行么', function(index){
								    	  var boxId=data.boxId;
								    	  $.ajax({
												url:"${pageContext.request.contextPath}/inventoryManagement/updateJoinPlanByBoxId"+"?timestamp="+Math.random(),
									  			async:false,
									  			data:"boxId="+boxId,
									  			type:"post",
									  			dataType:"json",
									  			success:function(data){
									  				if(data=true){
									  				  	obj.del();
									  					layer.msg("删除计划成功!")
												        layer.close(index);
									  				}else{
									  					layer.msg("删除计划失败,请联系系统管理员!")
									  				}
									  			},error:function(){
													layer.msg("接口异常")
												}
											});
								      });
								    } 
							});
							
							//根据全宗名称、盒年度、档案类型、保管期限渲染盒信息
							function queryBoxInfo(){
								var quanzongName=$("#quanzongName").val();
								var	boxAnual=$("#boxAnual").val();
								var pcName = $("#pcName").val();
								var retentionperiodname=$("#retentionperiodname").val();
								table.reload('demo', {
									  url: "${pageContext.request.contextPath}/inventoryManagement/queryBoxInfoByCondition"+"?timestamp="+Math.random()
									  ,where: {quanzongName:quanzongName,
										  	   boxAnual:boxAnual,
										  	   pcName:pcName,
										  	   retentionperiodname:retentionperiodname} //设定异步数据接口的额外参数
									  //,height: 300
									  ,method:'post',
								});
							}
						
					});
					
					$(function() {
						//须提前判断是否有一个checkbox勾选，不然则提示请勾选要执行的计划
						$("#plan").click(function() { //#btn为按钮id
							layer.open({
								type: 1,
								title: '<i class="fa fa-bars" style="padding:0 5px"></i>计划安排',
								area: ['350px', '280px'],
								skin: 'add_label_bg',
								offset: 'auto',
								shade: [0.8, '#393D49'],
								content:'<div class="layui-form-item" style="margin-top:15px;">'+
						          		'<label class="layui-form-label">盘点人</label>'+
						          		'<div class="layui-input-inline">'+
						                '<input type="text" required="" lay-verify="required" id="planPerson" placeholder="请输入盘点人" autocomplete="off" class="layui-input">'+
						          		'</div></div>'+
						        		'<div class="layui-form-item">'+
						          		'<label class="layui-form-label">实施日期</label>'+
						          		'<div class="layui-input-inline">'+
						                '<input type="text" required="" lay-verify="required" id="planStartdate" placeholder="年/月/日" autocomplete="off" class="layui-input">'+
						          		'</div></div>'+
						        		'<div class="layui-form-item">'+
						          		'<label class="layui-form-label">完成日期</label>'+
						          		'<div class="layui-input-inline">'+
						                '<input type="text" required="" lay-verify="required" id="planEnddate" placeholder="年/月/日" autocomplete="off" class="layui-input">'+
						          		'</div></div>'+
						          		'<div style="text-align: center;"><button class="layui-btn btn_color" id="submitPlan">确定</button></div>'
							  });
								
								// 验证日期
								function isDate(date) { 
									 var pattern = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/; 
									 return pattern.test(date); 
								}
								$(document).ready(function(){ 
									  $("#submitPlan").click(function(){
											if($("#boxNumberId").text()=='0'){
												layer.msg("没有可以提交的计划!");
											}else if($.trim($("#planPerson").val())=='' || $.trim($("#planStartdate").val())=='' || $.trim($("#planEnddate").val())==''){
												layer.msg("请填写完整表单信息!",{time:2000});
											}else if(isDate($("#planStartdate").val())== false || isDate($("#planEnddate").val())== false){
												layer.msg("请输入正确日期格式!")
											}else{
												var planPerson=$("#planPerson").val();
												var planStartdate=$("#planStartdate").val();
												var planEnddate=$("#planEnddate").val();
												var planBoxNumber=$("#boxNumberId").text();
												var jsonObj={"planPerson":planPerson,"planStartdate":planStartdate,"planEnddate":planEnddate,"planBoxNumber":planBoxNumber};
												$.ajax({
														url:"${pageContext.request.contextPath}/inventoryManagement/submitInventoryPlan",
														type:"post",
														contentType:"application/json;chartset=utf-8",
														dataType:"json",
														data: JSON.stringify(jsonObj),
														success:function(data){
															if(data==true){
																layer.msg("提交计划成功!",{time:2000})
																setTimeout(function(){ location.reload(); }, 1000);
															}else{
																layer.msg("提交计划失败,请联系系统管理员!")
															}
														},error:function(){
															layer.msg("接口异常,请重新登陆系统!")
														}
												  });
											}
									});
								});
						  });
					});
					
		</script>
		<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
         </script>
</body>

</html>