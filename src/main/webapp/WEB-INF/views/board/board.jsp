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
	<div class="header p-2" align="center">
		<input type="text" id="reply_input" name="reply"
			class="form-control mb-2">
		<button type="button" class="btn btn-primary" id="addRow">등록</button>
		<button type="button" class="btn btn-primary" id="deleteRow">삭제</button>
	</div>

	<table id="example" class="table table-striped" style="width: 100%">
		<thead>
			<tr>
				<th>댓글번호</th>
				<th>댓글내용</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>댓글번호</th>
				<th>댓글내용</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</tfoot>
	</table>

	<!-- 
	<div class="content">
		<ul class="list-group list-group-flush">
		<li class="list-group-item">
			<span class="col-sm-2">댓글번호</span>
			<span class="col-sm-5">댓글내용</span>
			<span class="col-sm-2">작성자</span>
			<span class="col-sm-2">삭제</span>
			</li>
		</ul>
	</div>

	<div class="footer">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center pagination-sm">
				<li class="page-item disabled"><a class="page-link">Prev</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
 -->
</div>

<link rel="stylesheet"
	href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css" />
<script>
	const loginId = '${loginId }';
	const boardNo = '${board.boardNo }';
</script>
<script src="js/boardService.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>
<script src="js/reply_dt.js"></script>
<!-- <script src="js/board.js"></script> -->