<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合利用查询系统_电子阅览室</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/layui/css/layui.css"
	media="all">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
<!--导航公共样式-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/archives-collection.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/viewer.min.css" />
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
<style type="text/css">
body .add_label_bg>.layui-layer-title, .btn_color {
	background: #EA5519;
	color: #FFFFFF;
}

.exchange_nav ul li a {
	width: 10%;
	display: inline-block;
	height: 38px;
	line-height: 38px;
	padding: 0 10px;
	background-color: #009688;
	color: #fff;
	white-space: nowrap;
	text-align: center;
	font-size: 14px;
	border: none;
	border-radius: 100px;
	cursor: pointer;
	float: left;
	margin: 20px 6%;
}

.exchange_nav ul li .a1 {
	background: #f0f2f9;
	color: #009688;
	border: 1px solid #009688;
}
/*主体样式*/
table tr th div, table tr td {
	text-align: center;
}

.layui-table-page {
	text-align: right;
}
/*检索*/
.jiansuo, .jiansuo_tabel {
	background: #FFFFFF;
	padding-right: 15px;
	border: 1px solid #FFFFFF;
	border-radius: 8px;
	margin-top: 0px;
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .1);
}
/*预览图*/
.nav_imgs li {
	float: left;
	width: 14%;
	margin: 15px 3%;
	height: 230px;
	text-align: center;
}

.nav_imgs li img {
	width: 100%;
	height: 100%;
}
/*查看*/
.Scanning_Images {
	width: 100%;
	height:400px;
	background: #FFFFFF;
	overflow-y: scroll;
}

.Scanning_Images li {
	float: left;
	width: 100px;
	height: 150px;
	background: #FFFFFF;
	margin-left: 28px;
	margin-top: 15px;
	text-align: right;
	box-shadow: 0.5px 1px 3px #000;
	margin-bottom: 15px;
}

.Scanning_Images li img {
	width: 100%;
	height: 80%;
}

.Scanning_Images li button {
	border: none;
	outline: none;
	background: none;
	cursor: pointer;
}

.Scanning_Images li p {
	text-align: center;
}

