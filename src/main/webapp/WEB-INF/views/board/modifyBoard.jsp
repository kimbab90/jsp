<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<h3>게시글 수정</h3>
<form action="modifyBoard.do" method="post"  enctype="multipart/form-data">
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
			<td colspan="3"><input type="text" name="title"
				value="${board.title }" class=form-control></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea rows="3" cols="45" name="content"
					class="form-control">${board.content }</textarea></td>
		</tr>
		<c:if test="${board.img != null }">
		<tr>
			<th>이미지</th>
			<td><input type="file" name="img" class="form-control"></td>
		</tr>
		</c:if>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
			<th>작성일자</th>
			<td>${board.writeDate }</td>
		</tr>
		<tr>
		<td colspan="4" align="center">
			<button type="submit" class="btn btn-warning">수정</button>
			<button type="reset" class="btn btn-secondary">취소</button>
		</td>
		</tr>
	</table>
</form>
