<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://com.zm" prefix="zm"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>综合利用查询系统_档案信息门户信息发布</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<!--导航公共样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archives-collection.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archivalfabu.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/medire/WdatePicker.js"></script>
		
	</head>
	<style>
		.form_top{
			padding:8px 0;
		}
		
	</style>
	<body class="layui-layout-body">
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
						<a href="${pageContext.request.contextPath}/information/godigitalarchives" style="color: #EA5519;">综合利用查询系统</a>
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
								<a href="${pageContext.request.contextPath}/AdviceMapperController/modelAndView">交流中心</a>
								</c:if>
							</li>
							<li>
							<c:if test="${zm:buttenPremission('ld',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/readingRoom/publicArchiveShow">电子阅览室</a>
								</c:if>
							</li>
							<li>
							<c:if test="${zm:buttenPremission('lh',sessionScope.user.role.authorities) }">
								<a href="${pageContext.request.contextPath}/information/goarchivalInformation" class="a1">档案信息门户</a>
							</c:if>
							</li>
						</ul>
					</div>
					<div class="layui-row" style="margin: 0px 15px;">
						<div class="layui-col-md12" style="padding: 15px;background: #FFFFFF;border-radius: 10px;box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .1);">
							<div style="float: left;">
								<span style="line-height: 20px;padding-left: 10px;">
						 			<i class="fa fa-step-forward font_color"></i>
						 			<span class="font_color"><a href="${pageContext.request.contextPath}/information/goarchivalInformation" style="cursor:pointer;">信息列表</a>&nbsp;&gt;&gt;&nbsp;</span><span>信息发布</span>
								</span>
							</div>
							<div style="border: 1px solid #EA5519;clear: both;">
								<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
									<ul class="layui-tab-title">
										<li>图片轮播区</li>
										<li class="layui-this">信息公示区</li>
									</ul>
									<div class="layui-tab-content" style="padding:0 50px;">
									     
										<div class="layui-tab-item">
										   <form   id="uploadFileForm"  method="post" enctype="multipart/form-data" >
											<table class="table layui-table">
												<thead>
													<tr>
														<th style="text-align: center;">图片序号</th>
														<th style="text-align: center;">图片地址</th>
														<th style="text-align: center;">链接地址</th>
														<th style="text-align: center;">操作</th>
													</tr>
												</thead>
												<tbody id="tab">
												   
													<tr>
													    
														<td>1</td>
														<td><input type="file" name="file"    placeholder="" id="aa" autocomplete="off" class="layui-input" style="float: left;width: 70%;" />
														</td>
														<td width="25%"><input type="text" name="PcUrlOne" id="bb" placeholder="" autocomplete="off" class="layui-input"/></td>
														<td width="25%">
															<i class="fa fa-long-arrow-up" onclick="moveUp(this)"></i>
															<i class="fa fa-long-arrow-down" onclick="moveDown(this)"></i>
														</td>
													</tr>
													
													<tr>
														<td>2</td>
														<td><input type="file" name="file"   placeholder="" id="cc" autocomplete="off" class="layui-input" style="float: left;width: 70%;" />
														</td>
														<td><input type="text" name="PcUrlTwo"  placeholder=""  id="dd" autocomplete="off" class="layui-input"/></td>
														<td>
															<i class="fa fa-long-arrow-up" onclick="moveUp(this)"></i>
															<i class="fa fa-long-arrow-down" onclick="moveDown(this)"></i>
														</td>
													</tr>
													<tr>
														<td>3</td>
														<td><input type="file" name="file"    placeholder="" id="ee" autocomplete="off" class="layui-input" style="float: left;width: 70%;" />
														</td>
														<td><input type="text" name="PcUrlThree"  placeholder="" id="ff" autocomplete="off" class="layui-input"/></td>
														<td>
															<i class="fa fa-long-arrow-up" onclick="moveUp(this)"></i>
															<i class="fa fa-long-arrow-down" onclick="moveDown(this)"></i>
														</td>
													</tr>
													<tr>
														<td>4</td>
														<td><input type="file" name="file"    placeholder="" id="gg" autocomplete="off" class="layui-input" style="float: left;width: 70%;" />
														</td>
														<td><input type="text" name="PcUrlFour"  placeholder="" id="hh" autocomplete="off" class="layui-input"/></td>
														<td>
															<i class="fa fa-long-arrow-up" onclick="moveUp(this)"></i>
															<i class="fa fa-long-arrow-down" onclick="moveDown(this)"></i>
														</td>
													</tr>
													<tr>
														<td>5</td>
														<td><input type="file" name="file"  placeholder="" id="ii" autocomplete="off" class="layui-input" style="float: left;width: 70%;" />
														</td>
														<td><input type="text" name="PcUrlFive"  placeholder="" id="jj" autocomplete="off" class="layui-input"/></td>
														<td>
															<i class="fa fa-long-arrow-up" onclick="moveUp(this)"></i>
															<i class="fa fa-long-arrow-down" onclick="moveDown(this)"></i>
														</td>
													</tr>
												</tbody>
											</table>
											<div class="form_top" style="text-align: right;">
											<c:if test="${zm:buttenPremission('lfa',sessionScope.user.role.authorities) }">
												 <button type="button" class="layui-btn" id="fileBtn">发布</button>
												</c:if>
												<!-- <input type="submit" value="发布"/> -->
											</div>
											</form>
											
											
										</div>
										<div class="layui-tab-item layui-show">
											<!--信息发布区域-->

											<form class="layui-form"  id="inforForm" onsubmit="return false"  style="width:70%;margin: 0 auto;text-align: left;" method="post">
												<div class="form_top">
													<div class="layui-inline">
														<label class="layui-form-label">索引号</label>
														<div class="layui-input-inline">
															<input type="text" name="iPIndexNum" id="iPIndexNum"  placeholder="请输入索引号" autocomplete="off" class="layui-input">
														</div>
													</div>
													<div class="layui-inline">
														<label class="layui-form-label">信息类型</label>
														<div class="layui-input-block">
															<select name="iPType" lay-verify="required" id="iPType">
																<option value="">请选择</option>
																 <option value="通知公告">通知公告</option>
																 <option value="工作动态">工作动态</option>
																 <option value="政务公开">政务公开</option>
																 <option value="档案法规">档案法规</option>
																 <option value="档案文化">档案文化</option>
															</select>
														</div>
													</div>
													<div class="layui-inline">
														<label class="layui-form-label">文号</label>
														<div class="layui-input-inline">
															<input type="text" name="iPDocumentNum"  id="iPDocumentNum"  placeholder="请输入文号" autocomplete="off" class="layui-input">
														</div>
													</div>
												</div>
												<div class="form_top">
													<div class="layui-inline">
														<label class="layui-form-label">信息有效性</label>
														<div class="layui-input-block">
															<input type="radio" name="iPTimealness" value="长期有效" title="长期有效" lay-filter="test1">
															<input type="radio" name="iPTimealness" value="30天有效" title="30天有效"  lay-filter="test1">
														</div>
													</div>
													<div class="layui-inline">
														<label class="layui-form-label">发布形式</label>
														<div class="layui-input-block">
															<input type="radio" name="iPForm" value="直接发布" title="直接发布" lay-filter="test2">
															<input type="radio" name="iPForm" value="定期发布" title="定期发布" lay-filter="test2">
														</div>
													</div>
													
													 <div class="layui-inline" >
														<label class="layui-form-label">发布日期</label>
														<div class="layui-input-inline">
															<input onClick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
															type="text" name="iPFormDate" id="iPFormDate"  placeholder="请选择发布日期" autocomplete="off" class="layui-input" readonly="readonly">
														</div>
													</div>
												</div>
												<div class="form_top">
													<div class="layui-inline" style="width: 60%;">
														<label class="layui-form-label">信息名称</label>
														<div class="layui-input-block">
															<input type="text" name="iPName" id="iPName"  placeholder="请输入信息名称" autocomplete="off" class="layui-input">
														</div>
													</div>
													<div class="layui-inline">
														<label class="layui-form-label">主题词</label>
														<div class="layui-input-block">
															<input type="text" name="subjectHeadings" id="subjectHeadings"  placeholder="请输入主题词" autocomplete="off" class="layui-input">
														</div>
													</div>
												</div>
												<div class="form_top">
													<div class="layui-inline" style="width: 60%;">
														<label class="layui-form-label">信息内容</label>
														<div class="layui-input-block">
														<textarea  id="container" name="iPContent" type="text/plain" ></textarea>
														</div>
													</div>
												</div>
												<div class="form_top" style="text-align: right;">
												<c:if test="${zm:buttenPremission('lhb',sessionScope.user.role.authorities) }">
													<button type="button" class="layui-btn" id="infoBtn">发布</button>
												</c:if>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						
					</div>
					<script type="text/html" id="barDemo">
						<!-- 这里同样支持 laytpl 语法，如： -->
						<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
					</script>
				</div>
			</div>
		</div>
		<!-- 辅助元素，一般用于移动设备下遮罩 -->
		<div class="layadmin-body-shade" layadmin-event="shade"></div>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/layui/lay/modules/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!--富文本编辑器-->
		<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript">
			layui.use('form', function() {
				var form = layui.form;
				form.on('radio(test1)', function(data) {
					console.log(data.value); //被点击的radio的value值
					if(data.value=="30天有效"){
						layer.msg("该条信息将会在30天后自动删除");
					}
				});
				form.render(); //更新全部
				
				
			});
			
			layui.use('form', function() {
				var form = layui.form;
				form.on('radio(test2)', function(data) {
					console.log(data.value); //被点击的radio的value值
					if(data.value=="定期发布"){
						layer.msg("请选择发布日期");
						 document.getElementById("iPFormDate").value="";
					}else if(data.value=="直接发布"){
						var date=new Date();
				    	 var year=date.getFullYear(); //获取当前年份
				    	var mon=date.getMonth()+1; //获取当前月份
				    	var da=date.getDate(); //获取当前日
				    	var hours = date.getHours();//获取当前小时
				    	 var minutes = date.getMinutes();//获取当前分钟
				    	 var secondons=date.getSeconds();//获取当前秒数
				    	 if(da<10){
				    		 da="0"+da;
				    	 }else if(mon<10){
				    		 mon="0"+mon;
				    	 }else if(hours<10){
				    		 hours="0"+hours;
				    	 }else if(minutes<10){
				    		 minutes="0"+minutes;
				    	 }else if(secondons<10){
				    		 secondons="0"+secondons;
				    	 }
				    	var mytime=year+"-"+mon+"-"+da +" "+ hours + ":" + minutes + ":" + secondons;
				    	 document.getElementById("iPFormDate").value=mytime;
					}
				});
				
				form.render(); //更新全部
				
				
			});
			
			
			
			//信息发布点击事件
         	$("#infoBtn").click(function(){
         		var iPIndexNum=$("#iPIndexNum").val();
         		var iPType=$("#iPType").val();
         		var iPDocumentNum=$("#iPDocumentNum").val();
         		var iPTimealness=$("input[name='iPTimealness']:checked").val();
         		var iPForm=$("input[name='iPForm']:checked").val();
         		var iPFormDate=$("#iPFormDate").val();
         		var iPName=$("#iPName").val();
         		var subjectHeadings=$("#subjectHeadings").val();
         		var iPContent=UE.getEditor('container').getContent();
         		if($.trim(iPIndexNum)==""||$.trim(iPIndexNum)==null){
         			layer.msg("请输入索引号");
         		}else if(iPType==null || iPType==""){
         			layer.msg("请选择信息类型");
         		}else if($.trim(iPDocumentNum)==""||$.trim(iPDocumentNum)==null){
         			layer.msg("请输入文号");
         		}else if(iPTimealness==null || iPTimealness==""){
         			layer.msg("请选择信息有效性");
         		}else if(iPForm==null || iPForm==""){
         			layer.msg("请选择发布形式");

         		}else if(iPForm=="定期发布"&&iPFormDate==""){
         			layer.msg("请选择发布日期");
         			return false;
         		}else if($.trim(iPName)==""||$.trim(iPName)==null){
         			layer.msg("请输入信息名称");
         		}else if($.trim(subjectHeadings)==""||$.trim(subjectHeadings)==null){
         			layer.msg("请输入主题词");
         		}else if($.trim(iPContent)==""||$.trim(iPContent)==null){
         			layer.msg("请输入信息内容");
         		}else{
         			if(iPForm=="直接发布"){
         				 $.ajax({
             				url:"${pageContext.request.contextPath}/information/addInformation"+"?timestamp="+Math.random(),
             				type:"post",
             				beforeSend :function(xmlHttp){ 
    					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
    					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
    					     },
    						dataType:"json",
    						async:false,
    						data:$("#inforForm").serialize(),
    						success:function(result){
    							console.log(result);
    							if(result==1){
    								layer.msg("对不起,索引号已存在");
    							}else if(result==2){
    								layer.msg("对不起,文号已存在");
    							}else if(result==3){
    								layer.msg("恭喜你,信息发布成功!",{offset:'auto',time:1500},function(){
    									window.location.href="${pageContext.request.contextPath}/information/goarchivalInformation";
    								}) 
    							}else{
    								layer.msg("对不起,信息发布失败!");
    							}
    						},
             			});
         			}else if(iPForm=="定期发布"){
         				$.ajax({
             				url:"${pageContext.request.contextPath}/information/insertInformation"+"?timestamp="+Math.random(),
             				type:"post",
             				beforeSend :function(xmlHttp){ 
    					        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
    					        xmlHttp.setRequestHeader("Cache-Control","no-cache");
    					     },
    						dataType:"json",
    						async:false,
    						data:$("#inforForm").serialize(),
    						success:function(result){
    							console.log(result);
    							 if(result==1){
    								layer.msg("恭喜你,该信息将会在你指定时间自动发布",{offset:'auto',time:3000},function(){
    									window.location.href="${pageContext.request.contextPath}/information/goarchivalInformation";
    								}) 
    							}else{
    								layer.msg("对不起,信息发布失败!");
    							}
    						},
             			});
         			}
         			
         		}
         	})

			function moveUp(_a) {
				var _row = _a.parentNode.parentNode;
				//如果不是第一行，则与上一行交换顺序  
				var _node = _row.previousSibling;
				while(_node && _node.nodeType != 1) {
					_node = _node.previousSibling;
				}
				if(_node) {
					swapNode(_row, _node);
				}
			}

			function moveDown(_a) {
				var _row = _a.parentNode.parentNode;
				//如果不是最后一行，则与下一行交换顺序
				var _node = _row.nextSibling;
				while(_node && _node.nodeType != 1) {
					_node = _node.nextSibling;
				}
				if(_node) {
					swapNode(_row, _node);
				}
			}

			function swapNode(node1, node2) {
				//获取父结点 
				var _parent = node1.parentNode;
				//获取两个结点的相对位置 
				var _t1 = node1.nextSibling;
				var _t2 = node2.nextSibling;
				//将node2插入到原来node1的位置 
				if(_t1) _parent.insertBefore(node2, _t1);
				else _parent.appendChild(node2);
				//将node1插入到原来node2的位置 
				if(_t2) _parent.insertBefore(node1, _t2);
				else _parent.appendChild(node1);
			}
			
			 var editor = new baidu.editor.ui.Editor({initialFrameHeight:240,initialFrameWidth:1000,autoHeightEnabled: false,});
         	editor.render('container'); 
         	
         	//正则表达式校验网址
         	function checkUrl(urlString){
				var reg=/(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;
			    return reg.test(urlString); 
		  }
         	 //图片轮播发布点击事件
         	$().ready(function(){
         		$("#fileBtn").click(function(){
             		var PcUrlOne=$("#bb").val();
             		var PcUrlTwo=$("#dd").val();
             		var PcUrlThree=$("#ff").val();
             		var PcUrlFour=$("#hh").val();
             		var PcUrlFive=$("#jj").val();
             		var file1=$("#aa").val();
             		var file2=$("#cc").val();
             		var file3=$("#ee").val();
             		var file4=$("#gg").val();
             		var file5=$("#ii").val();
             		var formData= new FormData($( "#uploadFileForm" )[0]);
             		if(file1==""||file1==null){
             			layer.msg("请上传图片");
             			return false;
             		}else if(file2==""||file2==null){
             			layer.msg("请上传图片");
             			return false;
             		}else if(file3==""||file3==null){
             			layer.msg("请上传图片");
             			return false;
             		}else if(file4==""||file4==null){
             			layer.msg("请上传图片");
             			return false;
             		}else if(file5==""||file5==null){
             			layer.msg("请上传图片");
             			return false;
             		}else if($.trim(PcUrlOne).length == 0){
             			layer.msg("链接地址没有输入,请输入");
             			return false;
             		}else if($.trim(PcUrlTwo).length == 0){
             			layer.msg("链接地址没有输入,请输入");
             			return false;
             		}else if($.trim(PcUrlThree).length == 0){
                 			layer.msg("链接地址没有输入,请输入");
                 			return false;	
             		}else if($.trim(PcUrlFour).length == 0){
             			layer.msg("链接地址没有输入,请输入");
             			return false;
             		}else if($.trim(PcUrlFive).length == 0){
             			layer.msg("链接地址没有输入,请输入");
             			return false;
             		}else if(checkUrl($.trim(PcUrlOne)) == false){
             			layer.msg("网址输入有误,请正确输入");
             			return false;
             		}else if(checkUrl($.trim(PcUrlTwo)) == false){
             			layer.msg("网址输入有误,请正确输入");
             			return false;
             		}else if(checkUrl($.trim(PcUrlThree)) == false){
             			layer.msg("网址输入有误,请正确输入");
             			return false;
             		}else if(checkUrl($.trim(PcUrlFour)) == false){
             			layer.msg("网址输入有误,请正确输入");
             			return false;
             		}else if(checkUrl($.trim(PcUrlFive)) == false){
             			layer.msg("网址输入有误,请正确输入");
             			return false;
             		}else{ 
             			var countAllPic=${countAllPic};
             			//第一行第三列
             			var bb;
             			//第二行第三列
             			var dd;
             			//第三行第三列
             			var ff;
             			//第四行第三列
             			var hh;
             			//第五行第三列
             			var jj;
             			formData.append('bb', $("#tab")[0].children[0].children[2].children[0].value);
             			formData.append('dd', $("#tab")[0].children[1].children[2].children[0].value);
             			formData.append('ff', $("#tab")[0].children[2].children[2].children[0].value);
             			formData.append('hh', $("#tab")[0].children[3].children[2].children[0].value);
             			formData.append('jj', $("#tab")[0].children[4].children[2].children[0].value);
             				$.ajax({
                 				url:"${pageContext.request.contextPath}/information/uploadFile"+"?timestamp="+Math.random(),
                 				type: 'post', 
                 				beforeSend :function(xmlHttp){ 
    						        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
    						        xmlHttp.setRequestHeader("Cache-Control","no-cache");
    						     },
                 				dataType:'json',
                 				data: formData,  
                                cache: false,  
                                processData: false,  
                                contentType: false,
                                success:function(data){
                                	console.log(data);
                                	if(data==true){
                                		layer.msg("图片上传成功",{offset:'auto',time:1500},function(){
                                		window.location.href="${pageContext.request.contextPath}/information/goarchivalInformation";
      								}) 
                                }else{
                                	layer.msg("图片上传失败!");
                                }
                                	 
                              },
                                error:function(){
                                	layer.msg("图片上传异常");
                                }
                 			});
             		   } 
	
             	});
         	});
         	
         	

         	

		</script>
		
	</body>

</html>