<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
	span{
		color: blue;
	}
	.page{
		border:1px #337ab7;
	}
	.page a{
		border: 1px #337ab7;
		width: 100px;
		height: 40px;
	}
	select{
		color: black;
	}
	.index{
		background-color: cccccc;
		color: white;
	}
</style>
  <span id="showPage">第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
  <span id="showRecord">总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
  <span id="showSubscript" class="page">
	<a href="javascript:void(0)" onclick="changePage(${1 })">[首页]</a>&nbsp;&nbsp;
	<a href="javascript:void(0)" <c:if test="${requestScope.pagemsg.currPage != 1}">onclick="changePage(${requestScope.pagemsg.currPage-1})"</c:if>>[上一页]</a>&nbsp;&nbsp;
	<c:if test="${requestScope.pagemsg.totalPage le 5}">
		<c:forEach begin="1" end="${requestScope.pagemsg.totalPage}" varStatus="status">
			<a href="javascript:void(0)" onclick="changePage(${status.count })" class="<c:if test="${pagemsg.currPage eq status.count }">index</c:if>">[ ${status.count } ]</a>
		</c:forEach>
	</c:if>
	
	<c:if test="${requestScope.pagemsg.totalPage gt 5}">
		<c:if test="${requestScope.pagemsg.totalPage-requestScope.pagemsg.currPage lt 5 }">
			<c:forEach begin="${requestScope.pagemsg.totalPage-4 }" end="${requestScope.pagemsg.totalPage }" varStatus="status">
				<a href="javascript:void(0)" onclick="changePage(${status.count+requestScope.pagemsg.totalPage-5 })" class="<c:if test="${pagemsg.currPage eq (status.count+requestScope.pagemsg.totalPage-5) }">index</c:if>">[ ${status.count+requestScope.pagemsg.totalPage-5 } ]</a>
			</c:forEach>
		</c:if>
		<c:if test="${requestScope.pagemsg.totalPage-requestScope.pagemsg.currPage ge 5 }">
			<c:forEach begin="${requestScope.pagemsg.currPage }" end="${requestScope.pagemsg.currPage+4 }" varStatus="status">
				<a href="javascript:void(0)" onclick="changePage(${status.count+requestScope.pagemsg.currPage-1 })" class="<c:if test="${pagemsg.currPage eq (status.count+requestScope.pagemsg.currPage-1) }">index</c:if>">[ ${status.count+requestScope.pagemsg.currPage-1 } ]</a>
			</c:forEach>
		</c:if>
	</c:if>
	<a href="javascript:void(0)" <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">onclick="changePage(${requestScope.pagemsg.currPage+1})"</c:if>>[下一页]</a>&nbsp;&nbsp;
	<select onchange="chang()" id="chang">
		<c:forEach begin="1" end="${requestScope.pagemsg.totalPage}" varStatus="status">
			<option value="${status.count}" <c:if test="${status.count eq requestScope.pagemsg.currPage}">selected</c:if>>${status.count}</option>
		</c:forEach>
	</select>
	<a href="javascript:void(0)" onclick="changePage(${requestScope.pagemsg.totalPage})">[尾页]</a>&nbsp;&nbsp;
 </span>


