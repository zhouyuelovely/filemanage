<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>系统管理_机构管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/layui/css/layui.css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css" media="all">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css" />
<link href="${pageContext.request.contextPath}/css/skin_01.css"
	rel="stylesheet" type="text/css" id="skin">

<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->

<style type="text/css">
table tr th div, table tr td {
	text-align: center;
}
/*添加全宗弹出层样式*/
.add_lb1 {
	margin: 20px 85px;
}

.add_lb2 {
	margin: 20px 70px;
}

body .add_label_bg>.layui-layer-title, .btn_color {
	background: #EA5519;
	color: #FFFFFF;
}
/*机构菜单*/
.font_color {
	color: #EA5519;
	font-weight: 300;
}

.gong_color {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body class="layui-layout-body">
	<div id="LAY_app">
		<div class="layui-layout layui-layout-admin">

			<!--class 个性化设置nav_bg1-->
			<div class="copy">
				<!-- 版权所有 -->
				<p>
					COPYRIGHT&nbsp;&copy;2018 <a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有
				</p>
			</div>

			<div class="logo_nav">
				<!-- 头部区域 -->
				<div>
					<span class="logo_img"><img
						src="${pageContext.request.contextPath}/imgs/home.gif" width="110"
						height="50" /></span> <span class="index_title"> <span><a
							href="${pageContext.request.contextPath}/log/goHome">数字档案管理平台</a></span>
					</span>
				</div>
				<div class="layui-layout-right" id="nav_help"
					style="line-height: 60px; font-weight: bold; font-size: 18px;">
					<a href="${pageContext.request.contextPath}/log/goHome">返回主页</a>
				</div>
			</div>

			<!-- 侧边菜单 -->
			<!--class 个性化设置nav_bg1-->
			<div class="layui-side layui-side-menu nav_bg1" id="menu_color"
				style="top: 80px">
				<div class="layui-side-scroll nav_bg1">
					<!--class 个性化设置nav_bg1-->
					<div class="layui-logo" lay-href="#" style="margin-top: 80px;">
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
			<div id="" class="gong" style="left: 220px; text-align: left;">
				<p style="line-height: 38px;">
					<i class="fa fa-volume-up gong_color" style="padding: 0 20px;"></i><span>
						<span class="gong_color">消息提示：</span> 您有<span>${messageNum}</span>条<a
						href="${pageContext.request.contextPath}/messageNotification/goNotification"
						class="gong_color">未读</a>消息，请及时处理！
					</span>
				</p>
			</div>
			<div class="top_bar">
				<!-- 头部区域 -->
				<ul class="layui-nav" id="top_nav">
					<li class="layui-nav-item layui-this">
						<a href="${pageContext.request.contextPath}/archive/archiveListShow">全宗管理</a>
					</li>
					<span class="layui-hide-xs span_color">|</span>
					<li class="layui-nav-item layui-hide-xs"><a
						href="${pageContext.request.contextPath}/messageNotification/goNotification">消息提醒</a>
					</li>
					<span class="layui-hide-xs span_color">|</span>
					<li class="layui-nav-item layui-hide-xs"><a
						href="${pageContext.request.contextPath}/classfication/getAllPrimaryClass">档案自定义</a>
					</li>
					<span class="layui-hide-xs span_color">|</span>
					<li class="layui-nav-item layui-hide-xs"><a
						href="${pageContext.request.contextPath}/roleManagement/getRoleList">角色管理</a>
					</li>
					<span class="layui-hide-xs span_color">|</span>
					<li class="layui-nav-item layui-hide-xs"><a
						href="${pageContext.request.contextPath}/user/getUserList">用户管理</a>
					</li>
					<span class="layui-hide-xs span_color">|</span>
					<li class="layui-nav-item layui-hide-xs"><a
						href="${pageContext.request.contextPath}/loggingProduce/goSafetyManagement">安全管理</a>
					</li>
					<span class="layui-hide-xs span_color">|</span>
					<li class="layui-nav-item layui-hide-xs"><a
						href="${pageContext.request.contextPath}/systemSetup/goToSystemSetup">系统设置</a>
					</li>
				</ul>
			</div>

			<!-- 主体内容 -->
			<div class="layui-body" id="LAY_app_body" style="top: 180px;">
				<div class="layui-inline" style="padding-top: 10px; width: 100%;">
					<div style="float: left;">
						<span style="line-height: 20px; padding-left: 10px;"> <i
							class="fa fa-step-forward font_color"></i> <a
							href="${pageContext.request.contextPath}/archive/archiveListShow"
							class="font_color">全宗管理</a>><span>机构管理</span>
						</span>
					</div>
					<div id="" style="float: right; padding-right: 20px;">
						<div class="layui-input-inline">
							<input type="tel" id="conditions" name="conditions"
								lay-verify="required|phone" autocomplete="off"
								class="layui-input" placeholder="请输入关键字">
						</div>
						<button class="layui-btn" id="orgQueryConditions">查询</button>
					</div>
				</div>
				<table class="layui-hide" id="demo" lay-filter="demo"></table>
				<script type="text/html" id="barDemo">
						<button class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">编辑</button>
						<button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>
					</script>
				<div id="" style="margin: 18px 0;">
					<c:if
						test="${zm:buttenPremission('bbd',sessionScope.user.role.authorities) }">
						<button class="layui-btn layui-btn-warm"
							onclick="$('input[id=fileContent]').click();">批量导入</button>
					</c:if>
					<form enctype="multipart/form-data" method="post"
						action="${pageContext.request.contextPath}/org/uploadFile"
						id="fileForm" style="display: inline;">
						<input type='text' id='archiveId' name='quanzongId'
							value='${quanzongId}' hidden='hidden' /> <input type="file"
							name="excelName" id="fileContent" style="display: none;"
							onchange="subForm()">
					</form>
					<c:if
						test="${zm:buttenPremission('bbe',sessionScope.user.role.authorities) }">
						<button class="layui-btn" id="downloadTemplate">模板下载</button>

						<button class="layui-btn layui-btn-danger add_label">添加机构</button>
					</c:if>
				</div>
			</div>
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
	<script
		src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.lqper.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/cookie.js"
		type="text/javascript" charset="utf-8"></script>
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
		var thisUrl = document.URL;
		console.log(thisUrl);
		var quanzongId = thisUrl.split("=")[1];
		console.log(quanzongId);
		layui
				.use(
						'table',
						function() {
							var table = layui.table;
							//展示已知数据
							table
									.render({
										elem : '#demo',
										url : '/filemanage/org/orgManageList?quanzongId='
												+ quanzongId,
										cols : [ [ //标题栏
										{
											field : 'numbers',
											title : '序号',
											width : 100,
											unresize : 'false',
											sort : true,
											templet : '#indexTpl',

										}, {
											field : 'organizationCode',
											title : '机构代码',
											width : 100,
											unresize : 'false',
										}, {
											field : 'organizationName',
											title : '机构名称',
											minWidth : 100,
											unresize : 'false',
										}, {
											field : 'organizationPhone',
											title : '机构电话',
											minWidth : 100,
											unresize : 'false',
										}, {
											field : 'organizationCreatetime',
											title : '创建日期',
											width : 120,
											unresize : 'false',
										}, {
											field : 'right',
											title : '操作',
											width : 200,
											unresize : 'false',
											toolbar : '#barDemo'
										} ] ],
										//,skin: 'line' //表格风格
										even : true,
										page : true //是否显示分页
										//,limits: [5, 7, 10]
										,
										limit : 8
									//每页默认显示的数量
									});
							//监听工具条
							table
									.on(
											'tool(demo)',
											function(obj) {
												var data = obj.data;
												var organizationId = obj.data.organizationId;
												if (obj.event === 'detail') {
													layer.msg('ID：' + data.id
															+ ' 的查看操作');
												} else if (obj.event === 'del') {
													layer
															.confirm(
																	'确定要删除该机构吗？',
																	{
																		title : '删除'
																	},
																	function(
																			index) {
																		obj
																				.del();
																		layer
																				.close(index);
																		$
																				.ajax({
																					url : "${pageContext.request.contextPath}/org/deleteOneOrganization",
																					type : "post",
																					dataType : "text",
																					data : {
																						"organizationId" : organizationId
																					},
																					success : function(
																							data) {
																						if (data == "true") {
																							layer
																									.msg(
																											"该机构已成功删除",
																											{
																												offset : 'auto',
																												time : 3000
																											},
																											function() {
																												location
																														.reload();
																											});
																						} else {
																							layer
																									.msg("该机构下存在用户，无法删除！");
																						}
																					},
																				});

																	});
												} else if (obj.event === 'edit') {
													layer
															.open({
																type : 1,
																title : '<i class="fa fa-bars" style="padding:0 5px"></i>编辑',
																area : [
																		'400px',
																		'280px' ],
																skin : 'add_label_bg',
																offset : 'auto',
																shade : [ 0.8,
																		'#393D49' ],
																//编辑弹出层
																content : "<form  id='orgForm1' name='orgForm1' class='orgNames' onsubmit='return validate_forms(this)' method='post' target='nm_iframe'>"
																		+ "<div class='add_lb2'><input type='text' id='quanzongId2' name='quanzongId' value='${quanzongId}' hidden='hidden'/></div>"
																		+ "<div class='add_lb1'><input type='hidden' id='organizationId' name='organizationId' ></div>"
																		+ "<div class='add_lb2'><label>机构代码</label><input type='text' id='organizationCode1' name='organizationCode' readonly='readonly'/></div>"
																		+ "<div class='add_lb2'><label>机构名称</label><input type='text' id='organizationName1' name='organizationName' readonly='readonly'/></div>"
																		+ "<div class='add_lb2'><label>机构电话</label><input type='text' id='organizationPhone1' name='organizationPhone' /></div>"
																		+ "<div class='add_lb2'><label>创建日期</label><input type='text' id='organizationCreatetime' name='organizationCreatetime' class='date1' placeholder='请选择日期' readonly='readonly'></div>"
																		+ "<div style='text-align: center;''><button class='layui-btn btn_color' type='submit'>确定</button></div>"
																		+ "</form>"
																		+ " <iframe id='id_iframe' name='nm_iframe' style='display:none;'></iframe> ",
															});

													//全宗的信息带入到弹出框中
													$
															.ajax({
																url : "${pageContext.request.contextPath}/org/queryOrganizationById",
																type : "post",
																dataType : "json",
																data : {
																	"organizationId" : organizationId
																},
																success : function(
																		data) {
																	console
																			.log(data);
																	$(
																			"#organizationId")
																			.val(
																					organizationId);
																	$(
																			"#organizationCode1")
																			.val(
																					data.organizationCode);
																	$(
																			"#organizationName1")
																			.val(
																					data.organizationName);
																	$(
																			"#organizationPhone1")
																			.val(
																					data.organizationPhone);
																	$(
																			"#organizationCreatetime")
																			.val(
																					data.organizationCreatetime);
																},
															});

													//日期控件
													layui
															.use(
																	[ 'layer',
																			'laydate' ],
																	function() {
																		var layer = layui.layer // 获取layer组件
																		, laydate = layui.laydate; // 获取laydate组件
																		//执行一个laydate实例
																		laydate
																				.render({
																					elem : '.date1' //指定元素
																				});
																	});
												}
											});
						});
		//添加机构
		$(function() {
			$(".add_label")
					.click(
							function() { //#btn为按钮id
								layer
										.open({
											type : 1,
											title : '<i class="fa fa-bars" style="padding:0 5px"></i>添加机构',
											area : [ '400px', '280px' ],
											skin : 'add_label_bg',
											offset : 'auto',
											shade : [ 0.8, '#393D49' ],
											content : "<form  id='orgForm' name='orgForm' class='orgNames' onsubmit='return validate_form(this)' method='post' target='nm_iframe2'>"
													+ "<div class='add_lb2'><input type='text' id='quanzongId' name='quanzongId' value='${quanzongId}' hidden='hidden'/></div>"
													+ "<div class='add_lb2'><label>机构代码</label><input type='text' id='organizationCode' name='organizationCode' /></div>"
													+ "<div class='add_lb2'><label>机构名称</label><input type='text' id='organizationName' name='organizationName' /></div>"
													+ "<div class='add_lb2'><label>机构电话</label><input type='text' id='organizationPhone' name='organizationPhone' /></div>"
													+ "<div class='add_lb2'><label>创建日期</label><input type='text' id='test1' name='organizationCreatetime' class='date1' placeholder='请选择日期'></div>"
													+ "<div style='text-align: center;''><button class='layui-btn btn_color' type='submit'>确定</button></div>"
													+ "</form>"
													+ " <iframe id='id_iframe2' name='nm_iframe2' style='display:none;'></iframe> ",
										});
								layui.use([ 'layer', 'laydate' ], function() {
									var layer = layui.layer, // 获取layer组件
									laydate = layui.laydate; // 获取laydate组件
									//执行一个laydate实例
									laydate.render({
										elem : '#test1' //指定元素
									});
								});
								//添加机构的弹出层中自动获取当前系统时间
								var date = new Date();
								var seperator1 = "/";
								var year = date.getFullYear();
								var month = date.getMonth() + 1;
								var strDate = date.getDate();
								var newDate = year + seperator1 + month
										+ seperator1 + strDate;
								document.getElementById("test1").value = newDate;
							})
		})
		//+++++++++++++++++++++++++++++++++++++++++++++++=========批量导入，模板下载===========++++++++++++++++++++++++++++++++++++++++++++++++

		//关键词查询
		$().ready(function() {
			var table = layui.table;
			$("#orgQueryConditions").click(function() {
				var conditions = $("#conditions").val();
				table.reload('demo', {
					url : '/filemanage/org/searchOrgByConditions',
					where : {
						//设定异步数据接口的额外参数，任意设
						conditions : conditions,

					//…
					},
					page : {
						curr : 1
					}
				});
				console.log(conditions);

			});
		});

		//模板下载
		$("#downloadTemplate")
				.bind(
						"click",
						function() {
							window.location.href = "${pageContext.request.contextPath}/org/downloadTemplate?filename=JGMB.xlsx"
						});

		function subForm() {
			$("#fileForm").submit();
		}

		//=====================================++++++++++++++++++++++++编辑全宗+++++++++++++++++++++++=======================================
		//编辑全宗字段输入内容不为空验证 
		function validate_forms(thisform) {
			with (thisform) {
				if ($.trim($('#organizationPhone1').val()).length == 0) {
					layer.msg("请输入电话号码");
					return false;
				} else if (isPhoneNo($.trim($('#organizationPhone1').val())) == false) {
					layer.msg("单位电话输入错误，请重新输入");
					return false;
				} else {
					$
							.ajax({
								url : "${pageContext.request.contextPath}/org/updateOneOrg",
								type : "post",
								data : $("#orgForm1").serialize(),
								dataType : "text",
								async : false,
								success : function(result) {
									if (result == 6) {
										layer.msg("机构修改成功!", {
											offset : 'auto',
											time : 3000
										}, function() {
											location.reload();
										});
									} else {
										layer.msg("机构修改失败");
									}
								},
							});
				}
			}
		}

		//+++++++++++++++++++++=======================添加机构=========================+++++++++++++++++++++++
		//添加全宗验证部分
		function validate_required(field, alerttxt) {
			with (field) {
				if (value == null || value == "") {
					layer.msg(alerttxt);
					return false
				} else {
					return true
				}
			}
		}

		//正则表达式验证电话号码
		function isPhoneNo(phone) {
			var pattern = /0\d{2,3}-\d{7,8}/;
			return pattern.test(phone);
		}

		// 添加全宗字段输入内容不为空验证 
		function validate_form(thisform) {
			with (thisform) {
				if (validate_required(organizationCode, "机构代码不能为空") == false) {
					organizationCode.focus();
					return false;
				}
				if (validate_required(organizationName, "机构名不能为空") == false) {
					organizationName.focus();
					return false;
				}
				if ($.trim($('#organizationPhone').val()).length == 0) {
					layer.msg("请输入机构电话");
					return false;
				} else if (isPhoneNo($.trim($('#organizationPhone').val())) == false) {
					layer.msg("机构电话输入错误，请重新输入");
					return false;
				} else {
					$
							.ajax({
								url : "${pageContext.request.contextPath}/org/addOneOrganization",
								type : "post",
								dataType : "text",
								data : $("#orgForm").serialize(),
								async : false,
								success : function(result) {
									if (result == 1) {
										layer.msg("机构代码已存在!", {
											time : 3000
										});
									} else if (result == 2) {
										layer.msg("机构名已存在", {
											time : 3000
										});
									} else if (result == 3) {
										layer.msg("机构电话已存在", {
											time : 3000
										});
									} else if (result == 4) {
										layer.msg("机构信息添加成功", {
											offset : 'auto',
											time : 3000
										}, function() {
											location.reload();
										});
									} else if (result == 5) {
										layer.msg("机构和机构分类信息添加成功", {
											offset : 'auto',
											time : 3000
										}, function() {
											location.reload();
										});
									} else {
										layer.msg("添加失败", {
											time : 3000
										});
									}
								},
							});
				}
			}
		}

		//退出登录
		function loginOut() {
			layer
					.confirm(
							'您确定要退出系统吗?',
							{
								btn : [ '确定', '取消' ]
							//按钮
							},
							function(index) {
								layer.close(index);
								//此处请求后台程序，下方是成功后的前台处理……
								var index = layer.load(0, {
									shade : [ 0.7, '#393D49' ]
								}, {
									shadeClose : true
								}); //0代表加载的风格，支持0-2
								window.location.href = "${pageContext.request.contextPath}/log/logout";
							});
		}

		console.log($("#archiveId").val());
	</script>
</body>
</html>