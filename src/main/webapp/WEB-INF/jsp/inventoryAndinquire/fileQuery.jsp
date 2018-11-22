<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<% String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort(); %>
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
		<title>档案查询_以盒或以件查询</title>
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
			/*表格隐藏*/
			
			/* [lay-filter='LAY-table-2'] {
				display: none;
			}
			 */
			 #d2 {
				display: none;
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
			#na1>div,#na2>div{
			    padding-bottom: 15px;
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
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
						<c:if test="${zm:buttenPremission('ea',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
							 	<a href="${pageContext.request.contextPath}/fileQuery/goToFileQueryBoxList">新增数据查询</a>
							</li>
							<span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('eb',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
							 	<a href="${pageContext.request.contextPath}/fileQuery/goToHistoryDataList">历史数据查询</a>
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
									<div class="layui-form">
										<div class="layui-row layui-col-space10 layui-form-item">
										  <div id="na1">
											<div class="layui-col-lg3">
												<label class="layui-form-label">全宗号：</label>
												<div class="layui-input-block">
													<input type="text" name="quanzongNumber" id="quanzongNumber" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">全宗名称：</label>
												<div class="layui-input-block">
													<input type="text" name="quanzongName" id="quanzongName" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">档案类型：</label>
												<div class="layui-input-block">
													<select name="pcId" lay-filter="pcId" id="pcId">
														<option value="">请选择</option>
														<c:forEach items="${pcList}" var="primary">
															<option value="${primary.pcId}">${primary.pcName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">机构问题：</label>
												<div class="layui-input-block">
													<select name="scId" lay-filter="scId" id="scId">
														<option value="" id="towfl">请选择</option>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">年度：</label>
												<div class="layui-input-block">
													<input type="text" name="boxanual" id="boxanual" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">保管期限：</label>
												<div class="layui-input-block">
													<select name="retentionperiodId" lay-filter="" id="retention">
														<option value="">请选择</option>
														<c:forEach items="${retentionperiodName}" var="rn">
															<option value="${rn.retentionperiodid}">${rn.retentionperiodname}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">盒号：</label>
												<div class="layui-input-block">
													<input type="text" name="boxNumber" id="boxNumber" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">架位号：</label>
												<div class="layui-input-block">
													<input type="text" name="storageRacknumber" id="storageRacknumber" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">关键词：</label>
												<div class="layui-input-block">
													<input type="text" name="condition" id="condition" placeholder="请输入关键词" autocomplete="off" class="layui-input">
												</div>
											</div>
										</div>
										
									 <!-- 以件查询===按条件 -->
										<div style="display:none" id="na2">
											<div class="layui-col-lg3">
												<label class="layui-form-label">全宗号：</label>
												<div class="layui-input-block">
													<input type="text" name="quanzongNumber" id="quanzongNumber2" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">全宗名称：</label>
												<div class="layui-input-block">
													<input type="text" name="quanzongName" id="quanzongName2" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">档案类型：</label>
												<div class="layui-input-block">
													<select name="pcId" lay-filter="pcId2" id="pcId2">
														<option value="">请选择</option>
														<c:forEach items="${pcList}" var="primary">
															<option value="${primary.pcId}">${primary.pcName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">机构问题：</label>
												<div class="layui-input-block">
													<select name="scId" lay-filter="scId2" id="scId2">
														<option value="" id="towfl2">请选择</option>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">年度：</label>
												<div class="layui-input-block">
													<input type="text" name="archiveFileAnual" id="archiveFileAnual" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">保管期限：</label>
												<div class="layui-input-block">
													<select name="retentionperiodid" lay-filter="" id="retention2">
														<option value="">请选择</option>
													</select>
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">档号：</label>
												<div class="layui-input-block">
													<input type="text" name="archiveFileFileNumber" id="archiveFileFileNumber" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">盒号：</label>
												<div class="layui-input-block">
													<input type="text" name="boxnumber" id="boxnumber2" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">日期：</label>
												<div class="layui-input-block">
													<input type="text" name="archiveFileCreatetime" id="archiveFileCreatetime" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">架位号：</label>
												<div class="layui-input-block">
													<input type="text" name="storageRacknumber" id="storageRacknumber2" placeholder="" autocomplete="off" class="layui-input">
												</div>
											</div>
											<div class="layui-col-lg3">
												<label class="layui-form-label">关键词：</label>
												<div class="layui-input-block">
													<input type="text" name="condition" id="condition2" placeholder="请输入关键词" autocomplete="off" class="layui-input">
												</div>
											</div>
										</div>
											<div class="layui-col-lg3" style="text-align: center;float: right;" id="lgg3">
												<input type="radio" name="radio" value="box" title="查询盒" checked>
												<input type="radio" name="radio" value="list" title="查询件">
												<c:if test="${zm:buttenPremission('eaa',sessionScope.user.role.authorities) }">
												<button class="layui-btn layui-btn-normal" data-type="" id="queryFile">查询</button>
												</c:if>
											</div>
										</div>
									</div>
									<div id="d1">
									    <table class="layui-table" lay-filter="demo" id="demo"></table>
										<div style="margin: 18px 0;" class="layui-btn-group demoTable">
											<span style="margin:0 15px;">档案合计：<b id="countbox"></b>盒</span>
											<span style="padding: 0 15px;"><b id="countFileNum"></b>件</span>
											<c:if test="${zm:buttenPremission('eab',sessionScope.user.role.authorities) }">
											<button class="layui-btn" id="exportDir"  data-type="getCheckData">导出目录</button>
											</c:if>
											<c:if test="${zm:buttenPremission('eac',sessionScope.user.role.authorities) }">
											<button class="layui-btn layui-btn-danger" id="printDir">目录打印</button>
											</c:if>
										</div>
									</div>
									<div id="d2">
										<table class="layui-table" lay-filter="demo2" id="demo2"></table>
										<div style="margin: 18px 0;" id="demolist2">
											<span style="margin:0 15px;">档案合计：<b id="fileNumber"></b>件</span>
											<span style="padding: 0 15px;"><b id="filePages"></b>页</span>
											 <button class="layui-btn" id="expectTT" data-type="expectTT">导出泰坦文件</button> 
										</div>
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
			<div id="createExcel" style="text-align:center;margin:0 auto;height:1000px;width:1000px;">
					<iframe src="" id="printIframe"></iframe>
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
		<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
         </script>
		<script>
		//重复判断
		function isRepeat(datas) {
		    var hash = {};
		    for (var i in datas) {
		        if (hash[datas[i]]){
		            return true; 
		        }
		        hash[datas[i]] = true;
		    }
		    return false;
		}

		var boxNum=${boxNum};
		var boxFileCasesNumber=${boxFileCasesNumber};
		$("#countbox").html(boxNum);
		$("#countFileNum").html(boxFileCasesNumber);
			//导出目录
			$(function() {
				layui.use('table', function(){
					  var table = layui.table;
					  //监听表格复选框选择
					  table.on('checkbox(demo)', function(obj){
					    console.log(obj)
					  });
					  var $ = layui.$, active = {
							    getCheckData: function(){ //获取选中数据
							      var checkStatus = table.checkStatus('demo')
							      ,data = checkStatus.data;
							      var datas = [];
							      for (var i = 0; i < data.length; i++) {
							    	  datas.push(data[i].boxNumber);
								  }
							      if(isRepeat(datas) == true){
							    	  layer.msg("您选择的数据盒号存在重复，建议将单个导入");
							      }else{
							    	  exportDirclick();
							      }
						 	}
					  }
					  $('.demoTable .layui-btn').on('click', function(){
						    var type = $(this).data('type');
						    active[type] ? active[type].call(this) : '';
					  }); 
				});
				var exportDirclick =  function(){
					/* $("#exportDir").click(function() {
					}); */
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
								window.location.href="${pageContext.request.contextPath}/fileQuery/exportDirectory?boxIdList="+boxIdList;
							}else{
								layer.msg("请勾选盒列表信息!")
							}
						});
					
				}
				
			})
			
			//打印目录
			$(function() {
				$("#printDir").click(function() {
				 	layui.use('table', function() {
						var table = layui.table;
						var checkStatus = table.checkStatus('demo')
						,data = checkStatus.data;
						var x=JSON.stringify(data);
						var y=JSON.parse(x);
						if(y.length>0){
							if(y.length>1){
								layer.msg("只能打印一个盒目录!");
							}else{
								var boxId = null;
								for(var i=0;i<y.length;i++){
									boxId=y[i].boxId;
									$.ajax({
										url:"${pageContext.request.contextPath}/fileQuery/printBoxattachmentFile"+"?timestamp="+Math.random(),
										data:"boxId="+boxId,
										type:"post",
										beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
										success:function(data){
											console.log("<%=url%>"+data.data);
											$("#printIframe").attr("src","<%=url%>"+data.data);
										}
									})
								}
							}
						}else{
							layer.msg("请勾选盒列表信息!")
						}
					});
				});
			})
			//js下载
			function DownURL(strRemoteURL, strLocalURL){
		        try{
		            var xmlHTTP = new ActiveXObject("Microsoft.XMLHTTP");
		            xmlHTTP.open("Get", strRemoteURL, false);
		            xmlHTTP.send();
		            var adodbStream = new ActiveXObject("ADODB.Stream");
		            adodbStream.Type = 1;//1=adTypeBinary 
		            adodbStream.Open();
		            adodbStream.write(xmlHTTP.responseBody);
		            adodbStream.SaveToFile(strLocalURL, 2);
		            adodbStream.Close();
		            adodbStream = null;
		            xmlHTTP = null;
		        }
		        catch (e){
		            window.confirm("下载URL出错!");
		        }
		        //window.confirm("下载完成."); 
		    }
			//一级分类级联二级分类
			layui.use('form', function() {
				var form = layui.form;
				var $ = layui.$;
				form.on('select(pcId)', function(data){
					var pcId = data.value;
			  		$.ajax({
			  			url:"${pageContext.request.contextPath}/cascading/selectSecondaryMenu"+"?timestamp="+Math.random(),
			  			async:false,
			  			data:{"pcId":pcId},
			  			beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
			  			success:function(data){
			  			    var list=data.length;
			  			  	$("#towfl").nextAll().remove();
			  				for (var i = 0; i < list; i++) {
			  					$("#towfl").after("<option value="+data[i].scId+">"+data[i].scName+"</option>'");
			  				}
			  				layui.use('form', function() {
			  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  			        form.render();
			  			    }); 
			  			}
			  		});
			  	})
			});
			
			//一级分类级联二级分类
			layui.use('form', function() {
				var form = layui.form;
				var $ = layui.$;
				form.on('select(pcId2)', function(data){
					var pcId = data.value;
			  		$.ajax({
			  			url:"${pageContext.request.contextPath}/cascading/selectSecondaryMenu"+"?timestamp="+Math.random(),
			  			async:false,
			  			data:{"pcId":pcId},
			  			type:"post",
			  			beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
			  			success:function(data){
			  			    var list=data.length;
			  			  	$("#towfl2").nextAll().remove();
			  				for (var i = 0; i < list; i++) {
			  					$("#towfl2").after("<option value="+data[i].scId+">"+data[i].scName+"</option>'");
			  				}
			  				layui.use('form', function() {
			  			        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  			        form.render();
			  			    }); 
			  			}
			  		});
			  	})
			});
			
			
		
			layui.use('form', function() {
				var form = layui.form;
				var $ = layui.$;
				form.on('radio', function(data) {
					if(data.value == 'box') {
						$("#d1").css('display', 'block');
						$("#d2").css('display', 'none');
						$("#na1").css('display', 'block');
						$("#na2").css('display', 'none');
					}
					if(data.value == 'list') {
						$("#d1").css('display', 'none');
						$("#d2").css('display', 'block');
						$("#na2").css('display', 'block');
						$("#na1").css('display', 'none');
						var optionNo=document.all["retention2"].options.length;
						if(optionNo==1){
							basicDataRendering();
						}else{
							return;
						}
					}

				});
				
			//以件查询基础数据渲染
			function basicDataRendering(){
				$.ajax({
					url:"${pageContext.request.contextPath}/fileQuery/basicDataRendering?timestamp="+Math.random(),
					dataType:"json",
					beforeSend :function(xmlHttp){ 
				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
				     },
					success:function(data){
						$("#fileNumber").text(data.fileNumber);
						$("#filePages").text(data.filePages);
						var retention = data.retention;
						var root=document.getElementById("retention2");
						for (var i = 0; i < retention.length; i++) {
							var option = document.createElement("option");
							option.setAttribute("value",retention[i].retentionperiodid);
							option.innerText=retention[i].retentionperiodname;
							root.appendChild(option);
							form.render('select');
						}
					}
				});
			}	
				
			//各种基于事件的操作，下面会有进一步介绍
			});
			layui.use('table', function() {
				var table = layui.table;
				//展示已知数据
				table.render({
					elem: '#demo',
					url:"/filemanage/fileQuery/queryBoxList"+"?timestamp="+Math.random(),
					method:'post',
					cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
					cols: [
						[ //标题栏
							{
								type: 'checkbox',
								fixed: 'left',
							},
							{
								type: 'numbers',
								title: '序号',
								width: 100,
								unresize: 'false',
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
								field: 'retentionPeriodName',
								title: '保管期限',
								unresize: 'false',
							},
							{
								field: 'boxStartNumber',
								title: '起件号',
								unresize: 'false',
							},
							{
								field: 'boxEndNumber',
								title: '止件号',
								unresize: 'false',
							},
							{
								field: 'boxNumber',
								title: '盒号',
								unresize: 'false',
							},
							{
								field: 'boxthickness',
								title: '盒属性',
								unresize: 'false',
							},
							{
								field: 'storageRacknumber',
								title: '架位号',
								unresize: 'false',
							},
						]
					],
					/*skin: 'nob' //表格风格
						,*/
					even: false,
					page: true //是否显示分页
					,limits: [10, 20, 30,40,50]
						,
					limit: 10 //每页默认显示的数量
					
				});
				
				table.render({
					elem: '#demo2',
					url:"/filemanage/fileQuery/queryFileList"+"?timestamp="+Math.random(),
					method:'post',
					cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
					cols: [
						[ //标题栏
							{
								type: 'checkbox',
								fixed: 'left',
							},
							{
								type: 'numbers',
								title: '序号',
								unresize: 'false',
								sort: true,
								templet: '#indexTpl',
							},
							{
								field: 'archiveFileFileNumber',
								title: '档号',
								unresize: 'false',
							}, {
								field: 'archiveFileReferenceNumber',
								title: '文号',
								unresize: 'false',
							}, {
								field: 'archiveFileResponsible',
								title: '责任者',
								unresize: 'false',
							},
							{
								field: 'archiveFileTitle',
								title: '题名',
								unresize: 'false',
							},
							{
								field: 'archiveFileCreatetime',
								title: '日期',
								unresize: 'false',
							},
							{
								field: 'afSecurityClassrification',
								title: '密级',
								unresize: 'false',
							},
							{
								field: 'archiveFilePages',
								title: '页数',
								unresize: 'false',
							},
							{
								field: 'archiveFileRemark',
								title: '备注',
								unresize: 'false',
							},
							{
								field: 'boxnumber',
								title: '盒号',
								unresize: 'false',
							},
							{
								field: 'storageRacknumber',
								title: '架位号',
								unresize: 'false',
							},
						]
					],
					
					/*skin: 'nob' //表格风格
						,*/
					even: false,
					page: true //是否显示分页
					,limits: [10, 20, 30,40,50]
						,
					limit: 10 //每页默认显示的数量
				});
				
				
				//导出泰坦格式
				 var $ = layui.$, active ={
					expectTT:function(){
						var checkStatus = table.checkStatus('demo2');
						var num=checkStatus.data.length;
						var list=checkStatus.data;
						if(num>0){
							var ids="";
							for(var i=0;i<list.length;i++){
								ids+=list[i].archiveFileId+","
							}
							window.location.href="${pageContext.request.contextPath}/expectHistory/expectHistory?ids="+ids+"&remark=1"
						}else{
							layer.msg("请选择导出的文件")
						}
					}		
				} 
				$('#demolist2 .layui-btn').on('click', function(){
				    var type = $(this).data('type');
				    active[type] ? active[type].call(this) : '';
				});
				
				
				//以盒查询or以件查询的按条件查询
				$("#queryFile").bind("click",function(){
					var radioCheck=$("input[name=radio]:checked")[0].value
					if(radioCheck=='box'){
						var quanzongNumber=$("#quanzongNumber").val();
						var quanzongName=$("#quanzongName").val();
						var pcId=$("#pcId").val();
						var scId=$("#scId").val();
						var boxanual=$("#boxanual").val();
						var retentionperiodId=$("#retention").val();
						var boxNumber=$("#boxNumber").val();
						var storageRacknumber=$("#storageRacknumber").val();
						var condition=$("#condition").val();
						table.reload('demo', {
							  url: "${pageContext.request.contextPath}/fileQuery/queryBoxListByCondition"+"?timestamp="+Math.random()
							  ,where: {quanzongNumber:quanzongNumber,
								  	   quanzongName:quanzongName,
								  	   pcId:pcId,
								  	   scId:scId,
								  	   boxanual:boxanual,
								  	   retentionperiodId:retentionperiodId,
								  	   boxNumber:boxNumber,
								  	   storageRacknumber:storageRacknumber,
								  	   condition:condition} //设定异步数据接口的额外参数
							  //,height: 300
							  ,method:'post',
						});
						
						$.ajax({
							url:"${pageContext.request.contextPath}/fileQuery/queryConditionNum"+"?timestamp="+Math.random(),
							type:"post",
							data:{
								   "quanzongNumber":quanzongNumber,
							  	   "quanzongName":quanzongName,
							  	   "pcId":pcId,
							  	   "scId":scId,
							  	   "boxanual":boxanual,
							  	   "retentionperiodId":retentionperiodId,
							  	   "boxNumber":boxNumber,
							  	   "storageRacknumber":storageRacknumber,
							  	   "condition":condition
							   },
							   dataType:"json",
								success:function(num){
									console.log(num);
									 $("#countbox").html("");
									 $("#countFileNum").html("");
									 $("#countbox").html(num.boxNum);
									$("#countFileNum").html(num.fileNum); 
								},
								error:function(){
									layer.msg("发生未知错误请联系管理员")
								}
						})
						
					}else if(radioCheck=='list'){
						var quanzongNumber=$("#quanzongNumber2").val();
						var quanzongName=$("#quanzongName2").val();
						var pcId=$("#pcId2").val();
						var scId=$("#scId2").val();
						var archiveFileAnual=$("#archiveFileAnual").val();
						var retentionperiodid=$("#retention2").val();
						var archiveFileFileNumber=$("#archiveFileFileNumber").val();
						var boxnumber=$("#boxnumber2").val();
						var archiveFileCreatetime=$("#archiveFileCreatetime").val();
						var storageRacknumber=$("#storageRacknumber2").val();
						var condition=$("#condition2").val();
						table.reload('demo2', {
							  url: "${pageContext.request.contextPath}/fileQuery/queryFileListByCondition"+"?timestamp="+Math.random()
							  ,where: {quanzongNumber:quanzongNumber,
								  	   quanzongName:quanzongName,
								  	   pcId:pcId,
								  	   scId:scId,
								  	   archiveFileAnual:archiveFileAnual,
								  	   retentionperiodid:retentionperiodid,
								  	   archiveFileFileNumber:archiveFileFileNumber,
								  	   boxnumber:boxnumber,
								  	   archiveFileCreatetime:archiveFileCreatetime,
								  	   storageRacknumber:storageRacknumber,
								  	   condition:condition} //设定异步数据接口的额外参数
							  //,height: 300
							  ,method:'post',
						});
						
						$.ajax({
							url:"${pageContext.request.contextPath}/fileQuery/queryFileConditionNum"+"?timestamp="+Math.random(),
							type:"post",
							data:{
								   "quanzongNumber":quanzongNumber,
							  	   "quanzongName":quanzongName,
							  	   "pcId":pcId,
							  	   "scId":scId,
							  	   "archiveFileAnual":archiveFileAnual,
							  	   "retentionperiodid":retentionperiodid,
							  	   "archiveFileFileNumber":archiveFileFileNumber,
							  	   "boxnumber":boxnumber,
							  	   "archiveFileCreatetime":archiveFileCreatetime,
							  	   "storageRacknumber":storageRacknumber,
							  	   "condition":condition
							   },
							   dataType:"json",
								success:function(num){
									console.log(num);
									 $("#fileNumber").html("");
									 $("#filePages").html("");
									 $("#fileNumber").html(num.archiveFileNumber);
									$("#filePages").html(num.archiveFilePage); 
								},
								error:function(){
									layer.msg("发生未知错误请联系管理员")
								}
						})
						
					}
				});
				
				
				
				
			});
			
		</script>
	</body>

</html>