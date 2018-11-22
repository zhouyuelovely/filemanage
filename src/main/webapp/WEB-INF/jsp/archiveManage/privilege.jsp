<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<html>

	<head>
		<meta charset="utf-8">
		<title>档案管理存储系统_角色管理_权限</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
		<link href="${pageContext.request.contextPath}/css/skin_01.css" rel="stylesheet" type="text/css" id="skin">
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
    	<style type="text/css">
		/*.layui-body{overflow-y: scroll;} 滚动条问题*/
		table thead tr th,table tbody tr td{
			text-align: left;
		}
		input[type=checkbox]{
			height: 12px;
		}
		table span{
			margin: 0 10px;
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
			</c:if>
				</div>
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
					<div style="margin: 20px;">
					<%-- <c:if test="">
						
					</c:if> --%>
					<c:if test="${zm:buttenPremission('bge',sessionScope.user.role.authorities) }">
						<button class="layui-btn layui-btn-danger" id="noPermit">无效</button>
						</c:if>
						<c:if test="${zm:buttenPremission('bgd',sessionScope.user.role.authorities) }">
							<button class="layui-btn layui-btn-normal" id="permit">生效</button>
						</c:if>
						<button class="layui-btn layui-btn-cyan" style="float:right"  id="seleAll">全选</button>
					</div>
					<table class="layui-table">
					  <thead>
					    <tr>
					      <th style="text-align: center;">一级权限</th>
					      <th style="text-align: center;">二级权限</th>
					      <th style="text-align: center;">权限配置细则</th>
					    </tr> 
					  </thead>
					  <tbody  id="levelTbody">
					  	  <input type="hidden" name="roleId" id="roleId" value="${roleId}"/>
					  	  <!--一级权限档案收集整理系统开始-->
					  	<tr>
					      <td  rowspan="7"><input type="checkbox" value="1" id="1" onclick="selectAll(1)" <c:if test="${zm:checked('1',authoritys) }">checked</c:if> />档案收集整理系统</td>
					      <td><input type="checkbox" value="13" class="1" id="13" onclick="selectAllTwo(13)" <c:if test="${zm:checked('13',authoritys) }">checked</c:if> />档案扫描</td>
					      <td>
					      	<span><input type="checkbox" value="59" name="1" class="13" id="59" onclick="selectAllstr(59)" <c:if test="${zm:checked('59',authoritys) }">checked</c:if> />在线扫描</span>
					      	<span><input type="checkbox" value="60" name="1" class="13" id="60" onclick="selectAllstr(60)" <c:if test="${zm:checked('60',authoritys) }">checked</c:if> />离线导入</span>
					      	<span><input type="checkbox" value="61" name="1" class="13" id="61" onclick="selectAllstr(61)" <c:if test="${zm:checked('61',authoritys) }">checked</c:if> />识别首页</span>
					      	<span><input type="checkbox" value="62" name="1" class="13" id="62" onclick="selectAllstr(62)" <c:if test="${zm:checked('62',authoritys) }">checked</c:if> />保存</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="14" class="1" id="14" onclick="selectAllTwo(14)"<c:if test="${zm:checked('14',authoritys) }">checked</c:if> />档案存储</span></td>
					      <td>
					      	<span><input type="checkbox" value="63" name="1" class="14" id="63" onclick="selectAllstr(63)" <c:if test="${zm:checked('63',authoritys) }">checked</c:if> />关键词查询</span>
					      	<span><input type="checkbox" value="64" name="1" class="14" id="64" onclick="selectAllstr(64)" <c:if test="${zm:checked('64',authoritys) }">checked</c:if> />编辑</span>
					      	<span><input type="checkbox" value="65" name="1" class="14" id="65" onclick="selectAllstr(65)" <c:if test="${zm:checked('65',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="66" name="1" class="14" id="66" onclick="selectAllstr(66)" <c:if test="${zm:checked('66',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="67" name="1" class="14" id="67" onclick="selectAllstr(67)" <c:if test="${zm:checked('67',authoritys) }">checked</c:if> />提交整理</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="15" class="1" id="15" onclick="selectAllTwo(15)" <c:if test="${zm:checked('15',authoritys) }">checked</c:if> />档案编辑</span></td>
					      <td>
					      	<span><input type="checkbox" value="68" name="1" class="15" id="68" onclick="selectAllstr(68)" <c:if test="${zm:checked('68',authoritys) }">checked</c:if> />在线插扫</span>
					      	<span><input type="checkbox" value="69" name="1" class="15" id="69" onclick="selectAllstr(69)" <c:if test="${zm:checked('69',authoritys) }">checked</c:if> />离线插入</span>
					      	<span><input type="checkbox" value="70" name="1" class="15" id="70" onclick="selectAllstr(70)" <c:if test="${zm:checked('70',authoritys) }">checked</c:if> />识别首页</span>
					      	<span><input type="checkbox" value="71" name="1" class="15" id="71" onclick="selectAllstr(71)" <c:if test="${zm:checked('71',authoritys) }">checked</c:if> />保存信息</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="16" class="1" id="16" onclick="selectAllTwo(16)" <c:if test="${zm:checked('16',authoritys) }">checked</c:if> />鉴定分类</span></td>
					      <td>
					      	<span><input type="checkbox" value="72" name="1" class="16" id="72" onclick="selectAllstr(72)" <c:if test="${zm:checked('72',authoritys) }">checked</c:if> />全部文件</span>
					      	<span><input type="checkbox" value="73" name="1" class="16" id="73" onclick="selectAllstr(73)" <c:if test="${zm:checked('73',authoritys) }">checked</c:if> />待整理文件</span>
					      	<span><input type="checkbox" value="74" name="1" class="16" id="74" onclick="selectAllstr(74)" <c:if test="${zm:checked('74',authoritys) }">checked</c:if> />回收站</span>
					      	<span><input type="checkbox" value="75" name="1" class="16" id="75" onclick="selectAllstr(75)" <c:if test="${zm:checked('75',authoritys) }">checked</c:if> />返回上一件</span>
					      	<span><input type="checkbox" value="76" name="1" class="16" id="76" onclick="selectAllstr(76)" <c:if test="${zm:checked('76',authoritys) }">checked</c:if> />保存</span>
					      	<span><input type="checkbox" value="77" name="1" class="16" id="77" onclick="selectAllstr(77)" <c:if test="${zm:checked('77',authoritys) }">checked</c:if> />知识库</span>
					      	<span><input type="checkbox" value="78" name="1" class="16" id="78" onclick="selectAllstr(78)" <c:if test="${zm:checked('78',authoritys) }">checked</c:if> />知识类型</span>
					      	<span><input type="checkbox" value="79" name="1" class="16" id="79" onclick="selectAllstr(79)" <c:if test="${zm:checked('79',authoritys) }">checked</c:if> />查询</span>
					      	<span><input type="checkbox" value="80" name="1" class="16" id="80" onclick="selectAllstr(80)" <c:if test="${zm:checked('80',authoritys) }">checked</c:if> />点击进入</span>
					      	<span><input type="checkbox" value="81" name="1" class="16" id="81" onclick="selectAllstr(81)" <c:if test="${zm:checked('81',authoritys) }">checked</c:if> />新增知识库</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="17" class="1" id="17" onclick="selectAllTwo(17)" <c:if test="${zm:checked('17',authoritys) }">checked</c:if> />文件装盒</span></td>
					      <td>
					      	<span><input type="checkbox" value="82" name="1" class="17" id="82" onclick="selectAllstr(82)" <c:if test="${zm:checked('82',authoritys) }">checked</c:if> />关键词查询</span>
					      	<span><input type="checkbox" value="83" name="1" class="17" id="83" onclick="selectAllstr(83)" <c:if test="${zm:checked('83',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="84" name="1" class="17" id="84" onclick="selectAllstr(84)" <c:if test="${zm:checked('84',authoritys) }">checked</c:if> />装盒</span>
					      </td>
					    </tr>
					     <tr>
					      <td><input type="checkbox" value="18" class="1" id="18" onclick="selectAllTwo(18)" <c:if test="${zm:checked('18',authoritys) }">checked</c:if> />档案送审</span></td>
					      <td>
					      	<span><input type="checkbox" value="85" name="1" class="18" id="85" onclick="selectAllstr(85)" <c:if test="${zm:checked('85',authoritys) }">checked</c:if> />关键词查询</span>
					      	<span><input type="checkbox" value="86" name="1" class="18" id="86" onclick="selectAllstr(86)" <c:if test="${zm:checked('86',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="84" name="1" class="18" id="87" onclick="selectAllstr(87)" <c:if test="${zm:checked('87',authoritys) }">checked</c:if> />提交验收</span>
					      	<span><input type="checkbox" value="88" name="1" class="18" id="88" onclick="selectAllstr(88)" <c:if test="${zm:checked('88',authoritys) }">checked</c:if> />导出档案</span>
							<span><input type="checkbox" value="89" name="1" class="18" id="89" onclick="selectAllstr(89)" <c:if test="${zm:checked('89',authoritys) }">checked</c:if> />重新整理</span>
					      </td>
					    </tr>
					     <tr>
					      <td><input type="checkbox" value="19" class="1" id="19" onclick="selectAllTwo(19)" <c:if test="${zm:checked('19',authoritys) }">checked</c:if> />档案审核</span></td>
					      <td>
					      	<span><input type="checkbox" value="90" name="1" class="19" id="90" onclick="selectAllstr(90)" <c:if test="${zm:checked('90',authoritys) }">checked</c:if> />关键词查询</span>
					      	<span><input type="checkbox" value="91" name="1" class="19" id="91" onclick="selectAllstr(91)" <c:if test="${zm:checked('91',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="92" name="1" class="19" id="92" onclick="selectAllstr(92)" <c:if test="${zm:checked('92',authoritys) }">checked</c:if> />驳回重整</span>
					      	<span><input type="checkbox" value="93" name="1" class="19" id="93" onclick="selectAllstr(93)" <c:if test="${zm:checked('93',authoritys) }">checked</c:if> />验收合格</span>
					      </td>
					    </tr>
					  	<!--一级权限档案收集整理系统结束-->
					  	<tr>
					  	<!--一级权限系统管理中心开始-->
					      <td  rowspan="10"><input type="checkbox" value="2" id="2" onclick="selectAll(2)" <c:if test="${zm:checked('2',authoritys) }">checked</c:if> />系统管理中心</td>

					      <td><input type="checkbox" value="20" class="2" id="20" onclick="selectAllTwo(20)" <c:if test="${zm:checked('20',authoritys) }">checked</c:if> />全宗管理</td>
					      <td class="system_str">
					      	<span><input type="checkbox" value="94" name="2" class="20" id="94" onclick="selectAllstr(94)" <c:if test="${zm:checked('94',authoritys) }">checked</c:if> />关键词查询</span>
					      	<span><input type="checkbox" value="95" name="2" class="20" id="95" onclick="selectAllstr(95)" <c:if test="${zm:checked('95',authoritys) }">checked</c:if> />机构管理</span>
					      	<span><input type="checkbox" value="96" name="2" class="20" id="96" onclick="selectAllstr(96)" <c:if test="${zm:checked('96',authoritys) }">checked</c:if> />编辑</span>
					      	<span><input type="checkbox" value="97" name="2" class="20" id="97" onclick="selectAllstr(97)" <c:if test="${zm:checked('97',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="98" name="2" class="20" id="98" onclick="selectAllstr(98)" <c:if test="${zm:checked('98',authoritys) }">checked</c:if> />批量导入</span>
					      	<span><input type="checkbox" value="99" name="2" class="20" id="99" onclick="selectAllstr(99)" <c:if test="${zm:checked('99',authoritys) }">checked</c:if> />模板下载</span>
					      	<span><input type="checkbox" value="100" name="2" class="20" id="100" onclick="selectAllstr(100)" <c:if test="${zm:checked('100',authoritys) }">checked</c:if> />添加全宗</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="21" class="2" id="21" onclick="selectAllTwo(21)" <c:if test="${zm:checked('21',authoritys) }">checked</c:if> />机构管理</td>
					      <td><!-- 222 -->
					      	<span><input type="checkbox" value="101" name="2" class="21" id="101" onclick="selectAllstr(101)" <c:if test="${zm:checked('101',authoritys) }">checked</c:if> />关键词查询</span>
					      	<span><input type="checkbox" value="102" name="2" class="21" id="102" onclick="selectAllstr(102)" <c:if test="${zm:checked('102',authoritys) }">checked</c:if> />编辑</span>
					      	<span><input type="checkbox" value="103" name="2" class="21" id="103" onclick="selectAllstr(103)" <c:if test="${zm:checked('103',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="104" name="2" class="21" id="104" onclick="selectAllstr(104)" <c:if test="${zm:checked('104',authoritys) }">checked</c:if> />批量导入</span>
					      	<span><input type="checkbox" value="105" name="2" class="21" id="105" onclick="selectAllstr(105)" <c:if test="${zm:checked('105',authoritys) }">checked</c:if> />模版下载</span>
					      	<span><input type="checkbox" value="106" name="2" class="21" id="106" onclick="selectAllstr(106)" <c:if test="${zm:checked('106',authoritys) }">checked</c:if> />添加机构</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="22" class="2" id="22" onclick="selectAllTwo(22)" <c:if test="${zm:checked('22',authoritys) }">checked</c:if> />消息提醒</td>
					      <td>
					      	<span><input type="checkbox" value="107" name="2" class="22" id="107" onclick="selectAllstr(107)" <c:if test="${zm:checked('107',authoritys) }">checked</c:if> />标记已读</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="23" class="2" id="23" onclick="selectAllTwo(23)" <c:if test="${zm:checked('23',authoritys) }">checked</c:if> />档案分类</td>
					      <td>
					      	<span><input type="checkbox" value="108" name="2" class="23" id="108" onclick="selectAllstr(108)" <c:if test="${zm:checked('108',authoritys) }">checked</c:if> />添加分类</span>
					      	<span><input type="checkbox" value="109" name="2" class="23" id="109" onclick="selectAllstr(109)" <c:if test="${zm:checked('109',authoritys) }">checked</c:if> />删除</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="24" class="2" id="24" onclick="selectAllTwo(24)" <c:if test="${zm:checked('24',authoritys) }">checked</c:if> />档案盒</td>
					      <td>
					      	<span><input type="checkbox" value="110" name="2" class="24" id="110" onclick="selectAllstr(110)" <c:if test="${zm:checked('110',authoritys) }">checked</c:if> />编辑</span>
					      	<span><input type="checkbox" value="111" name="2" class="24" id="111" onclick="selectAllstr(111)" <c:if test="${zm:checked('111',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="112" name="2" class="24" id="112" onclick="selectAllstr(112)" <c:if test="${zm:checked('112',authoritys) }">checked</c:if> />添加盒属性</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="25" class="2" id="25" onclick="selectAllTwo(25)" <c:if test="${zm:checked('25',authoritys) }">checked</c:if> />保管期限</td>
					      <td>
					      	<span><input type="checkbox" value="113" name="2" class="25" id="113" onclick="selectAllstr(113)" <c:if test="${zm:checked('113',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="114" name="2" class="25" id="114" onclick="selectAllstr(114)" <c:if test="${zm:checked('114',authoritys) }">checked</c:if> />添加保管期限</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="26" class="2" id="26" onclick="selectAllTwo(26)" <c:if test="${zm:checked('26',authoritys) }">checked</c:if> />角色管理</td>
					      <td>
					      	<span><input type="checkbox" value="115" name="2" class="26" id="115" onclick="selectAllstr(115)" <c:if test="${zm:checked('115',authoritys) }">checked</c:if> />查找用户</span>
					      	<span><input type="checkbox" value="116" name="2" class="26" id="116" onclick="selectAllstr(116)" <c:if test="${zm:checked('116',authoritys) }">checked</c:if> />添加角色</span>
					      	<span><input type="checkbox" value="117" name="2" class="26" id="117" onclick="selectAllstr(117)" <c:if test="${zm:checked('117',authoritys) }">checked</c:if> />删除角色</span>
					      	<span><input type="checkbox" value="118" name="2" class="26" id="118" onclick="selectAllstr(118)" <c:if test="${zm:checked('118',authoritys) }">checked</c:if> />生效</span>
					      	<span><input type="checkbox" value="119" name="2" class="26" id="119" onclick="selectAllstr(119)" <c:if test="${zm:checked('119',authoritys) }">checked</c:if> />无效</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="27" class="2" id="27" onclick="selectAllTwo(27)" <c:if test="${zm:checked('27',authoritys) }">checked</c:if> />用户管理</td>
					      <td>
					      	<span><input type="checkbox" value="120" name="2" class="27" id="120" onclick="selectAllstr(120)" <c:if test="${zm:checked('120',authoritys) }">checked</c:if> />关键词查询</span>
					      	<span><input type="checkbox" value="121" name="2" class="27" id="121" onclick="selectAllstr(121)" <c:if test="${zm:checked('121',authoritys) }">checked</c:if> />修改</span>
					      	<span><input type="checkbox" value="112" name="2" class="27" id="122" onclick="selectAllstr(122)" <c:if test="${zm:checked('122',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="123" name="2" class="27" id="123" onclick="selectAllstr(123)" <c:if test="${zm:checked('123',authoritys) }">checked</c:if> />重置密码</span>
					      	<span><input type="checkbox" value="124" name="2" class="27" id="124" onclick="selectAllstr(124)" <c:if test="${zm:checked('124',authoritys) }">checked</c:if> />批量导入</span>
					      	<span><input type="checkbox" value="125" name="2" class="27" id="125" onclick="selectAllstr(125)" <c:if test="${zm:checked('125',authoritys) }">checked</c:if> />模板下载</span>
					      	<span><input type="checkbox" value="126" name="2" class="27" id="126" onclick="selectAllstr(126)" <c:if test="${zm:checked('126',authoritys) }">checked</c:if> />添加用户</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="28" class="2" id="28" onclick="selectAllTwo(28)" <c:if test="${zm:checked('28',authoritys) }">checked</c:if> />安全管理</td>
					      <td>
					      	<span><input type="checkbox" value="127" name="2" class="28" id="127" onclick="selectAllstr(127)" <c:if test="${zm:checked('127',authoritys) }">checked</c:if> />查询</span>
					      	<span><input type="checkbox" value="128" name="2" class="28" id="128" onclick="selectAllstr(128)" <c:if test="${zm:checked('128',authoritys) }">checked</c:if> />导出</span>
					      	<span><input type="checkbox" value="129" name="2" class="28" id="129" onclick="selectAllstr(129)" <c:if test="${zm:checked('129',authoritys) }">checked</c:if> />批量导出</span>
					      	<span><input type="checkbox" value="130" name="2" class="28" id="130" onclick="selectAllstr(130)" <c:if test="${zm:checked('130',authoritys) }">checked</c:if> />数据备份</span>
					      	<span><input type="checkbox" value="131" name="2" class="28" id="131" onclick="selectAllstr(131)" <c:if test="${zm:checked('131',authoritys) }">checked</c:if> />数据恢复</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="29" class="2" id="29" onclick="selectAllTwo(29)" <c:if test="${zm:checked('29',authoritys) }">checked</c:if> />系统设置</td>
					      <td>
					      	<span><input type="checkbox" value="132" name="2" class="29" id="132" onclick="selectAllstr(132)" <c:if test="${zm:checked('132',authoritys) }">checked</c:if> />个性化设置</span>
					      	<span><input type="checkbox" value="133" name="2" class="29" id="133" onclick="selectAllstr(133)" <c:if test="${zm:checked('133',authoritys) }">checked</c:if> />修改密码</span>
					      </td>
					    </tr>
					  	<!--一级权限系统管理中心结束-->
					  	<!--档案著录  -->
					  	<tr>
					      <td  rowspan="3"><input type="checkbox" value="3" id="3" onclick="selectAll(3)" <c:if test="${zm:checked('3',authoritys) }">checked</c:if> />档案著录</td>
					      <td><input type="checkbox" value="30" class="3" id="30" onclick="selectAllTwo(30)" <c:if test="${zm:checked('30',authoritys) }">checked</c:if> />新建档案</td>
					      <td>
					      	<span><input type="checkbox" value="134" name="3" class="30" id="134" onclick="selectAllstr(134)" <c:if test="${zm:checked('134',authoritys) }">checked</c:if> />历史数据导入</span>
					      	<span><input type="checkbox" value="135" name="3" class="30" id="135" onclick="selectAllstr(135)" <c:if test="${zm:checked('135',authoritys) }">checked</c:if> />上传备考表</span>
					      	<span><input type="checkbox" value="136" name="3" class="30" id="136" onclick="selectAllstr(136)" <c:if test="${zm:checked('136',authoritys) }">checked</c:if> />批量上传文件</span>
					      	<span><input type="checkbox" value="137" name="3" class="30" id="137" onclick="selectAllstr(137)" <c:if test="${zm:checked('137',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="138" name="3" class="30" id="138" onclick="selectAllstr(138)" <c:if test="${zm:checked('138',authoritys) }">checked</c:if> />上传</span>
					      	<span><input type="checkbox" value="139" name="3" class="30" id="139" onclick="selectAllstr(139)" <c:if test="${zm:checked('139',authoritys) }">checked</c:if> />保存</span>
					      </td>
					    </tr>
					  	<tr>
					      <td><input type="checkbox" value="31" class="3" id="31" onclick="selectAllTwo(31)" <c:if test="${zm:checked('31',authoritys) }">checked</c:if> />著录列表</td>
					      <td>
					      	<span><input type="checkbox" value="140" name="3" class="31" id="140" onclick="selectAllstr(140)" <c:if test="${zm:checked('140',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="141" name="3" class="31" id="141" onclick="selectAllstr(141)" <c:if test="${zm:checked('141',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="142" name="3" class="31" id="142" onclick="selectAllstr(142)" <c:if test="${zm:checked('142',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="143" name="3" class="31" id="143" onclick="selectAllstr(143)" <c:if test="${zm:checked('143',authoritys) }">checked</c:if> />补充盒内文件</span>
					      	<span><input type="checkbox" value="144" name="3" class="31" id="144" onclick="selectAllstr(144)" <c:if test="${zm:checked('144',authoritys) }">checked</c:if> />提交进馆</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="32" class="3" id="32" onclick="selectAllTwo(32)" <c:if test="${zm:checked('32',authoritys) }">checked</c:if> />补充盒内文件</td>
					      <td>
					      	<span><input type="checkbox" value="145" name="3" class="32" id="145" onclick="selectAllstr(145)" <c:if test="${zm:checked('145',authoritys) }">checked</c:if> />上传备考表</span>
					      	<span><input type="checkbox" value="146" name="3" class="32" id="146" onclick="selectAllstr(146)" <c:if test="${zm:checked('146',authoritys) }">checked</c:if> />批量上传</span>
					      	<span><input type="checkbox" value="147" name="3" class="32" id="147" onclick="selectAllstr(147)" <c:if test="${zm:checked('147',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="148" name="3" class="32" id="148" onclick="selectAllstr(148)" <c:if test="${zm:checked('148',authoritys) }">checked</c:if> />上传文件</span>
					      	<span><input type="checkbox" value="149" name="3" class="32" id="149" onclick="selectAllstr(149)" <c:if test="${zm:checked('149',authoritys) }">checked</c:if> />保存</span>
					      </td>
					    </tr>
					    <!-- 档案著录结束 -->
					    <!-- 档案管理 -->
					    <tr>
					      <td  rowspan="5"><input type="checkbox" value="4" id="4" onclick="selectAll(4)" <c:if test="${zm:checked('4',authoritys) }">checked</c:if> />档案管理</td>
					      <td><input type="checkbox" value="33" class="4" id="33" onclick="selectAllTwo(33)" <c:if test="${zm:checked('33',authoritys) }">checked</c:if> />以盒管理</td>
					      <td>
					      	<span><input type="checkbox" value="150" name="4" class="33" id="150" onclick="selectAllstr(150)" <c:if test="${zm:checked('150',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="151" name="4" class="33" id="151" onclick="selectAllstr(151)" <c:if test="${zm:checked('151',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="152" name="4" class="33" id="152" onclick="selectAllstr(152)" <c:if test="${zm:checked('152',authoritys) }">checked</c:if> />管理明细</span>
					      	<span><input type="checkbox" value="153" name="4" class="33" id="153" onclick="selectAllstr(153)" <c:if test="${zm:checked('153',authoritys) }">checked</c:if> />保管期限变更</span>
					      	<span><input type="checkbox" value="154" name="4" class="33" id="154" onclick="selectAllstr(154)" <c:if test="${zm:checked('154',authoritys) }">checked</c:if> />密级变更</span>
					      	<span><input type="checkbox" value="155" name="4" class="33" id="155" onclick="selectAllstr(155)" <c:if test="${zm:checked('155',authoritys) }">checked</c:if> />鉴定销毁</span>
					      	<span><input type="checkbox" value="156" name="4" class="33" id="156" onclick="selectAllstr(156)" <c:if test="${zm:checked('156',authoritys) }">checked</c:if> />制作光盘</span>
					      </td>
					    </tr>
					     <tr>
					      <td><input type="checkbox" value="34" class="4" id="34" onclick="selectAllTwo(34)" <c:if test="${zm:checked('34',authoritys) }">checked</c:if> />以件管理</td>
					      <td>
					      	<span><input type="checkbox" value="157" name="4" class="34" id="157" onclick="selectAllstr(157)" <c:if test="${zm:checked('157',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="158" name="4" class="34" id="158" onclick="selectAllstr(158)" <c:if test="${zm:checked('158',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="159" name="4" class="34" id="159" onclick="selectAllstr(159)" <c:if test="${zm:checked('159',authoritys) }">checked</c:if> />管理明细</span>
					      	<span><input type="checkbox" value="160" name="4" class="34" id="160" onclick="selectAllstr(160)" <c:if test="${zm:checked('160',authoritys) }">checked</c:if> />保管期限变更</span>
					      	<span><input type="checkbox" value="161" name="4" class="34" id="161" onclick="selectAllstr(161)" <c:if test="${zm:checked('161',authoritys) }">checked</c:if> />密级变更</span>
					      	<span><input type="checkbox" value="162" name="4" class="34" id="162" onclick="selectAllstr(162)" <c:if test="${zm:checked('162',authoritys) }">checked</c:if> />鉴定销毁</span>
					      	<span><input type="checkbox" value="163" name="4" class="34" id="163" onclick="selectAllstr(163)" <c:if test="${zm:checked('163',authoritys) }">checked</c:if> />制作光盘</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="35" class="4" id="35" onclick="selectAllTwo(35)" <c:if test="${zm:checked('35',authoritys) }">checked</c:if> />历史数据</td>
					      <td>
					      	<span><input type="checkbox" value="164" name="4" class="35" id="164" onclick="selectAllstr(164)" <c:if test="${zm:checked('164',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="165" name="4" class="35" id="165" onclick="selectAllstr(165)" <c:if test="${zm:checked('165',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="166" name="4" class="35" id="166" onclick="selectAllstr(166)" <c:if test="${zm:checked('166',authoritys) }">checked</c:if> />管理明细</span>
					      	<span><input type="checkbox" value="167" name="4" class="35" id="167" onclick="selectAllstr(167)" <c:if test="${zm:checked('167',authoritys) }">checked</c:if> />保管期限变更</span>
					      	<span><input type="checkbox" value="168" name="4" class="35" id="168" onclick="selectAllstr(168)" <c:if test="${zm:checked('168',authoritys) }">checked</c:if> />密级变更</span>
					      	<span><input type="checkbox" value="169" name="4" class="35" id="169" onclick="selectAllstr(169)" <c:if test="${zm:checked('169',authoritys) }">checked</c:if> />鉴定销毁</span>
					      	<span><input type="checkbox" value="170" name="4" class="35" id="170" onclick="selectAllstr(170)" <c:if test="${zm:checked('170',authoritys) }">checked</c:if> />制作光盘</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="36" class="4" id="36" onclick="selectAllTwo(36)" <c:if test="${zm:checked('36',authoritys) }">checked</c:if> />盒审核</td>
					      <td>
					      	<span><input type="checkbox" value="171" name="4" class="36" id="171" onclick="selectAllstr(171)" <c:if test="${zm:checked('171',authoritys) }">checked</c:if> />查询</span>
					      	<span><input type="checkbox" value="172" name="4" class="36" id="172" onclick="selectAllstr(172)" <c:if test="${zm:checked('172',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="173" name="4" class="36" id="173" onclick="selectAllstr(173)" <c:if test="${zm:checked('173',authoritys) }">checked</c:if> />驳回</span>
					      	<span><input type="checkbox" value="174" name="4" class="36" id="174" onclick="selectAllstr(174)" <c:if test="${zm:checked('174',authoritys) }">checked</c:if> />通过</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="37" class="4" id="37" onclick="selectAllTwo(37)" <c:if test="${zm:checked('37',authoritys) }">checked</c:if> />件审核</td>
					      <td>
					     	<span><input type="checkbox" value="175" name="4" class="37" id="175" onclick="selectAllstr(175)" <c:if test="${zm:checked('175',authoritys) }">checked</c:if> />查询</span>
					      	<span><input type="checkbox" value="176" name="4" class="37" id="176" onclick="selectAllstr(176)" <c:if test="${zm:checked('176',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="177" name="4" class="37" id="177" onclick="selectAllstr(177)" <c:if test="${zm:checked('177',authoritys) }">checked</c:if> />驳回</span>
					      	<span><input type="checkbox" value="178" name="4" class="37" id="178" onclick="selectAllstr(178)" <c:if test="${zm:checked('178',authoritys) }">checked</c:if> />通过</span>
					      </td>
					    </tr>
					    <!--档案管理  -->
					    <!-- 档案查询 -->
					    <tr>
					      <td  rowspan="2"><input type="checkbox" value="5" id="5" onclick="selectAll(5)" <c:if test="${zm:checked('5',authoritys) }">checked</c:if> />档案查询</td>
					      <td><input type="checkbox" value="38" class="5" id="38" onclick="selectAllTwo(38)" <c:if test="${zm:checked('38',authoritys) }">checked</c:if> />新增数据查询</td>
					      <td>
					      	<span><input type="checkbox" value="179" name="5" class="38" id="179" onclick="selectAllstr(179)" <c:if test="${zm:checked('179',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="180" name="5" class="38" id="180" onclick="selectAllstr(180)" <c:if test="${zm:checked('180',authoritys) }">checked</c:if> />导出目录</span>
					      	<span><input type="checkbox" value="181" name="5" class="38" id="181" onclick="selectAllstr(181)" <c:if test="${zm:checked('181',authoritys) }">checked</c:if> />目录打印</span>
					      	<span><input type="checkbox" value="182" name="5" class="38" id="182" onclick="selectAllstr(182)" <c:if test="${zm:checked('182',authoritys) }">checked</c:if> />导出泰坦格式</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="39" class="5" id="39" onclick="selectAllTwo(39)" <c:if test="${zm:checked('39',authoritys) }">checked</c:if> />历史数据查询</td>
					      <td>
					      	<span><input type="checkbox" value="183" name="5" class="39" id="183" onclick="selectAllstr(183)" <c:if test="${zm:checked('183',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="184" name="5" class="39" id="184" onclick="selectAllstr(184)" <c:if test="${zm:checked('184',authoritys) }">checked</c:if> />导出泰坦格式</span>
					      </td>
					    </tr>
					    <!--档案查询结束  -->
					    <!-- 报表统计 -->
					    <tr>
					      <td  rowspan="4"><input type="checkbox" value="6" id="6" onclick="selectAll(6)" <c:if test="${zm:checked('6',authoritys) }">checked</c:if> />报表统计</td>
					      <td><input type="checkbox" value="40" class="6" id="40" onclick="selectAllTwo(40)" <c:if test="${zm:checked('40',authoritys) }">checked</c:if> />档案数量统计-盒统计</td>
					      <td>
					      	<span><input type="checkbox" value="185" name="6" class="40" id="185" onclick="selectAllstr(185)" <c:if test="${zm:checked('185',authoritys) }">checked</c:if> />统计图</span>
					      	<span><input type="checkbox" value="186" name="6" class="40" id="186" onclick="selectAllstr(186)" <c:if test="${zm:checked('186',authoritys) }">checked</c:if> />统计表</span>
					      	<span><input type="checkbox" value="187" name="6" class="40" id="187" onclick="selectAllstr(187)" <c:if test="${zm:checked('187',authoritys) }">checked</c:if> />下载</span>
					      	<span><input type="checkbox" value="188" name="6" class="40" id="188" onclick="selectAllstr(188)" <c:if test="${zm:checked('188',authoritys) }">checked</c:if> />打印</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="41" class="6" id="41" onclick="selectAllTwo(41)" <c:if test="${zm:checked('41',authoritys) }">checked</c:if> />档案数量统计-件统计</td>
					      <td>
					      	<span><input type="checkbox" value="189" name="6" class="41" id="189" onclick="selectAllstr(189)" <c:if test="${zm:checked('189',authoritys) }">checked</c:if> />统计图</span>
					      	<span><input type="checkbox" value="190" name="6" class="41" id="190" onclick="selectAllstr(190)" <c:if test="${zm:checked('190',authoritys) }">checked</c:if> />统计表</span>
					      	<span><input type="checkbox" value="191" name="6" class="41" id="191" onclick="selectAllstr(191)" <c:if test="${zm:checked('191',authoritys) }">checked</c:if> />下载</span>
					      	<span><input type="checkbox" value="192" name="6" class="41" id="192" onclick="selectAllstr(192)" <c:if test="${zm:checked('192',authoritys) }">checked</c:if> />打印</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="42" class="6" id="42" onclick="selectAllTwo(42)" <c:if test="${zm:checked('42',authoritys) }">checked</c:if> />档案借阅统计</td>
					      <td>
					      	<span><input type="checkbox" value="193" name="6" class="42" id="193" onclick="selectAllstr(193)" <c:if test="${zm:checked('193',authoritys) }">checked</c:if> />统计图</span>
					      	<span><input type="checkbox" value="194" name="6" class="42" id="194" onclick="selectAllstr(194)" <c:if test="${zm:checked('194',authoritys) }">checked</c:if> />统计表</span>
					      	<span><input type="checkbox" value="195" name="6" class="42" id="195" onclick="selectAllstr(195)" <c:if test="${zm:checked('195',authoritys) }">checked</c:if> />下载</span>
					      	<span><input type="checkbox" value="196" name="6" class="42" id="196" onclick="selectAllstr(196)" <c:if test="${zm:checked('196',authoritys) }">checked</c:if> />打印</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="43" class="6" id="43" onclick="selectAllTwo(43)" <c:if test="${zm:checked('43',authoritys) }">checked</c:if> />档案整理质量统计</td>
					      <td>
					      	<span><input type="checkbox" value="197" name="6" class="43" id="197" onclick="selectAllstr(197)" <c:if test="${zm:checked('197',authoritys) }">checked</c:if> />统计图</span>
					      	<span><input type="checkbox" value="198" name="6" class="43" id="198" onclick="selectAllstr(198)" <c:if test="${zm:checked('198',authoritys) }">checked</c:if> />统计表</span>
					      	<span><input type="checkbox" value="199" name="6" class="43" id="199" onclick="selectAllstr(199)" <c:if test="${zm:checked('199',authoritys) }">checked</c:if> />下载</span>
					      	<span><input type="checkbox" value="200" name="6" class="43" id="200" onclick="selectAllstr(200)" <c:if test="${zm:checked('200',authoritys) }">checked</c:if> />打印</span>
					      </td>
					    </tr>
					    <!-- 报表统计结束 -->
					    <!-- 档案借阅 -->
					    <tr>
					      <td  rowspan="2"><input type="checkbox" value="7" id="7" onclick="selectAll(7)" <c:if test="${zm:checked('7',authoritys) }">checked</c:if> />档案借阅</td>
					      <td><input type="checkbox" value="44" class="7" id="44" onclick="selectAllTwo(44)" <c:if test="${zm:checked('44',authoritys) }">checked</c:if> />档案借阅</td>
					      <td>
					      	<span><input type="checkbox" value="201" name="7" class="44" id="201" onclick="selectAllstr(201)" <c:if test="${zm:checked('201',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="202" name="7" class="44" id="202" onclick="selectAllstr(202)" <c:if test="${zm:checked('202',authoritys) }">checked</c:if> />申请借阅</span>
					      	<span><input type="checkbox" value="203" name="7" class="44" id="203" onclick="selectAllstr(203)" <c:if test="${zm:checked('203',authoritys) }">checked</c:if> />借阅明细</span>
					      	<span><input type="checkbox" value="204" name="7" class="44" id="204" onclick="selectAllstr(204)" <c:if test="${zm:checked('204',authoritys) }">checked</c:if> />归还</span>
					      	<span><input type="checkbox" value="205" name="7" class="44" id="205" onclick="selectAllstr(205)" <c:if test="${zm:checked('205',authoritys) }">checked</c:if> />续借</span>
					      </td>
					    </tr>
					     <tr>
					      <td><input type="checkbox" value="45" class="7" id="45" onclick="selectAllTwo(45)" <c:if test="${zm:checked('45',authoritys) }">checked</c:if> />借阅审批</td>
					      <td>
					      	<span><input type="checkbox" value="206" name="7" class="45" id="206" onclick="selectAllstr(206)" <c:if test="${zm:checked('206',authoritys) }">checked</c:if> />借阅明细</span>
					      	<span><input type="checkbox" value="207" name="7" class="45" id="207" onclick="selectAllstr(207)" <c:if test="${zm:checked('207',authoritys) }">checked</c:if> />通过</span>
					      	<span><input type="checkbox" value="208" name="7" class="45" id="208" onclick="selectAllstr(208)" <c:if test="${zm:checked('208',authoritys) }">checked</c:if> />拒绝</span>
					      	<span><input type="checkbox" value="209" name="7" class="45" id="209" onclick="selectAllstr(209)" <c:if test="${zm:checked('209',authoritys) }">checked</c:if> />批量通过</span>
					      	<span><input type="checkbox" value="210" name="7" class="45" id="210" onclick="selectAllstr(210)" <c:if test="${zm:checked('210',authoritys) }">checked</c:if> />批量拒绝</span>
					      </td>
					    </tr>
					    <!-- 档案借阅结束 -->
					    <!--库房管理  -->
					    <tr>
					      <td  rowspan="2"><input type="checkbox" value="8" id="8" onclick="selectAll(8)" <c:if test="${zm:checked('8',authoritys) }">checked</c:if> />库房管理</td>
					      <td><input type="checkbox" value="46" class="8" id="46" onclick="selectAllTwo(46)" <c:if test="${zm:checked('46',authoritys) }">checked</c:if> />库房建设</td>
					      <td>
					      	<span><input type="checkbox" value="211" name="8" class="46" id="211" onclick="selectAllstr(211)" <c:if test="${zm:checked('211',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="212" name="8" class="46" id="212" onclick="selectAllstr(212)" <c:if test="${zm:checked('212',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="213" name="8" class="46" id="213" onclick="selectAllstr(213)" <c:if test="${zm:checked('213',authoritys) }">checked</c:if> />编辑</span>
					      	<span><input type="checkbox" value="214" name="8" class="46" id="214" onclick="selectAllstr(214)" <c:if test="${zm:checked('214',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="215" name="8" class="46" id="215" onclick="selectAllstr(215)" <c:if test="${zm:checked('215',authoritys) }">checked</c:if> />新建库房</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="47" class="8" id="47" onclick="selectAllTwo(47)" <c:if test="${zm:checked('47',authoritys) }">checked</c:if> />档案入库</td>
					      <td>
					      	<span><input type="checkbox" value="216" name="8" class="47" id="216" onclick="selectAllstr(216)" <c:if test="${zm:checked('216',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="217" name="8" class="47" id="217" onclick="selectAllstr(217)" <c:if test="${zm:checked('217',authoritys) }">checked</c:if> />编辑</span>
					      	<span><input type="checkbox" value="218" name="8" class="47" id="218" onclick="selectAllstr(218)" <c:if test="${zm:checked('218',authoritys) }">checked</c:if> />入库</span>
					      </td>
					    </tr>
					    <!--库房管理结束  -->
					     <!--监测预警  -->
					    <tr>
					      <td  rowspan="2"><input type="checkbox" value="9" id="9" onclick="selectAll(9)" <c:if test="${zm:checked('9',authoritys) }">checked</c:if> />监测预警</td>
					      <td><input type="checkbox" value="48" class="9" id="48" onclick="selectAllTwo(48)" <c:if test="${zm:checked('48',authoritys) }">checked</c:if> />到期档案</td>
					      <td>
					      	<span><input type="checkbox" value="219" name="9" class="48" id="219" onclick="selectAllstr(219)" <c:if test="${zm:checked('219',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="220" name="9" class="48" id="220" onclick="selectAllstr(220)" <c:if test="${zm:checked('220',authoritys) }">checked</c:if> />保管期限变更</span>
					      	<span><input type="checkbox" value="221" name="9" class="48" id="221" onclick="selectAllstr(221)" <c:if test="${zm:checked('221',authoritys) }">checked</c:if> />鉴定销毁</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="49" class="9" id="49" onclick="selectAllTwo(49)" <c:if test="${zm:checked('49',authoritys) }">checked</c:if> />未归还档案</td>
					      <td>
					      	<span><input type="checkbox" value="222" name="9" class="49" id="222" onclick="selectAllstr(222)" <c:if test="${zm:checked('222',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="223" name="9" class="49" id="223" onclick="selectAllstr(223)" <c:if test="${zm:checked('223',authoritys) }">checked</c:if> />催还</span>
					      </td>
					    </tr>
					    <!--监测预警结束  -->
					     <!--盘点管理  -->
					    <tr>
					      <td  rowspan="2"><input type="checkbox" value="10" id="10" onclick="selectAll(10)" <c:if test="${zm:checked('10',authoritys) }">checked</c:if> />盘点管理</td>
					      <td><input type="checkbox" value="50" class="10" id="50" onclick="selectAllTwo(50)" <c:if test="${zm:checked('50',authoritys) }">checked</c:if> />盘点计划</td>
					      <td>
					      	<span><input type="checkbox" value="224" name="10" class="50" id="224" onclick="selectAllstr(224)" <c:if test="${zm:checked('224',authoritys) }">checked</c:if> />加入计划</span>
					      	<span><input type="checkbox" value="225" name="10" class="50" id="225" onclick="selectAllstr(225)" <c:if test="${zm:checked('225',authoritys) }">checked</c:if> />提交计划</span>
					      	<span><input type="checkbox" value="226" name="10" class="50" id="226" onclick="selectAllstr(226)" <c:if test="${zm:checked('226',authoritys) }">checked</c:if> />删除</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="51" class="10" id="51" onclick="selectAllTwo(51)" <c:if test="${zm:checked('51',authoritys) }">checked</c:if> />计划列表</td>
					      <td>
					      	<span><input type="checkbox" value="227" name="10" class="51" id="227" onclick="selectAllstr(227)" <c:if test="${zm:checked('227',authoritys) }">checked</c:if> />查询</span>
					      	<span><input type="checkbox" value="228" name="10" class="51" id="228" onclick="selectAllstr(228)" <c:if test="${zm:checked('228',authoritys) }">checked</c:if> />详情</span>
					      	<span><input type="checkbox" value="229" name="10" class="51" id="229" onclick="selectAllstr(229)" <c:if test="${zm:checked('229',authoritys) }">checked</c:if> />上传</span>
					      	<span><input type="checkbox" value="230" name="10" class="51" id="230" onclick="selectAllstr(230)" <c:if test="${zm:checked('230',authoritys) }">checked</c:if> />下载</span>
					      </td>
					    </tr>
					    <!--盘点管理结束  -->
					     <!--档案编研  -->
					    <tr>
					      <td  rowspan="2"><input type="checkbox" value="11" id="11" onclick="selectAll(11)" <c:if test="${zm:checked('11',authoritys) }">checked</c:if> />档案编研</td>
					      <td><input type="checkbox" value="52" class="11" id="52" onclick="selectAllTwo(52)" <c:if test="${zm:checked('52',authoritys) }">checked</c:if> />编研成果</td>
					      <td>
					      	<span><input type="checkbox" value="231" name="11" class="52" id="231" onclick="selectAllstr(231)" <c:if test="${zm:checked('231',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="232" name="11" class="52" id="232" onclick="selectAllstr(232)" <c:if test="${zm:checked('232',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="233" name="11" class="52" id="233" onclick="selectAllstr(233)" <c:if test="${zm:checked('233',authoritys) }">checked</c:if> />编辑</span>
					      	<span><input type="checkbox" value="234" name="11" class="52" id="234" onclick="selectAllstr(234)" <c:if test="${zm:checked('234',authoritys) }">checked</c:if> />删除</span>
					      	<span><input type="checkbox" value="235" name="11" class="52" id="235" onclick="selectAllstr(235)" <c:if test="${zm:checked('235',authoritys) }">checked</c:if> />下载</span>
					      	<span><input type="checkbox" value="236" name="11" class="52" id="236" onclick="selectAllstr(236)" <c:if test="${zm:checked('236',authoritys) }">checked</c:if> />打印</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="53" class="11" id="53" onclick="selectAllTwo(53)" <c:if test="${zm:checked('53',authoritys) }">checked</c:if> />加工编辑</td>
					      <td>
					      	<span><input type="checkbox" value="237" name="11" class="53" id="237" onclick="selectAllstr(237)" <c:if test="${zm:checked('237',authoritys) }">checked</c:if> />关键字搜索</span>
					      	<span><input type="checkbox" value="238" name="11" class="53" id="238" onclick="selectAllstr(238)" <c:if test="${zm:checked('238',authoritys) }">checked</c:if> />完成</span>
					      </td>
					    </tr>
					    <!--档案编研结束  -->
					      <!--数字档案馆  -->
					    <tr>
					      <td  rowspan="5"><input type="checkbox" value="12" id="12" onclick="selectAll(12)" <c:if test="${zm:checked('12',authoritys) }">checked</c:if> />数字档案馆</td>
					      <td><input type="checkbox" value="54" class="12" id="54" onclick="selectAllTwo(54)" <c:if test="${zm:checked('54',authoritys) }">checked</c:if> />电子文件中心</td>
					      <td>
					      	<span><input type="checkbox" value="239" name="12" class="54" id="239" onclick="selectAllstr(239)" <c:if test="${zm:checked('239',authoritys) }">checked</c:if> />接收文件</span>
					      	<span><input type="checkbox" value="240" name="12" class="54" id="240" onclick="selectAllstr(240)" <c:if test="${zm:checked('240',authoritys) }">checked</c:if> />导入文件</span>
					      	<span><input type="checkbox" value="241" name="12" class="54" id="241" onclick="selectAllstr(241)" <c:if test="${zm:checked('241',authoritys) }">checked</c:if> />查询</span>
					      	<span><input type="checkbox" value="242" name="12" class="54" id="242" onclick="selectAllstr(242)" <c:if test="${zm:checked('242',authoritys) }">checked</c:if> />查看 </span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="55" class="12" id="55" onclick="selectAllTwo(55)" <c:if test="${zm:checked('55',authoritys) }">checked</c:if> />交流中心</td>
					      <td>
					      	<span><input type="checkbox" value="243" name="12" class="55" id="243" onclick="selectAllstr(243)" <c:if test="${zm:checked('243',authoritys) }">checked</c:if> />咨询/建议</span>
					      	<span><input type="checkbox" value="244" name="12" class="55" id="244" onclick="selectAllstr(244)" <c:if test="${zm:checked('244',authoritys) }">checked</c:if> />关键字查询</span>
					      	<span><input type="checkbox" value="245" name="12" class="55" id="245" onclick="selectAllstr(245)" <c:if test="${zm:checked('245',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="246" name="12" class="55" id="246" onclick="selectAllstr(246)" <c:if test="${zm:checked('246',authoritys) }">checked</c:if> />回复</span>
					      </td>
					    </tr>
					     <tr>
					      <td><input type="checkbox" value="56" class="12" id="56" onclick="selectAllTwo(56)" <c:if test="${zm:checked('56',authoritys) }">checked</c:if> />电子阅览室</td>
					      <td>
					      	<span><input type="checkbox" value="247" name="12" class="56" id="247" onclick="selectAllstr(247)" <c:if test="${zm:checked('247',authoritys) }">checked</c:if> />文字查询</span>
					      	<span><input type="checkbox" value="248" name="12" class="56" id="248" onclick="selectAllstr(248)" <c:if test="${zm:checked('248',authoritys) }">checked</c:if> />文件查看</span>
					      	<span><input type="checkbox" value="249" name="12" class="56" id="249" onclick="selectAllstr(249)" <c:if test="${zm:checked('249',authoritys) }">checked</c:if> />缩略图查看</span>
					      </td>
					    </tr>
					     <tr>
					      <td><input type="checkbox" value="57" class="12" id="57" onclick="selectAllTwo(57)" <c:if test="${zm:checked('57',authoritys) }">checked</c:if> />档案信息门户</td>
					      <td>
					      	<span><input type="checkbox" value="250" name="12" class="57" id="250" onclick="selectAllstr(250)" <c:if test="${zm:checked('250',authoritys) }">checked</c:if> />查询</span>
					      	<span><input type="checkbox" value="251" name="12" class="57" id="251" onclick="selectAllstr(251)" <c:if test="${zm:checked('251',authoritys) }">checked</c:if> />查看</span>
					      	<span><input type="checkbox" value="252" name="12" class="57" id="252" onclick="selectAllstr(252)" <c:if test="${zm:checked('252',authoritys) }">checked</c:if> />信息发布</span>
					      </td>
					    </tr>
					    <tr>
					      <td><input type="checkbox" value="58" class="12" id="58" onclick="selectAllTwo(58)" <c:if test="${zm:checked('58',authoritys) }">checked</c:if> />信息发布</td>
					      <td>
					      	<span><input type="checkbox" value="253" name="12" class="58" id="253" onclick="selectAllstr(253)" <c:if test="${zm:checked('253',authoritys) }">checked</c:if> />图片轮播发布</span>
					      	<span><input type="checkbox" value="254" name="12" class="58" id="254" onclick="selectAllstr(254)" <c:if test="${zm:checked('254',authoritys) }">checked</c:if> />信息公式发布</span>
					      </td>
					    </tr>
					    <!-- 数字档案馆结束 -->
					  </tbody>
					</table>
				</div>
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<!--[if IE 6]>
		<script type="text/javascript" src="../js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script type="text/javascript">
		
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
		
		function selectAll(s) {//一级权限
			var one = document.getElementById(s);//获取id为s的元素
			var two = document.getElementsByClassName(s);//获取calss为s的元素集合
			var three=document.getElementsByName(s);//获取name为s的元素集合
			for(var i = 0; i < two.length; i++) {//二级权限元素
				if(two[i].type == 'checkbox') {
					two[i].checked = one.checked;//属相相等
				}
			}
			for(var i=0;i<three.length;i++){//三级权限元素
				if(three[i].type=="checkbox"){
					three[i].checked = one.checked;//属相相等
				}
			}
		}
		function selectAllTwo(a) {//二级权限
			var two=document.getElementById(a);//获取id为a的二级权限
			var one=document.getElementById(two.className);//获取id为a的二级权限对应的class元素
			var three=document.getElementsByClassName(a);//获取三级权限元素
			if(two.checked){//二级权限选中
				one.checked=two.checked;
			}else{
				var twoAll=document.getElementsByClassName(one.value);//获取一级权限下对应的所有二级权限
				for(var i=0;i<twoAll.length;i++){
					if(twoAll[i].checked){//二级存在选中
						one.checked=twoAll[i].checked;
						break;
					}else{
						one.checked=two.checked;
					}
				}
			}
			for(var i=0;i<three.length;i++){
				if(three[i].type=="checkbox"){
					three[i].checked = two.checked;
				}
			}
		}
		function selectAllstr(b) {//三级权限
			var three=document.getElementById(b);//获取id为b的三级权限
		  	var two=document.getElementById(three.className);//获取三级权限对应的二级权限元素
		  	var one=document.getElementById(three.name);//获取三级权限对应的一级权限元素
		  	if(three.checked){//三级权限被选中相应的一级和二级权限被选中
		  		two.checked=three.checked;
		  		one.checked=three.checked;
		  	}else{//没被选中
		  		var threeAll=document.getElementsByClassName(two.value);//获取相同二级权限所有的三级权限
		  		for(var i=0;i<threeAll.length;i++){
		  			if(threeAll[i].checked){//二级权限存在选中
		  				two.checked=threeAll[i].checked;
		  				one.checked=threeAll[i].checked;
		  				break;
		  			}else{//不存在选中
		  				two.checked=three.checked;//相应的二级权限不被选中
		  				var allThree=document.getElementsByName(one.value);//获取相同一级权限下所有二级权限
		  				for(var j=0;j<allThree.length;j++){
		  					if(allThree[j].checked){//二级权限存在选中
		  						one.checked=allThree[j].checked;//一级权限被选中
		  						break;
		  					}else{
		  						two.checked=three.checked;
		  						one.checked=three.checked;
		  					}
		  				}
		  			}
		  		}
		  	}
		}
		
		//权限无效、生效
		$().ready(function(){
			//权限失效
			$("#noPermit").bind("click",function(){
				$("input[type='checkbox']:checked").each(function(){
					$(this).prop({checked:false});
				});
					var roleId=$("input[name='roleId']").val();
					$.ajax({
						url:"${pageContext.request.contextPath}/roleManagement/deleteAuthority",
						type:"POST",
						data:"roleId="+roleId,
						dataType:"json",
						success:function(data){
							if(data>0){
								layer.msg("权限已失效!");
							}else{
								layer.msg("该角色没有权限,请赋予权限!");
							}
						}
					});
			});
			
			$("#permit").bind("click",function(){//保存权限
				//获取所有的被选中的checkbox的值
				var id_array = new Array();
				$("input[type='checkbox']:checked").each(function(){
					if($(this).prop("checked")){
						id_array.push($(this).val());
					}
				});
				if(!id_array.length){
					layer.msg("请勾选权限!");
				}else{
					var idstr = id_array.join(',');//将数组元素连接起来以构建一个字符串  
					var roleId=$("input[name='roleId']").val();
					var jsonObj={"roleId":roleId,"permissionId":idstr};
					$.ajax({
						url:"${pageContext.request.contextPath}/roleManagement/grantAuthority",
						type:"post",
						data:JSON.stringify(jsonObj),
						contentType:"application/json;chartset:utf-8",
						dataType:"json",
						success:function(data){
							if(data==true){
								layer.msg("权限已生效!");
							}else{
								layer.msg("权限生效失败!");
							}
							console.log(data)
						}
					});
				}
			});
			$("#seleAll").click(function(){
				var x=$("#seleAll").text();
				var list=$("input[type='checkbox']");
				if(x=='全选'){
					$("#seleAll").text("反选")
					for(var i=0;i<list.length;i++){
						list[i].checked=true;
					}
				}else{
					$("#seleAll").text("全选")
					for(var i=0;i<list.length;i++){
						list[i].checked=false;
					}
				}
				
			})
		});
	</script>
	</body>

</html>