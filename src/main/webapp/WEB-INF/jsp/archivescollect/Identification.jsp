<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
<%
  String app_url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%
	response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
	response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 
	response.setHeader("Pragma","No-cache"); 
	response.setDateHeader("Expires", 0);
%>
<%   
  if(request.getProtocol().compareTo("HTTP/1.0")==0)   
        response.setHeader("Pragma","no-cache");   
  else   if(request.getProtocol().compareTo("HTTP/1.1")==0)   
        response.setHeader("Cache-Control","no-cache");   
  response.setDateHeader("Expires",0);   
%>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="pragma" content="no-cache"> 
     	<meta http-equiv="cache-control" content="no-cache"> 
    	<meta http-equiv="expires" content="0"> 
		<title>档案收集整理系统_档案整理_鉴定分类</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--图片拖拽插件-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.gridly.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css" />
		<!-- 图片预览 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css">
		<!--翻书插件-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.booklet.latest.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Identification.css"/>
		
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
				<div class="layui-body" id="filebody" style="top:140px;left: 0;">
					<div class="layui-row">
						
						<div class="layui-inline" style="padding-top: 10px;padding-left:10px;width: 100%;">
							<div style="text-align: center;">
								<a href="#"><button class="btn-a">鉴定分类</button></a>
								<c:if test="${zm:buttenPremission('ae',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/FilePackingBoxController/modelAndView">
								
								<button class="btn-b">文件装盒</button></a>
								</c:if>
							</div>
							<div style="padding:15px;background: #FFFFFF;font-size: 16px;font-weight: bold;">
								<i class="fa fa-step-forward font_color" style="color: #EA5519;margin: 0 10px;"></i>鉴定分类
							</div>
							<div id="" style="padding-left: 20px;padding-top: 15px;">
							     <c:forEach items="${userList}" var="user">
								<label for="" >
									<i class="fa fa-circle" style="color: #EA5519;">${user.quanzongName}</i>
									<input id="quanzongIDNew" value="${user.quanzongId}" hidden="hidden"/>
								</label>
								
								<select name="archiveFileAnual" onchange="queryImgByAnual2()" id="archivefileanual" >
									<option value="" class="layui-input inline">请选择</option>
									<c:forEach items="${listFileByAnnual}" var="annual">
									<option value="${annual.archiveFileAnual}">${annual.archiveFileAnual}</option>
									</c:forEach>
								</select>
								<label for="" class="lab">档案类型</label>
								<select name="primaryClassFication" onchange="selectVal()" id="select1" >
									<option value="" >请选择</option>
									<c:forEach items="${primaryClassList}" var="pc">
									<option value="${pc.pcId}" >${pc.pcName}</option>
									</c:forEach>
								</select>
								<label for="" class="lab">机构/问题</label>
								<select name="secondryClassFication" id="onetype" onchange="queryScByPcIdAndStatus()" >
									<option value=""  >请选择</option>
									<option value="1" >问题分类</option>
									<option value="0" >机构分类</option>
								</select>
								</c:forEach>
							</div>
						</div>
						
						<div class="layui-col-sm12 layui-col-md5">
							 <input type="hidden" id="file" value="1"/>
							<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief" style="background: #FFFFFF;margin-left: 15px;padding-top: 15px;">
								<ul class="layui-tab-title">
									<li class="layui-this" onclick="queryImgByAnual()">全部文件</li>
									<li onclick="queryFileByAnualAndStatus()">待整理文件</li>
									<li onclick="queryFileByAnualAndStatus2()">回收站</li>
								</ul>
								<div class="layui-tab-content">
									<div class="layui-tab-item layui-show" id="quanbufilediv">
										<!--全部文件缩略图显示-->
										<ul class="nav_imgs" id="allul">
											
										</ul>
										 <div style="padding:15px;margin-top:30px;text-align:center;clear: both;">
											<span>共<span id="allfile"></span>件</span>
											 <span id="showSubscript">
											<span>第<select name="" id="pageNum" onchange="chang()">
	                           			<c:forEach begin="1" end="${requestScope.pagemsg.totalPage}" varStatus="status">
											<option value="${status.count}" <c:if test="${status.count eq requestScope.pagemsg.currPage}">selected</c:if>>${status.count}</option>
										</c:forEach>
	                       			</select>页
		                  			</span>
											<span>共<span id="totalPage">${requestScope.pagemsg.totalPage}</span>页</span>
											    <c:if test="${requestScope.pagemsg.currPage != 1}">
											    <span class="layui-btn layui-btn-xs" onclick="page('${requestScope.pagemsg.currPage-1}')">上一页</span>
                                              </c:if>
                                              <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
											<span class="layui-btn layui-btn-xs" onclick="page('${requestScope.pagemsg.currPage+1}')">下一页</span>
			                                  </c:if>
											</span>
										</div>
									</div>
									<div class="layui-tab-item">
										<!--待整理文件缩略图-->
										<ul class="nav_imgs" id="ul1">
										</ul>
										<div style="padding:15px;margin-top:30px;text-align:center;clear: both;">
											<span>共<span id="todofile"></span>件</span>
											<span id="showSubscript2">
											<span>
	                  			           第<select name="" id="pageNum2" onchange="chang2()">
	                           			<c:forEach begin="1" end="${requestScope.pagemsg2.totalPage}" varStatus="status">
											<option value="${status.count}" <c:if test="${status.count eq requestScope.pagemsg2.currPage}">selected</c:if>>${status.count}</option>
										</c:forEach>
	                       			</select>页
		                  			</span>
											<span>共<span id="totalPage2">${requestScope.pagemsg2.totalPage}</span>页</span>
											 <c:if test="${requestScope.pagemsg2.currPage != 1}">
											    <span class="layui-btn layui-btn-xs" onclick="page2('${requestScope.pagemsg2.currPage-1}')">上一页</span>
											</c:if>
											<c:if test="${requestScope.pagemsg2.currPage != requestScope.pagemsg2.totalPage}">				
											<span class="layui-btn layui-btn-xs" onclick="page2('${requestScope.pagemsg2.currPage+1}')">下一页</span>
										   </c:if>
											</span>
										</div>
									</div>
									<div class="layui-tab-item">
										<!--回收站文件缩略图-->
										<ul class="nav_imgs" id="ul2">
										</ul>
										<div style="padding:15px;margin-top:30px;text-align:center;clear: both;">
											<span>共<span id="revserfile"></span>件</span>
											<span id="showSubscript3">
											<span>
	                  			           第<select name="" id="pageNum3" onchange="chang3()">
	                           			<c:forEach begin="1" end="${requestScope.pagemsg3.totalPage}" varStatus="status">
											<option value="${status.count}" <c:if test="${status.count eq requestScope.pagemsg3.currPage}">selected</c:if>>${status.count}</option>
										</c:forEach>
	                       			</select>页
		                  			</span>
											<span>共<span id="totalPage3">${requestScope.pagemsg3.totalPage}</span>页</span>
											  <c:if test="${requestScope.pagemsg3.currPage != 1}">
											    <span class="layui-btn layui-btn-xs" onclick="page3('${requestScope.pagemsg3.currPage-1}')">上一页</span>
											</c:if>
											<c:if test="${requestScope.pagemsg3.currPage != requestScope.pagemsg3.totalPage}">
											<span class="layui-btn layui-btn-xs" onclick="page3('${requestScope.pagemsg3.currPage+1}')">下一页</span>
											</c:if>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="layui-col-sm12 layui-col-md7">
							<div id="look_books">
								<div class="book">
								      <input type="hidden" id="coverPath" value="">
										<div id="mybook">
										    
										</div>
										      
										   <div style="text-align: center;cursor: pointer;"  id="foo">
										     </div>
										<button id="custom-prev" class="zuo"><i class="fa fa-chevron-left"></i></button>
										<button id="custom-next" class="you"><i class="fa fa-chevron-right"></i></button>
								 </div>
							</div>
						    
							<div class="list_nav">
									<label for="" class="b_list">保管期限</label>
									  <c:forEach items="${retentionPeriodList}" var="rp">
									  <input type="radio" name="retentionperiodid"  value="${rp.retentionperiodid}" />
									   <label for="">${rp.retentionperiodname}</label>
									</c:forEach> 
									
									
									
							</div>
							<div class="list_nav">
									<label for="" class="b_list">密级</label>
									<input type="radio" name="afSecurityClassrification"  value="绝密" />
									<label for="">绝密</label>
									<input type="radio" name="afSecurityClassrification"  value="机密" />
									<label for="">机密</label>
									<input type="radio" name="afSecurityClassrification"  value="秘密" />
									<label for="">秘密</label>
									<input type="radio" name="afSecurityClassrification"  value="公开" />
									<label for="">公开</label>
							</div>
							<div class="list_nav" id="aa">
								<label for="" class="b_list"  id="scChange"></label>	
							</div>

							<div style="text-align:center;margin-right: 50px;">
							     <input type="hidden" id="tang" value="">
							     <input type="hidden" id="shangyijian" value="">
							     <c:if test="${zm:buttenPremission('add',sessionScope.user.role.authorities) }">
								<button class="layui-btn layui-btn-primary" onclick="queryFileByOutline()">返回上一件</button>
								</c:if>
								<c:if test="${zm:buttenPremission('ade',sessionScope.user.role.authorities) }">
								<button class="layui-btn" onclick="saveFileBtn()" id="saveBtn">保存</button>
								</c:if>
							</div>
							<div class="yb_conct" style="right:-125px">
							  <div class="yb_bar">
							    <ul>
							      <li class="yb_top">
							      	<div class="div_sc">
							      	<c:if test="${zm:buttenPremission('adf',sessionScope.user.role.authorities) }">
							      		<a href="${pageContext.request.contextPath}/knowledgeBase/goKnowledgeBase" >
							      		<img src="${pageContext.request.contextPath}/imgs/zhishiku.png" /><p>知识库</p></a>
									</c:if>
							      	</div>
							      </li>
							      <li class="yb_phone" id="bar">
							      	<div class="div_sc">
							      		<a href="#"><p><span class="bor-r" id="daizhengli"></span></p><img src="${pageContext.request.contextPath}/imgs/daizhengli.png" style="padding-top:0px;"/><p>待整理文件</p></a>
							     	 </div>
							      </li>
							      <li class="yb_QQ" id="barTwo">
							      	<div class="div_sc">
							      		<a href="#"><p><span class="bor-r" id="huishou"></span></p><img src="${pageContext.request.contextPath}/imgs/huishou.png"  style="padding-top:0px;"/><p>回收站 </p></a>
							      	</div>
							      	</li>
							    </ul>
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
		<script src="${pageContext.request.contextPath}/js/Sortable.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!-- 图片预览插件 -->
		<script src="${pageContext.request.contextPath}/js/viewer.min.js"></script>
		<!--翻书效果-->
		<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.booklet.latest.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.gridly.js" ></script>
		<script src="${pageContext.request.contextPath}/js/app.js" ></script>
		<script src="${pageContext.request.contextPath}/js/pageBean.js" ></script>
		<script>
		var quanzongIDNew = $("#quanzongIDNew").val();
			//注意：选项卡 依赖 element 模块，否则无法进行功能性操作 
			layui.use('element', function() {
				var element = layui.element;
				element.render();
			});
			
				 //监听一级分类onchange事件
			function selectVal(){
				var con=$("#select1  option:selected").text();
				var sel=$("#onetype").val();
				var val=$("#select1  option:selected").val();
				if(con!="文书档案"){
					$("#onetype").html("");
					$("#onetype").html("<option value='1'>问题分类</option>"); 
					queryStr();
				}else if(con=="文书档案"){
					$("#scChange").text("");
					$("#onetype").html("");
					$("#onetype").html("<option value=''>请选择</option><option value='1'>问题分类</option><option value='0'>机构分类</option>");
					if(sel==1){
						$.ajax({
							url:"${pageContext.request.contextPath}/classfication/queryScByIdAndStatus"+"?timestamp="+Math.random(),
							type:"post",
							beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
							dataType:"json",
							cache:false,
							data:{"pcId":val,"scStatus":1,"quanzongid":quanzongIDNew},
							success:function(data){
								$("#scChange").html("问题");
								if($("#aa")[0].children.length >1){
									$("input").remove(".scName");
									$("label").remove(".lascName");
									for(var i=0;i<data.length;i++){
										var str="<input type='radio' class='scName' name='scName'  value='"+data[i].scId+"' />"+
											    "<label class='lascName' for=''>"+data[i].scName+"</label>";
										$("#aa").append(str); 
									}
								}else{
									$("input").remove(".scName");
									$("label").remove(".lascName");
									for(var i=0;i<data.length;i++){
										var str="<input type='radio' class='scName' name='scName'  value='"+data[i].scId+"' />"+
											    "<label for='' class='lascName'>"+data[i].scName+"</label>";
										$("#aa").append(str); 
									}
								}
								
							},
						})
					}else if(sel==2){
						$.ajax({
							url:"${pageContext.request.contextPath}/classfication/queryScByOrg"+"?timestamp="+Math.random(),
							type:"post",
							beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
						    data:{"quanzongid":quanzongIDNew},
							dataType:"json",
							cache:false,
							success:function(data){
								
								$("#scChange").text("机构");
								if($("#aa")[0].children.length >1){
									$("input").remove(".scName");
									$("label").remove(".lascName");
									for(var i=0;i<data.length;i++){
										for (var j = 0; j < data[i].twos.length; j++) {
											var str="<input type='radio' class='scName' name='scName'  value='"+data[i].twos[j].scId+"'/>"+
										    "<label class='lascName' for=''>"+data[i].twos[j].scName+"</label>";
											$("#aa").append(str); 
										}
									}
								}else{
									$("input").remove(".scName");
									$("label").remove(".lascName");
									for(var i=0;i<data.length;i++){
										for (var j = 0; j < data[i].twos.length; j++) {
											var str="<input type='radio' class='scName' name='scName'  value='"+data[i].twos[j].scId+"' />"+
										    "<label class='lascName' for=''>"+data[i].twos[j].scName+"</label>";
											$("#aa").append(str); 
										}
									}
								}
								
							},
						})
					}

				}else if(con=="文书档案"&& sel==0){
					$("#onetype").html("");
					$("#onetype").html("<option value='0'>机构分类</option>");
				}
				
			}
			
			//根据一级分类主键查询二级分类
			function queryStr(){
				var val=$("#select1  option:selected").val();
				$.ajax({
					url:"${pageContext.request.contextPath}/classfication/queryScByPcId"+"?timestamp="+Math.random(),
					type:"post",
					beforeSend :function(xmlHttp){ 
				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
				     },
					dataType:"json",
					cache:false,
					data:{"pcId":val},
					success:function(data){
					  $("#scChange").text("问题");
							if($("#aa")[0].children.length >1){
								$("input").remove(".scName");
								$("label").remove(".lascName");
								for(var i=0;i<data.length;i++){
									var str="<input type='radio' class='scName' name='scName'  value='"+data[i].scId+"' />"+
										    "<label class='lascName' for=''>"+data[i].scName+"</label>";
									$("#aa").append(str); 
								}
							}else{
								$("input").remove(".scName");
								$("label").remove(".lascName");
								for(var i=0;i<data.length;i++){
									var str="<input type='radio' class='scName' name='scName'  value='"+data[i].scId+"' />"+
										    "<label for='' class='lascName'>"+data[i].scName+"</label>";
									$("#aa").append(str); 
								}
							}
					},
				})
			}
			//二级分类onchange事件111
			function queryScByPcIdAndStatus(){
				var sel=$("#onetype").val();
				var val=$("#select1  option:selected").val();
				if(sel==1){
					$.ajax({
						url:"${pageContext.request.contextPath}/classfication/queryScByIdAndStatus"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						dataType:"json",
						cache:false,
						data:{"pcId":val,"scStatus":1,"quanzongid":quanzongIDNew},
						success:function(data){
							$("#scChange").text("问题");
							if($("#aa")[0].children.length >1){
								$("input").remove(".scName");
								$("label").remove(".lascName");
								for(var i=0;i<data.length;i++){
									var str="<input type='radio' class='scName' name='scName'  value='"+data[i].scId+"' />"+
										    "<label class='lascName' for=''>"+data[i].scName+"</label>";
									$("#aa").append(str); 
								}
							}else{
								$("input").remove(".scName");
								$("label").remove(".lascName");
								for(var i=0;i<data.length;i++){
									var str="<input type='radio' class='scName' name='scName'  value='"+data[i].scId+"' />"+
										    "<label for='' class='lascName'>"+data[i].scName+"</label>";
									$("#aa").append(str); 
								}
							}
							
						},
					})
				}else if(sel==0){
					$.ajax({
						url:"${pageContext.request.contextPath}/classfication/queryScByOrg"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
					    data:{"quanzongid":quanzongIDNew},
						dataType:"json",
						cache:false,
						success:function(data){
							$("#scChange").text("机构");
							if($("#aa")[0].children.length >1){
								$("input").remove(".scName");
								$("label").remove(".lascName");
								for(var i=0;i<data.length;i++){
									for (var j = 0; j < data[i].twos.length; j++) {
										console.log(data[i].twos[j].scId);
										console.log(data[i].twos[j].scName);
										var str="<input type='radio' class='scName' name='scName'  value='"+data[i].twos[j].scId+"' />"+
									    "<label class='lascName' for=''>"+data[i].twos[j].scName+"</label>";
										$("#aa").append(str); 
									}
								}
							}else{
								$("input").remove(".scName");
								$("label").remove(".lascName");
								for(var i=0;i<data.length;i++){
									for (var j = 0; j < data[i].twos.length; j++) {
										var str="<input type='radio' class='scName' name='scName'  value='"+data[i].twos[j].scId+"' />"+
									    "<label class='lascName' for=''>"+data[i].twos[j].scName+"</label>";
										$("#aa").append(str); 
									}
								}
							}
							
						},
					})
				}
				
			}
			
			 //翻书效果
			function mybookshow(){
			    //single book
			    $('#mybook').booklet({
			        next: '#custom-next',
			        prev: '#custom-prev',
			        //自定义宽高
			        width:  400,
       				height: 280,
       				speed: 800,
       				//每一页padding
       				pagePadding: 0,
       				//页码是否开启
    				pageNumbers: false,
    				//是否允许鼠标点击page翻页
			    	manual: false,
			    	//内置箭头翻页
			    	arrows: false,
			    	//键盘左右翻页是否开启
			    	keyboard:false,
			    });
			     //图片视图
			    $('#mybook').viewer({
      		      
       		 	}).viewer('update')
			   
			}
 
			$(function() {
				// 悬浮窗口
				var falg=false
				$(".yb_phone").click(function() {
					if(falg){
						$(".yb_conct").css("right", "-125px");
					     $(".yb_bar .yb_ercode").css('height', '200px');
					    falg=false
					}else{
						$(".yb_conct").css("right", "5px");
						$(".yb_bar .yb_ercode").css('height', '53px');
					    falg=true
					}
				});
			});
			
			    var currentPage = 1;
			    var totalPage=null; 
			   function page(currentPage){
				   common_getPicFileList(currentPage);
				   
				   setTimeout("queryImgList()","500");
			   }
			   
			   function page2(currentPage){
				   common_getPicFileList2(currentPage);
				   setTimeout("queryImgList()","500");
			   }
			   
			   function page3(currentPage){
				   common_getPicFileList3(currentPage);
				   setTimeout("queryImgList()","500");
			   }

				//改变下拉框
				function chang(){
					var currentPage=$("#pageNum").val();
					common_getPicFileList(currentPage);
				};
				//改变下拉框
				function chang2(){
					var currentPage=$("#pageNum2").val();
					common_getPicFileList2(currentPage);
				};
				//改变下拉框
				function chang3(){
					var currentPage=$("#pageNum3").val();
					common_getPicFileList3(currentPage);
				};
				
				
				//统计图片数量
				function countImg(){
					var anual=$("#archivefileanual").val();
					var quanzongId=new String('${user.quanzongId}');
					$.ajax({
						url:"${pageContext.request.contextPath}/knowledgeBase/countImg"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						cache:false,
						dataType:"text",
						data:{"fileAttachmentAnual":anual,"archiveFileAuthenticateStatus":1,"quanzongId":quanzongId,"archiveFileFinishingStatus":2},
						success:function(data){
							document.getElementById("allfile").innerText=data;
						},
						
					});
				}
				//统计图片数量
				function countImg2(){
					var anual=$("#archivefileanual").val();
					var quanzongId=new String('${user.quanzongId}');
					$.ajax({
						url:"${pageContext.request.contextPath}/knowledgeBase/countImg"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						cache:false,
						dataType:"text",
						data:{"fileAttachmentAnual":anual,"archiveFileAuthenticateStatus":2,"quanzongId":quanzongId,"archiveFileFinishingStatus":2},
						success:function(data){
							document.getElementById("todofile").innerText=data;
						},
						
					});
				}
				//统计图片数量
				function countImg3(){
					var anual=$("#archivefileanual").val();
					var quanzongId=new String('${user.quanzongId}');
					$.ajax({
						url:"${pageContext.request.contextPath}/knowledgeBase/countImg"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						cache:false,
						dataType:"text",
						data:{"fileAttachmentAnual":anual,"archiveFileAuthenticateStatus":3,"quanzongId":quanzongId,"archiveFileFinishingStatus":3},
						success:function(data){
							document.getElementById("revserfile").innerText=data;
						},
						
					});
				}
				// 获取图片的存储路径集合 
				function  common_getPicFileList(currentPage){
					var anual=$("#archivefileanual").val();
					var quanzongId=new String('${user.quanzongId}');
					if(anual==""){
						layer.msg("请选择年度");
						return;
					}else{
						 $.ajax({
								url : "${pageContext.request.contextPath}/knowledgeBase/queryImgList"+"?timestamp="+Math.random(),
								type : "post",
								beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
								cache:false,
								data : {"archiveFileAuthenticateStatus":1,"fileAttachmentAnual":anual,"quanzongId":quanzongId,"archiveFileFinishingStatus":2,"currentPage":currentPage},
								success : function(code) {
									var result = code.lists;
									var ids = new Array();
									if(result.length>0){
										for (var i = 0; i < result.length; i++) {
											var id=result[0].archiveFileId;
											ids.push(result[i].archiveFileId );
										}
										$("#tang").val(id);
											//获取到的图片数组处理逻辑方法
											$("#allul").empty();
											 $("#foo").empty();
										     $("#foo").append("<span><input  type='hidden' value='"+id+"'>NO.1</span>");	
										for (var i = 0; i <result.length; i++) {
											$("#allul")
											  .append("<li class='li'>"
													 +"<img src="+'<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'
												+""+result[i].fileAttachmentPath+"?"+Math.random()+" id="+result[i].fileAttachmentPath+"><p onclick='showImgList(\""+result[i].archiveFileId+"\",\""+event+"\")'>NO."+(code.pageSize * (code.currPage - 1) + i+ 1)+"</p></li>")
												
											}
										$("#showSubscript").empty();
					    				var indexBox="";
					    				if(code.currPage!=1){
					    					indexBox=indexBox+"<span class='layui-btn layui-btn-xs' onclick='page("+(code.currPage-1)+")'>上一页</span>&nbsp;&nbsp;"
					    				}
					    				indexBox=indexBox+"<select onchange='chang()' id='pageNum'>"
					    				if(code.totalPage==0){
					    					indexBox=indexBox+"<option value='1'>+i+</option>"
					    				}else{
					    					for(var i=1;i<=code.totalPage;i++){
					    						indexBox=indexBox+"<option value='"+i+"' "
					    						if(i==code.currPage){
					    							indexBox=indexBox+"selected"
					    						}
					    						indexBox=indexBox+">"+i+"</option>"
					    					}
					    				}
					    					
					    				indexBox=indexBox+"</select>"
					    				if(code.currPage!=code.totalPage&&code.totalPage!=0){
					    					indexBox=indexBox+"<span class='layui-btn layui-btn-xs' onclick='page("+(code.currPage+1)+")'>下一页</span>&nbsp;&nbsp;"
					    					
					    				}
					    				    $("#showSubscript").append(indexBox);	

										countImg();
									
									}else{	
										queryFileByAnual();

									}	
								},
								error : function(e) {
									console.log("获取文件list数组失败，请检查接口服务");
						
								}
							});
						}
					  
				    }
				
				 function queryFileByAnual(){
					 var anual=$("#archivefileanual").val();
					 $.ajax({
						 url:"${pageContext.request.contextPath}/knowledgeBase/queryFileByAnual"+"?timestamp="+Math.random(),
						 type : "post",
						  beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
							cache:false,
							data:{"archiveFileAnual":anual},
							success:function(result){
								 if(result==1){
									layer.msg("本年度文件还没有全部整理完成");
								}else if(result==2){
									 layer.msg("本年度全部文件已整理完毕!",{offset:'auto',time:5000},function(){
										  location.reload();
									})  
								}
							},
					 });
				 }
				
				// 获取图片的存储路径集合 
				function common_getPicFileList2(currentPage) {
					var anual=$("#archivefileanual").val();
					var quanzongId=new String('${user.quanzongId}');
					if(anual==""){
						layer.msg("请选择年度");
						return;
					}else{
						$.ajax({
							url : "${pageContext.request.contextPath}/knowledgeBase/queryImgList"+"?timestamp="+Math.random(),
							type : "post",
							beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
							cache:false,
							data : {"archiveFileAuthenticateStatus":2,"fileAttachmentAnual":anual,"quanzongId":quanzongId,"archiveFileFinishingStatus":2,"currentPage":currentPage},
							success : function(data) {
								var result = data.lists;
								if(result.length>0){
									var id=result[0].archiveFileId;
									 $("#tang").val(id);
										 $("#foo").empty();
										 $("#foo").append("<span><input  type='hidden' value='"+id+"'>NO."+(data.pageSize * (data.currPage - 1) + 1)+"</span>");
										$("#ul1").empty();
										for (var i = 0; i < result.length; i++) {
											$("#ul1")
											  .append("<li class='li daizhengli'>"
													 +"<img src="+'<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'
												+""+result[i].fileAttachmentPath+"?"+Math.random()+" id="+result[i].fileAttachmentPath+"><p onclick='showImgList(\""+result[i].archiveFileId+"\",\""+event+"\")'>NO."+(data.pageSize * (data.currPage - 1) + i+ 1)+"</p></li>")
										}
									
									$("#showSubscript2").empty();
				    				var indexBox="";
				    				if(data.currPage!=1){
				    					indexBox=indexBox+"<span class='layui-btn layui-btn-xs' onclick='page2("+(data.currPage-1)+")'>上一页</span>&nbsp;&nbsp;"
				    				}
				    				
				    				indexBox=indexBox+"<select onchange='chang2()' id='pageNum2'>"
				    				if(data.totalPage==0){
				    					indexBox=indexBox+"<option value='1'>+i+</option>"
				    				}else{
				    					for(var i=1;i<=data.totalPage;i++){
				    						indexBox=indexBox+"<option value='"+i+"' "
				    						if(i==data.currPage){
				    							indexBox=indexBox+"selected"
				    						}
				    						indexBox=indexBox+">"+i+"</option>"
				    					}
				    				}
				    					
				    				indexBox=indexBox+"</select>"
				    				if(data.currPage!=data.totalPage&&data.totalPage!=0){
				    					indexBox=indexBox+"<span class='layui-btn layui-btn-xs' onclick='page2("+(data.currPage+1)+")'>下一页</span>&nbsp;&nbsp;"
				    				}
				    				$("#showSubscript2").append(indexBox);	
				    				countImg2();
								}else{
	                                 layer.msg("本年度无待整理文件!",{offset:'auto',time:1500},function(){
	                                	 $("#mybook").empty();
	                                	 $("#foo").empty();
	                                	//属性区域置空,单选框重置
	     								$('input:radio[name=retentionperiodid]').attr('checked',false);
	     								$('input:radio[name=afSecurityClassrification]').attr('checked',false);
	     								$('input:radio[name=scName]').attr('checked',false);
									})
									
								}
								
							},
							error : function(e) {
								console.log("获取文件list数组失败，请检查接口服务");
					
							}
						});
					}
					 

				}
				// 获取图片的存储路径集合 
				function common_getPicFileList3(currentPage) {
					var anual=$("#archivefileanual").val();
					var quanzongId=new String('${user.quanzongId}');
					if(anual==""){
						layer.msg("请选择年度");
						return;
					}else{
						$.ajax({
							url : "${pageContext.request.contextPath}/knowledgeBase/queryImgList"+"?timestamp="+Math.random(),
							type : "post",
							beforeSend :function(xmlHttp){ 
						        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
						     },
						    cache:false,
							data : {"archiveFileAuthenticateStatus":3,"fileAttachmentAnual":anual,"quanzongId":quanzongId,"archiveFileFinishingStatus":3,"currentPage":currentPage},
							success : function(data) {
								var result = data.lists;
								if(result.length>0){
									var id=result[0].archiveFileId;
									 $("#tang").val(id);
										 $("#foo").empty();
										 $("#foo").append("<span><input  type='hidden' value='"+id+"'>NO."+(data.pageSize * (data.currPage - 1) + 1)+"</span>");
										//获取到的图片数组处理逻辑方法
										$("#ul2").empty();
								for (var i = 0; i < result.length; i++) {
									$("#ul2")
									  .append("<li class='li' huishoufile>"
											 +"<img src="+'<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'
										+""+result[i].fileAttachmentPath+"?"+Math.random()+" id="+result[i].fileAttachmentPath+"><p onclick='showImgList(\""+result[i].archiveFileId+"\",\""+event+"\")'>NO."+(data.pageSize * (data.currPage - 1) + i+ 1)+"</p></li>")
								}
									
									$("#showSubscript3").empty();
				    				var indexBox="";
				    				if(data.currPage!=1){
				    					indexBox=indexBox+"<span class='layui-btn layui-btn-xs' onclick='page3("+(data.currPage-1)+")'>上一页</span>&nbsp;&nbsp;"
				    				}
				    				indexBox=indexBox+"<select onchange='chang3()' id='pageNum3'>"
				    				if(data.totalPage==0){
				    					indexBox=indexBox+"<option value='1'>+i+</option>"
				    				}else{
				    					for(var i=1;i<=data.totalPage;i++){
				    						indexBox=indexBox+"<option value='"+i+"' "
				    						if(i==data.currPage){
				    							indexBox=indexBox+"selected"
				    						}
				    						indexBox=indexBox+">"+i+"</option>"
				    					}
				    				}
				    					
				    				indexBox=indexBox+"</select>"
				    				if(data.currPage!=data.totalPage&&data.totalPage!=0){
				    					indexBox=indexBox+"<span class='layui-btn layui-btn-xs' onclick='page3("+(data.currPage+1)+")'>下一页</span>&nbsp;&nbsp;"
				    				}
				    				$("#showSubscript3").append(indexBox);	
				    				countImg3();
								}else{
									 
									 layer.msg("本年度无回收站文件!",{offset:'auto',time:1500},function(){
										 $("#mybook").empty();
	                                	 $("#foo").empty();
	                                	//属性区域置空,单选框重置
	     								$('input:radio[name=retentionperiodid]').attr('checked',false);
	     								$('input:radio[name=afSecurityClassrification]').attr('checked',false);
	     								$('input:radio[name=scName]').attr('checked',false);	
									 }) ;
									
								}
							},
							error : function(e) {
								console.log("获取文件list数组失败，请检查接口服务");
			    				
					         }
						});
				   }
					 
				
		      }		
				//全部文件图片路径集合展示
				function queryImgByAnual(){
					var currentPage=$("#pageNum").val();
					var anual=$("#archivefileanual").val();
					$("#file").val("1");
					if(anual==""){
						layer.msg("请选择年度");
						return;
					}else{
						 common_getPicFileList(currentPage);
						 setTimeout("queryImgList()","500"); 
					}
					
				}
				//根据年度和全宗统计待整理文件个数
				function countByStatus2(){
					 var anual=$("#archivefileanual").val();
					  var quanzongId=new String('${user.quanzongId}');
					$.ajax({
						url:"${pageContext.request.contextPath}/knowledgeBase/countImg"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						cache:false,
						dataType:"text",
						data:{"fileAttachmentAnual":anual,"archiveFileAuthenticateStatus":2,"quanzongId":quanzongId,"archiveFileFinishingStatus":2},
						success:function(data){
							$("#daizhengli").text(data);
						},	
					});
				}
				//根据年度和全宗统计回收文件个数
				function countByStatus3(){
					 var anual=$("#archivefileanual").val();
					  var quanzongId=new String('${user.quanzongId}');
					$.ajax({
						url:"${pageContext.request.contextPath}/knowledgeBase/countImg"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						cache:false,
						dataType:"text",
						data:{"fileAttachmentAnual":anual,"archiveFileAuthenticateStatus":3,"quanzongId":quanzongId,"archiveFileFinishingStatus":3},
						success:function(data){
							$("#huishou").text(data);
						},	
					});
				}
				
				
				 //根据年度下拉框筛选
				function queryImgByAnual2(){
				
				  var status=$("#file").val();
				  if(status=="1"){
					  queryImgByAnual();
				  }else if(status=="2"){
					  queryFileByAnualAndStatus();
				  }else if(status=="3"){
					  queryFileByAnualAndStatus2();
				  }	 
				  countByStatus2();
				  countByStatus3();
				  queryFileByAnual();
				   
				} 

			//待整理文件图片路径集合展示
			function queryFileByAnualAndStatus(){
				var currentPage=$("#pageNum2").val();
				var anual=$("#archivefileanual").val();
				$("#file").val("2");
				if(anual==""){
					layer.msg("请选择年度");
					return;
				}else{
					  common_getPicFileList2(currentPage);
					setTimeout("queryImgList()","500"); 
					$('#mybook').viewer({
		      		      
	       		 	}).viewer('update')
				}
				 
			}
			//回收站文件图片路径集合展示
            function queryFileByAnualAndStatus2(){
            	var currentPage=$("#pageNum3").val();
            	var anual=$("#archivefileanual").val();
            	$("#file").val("3");
            	if(anual==""){
            		layer.msg("请选择年度");
            		return;
            	}else{
            		 common_getPicFileList3(currentPage);
                	 setTimeout("queryImgList()","500");
            	} 
            	
			}
			
			//保存按钮点击事件,给属性赋值
			function saveFileBtn(){
				var archiveFileId=$("#tang").val();
				var anual=$("#archivefileanual").val();
				var quanzongId=new String('${user.quanzongId}');
				  
				if($("#shangyijian").val()!=''&&$("#shangyijian").val()!=null){
					archiveFileId=$("#tang").val();
				}
				var pcId=$('#select1 option:selected').val();
				var scId=$("input[name='scName']:checked").val();
				var retentionperiodId=$("input[name='retentionperiodid']:checked").val();
				var afSecurityClassrification=$("input[name='afSecurityClassrification']:checked").val();
				var onetype=$("#onetype").val();
				if(anual==""||anual==null){
					layer.msg("请选择年度");  
				}else if(pcId==""||pcId==null){
					layer.msg("请选择一级分类");
				 }else if(onetype==""||onetype==null){
					 layer.msg("请选择机构或问题分类");
				}else if(retentionperiodId==""||retentionperiodId==null){
					layer.msg("请勾选保管期限");
				}else if(afSecurityClassrification==""||afSecurityClassrification==null){
					layer.msg("请勾选密级");	
				}else if(scId==""||scId==null){
					layer.msg("请勾选二级分类");
				}else{
						 var msg = "正在生成图片页码,请稍等...";
						 layer.msg(msg,{time:false});
						 //将点击按钮禁用 
						 $("#saveBtn").attr('disabled',true);		
						 setTimeout(function(){filetest(pcId,scId,retentionperiodId,afSecurityClassrification,archiveFileId,anual,quanzongId)}, 2000);
				}
				  
			}
			
			function filetest(pcId,scId,retentionperiodId,afSecurityClassrification,archiveFileId,anual,quanzongId){
				console.log(pcId);
				console.log(scId);
				console.log(retentionperiodId);
				console.log(afSecurityClassrification);
				console.log(archiveFileId);
				console.log(anual);
				console.log(quanzongId);
				$.ajax({
						url:"${pageContext.request.contextPath}/knowledgeBase/updateArchiveFile"+"?timestamp="+Math.random(),
						type:"post",
						beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
						dataType:"json",
						cache:false,
						data:{"primaryclassificationid":pcId,"secondaryclassificationid":scId,
							"retentionperiodid":retentionperiodId,"afsecurityclassrification":afSecurityClassrification,"archivefileid":archiveFileId,"archivefileanual":anual,"quanzongid":quanzongId},
						success:function(result){
							  layer.msg("页码生成成功",{offset:'auto',time:3000},function(){
								  //请求回来时将点击按钮启用 
									  $("#saveBtn").attr('disabled',false);
									  if(result){
										  layer.msg("文件已保存成功",{offset:'auto',time:1500},function(){
											//属性区域置空,单选框重置
												$('input:radio[name=retentionperiodid]').attr('checked',false);
												$('input:radio[name=afSecurityClassrification]').attr('checked',false);
												$('input:radio[name=scName]').attr('checked',false);
												$("#allul").find("li").remove();
												$(".yulangdiv").find("h3").html("");
												$("#mybook").find("div").html("");
												
												$("#foo").empty();
												countImg();
												 queryImgByAnual2();
										  }) 
									}else{
										layer.msg("文件保存失败");
									}
							  });
						 },
					});
			  }
			
			//加载图片
			  function loadPicFormDB4(result){
				  $("#mybook").html(""); 
				  var str="<div class='yulangdiv'>";
				  for(var i=0;i<result.length;i++){
					   str+="<h3><img src="+'<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'
					  +""+result[i].fileAttachmentPath+"?"+Math.random()+" width='100%' height='100%'/></h3></div>"
					  	  
				  }
				  str+="</div>"
				  $("#mybook").append(str);
				 
				  mybookshow();
				  
			  }
			
			//右边预览区域图片展示
		  function queryImgList(){
				var archiveFileId=$("#tang").val() ;
			  $.ajax({
				url:"${pageContext.request.contextPath}/knowledgeBase/queryAttachmentImgList"+"?timestamp="+Math.random(),
				type : "post",
				beforeSend :function(xmlHttp){ 
			        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
			        xmlHttp.setRequestHeader("Cache-Control","no-cache");
			     },
				data:{
					"archiveFileId":archiveFileId},
			    cache:false,
				success:function(data){
					
					var result = data;
					loadPicFormDB4(result);
				},
				error : function(e) {
					console.log("获取文件list数组失败，请检查接口服务");
		
				}
				
			});
  
		  }
			function updateFileByStatus(id){
				$.ajax({
					 url:"${pageContext.request.contextPath}/knowledgeBase/updateFileByStatus"+"?timestamp="+Math.random(),
					 type : "post",
					  beforeSend :function(xmlHttp){ 
					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
					     },
					   data:{"archivefileid":id},
					   cache:false,
					   success:function(data){
						   
					   },
				});
			}
			
		  //点击返回上一件事件
		  function queryFileByOutline(){
			  var anual=$("#archivefileanual").val();
			  var quanzongId=new String('${user.quanzongId}');
			  $.ajax({
				  url:"${pageContext.request.contextPath}/knowledgeBase/previousOneQuery"+"?timestamp="+Math.random(),
				  type : "post",
				  beforeSend :function(xmlHttp){ 
				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
				     },
				  data:{"archiveFileAnual":anual,"quanzongId":quanzongId},
				  cache:false,
				  success:function(data){
					  var result=data;
					  var id=result[0].archiveFileId;
							 $("#foo").empty();
							 $("#foo").append("<span><input  type='hidden' value='"+id+"'>NO."+1+"</span>");
							loadPicFormDB4(result);
					  queryArchiveFileById(id);
					  updateFileByStatus(id);
					  queryImgByAnual2();
				  },
				  error : function(e) {
						console.log("获取文件list数组失败，请检查接口服务");
			             
					}
			  });
			  
		  }
		  
		  function queryArchiveFileById(id){
			  var archiveFileId=id;
			  $.ajax({
				  url:"${pageContext.request.contextPath}/knowledgeBase/queryArchiveFileById"+"?timestamp="+Math.random(),
				  type:"post",
				  beforeSend :function(xmlHttp){ 
				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
				     },
				  data:{"archiveFileId":archiveFileId},
				  cache:false,
				  success:function(data){
					  $("#shangyijian").val(id);
					  var afSecurityClassrification = document.getElementsByName("afSecurityClassrification");
					  var retentionperiodid= document.getElementsByName("retentionperiodid");
					  for (var i = 0; i < afSecurityClassrification.length; i++) {
						   if(data.afSecurityClassrification == afSecurityClassrification[i].value){
							   afSecurityClassrification[i].checked = true;
						  }else{
							  continue;  
						  } 
					  }
					  for(var i=0;i<retentionperiodid.length;i++){
						  if(data.amMaSmRetentionperiod.retentionperiodid==retentionperiodid[i].value){
							  retentionperiodid[i].checked=true;
						  }else{
							  continue;
						  }
					  }
					  
					  var sel=$("#onetype").val();
					  var val=data.primaryClassFication.pcId;
					  var con=data.primaryClassFication.pcName;
					 
					  if( con!="文书档案"){
						  $("#onetype").find("option").remove();
							$("#onetype").html("<option value='1'>问题分类</option>");
							$("#select1").find("option[value = '"+val+"']").attr("selected","selected");
						  $.ajax({
								url:"${pageContext.request.contextPath}/classfication/queryScByPcId"+"?timestamp="+Math.random(),
								type:"post",
								beforeSend :function(xmlHttp){ 
							        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
							        xmlHttp.setRequestHeader("Cache-Control","no-cache");
							     },
								dataType:"json",
								data:{"pcId":val},
								  cache:false,
								success:function(result){
									 oneAndTow(result);
								  $("#scChange").text("问题");
											$("input").remove(".scName");
											$("label").remove(".lascName");
											for(var i=0;i<result.length;i++){
												var str="<input type='radio' class='scName' name='scName'  value='"+result[i].scId+"' />"+
													    "<label for='' class='lascName'>"+result[i].scName+"</label>";
												$("#aa").append(str); 
											}

										for(var i=0;i<result.length;i++){
											  if(data.secondryClassFication.scName==result[i].scName){
												   $("input:radio[name='scName']")[i].checked = true 
												  return;
											  }else{
												  continue;
											  }
										  }
								    },
								
							})
					  }else if(con=="文书档案"){
						  if(data.secondryClassFication.scStatus==1){
							  $("#scChange").text("");
							  $("#onetype").find("option").remove();
								$("#onetype").html("<option value='1'>问题分类</option><option value='0'>机构分类</option>");
								$("#select1").find("option[value = '"+val+"']").attr("selected","selected");
										$.ajax({
											url:"${pageContext.request.contextPath}/classfication/queryScByIdAndStatus"+"?timestamp="+Math.random(),
											type:"post",
											beforeSend :function(xmlHttp){ 
										        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
										        xmlHttp.setRequestHeader("Cache-Control","no-cache");
										     },
											dataType:"json",
											data:{"pcId":val,"scStatus":1,"quanzongid":quanzongIDNew},
											  cache:false,
											success:function(result){
												 oneAndTow(result);
													$("#scChange").text("问题");
													$("input").remove(".scName");
													$("label").remove(".lascName");
													for(var i=0;i<result.length;i++){
														var str="<input type='radio' class='scName' name='scName'  value='"+result[i].scId+"'/>"+
															    "<label class='lascName' for=''>"+result[i].scName+"</label>";
														$("#aa").append(str); 
													}
													 for(var i=0;i<result.length;i++){
														  if(data.secondryClassFication.scId==result[i].scId){
															   $("input:radio[name='scName']")[i].checked = true; 
															   return;
														  }else{
															  continue;
														  }
													  }
											     },
										   });
										
										
						     }else if(data.secondryClassFication.scStatus==0){ 
						    	 $("#scChange").text("");
								  $("#onetype").html("");
									$("#onetype").html("<option value='0'>机构分类</option><option value='1'>问题分类</option>");
									$("#select1").find("option[value = '"+val+"']").attr("selected","selected");
									$.ajax({
										url:"${pageContext.request.contextPath}/classfication/queryScByOrg"+"?timestamp="+Math.random(),
										type:"post",
										beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
									    data:{"quanzongid":quanzongIDNew},
										dataType:"json",
										  cache:false,
										success:function(result){
											 oneAndTow(result);
											$("#scChange").text("机构");
												$("input").remove(".scName");
												$("label").remove(".lascName");
												for(var i=0;i<result.length;i++){
													for (var j = 0; j < result[i].twos.length; j++) {
														var str="<input type='radio' class='scName' name='scName'  value='"+result[i].twos[j].scId+"' />"+
													    "<label class='lascName' for=''>"+result[i].twos[j].scName+"</label>";
														$("#aa").append(str); 
													}
												}
												
												var scName=data.secondryClassFication.scName;
												  
												 for(var i=0;i<result.length;i++){
													for(var j=0;j<result[i].twos.length;j++){
														var scName = document.getElementsByClassName("scName");
														if(data.secondryClassFication.scName==result[i].twos[j].scName){
													 $(":radio[name='scName'][value='" + result[i].twos[j].scId + "']").prop("checked", "checked");
													     return;
												      }else{
														 continue;
													}
												}
											} 
										},
									})
									 
						     }else if(sel==1){
						    	 $("#scChange").text("");
								  $("#onetype").html("");
									$("#onetype").html("<option value='1'>问题分类</option><option value='0'>机构分类</option>");
									$("#select1").find("option[value = '"+val+"']").attr("selected","selected");
										  $.ajax({
											url:"${pageContext.request.contextPath}/classfication/queryScByIdAndStatus"+"?timestamp="+Math.random(),
											type:"post",
											beforeSend :function(xmlHttp){ 
										        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
										        xmlHttp.setRequestHeader("Cache-Control","no-cache");
										     },
											dataType:"json",
											data:{"pcId":val,"scStatus":1,"quanzongid":quanzongIDNew},
											  cache:false,
											success:function(result){
												 oneAndTow(result);
												$("#scChange").text("问题");
													$("input").remove(".scName");
													$("label").remove(".lascName");
													for(var i=0;i<result.length;i++){
														var str="<input type='radio' class='scName' name='scName'  value='"+result[i].scId+"' />"+
															    "<label class='lascName' for=''>"+result[i].scName+"</label>";
														$("#aa").append(str); 
													}			
										
													for(var i=0;i<result.length;i++){
														  if(data.secondryClassFication.scName==result[i].scName){
															   $("input:radio[name='scName']")[i].checked = true 
															  return;
														  }else{
															  continue;
														  }
													  }
												},
											});
						     }else if(sel==0){
						    	 $("#scChange").text("");
								  $("#onetype").html("");
									$("#onetype").html("<option value='0'>机构分类</option><option value='1'>问题分类</option>");
									$("#select1").find("option[value = '"+val+"']").attr("selected","selected");
									$.ajax({
										url:"${pageContext.request.contextPath}/classfication/queryScByOrg"+"?timestamp="+Math.random(),
										type:"post",
										beforeSend :function(xmlHttp){ 
									        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
									        xmlHttp.setRequestHeader("Cache-Control","no-cache");
									     },
									    data:{"quanzongid":quanzongIDNew},
										dataType:"json",
										  cache:false,
										success:function(result){
											 oneAndTow(result);
											$("#scChange").text("机构");
												$("input").remove(".scName");
												$("label").remove(".lascName");
												for(var i=0;i<result.length;i++){
													for (var j = 0; j < result[i].twos.length; j++) {
														var str="<input type='radio' class='scName' name='scName'  value='"+result[i].twos[j].scId+"' />"+
													    "<label class='lascName' for=''>"+result[i].twos[j].scName+"</label>";
														$("#aa").append(str); 
													}
												}
												
												for(var i=0;i<result.length;i++){
													for(var j=0;j<result[i].twos.length;j++){
														if(data.secondryClassFication.scName==result[i].twos[j].scName){
															result[i].twos[j].scName.checked = true 
															  return;
														  }else{
															  continue;
													}
												}
											}
										},
									})
						   		}
					  		}
				 		 },
			  		});
		  		}
		  
		  var oneAndTow = function(result){
				//自动绑定一级分类菜单
				var select = 'dd[lay-value=' + result[0].pcId + ']'; 
				$('#select1').siblings("div.layui-form-select").find('dl').find(select).click();
				//自动绑定二级分类菜单
				var onetype = 'dd[lay-value=' + result[0].scStatus + ']';  
				$('#onetype').siblings("div.layui-form-select").find('dl').find(onetype).click();
		  }
		// 点击展示更换图片和图片视图预览
		      var imgLis = document.getElementsByClassName("li");
		     function Img_view(){
		    	 for(var i=0;i<imgLis.length;i++){
		    		 this.imgLis[i].onclick = function() {
		    			 var imgli = this.innerHTML;
						 var imgPath=$(this).find("img").attr("id");
						 $("#coverPath").val(imgPath);
		    		 }
		    	 }
		     }
		     Img_view();
		  //右边预览区域图片数据重新渲染
		  function showImgList(id,event){
			  var text=window.event.srcElement.innerText;
			  $.ajax({
				  url:"${pageContext.request.contextPath}/knowledgeBase/queryFileAttachmentById"+"?timestamp="+Math.random(),
				  type:"post",
				  beforeSend :function(xmlHttp){ 
				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
				     },
				  dataType:"json",
				  data:{"archiveFileId":id},
				  cache:false,
				  success:function(result){
					  if(result !=null){
						  $("#mybook").empty();
						  var list=result;
						  var ids = new Array();
						  for (var i = 0; i < list.length; i++) {
								var id=list[0].archiveFileId;
								ids.push(list[i].archiveFileId );
							}
						  $("#tang").val(id);
						  $("#foo").empty();
						  $("#foo").append("<span><input  type='hidden' value='"+id+"'>"+text+"</span>");
						  var str="<div class='yulangdiv'>";
						  for(var i=0;i<list.length;i++){
							   str+="<h3><img src="+'<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'
							  +""+list[i].fileAttachmentPath+"?"+Math.random()+" width='100%' height='100%'/></h3></div>"
								  
						  }
						  str+="</div>"
						  $("#mybook").append(str);
						 
						  mybookshow();
					  }else{
						  layer.msg("数据获取失败请联系管理员");
					  }  
				  },
				  error:function(){
						layer.msg("发生未知错误请联系管理员");
					}
			  });
		  } 
	
			
		
		</script> 
		 
	</body>

</html>