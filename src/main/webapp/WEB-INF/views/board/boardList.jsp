<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="boardList.do" method=post>
	<div class="center">
		<div class="row">
			<div class="col-sm-2">
				<select name="search_condition" id="" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${searchCondition == "T" ? "selected" : ""}>제목</option>
					<option value="W" ${searchCondition == "W" ? "selected" : ""}>작성자</option>
					<option value="TW" ${searchCondition == "TW" ? "selected" : ""}>제목&작성자</option>
				</select>
			</div>
			<div class="col-sm-2">
				<input type="text" name="keyword" class="form-control" value="${keyword }">
			</div>
			<div class="col-sm-2">
				<input type="submit" value="조회" class="btn btn-primary">
			</div>
		</div>
	</div>
</form>

<table class="table table-hover table-striped">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.boardNo }</td>
				<td><a href="board.do?board_no=${board.boardNo }" class="nav-link">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.writeDate }</td>
				<td>${board.viewCnt }</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
<nav aria-label="...">
	<ul class="pagination">

		<c:choose>
			<c:when test="${paging.prev }">
				<li class="page-item"><a class="page-link" href="boardList.do?page_no=${paging.startPage - 1 }&search_condition=${searchCondition }&keyword=${keyword }"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${paging.currentPage == 1 }">
				<li class="page-item disabled"><span class="page-link">Start</span></li>
				<li class="page-item disabled"><span class="page-link">Previous</span></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="boardList.do?page_no=1&search_condition=${searchCondition }&keyword=${keyword }">Start</a></li>
				<li class="page-item"><a class="page-link" href="boardList.do?page_no=${paging.currentPage - 1 }&search_condition=${searchCondition }&keyword=${keyword }">Previous</a>
				</li>
			</c:otherwise>
		</c:choose>

		<c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }">
			<c:choose>
				<c:when test="${p == paging.currentPage }">
					<li class="page-item active" aria-current="page"><span class="page-link">${p }</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="boardList.do?page_no=${p }&search_condition=${searchCondition }&keyword=${keyword }">${p }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${paging.currentPage == paging.maxPage }">
				<li class="page-item disabled"><span class="page-link">Next</span>
				</li>
				<li class="page-item disabled"><span class="page-link">End</span>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="boardList.do?page_no=${paging.currentPage + 1 }&search_condition=${searchCondition }&keyword=${keyword }">Next</a></li>
				<li class="page-item"><a class="page-link" href="boardList.do?page_no=${paging.maxPage }&search_condition=${searchCondition }&keyword=${keyword }">End</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${paging.next }">
				<li class="page-item"><a class="page-link" href="boardList.do?page_no=${paging.endPage + 1 }&search_condition=${searchCondition }&keyword=${keyword }" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link" href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
			</c:otherwise>
		</c:choose>

	</ul>
</nav>