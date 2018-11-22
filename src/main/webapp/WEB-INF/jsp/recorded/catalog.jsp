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
		<meta http-equiv="pragma" content="no-cache"> 
     	<meta http-equiv="cache-control" content="no-cache"> 
    	<meta http-equiv="expires" content="0"> 
		<title>档案著录_新建档案</title>
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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webuploader/webuploader.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/catalog.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tableList.css" />
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
	</head>
	<style>
		#thelist>div{
		float:left;
		width:200px;
		}
		#uploader{
		width:100%;
		clear:both;
		padding: 20px 0;
		}
		#thelist{
			min-height: 500px;
		}
		.imgsup{
			width:120px;
			height:120px;
		}
		.info{
			width:200px;
			overflow: hidden;
			text-overflow:ellipsis;
			white-space: nowrap;
		}
	</style>
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
							<li class="layui-nav-item layui-this">
								<a href="${pageContext.request.contextPath}/recordedContent/goCatalog">新建档案</a>
							</li>
							<span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('cb',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/recordedTable/goRecordedTable">著录列表</a>
							</li>
						</c:if>
						
					</ul>
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-inline" style="padding-top: 10px;width: 100%;">
						<div style="float: left;width: 100%;">
							<blockquote class="layui-elem-quote layui-quote-nm">
							<c:if test="${zm:buttenPremission('caa',sessionScope.user.role.authorities) }">
								<button class="layui-btn layui-btn-md layui-btn-primary" style="width: 150px;">在线著录</button>
								<div id="uploadBtn">历史数据导入</div>
								</c:if>
							</blockquote>
							<form enctype="multipart/form-data" method="post"
								id="fileForm" style="display: inline;">
								<input type="file" name="historyFile" id="historyFile" style="display: none;" onchange="subForm()" multiple>
							</form>
							<form class="layui-form" action="" id="form_catalog">
								<div class="layui-form-item">
									<span class="font-i" style="padding-left: 15px;"><i class="fa fa-th" style="padding: 0 5px;"></i>盒信息</span>
									<button type="button" class="layui-btn layui-btn-sm layui-btn-warm" id="uplist">上传归档文件目录</button>
								</div>
								<input type="hidden" name="boxId" id="boxId" class="boxId"><!-- 盒子主键 -->
								<input type="hidden" name="imageAddress" id="imageAddress" class="imageAddress"><!--归档文件目录地址  -->
								<input type="hidden" name="bkImage" id="bkImage" class="bkImage"><!-- 备考表地址 -->
								<div class="layui-form-item">
										<div class="layui-input-inline">
											<input type="hidden"  placeholder="" autocomplete="off" class="layui-input" id="boxidMath"  name="boxidMath">
										</div>
									<label class="layui-form-label">全宗名称：</label>
									<div class="layui-input-inline">
										<select name="qzna" id="qzna" lay-filter="qzna">
											<option value="">请选择</option>
											<c:forEach items="${qzName }" var="qzna">
												<option value="${qzna.id }">${qzna.condition }</option>
											</c:forEach>
										</select>
										
									</div>
									<label class="layui-form-label">全宗号：</label>
									<div class="layui-input-inline">
										<select name="qznu" id="qznu" lay-filter="qznu">
											<option value="">请选择</option>
											<c:forEach items="${qzNumber }" var="qznu">
												<option value="${qznu.id }">${qznu.condition }</option>
											</c:forEach>
										</select>
									</div>
									<label class="layui-form-label">档案类型</label>
									<div class="layui-input-inline">
										<select name="pc" id="pc" lay-filter="pc">
											<option value="">请选择</option>
											<c:forEach items="${pc }" var="pc">
												<option value="${pc.id }">${pc.condition }</option>
											</c:forEach>
										</select>
									</div>
									<label class="layui-form-label">年度</label>
									<div class="layui-input-inline">
										<input type="text" placeholder="" autocomplete="off" class="layui-input" id="anual" name="anual">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">机构(问题)</label>
									<div class="layui-input-inline">
										<select name="sc" lay-verify="sc" id="sc">
											<option value="">请选择</option>
											<c:forEach items="${sc }" var="sc">
												<option value="${sc.id }">${sc.condition }</option>
											</c:forEach>
										</select>
									</div>
									<label class="layui-form-label">保管期限</label>
									<div class="layui-input-inline">
										<select name="rpn" id="rpn" lay-filter="rpn">
											<option value="">请选择</option>
											<c:forEach items="${rpn }" var="rpn">
												<option value="${rpn.id }">${rpn.condition }</option>
											</c:forEach>
										</select>
									</div>
									<label class="layui-form-label">起件号</label>
									<div class="layui-input-inline">
										<input type="text"  placeholder="" autocomplete="off" class="layui-input" id="bsn" name="bsn">
									</div>
									<label class="layui-form-label">止件号</label>
									<div class="layui-input-inline">
										<input type="text"  placeholder="" autocomplete="off" class="layui-input" id="ben" name="ben">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">盒号</label>
									<div class="layui-input-inline">
										<input type="text"  placeholder="" autocomplete="off" class="layui-input" id="boxNumber" name="boxNumber">
									</div>
									<label class="layui-form-label">盒属性</label>
									<div class="layui-input-inline">
										<select name="bp" id="bp" lay-filter="bp">
											<option value="">请选择</option>
											<c:forEach items="${bp }" var="bp">
												<option value="${bp.id }">可装页数:${bp.condition }</option>
											</c:forEach>
										</select>
									</div>
									<div class="layui-col-md2">
										<label class="layui-form-label" style="width: 85px;">备考表</label>
										<div class="layui-upload">
										<c:if test="${zm:buttenPremission('cab',sessionScope.user.role.authorities) }">
											<button type="button" class="layui-btn layui-btn-sm  layui-btn-normal" id="test10">选择文件</button>
											<button type="button" class="layui-btn layui-btn-sm " id="test11">开始上传</button>
											</c:if>
										</div>
									</div>
									<div class="layui-col-md3">
										<label class="layui-form-label" style="width: 85px;">归档文件目录</label>
										<div class="layui-upload">
											<button type="button" class="layui-btn layui-btn-sm " id="UploadArchiveDirectory">手动著录上传归档文件目录</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="jiansuo_tabel" style="margin:15px;">
						<div class="layui-card-header">
							<div class="layui-form layui-form-item" style="margin:15px 0;">
								<label class="layui-form-label font-i"><i class="fa fa-th-list" style="padding: 0 5px;"></i>盒内文件</label>
								<label class="layui-form-label">状态</label>
								<div class="layui-input-inline">
									<form>
										<select name="city" lay-verify="required" lay-filter="required" id="start">
											<option value="">请选择</option>
											<option value="1">未上传</option>
											<option value="2">已上传</option>
										</select>
									</form>
								</div>
								<div style="text-align: right;">
								<c:if test="${zm:buttenPremission('cac',sessionScope.user.role.authorities) }">
									<button type="button" class="layui-btn layui-btn-sm layui-btn-warm" id="shoudz">手动著录</button>
									<button type="button" class="layui-btn layui-btn-sm layui-btn-warm uploadimg">批量上传文件</button>
								</c:if>
								</div>
							</div>
						</div>
						<div style="clear: both;">
							<div>
								<table class="layui-hide" id="exchange_tabel" lay-filter="exchange_tabel"></table>
							</div>
							<div style="text-align: right;padding: 15px;">
							<c:if test="${zm:buttenPremission('caf',sessionScope.user.role.authorities) }">
								<button type="button" class="layui-btn" id="save">保存</button>
							</c:if>
							</div>
						</div>
					</div>
					<script type="text/html" id="barDemo">
						{{#  if(d.archiveFileIsUpload == '1'){  }}<button class="layui-btn layui-btn-xs up" lay-event="oneUpload">上传</button>
		 				{{#  } else if(d.archiveFileIsUpload == '2'){ }}<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
						{{#  }  }}
					</script>
				</div>
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/viewer.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/loginout.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/messgeNum.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/webuploader/webuploader.js" type="text/javascript" charset="utf-8"></script>
		<script>
		//生成UUID作为盒表主键			
		function uuid() {
		  var s = [];
		  var hexDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		  for (var i = 0; i < 36; i++) {
		    s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
		  }
		  s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
		  s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
		  s[8] = s[13] = s[18] = s[23] = "-";
		 
		  var uuid = s.join("");
		  return uuid;
		}
		$("#boxidMath").val(uuid());
//==================================图片放大======================================
			function img_vi() {
				$('.Scanning_Images').viewer();
			}
//=====================================表格数据=============================================			
		layui.use(['upload','form', 'layer','table'], function() {
				var table = layui.table
		          ,form = layui.form,upload = layui.upload;
				var $ = layui.jquery;
				//展示已知数据
				table.render({
					elem: '#exchange_tabel',
					cols: [
						[ //标题栏
							{
								type: 'numbers', 
								title: '序号'
							},
							{
								field: 'archiveFileFileNumber',
								title: '档号',
								minWidth: 200,
								unresize: 'false',
								edit:'text',
							}, {
								field: 'archiveFileReferenceNumber',
								title: '文号',
								minWidth: 150,
								unresize: 'false',
								edit:'text',
							}, {
								field: 'archiveFileResponsible',
								title: '责任者',
								width: 120,
								unresize: 'false',
								edit:'text',
							},
							{
								field: 'archiveFileTitle',
								title: '题名',
								width: 350,
								unresize: 'false',
								edit:'text',
							},
							{
								field: 'archiveFileCreatetime',
								title: '日期',
								width: 100,
								unresize: 'false',
								edit:'text',
							},
							{
								field: 'afSecurityClassrification',
								title: '密级',
								width: 100,
								unresize: 'false',
								edit:'text',
							},
							{
								field: 'archiveFilePages',
								title: '页数',
								width: 100,
								unresize: 'false',
								edit:'text',
							},
							{
								field: 'archiveFileRemark',
								title: '备注',
								width: 100,
								unresize: 'false',
								edit: 'text',
							},
							{
								field: 'archiveFileIsUpload',
								title: '状态',
								width: 100,
								unresize: 'false',
								toolbar:'#upstart',
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
					data: [],
					/*skin: 'nob' //表格风格
						,*/
					even: false,
					page: true //是否显示分页
						//,limits: [5, 7, 10]
						,
					limit: 10 //每页默认显示的数量
				});
				//备考表文件上传
				upload.render({
					elem: '#test10',
					url: '${pageContext.request.contextPath}/recordedContent/havingPerpartionForm/', //后台接口
					auto: false
						,
					bindAction: '#test11',
					done: function(res) {
						if(res.result!=''){
							layer.msg("上传成功",{time:1500,offset: 'auto',anim: 1},function(){
								$("#bkImage").val(res.result)
							})
						}else{
							layer.mag("备考表上传失败")
						}
					}
				});
				//监听单元格编辑
				table.on('edit(exchange_tabel)', function(obj) {
					var value = obj.value //得到修改后的值
						,
						data = obj.data //得到所在行所有键值
						,
						field = obj.field; //得到字段
						
						$.ajax({
							url:'${pageContext.request.contextPath}/recordedContent/updateFileInfor',
							data:{'fileId':data.archiveFileId,'content':field,'value':value},
							type:'post',
							dataType:'json',
							success:function(result){
								if(result){
									layer.msg("修改成功");
								}
							},error:function(){
								layer.msg("发生未知错误，请联系管理员")
							}
						})
				});
				//监听工具条
				table.on('tool(exchange_tabel)', function(obj) {
					var data = obj.data;
					var tr = obj.tr;
					var archiveFileId=data.archiveFileId;//获取文件的主键
					var fileTitle=data.archiveFileTitle;
					if(obj.event === 'detail') {
						//layer.msg('ID：'+ data.id + ' 的查看操作');
						$.ajax({
							url:'${pageContext.request.contextPath}/recordedContent/havingFileAtta',
							data:'archiveFileId='+archiveFileId,
							type:'post',
							dataType:'json',
							success:function(fileAtta){
								console.log(fileAtta[0])
								var text="";
								for(var i=0;i<fileAtta.length;i++){
									text+='<li><img src="<%=appurl%>'+fileAtta[i]+'" alt=""><p>page'+(i+1)+'</p></li>'
								};
								layer.open({
									type: 1,
									title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
									area: ['800px', '500px'],
									skin: 'add_label_bg',
									offset: 'auto',
									shade: [0.8, '#393D49'],
									content: '<div class="add_lb1">' +
										'<ul class="Scanning_Images" onclick="img_vi()">' +
										text+
										'</ul><div style="text-align:center;clear: both;">' +
										'</div></div>'
								});
							},error:function(){
								layer.msg("接口异常")
							}
						})
					}else if(obj.event == 'oneUpload'){
						layer.open({
							type: 1,
							title: '<i class="fa fa-bars" style="padding:0 5px"></i>上传文件',
							area: ['400px', '240px'],
							skin: 'add_label_bg',
							offset: 'auto',
							shade: [0.8, '#393D49'],
							content: '<div style="text-align: center;"><div id="oneUpload">选择文件</div></div>'
						});
						$(function(){
							var uploader;
							var boxId=$("#boxId").val();
							if(boxId == null || boxId == ''){
								var boxId = $("#boxidMath").val();
							}
							//上传历史数据
							uploader=WebUploader.create({
								auto :true,
								threads :'10',
								swf:'${pageContext.request.contextPath}/webuploader/Uploader.swf',//引入swf文件
								server:'${pageContext.request.contextPath}/recordedContent/oneUpload',//文件上传的后端控制器
								pick: {
									id:'#oneUpload',
								},
								formData:{boxId:boxId},
								resize: false,
							});
							uploader.on('fileQueued',function(file){//判断上传文件的格式
								var fileName=file.name;//获取文件的名称
								var index=fileName.indexOf('.');//获取文件后缀的下标
								var fileType=fileName.substring(index);
								var fileContent=fileName.substring(0,index);
								var fType=".zip";
								if(fileType!=fType){
									layer.msg("允许上传的文件的格式为:zip")
									uploader.removeFile(file)
								}
								if(fileTitle!=fileContent){
									layer.msg("选择相匹配文件")
									uploader.removeFile(file)
								}
								
							});
							uploader.on('uploadSuccess', function( file,response){
								layer.closeAll();
								layer.msg("上传成功")
								var start=$("#start").val();
								table.reload('exchange_tabel',{
									url:'${pageContext.request.contextPath}/recordedContent/havingFileStart?l='+Math.random(),
									where:{boxId:boxId,start:start},
									method:'post'
								})
							});
							uploader.on('uploadError', function(file,code){
								layer.msg("上传失败，请联系管理员")
							})
						})
					}
					
				});
				
		//=============================================================文件上传==========================================
				$(function() {
						$("#uplist").click(function() { //#btn为按钮id
							layer.open({
								type: 1,
								title: '<i class="fa fa-bars" style="padding:0 5px"></i>上传归档文件目录',
								area: ['800px', '600px'],
								skin: 'add_label_bg',
								offset: 'auto',
								ZIndex:1004,
								shade: [0.8, '#393D49'],
								content: '<div class="layui-col-md6" style="padding:15px;text-align: center;">' +
											'<div class="layui-upload">' +
												'<div class="layui-upload-list">' +
													'<img class="layui-upload-img Scanning_Images" id="demo1" style="widht:300px;height:350px;">' +
													'<p id="demoText"></p>' +
												'</div>' +
												'<button type="button" class="layui-btn" id="test1">上传图片</button>' +
											'</div>'+
										'</div>' +
										'<div class="layui-col-md6" style="padding:15px;text-align: center;">' +
											'<div class="layui-upload-list">' +
												'<img class="layui-upload-img Scanning_Images" id="demo2" style="widht:100%;height:350px;"/>' +
											'</div>' +
											'<button type="button" class="layui-btn recognition" data-type="recognition">识别目录</button>' +
										'</div>'
							});
							img_vi();
							//普通图片上传
							var uploadInst = upload.render({
								elem: '#test1',
								url: '${pageContext.request.contextPath}/recordedContent/uploadFileTable',
								before: function(obj) {
									//预读本地文件示例，不支持ie8
									obj.preview(function(index, file, result) {
										$('#demo1').attr('src', result); //图片链接（base64）
									});
								},
								done: function(res, index, upload) {
									if(res.code > 0) {//上传失败回调
										return layer.msg('上传失败');
									}else{//上传成功回调
										var pathname='<%=appurl%>'+res.name;
										$("#demo2").attr("src",pathname);
										$("#imageAddress").val(res.name);
										//识别归档文件目录
										$ = layui.$, active ={
												recognition:function(){
													var file=$("#demo2").attr("src");
													if(file!=""){
														file=file.substr('21');
														$.ajax({
															url:"${pageContext.request.contextPath}/recordedContent/tableContentInfor",
															data:"file="+file,
															type:"post",
															dataType:"json",
															success:function(result){
																var qzId=result.quanzongId;//全宗主键
																$('#qzna').siblings("div.layui-form-select").find('dl').find('dd[lay-value=' + qzId + ']').click();
																$('#qznu').siblings("div.layui-form-select").find('dl').find('dd[lay-value=' + qzId + ']').click();
																var pcId=result.pcId;//一级分类主键
																$('#pc').siblings("div.layui-form-select").find('dl').find('dd[lay-value=' + pcId + ']').click();
																var scId=result.scId;//二级分类主键
																$('#sc').siblings("div.layui-form-select").find('dl').find('dd[lay-value=' + scId + ']').click();
																var rtId=result.retentionperiodid;//保管期限主键
																$('#rpn').siblings("div.layui-form-select").find('dl').find('dd[lay-value=' + rtId + ']').click();
																var anual=result.anual;//年度
																$("#anual").val(anual)
																var bsn=result.boxstartnumber;//起件号
																$("#bsn").val(bsn)
																var ben=result.boxendnumber;//止件号
																$("#ben").val(ben)
																var boxId=result.boxId;//盒子主键
																$("#boxId").val(boxId);
																layer.closeAll();
																//盒内文件渲染
																table.reload('exchange_tabel',{
																	url:'${pageContext.request.contextPath}/recordedContent/havingFile?l='+Math.random(),
																	where:{boxId:boxId},
																	method:'post'
																})
															},
															error:function(){
																layer.msg("识别归档文件目录信息失败")
															}
														})
													}else{
														layer.msg("请上传归档文件目录")
													}
												}
											}
										$('.layui-col-md6 .recognition').on('click', function(){
										    var type = $(this).data('type');
										    active[type] ? active[type].call(this) : '';
										});
										//recognition();
									}
									//上传成功
								},
								error: function() {
									//演示失败状态，并实现重传
									var demoText = $('#demoText');
									demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini layui-btn-xs demo-reload">重试</a>');
									demoText.find('.demo-reload').on('click', function() {
										uploadInst.upload();
									});
								}
							});
						});
						$(".uploadimg").click(function() { //#btn为按钮id
							layer.open({
								type: 1,
								title: '<i class="fa fa-bars" style="padding:0 5px"></i>批量上传文件',
								area: ['820px', '600px'],
								skin: 'add_label_bg',
								offset: 'auto',
								shade: [0.8, '#393D49'],
								content: '<div style="text-align: center;">'+
										 '<div id="thelist" class="uploader-list"></div>'+
											'<div id="uploader" class="wu-example">'+
												'<div class="btns">'+
													'<div id="picker">选择文件</div>'+
													'<button id="ctlBtn" class="btn btn-default">开始上传</button>'+
												'</div>'+
											'</div>'+
										'</div>'
							});
							//盒子主键
							var boxId = $("#boxId").val();
							if(!boxId){
								var boxId=$("#boxidMath").val();
							}
							$().ready(function(){
								//多文件上传归档文件
								var $ = jQuery,
				                $list = $('#thelist'),
				                $btn = $('#ctlBtn'),
				                state = 'pending',
				                uploader;
								uploader=WebUploader.create({//初始化上传文件组件
									//auto :true,
									threads :'10',
									swf:'${pageContext.request.contextPath}/webuploader/Uploader.swf',//引入swf文件
									server:'${pageContext.request.contextPath}/recordedContent/moreUpload',//文件上传的后端控制器
									pick: {
										id:'#picker',
										multiple :true,
									},
									formData:{boxId:boxId},
									accept:{extensions:'zip'},
									resize: false,
								});
								uploader.on( 'fileQueued', function( file ) {
								    $list.append( '<div id="' + file.id + '" class="item">' +
								    	'<img src="../imgs/doc-manage-center/2.png"  class="imgsup" />'+
								        '<h4 class="info">' + file.name + '</h4>' +
								        '<p class="state ">等待上传...</p>' +
								        '<button class="removeFile layui-btn layui-btn-sm layui-btn-danger" name="'+file.id+'">移除文件</button>'+
								    '</div>' );
								    	 
								    $('.removeFile').on('click',function(){
						            	var id=$(this).attr('name');
						            	uploader.removeFile(uploader.getFile(id))
						            	$(this).parent().remove();
						            })
								});
								uploader.on( 'uploadProgress', function( file, percentage ) {
									 var $li = $('#' + file.id),
				                     $percent = $li.find('.progress .progress-bar'); 
					                 // 避免重复创建
					                 if (!$percent.length) {
					                     $percent = $('<div class="progress progress-striped active">' +
					                       '<div class="progress-bar" role="progressbar" style="width: 0%">' +
					                       '</div>' +
					                     '</div>').appendTo($li).find('.progress-bar');
					                 }
					                 $li.find('p.state').text('上传中');
					                 $percent.css('width', percentage * 100 + '%');
								});
								uploader.on('uploadFinished', function( file,response){
									layer.closeAll();
									layer.msg("上传成功")
									var start=$("#start").val();
									//盒子主键
									var boxId = $("#boxId").val();
									if(!boxId){
										var boxId=$("#boxidMath").val();
									}
									//盒内文件渲染
									table.reload('exchange_tabel',{
										url:'${pageContext.request.contextPath}/recordedContent/havingFileStart?l='+Math.random(),
										where:{boxId:boxId,start:start},
										method:'post'
									})
								});
								uploader.on('uploadError', function(file,code){
									layer.msg("上传失败，请联系管理员")
								});
					            $btn.on('click', function () {
					                 if (state === 'uploading') {
					                     uploader.stop();
					                 } else {
					                     uploader.upload();
					                 }
					            });
					           
							})
						});
						
						$('#UploadArchiveDirectory').on('click',function(){
						layer.open({
							type: 1,
							title: '<i class="fa fa-bars" style="padding:0 5px"></i>手动著录',
							area: ['520px', '600px'],
							skin: 'add_label_bg',
							offset: 'auto',
							shade: [0.8, '#393D49'],
							content: '<div class="layui-col-md6" style="padding:15px;text-align: center;">' +
										'<div class="layui-upload">' +
											'<button type="button" class="layui-btn" id="test2">上传图片</button>' +
										'</div>'+
									 '</div>'
						  	});
						img_vi();
						//普通图片上传
						var uploadInst = upload.render({
							elem: '#test2',
							url: '${pageContext.request.contextPath}/recordedContent/uploadFileTable',
							before: function(obj) {
								//预读本地文件示例，不支持ie8
								obj.preview(function(index, file, result) {
									$('#demo1').attr('src', result); //图片链接（base64）
								});
							},
							done: function(res, index, upload) {
								if(res.code > 0) {//上传失败回调
									return layer.msg('上传失败');
								}else{//上传成功回调
									var pathname='<%=appurl%>'+res.name;
									$("#demo2").attr("src",pathname);
									$("#imageAddress").val(res.name);
									console.log($("#demo2").attr("src",pathname));
									console.log($("#imageAddress").val(res.name));
									var imageAddress = res.name;
									console.log(imageAddress);
									layer.msg("上传成功")
									/* if(boxId!=''&&qzId!=''&&qzNumbar!=''&&qzName!=''&&pcId!=''&&scId!=''&&scName!=''&&rtId!=''&&bgName!=''&&bpId!=''&&boxPages!=''&&anual!=''&&bsn!=''&&ben!=''&&boxNumber!=''&&imageAddress!=''){//文件信息不为空保存 盒子信息
										$.ajax({
											url:'${pageContext.request.contextPath}/recordedContent/updataBoxStart',
											data:{
												'boxId':boxId,
												'qzId':qzId,
												'qzNumbar':qzNumbar,
												'qzName':qzName,
												'pcId':pcId,
												'scId':scId,
												'scName':scName,
												'rtId':rtId,
												'bgName':bgName,
												'bpId':bpId,
												'boxPages':boxPages,
												'anual':anual,
												'bsn':bsn,
												'ben':ben,
												'boxNumber':boxNumber,
												'imageAddress':imageAddress,
												'bkImage':bkImage},
											type:'post',
											dataType:'json',
											success:function(result){
												if(result.result!=''){
													layer.msg(result.result)
												}else{
													layer.msg("保存成功",{time:1500,offset: 'auto',anim: 1},function(){
														window.location.reload()
													})
												}
											},error:function(){
												layer.msg("接口异常")
											}
										}) 
									}else{
										layer.msg("相关信息不完整不允许提交")
									}*/
								}
								//上传成功
								
							},
							error: function() {
								//演示失败状态，并实现重传
								var demoText = $('#demoText');
								demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini layui-btn-xs demo-reload">重试</a>');
								demoText.find('.demo-reload').on('click', function() {
									uploadInst.upload();
								});
							}
						});
						});
						$('#save').on('click',function(){
							//盒子主键
							var boxId = $("#boxId").val();
							if(!boxId){
								var boxId=$("#boxidMath").val();
							}
							console.log(boxId);
							var qzId=$("#qzna").val();//全宗主键
							var qzNumbar=$("#qznu").find("option[value='"+$("#qznu").val()+"']").text();//全宗号
							var qzName=$("#qzna").find("option[value='"+$("#qzna").val()+"']").text();//全宗名
							var pcId=$("#pc").val();//一级分类主键 
							var scId=$("#sc").val();//二级分类主键
							var scName=$("#sc").find("option[value='"+$("#sc").val()+"']").text();//二级分类名
							var rtId=$("#rpn").val();//保管期限主键
							var bgName=$("#rpn").find("option[value='"+$("#rpn").val()+"']").text();//保管期限名
							var bpId=$("#bp").val();//盒子厚度
							var boxPages=$("#bp").find("option[value='"+$("#bp").val()+"']").text();//盒子可装页数
							boxPages=boxPages.substr(boxPages.indexOf(":")+1)
							var anual=$("#anual").val();//年度
							var bsn=$("#bsn").val();//起件号
							var ben=$("#ben").val();//止件号
							var boxNumber=$("#boxNumber").val();//盒号
							var imageAddress=$("#imageAddress").val();//归档文件目录
							var bkImage=$("#bkImage").val();//备考表地址
							console.log(imageAddress);
								if(boxId!=''&&qzId!=''&&qzNumbar!=''&&qzName!=''&&pcId!=''&&scId!=''&&scName!=''&&rtId!=''&&bgName!=''&&bpId!=''&&boxPages!=''&&anual!=''&&bsn!=''&&ben!=''&&boxNumber!=''&&imageAddress!=''){//文件信息不为空保存 盒子信息
									$.ajax({
										url:'${pageContext.request.contextPath}/recordedContent/updataBoxStart',
										data:{
											'boxId':boxId,
											'qzId':qzId,
											'qzNumbar':qzNumbar,
											'qzName':qzName,
											'pcId':pcId,
											'scId':scId,
											'scName':scName,
											'rtId':rtId,
											'bgName':bgName,
											'bpId':bpId,
											'boxPages':boxPages,
											'anual':anual,
											'bsn':bsn,
											'ben':ben,
											'boxNumber':boxNumber,
											'imageAddress':imageAddress,
											'bkImage':bkImage},
										type:'post',
										dataType:'json',
										success:function(result){
											if(result.result!=''){
												layer.msg(result.result)
											}else{
												layer.msg("保存成功",{time:1500,offset: 'auto',anim: 1},function(){
													window.location.reload()
												})
											}
										},error:function(){
											layer.msg("接口异常")
										}
									})
								}else{
									layer.msg("相关信息不完整不允许提交")
								}
						})
					});
//===============================================form=========================================================	
					form.on('select(qzna)', function(data){
						  var id=data.value; //得到被选中的值
						  var select='dd[lay-value=' + id + ']';
						  $('#qznu').siblings("div.layui-form-select").find('dl').find(select).click();
					});
					form.on('select(qznu)', function(data){
						  var id=data.value; //得到被选中的值
						  var select='dd[lay-value=' + id + ']';
						  $('#qzna').siblings("div.layui-form-select").find('dl').find(select).click();
					});
					form.on('select(required)',function(data){
						var start=data.value;
						//盒子主键
						var boxId = $("#boxId").val();
						if(!boxId){
							var boxId=$("#boxidMath").val();
						}
						//盒内文件渲染
						table.reload('exchange_tabel',{
							url:'${pageContext.request.contextPath}/recordedContent/havingFileStart?l='+Math.random(),
							where:{boxId:boxId,start:start},
							method:'post'
						})
					});
				
			});
//======================================================泰坦文件上传方法==============================================

			$().ready(function(){
				var uploader;
				//上传历史数据
				uploader=WebUploader.create({//初始化上传文件组件
					auto :true,
					threads :'10',
					swf:'${pageContext.request.contextPath}/webuploader/Uploader.swf',//引入swf文件
					server:'${pageContext.request.contextPath}/recordedContent/uploadHistory',//文件上传的后端控制器
					pick: {
						id:'#uploadBtn',
						multiple:false, 
					},
					//accept:{extensions:'zip,rar'},
					resize: false,
					chunked:true,
					chunkSize:10*1024*1024,
				});
				uploader.on('fileQueued',function(file){//判断上传文件的格式
					var fileName=file.name;//获取文件的名称
					var index=fileName.indexOf('.');//获取文件后缀的下标
					var fileType=fileName.substring(index);
					var fType=".zip";
					if(fileType!=fType){
						layer.msg("允许上传的文件的格式为:zip")
						uploader.removeFile(file)
					}
				});
				uploader.on('uploadSuccess', function( file,response){
					layer.msg("上传成功")
				});
				uploader.on('uploadError', function(file,code){
					layer.msg("上传失败，请联系管理员")
				})
			})
			//手动录入弹出层 
			var openlarer = function(){ 
				
			}
			/* 手动著录 */
			$("#shoudz").click(function() { //#btn为按钮id
				var nBoxid = $("#boxidMath").val();
				var qzId=$("#qzna").val();//全宗主键
				var qzNumbar=$("#qznu").find("option[value='"+$("#qznu").val()+"']").text();//全宗号
				var qzName=$("#qzna").find("option[value='"+$("#qzna").val()+"']").text();//全宗名
				var nPcId=$("#pc").val();//一级分类主键 
				var nScId=$("#sc").val();//二级分类主键
				var scName=$("#sc").find("option[value='"+$("#sc").val()+"']").text();//二级分类名
				var rtId=$("#rpn").val();//保管期限主键
				var bgName=$("#rpn").find("option[value='"+$("#rpn").val()+"']").text();//保管期限名
				var bpId=$("#bp").val();//盒子厚度
				var boxPages=$("#bp").find("option[value='"+$("#bp").val()+"']").text();//盒子可装页数
				boxPages=boxPages.substr(boxPages.indexOf(":")+1);
				var nAnual=$("#anual").val();//年度
				var bsn=$("#bsn").val();//起件号
				var ben=$("#ben").val();//止件号
				var boxNumber=$("#boxNumber").val();//盒号
				var imageAddress=$("#imageAddress").val();//归档文件目录
				var bkImage=$("#bkImage").val();//备考表地址
				if(qzId!=''&&qzNumbar!=''&&qzName!=''&&nPcId!=''&&nScId!=''&&scName!=''&&rtId!=''&&bgName!=''&&bpId!=''&&boxPages!=''&&nAnual!=''&&bsn!=''&&ben!=''&&boxNumber!=''){//文件信息不为空保存 盒子信息
					//文件审核状态(0：未审核，1：已审核：2：已驳回；默认0)
					var boxAuditstart = "2";
					//装盒状态（档案著录中已装盒，未装盒）
					var boxBoxingStart = "1";
					//盒状态(0：待审核，1：审核中，2：验收合格；3：驳回 ；4未进馆；5：未保存（档案著录新进啊档案默认0)
					var boxstatus = "5";
					if(bsn.length != 4 || ben.length != 4){
						layer.msg("起件号~止件号必须为4位数")
					}else{
						//判断起件号是否小于止件号
						var numQj = bsn.replace(/\b(0+)/gi,"");
						var numZj = ben.replace(/\b(0+)/gi,"");
						console.log(parseInt(numQj)<parseInt(numZj));
						if(parseInt(numQj) > parseInt(numZj)){
							layer.msg("起件号不能大于止件号");
						}else{
							var boxCasesnumbers = ben.replace(/\b(0+)/gi,"") - bsn.replace(/\b(0+)/gi,"");
							var boxCasesnumber = boxCasesnumbers+1;
							$.ajax({
							url:'${pageContext.request.contextPath}/recordedContent/manualDescription?l='+Math.random(),
							type:'post',
							data:{
								"anual":nAnual,
								"boxAuditstart":boxAuditstart,
								"boxBoxingStart":boxBoxingStart,
								"boxendnumber":ben,
								"boxid":nBoxid,
								"boxstartnumber":bsn,
								"boxstatus":boxstatus,
								"pcId":nPcId,
								"quanZongId":qzId,
								"retentionperiodid":rtId,
								"scId":nScId,
								"boxCasesnumber":boxCasesnumber
								},
							dataType:'json',
							async:false,
							success:function(data){
								layui.use(['upload','form', 'layer','table'], function() {
									var table = layui.table
							          ,form = layui.form,upload = layui.upload;
									var $ = layui.jquery;
									//盒内文件渲染
									table.reload('exchange_tabel',{
										url:'${pageContext.request.contextPath}/recordedContent/havingFile?l='+Math.random(),
										where:{boxId:nBoxid},
										method:'post'
									})
								})
							} 
						})
						}
					}
					
				}else{
					layer.msg("请完善盒信息");
				}
			});
//============================================方法===============================================
			
		</script>
		<script type="text/html" id="upstart">
			{{#  if(d.archiveFileIsUpload == '1'){  }}未上传
		 	{{#  } else if(d.archiveFileIsUpload == '2'){ }}已上传
			{{#  }  }}
		</script>
		
	</body>

</html>