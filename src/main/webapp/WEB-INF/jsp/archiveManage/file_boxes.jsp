<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>档案整理整理系统_档案整理_文件装盒</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css"/>
		<!-- 图片预览 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css">
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
		body .add_label_bg>.layui-layer-title,.btn_color{
			background: #EA5519;
			color: #FFFFFF;
		}
		
		.Scanning_Images{
				width: 100%;
				min-height: 400px;
				background: #FFFFFF;
			}
			.Scanning_Images li{
				float: left;
				width: 100px;
   				height: 150px;
   				background: #FFFFFF;
   				margin-left:28px ;
   				margin-top: 15px;
   				text-align: right;
   				box-shadow: 0.5px 1px 3px #000;
			}
			.Scanning_Images li img{
				width: 100%;
				height: 80%;
			}
			.Scanning_Images li button{
				border: none;
				outline: none;
				background: none;
				cursor: pointer;
			}
			.Scanning_Images li p{
				text-align: center;
			}
			
		.viewer-container,.viewer-fixed,.viewer-fade,.viewer-transition,.viewer-in{
			z-index: 99999999999!important;
			/*弹出层查看图片优先级提升*/
		}
		
		.btn-a{
			text-align: center;
			background: none;
			border: 1px solid #000;
			display: inline-block;
			padding: 2px;
			border-radius: 5px;
			margin: 3px;
		}
		.btn-b{
			text-align: center;
			background: none;
			border: 1px solid #000;
			display: inline-block;
			padding: 2px;
			border-radius: 5px;
			margin: 3px;
			color: #EA5519;
			border: 1px solid #EA5519;
		}
	</style>
	</head>
	<body class="layui-layout-body">
		<div >
			<div class="layui-layout layui-layout-admin">

				<!--class 个性化设置nav_bg1-->
				<div class="copy">
					<!-- 版权所有 -->
					<p>COPYRIGHT&nbsp;&copy;2018<a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有</p>
				</div>

				<div class="logo_nav">
					<!-- 头部区域 -->
					<div>
						<span class="logo_img"><img src="${pageContext.request.contextPath}/imgs/home.gif" width="110" height="50"/></span>
						<div class="logo">
							档案收集整理系统
							<a href="${pageContext.request.contextPath}/log/goHome" id="home">返回主页&gt;</a>
						</div>	
					</div>
					
				</div>
				<!--全宗导航-->
				<div class="top_bar">
					<!-- 头部区域 -->
					<ul class="layui-nav" id="top_nav">
						<li class="layui-nav-item ">
							<c:if test="${zm:buttenPremission('aa',sessionScope.user.role.authorities) }">
								<a class="active" href="${pageContext.request.contextPath}/fileScanning/goFileScanning?meng=<%=Math.random() %>">档案扫描</a>
							</c:if>
						</li>
						<li class="layui-nav-item">
							<c:if test="${zm:buttenPremission('ab',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/archiveFileStore/goStore?meng=<%=Math.random() %>">档案存储</a>
							</c:if>
						</li>
						<li class="layui-nav-item layui-this">
							<c:if test="${zm:buttenPremission('ae',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/knowledgeBase/goIdentification?currentPage=1&meng=<%=Math.random() %>">档案整理</a>
							</c:if>
						</li>
						<li class="layui-nav-item">
							<c:if test="${zm:buttenPremission('af',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/boxSubmitReview/goBoxReview?meng=<%=Math.random() %>">档案送审</a>
							</c:if>
						</li>
						<li class="layui-nav-item layui-hide-xs">
							<c:if test="${zm:buttenPremission('ag',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/fileAudit/fileAuditShow?meng=<%=Math.random() %>">档案审核</a>
							</c:if>
						</li>
					</ul>
				</div>
				<!-- 主体内容 -->
				<div class="layui-body" style="top:140px;left: 0;">
					<div class="layui-row">
					<div class="layui-inline" style="padding-top: 10px;padding-left:10px;width: 100%;">
							<div style="text-align: center;">
							<c:if test="${zm:buttenPremission('ad',sessionScope.user.role.authorities) }">
								<a href="../knowledgeBase/goIdentification">
									<button class="btn-a">鉴定分类</button></a>
									<a href="#"><button class="btn-b">文件装盒</button>
								</a>
							</c:if>
							</div>
							<div style="padding:15px;background: #FFFFFF;font-size: 16px;font-weight: bold;">
								<i class="fa fa-step-forward font_color" style="color: #EA5519;margin: 0 10px;"></i>文件装盒
							</div>
						<div id="" style="float: left;padding-left: 20px;padding-top: 15px;">
					 		<c:forEach items="${userList }" var="userList"> 
					 			<input type="hidden" id=quanzongId value="${userList.quanzongId }"/>
						 		<label for="" id="quanzongName"  style="float: left;"><i class="fa fa-circle" style="color: #EA5519;"></i>
						 				${userList.quanzongName }
						 		</label>
					 		</c:forEach>
					 		<select name="archivefileanual" id="archivefileanual" style="float: left;">
							 		<option value="请选择">请选择</option>
						 		<c:forEach items="${filePackingBoxAnnualQueryList }" var="filePackingBoxAnnualQueryList" >
						 			<option value="${filePackingBoxAnnualQueryList.archivefileanual }">${filePackingBoxAnnualQueryList.archivefileanual }</option>
						 		</c:forEach>
					 		</select>
					 		<select name="retentionperiodid" id="retentionperiodid" style="float: left;">
									<option value="请选择">请选择</option>
					 		</select>
					 		<select name="primaryclassificationid" id="primaryclassificationid" style="display: none;float: left;">
									<option value="请选择">请选择</option>
					 		</select>
					 		<select name="secondaryclassificationid" id="secondaryclassificationid" style="display: none;float: left;">
									<option value="请选择">请选择</option>
					 		</select>
