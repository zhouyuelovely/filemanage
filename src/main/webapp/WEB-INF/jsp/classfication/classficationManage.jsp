<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>系统管理_档案自定义</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/skin_01.css" id="skin"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/classficationManage.css" />
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
    	<style type="text/css">
    	  .delet{
    	    background: #FFFFFF;
			border: none;
			outline: none;
			color: red;
			margin-left: 30px;
			cursor: pointer;
			text-align:right;
    	}
    	</style>
	</head>
	
	<body class="layui-layout-body" >
		<div >
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
							<li class="layui-nav-item ">
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
						<li class="layui-nav-item layui-hide-xs layui-this">
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
					<!--切换导航-->
				
					<div class="tabboxs">
						<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
						  <ul class="layui-tab-title">
						    <li class="layui-this">档案分类</li>
						    <li>档案盒</li>
						    <li>保管期限</li>
						  </ul>
						 <div class="layui-tab-content" style="padding:30px 50px 50px;">
						  <div class="layui-tab-item layui-show"  id="app">
						  	 <!-- 全宗名 -->
	
							<div class="layui-col-lg2">
								<label class="layui-form-label">全宗名称：</label>
									<select name="quanzongName" id="quanzongName" style="margin-top:10px;">
									<option value="" >请选择</option>	
										<c:forEach var="archiveList" items="${archiveList}">
											<option value="${archiveList.quanzongId }" >${archiveList.quanzongName }</option>
										</c:forEach>	 
									 </select>
								</div>
		
							
						  		<div class="taba">
						  			<table class="layui-table">
									  <colgroup>
									    <col width="200">
									    <col width="200">
									    <col>
									  </colgroup>
									  <thead>
									    <tr>
									      <th colspan=2>
									      	  <i class="fa fa-signal" aria-hidden="true"></i>
										      <select name="city" lay-verify="required" class="onetype" v-model="selected" @change="selectVal">
										         <option v-for="(item,index) in onetype" :key="index">{{item.pcName}}</option>
										      </select>
									      </th>
									      <th>
										      <table border="" cellspacing="0" cellpadding="0" class="layui-table tableinit" >
									      		<tr>
									      			<th colspan=1>
									      			<i class="fa fa-signal" aria-hidden="true"></i>
											      	<select name="city" lay-verify="required" class="onetype" id="onetype" onchange="queryScByPcIdAndStatus()">
												        <option value="1" selected>问题分类</option>
												        <option value="2">机构分类</option>
												      </select>
									      		</th>
									      		  <th colspan=1><i class="fa fa-signal" aria-hidden="true"></i>操作</th>
									      		</tr>
									      	</table>
									      </th>
									    </tr> 
									  </thead>
									  <tbody id="delbox">
									    <tr v-for="(item,indexd) in onetype" :key="indexd">
									      <td>{{item.pcCode}}</td>
									    <!--   <td>{{item.pcName}} <a href="#" @click="delsd2(item.pcId,indexd,index)" class="fa fa-trash-o delet"></a></td> -->
									     <td>{{item.pcName}}<button class="fa fa-trash-o delet" @click="delsd2(item.pcId,indexd)"></button></td>
									      <td>
									      	<table border="" cellspacing="0" cellpadding="0" class="layui-table tableinit" id="aa" v-if="item.pcName==selected">
									      		<tr class="editOrgtr" v-for="(items,index) in item.twos" :key="index">
									      			<td width="30%">{{items.scCode}}</td>
									      			<td width="25%">{{items.scName}}</td>
									      			<td width="33%" v-if="items.scProperty=='0' && items.scStatus=='1'" class="editOrg2" >默认分类，不可删除</td>
									      			<td width="33%" v-if="items.scProperty=='1' && items.scStatus=='1'"><a href="#" @click="delsd(items.scId,indexd,index)" style="color:#FF5722">删除</a></td>
									      			<td width="33%" v-if="items.scStatus=='0'" class="editOrg3" >编辑机构请在全宗管理下进行操作</td>
									      		</tr>
									      	</table>
									      </td>
									    </tr>
									    
									  </tbody>
									</table>
						  		</div>
						  		<div class="addbut">
						  		<c:if test="${zm:buttenPremission('bda',sessionScope.user.role.authorities) }">
						  			<button class="layui-btn layui-btn-danger add_label addType">添加分类</button>
						  			 <!-- <div id="demo7" style="display: inline-block;float: right;"></div> -->
						  			 </c:if>
									
						  		</div>
						  	</div>
						    <!-- 档案自定义		>>		档案盒 	（陈一达注）-->
						    <div class="layui-tab-item">
						    	<table class="layui-hide yabhe" id="demo" lay-filter="demo"></table>
								<script type="text/html" id="barDemo">
									<button class="layui-btn layui-btn-normal layui-btn-xs" id="edit" lay-event="edit">编辑</button>
									<button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>
								</script>
								<div class="addbut">
								<c:if test="${zm:buttenPremission('bec',sessionScope.user.role.authorities) }">
						  			<button class="layui-btn layui-btn-danger add_label addhe">添加盒属性</button>
						  			</c:if>
						  			<div id="demo7" style="display: inline-block;float: right;"></div>
						  		</div>
						    </div>
						    	<!-- 档案自定义		>>		保管期限 	demo	333（陈一达注）<button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="dels">不可删除</button>-->
							    <div class="layui-tab-item">
							    	<table class="layui-hide yabhe" id="demo2" lay-filter="demo"></table>
									<script type="text/html" id="barDemo2">
										{{#  if(d.retentionperiodstatus < 1){ }}
                                   			<a href="#" class="layui-table-link">不可删除</a>
                                		{{#  } else { }}
                                   			<button id="btn" class="layui-btn layui-btn-danger layui-btn-xs" lay-event="dels">删除</button>
                                  		{{#  } }}
									</script>
									<div class="addbut">
									<c:if test="${zm:buttenPremission('bfb',sessionScope.user.role.authorities) }">
							  			<button class="layui-btn layui-btn-danger add_label addtime">添加保管期限</button>
							  			</c:if>
							  			<div id="demo7" style="display: inline-block;float: right;"></div>
							  		</div>
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/classficationManage.js" ></script>
		 <script src="${pageContext.request.contextPath}/js/loginout.js" type="text/javascript" charset="utf-8"></script>
		<!--[if IE 6]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/DDPngMin.js"></script>
		<script>
		DD_belatedPNG.fix('.main_t,.main_m,.main_b,.run a');
		</script>
		<![endif]-->
		<script>
		
		function page(currentPage){
			console.log(currentPage)
		}
		
		var curr=1;
		var limit=10;
		
		 function queryStr(){
			$.ajax({
				url:"${pageContext.request.contextPath}/classfication/queryStr",
				type:"post",
				dataType:"json",
				contentType:"application/json",
				success:function(result){
					app.selected=result.selected;
					app.onetype=result.onetype;	
					
				},
			});
		 } 
		
		var app = new Vue({
			el:'#app',
			 data:{
				selected:'',
				onetype:[
					{pcName:'',pcCode:'',pcId:'',
						twos:[
						 {scName:'',scCode:'',scId:'',del:true}
						 
					]},
				] 
			 },
			
			methods:{
				selectVal:function(){
					var con=this.selected;
					var sel=$("#onetype").val();
					if(con!="文书档案"&&sel==1){
						console.log(con+":"+sel);
						$("#onetype").html("");
						$("#onetype").html("<option value='1'>问题分类</option>");
					}else if(con!="文书档案"&&sel==2){
						console.log(con+":"+sel);
						$("#onetype").html("");
						$("#onetype").html("<option value='1'>问题分类</option>");
					}else if(con=="文书档案"){
						$("#onetype").html("");
						$("#onetype").html("<option value='1'>问题分类</option><option value='2'>机构分类</option>");
					}
				},
				delsd:function(id,indexd,index){
					var ones=this.onetype
					console.log(ones);
					var ids=id
					console.log(ids);
					var indexf=index
					console.log(indexf);
					layer.confirm('您确定要删除该二级分类吗?',{
						 btn : [ '确定', '取消' ]//按钮 
					},function(index){
						 layer.close(index);
						 $.ajax({
							  url:"${pageContext.request.contextPath}/classfication/deleteScById",
							  type:"post",
							  dataType:"text",
							  data:{"scId":ids},
							  success:function(result){
								  if(result=="true"){
									  layer.msg("删除成功!",{offset:'auto',time:1500},function(){
			        						 location.reload();
										});
									  ones[indexd].twos.splice(indexf, 1)  
								  }else{
									  layer.msg("该二级分类下存在数据,无法删除!");
								  }
							  },
						  });
					});
				},
				delsd2:function(id,indexd){
					var ones=this.onetype
					console.log(ones);
					var ids=id
					console.log(ids);
					var indexf=indexd
					console.log(indexf);
					layer.confirm('您确定要删除该一级分类吗?',{
						 btn : [ '确定', '取消' ]//按钮 
					},function(index){
						 layer.close(index);
						  $.ajax({
							  url:"${pageContext.request.contextPath}/classfication/deletePcByPcId",
							  type:"post",
							  dataType:"text",
							  data:{"pcId":ids},
							  success:function(result){
								  if(result=="true"){
									  layer.msg("删除成功!",{offset:'auto',time:1500},function(){
			        						 location.reload();
										});
									  ones[indexd].twos.splice(indexf, 1)  
								  }else{
									  layer.msg("该一级分类下有二级分类,无法删除!");
								  }
							  },
						  }); 
					});
					
				},
			},
			created:function(){
				queryStr();
			}
			
			
		})
		
		
		layui.use(['table','laypage', 'layer'], function() {
			var table = layui.table;
			var $=layui.$;
			var laypage = layui.laypage,
			    layer = layui.layer;
			//展示已知数据
			boxRender(table);
			//展示已知数据222
			termofCustody(table);
				/*  var countAllPc=${countAllPc};
			  //完整功能
			  laypage.render({
			    elem: 'demo7'
			    ,count: countAllPc
			    ,layout: ['count', 'prev', 'page', 'next']
			    ,jump: function(obj){
			      console.log(obj);
			      console.log(obj.limit);
			    }
			  });   */
			 //监听工具条
		  table.on('tool(demo)', function(obj){
			//444
		    var data = obj.data;
		    var tr = obj.tr;
		    //obj.data.retentionperiodid
		    if(obj.event === 'detail'){
		      layer.msg('ID：'+ data.id + ' 的查看操作');
		    } else if(obj.event === 'del'){
		      layer.confirm('您确定要删除该条记录吗？',{title:'删除'},function(index){
		    	var boxpropertyid = obj.data.boxpropertyid;
		    	var boxpropertythickness = obj.data.boxpropertythickness;
		      	var boxpropertypag = obj.data.boxpropertypag;
		    	$.ajax({
		    		url:"../filecustomizationfileboxcontroller/deleteBoxProperties",
		    		type:"post",
		    		async:false,
		    		data:{
		    			"boxpropertyid":boxpropertyid,
		    			"boxpropertythickness":boxpropertythickness,
		    			"boxpropertypag":boxpropertypag
		    		},
		    		success:function(data){
		    			if(data	== 2){
		    				
		    				layer.msg("该盒下存在多个文件！不可被删除！！");
		    			}else if(data >=1){
		    				//obj.del();
		    				
		    				layer.msg("删除成功",{offset:'auto',time:1500},function(){
	      						layui.use(['table','laypage', 'layer'], function() {
	      							var table = layui.table;
	      							var $=layui.$;
	      							var laypage = layui.laypage,
	      							    layer = layui.layer;
	      						boxRender(table);
      						});
	      						layer.closeAll();
							})
		    			}else if(data == 0){
		    				
		    				layer.msg("删除失败！！");
		    			}
		    		}
		    		
		    	});
		      });
		    } else if(obj.event === 'edit'){
		      layer.open({
				type: 1,
				title:'<i class="fa fa-bars" style="padding:0 5px"></i>编辑',
				area: ['600px', '300px'],
				skin: 'add_label_bg',
				offset: 'auto',
				shade: [0.8, '#393D49'],
				//编辑弹出层
				content: '<div class="add_lb1"><label class="layui-form-label labers">盒厚度 (cm)</label><div class="layui-input-block"><input type="text" id="boxpropertythickness" value="" class="layui-input"/></div></div><div class="add_lb1"><label class="layui-form-label labers">最多可装页数</label> <div class="layui-input-block"><input type="text" id="boxpropertypag" value=""  class="layui-input"/></div></div>'
			     +'<div style="text-align: center;"><button class="layui-btn btn_color" id="UpdateOK">确定</button></div>'
				});
		        var boxpropertyid = obj.data.boxpropertyid;
		      	document.getElementById("boxpropertythickness").value = obj.data.boxpropertythickness;
		      	document.getElementById("boxpropertypag").value = obj.data.boxpropertypag;
		      	console.log(boxpropertyid);
		      	var UpdateOK = document.getElementById("UpdateOK");
		      	UpdateOK.onclick = function(){
		      		var boxpropertythickness = document.getElementById("boxpropertythickness").value;
		      		var boxpropertypag = document.getElementById("boxpropertypag").value;
		      		 $.ajax({
		      			url:"../filecustomizationfileboxcontroller/updateBoxProperties",
		      			type:"post",
		      			async:false,
		      			data:{
		      				"boxpropertyid":boxpropertyid,
		      				"boxpropertythickness":boxpropertythickness,
		      				"boxpropertypag":boxpropertypag
		      			},
		      			success:function(data){
		      				if(data >= 1){
		      					layer.msg("修改成功",{offset:'auto',time:1500},function(){
		      						layui.use(['table','laypage', 'layer'], function() {
		      							var table = layui.table;
		      							var $=layui.$;
		      							var laypage = layui.laypage,
		      							    layer = layui.layer;
		      						boxRender(table);
	      						});
		      						layer.closeAll();
								})
								
		      				}else if(data == 0){
		      					layer.msg("修改失败");
		      					layer.closeAll();
		      				}
		      			}
		      		}); 
		      	}
		      	
		      //日期控件
				layui.use(['layer', 'laydate'], function(){ 
			    var layer = layui.layer // 获取layer组件
			    ,laydate = layui.laydate; // 获取laydate组件
			    //执行一个laydate实例
				laydate.render({
				  elem: '.date1' //指定元素
				});
			});
		    }else if(obj.event === 'dels'){
		    	var deleteOK = document.getElementById("deleteOK");
		    	var retentionperiodid = obj.data.retentionperiodid;
		    	var qx = document.getElementById("qx");
		    	layer.confirm('您确定要删除该条记录吗？',{title:'删除'},function(index){
		    		
			    		$.ajax({
				    		url:"../FileCustomizationTermOfCustodyController/deleteTermOfCustody",
				    		type:"post",
				    		async:false,
				    		data:{
				    			"retentionperiodid":retentionperiodid
				    		},
				    		success:function(data){
				    			if(data	== 2){
				    				layer.close(index);
				    				layer.msg("该盒下存在多个文件！不可被删除！！");
				    			}else if(data >=1){
				    				//obj.del();
				    				layer.msg("删除成功",{offset:'auto',time:1500},function(){
	      						      layui.use(['table','laypage', 'layer'], function() {
	      							  var table = layui.table;
	      							   var $=layui.$;
	      							   var laypage = layui.laypage,
	      							    layer = layui.layer;
	      							 termofCustody(table);
      						});
	      						layer.closeAll();
							})
				    			}else if(data == 0){
				    				layer.msg("删除失败！！");
				    			}else if(data == 3){
				    				layer.msg("该状态是默认状态，不可删除！！");
				    			}
				    		},
			    		
			    	}); 
		    	
		    		
		    	});
		    	/* qx.onclick = function(){
		    		
		    	} */
		    	
		    }
		  });
		});
		//盒属性渲染
		function boxRender(table){
			table.render({
				url:'${pageContext.request.contextPath}/filecustomizationfileboxcontroller/queryBoxProperties',
				elem: '#demo',
				cols: [
					[ //标题栏
						
						{
							field: 'boxpropertythickness',
							title: '盒厚度(cm)',
							width: 120,
							unresize:'false',
							rowspan: 2
						}, {
							field: 'boxpropertypag',
							title: '最多可装页数',
							minWidth: 120,
							maxWidth: 900,
							unresize:'false',
						},
						{
							field: 'right',
							title: '操作',
							width: 120,
							unresize:'false',
							toolbar: '#barDemo'
						}
					]
				],
					//,skin: 'line' //表格风格
				even: true,
				page: true //是否显示分页
				,limits: [10, 20, 30]
				,limit: 5 //每页默认显示的数量
				 
			});
		}
		//保管期限数据渲染
		function termofCustody(table){
			table.render({
				url:"${pageContext.request.contextPath}/FileCustomizationTermOfCustodyController/queryTermOfCustody",
				elem: '#demo2',
				cols: [
					[ //标题栏
						{
							field: 'retentionperiodcode',
							title: '保管期限代码',
							width: 140,
							unresize:'false',
							rowspan: 2
						}, {
							field: 'retentionperiodname',
							title: '保管期限',
							minWidth: 120,
							maxWidth: 900,
							unresize:'false',
						},{
							field: 'right',
							title: '操作',
							width: 120,
							unresize:'false',
							toolbar: '#barDemo2'
						}
					]
				],
					//,skin: 'line' //表格风格
				even: true,
				page: true //是否显示分页
				,limits: [10, 20, 30]
				,limit: 5 //每页默认显示的数量/* */
				/* ,done: function(res, curr, count){$("[data-field='retentionperiodstatus']").css('display','none'} */ 
				
			});
		};
		//添加分类模态框
		$(function(){
			$(".addType").click(function(){ //#btn为按钮id
			layer.open({
			type: 1,
			title:'<i class="fa fa-bars" style="padding:0 5px"></i>添加分类',
			area: ['600px', '500px'],
			skin: 'add_label_bg',
			offset: 'auto',
			shade: [0.8, '#393D49'],
			content: "<div class='add_lb1'>"+"<label class='layui-form-label'>类别代码</label>"+
			"<div class='layui-input-block'><input type='text' class='layui-input' name='typeCode' id='typeCode'/></div>"+
			"</div>"+"<div class='add_lb1'>"+"<label class='layui-form-label'>类别名称</label>"+
			" <div class='layui-input-block'><input type='text' class='layui-input' name='typeName' id='typeName'/></div>"+
			"</div>"+"<div class='add_lb1'>"+"<label class='layui-form-label'>分类级别</label>"+
			"<div class='layui-input-block'><select  lay-filter='aihao' class='layui-input' id='type_level' onchange='hj(value)'>"
                    +"<option value=''>请选择分类级别</option>"
                    +"<option value='1'>一级分类</option>"
                    +"<option value='2'>二级分类</option>"
			     +"</select></div>"+"</div>"
			     +"<div class='add_lb1' id='belong_toone'>"+"<label class='layui-form-label'>所属分类</label>"+
			     "<div class='layui-input-block'>"+"<select name='pcName' lay-filter='aihao' class='layui-input' id='suoshu' >"
			      +"<option>请选择所属一级分类</option>"
			     +"</select>"+"</div>"+"</div>"
			     +"<input type='hidden' name='scStatus' value='1' id='scStatus'/>"
			     +"<div class='add_lb1'>"+"<label class='layui-form-label'>分类描述</label>"
			     +"<div class='layui-input-block'>"+
			     "<textarea placeholder='请输入分类描述' class='layui-textarea' class='layui-input' name='typeContext' id='typeContext'></textarea>"+"</div>"+"</div>"
			     +"<div style='text-align: center;'>"+"<button class='layui-btn btn_color' onclick='addClassFication()' type='button' id='addClassFication'>确定</button>"+"</div>",
			     
			});
			  
			layui.use(['layer', 'laydate'], function(){ 
			  var layer = layui.layer // 获取layer组件
			  ,laydate = layui.laydate; // 获取laydate组件
			  //执行一个laydate实例
				laydate.render({
				  elem: '#test1' //指定元素
				});
			});
		 })

		 $(".addhe").click(function(){ //#btn为按钮id 添加盒
				layer.open({
				type: 1,
				title:'<i class="fa fa-bars" style="padding:0 5px"></i>添加盒属性',
				area: ['600px', '300px'],
				skin: 'add_label_bg',
				offset: 'auto',
				shade: [0.8, '#393D49'],
				content: '<div class="add_lb1"><label class="layui-form-label labers" >盒厚度 (cm)</label><div class="layui-input-block"><input type="text" id="Saveboxpropertythickness" class="layui-input"/></div></div><div class="add_lb1"><label class="layui-form-label labers">最多可装页数</label> <div class="layui-input-block"><input type="text" id="SaveBoxpropertypag" class="layui-input"/></div></div>'
				     +'<div style="text-align: center;"ha><button class="layui-btn btn_color" id="AddOK">确定</button></div>'
				});
				AddOK.onclick = function(){
					var boxpropertythickness = document.getElementById("Saveboxpropertythickness").value;
		      		var boxpropertypag = document.getElementById("SaveBoxpropertypag").value;
		      		var reg = /^\+?[1-9]\d*$/;
					if(boxpropertythickness == null || boxpropertythickness == ""){
						layer.msg("请填写盒厚度");
						return;
					}else if(boxpropertypag == null || boxpropertypag == ""){
						layer.msg("请填写最多可装页数");
						return;
					}else if(!reg.test(boxpropertythickness)){
						layer.msg("盒厚度只能为正整数数字");
						return;
					}else if(!reg.test(boxpropertypag)){
						layer.msg("可装页数只能为正整数数字");
						return;
					}else{
						 $.ajax({
			      			url:"../filecustomizationfileboxcontroller/saveBoxProperties",
			      			type:"post",
			      			async:false,
			      			data:{
			      				"boxpropertythickness":boxpropertythickness,
			      				"boxpropertypag":boxpropertypag
			      			},
			      			success:function(data){
			      				if(data >= 1){
			      					layer.msg("添加成功",{offset:'auto',time:1500},function(){
			      						layui.use('table', function() {
			      							var table = layui.table;
			      							boxRender(table);
			      							layer.closeAll();
		      							});
			      						
									})
			      					/* layer.msg("添加成功",{offset:'auto',time:1500},function(){
				      					layui.use(['table','laypage', 'layer'], function() {
				      							var table = layui.table;
				      							boxRender(table);
			      						});
				      						
				      						layer.closeAll();
									})  */
			      				}else if(data == 0){
			      					layer.msg("添加失败");	
			      				}
			      			}
			      		}); 
					}
		      	}
			
			 })
				$(".addtime").click(function(){ //#btn为按钮id
				layer.open({
				type: 1,
				title:'<i class="fa fa-bars" style="padding:0 5px"></i>添加保管期限',
				area: ['600px', '300px'],
				skin: 'add_label_bg',
				offset: 'auto',
				shade: [0.8, '#393D49'],
				content: '<div class="add_lb1"><label class="layui-form-label labers">保管期限代码</label><div class="layui-input-block"><input type="text" id="saveRetentionperiodcode" class="layui-input"/></div></div><div class="add_lb1"><label class="layui-form-label labers">保管期限</label> <div class="layui-input-block"><input type="text" id="saveRetentionperiodname" class="layui-input"/></div></div>'
				     +'<div style="text-align: center;"><button id="amsrOK" class="layui-btn btn_color">确定</button></div>'
				});
				var amsrOK = document.getElementById("amsrOK");
				//222
				amsrOK.onclick = function(){
					var retentionperiodcode = document.getElementById("saveRetentionperiodcode").value;
					var retentionperiodname = document.getElementById("saveRetentionperiodname").value;
					if(retentionperiodcode == null || retentionperiodcode == ""){
						layer.msg("请填写保管期限代码");
						return;
					}else if(retentionperiodname == null || retentionperiodname == ""){
						layer.msg("请填写保管期限");
						return;
					}else{
						$.ajax({
			      			url:"../FileCustomizationTermOfCustodyController/saveTermOfCustody",
			      			type:"post",
			      			async:false,
			      			data:{
			      				"retentionperiodcode":retentionperiodcode,
			      				"retentionperiodname":retentionperiodname
			      			},
			      			success:function(data){
			      				if(data >= 1){
			      					layer.msg("添加成功",{offset:'auto',time:1500},function(){
			      						layui.use('table', function() {
			      							var table = layui.table;
			      							termofCustody(table);
			      							layer.closeAll();
		      							});
			      						
									})
			      				}else if(data == 0){
			      					layer.msg("添加失败");
			      				}
			      			}
			      		}); 
					}
				}
				
			 })
				
		})
		///////////////////////////////////////此js为 唐传武所创/////////////////////////////////////////
			//二级分类所属的一级分类 的消失和出现
			  function hj(e){
				 if(e=="2"){
			          $("#belong_toone").css("display","block");
			          $.ajax({
						   url:"${pageContext.request.contextPath}/classfication/queryAllPrimaryClass",
							type:"post",
							dataType:"text",
							success:function(data){
								var list = eval("(" + data + ")");
								for (var i = 0; i < list.length; i++) {
									console.log(list[i].pcName);
									$("#suoshu").append("<option value='"+list[i].pcId+"'>"+list[i].pcName+"</option>");
								}
							},  
					   });
			        }else{
			          $("#belong_toone").css("display","none");
			        } 
			  }	
			
			
				//添加分类
				   function addClassFication(){
					   var typeCode=$("#typeCode").val();
						var typeName=$("#typeName").val();
						 var type_level=$("#type_level").val();
						 var typeId=$("#suoshu").val();
						 var scStatus=$("#scStatus").val();
						 var typeContext=$("#typeContext").val();
						 if(typeCode==""||typeCode==null){
							 layer.msg("类别代码不能为空!");
							 return false;
						 }else if(typeName==""||typeName==null){
							 layer.msg("类别名称不能为空!");
							 return false;
						 }else if(type_level==""||type_level==null){
							 layer.msg("请选择分类级别!");
							 return false;
						 
						 }else if(typeContext==""||typeContext==null){
							 layer.msg("请填写分类描述!");
							 return false;
						 }else{
							 if(type_level==1){//如果是一级分类时
								 $.ajax({
									 url:"${pageContext.request.contextPath}/classfication/addClassFication",
									 type:"post",
				        			 dataType:"text",
				        			 async:true,
				        			 data:{
				        				 "pcId":"",
				        				 "typeCode":typeCode,
				        				 "typeName":typeName,
				        				 "typeContext":typeContext,
				        				 "pcCode":typeCode,
				        				 "pcName":typeName,
				        				 "pcDescription":typeContext},
				        			 success:function(result){
				        				 if(result==4){
				        					 layer.msg("对不起,一级分类代码已存在!");
				        					
				        				 }else if(result==5){
				        					 layer.msg("对不起,一级分类名称已存在!");
				        					
				        				 }else if(result==6){
				        					 layer.msg("恭喜你,一级分类添加成功!",{offset:'auto',time:1500},function(){
												     location.reload();
												});  
				        				   }else{
				        					   layer.msg("对不起,一级分类添加失败!");
				        				   } 
				        			 },
									 
								 });
							 }else if(type_level==2){
								 if(typeId==1&&scStatus==0){
									 layer.msg("添加机构只能在全宗管理下操作!");
									 return;
								 }else{
									 $.ajax({
										 url:"${pageContext.request.contextPath}/classfication/addClassFication",
										 type:"post",
					        			 dataType:"text",
					        			 async:true,
					        			 data:{
					        				 "pcId":typeId,
					        				 "typeCode":typeCode,
					        				 "typeName":typeName,
					        				 "typeContext":typeContext,
					        				 "scCode":typeCode,
					        				 "scName":typeName,
					        				 "scStatus":scStatus,
					        				 "scDescription":typeContext},
					        			 success:function(result){
					        				 if(result==1){
					        					 layer.msg("对不起,二级分类代码已存在!");
					        					
					        				 }else if(result==2){
					        					 layer.msg("对不起,二级分类名称已存在!");
					        					 
					        				 }else if(result==3){
					        					 layer.msg("恭喜你,二级分类添加成功!",{offset:'auto',time:1500},function(){
					        						 location.reload();
												});
					        					
					        				 }else{
					        					 layer.msg("对不起,二级分类添加失败!");
					        				 } 
					        			 },
										 
									 });
								 }
								 
							 }
						 } 
						 
				  }
				
				
				function queryScByPcIdAndStatus(){
					if($("#onetype").val()==1){
						 $(".editOrg2").text("")
						$(".editOrg2").text("默认分类，不可删除")
						queryStr();
					}else if($("#onetype").val()==2){
						var quanzongid = $("#quanzongName").val();
						console.log(quanzongid);
						$.ajax({
							url:"${pageContext.request.contextPath}/classfication/queryScByPcIdAndStatus",
							type:"post",
							data:{"quanzongid":quanzongid},
							dataType:"json",
							/* contentType:"application/json", */
							success:function(data){
								console.log(data.onetype)
								app.onetype=data.onetype;
							},
						});
						
						
					}
				}
				
				$("#quanzongName").bind('change',function(){
					var onetype = $("#onetype").val();
					
					if($("#onetype").val()==1){
						 $(".editOrg2").text("")
						$(".editOrg2").text("默认分类，不可删除")
						queryStr();
					}else if($("#onetype").val()==2){
						var quanzongid = $("#quanzongName").val();
						console.log(quanzongid);
						$.ajax({
							url:"${pageContext.request.contextPath}/classfication/queryScByPcIdAndStatus",
							type:"post",
							data:{"quanzongid":quanzongid},
							dataType:"json",
							/* contentType:"application/json", */
							success:function(data){
								console.log(data.onetype)
								app.onetype=data.onetype;
							},
						});
						
						
					}
				});
				
			 ////////////////////////////////此js 结束///////////////////////////////////////	
			
				
			
			
			
			
			  
			 
		
		</script>
	</body>

</html>