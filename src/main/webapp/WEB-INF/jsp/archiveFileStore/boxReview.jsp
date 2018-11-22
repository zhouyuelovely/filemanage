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
		<title>档案收集整理系统_档案送审</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css" />
		<!-- 页面css -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/boxReview.css" >

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/boxReview.css" />

		<!-- 图片预览 -->

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css">

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css"/>

		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->

	</head>
<body class="layui-layout-body">
		<div>
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
						<div class="logo">
							档案收集整理系统
							<a href="${pageContext.request.contextPath}/log/goHome" id="home">返回主页&gt;</a>
						</div>
					</div>

				</div>
				<!--全宗导航-->
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						<li class="layui-nav-item ">
							<c:if test="${zm:buttenPremission('aa',sessionScope.user.role.authorities) }">
								<a class="active" href="${pageContext.request.contextPath}/fileScanning/goFileScanning?meng=<%=Math.random() %>">档案扫描</a>
							</c:if>
							<!-- INSERT INTO "SCOTT"."AM_MA_SM_PERMISSION" VALUES ('13', '档案扫描', '/fileScanning/goFileScanning', '/archivescollect/scanning', 'aa'); -->
						</li>
						<li class="layui-nav-item">
							<c:if test="${zm:buttenPremission('ab',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/archiveFileStore/goStore?meng=<%=Math.random() %>">档案存储</a>
							</c:if>
							<!-- INSERT INTO "SCOTT"."AM_MA_SM_PERMISSION" VALUES ('13', '档案扫描', '/fileScanning/goFileScanning', '/archivescollect/scanning', 'aa'); -->
						</li>
						<li class="layui-nav-item">
							<c:if test="${zm:buttenPremission('ae',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/knowledgeBase/goIdentification?currentPage=1&meng=<%=Math.random() %>">档案整理</a>
								<!-- INSERT INTO "SCOTT"."AM_MA_SM_PERMISSION" VALUES ('17', '文件装盒', '/FilePackingBoxController/modelAndView', '/archiveManage/file_boxes', 'ae'); -->
							</c:if>
						</li>
						<li class="layui-nav-item layui-this">
							<c:if test="${zm:buttenPremission('af',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/boxSubmitReview/goBoxReview?meng=<%=Math.random() %>">档案送审</a>
							</c:if>
						</li>
						<li class="layui-nav-item layui-hide-xs">
							<c:if test="${zm:buttenPremission('ag',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/fileAudit/fileAuditShow?meng=<%=Math.random() %>">档案审核</a>
							</c:if>
						</li>
					</ul>
				</div>
				<!-- 主体内容 -->
				<div class="layui-body" style="top:140px;left: 0;">
					<div class="layui-row">
						<div class="layui-inline" style="padding-top: 10px;padding-left:10px;width: 100%;">
							<div id="for" style="float: left;padding-left: 20px;">
								<span for="">${user.archive.quanzongName }</span>
								<form class="layui-form inline">
					 				<span for="" >年度</span>
									<div class="layui-form-item inline" style="width: 100px;">
									<select name="city1" lay-filter="city1" id="selectAnual">
										<option value="">请选择</option>
										<c:forEach items="${anual}" var="an">
											<option value="${an.anual}">${an.anual}</option>
										</c:forEach>
									</select>
									</div>
								</form>
								<div class="layui-form inline">
					 				<span for="" >保管期限</span>
									<div class="layui-form-item inline" style="width: 150px;">
									<select name="city2" lay-filter="city2" id="city2">
										<option value="">请选择</option>
									</select>
									</div>
								</div>
								<input type="hidden" id="custody" value="">
								<span id="inforCon">
								</span>
							</div>
							<div id="but" style="float: right;padding-right: 20px;">
							<c:if test="${zm:buttenPremission('afa',sessionScope.user.role.authorities) }">
								<div class="layui-input-inline">
									<input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入关键字查询" id="condition"/>
								</div>
								<button class="layui-btn layui-btn-normal" data-type="queryBox">查询</button>
							
							</c:if>
							</div>
						</div>
						
						<div style="padding: 15px;">
							<table class="layui-hide" id="demo" lay-filter="demo"></table>
						</div>
						<script type="text/html" id="barDemo">
							<!-- 这里同样支持 laytpl 语法，如： -->
							<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
						</script>
						<div id="features" style="margin: 18px 15px;">
							<label for="">档案合计：</label><span id="boxNum">${num }</span>盒&nbsp;<span id="fileNum">${fileNum }</span>件