.viewer-container, .viewer-fixed, .viewer-fade, .viewer-transition,
	.viewer-in {
	z-index: 99999999999 !important;
	/*弹出层查看图片优先级提升*/
}
</style>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<!--class 个性化设置nav_bg1-->
		<div class="copy">
			<!-- 版权所有 -->
			<p>
				COPYRIGHT&nbsp;&copy;2018 <a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有
			</p>
		</div>

		<div class="logo_nav" style="border-bottom: 1px dashed #C2C2C2;">
			<!-- 头部区域 -->
			<div>
				<span class="logo_img"><img
					src="${pageContext.request.contextPath}/imgs/home.gif" width="110"
					height="50" /></span>
				<div class="logo">
					<a href="${pageContext.request.contextPath}/information/godigitalarchives" style="color: #EA5519;">综合利用查询系统</a> <a
						href="${pageContext.request.contextPath}/log/goHome" id="home">返回主页&gt;</a>
				</div>
			</div>

		</div>
		<!-- 主体内容 -->
		<div class="layui-body" id="index-bg" style="top: 81px; left: 0;">
			<div class="layui-row">
				<div class="exchange_nav layui-col-sm12 layui-col-md12">
					<ul>
						<li><a href="#">电子文件中心</a></li>
						<li><a
							href="${pageContext.request.contextPath}/AdviceMapperController/modelAndView">交流中心</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/readingRoom/publicArchiveShow" class="a1">电子阅览室</a></li>
						<li><a
							href="${pageContext.request.contextPath}/information/goarchivalInformation">档案信息门户</a>
						</li>
					</ul>
				</div>
				<div class="layui-row" style="margin: 0px 15px;">
					<div class="layui-col-md3" style="padding: 15px;">
						<div class="layui-form jiansuo">
							<label class="layui-form-label"
								style="margin: 7px 0; color: #EA5519; font-weight: bold;"><i
								class="fa fa-search-plus" style="padding: 0 5px;"></i>档案检索</label>
							<div class="layui-form-item">
								<label class="layui-form-label">全宗名称</label>
								<div class="layui-input-block">
									<select id="quanzongName" name="quanzongName" lay-verify="">
										<option value="">请选择</option>
										<c:forEach items="${archiveNameList}" var="archive">
											<option value="${archive.quanzongName}">${archive.quanzongName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">文件年度</label>
								<div class="layui-input-block">
									<select id="archiveFileAnual" name="archiveFileAnual"
										lay-verify="">
										<option value="">请选择</option>
										<c:forEach items="${fileAnualList}" var="anual">
											<option value="${anual.archiveFileAnual}">${anual.archiveFileAnual}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">保管期限</label>
								<div class="layui-input-block">
									<select id="retentionperiodname" name="retentionperiodname"
										lay-verify="">
										<option value="">请选择</option>
										<c:forEach items="${retentionperiodNameList}" var="retention">
											<option value="${retention.retentionperiodname}">${retention.retentionperiodname}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">档案类别</label>
								<div class="layui-input-block">
									<select id="pcName" name="pcName" lay-verify="">
										<option value="">请选择</option>
										<c:forEach items="${pcNameList}" var="pc">
											<option value="${pc.pcName}">${pc.pcName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">问题(分类)</label>
								<div class="layui-input-block">
									<select id="scName" name="scName" lay-verify="">
										<option value="">请选择</option>
										<c:forEach items="${scNameList}" var="sc">
											<option value="${sc.scName}">${sc.scName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">关键词</label>
								<div class="layui-input-block">
									<textarea id="conditions" name="conditions" placeholder="考核指标"
										class="layui-textarea"></textarea>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button id="archiveFileQueryConditions"
										class="layui-btn  layui-btn-sm" lay-submit
										lay-filter="formDemo">查询</button>
								</div>
							</div>
						</div>
					</div>

					<div class="layui-col-md9" style="padding: 15px;">
						<div class="jiansuo_tabel layui-tab layui-tab-card">
							<div class="layui-card-header">
								<span style="color: #EA5519; font-weight: bold;"><i
									class="fa fa-th-list" style="padding: 0 5px;"></i>档案列表</span>
								<ul class="layui-tab-title" style="float: right;">
									<li class="layui-this"><i class="fa fa-bars"
										style="color: #EA5519; font-weight: bold;"></i></li>
										<!-- 缩略图展示 -->
									<li onclick="thumbnail()"><i class="fa fa-th" style="color: #EA5519; font-weight: bold;"></i></li>
								</ul>
							</div>
							<div class="layui-tab-content" style="clear: both;">
								<div class="layui-tab-item layui-show">
									<table class="layui-hide" id="exchange_tabel"
										lay-filter="exchange_tabel"></table>
								</div>
								<div class="layui-tab-item">
								 <input type="hidden" id="tang" value="">
									<ul class="nav_imgs" id="allUl">
									
											<li class="look-room">
											
											</li>
									</ul>
									<%-- <div style="padding: 15px; margin-top: 30px; text-align: center; clear: both;">
										<span>共<span id="allFile"></span>件</span>
										<span id="showSubscript">
										<span>第<select name="" id ="pageNum" onchange="chang()">
										<c:forEach begin="1" end="${requestScope.pagemsg.totalPage}" varStatus="status">
											<option value="${status.count}" <c:if test="${status.count eq requestScope.pagemsg.currPage}">selected</c:if>>${status.count}</option>
												</c:forEach>
										</select>页
										</span>
										<span>共<span id="totalPage">${requestScope.pagemsg.totalPage}</span>页</span>
										<c:if test="${requestScope.pagemsg.currPage != 1}">
											    <span class="layui-btn layui-btn-xs" onclick="page('${requestScope.pagemsg.currPage-1}')">上一页</span>
                                              </c:if>
                                              <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
											<span class="layui-btn layui-btn-xs" onclick="page('${requestScope.pagemsg.currPage+1}')">下一页</span>
			                                  </c:if>
			                               </span>   
									</div> --%>
								</div>
							</div>
						</div>
					</div>
					<!--<table class="layui-hide" id="exchange_tabel" lay-filter="exchange_tabel"></table>-->
				</div>
				<script type="text/html" id="barDemo">
						<!-- 这里同样支持 laytpl 语法，如： -->
						<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
					</script>
			</div>
		</div>
	</div>
	<div>
		<!-- 辅助元素，一般用于移动设备下遮罩 -->
		<div class="layadmin-body-shade" layadmin-event="shade"></div>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
	<script
		src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js"
		type="text/javascript" charset="utf-8"></script>
	<!-- 图片预览插件 -->
	<script src="${pageContext.request.contextPath}/js/viewer.min.js"></script>
	<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
    </script>
	<script type="text/javascript">
		$().ready(function() {
							var table = layui.table;
							var $ = layui.$;
							$("#archiveFileQueryConditions").click(
											function() {
												var quanzongName = $("#quanzongName").val();
												var archiveFileAnual = $("#archiveFileAnual").val();
												var retentionperiodname = $("#retentionperiodname").val();
												var pcName = $("#pcName").val();
												var scName = $("#scName").val();
												var condition = $("#conditions").val();
												table.reload('exchange_tabel',{
																	url : '${pageContext.request.contextPath}/readingRoom/queryAllPublicArchive',
																	where : {
																		//设定异步数据接口的额外参数，任意设
																		quanzongName : quanzongName,
																		archiveFileAnual : archiveFileAnual,
																		retentionperiodname : retentionperiodname,
																		pcName : pcName,
																		scName : scName,
																		condition : condition,

																	//…
																	},
																	page : {
																		curr : 1
																	}
																});

											})
						            })

		function img_vi() {
			$('.Scanning_Images').viewer();
		}
		layui.use('table',function() {
							var table = layui.table;
                            var $=layui.$;
							//展示已知数据
							table.render({
										elem : '#exchange_tabel',
										url : "${pageContext.request.contextPath}/readingRoom/archiveFileList",
										cols : [ [ //标题栏
												{
													type : 'numbers',
													title : '序号',
													width : 80,
													unresize : 'false',
													sort : true,
													templet: '#indexTpl',
													
												},{
													field : 'quanzongName',
													title : '全宗名称',
													width : 120,
													unresize : 'false',
												},
												{
													field : 'archiveFileFileNumber',
													title : '档号',
													minWidth : 150,
													unresize : 'false',
												},
												{
													field : 'archiveFileReferenceNumber',
													title : '文号',
													minWidth : 150,
													unresize : 'false',
												},
												{
													field : 'archiveFileResponsible',
													title : '责任人',
													width : 120,
													unresize : 'false',
												},
												{
													field : 'archiveFileTitle',
													title : '题名',
													width : 120,
													unresize : 'false',
												},
												{
													field : 'archiveFileCreatetime',
													title : '文件日期',
													width : 100,
													unresize : 'false',
												}, {
													field : 'right',
													title : '操作',
													width : 100,
													unresize : 'false',
													toolbar : '#barDemo'
												} ] ],
										data : [],
										skin : 'nob' //表格风格
										,
										even : false,
										page : true //是否显示分页
										//,limits: [5, 7, 10]
										,
										limit : 10
									//每页默认显示的数量
									});
							     //监听工具条
							     table.on('tool(exchange_tabel)',function(obj) {
								                var archiveFileId = obj.data.archiveFileId;
												var data = obj.data;
												var tr = obj.tr;

												if (obj.event === 'detail') {
													//layer.msg('ID：'+ data.id + ' 的查看操作');
													$.ajax({
														url:"${pageContext.request.contextPath}/readingRoom/searchAllPublicArchiveFile?mlt="+<%=Math.random()%>,
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
																type : "post",
																title : '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
																area : ['550px','400px' ],
																skin : 'add_label_bg',
																offset : 'auto',
																shade : [ 0.8, '#393D49' ],
																content : text,
															});
														}
													})
												}
											});
						             });
		
		         

		
