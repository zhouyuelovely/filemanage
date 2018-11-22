<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<%
  String app_url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%
    response.setHeader("Pragma","No-cache"); 
    response.setHeader("Cache-Control","no-cache"); 
    response.setDateHeader("Expires", 0); 
    response.flushBuffer();
%>
<html>
<head>
		<meta charset="utf-8">
		<title>库房管理_档案入库</title>
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
			
			.gong_color {
				color: red;
				font-weight: bold;
			}
			
			.font-i {
				color: #EA5519;
				font-weight: bold;
				cursor: pointer;
			}
			
			.font-w {
				font-weight: bold;
				cursor: pointer;
			}
			.line-h{
				line-height: 36px;
			}
			.put {
				display: inline-block;
				width: 85%;
			}
			#ru,#bianji{
				display: none;
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
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
								test="${zm:buttenPremission('h',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/wareHouseBuild/wareHouseListShow"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav8.png" />库房管理<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs"><c:if
								test="${zm:buttenPremission('i',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/expiredFile/goDaoQi"><img
									src="${pageContext.request.contextPath}/imgs/doc-manage-center/nav9.png" />监测预警<span>&gt;</span></a>
							</c:if></li>
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
							<span class="gong_color">消息提示：</span>
							您有<span>${messageNum}</span>条
							<a href="${pageContext.request.contextPath}/messageNotification/goNotification" class="gong_color">未读</a>消息，请及时处理！</span>
						</p>
					</c:if>
					
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						<c:if test="${zm:buttenPremission('ha',sessionScope.user.role.authorities) }">
								<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/wareHouseBuild/wareHouseListShow">库房建设</a>
							</li><span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('hb',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
								<a href="${pageContext.request.contextPath}/wareHouseStorage/fileStorageShow">档案入库</a>
							</li>
						</c:if>
					</ul>
				</div>

				<!-- 主体内容 开始-->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-fluid">
						<div class="layui-row layui-col-space15">
							<div class="layui-card">
								<div class="layui-card-body" style="margin-top: 15px;">
									
										<div class="layui-row layui-col-space10 layui-form-item">
										<form class="layui-form" action="" lay-filter="component-form-element" method="post">
											<div class="layui-col-lg3">
												<label class="layui-form-label">全宗号：</label>
												<div class="layui-input-block">
													<select id="quanzongNumber" name="quanzongNumber" lay-filter="">
														<option value="">请选择</option>
														<c:forEach items="${archiveNumberList}" var="archive">
														    <option value="${archive.quanzongNumber}">${archive.quanzongNumber}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">全宗名称：</label>
												<div class="layui-input-block">
													<select id="quanzongName" name="quanzongName" lay-filter="">
														<option value="">请选择</option>
														<c:forEach items="${archiveNameList}" var="archive">
														<option value="${archive.quanzongName}">${archive.quanzongName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">档案类型：</label>
												<div class="layui-input-block">
													<select id="pcName" name="pcName" lay-filter="">
														<option value="">请选择</option>
														<c:forEach items="${pcNameList}" var="pc">
														<option value="${pc.pcName}">${pc.pcName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3" style=" padding-bottom: 15px;">
												<label class="layui-form-label">机构问题：</label>
												<div class="layui-input-block">
													<select id="scName" name="scName" lay-filter="">
														<option value="">请选择</option>
														<c:forEach items="${scNameList}" var="sc">
														<option value="${sc.scName}">${sc.scName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">年度：</label>
												<div class="layui-input-block">
													<select id="boxAnual" name="boxAnual" lay-filter="">
														<option value="">请选择</option>
														<c:forEach items="${boxAnualList}" var="boxs">
														<option value="${boxs.boxAnual}">${boxs.boxAnual}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">保管期限：</label>
												<div class="layui-input-block">
													<select id="retentionperiodName" name="retentionperiodName" lay-filter="">
														<option value="">请选择</option>
														<c:forEach items="${retentionperiodNameList}" var="retention">
														<option value="${retention.retentionperiodName}">${retention.retentionperiodName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">盒号：</label>
												<div class="layui-input-block">
													<select id="boxNumber" name="boxNumber" lay-verify="required" lay-filter="">
														<option value="">请选择</option>
														<c:forEach items="${boxNumberList}" var="boxs">
														<option value="${boxs.boxNumber}">${boxs.boxNumber}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											</form>
											 <div class="layui-col-lg3" style="text-align: center;">
											 <c:if test="${zm:buttenPremission('hba',sessionScope.user.role.authorities) }">
												<button id="boxInfoQueryConditions" class="layui-btn layui-btn-normal">查询</button>
												</c:if>
											</div>
										</div>
									   
									<table class="layui-table" id="demo" lay-filter="demo"></table>
									<script type="text/html" id="barDemo">
										<!-- 这里同样支持 laytpl 语法，如： -->
                            {{#  if(d.storageRackNumber !== null){  }}
								<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">编辑</a>
		 					{{#  } else if(d.storageRackNumber == null){ }}
                                <a class="layui-bg-gray layui-btn layui-btn-normal layui-btn-xs" lay-event="#">编辑</a>
							{{#  }  }}


										
									</script>
									<div  class="layui-btn-group demoTable" style="margin: 18px 0;">
										<span style="margin:0 15px;">档案合计：<b>${boxsNum}</b>盒</spna><span style="padding: 0 15px;"><b>${archiveFilesNum}</b>件</span><button class="layui-btn layui-btn-danger" data-type="getCheckLength" id="ruku">入库</button>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 主体内容结束-->
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
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
		<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
        </script>
		<script>
		
		layui.use(['upload','form', 'layer','table'], function() {
			var table = layui.table,
			form = layui.form,upload = layui.upload;
			var $ = layui.jquery;
			//展示已知数据
			table.render({
				elem: '#demo',
				url:"/filemanage/wareHouseStorage/boxInfoList",
				cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
				cols: [
					[ //标题栏
						{
							type: 'checkbox',
							fixed: 'left',
						},
						{
							type : 'numbers',
							title: '序号',
							unresize: 'false',
							sort: false,
							templet: '#indexTpl',
						},
						{
							field: 'quanzongNumber',
							title: '全宗号',
							unresize: 'false',
						}, {
							field: 'quanzongName',
							title: '全宗名称',
							unresize: 'false',
						}, {
							field: 'boxAnual',
							title: '年度',
							unresize: 'false',
						},
						{
							field: 'scName',
							title: '机构(问题)',
							unresize: 'false',
						},
						{
							field: 'retentionperiodName',
							title: '保管期限',
							unresize: 'false',
						},
						{
							field: 'pcName',
							title: '档案类型',
							unresize: 'false',
						},
						{
							field: 'boxNumber',
							title: '盒号',
							unresize: 'false',
						},
						{
							field: 'boxThickness',
							title: '盒属性',
							unresize: 'false',
						},
						{
							field: 'storageRackNumber',
							title: '架位号',
							event: 'setSign',
							unresize: 'false',
						},
						{
							field: 'right',
							title: '操作',
							unresize: 'false',
							toolbar: '#barDemo'
						}
					]
				],
				data: [],
				/*skin: 'nob' //表格风格
					,*/
				even: false,
				page: true //是否显示分页
					//,limits: [5, 7, 10]
					,
				limit: 10 //每页默认显示的数量
			});
			
			//编辑弹框
			table.on('tool(demo)', function(obj) {
				var data = obj.data;
				console.log(data);
			    var boxId = obj.data.boxId;
			    
				if(obj.event === 'edit') {
					 layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>编辑',
						area: ['400px', '430px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						//编辑弹出层
						content: 
							 "<form  id='bj' name='bj' class='archiveNames' method='post' target='nm_iframe'>"
						    +"<input type='hidden' name='boxId' id='boxId'/>"
							+"<div class='layui-form'><div class='layui-form-item'><label class='layui-form-label'>盒编号:</label><div>"+data.boxSericalNumber+"</div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>库房名称:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildName' id='wareHouseBuildName' name='wareHouseBuildName' lay-verify='required'><option value=''>请选择</option><c:forEach items='${wareHouseName}' var='num'><option value='${num.wareHouseBuildId}'>${num.wareHouseBuildName}</option></c:forEach></select></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>库房编号:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildNumber' lay-verify='required' id='wareHouseBuildNumber' name='wareHouseBuildNumber'><option value=''></option></select></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>密集架号:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildShelfNumber' id='wareHouseBuildShelfNumber' name='wareHouseBuildShelfNumber' lay-verify='required'><option value=''></select></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>组编号:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildGroupNumber' id='wareHouseBuildGroupNumber' name='wareHouseBuildGroupNumber' lay-verify='required'><option value=''></select></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>格子号:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildLatticeNumber' id='wareHouseBuildLatticeNumber' name='wareHouseBuildLatticeNumber' lay-verify='required'><option value=''></option></select></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'></label><div class='layui-input-inline'><input type='hidden' lay-filter='storageRackNumber' id='storageRackNumber' name='storageRackNumber' lay-verify='required'></div></div>"
							+"<div style='text-align: center;'><button class='layui-btn layui-btn-danger' id='editHouse' data-type='updateWareHouse'>确定</button></div></div>"
						    +"</form><iframe name='nm_iframe' style='display: none;'></iframe>",
						    
					});
					 layui.use('form', function() {
		  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
		  			        form.render();
		  			    });
					 
					 //遍历库房编号
					 $.ajax({
							url:"${pageContext.request.contextPath}/wareHouseStorage/listWareHouseNumber"+"?timestamp="+Math.random(),
							type:"post",
							beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0");
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
							dataType:"text",
							 cache:false,
							success:function(data){
								//json数组类型字符串取值
								var jsonObj =  JSON.parse(data);//转换为json对象
								console.log(jsonObj);
								for (var i = 0; i < jsonObj.length; i++) {
									$("#wareHouseBuildNumber").append("<option value='"+jsonObj[i].wareHouseBuildId+"'>"+jsonObj[i].wareHouseBuildNumber+"</option>");
									
								}
								layui.use('form', function() {
				  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
				  			        form.render();
				  			    });
								
							},
						});
					 
					//要编辑的入库的信息带入编辑弹出框中
				       $.ajax({
				    	  url:"${pageContext.request.contextPath}/wareHouseStorage/queryOneInStorageInfoById",
				    	  type:"post",
				    	  dataType:"json",
				    	  data:{"boxId":boxId},
				    	  success:function(data){
				    		  $("#boxId").val(boxId);
				    		  $("#storageRackNumber").val(data.storageRackNumber);  
				    		  /* layui.use('form', function() {
				  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
				  			        form.render();
				  			    }); */
				    	  },
				      });
					
					//编辑操作的请求
					 $().ready(function(){
						 $("#editHouse").click(function(){
					    	  
					    	  //获取架位号
							  var seperator1 = "-";
							  var a = $("#wareHouseBuildNumber").find("option:selected").text();   
							  var b = $("#wareHouseBuildShelfNumber").find("option:selected").text();
							  var c = $("#wareHouseBuildGroupNumber").find("option:selected").text();
							  var d = $("#wareHouseBuildLatticeNumber").find("option:selected").text();
							  var storageRackNumber = a + seperator1 + b + seperator1 + c + seperator1 + d;
							  document.getElementById("storageRackNumber").value = storageRackNumber;
							  //$("#mulselCarType").find("option:selected");
	 						        var boxId = $("#boxId").val();
									var storageRackNumber = $("#storageRackNumber").val();
									var wareHouseBuildId = $("#wareHouseBuildNumber").val();
									$.ajax({
										url:"${pageContext.request.contextPath}/wareHouseStorage/editOneInStorageInfo"+"?timestamp="+Math.random(),
										data:{
											"boxId":boxId,
											"storageRackNumber":storageRackNumber,
											"wareHouseBuildId":wareHouseBuildId
										},
										type:'post',
										dataType:'json',
										success:function(res){
											console.log(res);
											if(res){
													layer.msg("编辑成功!",{time:3000,offset: 'auto'},function(){
														location.reload();
													});
											}else{
												layer.msg("编辑失败")
											}
										},
										error:function(){
											layer.msg("接口异常")
										}
									});
							
					            });
					    });
					 
					   
					   //遍历所有密集架号
				       $.ajax({
							url:"${pageContext.request.contextPath}/wareHouseStorage/listWareHouseShelfNumbers"+"?timestamp="+Math.random(),
							type:'post',
							 beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							dataType:"json",
							cache:false,
							success:function(data){
								if(data.length==0){
									$("#wareHouseBuildShelfNumber").text("请选择");
								}else{
									for (var i = 0; i < data.length; i++) {
										$("#wareHouseBuildShelfNumber").append("<option value='"+data[i].wareHouseBuildShelfNumber+"'>"+data[i].wareHouseBuildShelfNumber+"</option>");
									}
								}
							},
						});
					   //遍历所有组号
				       /* $.ajax({
							url:"${pageContext.request.contextPath}/wareHouseStorage/listWareHouseGroupNumbers"+"?timestamp="+Math.random(),
							type:'post',
							 beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							dataType:"json",
							cache:false,
							success:function(data){
								if(data.length==0){
									$("#wareHouseBuildGroupNumber").text("请选择");
								}else{
									for (var i = 0; i < data.length; i++) {
										$("#wareHouseBuildGroupNumber").append("<option value='"+data[i].wareHouseBuildGroupNumber+"'>"+data[i].wareHouseBuildGroupNumber+"</option>");
									}
								}
							},
						});
					   //遍历所有格子号
				       $.ajax({
							url:"${pageContext.request.contextPath}/wareHouseStorage/listWareHouseLatticeNumbers"+"?timestamp="+Math.random(),
							type:'post',
							 beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							dataType:"json",
							cache:false,
							success:function(data){
								if(data.length==0){
									$("#wareHouseBuildLatticeNumber").text("请选择");
								}else{
									for (var i = 0; i < data.length; i++) {
										$("#wareHouseBuildLatticeNumber").append("<option value='"+data[i].wareHouseBuildLatticeNumber+"'>"+data[i].wareHouseBuildLatticeNumber+"</option>");
									}
								}
							},
						}); */
					   
				}
			});
			
			
//===============================jquery===================================================================
	        //多条件查询
			$().ready(function() {
				$("#boxInfoQueryConditions").click(function() {
					var quanzongNumber = $("#quanzongNumber").val();
					var quanzongName = $("#quanzongName").val();
					var pcName = $("#pcName").val();
					var scName = $("#scName").val();
					var boxAnual = $("#boxAnual").val();
					var retentionperiodName = $("#retentionperiodName").val();
					var boxNumber = $("#boxNumber").val();
					table.reload('demo',{
										url : '${pageContext.request.contextPath}/wareHouseStorage/queryBoxInfoByConditions',
										where : {
											//设定异步数据接口的额外参数，任意设
											quanzongNumber : quanzongNumber,
											quanzongName : quanzongName,
											pcName : pcName,
											scName : scName,
											boxAnual : boxAnual,
											retentionperiodName : retentionperiodName,
											boxNumber : boxNumber,
										//…
										},
										page : {
											curr : 1
										}
								});
					console.log(quanzongNumber);
					console.log(quanzongName);
					console.log(pcName);
					console.log(scName);
					console.log(boxAnual);
					console.log(retentionperiodName);
					console.log(boxNumber);

				})
			})
//========================================================编辑弹框select下拉框级联==============================================================
	form.on('select(wareHouseBuildNumber)', function(data){
		            var wareHouseBuildId=data.value;
					 var select='dd[lay-value=' + wareHouseBuildId + ']';
					$('#wareHouseBuildName').siblings("div.layui-form-select").find('dl').find(select).click();
					$.ajax({
						 url:"${pageContext.request.contextPath}/wareHouseStorage/listWareHouseShelfNumber"+"?timestamp="+Math.random(),
						 data:"wareHouseBuildId="+wareHouseBuildId,
						 type:"get",
						 //解决缓存问题
						 beforeSend :function(xmlHttp){
							 xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						     xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
						    cache:false,
						 dataType:"JSON",
						 success:function(data){
							 //密集架下拉框显示
							$("#wareHouseBuildShelfNumber").find("option:gt(0)").remove();
								var option = data[0].wareHouseBuildShelfNumber;
								console.log(option);
								 var arr = new Array();
								 arr = option.split('；');
								 for(var i in arr){
									 console.log(arr.length)
									 var mm="<option value='"+arr[i]+"'>"+arr[i]+"</option>"  
									 $("#wareHouseBuildShelfNumber").append(mm);
								 }
		                          form.render('select');
		                          
		                       //组编号下拉框显示
	                          $("#wareHouseBuildGroupNumber").find("option:gt(0)").remove();
								var option2 = data[0].wareHouseBuildGroupNumber;
								console.log(option2);
								 var arr2 = new Array();
								 arr2 = option2.split('；');
								 for(var i in arr2){
									 console.log(arr2.length)
									 var mm2="<option value='"+arr2[i]+"'>"+arr2[i]+"</option>"  
									 $("#wareHouseBuildGroupNumber").append(mm2);
								 }
		                          form.render('select');
			                          
			                   //格子编号下拉框显示
	                          $("#wareHouseBuildLatticeNumber").find("option:gt(0)").remove();
								var option3 = data[0].wareHouseBuildLatticeNumber;
								console.log(option3);
								 var arr3 = new Array();
								 arr3 = option3.split('；');
								 for(var i in arr3){
									 console.log(arr3.length)
									 var mm3="<option value='"+arr3[i]+"'>"+arr3[i]+"</option>"  
									 $("#wareHouseBuildLatticeNumber").append(mm3);
								 }
		                          form.render('select');
						 },
						 error:function(){
							 layer.msg("接口异常")
						 }
					 }) 
					 });

			
//========================================================入库弹框select下拉框级联==============================================================
	form.on('select(wareHouseBuildNumber2)', function(data){
		            var wareHouseBuildId=data.value;
					var select='dd[lay-value=' + wareHouseBuildId + ']';
					$('#wareHouseBuildName2').siblings("div.layui-form-select").find('dl').find(select).click();
					$.ajax({
						 url:"${pageContext.request.contextPath}/wareHouseStorage/listWareHouseShelfNumber"+"?timestamp="+Math.random(),
						 data:"wareHouseBuildId="+wareHouseBuildId,
						 type:"get",
						 //解决缓存问题
						 beforeSend :function(xmlHttp){
							 xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						     xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
						    cache:false,
						 dataType:"JSON",
						 success:function(data){
							 //密集架下拉框显示
							$("#wareHouseBuildShelfNumber2").find("option:gt(0)").remove();
								var option = data[0].wareHouseBuildShelfNumber;
								console.log(option);
								 var arr = new Array();
								 arr = option.split('；');
								 for(var i in arr){
									 console.log(arr.length)
									 var mm="<option value='"+arr[i]+"'>"+arr[i]+"</option>"  
									 $("#wareHouseBuildShelfNumber2").append(mm);
								 }
		                          form.render('select');
		                          
		                       //组编号下拉框显示
	                          $("#wareHouseBuildGroupNumber2").find("option:gt(0)").remove();
								var option2 = data[0].wareHouseBuildGroupNumber;
								console.log(option2);
								 var arr2 = new Array();
								 arr2 = option2.split('；');
								 for(var i in arr2){
									 console.log(arr2.length)
									 var mm2="<option value='"+arr2[i]+"'>"+arr2[i]+"</option>"  
									 $("#wareHouseBuildGroupNumber2").append(mm2);
								 }
		                          form.render('select');
			                          
			                   //格子编号下拉框显示
	                          $("#wareHouseBuildLatticeNumber2").find("option:gt(0)").remove();
								var option3 = data[0].wareHouseBuildLatticeNumber;
								console.log(option3);
								 var arr3 = new Array();
								 arr3 = option3.split('；');
								 for(var i in arr3){
									 console.log(arr3.length)
									 var mm3="<option value='"+arr3[i]+"'>"+arr3[i]+"</option>"  
									 $("#wareHouseBuildLatticeNumber2").append(mm3);
								 }
		                          form.render('select');
						 },
						 error:function(){
							 layer.msg("接口异常")
						 }
					 }) 
					 });
			
//==============================================function============================================		
			
			//编辑字段输入内容不为空验证 
			function validate_forms(thisform){
				with(thisform){
					if($.trim($('#wareHouseBuildNumber').val()).length==0){
						layer.msg("请选择库房编号");
						return false;
					}else if($.trim($('#wareHouseBuildShelfNumber').val()).length==0){
						layer.msg("请选择密集架号");
						return false
					}else if($.trim($('#wareHouseBuildGroupNumber').val()).length==0){
						layer.msg("请选择组编号");
						return false
					}else if($.trim($('#wareHouseBuildLatticeNumber').val()).length==0){
						layer.msg("请选择格子号");
						return false
					}else{
						$.ajax({
							url:"${pageContext.request.contextPath}/wareHouseStorage/updateOneInStorageInfo",
							type:"post",
							dataType:"text",
							data:$("#bianji").serialize(),
							async:false,
							success:function(result){
								if(result == 1){
									layer.msg("编辑成功!",{offset:'auto',time:3000},function(){
										 location.reload();
									});
								}else{
									layer.msg("修改失败");
								}
							},
						});
					}
				}
			}
			
			//入库
			var $ = layui.$, active ={
				getCheckLength:function(){
					var checkStatus = table.checkStatus('demo');
				      data = checkStatus.data;
				      layer.open({
							type: 1,
							title: '<i class="fa fa-bars" style="padding:0 5px"></i>入库',
							area: ['400px', '430px'],
							skin: 'add_label_bg',
							offset: 'auto',
							shade: [0.8, '#393D49'],
							content: "<form  id='rk' name='ruku' class='archiveNames' method='post' target='frameFile'>"
							+"<div class='layui-form'><div class='layui-form-item'>	<label class='layui-form-label'>档案盒数:</label><div class='layui-input-inline line-h'><span id='boxNum' style='color:red;'></span><span>&nbsp&nbsp&nbsp:盒</span></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>库房名称:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildName2' id='wareHouseBuildName2' name='wareHouseBuildName' lay-verify='required'><option value=''>请选择</option><c:forEach items='${wareHouseName}' var='nums'><option value='${nums.wareHouseBuildId}'>${nums.wareHouseBuildName}</option></c:forEach></select></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>库房编号:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildNumber2' lay-verify='required' id='wareHouseBuildNumber2' name='wareHouseBuildNumber'><option value=''></option></select></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>密集架号:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildShelfNumber2' id='wareHouseBuildShelfNumber2' name='wareHouseBuildShelfNumber' lay-verify='required'><option value=''></select></div></div>"
							+"<div class='layui-form-item'><label class='layui-form-label'>组编号:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildGroupNumber2' id='wareHouseBuildGroupNumber2' name='wareHouseBuildGroupNumber' lay-verify='required'><option value=''></select></div></div>"
							+"<div class='layui-form-item'>	<label class='layui-form-label'>格子号:</label><div class='layui-input-inline'><select lay-filter='wareHouseBuildLatticeNumber2' id='wareHouseBuildLatticeNumber2' name='wareHouseBuildLatticeNumber' lay-verify='required'><option value=''></option></select></div></div>"
							+"<div class='layui-form-item'>	<label class='layui-form-label'></label><div class='layui-input-inline'><input type='hidden' lay-filter='storageRackNumber2' id='storageRackNumber2' name='storageRackNumber' lay-verify='required'></div></div>"
							+"<div style='text-align: center;'><button class='layui-btn layui-btn-danger' id='inHouse' data-type='inWareHouse'>确定</button></div></div>"
						    +"</form><iframe name='frameFile' style='display: none;'></iframe>"
						    
						});
				      //boxNum(hidden='')
				      $("#boxNum").text(data.length);
				     
				      
				      $.ajax({
							url:"${pageContext.request.contextPath}/wareHouseStorage/listWareHouseNumber"+"?timestamp="+Math.random(),
							type:"post",
							beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0");
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
							dataType:"text",
							 cache:false,
							success:function(data){
								//json数组类型字符串取值
								var jsonObj =  JSON.parse(data);//转换为json对象
								console.log(jsonObj);
								for (var i = 0; i < jsonObj.length; i++) {
									$("#wareHouseBuildNumber2").append("<option value='"+jsonObj[i].wareHouseBuildId+"'>"+jsonObj[i].wareHouseBuildNumber+"</option>");
									
								}
								layui.use('form', function() {
				  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
				  			        form.render();
				  			    });
								
							},
						});
				      
				      $("#inHouse").click(function(){
				    	  var checkStatus = table.checkStatus('demo');
				    	  console.log(data.length);
				    	  
				    	  //获取架位号
						  var seperator1 = "-";
						  var a = $("#wareHouseBuildNumber2").find("option:selected").text();
						  var b = $("#wareHouseBuildShelfNumber2").find("option:selected").text();
						  var c = $("#wareHouseBuildGroupNumber2").find("option:selected").text();
						  var d = $("#wareHouseBuildLatticeNumber2").find("option:selected").text();
						  var storageRackNumber = a + seperator1 + b + seperator1 + c + seperator1 + d;
						  document.getElementById("storageRackNumber2").value = storageRackNumber;
						  /* $("#storageRackNumber2").val(a.substr(a.length-1,1)+'-'+b.substr(b.length-1,1)+'-'+c.substr(c.length-1,1)+'-'+d.substr(d.length-1,1)); */
						  //$("#mulselCarType").find("option:selected");
						  if(checkStatus.data.length > 0){
								var arr=checkStatus.data;
								var str="";
								var index="all";
								for(j = 0,len=arr.length; j < len; j++) {                  
									console.log(arr[j]);
									if(arr[j]!=null){
										str+= arr[j].boxId+",";
										console.log(str);
									}else{
										index="some"
									}
								}
								function isInArray(str){
								    for(var i = 0; i < str.length; i++){
										if(null != str[i].storageRackNumber){
									    	return false;
									        }
									  }
									return true;
								}
							if(str.length > 0){
								var storageRackNumber = $("#storageRackNumber2").val();
								var wareHouseBuildId = $("#wareHouseBuildNumber2").val();
								console.log(checkStatus.data);
								if(isInArray(data) == false){
									layer.msg("抱歉！您选中的档案盒中存在'已入库'的档案盒，请从新选择！");
								}else if(isInArray(data) == true){
									$.ajax({
										url:"${pageContext.request.contextPath}/wareHouseStorage/updateOneInStorageInfo"+"?timestamp="+Math.random(),
										data:{
											str:str,
											storageRackNumber:storageRackNumber,
											wareHouseBuildId:wareHouseBuildId
										},
										type:'post',
										dataType:'json',
										success:function(res){
											console.log(res);
											if(res){
												if(index!='some'){
													layer.msg("入库成功!",{time:3000,offset: 'auto'},function(){
														location.reload();
													});
												}else{
													layer.msg("只能操作未入库的档案盒!",{time:3000,offset: 'auto'});
												}
											}else{
												layer.msg("入库失败")
											}
										},
										error:function(){
											layer.msg("接口异常")
										}
									});
								}
							}else{
								layer.msg("只能操作未入库的档案盒")
							}
						}else{
							layer.msg("请选择要入库的档案盒")
						}
				      })
				      
				      
					 },
				 }
			 
			 $('#inHouse').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			});
			 
			 
		      $('.demoTable .layui-btn-danger').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
		 	  });
			
		})
				
				
	
		</script>
	</body>
</html>