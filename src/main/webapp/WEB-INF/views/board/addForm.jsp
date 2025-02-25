<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>게시글 등록</h3>
<form action="addBoard.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" class="form-control"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="45" name="content" class="form-control"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" class="form-control" value="${loginId }" readonly></td>
		</tr>
		<tr>
		<th>이미지</th>
			<td><input type="file" name="img" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" class="btn btn-primary" value="등록">
			<input type="reset" class="btn btn-warning" value="취소">
			</td>
		</tr>
	</table>
</form>
