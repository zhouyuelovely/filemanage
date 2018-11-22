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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>档案收集整理系统_档案审核</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		
		<meta http-equiv="Expires" content="0">
        <meta http-equiv="kiben" content="no-cache">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css"/>
		<!-- 图片预览 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css">
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
		body .add_label_bg>.layui-layer-title,.btn_color{
			background: #EA5519;
			color: #FFFFFF;
		}

		.Scanning_Images{
				width: 100%;
				min-height: 400px;
				background: #FFFFFF;
			}
			.Scanning_Images li{
				float: left;
				width: 100px;
   				height: 150px;
   				background: #FFFFFF;
   				margin-left:28px ;
   				margin-top: 15px;
   				text-align: right;
   				box-shadow: 0.5px 1px 3px #000;
			}
			.Scanning_Images li img{
				width: 100%;
				height: 80%;
			}
			.Scanning_Images li button{
				border: none;
				outline: none;
				background: none;
				cursor: pointer;
			}
			.cor{
				color: #EA5519;
				font-weight: bold;
				text-align: center;
				padding: 30px 0;
			}
			
			.Scanning_Images li p{
				text-align: center;
			}
			
		.viewer-container,.viewer-fixed,.viewer-fade,.viewer-transition,.viewer-in{
			z-index: 99999999999!important;
			/*弹出层查看图片优先级提升*/
		}
		
		.btn-a{
			text-align: center;
			background: none;
			border: 1px solid #000;
			display: inline-block;
			padding: 10px;
			border-radius: 5px;
			margin: 3px;
		}
		.btn-a:hover{
			color: #EA5519;
			border: 1px solid #EA5519;
		}
		/*状态栏颜色*/
		.laytable-cell-1-BOX_AUDITSTART{
			color: #ff9700;
		}
		/*查看弹出层*/
			
			.look-list li {
				list-style-type: none;
				float: left;
				margin: 30px;
				background: #EA5519;
				color: #FFFFFF;
				padding: 5px;
				width: 120px;
				text-align: center;
			}
			
			.table_title {
				height: 20px;
				width: 100%;
			}
			
			.table_title li {
				float: left;
				margin-left: 150px;
				font-weight: bold;
			}
	</style>
