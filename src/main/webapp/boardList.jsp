<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="com.yedam.vo.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<table border="2">
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
			<%
			List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");

			for (BoardVO board : list) {
			%>
			<tr>
				<td><%=board.getBoardNo()%></td>
				<td><%=board.getTitle()%></td>
				<td><%=board.getWriter()%></td>
				<td><%=board.getWriteDate()%></td>
				<td><%=board.getViewCnt()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>