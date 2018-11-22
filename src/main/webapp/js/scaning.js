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

function del() {
	$("button.del").on('click', function() {
		var othis = $(this);
		layer.open({
			content: '您确认删除图片？',
			btn: ['确认', '取消'],
			shadeClose: false,
			yes: function() {
				layer.open({
					content: '确认',
					time: 1
				});
				othis.parent('li').remove();
			},
			no: function() {
				layer.open({
					content: '您选择了取消',
					time: 1
				});
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