<script type="text/javascript">
/* 	document.getElementById("primaryclassificationid").style.display = 'none';
	document.getElementById("secondaryclassificationid").style.display = 'none'; */
	//年度
	var archivefileanual = document.getElementById("archivefileanual");
	//全宗ID
	var quanzongId = document.getElementById("quanzongId");
	//保管期限
	var retentionperiodid = document.getElementById("retentionperiodid");
	//一级分类
	var primaryclassificationid = document.getElementById("primaryclassificationid");
	//二级分类
	var secondaryclassificationid = document.getElementById("secondaryclassificationid");
	//年度下拉框点击事件
	archivefileanual.onchange = function(){
		var archivefileanual = this.options[this.options.selectedIndex].value;
		if(archivefileanual == "请选择"){
			document.getElementById("primaryclassificationid").style.display = 'none';
			document.getElementById("secondaryclassificationid").style.display = 'none';
			retentionperiodid.options.length=1; 
			return;
		}else{
			$.ajax({
				url:"${pageContext.request.contextPath}/FilePackingBoxController/filePackingBoxsafekeepingTermQuery",
				type:"post",
				async:false,
				data:{"archivefileanual":archivefileanual,"quanzongId":quanzongId.value},
				success:function(data){
					if(retentionperiodid.options.length>1){
						document.getElementById("primaryclassificationid").style.display = 'none';
						document.getElementById("secondaryclassificationid").style.display = 'none';
						retentionperiodid.options.length=1; 
						for(var i=0;i<data.length;i++){
							retentionperiodid.options.add(new Option(data[i].retentionperiodname,data[i].retentionperiodid));
						}
					}else{
						for(var i=0;i<data.length;i++){
							document.getElementById("primaryclassificationid").style.display = 'none';
							document.getElementById("secondaryclassificationid").style.display = 'none';
							retentionperiodid.options.add(new Option(data[i].retentionperiodname,data[i].retentionperiodid));
						}
					}
				}
			});
		}
		
	}
	//保管期限点击事件
	retentionperiodid.onchange = function(){
		var quanzongId = document.getElementById("quanzongId").value;
		var retentionperiodid = document.getElementById("retentionperiodid").value;
		var archivefileanual = document.getElementById("archivefileanual").value;
		var retentionperiodid = this.options[this.options.selectedIndex].value;
		if(retentionperiodid == "请选择"){
			document.getElementById("primaryclassificationid").style.display = 'none';
			document.getElementById("secondaryclassificationid").style.display = 'none';
			primaryclassificationid.options.length=1; 
			return;
		}else{
			 $.ajax({
				url:"${pageContext.request.contextPath}/FilePackingBoxController/filePackingBoxArchivesPrimaryQuery",
				type:"post",
				async:false,
				data:{
					"quanzongId":quanzongId,
					"archivefileanual":archivefileanual,
					"retentionperiodid":retentionperiodid
					},
				success:function(data){
					 if(primaryclassificationid.options.length>1){
						 document.getElementById("primaryclassificationid").style.display = 'block';
						 document.getElementById("secondaryclassificationid").style.display = 'none';
						 primaryclassificationid.options.length=1; 
						for(var i=0;i<data.length;i++){
							primaryclassificationid.options.add(new Option(data[i].pcname,data[i].primaryclassificationid));
						}
					}else{
						for(var i=0;i<data.length;i++){
							document.getElementById("primaryclassificationid").style.display = 'block';
							document.getElementById("secondaryclassificationid").style.display = 'none';
							primaryclassificationid.options.add(new Option(data[i].pcname,data[i].primaryclassificationid));
						}
					} 
				}
			}); 
		}
	}
	
	//一级分类点击事件
	primaryclassificationid.onchange = function(){
		var quanzongId = document.getElementById("quanzongId").value;
		var retentionperiodid = document.getElementById("retentionperiodid").value;
		var archivefileanual = document.getElementById("archivefileanual").value;
		var primaryclassificationid = this.options[this.options.selectedIndex].value; 
		if(primaryclassificationid == "请选择"){
			document.getElementById("secondaryclassificationid").style.display = 'none';
			secondaryclassificationid.options.length=1; 
			return;
		}else{
			 $.ajax({
				url:"${pageContext.request.contextPath}/FilePackingBoxController/filePackingBoxArchiveSsecondaryQuery",
				type:"post",
				async:false,
				data:{
					"quanzongId":quanzongId,
					"archivefileanual":archivefileanual,
					"retentionperiodid":retentionperiodid,
					"primaryclassificationid":primaryclassificationid
					},
				success:function(data){
					 if(secondaryclassificationid.options.length>1){
						 document.getElementById("secondaryclassificationid").style.display = 'block';
						 secondaryclassificationid.options.length=1; 
						for(var i=0;i<data.length;i++){
							secondaryclassificationid.options.add(new Option(data[i].scname,data[i].secondaryclassificationid));
						}
					}else{
						for(var i=0;i<data.length;i++){
							document.getElementById("secondaryclassificationid").style.display = 'block';
							secondaryclassificationid.options.add(new Option(data[i].scname,data[i].secondaryclassificationid));
						}
					} 
				}
			}); 
		}
	}
	
	
