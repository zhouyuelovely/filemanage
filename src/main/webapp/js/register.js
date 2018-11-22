
var falg = false

	function checkbox() {
		var checkbox = document.getElementById('regText');
		if(checkbox.checked) {
			//选中状态
			$("#regBtn").removeClass("layui-btn-disabled")

		} else {
			//没有勾选	
			$("#regBtn").addClass("layui-btn-disabled");
		}
	}
	$(".bottomBox").click(function() {
		if(falg) {
			falg = false
			checkbox()
		} else {
			falg = true
			checkbox()
		}

	})

