<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3>게시글 상세</h3>
<form action="modifyForm.do" method="post">
	<input type="hidden" name="board_no" value="${board.boardNo }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo }</td>
			<th>조회수</th>
			<td>${board.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${board.content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
			<th>작성일자</th>
			<td>${board.writeDate }</td>
		</tr>
		<c:if test="${board.img != null }">
			<tr>
				<td colspan="4" align="center"><img src="images/${board.img }"
					class="img-thumbnail" style="width: 50%"></td>
			</tr>
		</c:if>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-warning">수정</button>
				<button type="button" class="btn btn-danger">삭제</button>
			</td>
		</tr>
		<c:if test="${msg != null }">
			<tr>
				<td colspan="4" align="center"><span
					class="text-danger fw-bold"> <c:out value="${msg }"></c:out>
				</span></td>
			</tr>
		</c:if>
	</table>
</form>
<h4>댓글</h4>

<style>
.reply .content ul {
	list-style-type: none;
}

.reply .content span {
	display: inline-block;
}
</style>

<div class="container reply">
	<div class="header" align="center">
	<input type="text" name="reply" class="form-control">
	<button type="button" class="btn btn-primary" onclick="addReply()">등록</button>
	</div>

	<div class="content">
	<ul>
	</ul>
	</div>
	
	<div class="footer">

	</div>

</div>

<script>
const loginId = '${loginId }';
const boardNo = '${board.boardNo }';
</script>
<script src="js/boardService.js"></script>
<script src="js/board.js"></script>