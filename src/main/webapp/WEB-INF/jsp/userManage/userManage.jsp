<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>系统管理_用户管理</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/skin_01.css" id="skin"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userManage.css" />
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
    	
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
					<div class="layui-side-scroll">
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
					<p style="line-height: 38px;"><i class="fa fa-volume-up gong_color" style="padding:0 20px;"></i><span>
						<span class="gong_color">消息提示：</span> 您有
						<span>${requestScope.messageNum}</span>条
						<a href="${pageContext.request.contextPath}/messageNotification/goNotification" class="gong_color">未读</a>消息，请及时处理！</span>
					</p>
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
					<c:if test="${zm:buttenPremission('ba',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item">
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
						<li class="layui-nav-item layui-hide-xs ">
							<a href="${pageContext.request.contextPath}/roleManagement/getRoleList">角色管理</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bh',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs layui-this">
							<a href="${pageContext.request.contextPath}/user/getUserList">用户管理</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bi',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/loggingProduce/goSafetyManagement">安全管理</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
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
					<div class="layui-inline" style="padding-top: 10px;padding-left:10px;width: 100%;">
					   <form id="form8" onsubmit="return false"  name="form8">
						<div id="" style="float: right;padding-right: 20px;">
							<div class="layui-input-inline">
								<input type="text" name="conditions" id="conditions" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入关键字">
							</div>
							<button class="layui-btn layui-btn-normal" id="userQueryCondition">查询</button>
						</div>
						</form>
					</div>
					<table class="layui-hide" id="demo" lay-filter="demo" ></table>
					<script type="text/html" id="barDemo">
						<button class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">修改</button>
                         
						<button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>
					</script>
					<div id="" style="margin: 18px 20px;">
						<button class="layui-btn layui-btn-danger add_label2">重置密码</button>
						<button class="layui-btn layui-btn-warm" onclick="importExp();" style="margin-right:10px;">批量导入</button>
						    <form enctype="multipart/form-data" method="post"
								id="fileForm" style="display: inline;">
								<input type="file" name="excelName" id="fileContent" />
							</form>
						  
						 
						<button class="layui-btn" id="downloadTemplate">模板下载</button>
						<button class="layui-btn layui-btn-danger add_username">添加用户</button>
					</div>
				</div>
			</div>
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
	     <script src="${pageContext.request.contextPath}/js/jquery.lqper.js" type="text/javascript" charset="utf-8"></script>
		 <script src="${pageContext.request.contextPath}/js/cookie.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/userManage.js" charset="utf-8"></script>
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
		
			layui.use('table', function() {
				var table = layui.table;
				var $ = layui.$;
				//展示已知数据
				table.render({
					elem: '#demo',
					height: 500,
					url:"${pageContext.request.contextPath}/user/getAllUser"+"?timestamp="+Math.random(),
						cols: [
						[ //标题栏
							{
								type: 'checkbox',
								fixed: 'left'
							},
							 {
								type: 'numbers',
								title: '序号',
								width: 100,
								unresize: 'false',
								templet: '#indexTpl',
								
							},  {
								field: 'userName',
								title: '姓名',
								width: 100,
								unresize: 'false',
							}, {
								field: 'userSex',
								title: '性别',
								minWidth: 50,
								unresize: 'false',
							}, {
								field: 'userIdNumber',
								title: '身份证号',
								minWidth: 200,
								unresize: 'false',
							}, {
								field: 'userTelePhone',
								title: '手机号',
								width: 200,
								unresize: 'false',
							},
							{
								field: 'userWorkNumber',
								title: '工号',
								width: 100,
								unresize: 'false',
							},
							{
								field: 'quanzongName',
								title: '所属全宗',
								width: 200,
								unresize: 'false',
							},
							{
								field: 'organizationName',
								title: '所属部门',
								width: 200,
								unresize: 'false',
							},
							{
								field: 'roleName',
								title: '所属角色',
								width: 120,
								unresize: 'false',
							},
							{
								field: 'right',
								title: '操作',
								width: 200,
								fixed: 'right',
								unresize: 'false',
								toolbar: '#barDemo'
							}
						]
					], 
					even: true,
					page: true ,//是否显示分页,
					limit: 10,//每页默认显示的数量,
					 limits: [10,20,30,50],
				    done: function(res, curr, count){
				    //如果是异步请求数据方式，res即为你接口返回的信息。
				    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
				    /* console.log(res); */
				    
				    //得到当前页码
				    /* console.log(curr); */ 
				    
				    //得到数据总量
				    /* console.log(count); */
				   } 
					
				});
				
				//监听工具条
				table.on('tool(demo)', function(obj) {
					
					var data = obj.data;
					var tr = obj.tr;
					var userId=obj.data.userId;
					console.log(userId);
					var userName=obj.data.userName;
					if(obj.event === 'detail') {
						layer.msg('ID：' + data.id + ' 的查看操作');
					} else if(obj.event === 'del') {
						layer.confirm('您确定要删除该用户吗？', {
							title: '删除'
						}, function(index) {
							layer.close(index);
						/* 	if(roleName=='系统管理员'||roleName=='单位管理员'||roleName=='档案内部人员'||roleName=='单位领导'||roleName=='档案业务人员'||roleName=='公众'){
								layer.msg("该用户角色为系统内置角色,不能被删除");
								return;	
							}else{ */
								$.ajax({
									url:"${pageContext.request.contextPath}/user/deleteUserById"+"?timestamp="+Math.random(),
									type:"post",
									beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
									dataType:"text",
									cache:false,
									data:{"userId":userId},
									success:function(data){
										 if(data=="true"){
											 layer.msg("该用户已成功被删除",{offset:'auto',time:3000},function(){
												 location.reload();
											});
										}else{
											layer.msg("用户删除失败!");
										}
									},
								});
						  });
					} else if(obj.event === 'edit') {
						layer.open({
							type: 1,
							title: '<i class="fa fa-bars" style="padding:0 5px"></i>编辑用户',
							area: ['600px', '280px'],
							skin: 'add_label_bg',
							offset: 'auto',
							shade: [0.8, '#393D49'],
							//编辑弹出层
							content: 
								"<form id='formOne' class='username' onsubmit='return validate_form(this)' method='post' target='nm_iframe'>"+
								"<div><input type='hidden' name='userId' id='userId'/><label>姓名</label><input type='text' name='userName' id='userName'/>"+
								"<label>性别</label><input type='radio' name='userSex' id='man' value='男'/>男<input type='radio' name='userSex' id='woman' value='女'/>女</div>"+
								"<div><label>身份证号</label><input type='text' id='User_idnumber2' name='userIdNumber' maxlength='18'/>"+
								"<label>所属全宗</label><select name='quanzongId' id='quanzong_id2'>"+
								"<option value='' >请选择</option></select></div>"+
								"<div ><label>手机号</label><input type='text' id='User_telephone2' name='userTelePhone' maxlength='11' />"+
								"<label>所属机构</label><select name='organizationId' id='Organization_id2'>"+
								"<option value='' id='towfl'>请选择</option></select></div>"+
								"<div><label>工号</label><input type='text' name='userWorkNumber' id='userWorkNumber2'>"+
								"<label>所属角色</label><select name='roleId' id='Role_id2'>"+
								"<option value=''>请选择</option></select></div>"+
								"<div class='align'><button class='layui-btn btn_color' type='submit' >确定</button></div>"+"</form >"+
								" <iframe id='id_iframe' name='nm_iframe' style='display:none;'></iframe> ",
								
						}); 
						//遍历所属全宗信息444	
							$.ajax({
								url:"${pageContext.request.contextPath}/user/archiveLists"+"?timestamp="+Math.random(),
								type:'post',
								 beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
								dataType:"json",
								cache:false,
								success:function(data){
									if(data.length==0){
										$("#quanzong_id2").text("请选择");
									}else{
										for (var i = 0; i < data.length; i++) {
											$("#quanzong_id2").append("<option value='"+data[i].quanzongId+"'>"+data[i].quanzongName+"</option>");
										}
									}	
								},
							});
						//遍历所属角色
							 $.ajax({
								url:"${pageContext.request.contextPath}/user/RoleLists"+"?timestamp="+Math.random(),
								type:"post",
								 beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
								dataType:"json",
								cache:false,
								success:function(data){
									if(data.length==0){
										$("#Role_id2").text("请选择");
									}else{
										for (var i = 0; i < data.length; i++) {
											$("#Role_id2").append("<option value='"+data[i].roleId+"'>"+data[i].roleName+"</option>");
										}
									}	
								},
							});
						//所属全宗和所属机构级联下拉框二级联动遍历111
						 $("#quanzong_id2").bind('change',function(){ 
							 var quanzongId = $(this).val();
							 $.ajax({
								 url:"${pageContext.request.contextPath}/user/selectOrgByQuanzongId"+"?timestamp="+Math.random(),
								 type:"post",
								 beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
								 data:{"quanzongId":quanzongId},
								 dataType:"json",
								 cache:false,
								 success:function(data){
									 var newData = new Array();
									 newData = data;
									 $("#towfl").nextAll().remove();
									 if(newData.length == 0){		
										 $("#towfl").text("请选择")
									 }else{
										 for(var i=0;i<newData.length;i++){
											 $("#towfl").after("<option value="+newData[i].organizationId+">"+newData[i].organizationName+"</option>'");	 
										  }
									 }
								 },
							 });
						});
						
						//根据用户主键查询用户信息显示在layer弹窗中123
						$(document).ready(function(){
						setTimeout(function(){
								$.ajax({
									type:"post",
									url:"${pageContext.request.contextPath}/user/queryUserById"+"?timestamp="+Math.random(),
									 dataType:"json",
									 beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
									 cache:false,
									 data:{"userId":userId},
									   success:function(data){
										 console.log(data);
										 //获取该全宗下的机构信息
										 if(data.org != null && data.org != ""){
											 if(data.org.organizationId!=null && data.org.organizationId!=""){
												 jgglfunc(data.quanzongId,data.org.organizationId);
												 $(" select option[value='"+data.quanzongId+"']").attr("selected","selected");
											 }
												if(data.userSex!=null && data.userSex!=""){
													if(data.userSex=="男"){
														   $("#man").attr("checked","checked");
														 }else if(data.userSex=="女"){
														   $("#woman").attr("checked","checked");
														 }
												 }
											if(data.org.organizationId!=null && data.org.organizationId!=""){
												console.log(data.org.organizationId);
												   $(" select option[value='"+data.role.roleId+"']").attr("selected","selected");
											 }
										 }
	 
										 $("#userId").val(data.userId);
										 $("#userName").val(data.userName);
										   $("#User_idnumber2").val(data.userIdNumber);
										   $("#userWorkNumber2").val(data.userWorkNumber);
										   $("#User_telephone2").val(data.userTelePhone); 
									   },   
								});
							},2000)
						});
						
						var jgglfunc = function(quanzongId,organizationId){
							 $.ajax({
								 url:"${pageContext.request.contextPath}/user/selectOrgByQuanzongId"+"?timestamp="+Math.random(),
								 type:"post",
								 beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
								 data:{"quanzongId":quanzongId},
								 dataType:"json",
								 cache:false,
								 success:function(data){
									 var newData = new Array();
									 newData = data;
									 $("#towfl").nextAll().remove();
									 if(newData.length == 0){		
										 $("#towfl").text("请选择")
									 }else{
										 for(var i=0;i<newData.length;i++){
											 $("#towfl").after("<option value="+newData[i].organizationId+">"+newData[i].organizationName+"</option>'");	 
										  }
										 //dom元素先后顺序这个机构显示是第二个进行下拉框的数据渲染。。所以要放在这里
										 $(" select option[value='"+organizationId+"']").attr("selected","selected");
									 }
									 
								 },
							 });
						}
					}
				});
			});

			//重置密码
			$(function() {
				var table = layui.table;
				table.on('checkbox(demo)', function(obj) {
				});
				
				$(".add_label2").click(function() { //#btn为按钮id
					var checkStatus = table.checkStatus('demo')
					,data = checkStatus.data;
				     var str="";
				     if(data.length>0){
				    	 for(var i=0;i<data.length;i++){
								str+=data[i].userId+','+data[i].userName+';'
							}
							$.ajax({
								url:"${pageContext.request.contextPath}/user/resetPassword"+"?timestamp="+Math.random(),
								type:"post",
								beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
								 async:false,
								 dataType:"json",
								 cache:false,
								 data:{'str':str},
								 success:function(data){
									 if(data){
										 layer.open({
												type: 1,
												title: '<i class="fa fa-bars" style="padding:0 5px"></i>重置密码',
												area: ['400px', '240px'],
												skin: 'add_label_bg',
												offset: 'auto',
												shade: [0.8, '#393D49'],
												content: '<form method="post"><div style="height:150px;line-height:150px;font-weight: bold;text-align: center;">账号密码已重置,初始密码为123456</div><div style="text-align: center;"><button class="layui-btn btn_color" id="resetpassword">确定</button></div></form>'
											});
									 }else{
										 layer.msg("密码重置失败,请联系管理员");
									 }
								 },
							})
				      }else{
				    	  layer.msg("请勾选用户");
				      }
					
				});
				$("#resetpassword").click(function(){
					layer.closeAll();
				})
				
			});
			
			//添加用户
			$(function() {
				$(".add_username").click(function() { //#btn为按钮id
					layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>添加用户',
						area: ['600px', '280px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						content: 
							 "<form id='formTwo' class='username' onsubmit='return validate_form2(this)' method='post' target='nm_iframe2'>"+
								"<div><label>姓名</label><input type='text' name='userName' id='userName'/>"+
								"<label>性别</label><input type='radio' name='userSex' value='男'/>男<input type='radio' name='userSex' value='女'/>女</div>"+
								"<div><label>身份证号</label><input type='text' id='User_idnumber' name='userIdNumber' maxlength='18'/>"+
								"<label>所属全宗</label><select name='quanzongId' id='quanzong_id'>"+
								"<option value='' >请选择</option></select></div>"+
								"<div ><label>手机号</label><input type='text' id='User_telephone' name='userTelePhone' maxlength='11' />"+
								"<label>所属机构</label><select name='organizationId' id='Organization_id'>"+
								"<option value='' id='towfl2'>请选择</option></select></div>"+
								"<div><label>工号</label><input type='text' name='userWorkNumber' id='userWorkNumber'>"+
								"<label>所属角色</label><select name='roleId' id='Role_id'>"+
								"<option value=''>请选择</option></select></div>"+
								"<div class='align'><button class='layui-btn btn_color' type='submit' >确定</button></div>"+"</form >"+
								" <iframe id='id_iframe2' name='nm_iframe2' style='display:none;'></iframe> ",
					});
				    //遍历所属全宗
					 $.ajax({
						url:"${pageContext.request.contextPath}/user/archiveLists"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						dataType:"text",
						 cache:false,
						success:function(data){
							var archiveList=new Array();
							archiveList=data;
							var list=eval("("+archiveList+")");
							for (var i = 0; i < list.length; i++) {
								$("#quanzong_id").append("<option value='"+list[i].quanzongId+"'>"+list[i].quanzongName+"</option>");
							}
							
						},
					});
				    
					//遍历所属角色
					 $.ajax({
						url:"${pageContext.request.contextPath}/user/RoleLists"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						dataType:"text",
						 cache:false,
						success:function(data){
							var roleList = new Array();
							roleList = data;
							var list = eval("(" + roleList + ")");
							for (var i = 0; i < list.length; i++) {
								$("#Role_id").append("<option value='"+list[i].roleId+"'>"+list[i].roleName+"</option>");
							}
							
						},
					});
				    
					//所属全宗和所属机构级联下拉框二级联动遍历
					 $("#quanzong_id").bind('change',function(){ 
						 var quanzongId = $(this).val();
						 $.ajax({
							 url:"${pageContext.request.contextPath}/user/selectOrgByQuanzongId"+"?timestamp="+Math.random(),
							 type:"post",
							 beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							 async:false,
							 data:{"quanzongId":quanzongId},
							 dataType:"json",
							 cache:false,
							 success:function(data){
								 var newData = new Array();
								 newData = data;
								 $("#towfl2").nextAll().remove();
								 if(newData.length == 0){
									 $("#towfl2").nextAll().remove();
								 }else{
									 for(var i=0;i<newData.length;i++){
										 $("#towfl2").after("<option value="+data[i].organizationId+">"+data[i].organizationName+"</option>'");	 
									  }
								 }
							 },
						 });
					});
				});
			});

			//添加用户
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
						// 验证身份证 
						function isCardNo(card) { 
						 var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
						 return pattern.test(card); 
						} 
						
						// 验证手机号
						function isPhoneNo(phone) { 
						 var pattern = /^1[34578]\d{9}$/; 
						 return pattern.test(phone); 
						}
						//修改用户输入框校验	
						function validate_form(thisform) {
							with(thisform) {
								if(validate_required(userName, "姓名不能为空") == false) {
									userName.focus();
									return false
								}
								 if($.trim($('#User_idnumber2').val()).length == 0){
									layer.msg("身份证号码没有输入");
									return false
								}else if(isCardNo($.trim($('#User_idnumber2').val())) == false){
									layer.msg("身份证号码不正确,请重新输入");
									return false
								}
								
								 if($.trim($('#User_telephone2').val()).length == 0){
									layer.msg("手机号码没有输入");
									return false
								}else if(isPhoneNo($.trim($('#User_telephone2').val())) == false){
									layer.msg("手机号码不正确,请重新输入");
									return false
								}
								if(validate_required(userWorkNumber, "工号不能为空") == false) {
									userWorkNumber.focus();
								    return false
								}
								if($.trim($('input[name="userSex"]:checked').val()).length==0){
									layer.msg("请选择性别");
									return false
								}
								if($.trim($('#quanzong_id2').val()).length==0){
									layer.msg("请选择所属全宗");
									return false
								}else if($.trim($('#Organization_id2').val()).length==0){
									layer.msg("请选择所属机构");
									return false
								}else if($.trim($('#Role_id2').val()).length==0){
									layer.msg("请选择所属角色");
									return false
								}else{
									
									 $.ajax({//调用后台修改方法
										url:"${pageContext.request.contextPath}/user/UpdateUser"+"?timestamp="+Math.random(),
										type:"post",
										beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
										dataType:"text",
										data:$("#formOne").serialize(),
										async:false,
										cache:false,
										success:function(result){
										 	//123
											if (result != null) {
												layer.msg("用户修改成功!",{offset:'auto',time:3000},function(){
													 location.reload();
												});
											}else{
												layer.msg("用户修改失败");
											}
											
										},
									}); 
									
								}	 
							}		
						}
						//添加用户输入框校验	
						function validate_form2(thisform) {
							with(thisform) {
								if(validate_required(userName, "姓名不能为空") == false) {
									userName.focus();
									return false
								} 
								 if($.trim($('#User_idnumber').val()).length == 0){
									layer.msg("身份证号码没有输入");
									return false
								}else if(isCardNo($.trim($('#User_idnumber').val())) == false){
									layer.msg("身份证号码不正确,请重新输入");
									return false
								}else if($.trim($('#User_telephone').val()).length == 0){
									layer.msg("手机号码没有输入");
									return false
								}else if(isPhoneNo($.trim($('#User_telephone').val())) == false){
									layer.msg("手机号码不正确,请重新输入");
									return false
								}
								if(validate_required(userWorkNumber, "工号不能为空") == false) {
									userWorkNumber.focus();
								    return false
								}
								if($.trim($('input[name="userSex"]:checked').val()).length==0){
									layer.msg("请选择性别");
									return false
								}
								if($.trim($('#quanzong_id').val()).length==0){
									layer.msg("请选择所属全宗");
									return false
								}else if($.trim($('#Organization_id').val()).length==0){
									layer.msg("请选择所属机构");
									return false
								}else if($.trim($('#Role_id').val()).length==0){
									layer.msg("请选择所属角色");
									return false
								}else{
									 $.ajax({//调用后台添加方法
										url:"${pageContext.request.contextPath}/user/addOrUpdateUser"+"?timestamp="+Math.random(),
										type:"post",
										beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
										dataType:"json",
										data:$("#formTwo").serialize(),
										async:false,
										cache:false,
										success:function(result){
											if(result==1){
												layer.msg("对不起,用户名已存在!",{time:3000});
											}else if(result==2){
												layer.msg("对不起,身份证号已存在!",{time:3000});
											}else if(result==3){
												layer.msg("对不起,手机号已存在!",{time:3000});
											}else if(result==4){
												layer.msg("对不起,工号已存在!",{time:3000});
											}else if(result==6){
												layer.msg("用户添加成功",{offset:'auto',time:3000},function(){
													 location.reload();
												});
											}else{
												layer.msg("用户添加失败",{time:3000});
											}
										},
										
									}); 
								}
								 
							}
								
						}
						
						//数据导入
						function importExp(){
							var files = $('input[name="excelName"]').prop('files');//获取到文件列表
							if(files.length == 0){
							  layer.msg('请选择文件');
							  return;
							}else{
								var formData = new FormData($( "#fileForm" )[0]);
							    var name = $("#fileContent").val();
								 var reg = /^.*\.(?:xls|xlsx)$/i; 
						         if (!reg.test(name)) {//校验是否是excel格式的文件
						        	 layer.msg("请上传excel格式的文件!");
						             return;
						         }  
						       $.ajax({
						    	  url : '${pageContext.request.contextPath}/user/uploadFile',
									type : "post",
									async : false,
									dataType : "json",
									data : formData,
							        processData : false,
							        contentType : false,
									success : function(result) {
										if(result==1){
											layer.msg("所属全宗名称不存在,导入失败");
										}else if(result==2){
											layer.msg("所属机构不存在,导入失败");
										}else if(result==3){
											layer.msg("所属角色不存在,导入失败");
										}else if(result==4){
											layer.msg("用户名已存在,导入失败");
										}else if(result==5){
											layer.msg("身份证号已存在,导入失败");
										}else if(result==6){
											layer.msg("手机号已存在,导入失败");
										}else if(result==7){
											layer.msg("工号已存在,导入失败");
										}else if(result==8){
											layer.msg("用户名不能为空,导入失败");
										}else if(result==9){
											layer.msg("身份证号不能为空,导入失败");
										}else if(result==10){
											layer.msg("手机号不能为空,导入失败");
										}else if(result==11){
											layer.msg("工号不能为空,导入失败");
										}else if(result==12){
											layer.msg("所属全宗不能为空,导入失败");
										}else if(result==13){
											layer.msg("所属机构不能为空,导入失败");
										}else if(result==14){
											layer.msg("所属角色不能为空,导入失败");
										}else if(result==15){
											layer.msg("恭喜你,用户导入成功");
										}
										
									},
									error:function(){
										layer.msg("导入异常");
									}
									
								});
						       
							}
						}	
		</script>
	</body>

</html>