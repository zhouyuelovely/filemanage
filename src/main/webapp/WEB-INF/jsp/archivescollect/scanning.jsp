<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.net.InetAddress"%>  
<%@ taglib uri="http://com.zm" prefix="zm"%>
<%
  String app_url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%  
    InetAddress address = InetAddress.getLocalHost();    
    String ip=address .getHostAddress().toString();    
    pageContext.setAttribute("ip",ip);  
%> 
<html>

	<head>
		<meta charset="utf-8">
		<title>档案收集整理系统_档案扫描</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css"/>
		<!-- 图片预览 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/viewer.min.css">
		<!-- 自定义样式 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/scaning.css">
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!-- 图片预览插件 -->
		<script src="${pageContext.request.contextPath}/js/viewer.min.js"></script>
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->

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
						<li class="layui-nav-item layui-this">
							<c:if test="${zm:buttenPremission('aa',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/fileScanning/goFileScanning?meng=<%=Math.random() %>">档案扫描</a>
							</c:if>
						</li>
						<li class="layui-nav-item">
							<c:if test="${zm:buttenPremission('ab',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/archiveFileStore/goStore?meng=<%=Math.random() %>">档案存储</a>
							</c:if>
						</li>
						<li class="layui-nav-item layui-hide-xs">
							<c:if test="${zm:buttenPremission('ae',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/knowledgeBase/goIdentification?currentPage=1&meng=<%=Math.random() %>">档案整理</a>
							</c:if>
						</li>
						<li class="layui-nav-item layui-hide-xs">
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
						 <div class="layui-col-xs12 layui-col-sm8 layui-col-md8" style="color: #626262;">
						 	<div class="nav_btn">
						 	<c:if test="${zm:buttenPremission('aaa',sessionScope.user.role.authorities) }">
								<button type="button" class="layui-btn layui-btn-warm" id="release">在线扫描</button>
								</c:if>
								<c:if test="${zm:buttenPremission('aab',sessionScope.user.role.authorities) }">
								<button type="button" class="layui-btn layui-btn-blue" id="test4"><i class="layui-icon"></i>离线导入</button>
								<!-- <button type="button" id="but2" onclick="common_getPicFileList(1)">测试</button> -->
								</c:if>
							</div>
							<!--扫描图片展示-->
						 	<ul class="Scanning_Images" id="img-sort">
						 		<%-- <li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page1</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page2.jpg" alt="">
									<p>page2</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page3.jpg" alt="">
									<p>page3</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page4.jpg" alt="">
									<p>page4</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page5</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page6</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page7</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page8</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page9</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page10</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page11</p>
						 		</li>
						 		<li class="li">
						 			<button class="del">X</button>
									<img src="${pageContext.request.contextPath}/imgs/page1.jpg" alt="">
									<p>page12</p>
						 		</li> --%>
						 		
						 	</ul>
						 	<!--图片分页-->
	                     	<div class="layui-clear" style="padding-top: 30px;text-align:center;">
								<span>
	                  			           第<select name="" id="pageNum" onchange="chang()">
	                           			 <!-- <option value="">1</option> -->
	                       			</select>页
	                  			</span>
								<span>共<span id="totalPage"></span>页</span>
								<span class="layui-btn layui-btn-xs" id="pageUp">上一页</span>
								<span class="layui-btn layui-btn-xs" id="pageDown">下一页</span>
							</div>
							
						 </div>
						 <div class="layui-col-xs12 layui-col-sm4 layui-col-md4" style="color: #000;">
								<!-- 图片识别区域 -->
								<div class="Image_recognition" style="margin-top: 15px;">
									<p style="text-align:left;">页面预览</p>
									<div style="text-align:center;">
										<div style="height:200px" id="img">
											<div class="delimg" id="delimg">
												<!-- 图片识别 -->
											</div>
										</div>
									</div>
									<c:if test="${zm:buttenPremission('aac',sessionScope.user.role.authorities) }">
									<button type="button" onclick="imageRecognize()" class="layui-btn layui-btn-sm" style="margin:2% 0;background:#EA5519;">识别首页</button>
									</c:if>
								<hr class="layui-bg-green">
								<!-- 识别信息区域 -->
							<form class="Image_recognition" id="scanForm" style="text-align:left;border:none;margin:0;">
								<div class="mg_top" style="width:50%;">
									<label>*责任人</label><input type="text" class="layui-input" name="archiveFileResponsible"  id="archiveFileResponsible" value="" style="width:60%;display:inline-block;">
								</div>
								<div class="mg_top">
									<label>*日&nbsp;&nbsp;&nbsp;期</label><input type="text" class="layui-input" onchange="vals('archiveFileCreatetime')" name="archiveFileCreatetime" id="archiveFileCreatetime" value="" style="width:31%;display:inline-block;">
									<label>*年&nbsp;&nbsp;&nbsp;度</label><input type="text" class="layui-input" name="archiveFileAnual" id="archiveFileAnual" value="" style="width:28%;display:inline-block;">
								</div>
								<div class="mg_top">
									<label>&nbsp;文&nbsp;&nbsp;&nbsp;号</label><input type="text" class="layui-input" name="archiveFileReferenceNumber" id="archiveFileReferenceNumber" value="" style="width:80%;display:inline-block;">
								</div>
								<div class="mg_top">
									<label>*题&nbsp;&nbsp;&nbsp;名</label><textarea style="width:80%;height:80px;display:inline-block;" class="layui-input" id="archiveFileTitle" name="archiveFileTitle"></textarea>
								</div>
								<div class="mg_but">、
								<c:if test="${zm:buttenPremission('aad',sessionScope.user.role.authorities) }">
									<button type="button" onclick="saveCoverInfo()" class="layui-btn layui-btn-sm">保存</button>
								</c:if>
								</div>
							</form>
							 </div>
						 </div>
					</div>	
				</div>
				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
			<!--左边弹框开始-->
			<div class="bomb-box2">
				<div class="box-worp" style="width: 800px;height:635px;">
					<div class="closed" id="closed">X</div>
					<h3 class="bgcolor">在线扫描</h3>
					<div class="mod-body" style="height: 600px;">
						<object classid="clsid:15D142CD-E529-4B01-9D62-22C9A6C00E9B"
									id="scaner1" width="100%" height="600"
									codebase="${pageContext.request.contextPath}/${pageContext.request.contextPath}/cabs/ScanOnWeb.cab#version=1,0,0,10">
								<param name="licenseMode" value="4">
    							<param name="key1" value="jaI31uGLizEzKHEM1tTAYbu7iJg9pAZo/x3kOPT1yiP2nKVqHyHDotNj6rUwscILG3ZHOcpdJXFE+u0XCmFeRfmsyskjS3YTiqfvldT8lBBBwbZSFuYI/lXF3zG0AGzd1AM=">
						</object>
					</div>
				</div>
			</div>
			<!--左边弹框结束-->
		</div>
		
		
