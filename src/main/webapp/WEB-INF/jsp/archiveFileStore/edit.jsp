<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.net.InetAddress"%>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>
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
<title>档案收集整理系统_档案存储_插扫</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="../font-awesome-4.7.0/css/font-awesome.min.css" />
<!--导航公共样式-->
<link rel="stylesheet" type="text/css"
	href="../css/archives-collection.css" />
<!--自定义样式-->
<link rel="stylesheet" type="text/css" href="../css/edit.css" />
<!-- 图片预览 -->
<link rel="stylesheet" type="text/css" href="../css/off-line-index.css" />
<link rel="stylesheet" type="text/css" href="../css/viewer.min.css">

<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
<style type="text/css">
/*.layui-body{overflow-y: scroll;} 滚动条问题*/
</style>
</head>
<body class="layui-layout-body">
	<div>
		<div class="layui-layout layui-layout-admin">

			<!--class 个性化设置nav_bg1-->
			<div class="copy">
				<!-- 版权所有 -->
				<p>
					COPYRIGHT&nbsp;&copy;2018 <a href="#">甘肃集优品网络科技有限公司</a>&nbsp;版权所有
				</p>
			</div>

			<div class="logo_nav">
				<!-- 头部区域 -->
				<div>
					<span class="logo_img"><img src="../imgs/home.gif"
						width="110" height="50" /></span>
					<div class="logo">
						档案收集整理系统 <a href="${pageContext.request.contextPath}/log/goHome"
							id="home">返回主页&gt;</a>
					</div>
				</div>

			</div>
			<!--全宗导航-->
			<div class="top_bar">
				<!-- 头部区域 -->
				<ul class="layui-nav" id="top_nav">
					<li class="layui-nav-item layui-this">
						<c:if test="${zm:buttenPremission('aa',sessionScope.user.role.authorities) }">
							<a class="active" href="${pageContext.request.contextPath}/fileScanning/goFileScanning?meng=<%=Math.random() %>">档案扫描</a>
						</c:if>
					<li class="layui-nav-item">
					    <c:if test="${zm:buttenPremission('ab',sessionScope.user.role.authorities) }">
							<a href="${pageContext.request.contextPath}/archiveFileStore/goStore?meng=<%=Math.random() %>">档案存储</a>
						</c:if>
					</li>
					
					<li class="layui-nav-item layui-hide-xs">
						<c:if test="${zm:buttenPremission('ad',sessionScope.user.role.authorities) }">
							<a	href="${pageContext.request.contextPath}/knowledgeBase/goIdentification?currentPage=1&meng=<%=Math.random() %>">档案整理</a>
						<!-- INSERT INTO "SCOTT"."AM_MA_SM_PERMISSION" VALUES ('43', '档案整理质量统计', 'report/queryRejects', '/statistics/Statistics_report_line', 'fd'); -->
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
			<div class="layui-body" style="top: 140px; left: 0;">
				<div class="layui-row">
					<div class="layui-inline"
						style="margin-top: 10px; padding-left: 10px; width: 100%; background: #FFFFFF;">
						<div id="" style="float: left; padding-left: 20px;">
							<i class="fa fa-step-forward font_color b-i"></i> <label for=""
								class="b-i">
								<c:if test="${zm:buttenPremission('ab',sessionScope.user.role.authorities) }">
								<a
								href="${pageContext.request.contextPath}/archiveFileStore/goStore">档案存储</a>
								</c:if>
								</label>
							&gt; &gt;<label for="">编辑</label>
						</div>
					</div>
					<div class="layui-col-xs12 layui-col-sm8 layui-col-md8"
						style="color: #626262; min-height: 600px;">
						<div class="nav_btn">
						<c:if test="${zm:buttenPremission('aca',sessionScope.user.role.authorities) }">
							<button type="button" class="layui-btn" id="release">在线插扫</button>
							
							<button type="button" class="layui-btn"
								onclick="$('input[id=image]').click()">离线图片上传</button>
							</c:if>
						</div>
						<form enctype="multipart/form-data" method="post" id="fileForm"
							style="display: inline;">
							<input type="file" name="image" id="image" style="display: none;"
								onchange="subForm()" multiple>
						</form>
						<!--扫描图片展示-->
						<ul class="Scanning_Images">
							<c:forEach items="${pagemsg.lists }" var="fileAttachment">
								<li class="li">
									<button class="del"
										name="${fileAttachment.fileAttachmentPageNumber }">X</button>
									<img
									src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>${fileAttachment.fileAttachmentPath}?meng=<%=Math.random() %>"
									name="${fileAttachment.fileAttachmentId }"
									id="${fileAttachment.fileAttachmentPath}">
									<p onclick="page('${fileAttachment.fileAttachmentPageNumber}')">page${fileAttachment.fileAttachmentPageNumber}</p>
								</li>
							</c:forEach>
						</ul>
						<!--图片分页-->
						<div class="layui-clear"
							style="padding-top: 30px; text-align: center;">
							<%@include file="/WEB-INF/page/pageBean.jsp"%>
						</div>

					</div>
					<div class="layui-col-xs12 layui-col-sm4 layui-col-md4"
						style="color: #000;">
						<!-- 图片识别区域 -->
						<div class="Image_recognition" style="margin-top: 15px;">
							<p style="text-align: left;">页面预览</p>
							<div style="text-align: center;">
								<div style="height: 240px" id="img">
									<div class="delimg" id="delimg">
										<!-- 图片识别 -->
									</div>
								</div>
							</div>
							<input type="hidden" id="coverPath" value="">
							<c:if test="${zm:buttenPremission('acc',sessionScope.user.role.authorities) }">
							<button type="button" class="layui-btn layui-btn-sm"
								style="margin: 2% 0; background: #EA5519;" onclick="know()">识别首页</button>
						</c:if>
						</div>
						<!-- 识别信息区域 -->
						<input type="hidden" name="page" id="page" value="">
						<form class="Image_recognition" style="text-align: left;" id="for">
							<input type="hidden" name="archiveFileId" id="archiveFileId"
								value="${archiveFile.archiveFileId }"> <input
								type="hidden" name="remark" id="remark" value="">
							<div class="mg_top" style="width: 50%;">
								<label>*责任者</label><input type="text"
									name="archiveFileResponsible"
									value="${archiveFile.archiveFileResponsible }"
									style="width: 60%; display: inline-block;" class="layui-input"
									id="archiveFileResponsible">
							</div>
							<div class="mg_top">
								<label>*日&nbsp;&nbsp;&nbsp;期</label><input type="text"
									name="archiveFileCreatetime"
									value="${archiveFile.archiveFileCreatetime }"
									style="width: 31%; display: inline-block;" class="layui-input"
									id="archiveFileCreatetime"> <label>*年&nbsp;&nbsp;&nbsp;度</label><input
									type="text" name="archiveFileAnual"
									value="${archiveFile.archiveFileAnual }"
									style="width: 28%; display: inline-block;" class="layui-input"
									id="archiveFileAnual" onclick="havingAnual()">
							</div>
							<div class="mg_top">
								<label>&nbsp;文&nbsp;&nbsp;&nbsp;号</label><input type="text"
									name="archiveFileReferenceNumber"
									value="${archiveFile.archiveFileReferenceNumber }"
									style="width: 80%; display: inline-block;" class="layui-input"
									id="archiveFileReferenceNumber">
							</div>
							<div class="mg_top">
								<label>*题&nbsp;&nbsp;&nbsp;名</label>
								<textarea name="archiveFileTitle"
									style="width: 80%; height: 100px; display: inline-block;"
									class="layui-input" id="archiveFileTitle">${archiveFile.archiveFileTitle }</textarea>
							</div>
							<div class="mg_but">
							<c:if test="${zm:buttenPremission('acd',sessionScope.user.role.authorities) }">
							
								<button type="button" class="layui-btn layui-btn-sm"
									onclick="saveArchiveFile()">保存</button>
							</c:if>	
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
		<!--左边弹框开始-->
		<div class="bomb-box2">
			<div class="box-worp" style="width: 800px;">
				<div class="closed" id="closed">X</div>
				<h3 class="bgcolor">编辑</h3>
				<div class="mod-body" style="height: 560px;">
					<object classid="clsid:15D142CD-E529-4B01-9D62-22C9A6C00E9B"
						id="scaner1" width="100%" height="600"
						codebase="${pageContext.request.contextPath}/${pageContext.request.contextPath}/cabs/ScanOnWeb.cab#version=1,0,0,10">
						<param name="licenseMode" value="4">
						<param name="key1"
							value="jaI31uGLizEzKHEM1tTAYbu7iJg9pAZo/x3kOPT1yiP2nKVqHyHDotNj6rUwscILG3ZHOcpdJXFE+u0XCmFeRfmsyskjS3YTiqfvldT8lBBBwbZSFuYI/lXF3zG0AGzd1AM=">


					</object>
				</div>
			</div>
		</div>
		<!--左边弹框结束-->
	</div>
	<script src="../js/jquery.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="../layui/layui.all.js"></script>
	<script src="../layui/lay/modules/laydate.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="../js/pageBean.js"></script>
	<!-- 图片预览插件 -->
	<script src="../js/viewer.min.js"></script>
	<script type="text/javascript">
		// 点击展示更换图片和图片视图预览
			var imgLis = document.getElementsByClassName("li");
			var delimg = document.getElementById("delimg");

			function Img_view() {
				for(var i = 0; i < imgLis.length; i++) {
					this.imgLis[i].onclick = function() {
						var imgli = this.innerHTML;
						var imgPath=$(this).find("img").attr("id")
						$("#coverPath").val(imgPath);
						var remark=$(this).find("img").attr("name")
						$("#remark").val(remark);
						$("#delimg").remove();
						var delimgDIV = "<div class='delimg' id= 'delimg'>" + imgli + "</div>";
						$("#img").append(delimgDIV);
						$(".delimg button").remove();
						$('#delimg').viewer();
					}
				}
			}
			
			function del(){
					$("button.del").on('click', function(){
				    var othis = $(this);
				    var fileAttachmentPageNumber=othis.attr("name");
				    var archiveFileId=$("#archiveFileId").val();
				    layer.open({
				        content: '您确认删除图片？',
				        btn: ['确认', '取消'],
				        shadeClose: false,
				        yes: function(){
				            layer.open({content: '确认', time: 1});
				            othis.parent('li').remove();
				            $.ajax({
				            	url:"${pageContext.request.contextPath}/archiveFileStoreModify/deleteImage?meng="+<%=Math.random() %>,
				            	data:"fileAttachmentPageNumber="+fileAttachmentPageNumber+"&archiveFileId="+archiveFileId,
				            	type:"post",
				            	dataType:"json",
				            	success:function(data){
				            		if(data==true){
				            			layer.msg("文件已删除成功",{setoff:'auto',anim: 1});
				            			var num=$("select").val();
				    					changePage(num)
				            		}else{
				            			layer.msg("文件删除失败");
				            		}
				            	}
				            })
				        }, no: function(){
				            layer.open({content: '您选择了取消', time: 1});
				        }
				    });
				})
			}
			Img_view();
			del();
			//	  点击发布消息弹框显示
			$("#release").click(function() {
				$(".bomb-box2").show();
			})
			//点击关闭弹框
			$("#closed").click(function() {
				$(".bomb-box2").hide();
			})
			
			//页面数据渲染
			function changePage(currentPage){
				var archiveFileId=$("#archiveFileId").val();
				$.ajax({
					url:"${pageContext.request.contextPath}/archiveFileStoreModify/havingFileAttachment?meng="+<%=Math.random() %>,
					type:"get",
					data:"archiveFileId="+archiveFileId+"&currentPage="+currentPage,
					dataType:"json",
					beforeSend :function(xmlHttp){ 
				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
				     },
					success:function(pagemsg){
						if(pagemsg!=null){
							$(".Scanning_Images").empty();
							var list=pagemsg.lists;
							var content="";
							for(var i=0;i<list.length;i++){
								content+="<li class=\"li\">"
									content+="<button class=\"del\" name=\""+list[i].fileAttachmentPageNumber+"\">X</button>"
									content+="<img src=\"<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>"+list[i].fileAttachmentPath+"?"+Math.random()+"\" name=\""+list[i].fileAttachmentId+"\" id=\""+list[i].fileAttachmentPath+"\">"
									content+="<p onclick=\"page('"+list[i].fileAttachmentPageNumber+"')\">page"+list[i].fileAttachmentPageNumber+"</p>"
								content+="</li>"
							}
							$(".Scanning_Images").append(content);
							Img_view();
							del();
							pageLocal(pagemsg);
							
						}else{
							layer.msg("数据获取失败请联系管理员");
						}
					},
					error:function(){
						layer.msg("发生未知错误请联系管理员");
					}
				})
			}
			function chang(){
				var currentPage=$("select").val();
				changePage(currentPage);
			}
			function page(index){
				$("#page").val(index);
			}
			function know(){
				var imgPath=$("#coverPath").val();
				if(imgPath==null||imgPath==''){
					layer.msg("请选择需要识别的首页!");
				}else{
					$.ajax({
						url : "${pageContext.request.contextPath}/archiveFileStoreModify/imageRecognize?meng="+<%=Math.random()%>,
						type : "post",
						data : "imgPath="+imgPath,
						dataType:"json",
						success : function(data) {
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
			function saveArchiveFile(){
				var archiveFileId=$("#archiveFileId").val();//获取文件 的主键
				var archiveFileReferenceNumber=$("#archiveFileReferenceNumber").val();//获取文件的文号
				var archiveFileTitle=$("#archiveFileTitle").val();//获取文件的题名
				var reg=new RegExp('^[^\\\\\\/:*?\\"<>|]+$');
				var archiveFileTitle=$("#archiveFileTitle").val();
				if($("#remark").val()==""){
					layer.msg("选择首页图片")
				}else if($.trim($("#archiveFileResponsible").val())=="" || $.trim($("#archiveFileCreatetime").val())=="" || $.trim($("#archiveFileAnual").val())=="" || $.trim($("#archiveFileTitle").val())==""){
					layer.msg("请填写完整表单信息!");
				}else if(!reg.test(archiveFileTitle)){
					layer.msg("不能包含以下符号:"+new String('\/:*?"<>|'))
				}else{
					$.ajax({//重名校验
						url:"${pageContext.request.contextPath}/archiveFileStoreModify/check?meng="+<%=Math.random()%>,
						data:{"archiveFileId":archiveFileId,"archiveFileReferenceNumber":archiveFileReferenceNumber,"archiveFileTitle":archiveFileTitle},
						type:"post",
						dataType:"json",
						success:function(data){
							if(data){//不存在重名文件或者重名文件为本文件允许修改
								$.ajax({
									url:"${pageContext.request.contextPath}/archiveFileStoreModify/updateArchiveFile?meng="+<%=Math.random()%>,
									data:$("#for").serialize(),
									type:"post",
									dataType:"json",
									success:function(data){
										if(data==true){
											layer.msg("文件已保存成功",{setoff:'auto',anim: 1},function(){
												location.href="${pageContext.request.contextPath}/archiveFileStore/goStore?meng="+<%=Math.random()%>;
											})
										}else{
											layer.msg("更新失败，联系管理员")
										}
									},
									error:function(e){
										layer.msg("检查接口是否连接")
									}
								})
							}else{
								layer.msg("题名或文号已存在，请检查文件信息")
							}
						},error:function(){//重名校验 连接检验
							layer.msg("检查接口是否连接")
						}
					})
					
					
					
					
					
				}
			}
			function havingAnual(){
				var fileTime=$("#archiveFileCreatetime").val();
				fileTime=fileTime.substr('0','4');
				$("#archiveFileAnual").val(fileTime)
			}
			function subForm(){
				//var image = $('#excelFile').get(0).files[0]; 
				var image =new FormData($("#fileForm")[0])
				image.append("CustomField", "This is some extra data");
				var archiveFileId=$("#archiveFileId").val();//获取文件主键
				var index=$("#page").val();//获取当前插入位置
				if(index!=""){
					$.ajax({  
			            url:'${pageContext.request.contextPath}/archiveFileStoreModify/havingIndex?archiveFileId='+archiveFileId+"&index="+index,  
			            type:'POST',  
			            data:image,  
			            async: false,    
			            cache: false,   
			            contentType: false, //不设置内容类型  
			            processData: false, //不处理数据  
			            success:function(data){
			                chang()
			            },  
			            error:function(){  
			            	layer.msg("上传失败！");  
			            }  
			        })  
				}else{
					$.ajax({  
			            url:'${pageContext.request.contextPath}/archiveFileStoreModify/lastIndex?archiveFileId='+archiveFileId,  
			            type:'POST',  
			            data:image,  
			            async: false,    
			            cache: false,   
			            contentType: false, //不设置内容类型  
			            processData: false, //不处理数据  
			            success:function(data){
			                chang()
			            },  
			            error:function(){  
			            	layer.msg("上传失败！");  
			            }  
			        })  
				}
			}
		</script>
	<script language="javascript" event="OnUploadBtnClick()" for="scaner1">
			var archiveFileId=$("#archiveFileId").val();//获取文件主键
			var index=$("#page").val();//获取当前插入位置
			if(index!=""){
				var havingIndex=document.getElementById("scaner1").uploadAllAsEachJpgToServerUrl("<%=app_url%>/archiveFileStoreModify/havingIndex?archiveFileId="+archiveFileId+"&index="+index+"","123456","desc");
				if('false'==havingIndex){
					layer.msg("上传图片失败，请检查系统")
				}else if('true'==havingIndex){
					var num=$("select").val();
					changePage(num)
					alert("上传成功")
				}
			}else{
				var noIndex=document.getElementById("scaner1").uploadAllAsEachJpgToServerUrl("<%=app_url%>/archiveFileStoreModify/lastIndex?archiveFileId="+archiveFileId+"","123456","desc");
				if('false'==noIndex){
					layer.msg("上传图片失败，请检查系统")
				}else if('true'==noIndex){
					var num=$("select").val();
					changePage(num)
					alert("上传成功")
				}
			}
			
		</script>
	<script type='text/javascript'>
   			document.getElementById('scaner1').loadLicenseData('http://<%=ip%>
		:8080/licserver/check.jsp');
	</script>
</body>

</html>