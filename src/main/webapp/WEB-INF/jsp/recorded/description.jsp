<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<%
  String app_url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%
  String appurl=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
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
		<title>档案管理存储系统_档案著录</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="../layui/css/layui.css" media="all">
		<link rel="stylesheet" href="../css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="../font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="../css/index.css" />
		<link rel="stylesheet" type="text/css" href="../css/viewer.min.css" />
		<link href="../css/skin_01.css" rel="stylesheet" type="text/css" id="skin">
		<link rel="stylesheet" type="text/css" href="../css/scaning.css" />
		<link rel="stylesheet" type="text/css" href="../css/description.css" />
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
    	<style>
    	 #boxId div:last-child{
    	 	float:right!important;
    	 	padding-right:35px!important;
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
						<span class="logo_img"><img src="../imgs/home.gif" width="110" height="50"/></span>
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
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
							<span class="gong_color">消息提示：</span> 您有
							<span id="messNum"></span>条
							<a href="${pageContext.request.contextPath}/messageNotification/goNotification" class="gong_color">未读</a>消息，请及时处理！</span>
						</p>
					</c:if>
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						 <c:if test="${zm:buttenPremission('ca',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/recordedContent/goCatalog">新建档案</a>
							</li>
							<span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('cb',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
								<a href="${pageContext.request.contextPath}/recordedTable/goRecordedTable">著录列表</a>
							</li>
						</c:if>
						
					</ul>
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-fluid">
						<div class="layui-row layui-col-space15">
							<div class="layui-col-md9">
								<form id="for">
									<div class="layui-form inline">
										<label for="" style="float:left;line-height: 40px;"><i class="fa fa-circle" style="color: #EA5519;"></i>${sessionScope.user.archive.quanzongName }</label>
										<input type="hidden" id="quId" value="${sessionScope.user.archive.quanzongId }">
										<div class="layui-form-item inline" style="width: 100px;">
											<select lay-filter="pc" id="pc" name="pc">
												<option value="">档案分类</option>
												<c:forEach items="${sp }" var="p">
													<option value="${p.selectKey }">${p.selectValue }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="layui-form inline">
										<div class="layui-form-item inline" style="width: 100px;">
											<select lay-filter="anual" id="anual" name="anual">
												<option value="">年度</option>
												<c:forEach items="${sa }" var="a">
													<option value="${a }">${a }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="layui-form inline">
										<div class="layui-form-item inline" style="width: 100px;">
											<select lay-filter="start" id="start" name="start">
												<option value="">状态</option>
												<option value="1">未装盒</option>
												<option value="2">已装盒</option>
											</select>
										</div>
									</div>
								</form>
							</div>
							<div class="layui-col-md3">
								<div class="layui-input-inline">
									<input type="text" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入关键字查询" id="condition">
								</div>
								<button class="layui-btn layui-btn-normal" data-type="queryBox">查询</button>
							</div>
							<div class="layui-card layui-clear">
								<div class="layui-card-body">
									<table class="layui-hide" id="description_tabel" lay-filter="description_tabel"></table>
									<div id="infor" style="margin: 18px 0px;">
										<label for="">档案合计：</label>
										<span id="boxNum">${num.boxNum }</span>盒&nbsp;
										<span id="fileNum">${num.fileNum }</span>件
										<c:if test="${zm:buttenPremission('cbd',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-normal" data-type="addFile">补充盒内文件</button></a>
										</c:if>
										<c:if test="${zm:buttenPremission('cbe',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-normal" data-type="join">提交进馆</button>
										</c:if>
									</div>
								</div>
							</div>
						</div>
						<script type="text/html" id="barDemo">
							<!-- 这里同样支持 laytpl 语法，如： -->
							<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
							<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
						</script>
					</div>
					<!-- 辅助元素，一般用于移动设备下遮罩 -->
					<div class="layadmin-body-shade" layadmin-event="shade"></div>
				</div>
			</div>
		</div>
		<script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../layui/layui.all.js"></script>
		<script src="../layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/messgeNum.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/viewer.min.js" type="text/javascript" charset="utf-8"></script>
		<!--[if IE 6]>
				<script type="text/javascript" src="../js/DDPngMin.js"></script>
				<script>DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');</script>
			<![endif]-->
		<script>
			layui.use(['upload','form', 'layer','table'], function() {
				var table = layui.table
		          ,form = layui.form,upload = layui.upload;
				var $ = layui.jquery;
				//展示已知数据
				table.render({
					elem: '#description_tabel',
					url:"${pageContext.request.contextPath}/recordedTable/havingAmCoBoxByQuanzongId?l="+Math.random(),
					method:'post',
					cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
					cols: [
						[ //标题栏
							{
								type: 'checkbox',
								fixed: 'left',
							},
							{
								field: 'id',
								title: '序号',
								type: 'numbers', 
								unresize: 'false',
								sort: true,
							},
							{
								field: 'quanzongNumber',
								title: '全宗号',
								unresize: 'false',
								toolbar:'#quanzongNumber',
							}, {
								field: 'quanzongName',
								title: '全宗名称',
								unresize: 'false',
								toolbar:'#quanzongName',
							}, {
								field: 'boxanual',
								title: '年度',
								unresize: 'false',
							},
							{
								field: 'scName',
								title: '机构(问题)',
								unresize: 'false',
								toolbar:'#scName',
							},
							{
								field: 'retentionperiodname',
								title: '保管期限',
								unresize: 'false',
								toolbar:'#retentionperiodname',
							},
							{
								field: 'boxstartnumber',
								title: '起件号',
								unresize: 'false',
							},
							{
								field: 'boxendnumber',
								title: '止件号',
								unresize: 'false',
							},
							{
								field: 'boxnumber',
								title: '盒号',
								unresize: 'false',
							},
							{
								field: 'boxpage',
								title: '盒属性',
								unresize: 'false',
							},
							{
								field: 'boxBoxingStart',
								title: '状态',
								unresize: 'false',
								toolbar:'#boxBoxingStart',
							},
							{
								field: 'boxstatus',
								title: '状态',
								unresize: 'false',
								toolbar:'#boxstatus',
							},
							{
								field: 'right',
								title: '操作',
								unresize: 'false',
								toolbar: '#barDemo'
							}
						]
					],
					data: [ ],
					/*skin: 'nob' //表格风格
						,*/
					even: false,
					page: true //是否显示分页
						//,limits: [5, 7, 10]
						,
					limit: 10 //每页默认显示的数量
				});
				//行内操作
				table.on('tool(description_tabel)', function(obj) {
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
															"<div style='float: left;'><img src='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+amCoBoxattachment.boxattachmentBox+"?l="+Math.random()+"' width='150px' height='200' style='padding: 20px;' class='imgs'/></div>" +
															"<div style='float: left;'><img src='../imgs/guidang.png' class='guidang' width='150px' height='200' id='"+boxId+"' style='padding: 20px;'/></div>" 
										var lists=pageBean.lists;
											var im=null;
											for(var i=0;i<lists.length;i++){
												im=lists[i].fileAttachmentPath;
												if(im!=null){
													im='<%=appurl%>'+im+"?l="+Math.random();
												}else{
													im='';
												}
												text+="<div style='float: left;'><img src='"+im+"' class='wenjian' width='150px' height='200' id='"+lists[i].archiveFileId+"' style='padding: 20px;'/></div>"
											}
											var imb=amCoBoxattachment.boxattachmentForm;
											if(imb!=null){
												imb='<%=appurl%>'+imb+"?l="+Math.random();
											}else{
												imb='';
											}
											text=text+	"<div style='float: left;'><img src='"+imb+"' width='150px' height='200' style='padding: 20px;'class='imgs' /></div>" +
												"</div><div class='layui-clear' style='padding-top: 30px;padding-left: 350px;'>"+
												"<span>第<select id='pages' data-type='change'>"
												for(var i=0;i<pageBean.totalPage;i++){
													text=text+ "<option" 
													if(pageBean.currPage==(i+1)){
														text+=" selected"
													}
													text=text+ " value='"+(i+1)+"'>"+(i+1)+"</option>"
												}
											text=text+	"</select>件</span>" +
												"<span>共<span>"+pageBean.totalPage+"</span>件</span><span class='layui-btn layui-btn-xs previous' data-type='previous' id='"+pageBean.currPage+"'  name='1'>上一件</span><span class='layui-btn layui-btn-xs next'  data-type='next' id='"+pageBean.currPage+"' name='"+pageBean.totalPage+"'>下一件</span></div></div>"
												
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
														url:"${pageContext.request.contextPath}/boxSubmitReview/havingFileAttachment?timestamp="+Math.random(),
														data:"boxId="+boxId+"&currentPage="+currPage,
														type:"post",
														dataType:"json",
														success:function(pageBean){
															var list=pageBean.lists;
															$(".wenjian").attr("src","<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+list[0].fileAttachmentPath+"?l="+Math.random());
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
					}else if(obj.event === 'del'){
						var boxStart=obj.data.boxstatus;
						if(boxStart=='2'){
							layer.msg("已进馆档案不允许删除")
						}else if(boxStart=='4'){
							layer.open({
								type: 1,
								title: '<i class="fa fa-bars" style="padding:0 5px"></i>删除',
								area: ['400px', '280px'],
								skin: 'add_label_bg',
								offset: 'auto',
								shade: [0.8, '#393D49'],
								content: '<div style="text-align: center;height:100%;line-height:230px;">确定要删除该条记录？</div>',
								btn: ['确定', '取消']
								,yes: function() {
									$.ajax({
										url:'${pageContext.request.contextPath}/recordedTable/deleteBox?l='+Math.random(),
										data:"boxId="+boxId,
										type:'post',
										dataType:'json',
										success:function(result){
											if(result){
												obj.del();
								      		    layer.closeAll();
								      		    layer.msg("盒子信息删除成功")
											}else{
												layer.closeAll();
												layer.msg("盒子删除失败")
											}
										},
										error:function(){
											layer.msg("接口异常")
										}
									})
								},
								btn2: function() {
									layer.closeAll();
								}
							})
						}
					}
				});
				//select筛选方法
				form.on('select',function(data){
					var pcId=$("#pc").val();
					var anual=$("#anual").val();
					var start=$("#start").val();
					table.reload('description_tabel', {
						  url: "${pageContext.request.contextPath}/recordedTable/havingAmCoBoxBySelect?timestamp="+Math.random()
						  ,where: {pcId:pcId,anual:anual,start:start} //设定异步数据接口的额外参数
						  //,height: 300
						  ,method:'post',
					});
					$.ajax({
						url:'${pageContext.request.contextPath}/recordedTable/havingFileAmCoBoxBySelect?l='+Math.random(),
						data:{"pcId":pcId,"anual":anual,"start":start},
						type:'post',
						dataType:'json',
						success:function(num){
							$("#boxNum").text(num.boxNum);
							$("#fileNum").text(num.fileNum);
						},
						error:function(){
							layer.msg("下标数量更新失败")
						}
					})
				});
				//查询方法
				var $ = layui.$, active ={
					queryBox:function(){
						var condition=$("#condition").val();
						table.reload('description_tabel', {
							  url: "${pageContext.request.contextPath}/recordedTable/havingAmCoBoxByCondition?timestamp="+Math.random()
							  ,where: {condition:condition} //设定异步数据接口的额外参数
							  //,height: 300
							  ,method:'post',
						});
						$.ajax({
							url:'${pageContext.request.contextPath}/recordedTable/havingFileAmCoBoxByCondition?l='+Math.random(),
							data:{"condition":condition},
							type:'post',
							dataType:'json',
							success:function(num){
								$("#boxNum").text(num.boxNum);
								$("#fileNum").text(num.fileNum);
							},
							error:function(){
								layer.msg("下标数量更新失败")
							}
						})
					},
					join:function(){
						var checkStatus = table.checkStatus('description_tabel');
						if(checkStatus.data.length>0){
							var arr=checkStatus.data;
							var str="";
							var index="all";
							for(j = 0,len=arr.length; j < len; j++) {
								if(arr[j].boxBoxingStart=='2'){
									str+=arr[j].boxid+","
								}else{
									index="some"
								}
							}
							if(str.length>0){
								$.ajax({
									url:'${pageContext.request.contextPath}/recordedTable/updateBoxStart?l='+Math.random(),
									data:"str="+str,
									type:'post',
									dataType:'json',
									success:function(res){
										if(res){
											if(index!='some'){
												layer.msg('已提交进馆',{time:1500,offset: 'auto',anim: 1},function(){
													window.location.reload()
												});
											}else{
												layer.msg("请注意只允许提交已装盒盒子!!!",{time:3000,offset: 'auto',anim: 1},function(){
													window.location.reload();
												})
											}
										}else{
											layer.msg("提交进馆失败")
										}
									},
									error:function(){
										layer.msg("接口异常")
									}
								})
							}else{
								layer.msg("只允许提交已装盒盒子")
							}
						}else{
							layer.msg("选择提交的盒子")
						}
						
					},
					addFile:function(){
						var checkStatus = table.checkStatus('description_tabel');
						var num=checkStatus.data.length;
						if(num==0){
							layer.msg("请选择文件")
						}else if(num>1){
							layer.msg("不允许多选")
						}else{
							var boxStart=checkStatus.data[0].boxstatus;
							if(boxStart=='2'){
								layer.msg("已进馆档案不允许补充盒内文件")
							}else if(boxStart=='4'){
								var boxId=checkStatus.data[0].boxid;
								window.location.href="${pageContext.request.contextPath}/recodedEdit/goSupplement?boxId="+boxId;
							}
						}
					}
				}
				$('.layui-col-md3 .layui-btn-normal').on('click', function(){
				    var type = $(this).data('type');
				    active[type] ? active[type].call(this) : '';
				});
				$('#infor .layui-btn-normal').on('click', function(){
				    var type = $(this).data('type');
				    active[type] ? active[type].call(this) : '';
				});
			});

			function img_vi() {
				$('.Scanning_Images').viewer();
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
		<script type="text/html" id="boxBoxingStart">
			{{#  if(d.boxBoxingStart == '1'){  }}未装盒
			{{#  } else if(d.boxBoxingStart == '2'){ }}已装盒
			{{#  }  }}
		</script>
		<script type="text/html" id="boxstatus">
			{{#  if(d.boxstatus == '4'){  }}未进馆
			{{#  } else if(d.boxstatus == '2'){ }}已进馆
			{{#  }  }}
		</script>
	</body>

</html>