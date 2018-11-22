function pageLocal(data){
		$("#showPage").html("");//渲染分页
		$("#showRecord").html("");
		$("#showSubscript").empty();
		var indexBox="";
		indexBox=indexBox+""+
		" <span id='showPage'>第"+data.currPage+"/ "+data.totalPage+"页</span>&nbsp;&nbsp;"+
		" <span id='showRecord'>总记录数："+data.totalCount+"&nbsp;&nbsp;每页显示:"+data.pageSize+"</span>&nbsp;&nbsp;"+
		"<span id='showSubscript' class='page'>"+
		"<a href='javascript:void(0)' onclick='changePage(1)'>[首页]</a>&nbsp;&nbsp;"+
		"<a href='javascript:void(0)' "
		if(data.currPage!=1){
			indexBox=indexBox+"onclick='changePage("+(data.currPage-1)+")'"
		}
		indexBox=indexBox+">[上一页]</a>&nbsp;&nbsp;"
		if(data.totalPage<=5){
			for(var i=1;i<=data.totalPage;i++){
				indexBox=indexBox+"<a href='javascript:void(0)' onclick='changePage("+i+")' class='"
				if(data.currPage==i){
					indexBox=indexBox+"index"
				}
				indexBox=indexBox+"'>[ "+i+" ]</a>"
			}
		}
		if(data.totalPage>5){
			if((data.totalPage-data.currPage)<5){
				for(var i=(data.totalPage-4);i<=data.totalPage;i++){
					indexBox=indexBox+"<a href='javascript:void(0)' onclick='changePage("+i+")' class='"
					if(data.currPage==i){
						indexBox=indexBox+"index"
					}
					indexBox=indexBox+"'>[ "+i+" ]</a>"
				}
			}
			if((data.totalPage-data.currPage)>=5){
				for(var i=data.currPage;i<=(data.currPage+4);i++){
					indexBox=indexBox+"<a href='javascript:void(0)' onclick='changePage("+i+")' class='"
					if(data.currPage==i){
						indexBox=indexBox+"index"
					}
					indexBox=indexBox+"'>[ "+i+" ]</a>"
				}
			}
		}
		indexBox=indexBox+"<a href='javascript:void(0)'"
		if(data.currPage!=data.totalPage){
			indexBox=indexBox+"onclick='changePage("+(data.currPage+1)+")'"
		}
		indexBox=indexBox+">[下一页]</a>&nbsp;&nbsp;"+
							"<select onchange='chang()' id='chang'>"
		for(var i=1;i<=data.totalPage;i++){
			indexBox=indexBox+"<option value='"+i+"' "
			if(data.currPage==i){
				indexBox=indexBox+"selected"
			}
			indexBox=indexBox+">"+i+"</option>"
		}
		indexBox=indexBox+"</select>"
		indexBox=indexBox+"<a href='javascript:void(0)' onclick='changePage("+data.totalPage+")'>[尾页]</a>&nbsp;&nbsp;"+
		"</span>"
		
	return $("#showSubscript").append(indexBox);
}