<!-- 							<button class="layui-btn layui-btn-sm" data-type="submitAccept">提交验收</button>
							<button class="layui-btn layui-btn-sm" data-type="exportFile">导出档案</button>
							<button class="layui-btn layui-btn-sm" data-type="reorganize">重新整理</button> -->
						</div>
						<div id="" style="width: 800px;">

						</div>
					</div>
					<!-- 辅助元素，一般用于移动设备下遮罩 -->
					 <div class="layadmin-body-shade" layadmin-event="shade"></div>
					</div>
				</div>
			</div>
			<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
			<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
			<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
			<script src="${pageContext.request.contextPath}/js/formSelects.js" type="text/javascript" charset="utf-8"></script>
			<!-- 图片预览插件 -->
			<script src="${pageContext.request.contextPath}/js/viewer.min.js"></script>
			<script>
			/* 表格渲染开始 */
				layui.use('table', function() {
					var $ = layui.$
					,layer = layui.layer;
					var table = layui.table;
					var laypage = layui.laypage;
					//初始化数据渲染
					table.render({
						elem: '#demo',
						url:"${pageContext.request.contextPath}/boxSubmitReview/havingBoxContent"+"?timestamp="+Math.random(),
						method:'post',
						cols: [
							[ //标题栏
								{
									type: 'numbers', 
									title: '序号' 
								}, {
									field: 'quanzongNumber',
									title: '全宗号',
									width: 150,
									unresize: 'false',
									toolbar:'#quanzongNumber',
								}, {
									field: 'quanzongName',
									title: '全宗名称',
									minWidth: 150,
									unresize: 'false',
									toolbar:'#quanzongName',
								}, {
									field: 'boxanual',
									title: '年度',
									width: 100,
									unresize: 'false',
								}, {
									field: 'scName',
									title: '机构(问题)',
									width: 150,
									unresize: 'false',
									toolbar:'#scName',
								},
								{
									field: 'retentionperiodname',
									title: '保管期限',
									width: 100,
									unresize: 'false',
									toolbar:'#retentionperiodname',
								},
								{
									field: 'boxstartnumber',
									title: '起件号',
									width: 100,
									unresize: 'false',
								},
								{
									field: 'boxendnumber',
									title: '止件号',
									width: 100,
									unresize: 'false',
								},
								{
									field: 'boxnumber',
									title: '盒号',
									width: 100,
									unresize: 'false',
								},
								{
									field: 'boxthickness',
									title: '盒属性',
									width: 100,
									unresize: 'false',
								},
								{
									field: 'boxstatus',
									title: '状态',
									width: 100,
									unresize: 'false',
									toolbar:'#boxStart',
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
						data: []
							//,skin: 'line' //表格风格
							,
						even: true,
						page: true //是否显示分页
							//,limits: [5, 7, 10]
							,
						limit: 10//每页默认显示的数量
					});
					//监听工具条
					table.on('tool(demo)', function(obj) {
						var data = obj.data;
						var tr = obj.tr;
						var boxId=obj.data.boxid;
						if(obj.event === 'detail') {//查看文件的附件（图片）
							//获取盒子附件的信息
							var text="";
							$.ajax({//根据盒子主键获取盒子附件信息
								url:"${pageContext.request.contextPath}/boxSubmitReview/havingAmCoBoxattachment?timestamp="+Math.random(),
								data:"boxId="+boxId,
								type:"post",
								beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
								dataType:"json",
								success:function(amCoBoxattachment){
									$.ajax({//根据文件主键获取盒子中第一份文件的附件（图片）
										url:"${pageContext.request.contextPath}/boxSubmitReview/havingFileAttachment?timestamp="+Math.random(),
										data:"boxId="+boxId,
										type:"post",
										dataType:"json",
										beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
										success:function(pageBean){//组装盒子附件的页面和数据
												text=text+"<div class='add_lb1'>" +
																"<ul class='look-list'>" +
																	"<li>盒面&盒脊</li>" +
																	"<li>归档文件目录</li>" +
																	"<li>文件</li>" +
																	"<li>备考表</li>" +
																"</ul>" +
															"<div id='boxId'>"+
																"<div style='float: left;'><img src='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+amCoBoxattachment.boxattachmentBox+"?"+Math.random()+"' width='150px' height='200' style='padding: 20px;' class='imgs'/></div>" +
																"<div style='float: left;'><img src='../imgs/guidang.png' class='guidang' width='150px' height='200' id='"+boxId+"' style='padding: 20px;'/></div>" 
											var lists=pageBean.lists;
													for(var i=0;i<lists.length;i++){
														text+="<div style='float: left;'><img src='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+lists[i].fileAttachmentPath+"?"+Math.random()+"' class='wenjian' width='150px' height='200' id='"+lists[i].archiveFileId+"' style='padding: 20px;'/></div>"
													}
												text=text+	"<div style='float: left;'><img src='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+amCoBoxattachment.boxattachmentForm+"?"+Math.random()+"' width='150px' height='200' style='padding: 20px;'class='imgs' /></div>" +
													"<div class='layui-clear' style='padding-top: 30px;padding-left: 350px;'>"+
													"<span>第<select name='' id='pages' data-type='change'>"
													for(var i=0;i<pageBean.totalPage;i++){
														text=text+ "<option" 
														if(pageBean.currPage==(i+1)){
															text+=" selected "
														}
														text=text+ " value='"+(i+1)+"'>"+(i+1)+"</option>"
													}
												text=text+	"</select>件</span>" +
													"<span>共<span>"+pageBean.totalPage+"</span>件</span><span class='layui-btn layui-btn-xs previous' data-type='previous' id='"+pageBean.currPage+"'  name='1'>上一件</span><span class='layui-btn layui-btn-xs next'  data-type='next' id='"+pageBean.currPage+"' name='"+pageBean.totalPage+"'>下一件</span></div></div></div>"
													
													layer.open({//渲染盒子的信息
														type: 1,
														title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
														area: ['800px', '460px'],
														skin: 'add_label_bg',
														offset: 'auto',
														shade: [0.8, '#393D49'],
														content:text
													});
													x();
													var $ = layui.$, active ={//盒子附件查看文件的分页
															previous: function(){
																var currPage=$(this).attr("id")
																var cur=parseInt(currPage)-1;
																var home=$(this).attr("name")
																if(currPage!=home){
																	cont(cur,boxId)
																}else{
																	layer.msg("当前为第一件")
																}
															},
															next: function(){
																var currPage=$(this).attr("id")
																var cur=parseInt(currPage)+1;
																var last=$(this).attr("name")
																if(currPage!=last){
																	cont(cur,boxId);
																}else{
																	layer.msg("当前为最后一件")
																}
															},
															change: function(){
																var cur= parseInt($("#pages").val())
																cont(cur,boxId);
															}
													}
													
													$('.layui-clear .layui-btn').on('click', function(){//绑定文件数量事件
													    var type = $(this).data('type');
													    active[type] ? active[type].call(this) : '';
													});
													$('.layui-clear #pages').on('change', function(){//绑定文件分页事件
													    var type = $(this).data('type');
													    active[type] ? active[type].call(this) : '';
													});
													function cont(currPage,boxId){//分页数据渲染
														$.ajax({
															url:"${pageContext.request.contextPath}/boxSubmitReview/havingFileAttachment"+"?timestamp="+Math.random(),
															data:"boxId="+boxId+"&currentPage="+currPage,
															type:"post",
															dataType:"json",
															success:function(pageBean){
																var list=pageBean.lists;
																$(".wenjian").attr("src","<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+list[0].fileAttachmentPath);
																$(".wenjian").attr("id",list[0].archiveFileId)
																$(".previous").attr("id",pageBean.currPage)
																$(".next").attr("id",pageBean.currPage)
																$("#pages").find("option").remove();
																var content="";
																for(var i=0;i<pageBean.totalPage;i++){
																	content=content+ "<option" 
																	if(pageBean.currPage==(i+1)){
																		content+=" selected"
																	}
																	content=content+ " value='"+(i+1)+"'>"+(i+1)+"</option>"
																}
																console.log(content)
																$("#pages").append(content);
																
															},error:function(){
																layer.msg("请检查接口")
															}
														})
													}
													
										},error:function(){
											layer.msg("检查接口")
										}
									});
									
								},error:function(){
									layer.msg("检查接口")
								}
							});
							
							function x(){
								
								$(function() {//文件点击查看
									$('.imgs').viewer();
								})
								//查看文件列表
								$(function() {
									$(".wenjian").click(function() { //点击查看文件
										var archivefileid=$(".wenjian").attr("id")
										$.ajax({//根据文件主键查看文件的附件
											url:"${pageContext.request.contextPath}/boxSubmitReview/havingFileAttachmentByArchiveFileId"+"?timestamp="+Math.random(),
											data:"archivefileid="+archivefileid,
											type:"post",
											beforeSend :function(xmlHttp){ 
										        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
										        xmlHttp.setRequestHeader("Cache-Control","no-cache");
										     },
											dataType:"json",
											success:function(data){
												var text="'<ul class='Scanning_Images' onclick='img_vi()'>";
												for(var i=0;i<data.length;i++){
													text+="<li><img src=\"<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+data[i].fileAttachmentPath+"?"+Math.random()+"\" alt=''><p>page"+data[i].fileAttachmentPageNumber+"</p></li>"
												}
												text+="</ul>"
												layer.open({
													type: 1,
													title: '<i class="fa fa-bars" style="padding:0 5px"></i>文件列表',
													area: ['800px', '400px'],
													skin: 'add_label_bg',
													offset: 'auto',
													shade: [0.8, '#393D49'],
													content: text
												});
												
											},error:function(){
												layer.msg("发生错误请检查接口")
											}
										})
									})
								})
								$(function() {
									$(".guidang").click(function() { //查看归档文件目录的信息
										var boxId=$(".guidang").attr("id");
										$.ajax({
											url:"${pageContext.request.contextPath}/boxSubmitReview/havingAmCoBoxByBoxId"+"?timestamp="+Math.random(),
											data:"boxId="+boxId,
											type:"post",
											dataType:"json",
											success:function(data){
												var text="";
												text=text+"<div style='padding: 15px;'>"
													text=text+"<ul class='table_title'>"
														text=text+"<li><label>期限：</label><span>"+data.retentionperiod.retentionperiodname+"</span></li>"
														text=text+"<li><label>分类：</label><span>"+data.secondryClassFication.scName+"</span></li>"
														text=text+"<li><label>盒号：</label><span>"+data.boxnumber+"</span></li>"
													text=text+"</ul>"
													text=text+"<table class='layui-hide' id='guidang' lay-filter='guidang'></table>"
												text=text+"</div>"		
												layer.open({
													type: 1,
													title: '<i class="fa fa-bars" style="padding:0 5px"></i>归档文件列表',
													area: ['800px', '600px'],
													skin: 'add_label_bg',
													offset: 'auto',
													shade: [0.8, '#393D49'],
													content: text
												});
												
												layui.use('table', function() {//归档文件表格
													var table = layui.table;
													var laypage = layui.laypage;
													var boxId=$(".guidang").attr("id");
													//展示已知数据
													table.render({
														elem: '#guidang',
														url:"${pageContext.request.contextPath}/boxSubmitReview/havingArchiveFileByBoxId?boxId="+boxId+"&timestamp="+Math.random(),
														method:'post',
														cols: [
															[ //标题栏
																{
																	type: 'numbers', 
																	title: '序号' 
																},
																{
																	field: 'archiveFileFileNumber',
																	title: '档号',
																	width: 150,
																	unresize: 'false',
																}, {
																	field: 'archiveFileReferenceNumber',
																	title: '文号',
																	minwidth: 200,
																	unresize: 'false',
																}, {
																	field: 'archiveFileResponsible',
																	title: '责任者',
																	Width: 100,
																	unresize: 'false',
																}, {
																	field: 'archiveFileTitle',
																	title: '题名',
																	Width: 100,
																	unresize: 'false',
																},
																{
																	field: 'archiveFileCreatetime',
																	title: '日期',
																	Width: 150,
																	unresize: 'false',
																},
																{
																	field: 'afSecurityClassrification',
																	title: '密级',
																	Width: 100,
																	unresize: 'false',
																},
																{
																	field: 'archiveFilePages',
																	title: '页数',
																	Width: 100,
																	unresize: 'false',
																},
																{
																	field: 'archiveFileRemark',
																	title: '备注',
																	Width: 100,
																	unresize: 'false',
																},
			
															]
														],
														data: [ ]
															//,skin: 'line' //表格风格
															,
														even: true,
														page: true //是否显示分页
															//,limits: [5, 7, 10]
															,
														limit: 10//每页默认显示的数量
													});
												});
												
											},error:function(){
												layer.msg("发生错误请检查接口")
											}
										})
								
									})
								})
							}	
						}
					});
					var $ = layui.$, active ={
							queryBox:function(){//条件查询盒子信息
								var condition=$("#condition").val();
								var anual=$("#selectAnual").val();
								table.reload('demo', {
									  url: "${pageContext.request.contextPath}/boxSubmitReview/conditionBoxContent"+"?timestamp="+Math.random()
									  ,where: {condition:condition,anual:anual} //设定异步数据接口的额外参数
									  //,height: 300
									  ,method:'post',
								});
								 $.ajax({
										url:"${pageContext.request.contextPath}/boxSubmitReview/contionHavingInforBox"+"?timestamp="+Math.random(),
										data:"anual="+anual+"&condition="+condition,
										type:"post",
										dataType:"json",
										success:function(result){
											$("#boxNum").text(result.boxNum);
											$("#fileNum").text(result.fileNum);
										},error:function(){
											layer.msg("接口访问异常")
										}
								});
							},
					}
					$('#but .layui-btn').on('click', function(){//绑定查看盒子信息
					    var type = $(this).data('type');
					    active[type] ? active[type].call(this) : '';
					});
					layui.use('form', function(){//按照年度筛选获取盒子
						  var form = layui.form;
						  var $=layui.$;
						  form.on('select(city1)', function(data){
							 var anual=data.value;
							 if(anual!=""){//年度不为空时展现数据信息
								 table.reload('demo', {
									  url: "${pageContext.request.contextPath}/boxSubmitReview/reloadHavingBox?timestamp="+Math.random()
									  ,where: {anual:anual} //设定异步数据接口的额外参数
									  //,height: 300
									  ,method:'post',
									  id:'tm',
								});
								$.ajax({//重载盒子表格信息
									url:"${pageContext.request.contextPath}/boxSubmitReview/reloadInfor?timestamp="+Math.random(),
									data:"anual="+anual,
									type:"post",
									dataType:"json",
									success:function(result){
										$("#boxNum").text(result.boxNum);
										$("#fileNum").text(result.fileNum);
										
										//保管期限渲染
										$.ajax({
											url: "${pageContext.request.contextPath}/boxSubmitReview/havingRetentionperiodHelp"+"?timestamp="+Math.random(),
											data:"anual="+anual,
											type:"post",
											dataType:"json",
											success:function(result){
												$("#city2").find("option:gt(0)").remove();
												 $.each(result,function(key,val){
													 var option=$("<option>").val(val.retentionperiodid).text(val.retentionperiodname);
													 $("#city2").append(option);
							                         form.render('select');
												 })
						                         moreSel();
											}
										})
										
										//清空页面按钮
										$("#city2").find("option:gt(0)").remove();
										$("#features").find("button").remove();//清除按钮子元素
										$("#inforCon").find("span").remove();//清除xian'shi子元素
									},error:function(){
										layer.msg("接口访问异常")
									}
								});
							 }else{
								 table.reload('demo', {//年度为空是显示盒子信息
									  url: "${pageContext.request.contextPath}/boxSubmitReview/havingBoxContent"+"?timestamp="+Math.random()
									  ,where: {} //设定异步数据接口的额外参数
									  //,height: 300
									  ,method:'post',
								});
								$.ajax({
										url:"${pageContext.request.contextPath}/boxSubmitReview/havingInfor"+"?timestamp="+Math.random(),
										data:"anual="+anual,
										type:"post",
										dataType:"json",
										success:function(result){
											$("#boxNum").text(result.boxNum);
											$("#fileNum").text(result.fileNum);
										},error:function(){
											layer.msg("接口访问异常")
										}
								});
							 }	
							 
						}); 
						  //各种基于事件的操作，下面会有进一步介绍
					});
					function func(){
						var $ = layui.$, active ={
								queryBox:function(){//查询按钮事件
									var condition=$("#condition").val();
									var anual=$("#selectAnual").val();
									table.reload('demo', {
										  url: "${pageContext.request.contextPath}/boxSubmitReview/conditionBoxContent"+"?timestamp="+Math.random()
										  ,where: {condition:condition,anual:anual} //设定异步数据接口的额外参数
										  //,height: 300
										  ,method:'post',
									});
									 $.ajax({
											url:"${pageContext.request.contextPath}/boxSubmitReview/contionHavingInforBox"+"?timestamp="+Math.random(),
											data:"anual="+anual+"&condition="+condition,
											type:"post",
											dataType:"json",
											success:function(result){
												$("#boxNum").text(result.boxNum);
												$("#fileNum").text(result.fileNum);
											},error:function(){
												layer.msg("接口访问异常")
											}
									});
								},
								submitAccept: function(){//提交整理点击事件
									var custody=$("#custody").val();
									var anual=$("#selectAnual").val();
									if(custody!=""&&anual!=""){
										$.ajax({
											url:"${pageContext.request.contextPath}/boxSubmitReview/submitAccept?timestamp="+Math.random(),
											data:"custody="+custody+"&anual="+anual,
											type:"post",
											dataType:"json",
											success:function(result){
												if(result==true){
													layer.msg("盒子已提交成功",{setoff:'auto',anim: 1},function(){
														table.reload('demo',{});
													})
												}else{
													layer.msg("发生未知错误请联系管理员")
												}
											},error:function(){
												layer.msg("接口访问异常")
											}
										});
									}else{
										layer.msg("请选择提交审核的盒子保管期限")
									}
								},
								
								//导出文档
								exportFile: function(){
									if($("#selectAnual").val()==''){
										layer.msg("请选择年度!")
									}else if($("#custody").val()==''){
										layer.msg("请选择保管期限!")
									}else{
										var boxYear=$("#selectAnual").val();
										var retentionperoids=$("#custody").val();
										console.log("boxYear="+boxYear);
										console.log("retentionperoids="+retentionperoids);
										window.location.href="${pageContext.request.contextPath}/boxSubmitReview/exportDocument?boxYear="+boxYear+"&retentionperiodid="+retentionperoids;
									}
								},

								reorganize: function(){//驳回重整
									var anual=$("#selectAnual").val();
									var custody=$("#custody").val();
									if(anual!=""){
										$.ajax({
											url:"${pageContext.request.contextPath}/boxSubmitReview/reorganize?timestamp="+Math.random(),
											data:"anual="+anual+"&custody="+custody,
											type:"post",
											dataType:"json",
											success:function(result){
												if(result==true){
													layer.msg("文件已驳回重新整理",{setoff:'auto',anim: 1},function(){
														table.reload('demo',{});
													})
												}else{
													layer.msg("发生未知错误请联系管理员")
												}
											},error:function(){
												layer.msg("接口访问异常")
											}
										});
									}else{
										layer.msg("请选择驳回重整盒子的年度")
									}
								},
								
							}
						
						$('#features .layui-btn').on('click', function(){
						    var type = $(this).data('type');
						    active[type] ? active[type].call(this) : '';
						});
					}
					
					function moreSel(){
						formSelects.selects({//多选
							name: 'select2',
							el: 'select[name=city2]',
							show: '#select-result2',
							model: 'select',
							filter: 'city2',
							change:function(data, arr){
								var retentionperoids="";
								for(var i=0;i<arr.length;i++){
									retentionperoids+=arr[i].val+","
								}
								retentionperoids=retentionperoids.substr(0,retentionperoids.length-1);
								$("#custody").val("")
								$("#custody").val(retentionperoids)
								var anual=$("#selectAnual").val();
								if(anual!=""){
									if(retentionperoids!=""){
										table.reload('demo', {
											  url: "${pageContext.request.contextPath}/boxSubmitReview/queryAllAllAmcBoxByAnualAndRetentionperoid?timestamp="+Math.random()
											  ,where: {retentionperoids:retentionperoids,anual:anual} //设定异步数据接口的额外参数
											  //,height: 300
											  ,method:'post',
										});
										$.ajax({
											url:"${pageContext.request.contextPath}/boxSubmitReview/reloadAmcBoxByAnualAndRetentionperoid?timestamp="+Math.random(),
											data:"anual="+anual+"&retentionperoids="+retentionperoids,
											type:"post",
											dataType:"json",
											success:function(result){
												$("#boxNum").text(result.boxNum);
												$("#fileNum").text(result.fileNum);
											},error:function(){
												layer.msg("接口访问异常")
											}
										});
										$.ajax({//根据文件的信息展示不同的按钮
											url: "${pageContext.request.contextPath}/boxSubmitReview/queryAllAllAmcBoxByAnualAndRetentionperoid?timestamp="+Math.random(),
											data:{'anual':anual,'limit':10,'page':1,"retentionperoids":retentionperoids},
											type:"post",
											dataType:"json",
											success:function(data){
												var list=data.data;
												for(var i=0;i<list.length;i++){
													if(list[i].boxstatus=='0'){
														meng='1';
													}else if(list[i].boxstatus=='1'){
														meng='2';
														break;
													}else if(list[i].boxstatus=='2'){
														meng='3';
														break;
													}else if(list[i].boxstatus=='3'){
														meng='4';
														break;
													}
												}
												if(meng=='1'){
													$("#city2").find("option:gt(0)").remove();
													$("#features").find("button").remove();//清除按钮子元素
													$("#inforCon").find("span").remove();//清除xian'shi子元素
													$("#features").append('<button class="layui-btn layui-btn-sm" data-type="submitAccept">提交验收</button>')
													
													func();
													td()
												}else if(meng=='2'){
													$("#city2").find("option:gt(0)").remove();
													$("#features").find("button").remove();//清除按钮子元素
													$("#inforCon").find("span").remove();//清除xian'shi子元素
													func();
													td()
												}else if(meng=='3'){
													$("#city2").find("option:gt(0)").remove();
													$("#features").find("button").remove();//清除按钮子元素
													$("#features").append('<button class="layui-btn layui-btn-sm" data-type="exportFile">导出档案</button>')
													var content="";
													content+='<span style="color: green;font-weight: bold;">*<span>'+anual+'</span>年度档案已验收合格，请及时根据电子档案进行实体档案整理！</span>'
													$("#inforCon").find("span").remove();//清除xian'shi子元素
													$("#inforCon").html(content)
													func();
													td()
												}else if(meng=='4'){
													$("#city2").find("option:gt(0)").remove();
													$("#features").find("button").remove();//清除按钮子元素
													$("#features").append('<button class="layui-btn layui-btn-sm" data-type="reorganize">重新整理</button>')
													var content="";
													content+='<span style="color:red;font-weight: bold;">*<span>'+anual+'</span>年度档案已被驳回重整,请及时根据'
													content+='<a class="look for_review" style="cursor: pointer;">验收情况表</a>进行修改重新提交验收！</span>'
													$("#inforCon").find("span").remove();//清除xian'shi子元素
													$("#inforCon").html(content);
													func();
													td()
												}
											}
										})
									}else{
										 table.reload('demo', {
											  url: "${pageContext.request.contextPath}/boxSubmitReview/reloadHavingBox"+"?timestamp="+Math.random()
											  ,where: {anual:anual} //设定异步数据接口的额外参数
											  //,height: 300
											  ,method:'post',
											  id:'tm',
										});
										$.ajax({//重载盒子表格信息
											url:"${pageContext.request.contextPath}/boxSubmitReview/reloadInfor"+"?timestamp="+Math.random(),
											data:"anual="+anual,
											type:"post",
											dataType:"json",
											success:function(result){
												$("#boxNum").text(result.boxNum);
												$("#fileNum").text(result.fileNum);
											},error:function(){
												layer.msg("接口访问异常")
											}
										});
									}	
								}else{
									layer.msg("请选择年度")
								}
							},
							reset: true
						});
	   				}
					
				});
				/* 表格数据渲染结束  */
				function img_vi() {
					$('.Scanning_Images').viewer();
				}
				function td(){//驳回重整表
					$(function() {
						$(".for_review").click(function() { //#btn为按钮id
							layer.open({
								type: 1,
								title: '<i class="fa fa-bars" style="padding:0 5px"></i>驳回重整',
								area: ['800px', '600px'],
								skin: 'add_label_bg',
								offset: 'auto',
								shade: [0.8, '#393D49'],
								content: '<div style="padding: 15px;text-align: center;"><label style="font-weight: bold;">验收情况表</label><table class="layui-hide" id="text" lay-filter="text"></table> </div></form>'
							});
							layui.use('table', function() {
								var table = layui.table;
								var laypage = layui.laypage;
								var anual=$("#selectAnual").val();
								//展示已知数据
								table.render({
									elem: '#text',
									url:"${pageContext.request.contextPath}/boxSubmitReview/returnInfo?anual="+anual+"&timestamp="+Math.random(),
									method:'post',
									cols: [
										[ //标题栏
											{ 	type: 'numbers', 
												title: '序号' 
											},
											{
												field: 'boxsericalnumber',
												title: '抽查盒编号',
												width: 150,
												unresize: 'false',
												toolbar:"#boxsericalnumber",
											}, {
												field: 'returnInfoReason',
												title: '存在问题',
												minwidth: 200,
												unresize: 'false',
											}, {
												field: 'returnInfoPreson',
												title: '审核人',
												Width: 100,
												unresize: 'false',
											}, {
												field: 'returnInfoTime',
												title: '审核时间',
												Width: 100,
												unresize: 'false',
												toolbar:"#time"
											},

										]
									],
									data: [
										]
										//,skin: 'line' //表格风格
										,
									even: true,
									page: true //是否显示分页
										//,limits: [5, 7, 10]
										,
									limit: 10 //每页默认显示的数量
								});
							});
						})
					})
			
				}
				function dateForm(time){//时间格式化
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
			<script type="text/html" id="quanzongNumber">
				{{d.archive.quanzongNumber}}
			</script>
			<script type="text/html" id="quanzongName">
				{{d.archive.quanzongName}}
			</script>
			<script type="text/html" id="scName">
				{{d.secondryClassFication.scName}}
			</script>
			<script type="text/html" id="retentionperiodname">
				{{d.retentionperiod.retentionperiodname}}
			</script>
			<script type="text/html" id="boxStart">
				{{#  if(d.boxstatus == 0){  }}待审核
		 		{{#  } else if(d.boxstatus == 1){ }}审批中
				{{#  } else if(d.boxstatus == 2){ }}审批通过
				{{#  } else if(d.boxstatus == 3){ }}已驳回
				{{#  }  }}
			</script>
			<script type="text/html" id="boxsericalnumber">
				{{d.amCoBox.boxsericalnumber}}
			</script>
			<script type="text/html" id="time">
				{{ dateForm(d.returnInfoTime)}}
			</script>
</body>
</html>