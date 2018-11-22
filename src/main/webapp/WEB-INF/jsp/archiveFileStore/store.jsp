<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<%
	response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
	response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 
	response.setHeader("Pragma","No-cache"); 
	response.setDateHeader("Expires", 0);
%>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="pragma" content="no-cache"> 
     	<meta http-equiv="cache-control" content="no-cache"> 
    	<meta http-equiv="expires" content="0"> 
		<title>档案收集整理系统_档案存储</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="../layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="../font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="../css/archives-collection.css" />
		<!--css版本  -->
		<link rel="stylesheet" type="text/css" href="../css/store.css">
		<!-- 图片预览 -->
		<link rel="stylesheet" type="text/css" href="../css/viewer.min.css">
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
						<span class="logo_img"><img src="../imgs/home.gif" width="110" height="50"/></span>
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
						<li class="layui-nav-item layui-this">
							<c:if test="${zm:buttenPremission('ab',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/archiveFileStore/goStore?meng=<%=Math.random() %>">档案存储</a>
							</c:if>
						</li>
						<li class="layui-nav-item layui-hide-xs">
							<c:if test="${zm:buttenPremission('ae',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/knowledgeBase/goIdentification?currentPage=1&meng=<%=Math.random() %>">档案整理</a>
							</c:if>
						</li>
						<li class="layui-nav-item layui-hide-xs">
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
					 			<form class="layui-form inline">
					 				<label for="" class="inline">档案年度</label>
									<div class="layui-form-item inline" >
									<select name="city1" lay-filter="city1" id="city1">
										<option value="">请选择</option>
										<c:forEach items="${anualList }" var="anual">
											<option value="${anual.anual }">${anual.anual }</option>
										</c:forEach>
									</select>
									</div>
								</form>
					 		</div> 
							<div id="btn" style="float: right;padding-right: 20px;">
								<c:if test="${zm:buttenPremission('aba',sessionScope.user.role.authorities) }">
									<div class="layui-input-inline">
										<input type="tel" name="phone" id="condition" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入关键字查询" />
									</div>
									<button class="layui-btn" data-type="query">查询</button>
								</c:if>
							</div>
						</div>
						<div style="padding:0px 15px;">
							<table class="layui-hide" id="demo" lay-filter="demo"></table>
						</div>
						<script type="text/html" id="barDemo">
							<c:if test="${zm:buttenPremission('abb',sessionScope.user.role.authorities) }">
								<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
							</c:if>
							<c:if test="${zm:buttenPremission('abc',sessionScope.user.role.authorities) }">
								<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
							</c:if>
						</script>
						<div id="but" style="margin: 18px 15px;">
							<label for="">档案合计：</label><span id="count">${count }</span>件&nbsp;<span id="pages">${pages }</span>页
							<c:if test="${zm:buttenPremission('abd',sessionScope.user.role.authorities) }">
								<button class="layui-btn layui-btn-danger" style="margin-left: 20px;" data-type="deleteFile">删除</button>
							</c:if>
							<c:if test="${zm:buttenPremission('abe',sessionScope.user.role.authorities) }">
								<button class="layui-btn" data-type="joinFile">提交整理</button>
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
		<script>
			layui.use('table', function() {
				var table = layui.table;
				var laypage = layui.laypage;
				//展示已知数据
				table.render({
					elem: '#demo',
					url:"/filemanage/archiveFileStore/havingArchiveFile?meng="+<%=Math.random() %>,
					cols: [
						[ //标题栏
							{	
								type: 'checkbox',
								fixed: 'left',
							},
							{ 	type: 'numbers', 
								title: '序号' 
							}, {
								field: 'archiveFileResponsible',
								title: '责任者',
								minWidth: 220,
								unresize: 'false',
							}, {
								field: 'archiveFileCreatetime',
								title: '日期',
								width: 150,
								unresize: 'false',
								sort: true
							}, {
								field: 'archiveFileAnual',
								title: '年度',
								width: 100,
								unresize: 'false',
							}, {
								field: 'archiveFileReferenceNumber',
								title: '文号',
								width: 200,
								unresize: 'false',
							},
							{
								field: 'archiveFileTitle',
								title: '题名',
								minWidth: 200,
								unresize: 'false',
							},
							{
								field: 'archiveFilePages',
								title: '页数',
								width: 100,
								unresize: 'false',
							},
							{
								field: 'archiveFileScanpople',
								title: '扫描人',
								width: 100,
								unresize: 'false',
							},
							{
								field: 'archiveFileScanDate',
								title: '扫描日期',
								width: 150,
								unresize: 'false',
								toolbar:'#scanTime',
							},
							{
								field: 'archiveFileFinishingStatus',
								title: '状态',
								width: 100,
								toolbar:'#fileStart',
								unresize: 'false',
							},
							{
								field: 'right',
								title: '操作',
								width: 150,
								unresize: 'false',
								toolbar: '#barDemo',
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
				//监听工具条
				table.on('tool(demo)', function(obj) {
					var archiveFileId = obj.data.archiveFileId;
					var tr = obj.tr;

					if(obj.event === 'detail') {
						$.ajax({
							url:"${pageContext.request.contextPath}/archiveFileStore/havingFileAttachmentList?meng="+<%=Math.random() %>,
							type:"post",
							data:"archiveFileId="+archiveFileId,
							dataType:"json",
							success:function(result){
								var text=""
								text+="<div class='add_lb1'><ul class='Scanning_Images' onclick='img_vi()''>"
								for(var i=0;i<result.length;i++){
									var url='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'+result[i].fileAttachmentPath;
									text+="<li><img src='"+url+"?"+Math.random()+"' alt=''><p>"+result[i].fileAttachmentPageNumber+"</p></li>"
								}
								text+="</ul></div>";
								
								layer.open({
									type: 1,
									title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
									area: ['800px', '400px'],
									skin: 'add_label_bg',
									offset: 'auto',
									shade: [0.8, '#393D49'],
									content: text,
								});
							}
						})
						
					}else if(obj.event === 'edit'){
						var archiveFileFinishingStatus = obj.data.archiveFileFinishingStatus;
						if(archiveFileFinishingStatus!='1'){
							layer.msg("非待整理文件不可编辑~~~~~~~~~~")
						}else{
							window.location.href="${pageContext.request.contextPath}/archiveFileStoreModify/goArchiveFileStoreEdit?archiveFileId="+archiveFileId+"&meng="+<%=Math.random() %>;
						}
					}
				});
				
				//监听多选框的内容
				table.on('checkbox(demo)', function(obj){
					 console.log(obj)
				});
				
				//事件
				var $ = layui.$, active ={
					deleteFile:function(){
						var checkStatus = table.checkStatus('demo')
						,data = checkStatus.data;
						var x=JSON.stringify(data);
						var y=JSON.parse(x);
						var str="";
						var anual=$("#city1").val();
						if(anual!=""){
							if(y.length>0){
								for(var i=0;i<y.length;i++){
									if(y[i].archiveFileFinishingStatus == 1){
										str+=y[i].archiveFileId+","	
									}
								}
								if(str.length>0){
									layer.confirm('是否删除这'+data.length+'条数据',{icon:3,title:'提示'},function(index){
										layer.closeAll();
										$.ajax({
											url:"${pageContext.request.contextPath}/archiveFileStore/deleteFile?meng="+<%=Math.random() %>,
											type:"post",
											data:"fileId="+str,
											dataType:"json",
											success:function(result){
												if(result){
													layer.msg("删除成功",{setoff:'auto',anim: 1,time:1500},function(){
														table.reload('demo',{
															url: "${pageContext.request.contextPath}/archiveFileStore/havingArchiveFileByAnual?meng="+<%=new Date().getTime() %>,
															where:{anual:anual}
														});
														$.ajax({
															url:"${pageContext.request.contextPath}/archiveFileStore/anual?meng="+<%=Math.random() %>,
															type:"get",
															data:"anual="+anual,
															dataType:"json",
															success:function(num){
																$("#count").html(num.archiveFileNumber);
																$("#pages").html(num.archiveFilePage);
															},
															error:function(){
																layer.msg("发生未知错误请联系管理员")
															}
														})
													})
												}else{
													layer.msg("删除失败")
												}
											},
											error:function(){
												layer.msg("删除失败")
											}
										})
										
									})
									
								}else{
									layer.msg("非待整理的文件不允许删除")
								}
							}else{
								layer.alert("请选择删除的数据")
							}
						}else{
							layer.msg("选择年度删除数据")	
						}
					},
					joinFile: function(){
						var checkStatus = table.checkStatus('demo')
						,data = checkStatus.data;
						var x=JSON.stringify(data);
						var y=JSON.parse(x);
						var anual=$("#city1").val();
						var str="";
						if(anual!=""){
							var list=table.cache.demo;//获取边个中的所有内容
							var m=0;
							var n=0;
							var str="";
							for(var i=0;i<list.length;i++){
								if(list[i].archiveFileFinishingStatus!='1'){
									m++;
								}else{
									n++;
									str+=list[i].archiveFileId+","
								}
							}
							if(m==list.length){
								layer.msg("本年度已全部提交，无需重复提交")
							}else if(n==list.length){
								$.ajax({
									url:"${pageContext.request.contextPath}/archiveFileStore/updateStart?meng="+<%=Math.random() %>,
									type:"post",
									data:"anual="+anual,
									dataType:"json",
									success:function(result){
										if(result){
											layer.msg("文件已提交成功",{setoff:'auto',anim: 1},function(){
												table.reload('demo',{
													url: "${pageContext.request.contextPath}/archiveFileStore/havingArchiveFileByAnual?meng="+<%=new Date().getTime() %>,
													where:{anual:anual}
												});
											})
										}else{
											layer.msg("提交失败")
										}
									},
									error:function(){
										layer.msg("提交失败")
									}
								})
							}else{
								$.ajax({
									url:"${pageContext.request.contextPath}/archiveFileStore/updateArchiveFileStartById?meng="+<%=Math.random() %>,
									type:"post",
									data:"str="+str,
									dataType:"json",
									success:function(result){
										if(result){
											layer.msg("文件已提交成功",{time:'1500',anim: 1},function(){
												table.reload('demo',{
													url: "${pageContext.request.contextPath}/archiveFileStore/havingArchiveFileByAnual?meng="+<%=new Date().getTime() %>,
													where:{anual:anual}
												});
											})
										}else{
											layer.msg("提交失败")
										}
									},
									error:function(){
										layer.msg("提交失败")
									}
								})
							}
						}else{
							layer.msg("选择年度提交数据")	
						}
					},
					query:function(){
						var condition=$("#condition").val();
						var anual=$("#city1").val();
						table.reload('demo', {
							  url: "${pageContext.request.contextPath}/archiveFileStore/queryCondition?meng="+<%=Math.random() %>
							  ,where: {condition:condition,anual:anual} //设定异步数据接口的额外参数
							  //,height: 300
						});
						$.ajax({
							url:"${pageContext.request.contextPath}/archiveFileStore/queryConditionNum?meng="+<%=Math.random() %>,
							data:{"condition":condition,"anual":anual},
							type:"get",
							dataType:"json",
							success:function(num){
								$("#count").html(num.archiveFileNumber);
								$("#pages").html(num.archiveFilePage);
							},
							error:function(){
								layer.msg("发生未知错误请联系管理员")
							}
						})
					}
				}
				
				
				$('#but .layui-btn').on('click', function(){
				    var type = $(this).data('type');
				    active[type] ? active[type].call(this) : '';
				});
				$('#btn .layui-btn').on('click', function(){
				    var type = $(this).data('type');
				    active[type] ? active[type].call(this) : '';
				});
				
				layui.use('form', function(){
					var form = layui.form;
					 form.on('select(city1)', function(data){
						 var anual=data.value;
						 if(anual==""){//年度为空是展示所有的数据
							 table.reload('demo', {
								  url: "/filemanage/archiveFileStore/havingArchiveFile?meng="+<%=Math.random() %>
								  ,where: {} //设定异步数据接口的额外参数
								  //,height: 300
							});
						 	$.ajax({
								url:"${pageContext.request.contextPath}/archiveFileStore/noAnual?meng="+<%=Math.random() %>,
								type:"get",
								dataType:"json",
								success:function(num){
									$("#count").html(num.archiveFileNumber);
									$("#pages").html(num.archiveFilePage);
								},
								error:function(){
									layer.msg("发生未知错误请联系管理员")
								}
							})
						 }else{
							 table.reload('demo', {
								  url: "${pageContext.request.contextPath}/archiveFileStore/havingArchiveFileByAnual?meng="+<%=new Date().getTime() %>
								  ,where: {anual:anual} //设定异步数据接口的额外参数
								  //,height: 300
							});
							$.ajax({
									url:"${pageContext.request.contextPath}/archiveFileStore/anual?meng="+<%=Math.random() %>,
									type:"get",
									data:"anual="+anual,
									dataType:"json",
									success:function(num){
										$("#count").html(num.archiveFileNumber);
										$("#pages").html(num.archiveFilePage);
									},
									error:function(){
										layer.msg("发生未知错误请联系管理员")
									}
							})
						 }
					 })
				})
				
				
				
			});

			function img_vi() {
				$('.Scanning_Images').viewer();
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
		<script type="text/html" id="indexTpl">
    		{{d.LAY_TABLE_INDEX+1}}
		</script>
		<script type="text/html" id="fileStart">
			{{#  if(d.archiveFileFinishingStatus == 1){  }}待整理
		 	{{#  } else if(d.archiveFileFinishingStatus == 2){ }}整理中
			{{#  } else if(d.archiveFileFinishingStatus == 3){ }}已整理
			{{#  }  }}
		</script>
		<script type="text/html" id="scanTime">
        	{{ dateForm(d.archiveFileScanDate)}}
    	</script>
	</body>

</html>