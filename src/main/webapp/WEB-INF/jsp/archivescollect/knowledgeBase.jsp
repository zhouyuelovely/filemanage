<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>档案收集整理系统_知识库</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/knowledgeBase.css"/>
    	<style>
    		#edui1,#edui1_iframeholder{
			width:100%!important;
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
						<div class="log_t"><i class="fa fa-step-forward title_red"></i>
						<a href="#" class="title_red">档案整理</a>
						<span class="title_red">&gt;&gt;</span>
						<c:if test="${zm:buttenPremission('ad',sessionScope.user.role.authorities) }">
						<a href="${pageContext.request.contextPath}/knowledgeBase/goIdentification" class="title_red">鉴定分类</a>
						</c:if>
						<span class="title_red">&gt;&gt;</span><a href="#">知识库</a></div>
					 	<div id="bg" >
					 		<div id="" style="height: 40px;padding-left: 15px;padding-top: 15px;" >
					 			<h4  class="h4_title">请选择知识库类型</h4>
					 				<div class="layui-input-inline" style="padding-left:15%;width: 40%;">
					        			<input type="text" name="conditions" id="conditions" lay-verify="required|phone"  class="layui-input" placeholder="请输入关键字查询" style="text-align: center;" /> 
					     	 		</div>
					     			<button class="layui-btn layui-btn-normal" id="knowQueryCondition">查询</button>
					     	</div>
					     	
					     	<div class="layui-col-md2" style="">
					     		<ul class="nav_list">
					     			<li id="aa" value="国家标准">国家相关标准&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;》</li>
					     			<li id="bb" value="省级标准">省级相关标准&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;》</li>
					     			<li id="cc" value="市级标准">市级相关标准&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;》</li>
					     			<li id="dd" value="单位标准">单位相关标准&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;》</li>
					     		</ul>
					     	</div>
					     	<div class="layui-col-md10">
					     		 <div class="table_border">
					     		 	<div class="table_title" id="knowText"></div>
					 				<table class="layui-hide" id="demo" lay-filter="demo"></table>
					 				<div style="text-align: right;">
					 				<c:if test="${zm:buttenPremission('adj',sessionScope.user.role.authorities) }">
					 					<button class="layui-btn  layui-btn-danger add_repository">新增知识</button>
					 					</c:if>
					 				</div>
					 			</div>
					 			<script type="text/html" id="barDemo">
								    <a  href="#"  style="color: blue;" lay-event="detail">(点击进入)</a>
								</script>
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
		<!--富文本编辑器-->
		<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
		<script>
		
		layui.use('table', function() {
				var table = layui.table;
				var $ = layui.$;
				//展示已知数据
				table.render({
					elem: '#demo',
					url:"${pageContext.request.contextPath}/knowledgeBase/getKnowledgeBase"+"?timestamp="+Math.random(),
					method:'post',		
					cols: [
						[ //标题栏
							{
								field: 'knowledgeDocumentNum',
								title: '',
								width: 180,
								unresize:'false',
							},{
								field: 'knowledgeTitle',
								title: '',
								minwidth: 220,
								unresize:'false',
							},{
								field: 'right',
								title: '',
								width: 150,
								unresize:'false',
								toolbar: '#barDemo'
							}
						]
					],
					
						//,skin: 'line' //表格风格
						
					even: true,
					page: true//是否显示分页
					,limit:10   //默认十条数据一页  
				    ,limits:[10,20,30,50]  //数据分页条  
					,done: function(res, curr, count){
						    //如果是异步请求数据方式，res即为你接口返回的信息。
						    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
						    console.log(res);
						    
						    //得到当前页码
						    console.log(curr); 
						    
						    //得到数据总量
						    console.log(count);
						  }

				});
				 //监听工具条
				    
			  table.on('tool(demo)', function(obj){
			    var data = obj.data;
			    var tr = obj.tr;
			    var knowledgeId=obj.data.knowledgeId;
			    if(obj.event === 'detail'){
//				      layer.msg('ID：'+ data.id + ' 的查看操作');
						 
                    	  layer.open({
      						type: 1,
      						title:'<i class="fa fa-bars" style="padding:0 5px"></i>查看知识库',
      						area: ['800px', '550px'],
      						skin: 'add_label_bg',
      						offset: 'auto',
      						shade: [0.8, '#393D49'],
      						zIndex:999,
      						content:'<div style="padding: 15px;text-align: center;">'+
      						'<div class="layui-form-item"><label class="layui-form-label">文号</label>'+
      						'<div class="layui-input-block"><input type="text" name="knowledgeDocumentNum" id="knowledgeDocumentNum2" required="" lay-verify="required"  autocomplete="off" class="layui-input"></div></div>'+
      						'<div style="width:320px;float: left;"><label class="layui-form-label">知识类型</label>'+
      						'<select id="select2" name="KnowledgeType"><option value="">请选择</option><option value="国家标准">国家相关标准</option><option value="省级标准">省级相关标准</option><option value="市级标准">市级相关标准</option><option value="单位标准">单位相关标准</option></select></div>'+
      						'<div style="width:445px;float: left;"><label class="layui-form-label">发布日期</label>'+
      						'<div class="layui-input-block"><input type="text" name="knowledgeReleaDate" id="data_text2" required="" lay-verify="required"  autocomplete="off" class="layui-input"></div></div>'+
      						'<div class="layui-form-item" style="padding-top: 15px;"><label class="layui-form-label">标题</label>'+
      						'<div class="layui-input-block"><input type="text" name="knowledgeTitle" id="knowledgeTitle2" required="" lay-verify="required"  autocomplete="off" class="layui-input"></div></div>'+
      						'<div id="editor" style="width: 750px;padding-left:20px;"><textarea  id="container2" name="knowledgeContent" type="text/plain"/><button class="layui-btn btn_color" type="button" id="closeKnowBtn">关闭</button></div></div>',
      						
      						});
                         	    var editor = new baidu.editor.ui.Editor({initialFrameHeight:240,autoHeightEnabled: false,});
                            	editor.render('container2'); 
                            	
                    	  $.ajax({
            			    	url:"${pageContext.request.contextPath}/knowledgeBase/queryKnowledgeById"+"?timestamp="+Math.random(),
            			    	type:"post",
            			    	beforeSend :function(xmlHttp){ 
            				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
            				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
            				     },
  							dataType:"json",
  							data:{"knowledgeId":knowledgeId},
  							success:function(data){
  								console.log(data);
  								$("#knowledgeDocumentNum2").val(data.knowledgeDocumentNum);
  								$("#select2").val(data.knowledgeType);
  								$("#data_text2").val(data.knowledgeReleaDate);
  								$("#knowledgeTitle2").val(data.knowledgeTitle);
  								 editor.ready(function() { 
  									editor.setContent(data.knowledgeContent); 
									}); 
									
								
  							},
            			    	
            		});
                    	  //关闭按钮
                    	$("#closeKnowBtn").click(function(){
                    		layer.closeAll();
                    	})  
                    	  
				 }
			      
			  });
			});
		
			$(document).ready(function(){
				$(".add_repository").click(function(){ //#btn为按钮id
				layer.open({
				type: 1,
				title:'<i class="fa fa-bars" style="padding:0 5px"></i>新增知识',
				area: ['820px', '620px'],
				skin: 'add_label_bg',
				offset: 'auto',
				/* btn:'发布', */
				shade: [0.8, '#393D49'],
				scrollbar: true,
				zIndex:999,
				content: '<form id="knowForm" onsubmit="return false" method="post"><div style="padding: 15px;text-align: center;">'+
				'<div class="layui-form-item"><label class="layui-form-label">文号</label>'+
				'<div class="layui-input-block"><input type="text" name="knowledgeDocumentNum" id="knowledgeDocumentNum" required="" lay-verify="required" placeholder="请输入文号" autocomplete="off" class="layui-input"></div></div>'+
				'<div style="width:320px;float: left;"><label class="layui-form-label">知识类型</label>'+
				'<select id="select" name="KnowledgeType"><option value="">请选择</option><option value="国家标准">国家相关标准</option><option value="省级标准">省级相关标准</option><option value="市级标准">市级相关标准</option><option value="单位标准">单位相关标准</option></select></div>'+
				'<div style="width:445px;float: left;"><label class="layui-form-label">发布日期</label>'+
				'<div class="layui-input-block"><input type="text" name="knowledgeReleaDate" id="data_text" required="" lay-verify="required" placeholder="请输入发布日期" autocomplete="off" class="layui-input"></div></div>'+
				'<div class="layui-form-item" style="padding-top: 15px;"><label class="layui-form-label">标题</label>'+
				'<div class="layui-input-block"><input type="text" name="knowledgeTitle" id="knowledgeTitle" required="" lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"></div></div>'+
				'<div id="editor" style="width: 750px;padding-left:20px;"><div id="container" name="knowledgeContent"></div><button class="layui-btn btn_color" type="button" id="addKnowBtn">发布</button></div></div></form>',
				});
			    var editor = new baidu.editor.ui.Editor({initialFrameHeight:240,autoHeightEnabled: false,});
			    editor.render('container');
			    
			    $(function(){
			    	var date=new Date();
			    	var year=date.getFullYear(); //获取当前年份
			    	var mon=date.getMonth()+1; //获取当前月份
			    	var da=date.getDate(); //获取当前日
			    	var hours = date.getHours();//获取当前小时
			        var minutes = date.getMinutes();//获取当前分钟
			        var seconds = date.getSeconds();//获取当前秒数
			    	var mytime=year+"-"+mon+"-"+da +" "+ hours + ":" + minutes + ":" + seconds;
			    	$("#data_text").val(mytime);
			    })
			    
			    $("#addKnowBtn").click(function(){
			    	 var knowledgeDocumentNum=$("#knowledgeDocumentNum").val();
			    	 var KnowledgeType=$("#select").val();
			    	 var knowledgeReleaDate=$("#data_text").val();
			    	 var knowledgeTitle=$("#knowledgeTitle").val();
			    	 var knowledgeContent=UE.getEditor('container').getContent();
			    	 if($.trim(knowledgeDocumentNum)==""||$.trim(knowledgeDocumentNum)==null){
			    		 layer.msg("文号不能为空!");
			    	 }else if(KnowledgeType==""||KnowledgeType==null){
			    		 layer.msg("请选择知识类型!");
			    	 }else if(knowledgeReleaDate==""||knowledgeReleaDate==null){
			    		 layer.msg("请选择发布日期!");
			    	 }else if($.trim(knowledgeTitle)==""||$.trim(knowledgeTitle)==null){
			    		 layer.msg("请填写标题!");
			    	 }else if($.trim(knowledgeContent)==""||$.trim(knowledgeContent)==null){
			    		 layer.msg("请输入发布内容!");
			    	 }else if(knowledgeDocumentNum>0){
			    		 layer.msg("文号已存在!");
			    	 }else{
			    		 $.ajax({
			    			 url:"${pageContext.request.contextPath}/knowledgeBase/addKnowledgeBase"+"?timestamp="+Math.random(),
			    			 type:"post",
			    			 beforeSend :function(xmlHttp){ 
         				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
         				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
         				     },
							 dataType:"text",
							 async:false,
							 data:$("#knowForm").serialize(),
							 success:function(result){
								 if(result==1){
									 layer.msg("文号已存在!");
								 }else if(result==2){
									 layer.msg("知识内容已发布成功",{offset:'auto',time:1500},function(){
										 location.reload();
									}) 
 
								 }else{
									 layer.msg("知识内容发布失败");
								 }
							 }
			    			 
			    		 });
			    	 }
			    	
			    });
			   
 
			});
		});
				 
  			   
            
		</script>
		  <script type="text/javascript">
					     	   //关键词查询知识库
					     	   $().ready(function(){
					     		 
					     		  var table = layui.table;
					     		   var $ = layui.$;
					     		   $("#knowQueryCondition").click(function(){
					     			  var conditions=$("#conditions").val();
					     				table.reload('demo', {
					     					  url:'/filemanage/knowledgeBase/queryKnowByConditions'+"?timestamp="+Math.random(),
					     					  method:'post',	  
					     					  where: { //设定异步数据接口的额外参数，任意设
					     						  conditions: conditions,
					     					  }
					     					  ,page: {
					     					    curr: 1 //重新从第 1 页开始
					     					  }
					     					});
					     				console.log(conditions);
					     			   
					     		   });
					     		   $("#aa").click(function(){
					     			   var aas=$('#aa').attr("value"); 
					     			   console.log(aas);
					     			   table.reload('demo', {
				     					  url:'/filemanage/knowledgeBase/queryKnowByType'+"?timestamp="+Math.random(),
				     					  method:'post',		  
				     					  where: { //设定异步数据接口的额外参数，任意设
				     						 KnowledgeType: aas,
				     					  }
				     					  ,page: {
				     					    curr: 1 //重新从第 1 页开始
				     					  }
				     					});
					     			   $("#knowText").text('国家相关标准');
					     		   });
					     		   
					     		    $("#bb").click(function(){
					     			   var bbs=$('#bb').attr("value");
					     			  console.log(bbs);
					     			 table.reload('demo', {
				     					  url:'/filemanage/knowledgeBase/queryKnowByType'+"?timestamp="+Math.random(),
				     					  method:'post',	  
				     					  where: { //设定异步数据接口的额外参数，任意设
				     						 KnowledgeType: bbs,
				     					  }
				     					  ,page: {
				     					    curr: 1 //重新从第 1 页开始
				     					  }
				     					});
					     			   $("#knowText").text('省级相关标准');
					     		   });
					     		    
					     		   $("#cc").click(function(){
					     			   var ccs=$('#cc').attr("value");
					     			  console.log(ccs);
					     			 table.reload('demo', {
				     					  url:'/filemanage/knowledgeBase/queryKnowByType'+"?timestamp="+Math.random(),
				     					  method:'post',	  
				     					  where: { //设定异步数据接口的额外参数，任意设
				     						 KnowledgeType: ccs,
				     					  }
				     					  ,page: {
				     					    curr: 1 //重新从第 1 页开始
				     					  }
				     					});
					     			   $("#knowText").text('市级相关标准');
					     		   });
					     		   
					     		  $("#dd").click(function(){
					     			   var dds=$('#dd').attr("value");
					     			   console.log(dds);
					     			  table.reload('demo', {
				     					  url:'/filemanage/knowledgeBase/queryKnowByType'+"?timestamp="+Math.random(),
				     					  method:'post',	  
				     					  where: { //设定异步数据接口的额外参数，任意设
				     						 KnowledgeType: dds,
				     					  }
				     					  ,page: {
				     					    curr: 1 //重新从第 1 页开始
				     					  }
				     					});
					     			   $("#knowText").text('单位相关标准');
					     		   });
					     		  
					     		 
					     	   });
					     	   
		 </script>
	</body>
</html>