         //退出登录
		function loginOut(){
			layer.confirm('您确定要退出系统吗?', {
	            btn : [ '确定', '取消' ]//按钮
	        }, function(index) {
	            layer.close(index);
	            //此处请求后台程序，下方是成功后的前台处理……
	            var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
	            window.location.href="../log/logout";
	        }); 
		}