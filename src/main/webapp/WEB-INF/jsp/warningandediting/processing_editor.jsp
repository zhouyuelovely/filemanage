<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>档案编研_加工编辑</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css" />
		<link href="${pageContext.request.contextPath}/css/skin_01.css" rel="stylesheet" type="text/css" id="skin">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/scaning.css" />
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
		<style type="text/css">
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
			}
			.nav-list-a li{
				text-indent: 1em;
				padding: 10px 0;
			}
			.span-p{
				color: #000000;
				font-weight: bold;
				padding: 10px;
			}
			.layui-form-select dl{
				z-index: 1001;
			}
			#edui1{
				width: 100%;
			}
			.btn_wa{
				padding: 15px;
				text-align: right;
			}
			.viewer-container,
			.viewer-fixed,
			.viewer-fade,
			.viewer-transition,
			.viewer-in {
				z-index: 99999999999!important;
				/*弹出层查看图片优先级提升*/
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
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
						<c:if test="${zm:buttenPremission('ka',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
							 	<a href="${pageContext.request.contextPath}/editingFile/goBianYan">编研成果</a>
							</li><span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('kb',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/editingFile/goBianJi">加工编辑</a>
							</li>
						</c:if>
						
					</ul>
				</div>

				<!-- 主体内容 开始-->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-fluid">
						<div class="layui-row layui-col-space15">
							<div class="layui-col-md3">
								<div class="">
									<div class="layui-card" style="padding-bottom:19px;">
										<div class="layui-card-header">
											<div id="" style="padding: 15px 0;">
												<div class="layui-col-md9 layui-inline" style="margin-top: 3px;">
													<input type="text"  id="searchBody" name="searchBody" placeholder="请输入关键词" autocomplete="off" class="layui-input">
												</div>
												<div class="layui-col-md3 layui-inline">
												<c:if test="${zm:buttenPremission('kba',sessionScope.user.role.authorities) }">
													<button class="layui-btn layui-btn-normal" style="padding: 0 28px;" id="fileConditionsBtn">搜索</button>
												</c:if>
												</div>
											</div>
										</div>
										<div class="layui-card-body" id="laybodt" style="margin-top:15px;height:565px;overflow:auto;">
											<ul class="nav-list-a">
												<c:forEach items="${listFile}" var="editing">
													<li>
													<input type="hidden" class="archiveFileId" value="${editing.archivefileid}"/>
													<a href="#" class="edito"  >${editing.archivefiletitle}</a>
													<span class="span-p"  >${editing.archivefilecreatetime}</span>
													</li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="layui-col-md9">
								<div class="layui-card">
								   
									<div class="layui-card-header">
										<div class="layui-form" style="padding: 15px 0;">
										   <form  class="layui-form">
											<div class="layui-col-md9">
												<div class="layui-form-item">
												    <label class="layui-form-label">主题</label>
												    <div class="layui-input-block">
												      <input type="text" name="editingTitle" required  lay-verify="required" placeholder="请输入主题" autocomplete="off" class="layui-input" id="title">
												    </div>
 												 </div>
											</div>
											<div class="layui-col-md3">
												<div class="layui-form-item">
												    <label class="layui-form-label">编研类型</label>
												    <div class="layui-input-block  layui-form"  lay-filter="selFilter">
												     <select id="editingTypeName" name="editingTypeName">
														<option value="">编研类型</option>
														<c:forEach items="${editingTypeNameList}" var="editing">
														<option value="${editing.editingTypeName}" name="${editing.editingType}">${editing.editingTypeName}</option>
														</c:forEach>
												</select>
												    </div>
												 </div>
											</div>
											</form>
										</div>
									</div>
									<div class="layui-card-body" style="margin-top: 15px;">
										<div id="editor" style="width: 100%;">
										<textarea id="container" name="editingController"  type="text/plain"  ></textarea>
									   </div>
										<div class="btn_wa">
											<button class="layui-btn layui-bg-red" id="successBtn">完成</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 主体内容结束-->
			</div>
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/viewer.min.js" type="text/javascript" charset="utf-8"></script>
		<!--富文本编辑器-->
		<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/loginout.js" type="text/javascript" charset="utf-8"></script>
		
		<!--[if IE 6]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script>
			
		   $(".edito").click(function() {
              //获取文件ID
			   var archiveFileId=$(this.parentElement.childNodes[1]).val();
			   select(archiveFileId);		 
		   });
		   function img_vi() {
				$('.Scanning_Images').viewer();
			}
		   var select = function (archiveFileId){
			   $.ajax({
					url:"${pageContext.request.contextPath}/archiveFileStore/havingFileAttachmentList?meng="+<%=Math.random() %>,
					type:"post",
					data:"archiveFileId="+archiveFileId,
					dataType:"json",
					success:function(result){
						var text=""
						text+="<div class='add_lb1'><ul class='Scanning_Images' onclick='img_vi()'>"
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
				img_vi();		
		   }
		   
	
		  
		//关键词查询件信息
			$("#fileConditionsBtn").click(function(){
				var searchBody=$("#searchBody").val();
				   $.ajax({
						  url:"${pageContext.request.contextPath}/editingFile/selectFuzzyEditingFileTitle"+"?timestamp="+Math.random(),
						  type:"post",
							 beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							 data:{"searchBody":searchBody},
							 dataType:"json",
							 cache:false,
							 success:function(data){
								 $("#laybodt").empty();
								 for (var i = 0; i < data.length; i++) {
									 var ulLIst  = "<ul class='nav-list-a'>"
									 					+"<li><input type='hidden' class='archiveFileId' value='"+data[i].archivefileid+"'/>"
									 					+"<a href='#' class='edito'  >"+data[i].archivefiletitle+"</a>"
									 					+"<span class='span-p'  >"+data[i].archivefilecreatetime+"</span></li></ul>";	
									 $("#laybodt").append(ulLIst);
								}
								 console.log(data);
							 },
							 error:function(data){
								 console.log(data);
							 }
					  });
		       });
		
		//点击完成
	  
		
		$(document).ready(function(){
			var editor = new baidu.editor.ui.Editor({initialFrameHeight:400,autoHeightEnabled: false,});
			editor.render('container');
			 var editingTitle = $("#title");
				var editingTypeName = $("#editingTypeName");
				var editingController = $("#container");
					var thisUrl = document.URL;
					var editingId = thisUrl.split("=")[1];
					console.log(editingId);
				   $.ajax({
					  url:"${pageContext.request.contextPath}/editingFile/selectEditingFileBody",
					  type:"post",
						 beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
						 data:{"editingId":editingId},
						 dataType:"json",
						 cache:false,
						 success:function(data){
							 console.log(data);
							 editingTitle.val(data.editingTitle);
							 editingTypeName.val(data.editingTypeName);
							 console.log(data.editingTypeName);
							 layui.use('form',function(){
								 var form=layui.form; 
								 form.render('select','selFilter');
							 })
						
							 editor.ready(function() { 
									editor.setContent(data.editingController); 
							}); 
						 },
						 error:function(data){
							 console.log(data);
						 },
				    }); 
			
			
			$("#successBtn").click(function(){
				var date=new Date();
		    	var year=date.getFullYear(); //获取当前年份
		    	var mon=date.getMonth()+1; //获取当前月份
		    	var da=date.getDate(); //获取当前日
		    	 var editingDate=year+"-"+mon+"-"+da;
					var editingTypeName = $("#editingTypeName").val();
					var editingTitle =$("#title").val();
					var editingAuthor ="${user.userName}";
					var editingController=UE.getEditor('container').getContent();
					  console.log(editingController);
					 if(editingTypeName==""||editingTypeName==null){
			    		 layer.msg("请选择编研类型!");
			    	 }else if(editingTitle==""||editingTitle==null){
			    		 layer.msg("主题不能为空!");
			    	 }else if(editingController==""||editingController==null){
			    		 layer.msg("请输入内容!");
			    	 }else if(editingId=="" ||editingId==null){
					      $.ajax({
							  url:"${pageContext.request.contextPath}/editingFile/insertEditingFile"+"?timestamp="+Math.random(),
							  type:"post",
								 beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
								 data:{"editingTypeName":editingTypeName,"editingDate":editingDate,"editingTitle":editingTitle,"editingAuthor":editingAuthor,"editingController":editingController},
								 dataType:"json",
								 cache:false,
								 async:false,
								 success:function(result){
									 if(result==1){
										 layer.msg("添加成功!",{offset:'auto',time:1500},function(){
											 window.location.href="${pageContext.request.contextPath}/editingFile/goBianYan";
											 window.opener.location.reload();
										});
									 }else if(result==2){
										 layer.msg("添加失败!");
									 }
								 },
								 error:function(){
									layer.msg("未知错误,请联系系统管理员!");
								}
						  });
			    	    }else{
			    	    	$.ajax({
								  url:"${pageContext.request.contextPath}/editingFile/changeEditingFile"+"?timestamp="+Math.random(),
								  type:"post",
									 beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
									data:{"editingTypeName":editingTypeName,"editingTitle":editingTitle,"editingController":editingController,"editingId":editingId},
									 dataType:"json",
									 cache:false,
									 success:function(result){
										 if(result==1){
											 layer.msg("修改成功!",{offset:'auto',time:1500},function(){
													 window.location.href="${pageContext.request.contextPath}/editingFile/goBianYan";
													 setTimeout(window.opener.location.reload(),1000);  
												 
											});
										 }else if(result==2){
											 layer.msg("修改失败!");
										 }
									 },
									 error:function(){
										layer.msg("未知错误,请联系系统管理员!");
									}
							  });
			    	    }

			});
			
		})
		
		
		
			
		</script>
	</body>

</html>