</head>
<body class="layui-layout-body">
		<div >
			<div class="layui-layout layui-layout-admin">

				<!--class 个性化设置nav_bg1-->
				<div class="copy">
					<!-- 版权所有 -->
					<p>COPYRIGHT&nbsp;&copy;2018<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有</p>
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
						</li>
						<li class="layui-nav-item">
							<c:if test="${zm:buttenPremission('ab',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/archiveFileStore/goStore?meng=<%=Math.random() %>">档案存储</a>
							</c:if>
						</li>
						<li class="layui-nav-item">
							<c:if test="${zm:buttenPremission('ae',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/knowledgeBase/goIdentification?currentPage=1&meng=<%=Math.random() %>">档案整理</a>
							</c:if>
						</li>
						<li class="layui-nav-item">
							<c:if test="${zm:buttenPremission('af',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/boxSubmitReview/goBoxReview?meng=<%=Math.random() %>">档案送审</a>
							</c:if>
						</li>
						<li class="layui-nav-item layui-this">
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
					 		<form class="layui-form inline">
						 		<div class="layui-form inline">
						 			<label for="" class="inline">全宗名称</label>
									<div class="layui-form-item inline" >
										<select class="select" name="city1" lay-filter="city1" data-type="arch" id="city1">
											<option value="">请选择</option>
											<c:forEach items="${archiveInfo }" var="arc">
												<option value="${arc.quanzongId}">${arc.quangzongName }</option>
											</c:forEach>
										</select>
									</div>
								</div>
						 		<div class="layui-form inline">
						 			<label for="" class="inline">档案年度</label>
									<div class="layui-form-item inline" >
										<select name="city2" lay-filter="city2" class="select" id="city2">
											<option value="">请选择</option>
											
										</select>
									</div>
								</div>
					 		</form>
					 	</div> 
					 	<div id="meng" style="float: right;padding-right: 20px;">
					 	<c:if test="${zm:buttenPremission('aga',sessionScope.user.role.authorities) }">
					 		<div class="layui-input-inline">
					        	<input type="tel" name="conditions" lay-verify="required|phone" id="condition" autocomplete="off" class="layui-input" placeholder="请输入关键字查询" /> 
					     	 </div>
					     <button class="layui-btn layui-btn-normal" data-type="look">查询</button>
					 	
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
					<div id="btn" style="margin: 18px 15px;">
						<label for="">档案合计：</label><span id="boxNum">${pageInfo.boxNum }</span>盒&nbsp;<span id="fileNum">${pageInfo.fileNum }</span>件
						<c:if test="${zm:buttenPremission('agc',sessionScope.user.role.authorities) }">
						<button class="layui-btn layui-btn-sm layui-btn-danger file_boxes">驳回重整</button>
						</c:if>
						<c:if test="${zm:buttenPremission('agd',sessionScope.user.role.authorities) }">
						<button class="layui-btn layui-btn-sm" data-type="good">验收合格</button>
					</c:if>
					</div>	
						 
					</div>	
				</div>
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../layui/layui.all.js"></script>
		<script src="../layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!-- 图片预览插件 -->
		<script src="../js/viewer.min.js"></script>
	<!--	<script src="../js/audit.js" type="text/javascript" charset="utf-8"></script>-->
		<script>
			layui.use('table', function() {
						var table = layui.table;
					
						//展示已知数据
						table.render({
							elem: '#demo',
							url:"${pageContext.request.contextPath}/fileAudit/fileAuditList",
							cols: [
								[ //标题栏
									{
										type: 'checkbox',
										fixed: 'left'
									},
									{
										type: 'numbers', 
										title: '序号' 
									}, {
										field: 'quanzongNumber',
										title: '全宗号',
										width: 150,
										unresize: 'false',
										/* toolbar:'#quanzongNumber', */
									}, {
										field: 'quanzongName',
										title: '全宗名称',
										minWidth: 150,
										unresize: 'false',
										/* toolbar:'#quanzongName', */
									}, {
										field: 'boxAnual',
										title: '年度',
										width: 100,
										unresize: 'false',
									}, {
										field: 'scName',
										title: '机构(问题)',
										width: 150,
										unresize: 'false',
										/* toolbar:'#scName', */
									},
									{
										field: 'retentionperiodName',
										title: '保管期限',
										width: 100,
										unresize: 'false',
										/* toolbar:'#retentionperiodname', */
									},
									{
										field: 'boxStartnumber',
										title: '起件号',
										width: 100,
										unresize: 'false',
									},
									{
										field: 'boxEndnumber',
										title: '止件号',
										width: 100,
										unresize: 'false',
									},
									{
										field: 'boxNumber',
										title: '盒号',
										width: 100,
										unresize: 'false',
									},
									{
										field: 'boxThickness',
										title: '盒属性',
										width: 100,
										unresize: 'false',
									},
									{
										field: 'boxAuditstart',
										title: '状态',
										width: 100,
										unresize: 'false',
										toolbar:'#boxAuditstart',
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
							limit: 10 //每页默认显示的数量
						});
						console.log(table.render);
						//监听工具条
						table.on('checkbox(demo)', function(obj){
							  console.log(obj.checked); //当前是否选中状态
							  console.log(obj.data); //选中行的相关数据
							  console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
						});

						table.on('tool(demo)', function(obj) {
							var data = obj.data;
							var tr = obj.tr;
							var boxId=obj.data.boxId;
							 
							if(obj.event === 'detail') {
								//			      layer.msg('ID：'+ data.id + ' 的查看操作');
							var text="";
							$.ajax({
								url:"${pageContext.request.contextPath}/boxSubmitReview/havingAmCoBoxattachment"+"?timestamp="+Math.random(),
								data:"boxId="+boxId,
								type:"get",
								//解决缓存问题
								beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							    cache:false,
								dataType:"json",
								success:function(amCoBoxattachment){
									$.ajax({
										url:"${pageContext.request.contextPath}/boxSubmitReview/havingFileAttachment"+"?timestamp="+Math.random(),
										data:"boxId="+boxId,
										type:"get",
										//解决缓存问题
										beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
									    cache:false,
										dataType:"json",
										success:function(pageBean){
											
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
											layer.open({
														type: 1,
														title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
														area: ['800px', '460px'],
														skin: 'add_label_bg',
														offset: 'auto',
														shade: [0.8, '#393D49'],
														content:text
													});
													x();
												
													var $ = layui.$, active ={
															previous: function(){
																var currPage=$(this).attr("id")
																var cur=parseInt(currPage)-1;
																var home=$(this).attr("name")
																if(currPage!=home){
																	cont(cur,boxId)
																}else{
																	layer.msg("当前为第一页")
																}
															},
															next: function(){
																var currPage=$(this).attr("id")
																var cur=parseInt(currPage)+1;
																var last=$(this).attr("name")
																if(currPage!=last){
																	cont(cur,boxId);
																}else{
																	layer.msg("当前为最后一页")
																}
															},
															change: function(){
																var cur= parseInt($("#pages").val())
																cont(cur,boxId);
															}
													}
													
													$('.layui-clear .layui-btn').on('click', function(){
													    var type = $(this).data('type');
													    active[type] ? active[type].call(this) : '';
													});
													$('.layui-clear #pages').on('change', function(){
													    var type = $(this).data('type');
													    active[type] ? active[type].call(this) : '';
													});
													function cont(currPage,boxId){
														$.ajax({
															url:"${pageContext.request.contextPath}/boxSubmitReview/havingFileAttachment"+"?timestamp="+Math.random(),
															data:"boxId="+boxId+"&currentPage="+currPage,
															type:"get",
															//解决缓存问题
															beforeSend :function(xmlHttp){ 
														        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
														        xmlHttp.setRequestHeader("Cache-Control","no-cache");
														     },
														    cache:false,
															dataType:"json",
															success:function(pageBean){
																var list=pageBean.lists;
																$(".wenjian").attr("src","<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+list[0].fileAttachmentPath+"?"+Math.random());
																$(".wenjian").attr("src","<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+list[0].fileAttachmentPath+"?"+Math.random());
																$(".wenjian").attr("id",list[0].archiveFileId)
																$(".previous").attr("id",pageBean.currPage)
																$(".next").attr("id",pageBean.currPage)
																$("#pages").find("option[value='"+pageBean.currPage+"']").attr("selected","selected");
																
															},error:function(){
																layer.msg("请检查接口")
															}
															
														});
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
								
								$(function() {
									$('.imgs').viewer();
								})
								//查看文件列表
								$(function() {
									$(".wenjian").click(function() { //#btn为按钮id
										var archivefileid=$(".wenjian").attr("id")
										console.log(archivefileid)
										
										$.ajax({
											url:"${pageContext.request.contextPath}/boxSubmitReview/havingFileAttachmentByArchiveFileId"+"?timestamp="+Math.random(),
											data:"archivefileid="+archivefileid,
											type:"get",
											//解决缓存问题
											beforeSend :function(xmlHttp){ 
										        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
										        xmlHttp.setRequestHeader("Cache-Control","no-cache");
										     },
										    cache:false,
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
									$(".guidang").click(function() { //#btn为按钮id
										var boxId=$(".guidang").attr("id");
										$.ajax({
											url:"${pageContext.request.contextPath}/boxSubmitReview/havingAmCoBoxByBoxId"+"?timestamp="+Math.random(),
											data:"boxId="+boxId,
											type:"get",
											//解决缓存问题
											beforeSend :function(xmlHttp){ 
										        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
										        xmlHttp.setRequestHeader("Cache-Control","no-cache");
										     },
										    cache:false,
											dataType:"json",
											success:function(data){
												var text="";
												text=text+"<div style='padding: 15px;'>"
													text=text+"<ul class='table_title'>"
														text=text+"<li><label>期限：</label><span>"+data.retentionperiod.retentionperiodname+"</span></li>"
														text=text+"<li><label>分类：</label><span>"+data.secondryClassFication.scName+"</span></li>"
														text=text+"<li><label>盒号：</label><span>"+data.boxendnumber+"</span></li>"
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
												
												layui.use('table', function() {
													var table = layui.table;
													var boxId=$(".guidang").attr("id");
													//展示已知数据
													table.render({
														elem: '#guidang',
														url:"${pageContext.request.contextPath}/boxSubmitReview/havingArchiveFileByBoxId?boxId="+boxId+"&timestamp="+Math.random(),
														cols: [
															[ //标题栏
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
																	Width: 100,
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
														data: []
															//,skin: 'line' //表格风格
															,
														even: true,
														page: true //是否显示分页
															//,limits: [5, 7, 10]
															,
														limit: 12//每页默认显示的数量
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
								good:function(){
									var anual=$("#city2").val();
									var arcId=$("#city1").val();
									if(anual!=""&&arcId!=""){
										$.ajax({
											url:"${pageContext.request.contextPath}/fileAudit/good"+"?timestamp="+Math.random(),
											data:"anual="+anual+"&arcId="+arcId,
											type:"post",
											//解决缓存问题
											beforeSend :function(xmlHttp){ 
										        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
										        xmlHttp.setRequestHeader("Cache-Control","no-cache");
										     },
										    cache:false,
											dataType:"json",
											success:function(lock){
												if(lock==true){
													layer.msg("档案已验收通过！",{time:1500});
													setTimeout(function(){
														table.reload('demo',{url:"${pageContext.request.contextPath}/fileAudit/fileAuditList"});
													},1500)
												}else{
													layer.msg("未知错误")
												}
											},error:function(){
												layer.msg("接口出错")
											}
										})
									}else{
										layer.msg("选择全宗和年度")
									}
									
								},
								look:function(){
									var anual=$("#city2").val();
									var arcId=$("#city1").val();
									var condition=$("#condition").val();
									table.reload('demo', {
										  url: '${pageContext.request.contextPath}/fileAudit/reloadCondition'+"?timestamp="+Math.random()
										  ,where: {anual:anual,arcId:arcId,condition:condition} //设定异步数据接口的额外参数
										  //,height: 300
									});
									$.ajax({
										url:"${pageContext.request.contextPath}/fileAudit/reloadCPageInfo"+"?timestamp="+Math.random(),
										data:"anual="+anual+"&arcId="+arcId+"&condition="+condition,
										type:"get",
										//解决缓存问题
										beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
									    cache:false,
										dataType:"json",
										success:function(page){
											$("#boxNum").text("");
											$("#boxNum").text(page.boxNum);
											$("#fileNum").text("")
											$("#fileNum").text(page.fileNum);
										},
										error:function(){
											layer.msg("接口异常")
										}
									})
									
								}
								
						}
						
						$('#btn .layui-btn').on('click', function(){
						    var type = $(this).data('type');
						    active[type] ? active[type].call(this) : '';
						});
						$('#meng .layui-btn').on('click', function(){
						    var type = $(this).data('type');
						    active[type] ? active[type].call(this) : '';
						});
						
						layui.use('form', function(){
							 var form = layui.form;
							 form.on('select(city1)', function(data){
								 var arcId=data.value;
								 $.ajax({
									 url:"${pageContext.request.contextPath}/fileAudit/havingAnual"+"?timestamp="+Math.random(),
									 data:"arcId="+arcId,
									 type:"get",
									 //解决缓存问题
									 beforeSend :function(xmlHttp){
										 xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									     xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
									    cache:false,
									 dataType:"JSON",
									 success:function(data){
										 $("#city2").find("option:gt(0)").remove();
										 $.each(data,function(key,val){
											 var option=$("<option>").val(val.anual).text(val.anual);
											 $("#city2").append(option);
					                          form.render('select');
										 })
									 },
									 error:function(){
										 layer.msg("接口异常")
									 }
								 })
							 });
							 form.on('select(city2)',function(data){
								 var anual=data.value;
								 var arcId=$("#city1").val();
								 table.reload('demo', {
									  url: '${pageContext.request.contextPath}/fileAudit/reloadHavingBox'
									  ,where: {anual:anual,arcId:arcId} //设定异步数据接口的额外参数
									  //,height: 300
								});
								$.ajax({
									url:"${pageContext.request.contextPath}/fileAudit/reloadPageInfo"+"?timestamp="+Math.random(),
									data:"anual="+anual+"&arcId="+arcId,
									type:"get",
									//解决缓存问题
									beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
								    cache:false,
									dataType:"json",
									success:function(page){
										$("#boxNum").text("");
										$("#boxNum").text(page.boxNum);
										$("#fileNum").text("")
										$("#fileNum").text(page.fileNum);	
									},
									error:function(){
										layer.msg("接口异常")
									}
								})
							 });
						})
						
						
					});
					
					function img_vi() {
						$('.Scanning_Images').viewer();
					}
					
					$(function() {
						$(".file_boxes").click(function() { //#btn为按钮id
							
							layui.use('table', function() {
								var table = layui.table;
								var checkStatus = table.checkStatus('demo')
								,data = checkStatus.data;
								var x=JSON.stringify(data);
								var y=JSON.parse(x);
								var str="";
								
								if(y.length>0){
									var anual=$("#city2").val();
									var arcId=$("#city1").val();
									if(anual != "" && arcId != ""){
										for(var i=0;i<y.length;i++){
											str+=y[i].boxId+","	
										}
										$.ajax({
											url:"${pageContext.request.contextPath}/fileAudit/addReturn"+"?timestamp="+Math.random(),
											data:"str="+str,
											type:"post",
											//解决缓存问题
											beforeSend :function(xmlHttp){ 
										        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
										        xmlHttp.setRequestHeader("Cache-Control","no-cache");
										     },
										    cache:false,
											dataType:"json",
											success:function(data){
												if(data=true){
													layer.open({
														type: 1,
														title: '<i class="fa fa-bars" style="padding:0 5px"></i>驳回重整',
														area: ['800px', '600px'],
														skin: 'add_label_bg',
														offset: 'auto',
														shade: [0.8, '#393D49'],
														content: '<div style="padding: 15px;text-align: center;"><label style="font-weight: bold;">验收情况表</label><table class="layui-hide" id="text" lay-filter="text"></table> </div><div id="m" style="text-align: center;margin:5px;"><button class="layui-btn btn_color" data-type="bad">确定</button></div><div class="cor"><span>提示:驳回后数据将被打回,审核界面将置空!</span></div></form>'
													});
													
													//展示已知数据
													table.render({
														elem: '#text',
														url:"${pageContext.request.contextPath}/fileAudit/havingReturnInfo?archiveId="+arcId+"&anual="+anual,
														cols: [
															[ //标题栏
																{
																	field: 'boxsericalnumber',
																	title: '抽查盒编号',
																	width: 200,
																	unresize: 'false',
																	/* toolbar:"#boxNum", */
																}, {
																	field: 'returnInfoReason',
																	title: '存在问题',
																	minwidth: 200,
																	unresize: 'false',
																	edit: 'text',
																}
										
															]
														],
														data: [{
																	"audit-id": "021-2017-Y-1",
																	"audit-number": "请点击编辑",
																	
																}
															]
															//,skin: 'line' //表格风格
															,
														even: true,
														page: false //是否显示分页
															//,limits: [5, 7, 10]
															,
														limit: 20 //每页默认显示的数量
													});
													var $ = layui.$, active ={
														bad:function(){
															var anual=$("#city2").val();
															var arcId=$("#city1").val();
															/* var boxNumb = $("#boxNumb").val(); */
															var list=table.cache.text;
															var lock=true;
															for(var i=0;i<list.length;i++){
																var returnInfoId=list[i].returnInfoId;
																var returnInfoReason=list[i].returnInfoReason;
																if(returnInfoReason==null){
																	layer.msg("请填写驳回理由")
																}else{
																	$.ajax({
																		url:"${pageContext.request.contextPath}/fileAudit/addReturnInfoReason"+"?timestamp="+Math.random(),
																		data:"returnInfoId="+returnInfoId+"&returnInfoReason="+returnInfoReason,
																		type:"post",
																		//解决缓存问题
																		beforeSend :function(xmlHttp){ 
																	        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
																	        xmlHttp.setRequestHeader("Cache-Control","no-cache");
																	     },
																	    cache:false,
																		dataType:"json",
																		success:function(data){
																			if(data){
																				lock=data;
																				console.log(data+":"+lock);
																			}else{
																				layer.msg("请及时查看驳回情况表")
																			}
																			layer.closeAll();
																		},error:function(){
																			layer.msg("发生未知错误")
																		}
																	})
																}
															}
															if(lock){
																$.ajax({
																	url:"${pageContext.request.contextPath}/fileAudit/updateBad"+"?timestamp="+Math.random(),
																	data:"anual="+anual+"&arcId="+arcId,
																	type:"post",
																	//解决缓存问题
																	beforeSend :function(xmlHttp){
																        xmlHttp.setRequestHeader("If-Modified-Since","0");
																        xmlHttp.setRequestHeader("Cache-Control","no-cache");
																     },
																    cache:false,
																	dataType:"json",
																	success:function(data){
																		if(data==true){
																			layer.msg("档案已驳回成功！",{time:4000});
																			setTimeout(function(){
																				table.reload('demo', {
																					  url: '${pageContext.request.contextPath}/fileAudit/fileAuditList'
																					  ,where: {} //设定异步数据接口的额外参数
																				});  //,height: 300
																			},1500)
																		}
																	}
																})
															}else{
																layer.msg("请检查驳回情况表")
															}
														}	
													}
													$('#m .layui-btn').on('click', function(){
													    var type = $(this).data('type');
													    active[type] ? active[type].call(this) : '';
													});
												}else{
													layer.msg("发生未知错误")
												}
											}
										})	
									}else{
										layer.msg("请选择全宗和年度")
									}
								}else{
									layer.msg("请勾选相关盒")
								}
								
								
								
							
							});
						})
					})
		
		</script>
		 
		<!--<script type="text/html" id="boxNum">
				{{d.boxsericalnumber}}
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
		 -->
		<script type="text/html" id="boxAuditstart">
				{{#  if(d.boxAuditstart == 0){  }}未审核
		 		{{#  } else if(d.boxAuditstart == 1){ }}已审核
				{{#  } else if(d.boxAuditstart == 2){ }}已驳回
				{{#  }  }}
			</script>
	</body>
</html>