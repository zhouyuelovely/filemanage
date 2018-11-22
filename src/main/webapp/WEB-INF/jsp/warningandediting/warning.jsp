<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>监测预警_到期档案</title>
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
			.gong_color{
				color: red;
				font-weight: bold;
			}
			.viewer-container,
			.viewer-fixed,
			.viewer-fade,
			.viewer-transition,
			.viewer-in {
				z-index: 99999999999!important;
				/*弹出层查看图片优先级提升*/
			}
			
			#form_catalog {
				background: #FFFFFF;
				height: 100%;
				padding-top: 15px;
				border-radius: 4px;
				box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .1);
				margin: 0 15px;
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
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
						<li class="layui-nav-item  layui-hide-xs "><c:if
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
						<c:if test="${zm:buttenPremission('ia',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
								<a href="${pageContext.request.contextPath}/expiredFile/goDaoQi">到期档案</a>
							</li><span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('ib',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/borrowingFile/goGuiHuan">未归还档案</a>
							</li>
						</c:if>
						
					</ul>
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-inline" style="padding-top: 10px;width: 100%;">
						<div style="float: left;width: 100%;" id="form_catalog">
							<form class="layui-form" action="">
								<div class="layui-form-item">
									<label class="layui-form-label">全宗名称</label>
									<div class="layui-input-inline">
										<select name="qzName" id="qzName" lay-verify=""  lay-filter="qzName">
											<option value="">请选择</option>
											<c:forEach items="${qzNameList}" var="quanZong">
												<option value="${quanZong.qzName}">${quanZong.qzName}</option>
											</c:forEach>
										</select>
									</div>
									<label class="layui-form-label">到期预警</label>
									<div class="layui-input-inline">
										<select name="surplusDays" id="surplusDays" lay-verify=""  lay-filter="surplusDays">
											<option value="">请选择</option>
											<c:forEach items="${warningDayList}" var="warning">
												<option value="${warning}">${warning}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</form>
							<div class="layui-tab-content" style="clear: both;">
								 <div style="padding:0 15px;">
								 	<table class="layui-hide" id="demo" lay-filter="demo"></table>
								 </div>
								<script type="text/html" id="barDemo">
							<!-- 这里同样支持 laytpl 语法，如： -->
							<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
						</script>
						<script type="text/html" id="barDemo2">
							<input type="radio" name="radio" lay-event="radio" lay-ignore/>
						</script>
								<div id="" style="margin: 18px 0;">
									<span id="total" style="margin:0 15px;">合计：<b>${total}</b>件</span>
									<button class="layui-btn"  id="change_period">保管期限变更</button>
									<button class="layui-btn layui-btn-danger add_label" id="destruction">鉴定销毁</button>
								</div>
							</div>
						</div>
					</div>
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
		//下拉框查询
		 layui.use('form',function(){
			   var form=layui.form; 
			   var table = layui.table;
			   form.on('select(qzName)', function(data){//根据全宗名查询
					  console.log(data.value); //得到被选中的值
						  var qzName = data.value;
						  table.reload('demo', {
							  url:'${pageContext.request.contextPath}/expiredFile/selectFileByQzName',
							  where: { //设定异步数据接口的额外参数，任意设
								  qzName: qzName,
							  },page: {
							    curr: 1 //重新从第 1 页开始
							  }  
							}); 
			       });   
			   form.on('select(surplusDays)', function(data){//预警天数查询
					  console.log(data.value); //得到被选中的值
						  var surplusDays = data.value;
						  table.reload('demo', {
							  url:'${pageContext.request.contextPath}/expiredFile/selectFileBySurplusDays',
							  where: { //设定异步数据接口的额外参数，任意设
								  surplusDays: surplusDays,
							  },page: {
							    curr: 1 //重新从第 1 页开始
							  }  
							}); 
			       });    
		  });
		
			layui.use('table', function() {
						var table = layui.table;
						var $ = layui.$;
						//展示已知数据
						table.render({
							elem: '#demo',
							url:'${pageContext.request.contextPath}/expiredFile/selectAllExpiredFile',
							cols: [
								[ //标题栏
									{
										type: 'left',
										title: '单选',
										unresize: 'false',
										toolbar: '#barDemo2'
									},
									{
										type: 'numbers',
										title: '序号',
										unresize: 'false',
										templet: '#indexTpl',
									},{
										field: 'qzName',
										title: '全宗名称',
										minWidth: 100,
										unresize: 'false',
									},{
										field: 'fileNumber',
										title: '档号',
										minWidth: 200,
										unresize:'false',
									},{
										field: 'boxNumber',
										title: '盒号',
										width: 100,
										unresize: 'false',
									},{
										field: 'rackNumber',
										title: '架位号',
										width: 100,
										unresize: 'false',
									},
									{
										field: 'fileCreateDate',
										title: '档案日期',
										width: 150,
										unresize: 'false',
									},
									{
										field: 'endDate',
										title: '到期日期',
										width: 150,
										unresize: 'false',
									},
									{
										field: 'surplusDays',
										title: '到期预警',
										width: 100,
										unresize: 'false',
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
							even: true,
							page: true, //是否显示分页
							limit:10,  //默认十条数据一页  
							limits:[10,20,30,50]  //数据分页条  
						});
						table.on('tool(demo)', function(obj) {
							var data = obj.data;
							var tr = obj.tr;
							var archivefileId = obj.data.archivefileId;
							console.log(data)
							if(obj.event === 'detail') {
								$.ajax({
									url:"${pageContext.request.contextPath}/archiveFileStore/havingFileAttachmentList?meng="+<%=Math.random() %>,
									type:"post",
									data:"archiveFileId="+archivefileId,
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
								img_vi();						
						    }else if(obj.event === 'radio'){
								  console.log(obj.data);
								 var saveDays=obj.data.saveDays;
								 $("#change_period").click(function() { //#btn为按钮id
									 var managerDetailsApplication='保管期限变更';
										layer.open({
											type: 1,
											title: '<i class="fa fa-bars" style="padding:0 5px"></i>保管期限变更',
											area: ['380px', '400px'],
											skin: 'add_label_bg',
											offset: 'auto',
											shade: [0.8, '#393D49'],
											content: "<form id='formone' method='post' onsubmit='return validate_form(this)' class='layui-form' target='nm_iframe'>"+
										     "<div class='layui-form-item' style='padding-top: 15px;'>"+
										     "<input type='hidden' name='managerDetailsApplication' id='managerDetailsApplication' value='"+managerDetailsApplication+"'/>"+
										     "<input type='hidden' name='id' id='archivefileId' value='"+obj.data.archivefileId+"'/>"+
											"<label class='layui-form-label'>申请人:</label>"+
											"<div class='layui-input-inline'>"+
												"<input type='text' name='managerDetailsPerson' id='managerDetailsPerson' class='layui-input' readonly>"+
											"</div>"+
										"</div>"+
										"<div class='layui-form-item'>"+
											"<label class='layui-form-label'>申请时间:</label>"+
											"<div class='layui-input-inline'>"+
												"<input type='text' name='managerDetailsTime' id='managerDetailsTime'  class='layui-input' readonly>"+
											"</div>"+
										"</div>"+
										"<div class='layui-form-item'>"+
											"<label class='layui-form-label'>原保管期限:</label>"+
											"<div class='layui-input-inline'>"+
												"<input type='text' name='managerDetailsBeforeChange' id='managerDetailsBeforeChange'  class='layui-input' readonly>"+
											"</div>"+
										"</div>"+
										"<div class='layui-form-item'>"+
											"<label class='layui-form-label'>变更保管期限:</label>"+
											"<div class='layui-input-inline'>"+
												"<input type='text' name='managerDetailsAfterChange' id='managerDetailsAfterChange'  class='layui-input' >"+
											"</div>"+
										"</div>"+
										"<div class='layui-form-item'>"+
											"<label class='layui-form-label'>变更事由:</label>"+
											"<div class='layui-input-inline'>"+
												"<input type='text' name='managerDetailsReason' id='managerDetailsReason'  class='layui-input' >"+
											"</div>"+
										"</div>"+
										"<div class='layui-form-item' style='text-align: center;'>"+
											"<button class='layui-btn layui-btn-danger'  type='submit'>确定</button>"+
										"</div>"+
									"</form>"+
									 " <iframe id='id_iframe' name='nm_iframe' style='display:none;'></iframe> ",
									    });
									   var managerDetailsPerson=new String('${user.userName}');
									   document.getElementById("managerDetailsPerson").value=managerDetailsPerson;
										var date=new Date();
								    	 var year=date.getFullYear(); //获取当前年份
								    	var mon=date.getMonth()+1; //获取当前月份
								    	var da=date.getDate(); //获取当前日
								    	var hours = date.getHours();//获取当前小时
								    	 var minutes = date.getMinutes();//获取当前分钟
								    	if(hours<10){
								    		hours="0"+hours;
								    	}else if(minutes<10){
								    		minutes="0"+minutes;
								    	}
								    	var mytime=year+"-"+mon+"-"+da +" "+ hours + ":" + minutes;
								         console.log(mytime)
								         document.getElementById("managerDetailsTime").value=mytime; 
								         document.getElementById("managerDetailsBeforeChange").value=saveDays;
										
									  });
								 
								//鉴定销毁弹出层
									$("#destruction").click(function() { //#btn为按钮id
										var managerDetailsApplication="鉴定销毁";
										layer.open({
											type: 1,
											title: '<i class="fa fa-bars" style="padding:0 5px"></i>鉴定销毁',
											area: ['380px', '400px'],
											skin: 'add_label_bg',
											offset: 'auto',
											shade: [0.8, '#393D49'],
											content:'<form id="formthree" method="post" onsubmit="return validate_form3(this)" class="layui-form" target="nm_iframe3">'+
										  '<div class="layui-form-item" style="padding-top: 15px;">'+
										  "<input type='hidden' name='managerDetailsApplication' id='managerDetailsApplication3' value='"+managerDetailsApplication+"'/>"+
										     "<input type='hidden' name='id' id='archivefileId3' value='"+obj.data.archivefileId+"'/>"+
											'<label class="layui-form-label">申请人:</label>'+
											'<div class="layui-input-inline">'+
												'<input type="text" name="managerDetailsPerson" id="managerDetailsPerson3"  class="layui-input" readonly>'+
											'</div>'+
										'</div>'+
										'<div class="layui-form-item">'+
											'<label class="layui-form-label">申请时间:</label>'+
											'<div class="layui-input-inline">'+
												'<input type="text" name="managerDetailsTime" id="managerDetailsTime3"  class="layui-input" readonly>'+
											'</div>'+
											'</div>'+
										'<div class="layui-form-item">'+
											'<label class="layui-form-label">销毁事由:</label>'+
											'<textarea name="managerDetailsReason" id="managerDetailsReason3"  style="margin: 0px; width: 190px; height: 150px;"></textarea>'+
										'</div>'+
										'<div class="layui-form-item" style="text-align: center;">'+
											'<button class="layui-btn layui-btn-danger">确定</button>'+
										'</div>'+
								    '</form>'+ " <iframe id='id_iframe3' name='nm_iframe3' style='display:none;'></iframe> ",
										});
										var managerDetailsPerson=new String('${user.userName}');
										   document.getElementById("managerDetailsPerson3").value=managerDetailsPerson;
											var date=new Date();
									    	 var year=date.getFullYear(); //获取当前年份
									    	var mon=date.getMonth()+1; //获取当前月份
									    	var da=date.getDate(); //获取当前日
									    	var hours = date.getHours();//获取当前小时
									    	 var minutes = date.getMinutes();//获取当前分钟
									    	if(hours<10){
									    		hours="0"+hours;
									    	}else if(minutes<10){
									    		minutes="0"+minutes;
									    	}
									    	var mytime=year+"-"+mon+"-"+da +" "+ hours + ":" + minutes;
									        console.log(mytime)
									         document.getElementById("managerDetailsTime3").value=mytime; 
									});
						    }
					    });
					});
					function img_vi() {
						$('.Scanning_Images').viewer();
					}
					
					function validate_required(field, alerttxt) {
						with(field) {
							if(value == null || value == "") {
								layer.msg(alerttxt);
								return false
							} else{
								return true
							}
						}
					}
					//保管期限变更校验
					function validate_form(thisform){
						with(thisform) {
							if(validate_required(managerDetailsAfterChange, "变更保管期限不能为空") == false) {
								managerDetailsAfterChange.focus();
								return false
							}
							if(validate_required(managerDetailsReason, "变更事由不能为空") == false) {
								managerDetailsReason.focus();
								return false
							}else{
								$.ajax({
									url:"${pageContext.request.contextPath}/danganmanage/addManagerDetails2"+"?timestamp="+Math.random(),
									type:"post",
									beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
									dataType:"json",
									data:$("#formone").serialize(),
									async:false,
									cache:false,
									success:function(result){
										if(result==1){
											layer.msg("保管期限变更成功",{offset:'auto',time:3000},function(){
												 location.reload();
											});
										}else if(result==2){
											layer.msg("保管期限变更失败");
										}
									},
								});
							}
							
						}
					}
					//鉴定销毁校验
					function validate_form3(thisform){
						with(thisform) {
							if(validate_required(managerDetailsReason, "销毁事由不能为空") == false) {
								managerDetailsReason.focus();
								return false
							}else{
								$.ajax({
									url:"${pageContext.request.contextPath}/danganmanage/addManagerDetails2"+"?timestamp="+Math.random(),
									type:"post",
									beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
									dataType:"json",
									data:$("#formthree").serialize(),
									async:false,
									cache:false,
									success:function(result){
										if(result==1){
											layer.msg("鉴定销毁成功",{offset:'auto',time:3000},function(){
												 location.reload();
											});
										}else if(result==2){
											layer.msg("鉴定销毁失败");
										}
									},
								});
							}	
						}
					}
		</script>
</body>

</html>