<script language="javascript" event="OnUploadBtnClick()" for="scaner1">
	var status = document.getElementById("scaner1").uploadAllAsEachJpgToServerUrl('<%=app_url%>/fileScanning/uploadjpg','123456','');
	console.log(status);
	if (null == status) {
		alert("上传失败!可能是安全框架拦截了上传请求!");
		return;
	}
	var json_obj = eval("(" + status + ")");
	if (true == json_obj.status) {
		alert("上传成功!");
		common_getPicFileList(1);
	} else {
		alert("上传失败!");
	}
</script>
		
<script type="text/javascript">

	// 验证日期
	function isDate(date) { 
	 var pattern = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/; 
	 return pattern.test(date); 
	}
	
	// 1900-2099年的验证
	function isYear(date) { 
	 var pattern = /(19[\d][\d]|20[\d][\d])/; 
	 return pattern.test(date); 
	}
	function vals(id){
		var val=$("#archiveFileCreatetime").val();
		var arr=val.substr('0','4'); 
		$("#archiveFileAnual").val(arr);
	}
	//保存封面信息
	function saveCoverInfo(){
		var reg=new RegExp('^[^\\\\\\/:*?\\"<>|]+$');
		var archiveFileTitle=$("#archiveFileTitle").val();
		var temporaryAccessaryPath=$("#delimg img").eq(0).attr("src");
		if($.trim($("#archiveFileResponsible").val())=="" || $.trim($("#archiveFileCreatetime").val())=="" || $.trim($("#archiveFileAnual").val())=="" || $.trim($("#archiveFileTitle").val())==""){
			layer.msg("请填写完整表单信息!");
		}else if($.trim(temporaryAccessaryPath)==''){
			layer.msg("请识别首页!");
		}else if(isDate($("#archiveFileCreatetime").val()) == false){
			layer.msg("日期不正确,请重新输入!");
			return false
		}else if(isYear($("#archiveFileAnual").val()) == false){
			layer.msg("年度不正确,请重新输入!");
			return false
		}else if(!reg.test(archiveFileTitle)){
			layer.msg("不能包含以下符号:"+new String('\/:*?"<>|'))
		}else{
			layer.msg("正在保存信息,请稍后...",{time:5000});
			$.ajax({
				url:"${pageContext.request.contextPath}/fileScanning/saveCoverForm",
				type:"POST",
				dataType:"JSON",
				async:false,
				data: $("#scanForm").serialize()+"&temporaryAccessaryPath="+temporaryAccessaryPath,
				success:function(data){
					if(data == 1){
						layer.msg("文号或题名已存在，表单信息添加失败!");
					}else if(data == 2){
						layer.msg("文件已保存成功!",{time:2000});
						setTimeout(function(){
							window.location.href="${pageContext.request.contextPath}/fileScanning/goFileScanning";
						},2000)
					}else if(data == 3){
						layer.msg("表单信息添加异常!");
					}
				},
				error:function(e){
					layer.msg("服务端接口异常!");
			
				}
			});
		}
	}
	
	var currentPage = 1;
	var totalPage=null;
	$().ready(function(){
		//上一页图片
		$("#pageUp").unbind('click').bind('click',function(){
			if(currentPage > 1){
				currentPage--;
				common_getPicFileList(currentPage);
			}else if(currentPage==1){
				layer.msg("已经是第一页了!",{time:2000});
				return;
			}
		});
	
		//下一页图片
		$("#pageDown").unbind('click').bind('click',function(){
			if(currentPage < totalPage){
				currentPage++;
				common_getPicFileList(currentPage);
			}else if(currentPage==totalPage){
				layer.msg("已经是最后一页了!",{time:2000});
				return;
			} 
		});
	})
	
	//改变下拉框
	function chang(){
		currentPage=$("#pageNum").val();
		common_getPicFileList(currentPage);
	};
	
	// 获取图片的存储路径集合 
	function common_getPicFileList(currentPage) {
		$.ajax({
			url : "${pageContext.request.contextPath}/fileScanning/getImgFileList",
			type : "POST",
			data : "currentPage="+currentPage,
			beforeSend :function(xmlHttp){ 
		        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
		        xmlHttp.setRequestHeader("Cache-Control","no-cache");
		     },
			success : function(data) {
				currentPage=data.currPage;
				console.log("当前页:"+currentPage);
				totalPage = data.totalPage;
				var result = data.lists;
				console.log(result);
				console.log("图片长度"+result.length);
				if (!result.length) {
					layer.msg("图片显示异常,请联系系统管理员!");
					return;
				} else {
					//获取到的图片数组处理逻辑方法
					loadPicFormDB(result);
				}
				$("#totalPage").html(data.totalPage);
				$("#pageNum").empty();
				for(var i=1;i<=totalPage;i++){
					if(currentPage==i){
						$("#pageNum").append("<option value='"+i+"' selected>"+i+"</option>");
					}else{
						$("#pageNum").append("<option value='"+i+"'>"+i+"</option>")
					}
				}
			},
			error : function(e) {
				layer.msg("服务端异常!");
	
			}
		});
	}
	
	//加载图片
	function loadPicFormDB(result) {
		$("#img-sort").empty();
			for (var i = 0; i < result.length; i++) {
				$("#img-sort")
				  .append("<li class='li'><button class='del' value='"+result[i].temporaryAccessaryPath+"' name='"+result[i].temporaryAccessaryPageNumber+"'>X</button>"
						 +"<img src="+'<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>'
												+""+result[i].temporaryAccessaryPath+"?"+Math.random()+"><p>page"+result[i].temporaryAccessaryPageNumber+"</p></li>")
				
			}
			Img_view();
			del();
	};
	
	// 点击展示更换图片和图片视图预览
	var imgLis = document.getElementsByClassName("li");
	var delimg = document.getElementById("delimg");

	function Img_view() {
		for(var i = 0; i < imgLis.length; i++) {
			this.imgLis[i].onclick = function() {
				var imgli = this.innerHTML;
				$("#delimg").remove();
				var delimgDIV = "<div class='delimg' id= 'delimg'>" + imgli + "</div>";
				$("#img").append(delimgDIV);
				$(".delimg button").remove();
				$('#delimg').viewer();
			}
		}
	}
	
	//OCR图片识别
	function imageRecognize(){
		var imgPath=$("#delimg img").eq(0).attr("src");
		if(imgPath==null||imgPath==''){
			layer.msg("请选择需要识别的首页!");
		}else{
			layer.msg('正在识别中，请稍后...', {time:3000}); 
			$.ajax({
				url : "${pageContext.request.contextPath}/fileScanning/imageRecognize",
				type : "GET",
				data : "temporaryAccessaryPath="+imgPath,
				dataType:"json",
				success : function(data) {
					console.log(data);
					if(data.archiveFileResponsible==''||data.archiveFileTitle==''){
						layer.msg("识别图片失败,请检查识别的图片是否是首页!");
					}else{
						//var result=JSON.parse(data);
						$("#archiveFileResponsible").val(""); //清空上次input框里的数据  
				        $('#archiveFileResponsible').val(data.archiveFileResponsible);//往input框里传值 
				        $("#archiveFileReferenceNumber").val(""); //清空上次input框里的数据  
				        $('#archiveFileReferenceNumber').val(data.archiveFileReferenceNumber);//往input框里传值 
				        $("#archiveFileTitle").val(""); //清空上次textarea框里的数据  
				        $('#archiveFileTitle').val(data.archiveFileTitle);//往textarea框里传值 
						
					}
				}
			});
		}
	}
	
	//删除图片
	function del(){
			$("button.del").on('click', function(){
		    var othis = $(this);
		    var imgPath = othis.val();
		    var pageNumber=othis.attr("name");
		    console.log("当前页:"+pageNumber);
		    layer.open({
		        content: '您确认删除图片？',
		        btn: ['确认', '取消'],
		        shadeClose: false,
		        yes: function(){
		            layer.open({content: '确认', time: 1});
		            $.ajax({
		    			url : "${pageContext.request.contextPath}/fileScanning/delImg",
		    			type : "POST",
		    			data : "temporaryAccessaryPath="+imgPath+"&temporaryAccessaryPageNumber="+pageNumber,
		    			success : function(data) {
		    				if(data=='1'){
		    					layer.msg("删除图片成功!");
		    					othis.parent('li').remove();
		    					common_getPicFileList(currentPage);
		    				}else{
		    					layer.msg("删除图片失败,系统出现异常!");
		    				}
		    			},
		    			error : function(e) {
		    				layer.msg("服务端异常,请联系系统管理员!");
		    	
		    			}
		    		});
		        }, no: function(){
		            layer.open({content: '您选择了取消', time: 1});
		        }
		    });
		})
	}
	
	//	  点击发布消息弹框显示
	$("#release").click(function() {
		$(".bomb-box2").show();
	})
	//点击关闭弹框
	$("#closed").click(function() {
		$(".bomb-box2").hide();
	})
	
	//离线导入
	layui.use('upload', function(){
	  var $ = layui.jquery
	  ,upload = layui.upload;
	  upload.render({ //允许上传的文件后缀
		    elem: '#test4'
		    ,url: '${pageContext.request.contextPath}/fileScanning/offlineImport'
		    ,accept: 'file' //普通文件
		    ,exts: 'zip' //只允许上传压缩文件
		    ,done: function(res){
		      if(res['msg']=='ok'){
		    	  layer.msg("文件已导入成功!");
		      }else if(res['msg']=='error'){
		    	  layer.msg("数据上传异常,请检查上传数据包是否正确!");
		      }
		    }
		  });
	})
	
</script>
<script type='text/javascript'>
  document.getElementById('scaner1').loadLicenseData('http://<%=ip%>:8080/licserver/check.jsp');
</script>
</body>

</html>