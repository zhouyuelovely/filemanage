$().ready(function() {
	var table = layui.table;
		//模版下载
		$("#downloadTemplate").bind("click",function() {
			window.location.href = "/filemanage/user/downloadTemplate?filename=YHMB.xlsx"
		});
		//关键词查询用户
		$("#userQueryCondition").click(function(){
			var conditions=$("#conditions").val();
			table.reload('demo', {
				  url:'/filemanage/user/queryUserByConditions',
				  where: { //设定异步数据接口的额外参数，任意设
					  conditions: conditions,
					  
				    //…
				  }
				  ,page: {
				    curr: 1 //重新从第 1 页开始
				  }
				});
			console.log(conditions);
			
			
			
		});
 });




