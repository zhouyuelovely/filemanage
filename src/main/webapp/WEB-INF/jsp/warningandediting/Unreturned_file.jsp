<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>监测预警_未归还档案</title>
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
					<p style="line-height: 38px;"><i class="fa fa-volume-up gong_color" style="padding:0 20px;"></i><span>
						<span class="gong_color">消息提示：</span> 您有
						<span>${requestScope.messageNum}</span>条
						<a href="${pageContext.request.contextPath}/messageNotification/goNotification" class="gong_color">未读</a>消息，请及时处理！</span>
					</p>
				</div>
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						<li class="layui-nav-item">
							<a href="${pageContext.request.contextPath}/expiredFile/goDaoQi">到期档案</a>
						</li><span class="layui-hide-xs span_color">|</span>
						<li class="layui-nav-item layui-this">
							<a href="${pageContext.request.contextPath}/borrowingFile/goGuiHuan">未归还档案</a>
						</li>
					</ul>
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;">
					<div class="layui-inline" style="padding-top: 10px;width: 100%;">
						<div style="float: left;width: 100%;" id="form_catalog">
							<form class="layui-form" action="">
								<div class="layui-form-item">
									<label class="layui-form-label">归还预警</label>
									<div class="layui-input-inline">
										<select name="surplusDays" id="surplusDays" lay-verify="">
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
								 	<table class="layui-hide" id="demot" lay-filter="demot"></table>
								 </div>
								<script type="text/html" id="barDemo">
								  <!-- 这里同样支持 laytpl 语法，如： -->
								    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
								</script>
								<div id="" style="margin: 18px 0;" class="layui-btn-group demoTable">
									<span style="margin:0 15px;">合计：<b>${total}</b>件</span><button class="layui-btn layui-btn-danger" id="change_period" data-type="getCheckLength">催还</button>
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
		<script src="${pageContext.request.contextPath}/layui/lay/date-format.js" type="text/javascript" charset="utf-8"></script>
		<!--[if IE 6]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
         </script>
         <script id="createTime" type="text/html">
    {{#   
    var date = new Date();
    date.setTime(d.startDate);
    date.setTime(d.endDate);
    return date.Format("yyyy-MM-dd"); 
    }} 
    </script>
		<script>
			//催还
			layui.use('table', function(){
				  var table = layui.table;
				  //监听表格复选框选择
				  table.on('checkbox(demot)', function(obj){
				    console.log(obj)
				  });
			
				var $ = layui.$, active = {
				    getCheckLength: function(){ //获取选中数目
				      var checkStatus = table.checkStatus('demot')
				      ,data = checkStatus.data;
				      if (data.length <= 0) {
				    	  layer.msg('请选择要催还的档案！');
						}else{
							var messageCreator = "${user.userName}";
						    $.ajax({
								  url:"${pageContext.request.contextPath}/borrowingFile/insertMessage"+"?timestamp="+Math.random(),
								  type:"post",
									 beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
									    data:{"messageCreator":messageCreator},
									 dataType:"json",
									 cache:false,
									 success:function(data){
									 },
									 error:function(data){
										 layer.msg('催还成功');
									 },
							  });
						}
				      
				    }
				}
				$('.demoTable .layui-btn').on('click', function(){
				    var type = $(this).data('type');
				    active[type] ? active[type].call(this) : '';
				  });
			})
		
		//下拉框查询
		 layui.use('form',function(){
			   var form=layui.form; 
			   var table = layui.table;
			   form.on('select', function(data){
					  console.log(data.value); //得到被选中的值
						  var surplusDays = data.value;
						  table.reload('demot', {
							  url:'${pageContext.request.contextPath}/borrowingFile/selectByEndDate',
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
						//展示已知数据
						table.render({
							elem: '#demot',
							url:'${pageContext.request.contextPath}/borrowingFile/selectAllBorrowingFile',
							cols: [
								[ //标题栏
									{
										type: 'checkbox',
										fixed: 'left'
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
										field: 'startDate',
										title: '借阅日期',
										width: 150,
										unresize: 'false',
										//templet: '#createTime',
									},
									{
										field: 'endDate',
										title: '归还日期',
										width: 150,
										unresize: 'false',
										//templet: '#createTime',
									},
									{
										field: 'surplusDays',
										title: '归还预警',
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
						table.on('tool(demot)', function(obj) {
							var data = obj.data;
							var tr = obj.tr;
							var archivefileId = obj.data.archivefileId;
							console.log(obj.data)
							if(obj.event === 'detail') {
								$.ajax({
									url:"${pageContext.request.contextPath}/archiveFileStore/havingFileAttachmentList?meng="+<%=Math.random() %>,
									type:"post",
									data:"archiveFileId="+archivefileId,
									dataType:"json",
									success:function(result){
										console.log(archivefileId);
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
						    }
						});
					});
						function img_vi() {
							$('.Scanning_Images').viewer();
						}
		</script>
	</body>

</html>