</script>
					 	</div>
					 	<div id="" style="float: right;padding-right: 20px;padding-top: 15px;">
					 	<c:if test="${zm:buttenPremission('aea',sessionScope.user.role.authorities) }">
					 		<div class="layui-input-inline">
					        	<input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" id="keyWord" placeholder="请输入关键字查询" /> 
					     	 </div>
					     <button class="layui-btn layui-btn-normal" id="query">查询</button>
					 	</c:if>
					 	</div> 
					 </div>
					 <div style="padding: 15px;">
					 	<table class="layui-hide" id="demo" lay-filter="demo" ></table><!-- 111 -->
					 </div>
					<script type="text/html" id="barDemo">
					  <!-- 这里同样支持 laytpl 语法，如： -->
					    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
					</script>
					<div id="" style="margin: 18px 15px;">
						<label for="">档案合计：</label><span id="countFile"></span>件&nbsp;<span id="countPage"></span>页<span style="margin:0 15px;">|</span>
						<label for="">装盒</label>
						<select name="boxProperties" id="boxProperties">
							<option value="请选择">请选择</option>
							<c:forEach items="${AmCoBoxPropertyList }" var="AmCoBoxPropertyList">
								<option value="${AmCoBoxPropertyList.boxpropertyid }">${AmCoBoxPropertyList.boxpropertythickness }cm (最多可装${AmCoBoxPropertyList.boxpropertypag }页)</option>
							</c:forEach>
						</select>
						<div class="layui-btn-group demoTable">
							<button class="layui-btn layui-btn-sm file_boxes" data-type="getCheckData">装盒</button>
						</div>	
					</div>	
						 
					</div>	
				</div>
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade" id="newBody"></div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!-- 图片预览插件 -->
		<script src="${pageContext.request.contextPath}/js/viewer.min.js"></script>
		<script>
		var data;
		var newData;
		var query = document.getElementById("query");
		secondaryclassificationid.onchange = function(){
			var secondaryclassificationid = document.getElementById("secondaryclassificationid");
			var quanzongId = document.getElementById("quanzongId").value;
			var retentionperiodid = document.getElementById("retentionperiodid").value;
			var archivefileanual = document.getElementById("archivefileanual").value;
			var primaryclassificationid = document.getElementById("primaryclassificationid").value;
			var secondaryclassificationid = this.options[this.options.selectedIndex].value; 
			if(primaryclassificationid == "请选择"){
				return;
			}else{
				var keywords = new Array();
				keywords[0] = quanzongId; 
				keywords[1] = archivefileanual; 
				keywords[2] = retentionperiodid; 
				keywords[3] = primaryclassificationid;
				keywords[4] = secondaryclassificationid;
				newData = CascadeQuery(keywords);
				data = newData;
				dataRendering(data);
			}
		}
		
		query.onclick = function(){
			var keywords = new Array();
			keywords[0] = document.getElementById("keyWord").value;
			keywords[1] = document.getElementById("quanzongId").value; 
			keywords[2] = document.getElementById("archivefileanual").value; 
			keywords[3] = document.getElementById("retentionperiodid").value;
			keywords[4] = document.getElementById("primaryclassificationid").value;;
			keywords[5] = document.getElementById("secondaryclassificationid").value;
			newData = keyWordQuery(keywords);
			data = newData;
			dataRendering(data);
		}
			
			var selectValueBindOld  = new Array();
			var selectValueBindNew = new Array();
			var table;
			var dataRendering = function(data){
			layui.use('table', function() {
				table = layui.table;
				var $ = layui.$;
				table.on('checkbox(demo)', function(obj){
					/* if(obj){
						if(obj.checked == true){
							for (var i = 0; i < selectValueBindOld.length; i++) {
								selectValueBindOld[i]
							}
							console.log(obj.data.archivefilepages);
							console.log(document.getElementById("boxProperties").value);
						}else{
							return;
						}
						
						
					}else{
						console.log("不获取数据");
					} */
					 
				});
				//展示已知数据
				table.render({
					elem: '#demo',
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
								field: 'archivefilefilenumber',
								title: '档号',
								width: 220,
								unresize:'false',
								sort:true,
							}, {
								field: 'archivefilereferencenumber',
								title: '文号',
								minWidth: 100,
								unresize:'false',
							}, {
								field: 'archivefileresponsible',
								title: '责任者',
								minWidth: 100,
								unresize:'false',
							}, {
								field: 'archivefiletitle',
								title: '题名',
								width: 200,
								unresize:'false',
							},
							 {
								field: 'archivefilecreatetime',
								title: '日期',
								width: 200,
								unresize:'false',
							},
							{
								field: 'afsecurityclassrification',
								title: '密级',
								width: 100,
								unresize:'false',
							},
							{
								field: 'archivefilepages',
								title: '页数',
								width: 100,
								unresize:'false',
							},
							{
								field: 'archivefileremark',
								title: '备注',
								width: 100,
								unresize:'false',
								event:'setArchivefileremark',
								edit: 'text',
							},
							{
								field: 'right',
								title: '操作',
								width: 150,
								unresize:'false',
								toolbar: '#barDemo'
							}
						]
					],
					data:data.data,
						//,skin: 'line' //表格风格
					even: true,
					page: true //是否显示分页
					//,limits: [5, 7, 10]
					,limit: 10//每页默认显示的数量
				});
				var countFile = document.getElementById("countFile").innerText=data.count;
				var pageCount = 0;
				for (var i = 0; i < data.data.length; i++) {
					pageCount = pageCount+parseInt(data.data[i].archivefilepages);
				}
				var countPage = document.getElementById("countPage").innerText=pageCount;
				//监听工具条
				table.on('tool(demo)', function(obj) {
					var value = obj.value //得到修改后的值
				    ,data = obj.data //得到所在行所有键值
				    ,field = obj.field; //得到字段
				    
					var archiveFileId = obj.data.archiveFileId;
					var tr = obj.tr;
					if(obj.event === 'detail') {
						$.ajax({
							url:"${pageContext.request.contextPath}/archiveFileStore/havingFileAttachmentList",
							type:"post",
							data:"archiveFileId="+obj.data.archivefileid,
							dataType:"json",
							success:function(result){
								var text=""
									text+="<div class='add_lb1'><ul class='Scanning_Images' onclick='img_vi()'>"
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
					}else if(obj.event === 'edit'){
						window.location.href="${pageContext.request.contextPath}/archiveFileStoreModify/goArchiveFileStoreEdit?archiveFileId="+archiveFileId;
					}
					
					
				});
				//单元格监听事件
				table.on('edit(demo)', function(obj){
					var value = obj.value //得到修改后的值
				    ,data = obj.data //得到所在行所有键值
				    ,field = obj.field; //得到字段
				    /* console.log(value);
				    console.log(data.archivefileid);
				    console.log(data.archivefileremark); */
				    var archivefileid = data.archivefileid;
				    var archivefileremark = data.archivefileremark;
				    //更新备注
				    if(myKeypress(archivefileid,archivefileremark) > 0){
				    	var msg = "备注添加成功！";
						 layer.msg(msg,{time:1000});
				    }else{
				    	var msg = "备注添加失败！";
						 layer.msg(msg,{time:1000});
				    }
				});
				
			});
			
		}
			//图片预览
			function img_vi() {
				/* console.log($('.Scanning_Images')); */
				$('.Scanning_Images').viewer();
			}
			img_vi();
			
			  //定义集合并解析
			  var demoArray = new Array();
			  //获取截取后的数组
			  var cutDemoArray = new Array();
			  //获取截取后的件号
			  var partNumber = new Array();
			  //装盒的数据
			  var cartoningFunctionData;
			  //是否连续
			  var isOrdered;
			 active = {
					    getCheckData: function(){ //获取选中数据
					      var checkStatus = table.checkStatus('demo')
					      ,data = checkStatus.data;
					      var x=JSON.stringify(data);
					      demoArray =  JSON.parse(x);
					      for (var i = 0; i < demoArray.length; i++) {
					    	  cutDemoArray[i] = demoArray[i].archivefilefilenumber.split("-");
							}
					      for (var i = 0; i < cutDemoArray.length; i++) {
				    		  partNumber[i] = parseInt(cutDemoArray[i][cutDemoArray[i].length-1]);
							}
					      if(document.getElementById("boxProperties").value == "请选择"){
					    	  isOrdered = false;
					    	  var msg = "请选择要装的盒子属性";
					    	  layer.msg(msg,{time:5000});
					    	  return isOrdered;
					      }else{
					    	  //序列判断
					    	  if(partNumber[partNumber.length-1]-partNumber[0] == partNumber.length-1){
						    	  isOrdered = true;
				    			  var msg = "恭喜!检测完毕：符合条件";
				    			  /* layer.msg(msg,{time:5000}); */
				    			  if(msg == "恭喜!检测完毕：符合条件"){
				    				  var pageCount = 0;
				    				 for (var i = 0; i < partNumber.length; i++) {
				    					 pageCount = parseInt(pageCount)+parseInt(demoArray[i].archivefilepages);
										}
				    				 
				    				 document.getElementById("boxProperties").value;
				    				 if(pageCount <= boxPrimaryKeyQuery(document.getElementById("boxProperties").value)[0].boxpropertypag){
				    					 layer.open({
				    							type: 1,
				    							title:'<i class="fa fa-bars" style="padding:0 5px"></i>装盒',
				    							area: ['400px', '280px'],
				    							skin: 'add_label_bg',
				    							offset: 'auto',
				    							shade: [0.8, '#393D49'],
				    							content: '<div class="add_lb1" id="form" style="text-align: center;" ><label style="font-weight: bold;">盒内情况说明</label><textarea name="" id="boxsituation" rows="" cols="" style="width: 381px; height: 163px; margin: 0px;"></textarea><div style="text-align: center;margin:5px;"><button class="layui-btn btn_color" id="zhSure">确定</button></div></div><img id="img" width="100%" height="200px" style="display:none" src="${pageContext.request.contextPath}/imgs/loading.gif"/>'
				    							});
				    					 var rowsData = demoArray;
				    					 document.getElementById("zhSure").onclick = function(){
				    						 //判断盒内情况说明是否为空
				    						 if(document.getElementById('boxsituation').value == '' || document.getElementById('boxsituation').value == null){
				    							 var msg = "无";
				    							 layer.msg(msg,{time:5000});
				    						 }
				    						 var msg = "开始装盒请稍等!";
			    							 if(msg == "开始装盒请稍等!"){
			    								 var boxProperties = document.getElementById('boxProperties').value;	//获取盒主键
					    						 var isupdateFilePackingBox;											//是否添加状态成功
					    						 var boxUUID;															//UUID		
					    						 if(boxProperties != null || boxProperties != ""){
					    							 var listDatas = [];
							    						for (var i = 0; i < rowsData.length; i++) {
							    							listDatas.push({
							    								archivefilefilenumber:rowsData[i].archivefilefilenumber,
							    								archivefileid:rowsData[i].archivefileid,
							    								archivefileremark:rowsData[i].archivefileremark
							    								
							    							})
														}
					    							 	//更新档案盒子主键
					    								boxUUID = updateFilePackingBox(listDatas);
					    								if(boxUUID != null ){
					    									isupdateFilePackingBox = 1;
					    								}else{
					    									isupdateFilePackingBox = 2;
					    								}
					    							if(isupdateFilePackingBox == 1){
					    								//进行装盒111
					    								//件数
					    								var boxcasesnumber = rowsData.length;
					    								//文件主键
												    	//档案盒的主键
												    	var boxid = boxUUID;
					    								//全宗号
					    								var quanzongId = document.getElementById("quanzongId").value;
					    								//全宗名
							    						var quanzongName = document.getElementById("quanzongName").innerText;
					    								//年度
					    								var archivefileanual = document.getElementById("archivefileanual").value;
					    								//保管期限
					    								var retentionperiodid = document.getElementById("retentionperiodid").value;
					    								
					    								//一级菜单ID
					    								var primaryclassificationid = document.getElementById("primaryclassificationid").value;
					    								//二级菜单ID
					    								var secondaryclassificationid = document.getElementById("secondaryclassificationid").value;
					    								//盒子主键
					    								var boxProperties = document.getElementById("boxProperties").value;
					    								//盒内情况说明
					    								var boxsituation = document.getElementById('boxsituation').value;
					    								//起件号
					    								var boxstartnumber;
					    								//止件号
					    								var boxendnumber;
					    								//一级分类名称
					    								 var primaryclassificationNames = document.getElementById("primaryclassificationid").children;
									    				 var primaryclassificationName;
									    				 for (var i = 0; i < primaryclassificationNames.length; i++) {
									    					 if(primaryclassificationNames[i].selected == true){
									    						 primaryclassificationName = primaryclassificationNames[i].innerText;
									    					 }
														}
									    				 //保管期限名称
									    				 var retentionperiodidNames = document.getElementById("retentionperiodid").children;
									    				 var retentionperiodidName;
									    				 for (var i = 0; i < retentionperiodidNames.length; i++) {
									    					 if(retentionperiodidNames[i].selected == true){
									    						 retentionperiodidName = retentionperiodidNames[i].innerText;
									    					 }
														}
									    				 //二级分类名称
									    				 var secondaryclassificationidNames = document.getElementById("secondaryclassificationid").children;
									    				 var secondaryclassificationidName;
									    				 for (var i = 0; i < secondaryclassificationidNames.length; i++) {
									    					 if(secondaryclassificationidNames[i].selected == true){
									    						 secondaryclassificationidName = secondaryclassificationidNames[i].innerText;
									    					 }
														}
							    						for(var i =0;i<rowsData.length;i++){
							    							for(var j =0;j<rowsData[i].archivefilefilenumber.split("-").length;j++){
							    								boxstartnumber = rowsData[0].archivefilefilenumber.split("-")[rowsData[i].archivefilefilenumber.split("-").length-1];
							    								boxendnumber = rowsData[rowsData.length-1].archivefilefilenumber.split("-")[rowsData[i].archivefilefilenumber.split("-").length-1];
							    							}
							    						}
							    						var cartoningFunctionData ;
							    						//文件主键
							    						var archivefileids = '';
							    						for (var i = 0; i < rowsData.length; i++) {
							    							archivefileids = archivefileids+"-"+rowsData[i].archivefileid;
						    							}
							    						var excelList = [];
							    						for (var i = 0; i < rowsData.length; i++) {
							    							excelList.push({
							    									archivefilefilenumber:rowsData[i].archivefilefilenumber,
							    									archivefilereferencenumber:rowsData[i].archivefilereferencenumber,
							    									archivefileresponsible:rowsData[i].archivefileresponsible,
							    									archivefiletitle:rowsData[i].archivefiletitle,
							    									archivefilecreatetime:rowsData[i].archivefilecreatetime,
							    									afsecurityclassrification:rowsData[i].afsecurityclassrification,
							    									archivefilepages:rowsData[i].archivefilepages,
							    									archivefileremark:rowsData[i].archivefileremark,
							    									archivefileid:rowsData[i].archivefileid,
							    									collator:rowsData[i].collator
							    									})
														}
							    						cartoningFunctionData = {
							    								boxid:boxid,
																boxProperties:boxProperties,
																boxsituation:boxsituation,
																boxcasesnumber:boxcasesnumber,
																quanzongId:quanzongId,
																quanzongId:quanzongId,
																archivefileanual:archivefileanual,
																retentionperiodid:retentionperiodid,
																secondaryclassificationid:secondaryclassificationid,
																boxstartnumber:boxstartnumber,
																boxendnumber:boxendnumber,
																quanzongName:quanzongName.replace(/\s+/g,""),
																excelList:excelList,
																retentionperiodidName:retentionperiodidName.replace(/\s+/g,""),
																secondaryclassificationidName:secondaryclassificationidName.replace(/\s+/g,"")
																
																};
							    						document.getElementById("form").style.display='none';
														/* document.getElementById("img").style.display='block'; */
														var msg = "文件正在装盒，请耐心等待.....";
						    							layer.msg(msg,{time:10000});
														/* console.log(cartoningFunctionData); */
														//进行装盒
							    						setTimeout(function(){cartoningFunction(cartoningFunctionData)}, 2000);
							    						
							    						var amCoBoxArr = new Array();
					    							}else{
					    								var msg = "抱歉！添加盒子主键失败";
						    							 layer.msg(msg,{time:5000});
					    							}	
					    							
					    						 }else{
					    							 var msg = "抱歉！没有拿到盒子的主键！！";
					    							 layer.msg(msg,{time:5000});
					    						 }
			    							 }
				    						
				    					 }
				    					 
				    				 }else{
				    					 console.log(pageCount);
				    					 var msg = "已选文件共计"+pageCount+"页，建议重新选择！" 
				    					 layer.msg(msg);
				    				 }
				    			  }
								    var newDemoArray = new Array();
									var newCutDemoArray = new Array();
									var newPartNumber = new Array();
									demoArray = newDemoArray;
									cutDemoArray = newCutDemoArray;
									partNumber = newPartNumber;
								  return isOrdered;
						      }else{
						    		isOrdered = false;
						    		 var msg = "请选择文件";
									layer.msg(msg)
									var newDemoArray = new Array();
									var newCutDemoArray = new Array();
									var newPartNumber = new Array();
									demoArray = newDemoArray;
									cutDemoArray = newCutDemoArray;
									partNumber = newPartNumber;
									return isOrdered;
						      }
					      }
					    }
					
					  }
			  
					  $('.demoTable .layui-btn').on('click', function(){
					    var type = $(this).data('type');
					    active[type] ? active[type].call(this) : '';
					    if(isOrdered){
					    	/* layer.msg("开始生成盒",{time:5000}); */
					    	
					    }else{
					    	return;
					    }
					  });
			
			 /* 进行装盒 */
			 var cartoningFunction =function(cartoningFunctionData){
				 var data;
				$.ajax({
						url:"${pageContext.request.contextPath}/FilePackingBoxController/cartoningFunction",
						type:"post",
						async:false,
						data:JSON.stringify(cartoningFunctionData),// 指定请求的数据格式为json，实际上传的是json字符串  
		                contentType: 'application/json;charset=utf-8',
						success:function(datas){
							data = datas;
						}
					});
				if(data == true){
					layer.closeAll();
					var msg = "装盒成功！";
					layer.msg(msg,{time:5000});
					var keywords = new Array();
					keywords[0] = document.getElementById("keyWord").value;
					keywords[1] = document.getElementById("quanzongId").value; 
					keywords[2] = document.getElementById("archivefileanual").value; 
					keywords[3] = document.getElementById("retentionperiodid").value;
					keywords[4] = document.getElementById("primaryclassificationid").value;;
					keywords[5] = document.getElementById("secondaryclassificationid").value;
					newData = keyWordQuery(keywords);
					data = newData;
					dataRendering(data);
					
				}else{
					layer.closeAll();
					layer.msg("装盒失败！")
					layer.msg(msg,{time:5000});
				}
				
				 return data;
			 };
			/* 级联菜单查询 */
			var CascadeQuery = function(keywords){
				var data;
				 $.ajax({
						url:"${pageContext.request.contextPath}/FilePackingBoxController/filePackingBoxALLQuery",
						type:"post",
						async:false,
						data:{
							"quanzongId":keywords[0],
							"archivefileanual":keywords[1],
							"retentionperiodid":keywords[2],
							"primaryclassificationid":keywords[3],
							"secondaryclassificationid":keywords[4]	
							},
						success:function(datas){
							data = datas;
						}
					}); 
				 return data;
			} 
		
			/* 关键词查询 */
		 	var keyWordQuery = function(keywords){
				var data;
				 $.ajax({
					url:"${pageContext.request.contextPath}/FilePackingBoxController/filePackingBoxALLQuery",
					type:"post",
					async:false,
					beforeSend:function(xmlHttp){ 
				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
				     },
					data:{
						"keyWord":keywords[0],
						"quanzongId":keywords[1],
						"archivefileanual":keywords[2],
						"retentionperiodid":keywords[3],
						"primaryclassificationid":keywords[4],
						"secondaryclassificationid":keywords[5]	
					},
					success:function(datas){
						data = datas;
					}
				}); 
				 return data;
			}  
			/* 根据盒主键查询盒子页数 */
			var boxPrimaryKeyQuery = function(boxpropertyid){
				var data;
				 $.ajax({
					url:"${pageContext.request.contextPath}/FilePackingBoxController/boxPrimaryKeyQuery",
					type:"post",
					async:false,
					data:{
						"boxpropertyid":boxpropertyid,
					},
					success:function(datas){
						data = datas;
					}
				}); 
				 return data;
			} 
			/* 装盒推荐 */
			var boxRecommendation = function(keywords){
				var data;
				 $.ajax({
					url:"${pageContext.request.contextPath}/FilePackingBoxController/boxRecommendation",
					type:"post",
					async:false,
					data:{
						"keyWord":keywords[0],
						"quanzongId":keywords[1],
						"archivefileanual":keywords[2],
						"retentionperiodid":keywords[3],
						"primaryclassificationid":keywords[4],
						"secondaryclassificationid":keywords[5]	
					},
					success:function(datas){
						data = datas;
					}
				}); 
				 return data;
			} 
			/* 根据盒子主键对文件进行添加盒子主键功能 */
			var updateFilePackingBox = function(listDatas){
				var data;
				 $.ajax({
					url:"${pageContext.request.contextPath}/FilePackingBoxController/updateFilePackingBox",
					type:"post",
					async:false,
					data:JSON.stringify(listDatas),// 指定请求的数据格式为json，实际上传的是json字符串  
	                contentType: 'application/json;charset=utf-8',
					success:function(datas){
						data = datas;
					}
				}); 
				 return data;
			} 
			/* 更新备注*/
			var myKeypress = function(archivefileid,archivefileremark){
				$.ajax({
					url:"${pageContext.request.contextPath}/FilePackingBoxController/updateArchivefileremark",
					type:"post",
					async:false,
					data:{"archivefileid":archivefileid,"archivefileremark":archivefileremark},
					success:function(datas){
						data = datas;
					}
				});
				return data;
			}
		</script>
	</body>
</html>