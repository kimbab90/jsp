<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>회원등록</h3>
<table class="table">
	<thead>
	</thead>
	<tbody>
		<tr>
			<th>ID</th>
			<td><input type="text" name="member_id" id="member_id"
				class="form-control"></td>
		</tr>
		<tr>
			<th>PWD</th>
			<td><input type="text" name="passwd" id="passwd"
				class="form-control"></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="member_name" id="member_name"
				class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" onclick="addMember()" class="btn btn-primary">추가</button>
			</td>
		</tr>
	</tbody>
</table>

<h3>회원목록</h3>
<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>PWD</th>
			<th>NAME</th>
			<th>RESPONSIBILITY</th>
			<th>REMOVE</th>
		</tr>
	</thead>
	<tbody id="list">



	</tbody>
</table>

<script src="js/member.js"></script>