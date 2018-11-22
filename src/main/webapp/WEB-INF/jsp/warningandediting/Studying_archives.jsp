<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>档案编研_编研成果</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">
		<link href="${pageContext.request.contextPath}/css/skin_01.css" rel="stylesheet" type="text/css" id="skin">
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
			/*检索*/
			
			.jiansuo,
			.jiansuo_tabel {
				background: #FFFFFF;
				padding-right: 15px;
				border: 1px solid #FFFFFF;
				border-radius: 8px;
				margin-top: 0px;
				box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .1);
			}
			
			.viewer-container,
			.viewer-fixed,
			.viewer-fade,
			.viewer-transition,
			.viewer-in {
				z-index: 99999999999!important;
				/*弹出层查看图片优先级提升*/
			}
			
			.font-i {
				color: #EA5519;
				font-weight: bold;
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
							<div class="layui-card">
								<div class="layui-card-header">
									<div class="layui-form">
										<div class="layui-form-item">
											<div class="layui-inline">
											<form class="layui-form" action="">
													<select id="editingTypeName" name="editingTypeName"  lay-filter="editingTypeName">
														<option value="">编研类型</option>
														<c:forEach items="${editingTypeNameList}" var="editing">
														<option value="${editing.editingTypeName}">${editing.editingTypeName}</option>
														</c:forEach>
												</select>
													</form>
											</div>
											<div class="layui-inline">
													<select id="editingDate" name="editingDate"  lay-filter="editingDate">
															<option value="">编研日期</option>
															<c:forEach items="${editingDateList}" var="editing">
																<option><fmt:formatDate value="${editing.editingDate}" pattern="yyyy-MM-dd"/></option>
															</c:forEach>
													</select>
											</div>
											<div id="" style="float: right;">
												<div class="layui-inline">
													<input type="text" id="searchBody" name="searchBody" placeholder="请输入关键词" autocomplete="off" class="layui-input">
												</div>
												<div class="layui-inline">
												<c:if test="${zm:buttenPremission('kaa',sessionScope.user.role.authorities) }">
										            <button class="layui-btn layui-btn-normal" style="padding: 0 28px;" id="fileConditionsBtn"> 查询</button>
								          		</c:if>
								          		</div>
								          	</div>
										</div>
									</div>
								</div>
								<div class="layui-card-body">
									<table class="layui-hide" id="studying" lay-filter="studying">
									</table>
								</div>
								<div class="layui-card-header demoTable" >
									<button class="layui-btn layui-btn-sm layui-btn-normal" id="download"   data-type="download">下载</button>
									<input type="hidden" id="borrowDatas"/>
									<button class="layui-btn layui-btn-sm" id="print"  data-type="print">打印</button>
								</div>
							</div>
							<script type="text/html" id="barDemo">
								<!-- 这里同样支持 laytpl 语法，如： -->
								<a href="#" class="layui-btn layui-btn-xs" lay-event="look" id = "look">查看</a>
								<a href="#" class="layui-btn layui-btn-xs" lay-event="editing" id="editing">编辑</button>
								<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" id = "delete">删除</a>
							</script>
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
		<script src="${pageContext.request.contextPath}/layui/lay/date-format.js" type="text/javascript" charset="utf-8"></script>
		 <script src="${pageContext.request.contextPath}/js/loginout.js" type="text/javascript" charset="utf-8"></script>
		 <!-- <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script> -->
		 <!--  word文档下载 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/FileSaver.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.wordexport.js"></script>
		<!--[if IE 6]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script type="text/html" id="barDemo2">
							<input type="radio" name="radio" lay-event="radio" lay-ignore/>
						</script>
		<script type="text/html" id="indexTpl">
          {{d.LAY_TABLE_INDEX+1}}
         </script>
         <script id="createTime" type="text/html">
    {{#   
    var date = new Date();
    date.setTime(d.editingDate);
    return date.Format("yyyy-MM-dd"); 
    }} 
    </script>
		<script>
		
		//下拉查看文件
		 layui.use('form',function(){
			   var form=layui.form; 
			   var table = layui.table;
			   form.on('select(editingTypeName)', function(data){
					  console.log(data.value); //得到被选中的值
						  var editingTypeName = data.value;
						table.reload('studying', {
							  url:'${pageContext.request.contextPath}/editingFile/selectEditingFileByType',
							  where: { //设定异步数据接口的额外参数，任意设
								  editingTypeName: editingTypeName,
							  },page: {
							    curr: 1 //重新从第 1 页开始
							  }  
							}); 
			       }); 
			  form.on('select(editingDate)', function(data){
					  console.log(data.value); //得到被选中的值
						  var editingDate = data.value;
						table.reload('studying', {
							  url:'${pageContext.request.contextPath}/editingFile/selectEditingFileByDate',
							  where: { //设定异步数据接口的额外参数，任意设
								  editingDate: editingDate,
							  },page: {
							    curr: 1 //重新从第 1 页开始
							  }  
							}); 
			       });
		  });
		 
		//关键词查询件信息
		$().ready(function(){
			var table = layui.table;
			$("#fileConditionsBtn").click(function(){
				var searchBody=$("#searchBody").val();
				table.reload('studying', {
					  url:'${pageContext.request.contextPath}/editingFile/selectFuzzyEditingFile',
					  where: { //设定异步数据接口的额外参数，任意设
						  searchBody: searchBody,
					  },page: {
					    curr: 1 //重新从第 1 页开始
					  }  
					});
		});
	});
		
			//页面渲染信息
			layui.use('table', function() {
				var table = layui.table;
				var $ = layui.jquery;
				var data = layui.data;
				//展示已知数据
				table.render({
					elem: '#studying',
					url:'${pageContext.request.contextPath}/editingFile/selectAllEditingFile',
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
								field: 'editingTypeName',
								title: '编研类型',
								minWidth: 200,
								unresize: 'false',
							}, {
								field: 'editingTitle',
								title: '主题',
								minWidth: 300,
								unresize: 'false',
							}, {
								field: 'editingDate',
								title: '编研日期',
								minWidth: 120,
								unresize: 'false',
								templet: '#createTime',
							},
							{
								field: 'editingAuthor',
								title: '作者',
								minWidth: 120,
								unresize: 'false',
							},
							{
								field: 'right',
								title: '操作',
								width: 300,
								unresize: 'false',
								toolbar: '#barDemo'
							}]],
					even: false,
					page: true, //是否显示分页
					limits: [10, 20, 30],
					limit: 10 //每页默认显示的数量
				});
				 //监听表格复选框选择
				  table.on('checkbox(studying)', function(obj){
				    console.log(obj)
				  });
				  //监听工具条
				  table.on('tool(studying)', function(obj){
				    var data = obj.data;
				    var editingId=obj.data.editingId;
				    if(obj.event === 'del'){
				      layer.confirm('您确定要删除该条记录吗?', function(index){
				        obj.del();
				        layer.close(index);
				        $.ajax({
							  url:"${pageContext.request.contextPath}/editingFile/removeEditingFile"+"?timestamp="+Math.random(),
							  type:"post",
								 beforeSend :function(xmlHttp){ 
								        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
								        xmlHttp.setRequestHeader("Cache-Control","no-cache");
								     },
								 data:{"editingId":editingId},
								 dataType:"json",
								 cache:false,
								 success:function(result){
									 if(result==1){
										 layer.msg("删除成功",{offset:'auto',time:3000},function(){
											 location.reload();
										});
									 }else if(result==2){
										 layer.msg("删除失败");
									 }
								 }
						  });
				      });
				    }else if(obj.event === 'look'){
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
				    	 			window.location.href='${pageContext.request.contextPath}/editingFile/goChaKan?editingId='+editingId;
								 },
								 error:function(data){
									 console.log(data);
				    	 			//window.location.href='${pageContext.request.contextPath}/editingFile/goChaKan?editingId='+editingId;
								 },
						  }); 
				    }else if(obj.event === 'editing'){
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
									 console.log(editingId);
									  window.location.href='${pageContext.request.contextPath}/editingFile/goBianJi?editingId='+editingId; 
								 },
								 error:function(data){
									 console.log(data);
									 window.location.href='${pageContext.request.contextPath}/editingFile/goBianJi?editingId='+editingId;
								 },
						  }); 
				    	
				    }
				    radioData(data);
				  });
			});
			
			//下载
			var radioData = function(data){
				var $ = layui.$, active = {
						download: function(){//下载
							layer.closeAll();
							var datass = data.editingController; 
							$("#borrowDatas").data("result",datass);    //用data属性进行存储（result:存储数据的名字 data:为存储的值）
							var datas = $("#borrowDatas").data("result");   		
							if(datas != null || datas != ""){
								datas = "";
								$("#borrowDatas").data("result",datass);    //用data属性进行存储（result:存储数据的名字 data:为存储的值）
								datas = $("#borrowDatas").data("result");   		
							}
							layer.open({
								type: 1,
								title: '<i class="fa fa-bars" style="padding:0 5px"></i>下载',
								area: ['800px', '500px'],
								skin: 'add_label_bg',
								offset: 'auto',
								shade: [0.8, '#393D49'],
								content: "<div id='pagecontent2' style='min-height:400px;'>"+datas+"</div><div  style='width:100%;clear:both;text-align: center;'><button class='layui-btn layui-btn-sm layui-btn-normal' id='download2' >下载</button></div>",
							});
							$("#pagecontent2").empty();
							$("#pagecontent2").append(datas); 
								//$("#pagecontent2").append(datas);
								//$("#pagecontent2").wordExport();
							$("#download2").click(function(){
								$("#pagecontent2").wordExport();
								}); 
					    } ,
					    print:function(){//打印
					    	layer.closeAll();
							var datass = data.editingController; 
							$("#borrowDatas").data("result",datass);    //用data属性进行存储（result:存储数据的名字 data:为存储的值）
							var datas = $("#borrowDatas").data("result");   		
							if(datas != null || datas != ""){
								datas = "";
								$("#borrowDatas").data("result",datass);    //用data属性进行存储（result:存储数据的名字 data:为存储的值）
								datas = $("#borrowDatas").data("result");   		
							}
							layer.open({
								type: 1,
								title: '<i class="fa fa-bars" style="padding:0 5px"></i>打印',
								area: ['800px', '500px'],
								skin: 'add_label_bg',
								offset: 'auto',
								shade: [0.8, '#393D49'],
								content: "<div id='pagecontent2' style='min-height:400px;'>"+datas+"</div><div style='width:100%;clear:both;text-align: center;'><button class='layui-btn layui-btn-sm' id='print2' >打印</button></div>",
							});
							console.log(datas);
							$("#pagecontent2").empty();
							$("#pagecontent2").append(datas); 
								//$("#pagecontent2").append(datas);
								//$("#pagecontent2").wordExport();
							//调用打印机
							$("#print2").click(function(){
							document.body.innerHTML=document.getElementById('pagecontent2').innerHTML;
							window.print();
							}); 
					    }   
				}
			    $('.demoTable .layui-btn').on('click', function(){
			        var type = $(this).data('type');
			        active[type] ? active[type].call(this) : '';
			      });
			}
			
		    
		</script>
	</body>

</html>