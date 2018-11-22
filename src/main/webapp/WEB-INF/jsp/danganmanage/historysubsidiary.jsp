 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>档案管理_历史数据管理明细</title>
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
			
			.gong_color {
				color: red;
				font-weight: bold;
			}
			.viewer-container,
			.viewer-fixed,
			.viewer-fade,
			.viewer-transition,
			.viewer-in {
				z-index: 99999999999!important;
				/*弹出层与图片预览层级*/
			}
			.font_color{
				color: #EA5519;
				font-weight: 300;
			}
			#tba{
				padding-left: 15px;
				padding-bottom: 15px;
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
							<li class="layui-nav-item ">
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
						<div id="tba">
					 		<span style="line-height: 20px;padding-left: 10px;">
					 			<i class="fa fa-step-forward font_color"></i>
					 			<c:if test="${zm:buttenPremission('dc',sessionScope.user.role.authorities) }">
					 			<a href="${pageContext.request.contextPath}/danganmanage/gohistorymanagement" class="font_color">历史数据管理&gt;&gt;</a><span>管理明细</span>
					 			</c:if>
					 		</span>
					 	</div>

						<div class="layui-form">
							<div class="layui-row layui-col-space10 layui-form-item">
								<div class="layui-col-lg2">
									<label class="layui-form-label">申请项：</label>
									<div class="layui-input-block">
										<select name="managerDetailsApplication" lay-filter="managerDetailsApplication" id="managerDetailsApplication">
											<option value="">请选择</option>
											<option value="保管期限变更">保管期限变更</option>
											<option value="密级变更">密级变更</option>
											<option value="鉴定销毁">鉴定销毁</option>
											<option value="光盘制作">光盘制作</option>
										</select>
									</div>
								</div>
								<div class="layui-col-lg2">
									<label class="layui-form-label">申请人：</label>
									<div class="layui-input-block">
										<select name="managerDetailsPerson" lay-filter="managerDetailsPerson" id="managerDetailsPerson">
											<option value="">请选择</option>
											<c:forEach items="${userList}" var="user">
											<option value="${user.userName}">${user.userName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="layui-col-lg6">
									<label class="layui-form-label">申请时间：</label>
									<div class="layui-input-inline" style="float: left;">
										<input type="text" name="managerDetailsTime" id="startTime" lay-verify="required|phone" autocomplete="off" class="layui-input dateone" placeholder="请选择开始时间">
									</div>
									<div class="layui-input-inline" style="float: left;">
										<input type="text" name="managerDetailsTime" id="endTime" lay-verify="required|phone" autocomplete="off" class="layui-input datetwo" placeholder="请选择结束时间">
									</div>
									<div class="layui-col-lg-offset1 layui-col-lg3">
									<button class="layui-btn layui-btn-normal" id="historyConditionsBtn">查询</button>
								</div>
								</div>
								
							</div>
							<div class="layui-card layui-clear">
								<div class="layui-card-body">
									<table class="layui-hide" id="description_tabel" lay-filter="description_tabel"></table>
								</div>
							</div>
						</div>
						<script type="text/html" id="barDemo">
							<!-- 这里同样支持 laytpl 语法，如： -->
						{{#  if(d.managerDetailsStatus == 3 && d.managerDetailsApplication=='鉴定销毁'){  }}<a class="layui-btn layui-btn-xs" lay-event="destruction">销毁</a>
		 					{{#  } else if(d.managerDetailsStatus ==3 && d.managerDetailsApplication=='光盘制作'){ }}<a class="layui-btn layui-btn-xs" lay-event="download">下载</a>
							{{#  }  }}
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
		//时间插件
		layui.use(['layer', 'laydate'], function(){ 
			  var layer = layui.layer // 获取layer组件
			  ,laydate = layui.laydate; // 获取laydate组件
			  //执行一个laydate实例
				laydate.render({
				  elem: '.dateone', //指定元素
				  type: 'date',//日期时间
				  format: 'yyyy-M-dd HH:mm',//日期时间格式
					  range: false,
				});
			});
		//时间插件
		layui.use(['layer', 'laydate'], function(){ 
			  var layer = layui.layer // 获取layer组件
			  ,laydate = layui.laydate; // 获取laydate组件
			  //执行一个laydate实例
				laydate.render({
				  elem: '.datetwo',//指定元素
				  type: 'date',//日期时间
				  format: 'yyyy-M-dd HH:mm',//日期时间格式
					  range: false,
				});
			});
			layui.use('table', function() {
				var table = layui.table;
				var $=layui.$;
				//展示已知数据
				table.render({
					elem: '#description_tabel',
					url:'${pageContext.request.contextPath}/danganmanage/queryAllManagerdetailsByHistoryData'+"?timestamp="+Math.random(),
					cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
					cols: [
						[ //标题栏
							{
								type: 'numbers',
								title: '序号',
								width: 100,
								unresize: 'false',
								templet: '#indexTpl',
							},
							{
								field: 'managerDetailsApplication',
								title: '申请项',
								unresize: 'false',
							}, {
								field: 'managerDetailsBeforeChange',
								title: '变更前',
								unresize: 'false',
							}, {
								field: 'managerDetailsAfterChange',
								title: '变更后',
								unresize: 'false',
							},
							{
								field: 'managerDetailsReason',
								title: '申请事由',
								unresize: 'false',
							},
							{
								field: 'managerDetailsPerson',
								title: '申请人',
								unresize: 'false',
							},
							{
								field: 'managerDetailsTime',
								title: '申请时间',
								unresize: 'false',
							},
							{
								field: 'managerDetailsReviewer',
								title: '审核人',
								unresize: 'false',
							},
							{
								field: 'managerDetailsAudittime',
								title: '审核时间',
								unresize: 'false',
							},
							{
								field: 'managerDetailsStatus',
								title: '状态',
								unresize: 'false',
								toolbar:'#boxStart',
							},
							{
								field: 'right',
								title: '操作',
								unresize: 'false',
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
				
				table.on('tool(description_tabel)', function(obj) {
					var data = obj.data;
					var tr = obj.tr;
					var historydataId=obj.data.id;
					var managerDetailsId=obj.data.managerDetailsId;
					if(obj.event === 'destruction') {
						 console.log(data)
						 layer.confirm('您确定要销毁该条记录吗？', function(index){
                          obj.del();
                          layer.close(index);
                          $.ajax({
                        	  url:"${pageContext.request.contextPath}/danganmanage/updateManagerdetailsByIsDelete"+"?timestamp="+Math.random(),
                        	  type:"post",
                        	  dataType:"json",
                        	  data:{"managerDetailsId":managerDetailsId},
                        	  success:function(result){
                        		  if(result==1){
                        			  layer.msg("该条记录已成功销毁",{offset:'auto',time:3000},function(){
 										 location.reload();
 									});
                        		  }else{
                        			  layer.msg("该条记录销毁失败");
                        		  }
                        	  },
                          });
						});
					}else if(obj.event==='download'){
						console.log(data)
						$.ajax({
							url:"${pageContext.request.contextPath}/danganmanage/uploadHistoryDataPdf"+"?timestamp="+Math.random(),
							type:"post",
							data:{"historydataId":historydataId},
							success:function(result){
								if(result==1){
									layer.msg("生成pdf文件成功");
								}else{
									layer.msg("生成pdf文件失败");
								}
							},
							error:function(){
								layer.msg("生成pdf失败,请检查接口");
							}
						});
					}
					
				});
			});
			
			
			//查询条件点击事件
			$().ready(function(){
				var table = layui.table;
				$("#historyConditionsBtn").click(function(){
					var managerDetailsApplication=$("#managerDetailsApplication").val();
					var managerDetailsPerson=$("#managerDetailsPerson").val();
					var startTime=$("#startTime").val();
					var endTime=$("#endTime").val();
					table.reload('description_tabel', {
						  url:'${pageContext.request.contextPath}/danganmanage/queryManagerdetailsByHistoryDataConditions'+"?timestamp="+Math.random(),
						  where: { //设定异步数据接口的额外参数，任意设
							  managerDetailsApplication: managerDetailsApplication,
							  managerDetailsPerson:managerDetailsPerson,
							  startTime:startTime,
							  endTime:endTime,
						  }
						  ,page: {
						    curr: 1 //重新从第 1 页开始
						  }
						});
				})
			})
			
		</script>
		
		<script type="text/html" id="boxStart">
				{{#  if(d.managerDetailsStatus == 1){  }}待审核
		 		{{#  } else if(d.managerDetailsStatus == 2){ }}已驳回
				{{#  } else if(d.managerDetailsStatus == 3){ }}已通过
				{{#  }  }}
		</script>
	</body>

</html>