//++++++++++++++++++++++++++++++++++++++++++++++缩略图展示密级为公开的文件附件的图片首页+++++++++++++++++++++++++++++++++++++++++++
        //文件附件首页图片展示
		function thumbnail(){
			var currentPage =$("#pageNum").val();
			picFileListShow(currentPage);
		}
		
		function page(currentPage){
			picFileListShow(currentPage);
		}
		
		function chang(){
			var currentPage =$("#pageNum").val();
			picFileListShow(currentPage);
		} 
		
		//获取文件附件首页图片存储路径集合
		function picFileListShow(currentPage){
			$.ajax({
				url : "${pageContext.request.contextPath}/readingRoom/imgListShow"+"?timestamp="+Math.random(),
				type : "post",
				beforeSend :function(xmlHttp){ 
			        xmlHttp.setRequestHeader("If-Modified-Since","0");
			        xmlHttp.setRequestHeader("Cache-Control","no-cache");
			     },
				cache:false,
				data : {"afSecurityClassrification":"公开","currentPage":currentPage},
				success : function(code) {
					var result = code.lists;
					console.log(result);
					var ids = new Array();
					if(result.length>0){
						for (var i = 0; i < result.length; i++) {
							var id=result[0].archiveFileId;
							ids.push(result[i].archiveFileId );
						}
						console.log("文件主键:"+id);
						$("#tang").val(id);
							//获取到的图片数组处理逻辑方法
							$("#allUl").empty();
						for (var i = 0; i <result.length; i++) {
							
							$("#allUl")
							  .append("<li class='look-room'>"
									 +"<img src="+'<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'
								+""+result[i].fileAttachmentPath+"?"+Math.random()+" id="+result[i].fileAttachmentPath+">"+result[i].archiveFileFileNumber+"<p id='pArchiveFileId' hidden='hidden'>"+result[i].archiveFileId+"</p></li>")
								
							}
						$("#showSubscript").empty();
						 $(".look-room").click(function() {//#btn为按钮id
							  var archiveFileId = $(this)[0].lastChild.innerText;
							   $.ajax({
								url:"${pageContext.request.contextPath}/readingRoom/searchAllPublicArchiveFile",
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
										type : "post",
										title : '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
										area : ['550px','400px' ],
										skin : 'add_label_bg',
										offset : 'auto',
										shade : [ 0.8, '#393D49' ],
										content : text,
									});
								}
							})
				       })
	    				var indexBox="";
	    				if(code.currPage!=1){
	    					indexBox=indexBox+"<span class='layui-btn layui-btn-xs' onclick='page("+(code.currPage-1)+")'>上一页</span>&nbsp;&nbsp;"
	    				}
	    				indexBox=indexBox+"<select onchange='chang()' id='pageNum'>"
	    				if(code.totalPage==0){
	    					indexBox=indexBox+"<option value='1'>+i+</option>"
	    				}else{
	    					for(var i=1;i<=code.totalPage;i++){
	    						indexBox=indexBox+"<option value='"+i+"' "
	    						if(i==code.currPage){
	    							indexBox=indexBox+"selected"
	    						}
	    						indexBox=indexBox+">"+i+"</option>"
	    					}
	    				}
	    					
	    				indexBox=indexBox+"</select>"
	    				if(code.currPage!=code.totalPage&&code.totalPage!=0){
	    					indexBox=indexBox+"<span class='layui-btn layui-btn-xs' onclick='page("+(code.currPage+1)+")'>下一页</span>&nbsp;&nbsp;"
	    					
	    				}
	    				    $("#showSubscript").append(indexBox);	

						
					
					}
				},
				error : function(e) {
					console.log("获取文件list数组失败，请检查接口服务");
		
				}
			});
			
		}
		
	         
  
	</script>
</body>
</html>