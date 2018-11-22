<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>综合利用查询系统_交流中心</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css" />
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
	<style type="text/css">
			/*导航样式*/
			body .add_label_bg>.layui-layer-title,.btn_color{
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
			.exchange_nav ul li .a1{
				background: #f0f2f9;
				color: #009688;
				border: 1px solid #009688;
			}
			
			.exchange_nav ul {
				height: 40px;
			}
			/*主体样式*/
			
			.exchange_main {
				margin: 20px 50px;
				background: #FFFFFF;
				border: 1px solid #FFFFFF;
				border-radius: 8px;
			}
			
			table tr th div,
			table tr td {
				text-align: center;
			}
			
			.layui-table-page {
				text-align: right;
			}
			/*#exchange_tabel  .layui-table thead tr{
				 	background: #FFFFFF;
				 }*/
			/*咨询/建议*/
			#zhixun .layui-input-block,#reply  .layui-input-block{
				margin-right: 20px!important;
			}
			/*查看*/
			#look .layui-input-block{
				line-height: 36px;
				border-left: 1px dashed #ccc;
			}
			#look .layui-form-item {
				margin-bottom: 0px;
			    clear: both;
			    border-bottom: 1px dashed #ccc;
			}
		</style>
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

				<div class="logo_nav" style="border-bottom: 1px dashed #C2C2C2;">
					<!-- 头部区域 -->
					<div>
						<span class="logo_img"><img src="${pageContext.request.contextPath}/imgs/home.gif" width="110" height="50"/></span>
						<div class="logo">
						<c:if test="${zm:buttenPremission('la',sessionScope.user.role.authorities) }">
							<a href="${pageContext.request.contextPath}/information/godigitalarchives" style="color: #EA5519;">综合利用查询系统</a>
							</c:if>
							<a href="${pageContext.request.contextPath}/log/goHome" id="home">返回主页&gt;</a>
						</div>
					</div>

				</div>
				<!-- 主体内容 -->
				<div class="layui-body" id="index-bg" style="top:81px;left: 0;">
					<div class="layui-row">
						<div class="exchange_nav layui-col-sm12 layui-col-md12">
							<ul>
								<li>
									<a href="#">电子文件中心</a>
								</li>
								<li>
								<c:if test="${zm:buttenPremission('lc',sessionScope.user.role.authorities) }">
									<a href="${pageContext.request.contextPath}/AdviceMapperController/modelAndView"  class="a1">交流中心</a>
								</c:if>
								</li>
								<li>
								<c:if test="${zm:buttenPremission('ld',sessionScope.user.role.authorities) }">
									<a href="${pageContext.request.contextPath}/readingRoom/publicArchiveShow">电子阅览室</a>
								</c:if>
								</li>
								<li>
								<c:if test="${zm:buttenPremission('lh',sessionScope.user.role.authorities) }">
									<a href="${pageContext.request.contextPath}/information/goarchivalInformation">档案信息门户</a>
								</c:if>
								</li>
							</ul>
						</div>
						<div class="layui-row">
							<div class="layui-inline" style="padding-top: 10px;margin-left:15px;width: 98%;background: #FFFFFF;line-height: 80px;">
								<div id="for" style="float: left;padding-left: 20px;">
									<div class="layui-form inline">
										<div style="font-size: 16px;font-weight: bold;min-height: 70px;line-height: 70px;cursor: pointer;">
											<i class="fa fa-bars font_color" style="color: #EA5519;margin: 0 10px;"></i>交流列表
										</div>
									</div>
								</div>
								<div class="demoTable" style="float: right;margin-right: 20px;">
									<div class="layui-input-inline">
										<input type="hidden" id="UserId" value="${userId }" />
										<input type="tel" name="phone" id="keywords" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入关键字查询" />
									</div>
									<c:if test="${zm:buttenPremission('lca',sessionScope.user.role.authorities) }">
									<button class="layui-btn" data-type="reload">查询</button>
									</c:if>
								</div>
							</div>
							<div style="padding:0px 15px;">
								<table class="layui-table" id="exchange_tabel" lay-filter="exchange_tabel"></table>
							</div>
							<script type="text/html" id="barDemo">
								<!-- 这里同样支持 laytpl 语法，如： -->
								<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
							</script>
							<div class="layui-btn-group demoTable" style="margin: 18px 15px;">
							<!-- 1:管理员 -->
							<c:if test="${userType == 1}"><!-- reply -->
								<button data-type="getCheckData" class="layui-btn  layui-btn-danger layui-btn-sm reply" id="usertype" value="${userType }">回复</button>
							</c:if>
							<!-- 2:游客 -->
							<c:if test="${userType != 1 }">
								<button class="layui-btn  layui-btn-danger layui-btn-sm consult" id="usertype" value="${userType }">咨询/建议</button>
							</c:if>
							    <%-- <button data-type="getCheckData" class="layui-btn  layui-btn-danger layui-btn-sm reply" id="usertype" value="${userType }">回复</button>
								<button class="layui-btn  layui-btn-danger layui-btn-sm consult" id="usertype" value="${userType }">咨询/建议</button> --%>
							<c:if test="${zm:buttenPremission('lcc',sessionScope.user.role.authorities) }">
							    <button data-type="getCheckData" class="layui-btn  layui-btn-danger layui-btn-sm reply" id="usertype" value="${userType }">回复</button>
								</c:if>
								
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
		<!-- 图片预览插件 -->
		<script src="${pageContext.request.contextPath}/js/viewer.min.js"></script>
		<script type="text/javascript">
		var datas = null;
		var dataAll = function(){
			var dataList = null;
			$.ajax({
				url:"${pageContext.request.contextPath}/AdviceMapperController/adviceQuery",
				type:"POST",
				async:false,
				success:function(data){
					dataList=data;
					
				}
			});
			return dataList;
		};
		
		var tableRendering = function(){
			var data = dataAll();
			layui.use('table', function() {
				var table = layui.table;
				data = table.cache;
				//展示已知数据
				 table.render({
					/* url:'', */
					elem: '#exchange_tabel',
					cols: [
						[ //标题栏
							{
								type: 'checkbox',
								fixed: 'left'
							},
							{
								field: 'id',	
								type: 'numbers', 
								title: '序号' 
							}, {
								field: 'adviceType',
								title: '类型',
								width: 120,
								unresize: 'false',
							},
							{
								field: 'advicePublicinformation',
								title: ' 公开情况 ',
								minWidth: 150,
								unresize: 'false',
							}, {
								field: 'adviceTheme',
								title: '主题',
								minWidth: 150,
								unresize: 'false',
							}, {
								field: 'adviceTime',
								title: '提交时间',
								width: 150,
								unresize: 'false',
							},
							{
								field: 'adviceStatus',
								title: '回复状态',
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
					data:dataAll().data,
					id:'exchange_tabel',
					/* skin: 'line' //表格风格
						, */
					even: false,
					page: true //是否显示分页
						//,limits: [5, 7, 10]
						,
					limit: 10 //每页默认显示的数量
				});
				var $ = layui.$, active = {
						reload: function(){
					    var keywords = document.getElementById("keywords").value;
					      console.log(keywords);
					      //执行重载
					      table.reload('exchange_tabel', {
					    	url:'${pageContext.request.contextPath}/AdviceMapperController/adviceQuery',
					        page: {
					          curr: 1 //重新从第 1 页开始
					        }
					        ,where: {
					        	 keywords:keywords
					        }
					      });
					    }
					  };
				 $('.demoTable .layui-btn').on('click', function(){
					    var type = $(this).data('type');
					    active[type] ? active[type].call(this) : '';
					  });
				//监听工具条
				table.on('tool(exchange_tabel)', function(obj) {
					var data = obj.data;
					var tr = obj.tr;
					console.log(data);
					if(obj.event === 'detail') {
						if(data.advicePublicinformation == '公开'){
							layuiOpen(data);
						}else{
							//登陆用户ID
							var userid = document.getElementById("UserId").value;
							//登陆用户的类型
							var usertype = document.getElementById("usertype").value;
							console.log(usertype);
							if(data.userIds.userId == userid || usertype == 1){
								layuiOpen(data);
							}else{
								var msg = "此内容为‘非公开’,您没有该权限查看";
						    	  layer.msg(msg,{time:5000});
							}
						}
						
					}
					
				});
			});
		}
		tableRendering();
		
			$(function(){
				//重新渲染radio，此处为必要条件
				layui.use('form', function(){
				var form = layui.form;
				var myDate = new Date();
				var date = myDate.toLocaleString(); 
				$(".consult").click(function(){ //#btn为按钮id
					layer.open({
					type: 1,
					title:'<i class="fa fa-bars" style="padding:0 5px"></i>咨询/建议',
					area: ['800px', '450px'],
					skin: 'add_label_bg',
					offset: 'auto',
					shade: [0.8, '#393D49'],
					content: '<div class="layui-form" id="zhixun">'+
							 '<div class="layui-form-item" style="margin-top:15px;">'+
							 '<label class="layui-form-label">主题</label>'+
							 '<div class="layui-input-block">'+
							 '<input type="text" id="adviceTheme" name="title" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">'+
							 '</div></div>'+
							 '<div class="layui-form-item"><label class="layui-form-label">类型</label><div class="layui-input-block"><input class="adviceType" type="radio" name="consult" value="1" title="咨询"><input class="adviceType" type="radio" name="consult" value="2" title="建议"></div></div><div class="layui-form-item" pane>'+
							 '<label class="layui-form-label">公开情况</label>'+
							 '<div class="layui-input-block"><input type="radio" name="open" value="公开" title="公开"><input type="radio" name="open" value="不公开" title="不公开"></div></div>'+
							 '<div class="layui-form-item">'+
							 '<label class="layui-form-label">提交时间</label>'+
							 '<div class="layui-input-block">'+
							 '<input type="text" name="title" required lay-verify="required" id="adviceTime" placeholder="请输入标题" value="'+date+'" disabled="" autocomplete="off" class="layui-input">'+
							 '</div></div><div class="layui-form-item layui-form-text">'+
							 '<label class="layui-form-label" style="text-align: center;">咨询/建议<br>内容</label>'+
							 '<div class="layui-input-block">'+
							 '<textarea name="desc" placeholder="请输入内容" class="layui-textarea" id="adviceContent" required lay-verify="required"></textarea></div></div>'+
							 '<div style="text-align: center;">'+
							 '<button class="layui-btn" lay-submit onclick="advisoryReCommit()" lay-filter="formDemo">提交</button></div></div>',
						});
					
						form.render();
					});
				//点击回复代码初始位置			
				//点击回复
				/* replyClick(); */
			 })
				  //各种基于事件的操作，下面会有进一步介绍
				  
		});
			
			//弹出层数据渲染(查看功能)
			var layuiOpen = function(data){
				//layer.msg('ID：'+ data.id + ' 的查看操作');
				console.log();
				/* var adviceType = (data.adviceType==1)?data.adviceType='咨询':data.adviceType='建议'; */
				var replyTime = (data.replyTime==null)?data.replyTime='':data.replyTime=data.replyTime;
				var replyContent = (data.replyContent==null)?data.replyContent='< 请等待专业人员进行回复！>':data.replyContent=data.replyContent;
				/* console.log(adviceType); */
				layer.open({
					type: 1,
					title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
					area: ['800px', '500px'],
					skin: 'add_label_bg',
					offset: 'auto',
					shade: [0.8, '#393D49'],
					content: '<div class="layui-form" id="look">'+
							 '<div class="layui-form-item">'+
							 '<label class="layui-form-label">主题:</label>'+
							 '<div class="layui-input-block">'+data.adviceTheme+'</div></div>'+
							 '<div class="layui-form-item"><label class="layui-form-label">类型:</label><div class="layui-input-block">'+data.adviceType+'</div></div><div class="layui-form-item" pane>'+
							 '<label class="layui-form-label">公开情况:</label>'+
							 '<div class="layui-input-block">'+data.advicePublicinformation+'</div></div>'+
							 '<div class="layui-form-item">'+
							 '<label class="layui-form-label">提交时间:</label>'+
							 '<div class="layui-input-block">'+data.adviceTime+'</div></div><div class="layui-form-item layui-form-text">'+
							 '<label class="layui-form-label" style="text-align: center;">咨询/建议<br/>内容</label>'+
							 '<div class="layui-input-block">'+
							 '<textarea name="desc" class="layui-textarea" readonly="readonly">'+data.adviceContent+'</textarea></div></div>'+
							  '<div class="layui-form-item">'+
							 '<label class="layui-form-label">回复时间:</label>'+
							 '<div class="layui-input-block">'+replyTime+'</div></div><div class="layui-form-item layui-form-text">'+
							 '<label class="layui-form-label" style="text-align: center;">回复内容</label>'+
							 '<div class="layui-input-block">'+
							 '<textarea name="desc" class="layui-textarea" readonly="readonly">'+replyContent+'</textarea></div></div>'+
							 '<div style="text-align: center;">'+
							 '<button class="layui-btn"  onclick="btnCloss()">关闭</button></div></div>',
				});
			}
			//提交状态
			var commitType = null;
			//为对象进行封装
			var pseudoObject = function (commitType,adviceId){
				//建立伪对象
				var exchangeCenter;
				//获取主题
				var adviceTheme = $('#adviceTheme').val();
				//类型
				var adviceTypes = $(':radio[name="consult"]:checked').val()
				//公开情况
				var advicePublicinformations = $(':radio[name="open"]:checked').val()
				//提交时间
				var adviceTime = $('#adviceTime').val();
				//咨询建议内容
				var adviceContent = $('#adviceContent').val();
				//回复时间
				var replyTime = $('#replyTime').val();
				//回复内容
				var replyContent = $('#replyContent').val();
				//提交人回复人ID
				var userId = $('#UserId').val();
				//咨询人ID
				var adviceId = adviceId;
				exchangeCenter = {
					adviceTheme:adviceTheme,
					adviceType:adviceTypes,
					advicePublicinformation:advicePublicinformations,
					adviceTime:adviceTime,
					adviceContent:adviceContent,
					replyTime:replyTime,
					replyContent:replyContent,
					userId:userId,
					commitType:commitType,
					adviceId:adviceId
				}
				console.log(exchangeCenter);
				var isTrue=null;
				$.ajax({
					url:"${pageContext.request.contextPath}/AdviceMapperController/adviceReplyCommit",
					type:"POST",
					async:false,
					dataType:"JSON",
					data:JSON.stringify(exchangeCenter),
					contentType: 'application/json;charset=utf-8',
					success:function(data){
						dataAll();
						layer.closeAll();
						var msg = data.msg;
						layer.msg(msg,{time:5000});
					}
				});
			}
			
				//定义文件数组
				var adviceParameters = new Array();
				layui.use('table', function(){
					   var table = layui.table;
					   //监听表格复选框选择
					   table.on('checkbox(exchange_tabel)', function(obj){
						    console.log(obj)
					  });
					   
					   var $ = layui.$, active = {
							getCheckData: function(){ //获取选中数据
							  var checkStatus = table.checkStatus('exchange_tabel')
							  ,data = checkStatus.data;
							  var x = (JSON.stringify(data));
							  adviceParameters =  JSON.parse(x);
							  console.log(adviceParameters);
							  if(adviceParameters.length >1){
								  var msg = "抱歉！您只能一个一个进行回复！";
				    			  layer.msg(msg,{time:2000});
							  }else if(adviceParameters.length == 0){
								  var msg = "请选择您要回复的一条信息！";
				    			  layer.msg(msg,{time:2000});
							  }else{
								  var form = layui.form;
								  var myDate = new Date();
								  var date = myDate.toLocaleString();
								  var adviceId = adviceParameters[0].adviceId;
								  layer.open({
									type: 1,
									title:'<i class="fa fa-bars" style="padding:0 5px"></i>回复',
									area: ['800px', '280px'],
									skin: 'add_label_bg',
									offset: 'auto',
									shade: [0.8, '#393D49'],
									content: '<div class="layui-form" id="reply">'+
											 '<div class="layui-form-item" style="margin-top:15px;">'+
											 '<label class="layui-form-label">提交时间</label>'+
											 '<div class="layui-input-block">'+
											 '<input type="text" name="title" required lay-verify="required" id="replyTime" placeholder="请输入提交时间" value="'+date+'" disabled="" autocomplete="off" class="layui-input">'+
											 '</div></div><div class="layui-form-item layui-form-text">'+
											 '<label class="layui-form-label" style="text-align: center;">回复内容</label>'+
											 '<div class="layui-input-block">'+
											 '<textarea name="desc" placeholder="请输入内容" id="replyContent" class="layui-textarea" required lay-verify="required"></textarea></div></div>'+
											 '<div class="layui-form-item">'+
											 '<div style="text-align: center;">'+
											 "<button class='layui-btn'  onclick='ReplyCommit(\""+ adviceId + "\")' lay-submit lay-filter='formDemo'>提交</button></div></div></div>",
										});
							  }
							  
							}
					   }
					   $('.demoTable .layui-btn').on('click', function(){
						    var type = $(this).data('type');
						    active[type] ? active[type].call(this) : '';
						  });
					   
					});
			
			//点击建议进行提交
			var advisoryReCommit = function(){
				if ($('input:radio[name="consult"]:checked').length != 0){
			    	if($('input:radio[name="open"]:checked').length != 0){
			    		//咨询建议的提交状态为“1”；
			    		commitType = "1";
						pseudoObject(commitType);
						tableRendering();
			    	}else{
			    		var msg = "请选择公开情况！";
				    	layer.msg(msg,{time:2000});
			    	}
				}else{
					var msg = "请选择类型！";
			    	layer.msg(msg,{time:2000});
				}
			}
			//点击回复进行提交
			var ReplyCommit = function(adviceId){
				console.log($("#replyContent").val());
				if($("#replyContent").val() == ""){
					var msg = "请输入回复内容！";
			    	layer.msg(msg,{time:2000});
				}else{
					//回复的提交状态为“2”;
					commitType = "2";
					pseudoObject(commitType,adviceId);
					tableRendering();
				}
				
			}
			//关闭
			var btnCloss = function(){
				layer.closeAll();
			}
	
		</script>
	</body>

</html>