<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<html>

	<head>
		<meta charset="utf-8">
		<title>档案管理存储系统_角色管理</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
		<link href="${pageContext.request.contextPath}/css/skin_01.css" rel="stylesheet" type="text/css" id="skin">
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
    	<style type="text/css">
		/*.layui-body{overflow-y: scroll;} 滚动条问题*/
		table tr th div,table tr td{
			text-align: center;
		}
		/*添加全宗弹出层样式*/
		.add_lb1{
			margin:20px 85px;
		}
		.add_lb2{
			margin:20px 70px;
		}
		.gong_color{
			color: red;
			font-weight: bold;
		}
		body .add_label_bg>.layui-layer-title,.btn_color{
			background: #EA5519;
			color: #FFFFFF;
		}
		/*所属全宗样式*/
		.cv_fcv{
			padding: 1% 20%;
			font-size: 16px;
		}
		#help_list,#help_list2{
			float: left;
			margin:15px;
			width: 30%;
		}
		#help_list,#help_list2,.two_list{
			background: #FFFFFF;
			min-heiht:700px;
		}
		.list2>li{
			list-style-type: none;
			height:auto;
			}
		.node .node {
			display: none;
		} 
		.node{
			line-height: 24px;
		}
		.list2{
			padding-left: 20px;
		}
		.two_list li{
			margin: 5px 0px;
			cursor: pointer;
		}
		.two_list li div:hover{
			background: #000000;
			color: #FFFFFF;
			text-align: center;
		}
		.two_list li div{
			width: 100px;
			text-align:right;
			cursor: pointer;
		}
		.two_list,.list2{
			margin-top: 8px;
		}
		.ce_ceng_close {
			background: url(${pageContext.request.contextPath}/imgs/jiantouupo.jpg) left center no-repeat;
			padding:0 25px;
			height: 20px;
		}
		
		.ce_ceng_open {
			background: url(${pageContext.request.contextPath}/imgs/zhankai.gif) left center no-repeat;
		}
		/*所属全宗结束*/
		/*角色管理*/
		#role{
			font-size: 16px;
			text-align: center;
		}
		#role ul li{
			margin: 20px 0;
		}
		#role ul li a{
			display: inline-block;
			min-width: 150px;
		}
		#role ul li button{
			background: #FFFFFF;
			border: none;
			outline: none;
			color: red;
			margin-left: 30px;
			cursor: pointer;
		}
		/*角色管理*/
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
					<c:if test="${zm:buttenPremission('bc',sessionScope.user.role.authorities) }">
				<p style="line-height: 38px;">
					<i class="fa fa-volume-up gong_color" style="padding: 0 20px;"></i><span>
						<span class="gong_color">消息提示：</span> 您有<span>${messageNum}</span>条<a
						href="${pageContext.request.contextPath}/messageNotification/goNotification"
						class="gong_color">未读</a>消息，请及时处理！
						
					</span>
					
				</p>	
			</c:if></div>
				<div class="top_bar">
					<!-- 头部区域 -->
			<ul class="layui-nav" id="top_nav">
					<c:if test="${zm:buttenPremission('ba',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-this">
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
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/roleManagement/getRoleList">角色管理</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bh',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/user/getUserList">用户管理</a>
						</li>
						<span class="layui-hide-xs span_color">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bi',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
					 		<a href="${pageContext.request.contextPath}/loggingProduce/goSafetyManagement">安全管理</a>
						</li>
							<span class="layui-hide-xs span_color ">|</span>
					</c:if>
					<c:if test="${zm:buttenPremission('bj',sessionScope.user.role.authorities) }">
						<li class="layui-nav-item layui-hide-xs">
							<a href="${pageContext.request.contextPath}/systemSetup/goToSystemSetup">系统设置</a>
						</li>
					</c:if>
				</ul>
				</div>

				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body" style="top:180px;background: #f0f2f9;">
					
					 	<div id="help_list" style="margin-top: 15px; margin-bottom: 10px;">
					 		<span>
					 			<img src="${pageContext.request.contextPath}/imgs/jianto.gif" height="30px" style="float: left;"/>
					 			<p style="font-size: 16px;line-height: 35px;float: left;">用户</p>
					 		</span>
					 		<hr class="layui-bg-blue" style="margin-top:0px;" />
					 		<div class="layui-input-inline" style="padding-left: 20%;margin: 3% 0;">
					 		<c:if test="${zm:buttenPremission('bga',sessionScope.user.role.authorities) }">
					        	<input type="text" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="查找用户" style="float: left;width: 70%;"/>
					        		<button class="layui-btn" id="searchUser" style="float: left;" ><i class="fa fa-search"></i></button>
					     	</c:if>
					     	</div>
					     <!--所属-->
					     <c:forEach items="${listArchive}" var="archive">
					     	<div class="cv_fcv node">
								<div class="tree" id="showOrg${archive.quanzongId}" onclick="showOrganization('${archive.quanzongId}')">${archive.quanzongName}</div>
								<ul class="node list2" id="allcase${archive.quanzongId}">
								<!-- <li>
										<div class="tree">所属部门</div>
										<ul class="node two_list">
											<li>
												<div class="tree">马克思</div>
											</li>
											<div></div>
										</ul>
									  </li> -->
								</ul>
							</div>
						</c:forEach>
							 <!--所属 onclick="deleteRole('${role.roleId}')"-->
						</div> 
							<div id="help_list2">
					 		<span>
					 			<img src="${pageContext.request.contextPath}/imgs/jianto.gif" height="30px" style="float: left;"/>
					 			<p style="font-size: 16px;line-height: 35px;float: left;">角色</p>
					 		</span>
					 		<hr class="layui-bg-blue" style="margin-top:0px;" />
					 		<c:if test="${zm:buttenPremission('bgb',sessionScope.user.role.authorities) }">
					    	 <button class="layui-btn layui-btn-fluid add_role" style="margin: 3% 0;">+添加角色</button>
							</c:if>
					  			<div id="role">
					  				<ul>
					  					<c:forEach items="${listRole}" var="role">
						  					<li class='role'>
						  						<a href="${pageContext.request.contextPath}/roleManagement/goPrivilegeJsp?roleId=${role.roleId}">${role.roleName}</a>
						  						<input type="radio" name="role" id="roleProperty${role.roleId}" value="${role.roleId}" />
						  						<c:if test="${zm:buttenPremission('bgc',sessionScope.user.role.authorities) }">
						  						<button class="fa fa-trash-o delet" value="${role.roleId}"></button>
												</c:if>
						  					</li>
					  					</c:forEach>
					  				</ul>
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
		<!--[if IE 6]>
		<script type="text/javascript" src="../js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->

		<script type="text/javascript">
			//查询用户
			$("#searchUser").click(function(){
				var userName =$("input[name='phone']").val();
				if(userName==''||userName==null){
					layer.msg("请填写用户名!");
				}else{
					$.ajax({
						url:"${pageContext.request.contextPath}/roleManagement/getUserInfo",
						type:"POST",
						data:"userName="+userName,
						dataType:"JSON",
						success:function(data){
							console.log(data.length);
							var organizationId=null;
							for (var i = 0; i < data.length; i++) {
								var showOrg = $("#showOrg"+data[i].quanzongId);
								showOrg.click();
								organizationId=data[i].organizationId;
								if(data[i].roleId==$(".delet").val()){
									$("#roleProperty"+data[i].roleId).attr('checked','checked');
								}
							}  
							setTimeout(function(){
								 $("#showUser"+organizationId).click();
							}, 300)
							
						},
					    error : function(e) {
					    	layer.msg("用户不存在!");
   					   	}
					});
				}
			});
			
			
			//用户所属树形菜单
			$(".tree").each(function(index, element) {
				if($(this).next(".node").length > 0) {
					$(this).addClass("ce_ceng_close");
				}
			});
			$(".tree").click(function(e) {
				var ul = $(this).next(".node");
				if(ul.css("display") == "none") {
					ul.slideDown();
					$(this).addClass("ce_ceng_open");
					ul.find(".ce_ceng_close").removeClass("ce_ceng_open");
				} else {
					ul.slideUp();
					$(this).removeClass("ce_ceng_open");
					ul.find(".node").slideUp();
					ul.find(".ce_ceng_close").removeClass("ce_ceng_open");
				}
			});
			//添加角色弹出层
			$(function(){
				$(".add_role").click(function(){ 
				layer.open({
				type: 1,
				title:'<i class="fa fa-bars" style="padding:0 5px"></i>添加角色',
				area: ['600px', '280px'],
				skin: 'add_label_bg',
				offset: 'auto',
				shade: [0.8, '#393D49'],
				content: '<div style="margin:70px 0;"><label class="layui-form-label" style="width:120px;">请输入自定义角色</label><div class="layui-input-block"><input type="text" name="roleName" required="required"  placeholder="请输入角色名" autocomplete="off" class="layui-input" style="width:90%;" /></div></div><div style="text-align: center;"><button class="layui-btn btn_color" id="btn_submit">确定</button></div>'
				});
				$("#btn_submit").click(function() {
					var roleName = $("input[name='roleName']").val();
					if (roleName == "") {
						layer.msg("角色名称不能为空!");
					} else {
	   					$.ajax({
	   						url : "${pageContext.request.contextPath}/roleManagement/addRole",
	   						data :"roleName="+roleName,
	   						type : "post",
	   						async : true,
	   						dataType : "text",
	   						success : function(data) {
	   							if (data == 1) {
	   								layer.msg("角色名称已存在!");
	   							} else if (data == 2) {
	   								layer.msg("角色添加成功!");
	   								location.reload();
	   								//layer.closeAll();
	   							  	//$(".layui-body").load(location.href+".layui-body");
	   							}else{
	   								layer.msg("角色添加异常!");
	   							}
	   						},
	   						error : function(e) {
	   							console.log("请与管理员联系,检查接口服务!");
	   					   	}

	   					});
					}
	   			});
			  })
			})
   			//删除事件
   			$(function(){
   				$(".delet").on('click', function(){
				    var othis = $(this);
				    var roleId=$(this).val()
				    var roleProperty= $("#roleProperty"+roleId).val();
				    if(roleProperty =='0'){
				    	layer.msg("该角色为系统内置角色,不能被删除!");
				    }else {
					    layer.open({
					        content: '您确认删除此角色吗？',
					        btn: ['确认', '取消'],
					        shadeClose: false,
					        yes: function(){
					            layer.open({content: '确认取消', time: 1});
			        			$.ajax({
			        				url:"${pageContext.request.contextPath}/roleManagement/deleteRole",
			        				type:"post",
			        				dataType:"text",
			        				async:true,
			        				data:"roleId="+roleId,
			        				success:function(data){
			        					if(data=="true"){
			        						othis.parent('li').remove();
			        						layer.msg("删除成功!");
			        					}else{
			        						layer.msg("删除失败!");
			        					}
			        				},
			        				error : function(e) {
			   							console.log("请与管理员联系,检查接口服务!");
			   					   	}
			        			});
					            
					        }, no: function(){
					            layer.open({content: '您选择了取消', time: 1});
					        }
					    });
				    }
				})
   			})
			
   			//查询全宗下的科室信息
   			function showOrganization(quanzongId){
   				$.ajax({
   					url:"${pageContext.request.contextPath}/roleManagement/showOrganization",
   					data:"quanzongId="+quanzongId,
   					type:"get",
   					dataType:"json",
   					success:function(data){
   						$("#allcase"+quanzongId).empty();
   						console.log(data);
   						var list=data;
   						for(var i=0;i<list.length;i++){
   							$("#allcase"+quanzongId).append(
   								"<li>"+
   								"<div class='tree2' id='showUser"+list[i].organizationId+"' onclick=\"queryUser('"+list[i].organizationId+"')\">"+list[i].organizationName+"</div>"+
   									/* "<div class='tree2' id='showUser"+list[i].organizationId+"' onclick=\"queryUser('"+list[i].organizationId+"')\">"+list[i].organizationName+"</div>"+ */
   									"<ul class='node two_list' id='organization"+list[i].organizationId+"'></ul>"+
   								"</li>"
   							   )	
   						}
   						//用户所属树形菜单
   						$(".tree2").each(function(index, element) {
   							if($(this).next(".node").length > 0) {
   								$(this).addClass("ce_ceng_close");
   							}
   						});
   						$(".tree2").click(function(e) {
   							var ul = $(this).next(".node");
   							if(ul.css("display") == "none") {
   								ul.slideDown();
   								$(this).addClass("ce_ceng_open");
   								ul.find(".ce_ceng_close").removeClass("ce_ceng_open");
   							} else {
   								ul.slideUp();
   								$(this).removeClass("ce_ceng_open");
   								ul.find(".node").slideUp();
   								ul.find(".ce_ceng_close").removeClass("ce_ceng_open");
   							}
   						});
   					}
   				})
   			}
			
   			//查询科室的人员信息
   			function queryUser(organizationId){
   				$.ajax({
   					url:"${pageContext.request.contextPath}/roleManagement/showUserInfo",
   					data:"organizationId="+organizationId,
   					type:"get",
   					dataType:"json",
   					success:function(data){
   						$("#organization"+organizationId).empty();
   						for(var i=0;i<data.length;i++){
   							$("#organization"+organizationId).append(
   									"<li>"+
   										"<div class='tree user' onclick='checkRole("+data[i].roleId+")'>"+
   											data[i].userName+
   										"</div>"+
   									"</li>"
   								)
   						}
   					}
   				})
   			};
   			//用户角色
   			function checkRole(roleId){
   				var list=$(".role").find("input[type='radio']");//获取角色集合；
   				for(var i=0;i<list.length;i++){
   					var id=list[i].value;
   					list[i].checked=false;
   					if(id==roleId){
   						list[i].checked=true;
   					}
   				}
   			}
   		    //退出登录
			function loginOut(){
				layer.confirm('您确定要退出系统吗?', {
		            btn : [ '确定', '取消' ]//按钮
		        }, function(index) {
		            layer.close(index);
		            //此处请求后台程序，下方是成功后的前台处理……
		            var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
		            window.location.href="${pageContext.request.contextPath}/log/logout";
		        }); 
			}
   			
		</script>
	</body>

</html>