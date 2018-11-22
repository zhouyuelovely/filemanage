
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>档案管理_历史数据管理</title>
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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/historymanagement.css" />
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
						<li class="layui-nav-item  layui-hide-xs layui-this"><c:if
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
					<c:if test="${zm:buttenPremission('bc',sessionScope.user.role.authorities) }">
				<p style="line-height: 38px;">
					<i class="fa fa-volume-up gong_color" style="padding: 0 20px;"></i><span>
						<span class="gong_color">消息提示：</span> 您有<span>${messageNum}</span>条<a
						href="${pageContext.request.contextPath}/messageNotification/goNotification"
						class="gong_color">未读</a>消息，请及时处理！
						
					</span>
					
				</p>	
			</c:if>
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						<c:if test="${zm:buttenPremission('da',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
								<a href="${pageContext.request.contextPath}/danganmanage/goboxmanagement">新增数据管理</a>
								<!-- INSERT INTO "SCOTT"."AM_MA_SM_PERMISSION" VALUES ('33', '以盒管理', '/danganmanage/goboxmanagement', '/danganmanage/boxmanagement', 'da'); -->
							</li>
							<span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('dc',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item layui-this">
								<a href="${pageContext.request.contextPath}/danganmanage/gohistorymanagement">历史数据管理</a>
							</li>
							<span class="layui-hide-xs span_color">|</span>
						</c:if>
						<c:if test="${zm:buttenPremission('dd',sessionScope.user.role.authorities) }">
							<li class="layui-nav-item">
							 	<a href="${pageContext.request.contextPath}/danganmanage/goboxdatareview">档案审核</a>
							</li>
						</c:if>
					</ul>
					
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-fluid">
						<div class="layui-form">
							<div class="layui-row layui-col-space10 layui-form-item">
							 <form class="layui-form">
								<div class="layui-col-lg2">
									<label class="layui-form-label">全宗名称：</label>
									<div class="layui-input-block">
										<select name="quanzongName" lay-filter="quanzongName" id="quanzongName">
											<option value="">请选择</option>
											<c:forEach items="${listquanzongName}" var="quanzong">
											  <option value="${quanzong.quanzongName}">${quanzong.quanzongName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="layui-col-lg2">
									<label class="layui-form-label">档案类型：</label>
									<div class="layui-input-block">
										<select name="historydataType" lay-filter="historydataType" id="historydataType">
											<option value="" id="towfl">请选择</option>	
										</select>
									</div>
								</div>
								<div class="layui-col-lg2">
									<label class="layui-form-label">年度：</label>
									<div class="layui-input-block">
										<select name="historydataArchivalYear" lay-filter="historydataArchivalYear" id="historydataArchivalYear">
											<option value="" id="towfl2">请选择</option>				
										</select>
									</div>
								</div>
								<div class="layui-col-lg2">
									<label class="layui-form-label">保管期限：</label>
									<div class="layui-input-block">
										<select name="retentionperiodname" lay-filter="retentionperiodname" id="retentionperiodname">
											<option value="" id="towfl3">请选择</option>
										</select>
									</div>
								</div>
								</form>
								<div class="layui-col-lg-offset1 layui-col-lg3">
									<div class="layui-input-inline">
										<input type="text" id="conditions" name="conditions" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入关键字查询">
									</div>
									<c:if test="${zm:buttenPremission('dca',sessionScope.user.role.authorities) }">
									<button class="layui-btn layui-btn-normal" id="historyConditionsBtn">查询</button>
									</c:if>
								</div>
							</div>
							<div class="layui-card layui-clear">
								<div class="layui-card-body">
									<table class="layui-hide" id="description_tabel" lay-filter="description_tabel"></table>
									<div id="" style="margin: 18px 0px;">
										<label for="">档案合计：</label>
										<span id="countHistoryData"></span>件&nbsp;
										<span id="countHistoryDataPages"></span>页
										<c:if test="${zm:buttenPremission('dcd',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-sm layui-btn-warm" id="change_period">保管期限变更</button>
										</c:if>
										<c:if test="${zm:buttenPremission('dce',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-sm" id="classification_period">密级变更</button>
										</c:if>
										<c:if test="${zm:buttenPremission('dcf',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-sm layui-btn-danger" id="destruction">鉴定销毁</button>
										</c:if>
										<c:if test="${zm:buttenPremission('dcg',sessionScope.user.role.authorities) }">
										<button class="layui-btn layui-btn-sm layui-btn-normal" id="CD_manufacturing">光盘制作</button>
										</c:if>
									</div>
								</div>
							</div>
						</div>
						<script type="text/html" id="barDemo">
							<!-- 这里同样支持 laytpl 语法，如： -->
							<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
							<a href="${pageContext.request.contextPath}/danganmanage/gohistorysubsidiary" class="layui-btn layui-btn-danger layui-btn-xs">管理明细</a>
						</script>
						<script type="text/html" id="barDemo2">
							<input type="radio" name="radio" lay-event="radio" lay-ignore/>
						</script>
					</div>
					<!-- 辅助元素，一般用于移动设备下遮罩 -->
					<div class="layadmin-body-shade" layadmin-event="shade"></div>
				</div>
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
				<script>DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');</script>
			<![endif]-->
			<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
         </script>
		<script>
		layui.use('form',function(){
			   var form=layui.form; 
			   form.on('select(quanzongName)', function(data){
					  console.log(data); //得到被选中的值
						  var quanzongName = data.value;
						  $.ajax({
							  url:"${pageContext.request.contextPath}/danganmanage/queryPcByquanzongName3"+"?timestamp="+Math.random(),
							  type:"post",
								 beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
								 data:{"quanzongName":quanzongName},
								 dataType:"json",
								 cache:false,
								 async:false,
								 success:function(data){
									 console.log(data);
									$("#towfl").nextAll().remove();
									$("#towfl2").nextAll().remove();
									$("#towfl3").nextAll().remove();
									 for(var i=0;i<data.length;i++){
										 $("#towfl").after("<option value="+data[i].historydataType+">"+data[i].historydataType+"</option>"); 
									 }
						  			      //只有执行了这一步，部分表单元素才会自动修饰成功
						  			      form.render();   
								 },
						  });  
			       });  
		     });
		   
		   layui.use('form',function(){
			   var form=layui.form;
			    form.on('select(historydataType)',function(data){
			    	  console.log(data)
			    	  var historydataType=data.value;
			    	  var quanzongName=$("#quanzongName").val();
			    	  $.ajax({
						  url:"${pageContext.request.contextPath}/danganmanage/queryBoxAnualByquanzongNameAndPcName3"+"?timestamp="+Math.random(),
						  type:"post",
							 beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							 data:{"quanzongName":quanzongName,"historydataType":historydataType},
							 dataType:"json",
							 cache:false,
							 async:false,
							 success:function(data){
								 console.log(data);
								$("#towfl2").nextAll().remove();
								 for(var i=0;i<data.length;i++){
									 $("#towfl2").after("<option value="+data[i].historydataArchivalYear+">"+data[i].historydataArchivalYear+"</option>"); 
								 }
					  			      //只有执行了这一步，部分表单元素才会自动修饰成功
					  			      form.render();   
							 },
					  });
			      })
		   })
		   
		    layui.use('form',function(){
			   var form=layui.form;
			    form.on('select(historydataArchivalYear)',function(data){
			    	  console.log(data)
			    	  var historydataArchivalYear=data.value;
			    	  var quanzongName=$("#quanzongName").val();
			    	  var historydataType=$("#historydataType").val();
			    	  $.ajax({
						  url:"${pageContext.request.contextPath}/danganmanage/queryRpNameByquanzongNameAndPcNameAndBoxAnual3"+"?timestamp="+Math.random(),
						  type:"post",
							 beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
							 data:{"quanzongName":quanzongName,"historydataType":historydataType,"historydataArchivalYear":historydataArchivalYear},
							 dataType:"json",
							 cache:false,
							 async:false,
							 success:function(data){
								 console.log(data);
								$("#towfl3").nextAll().remove();
								 for(var i=0;i<data.length;i++){
									 $("#towfl3").after("<option value="+data[i].retentionperiodname+">"+data[i].retentionperiodname+"</option>"); 
								 }
					  			      //只有执行了这一步，部分表单元素才会自动修饰成功
					  			      form.render();   
							 },
					  });
			      })
		   })
		   
		   layui.use('form', function() {
				var form = layui.form;
				var $ = layui.$;
				var table = layui.table;
				form.on('select(retentionperiodname)', function(data){
					var quanzongName=$("#quanzongName").val();
					var	historydataArchivalYear=$("#historydataArchivalYear").val();
					var historydataType = $("#historydataType").val();
					var retentionperiodname=data.value;
					table.reload('description_tabel', {
						  url: "${pageContext.request.contextPath}/danganmanage/queryAllHistoryData"+"?timestamp="+Math.random()
						  ,where: {quanzongName:quanzongName,
							       historydataArchivalYear:historydataArchivalYear,
							       historydataType:historydataType,
							  	   retentionperiodname:retentionperiodname,} //设定异步数据接口的额外参数
					    ,page: {
					    curr: 1 //重新从第 1 页开始
					   }  
					});
					
					$.ajax({
						url:"${pageContext.request.contextPath}/danganmanage/queryHistoryDataByCondition?meng="+<%=Math.random() %>,
						data:{"quanzongName":quanzongName,"historydataType":historydataType,"historydataArchivalYear":historydataArchivalYear,"retentionperiodname":retentionperiodname},
						type:"post",
						dataType:"json",
						success:function(num){
							console.log(num)
							 $("#countHistoryData").html(num.archiveFileNumber);
							$("#countHistoryDataPages").html(num.archiveFilePage);
						},
						error:function(){
							layer.msg("发生未知错误请联系管理员")
						}
					})
					
			  	})
			});
		   
			function img_vi() {
				$('.Scanning_Images').viewer();
			}
			layui.use('table', function() {
				var table = layui.table;
				var $ = layui.$;
				//展示已知数据
				table.render({
					elem: '#description_tabel',
					url:'${pageContext.request.contextPath}/danganmanage/selectAllHistoryData'+"?timestamp="+Math.random(),
					cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
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
								width: 100,
								unresize: 'false',
								templet: '#indexTpl',
							},
							{
								field: 'historydataNumber',
								title: '档号',
								unresize: 'false',
							}, {
								field: 'historydataReferencenumber',
								title: '文件编号',
								unresize: 'false',
							}, {
								field: 'historydataAFResponsible',
								title: '责任者',
								unresize: 'false',
							},
							{
								field: 'historydataTitle',
								title: '文件题名',
								unresize: 'false',
							},
							{
								field: 'historydataFiledate',
								title: '成文日期',
								unresize: 'false',
							},
							{
								field: 'historydataSecurityLevel',
								title: '密级',
								unresize: 'false',
							},
							{
								field: 'historydataPages',
								title: '页数',
								unresize: 'false',
							},
							{
								field: 'historydataNotes',
								title: '附注',
								unresize: 'false',
							},
							{
								field: 'historydataBoxNumber',
								title: '盒号',
								unresize: 'false',
							},
							{
								field: 'right',
								title: '操作',
								unresize: 'false',
								width:150,
								toolbar: '#barDemo'
							},
						]
					],
					
					even: true,
					page: true //是否显示分页
						,
						limit:10  //默认十条数据一页  
					    ,limits:[10,20,30,50]  //数据分页条  
				});
				var historydataNum=${historydataNum};
				var historydataPagesNum=${historydataPagesNum};
				 $("#countHistoryData").html(historydataNum);
					$("#countHistoryDataPages").html(historydataPagesNum);
					
				table.on('tool(description_tabel)', function(obj) {
					var data = obj.data;
					var tr = obj.tr;
                    var historydataId=data.historydataId;
                    
					if(obj.event === 'detail') {
						
						$.ajax({
							url:"${pageContext.request.contextPath}/danganmanage/queryHistoryAnnexByHistoryId?meng="+<%=Math.random() %>,
							type:"post",
							data:"historydataId="+historydataId,
							dataType:"json",
							success:function(result){
								console.log(historydataId);
								console.log(result);
								var text="";
								text+="<div class='add_lb1'><ul class='Scanning_Images' onclick='img_vi()''>"
								for(var i=0;i<result.length;i++){
									var url='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'+result[i].historyannexPath;
									console.log(url);
									text+="<li><img src='"+url+"?"+Math.random()+"' alt=''></li>"
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
				    	 var historydataSecurityLevel=obj.data.historydataSecurityLevel;
				    	 var retentionperiodname=obj.data.retentionperiodname;
				    	 $("#change_period").click(function() { //#btn为按钮id
							 var managerDetailsApplication='保管期限变更';
								layer.open({
									type: 1,
									title: '<i class="fa fa-bars" style="padding:0 5px"></i>保管期限变更',
									area: ['380px', '400px'],
									skin: 'add_label_bg',
									offset: 'auto',
									shade: [0.8, '#393D49'],
									cancel: function(){ 
										window.location.reload();
									},
									content: "<form id='formone' method='post' onsubmit='return validate_form(this)' class='layui-form' target='nm_iframe'>"+
								     "<div class='layui-form-item' style='padding-top: 15px;'>"+
								     "<input type='hidden' name='managerDetailsApplication' id='managerDetailsApplication' value='"+managerDetailsApplication+"'/>"+
								     "<input type='hidden' name='id' id='historydataId' value='"+obj.data.historydataId+"'/>"+
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
						         document.getElementById("managerDetailsBeforeChange").value=retentionperiodname;
								
							  });
						 
						//密级变更弹出层
							$("#classification_period").click(function() { //#btn为按钮id
								var managerDetailsApplication="密级变更";
								layer.open({
									type: 1,
									title: '<i class="fa fa-bars" style="padding:0 5px"></i>密级变更',
									area: ['380px', '400px'],
									skin: 'add_label_bg',
									offset: 'auto',
									shade: [0.8, '#393D49'],
									cancel: function(){ 
										window.location.reload();
									},
									content:'<form id="formtwo" method="post" onsubmit="return validate_form2(this)" class="layui-form" target="nm_iframe2">'+
								'<div class="layui-form-item" style="padding-top: 15px;">'+
								 "<input type='hidden' name='managerDetailsApplication' id='managerDetailsApplication2' value='"+managerDetailsApplication+"'/>"+
							     "<input type='hidden' name='id' id='historydataId2' value='"+obj.data.historydataId+"'/>"+
									'<label class="layui-form-label">申请人:</label>'+
									'<div class="layui-input-inline">'+
										'<input type="text" name="managerDetailsPerson" id="managerDetailsPerson2" class="layui-input" readonly>'+
									'</div>'+
								'</div>'+
								'<div class="layui-form-item">'+
									'<label class="layui-form-label">申请时间:</label>'+
									'<div class="layui-input-inline">'+
										'<input type="text" name="managerDetailsTime" id="managerDetailsTime2" class="layui-input" readonly>'+
									'</div>'+
								'</div>'+
								'<div class="layui-form-item">'+
									'<label class="layui-form-label">原密级:</label>'+
									'<div class="layui-input-inline">'+
										'<input type="text" name="managerDetailsBeforeChange" id="managerDetailsBeforeChange2" class="layui-input" readonly>'+
									'</div>'+
								'</div>'+
								'<div class="layui-form-item">'+
									'<label class="layui-form-label">变更密级:</label>'+
									'<div class="layui-input-inline">'+
										'<input type="text" name="managerDetailsAfterChange" id="managerDetailsAfterChange2"  class="layui-input" >'+
									'</div>'+
								'</div>'+
								'<div class="layui-form-item">'+
									'<label class="layui-form-label">变更事由:</label>'+
									'<div class="layui-input-inline">'+
										'<input type="text" name="managerDetailsReason" id="managerDetailsReason2"  class="layui-input" >'+
									'</div>'+
								'</div>'+
								'<div class="layui-form-item" style="text-align: center;">'+
									'<button class="layui-btn layui-btn-danger">确定</button>'+
								'</div>'+
						   '</form>'+ " <iframe id='id_iframe2' name='nm_iframe2' style='display:none;'></iframe> ",
								});
								 var managerDetailsPerson=new String('${user.userName}');
								
								   document.getElementById("managerDetailsPerson2").value=managerDetailsPerson;
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
							         document.getElementById("managerDetailsTime2").value=mytime; 
								    document.getElementById("managerDetailsBeforeChange2").value=historydataSecurityLevel;
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
									cancel: function(){ 
										window.location.reload();
									},
									content:'<form id="formthree" method="post" onsubmit="return validate_form3(this)" class="layui-form" target="nm_iframe3">'+
								  '<div class="layui-form-item" style="padding-top: 15px;">'+
								  "<input type='hidden' name='managerDetailsApplication' id='managerDetailsApplication3' value='"+managerDetailsApplication+"'/>"+
								     "<input type='hidden' name='id' id='historydataId3' value='"+obj.data.historydataId+"'/>"+
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
							//光盘制作弹出层
							$("#CD_manufacturing").click(function() { //#btn为按钮id
								var managerDetailsApplication="光盘制作";
								layer.open({
									type: 1,
									title: '<i class="fa fa-bars" style="padding:0 5px"></i>光盘制作',
									area: ['380px', '400px'],
									skin: 'add_label_bg',
									offset: 'auto',
									shade: [0.8, '#393D49'],
									cancel: function(){ 
										window.location.reload();
									},
									content:'<form id="formfour" method="post" onsubmit="return validate_form4(this)" class="layui-form" target="nm_iframe4">'+
								'<div class="layui-form-item" style="padding-top: 15px;">'+
								 "<input type='hidden' name='managerDetailsApplication' id='managerDetailsApplication4' value='"+managerDetailsApplication+"'/>"+
							     "<input type='hidden' name='id' id='historydataId4' value='"+obj.data.historydataId+"'/>"+
									'<label class="layui-form-label">申请人:</label>'+
									'<div class="layui-input-inline">'+
										'<input type="text" name="managerDetailsPerson" id="managerDetailsPerson4"  class="layui-input" readonly>'+
									'</div>'+
								'</div>'+
								'<div class="layui-form-item">'+
									'<label class="layui-form-label">申请时间:</label>'+
									'<div class="layui-input-inline">'+
										'<input type="text" name="managerDetailsTime" id="managerDetailsTime4"  class="layui-input" readonly>'+
									'</div>'+
								'</div>'+
								'<div class="layui-form-item">'+
									'<label class="layui-form-label">制作事由:</label>'+
									'<textarea name="managerDetailsReason" id="managerDetailsReason4" style="margin: 0px; width: 190px; height: 150px;"></textarea>'+
								'</div>'+
								'<div class="layui-form-item" style="text-align: center;">'+
									'<button class="layui-btn layui-btn-danger">确定</button>'+
								'</div>'+
							'</form>'+ " <iframe id='id_iframe4' name='nm_iframe4' style='display:none;'></iframe> ",
								});
								var managerDetailsPerson=new String('${user.userName}');
								   document.getElementById("managerDetailsPerson4").value=managerDetailsPerson;
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
							         document.getElementById("managerDetailsTime4").value=mytime; 
								
							});
				    }
			    });
			});
			
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
			//密级变更校验
			function validate_form2(thisform){
				with(thisform) {
					if(validate_required(managerDetailsAfterChange, "变更密级不能为空") == false) {
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
							data:$("#formtwo").serialize(),
							async:false,
							cache:false,
							success:function(result){
								if(result==1){
									layer.msg("密级变更成功",{offset:'auto',time:3000},function(){
										 location.reload();
									});
								}else if(result==2){
									layer.msg("密级变更失败");
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
			//光盘制作校验
			function validate_form4(thisform){
				with(thisform) {
					if(validate_required(managerDetailsReason, "制作事由不能为空") == false) {
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
							data:$("#formfour").serialize(),
							async:false,
							cache:false,
							success:function(result){
								if(result==1){
									layer.msg("光盘制作成功",{offset:'auto',time:3000},function(){
										 location.reload();
									});
								}else if(result==2){
									layer.msg("光盘制作失败");
								}
							},
						});
					}	
				}
			}
			//关键词查询历史数据
			$().ready(function(){
				var table = layui.table;
				$("#historyConditionsBtn").click(function(){
					var conditions=$("#conditions").val();
					table.reload('description_tabel', {
						  url:'${pageContext.request.contextPath}/danganmanage/queryHistoryDataByConditions'+"?timestamp="+Math.random(),
						  where: { //设定异步数据接口的额外参数，任意设
							  conditions: conditions,
						  }
						  ,page: {
						    curr: 1 //重新从第 1 页开始
						  }  
						});
					$.ajax({
						url:"${pageContext.request.contextPath}/danganmanage/queryHistoryDataConditionNum?meng="+<%=Math.random() %>,
						data:{"conditions":conditions},
						type:"post",
						dataType:"json",
						success:function(num){
							console.log(num)
							 $("#countHistoryData").html(num.archiveFileNumber);
							$("#countHistoryDataPages").html(num.archiveFilePage);
						},
						error:function(){
							layer.msg("发生未知错误请联系管理员")
						}
					})	
					
				})
			})
			

		</script>
		
	</body>

</html>