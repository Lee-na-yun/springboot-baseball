<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="height:640px">
	<br /> <br /><br>
	<div class="d-flex justify-content-center">
		<h3>경기장 목록</h3>
	</div>

	<br /> <br />
	<table class="table table-striped text-center table-danger table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>홈구장</th>
				<th>경기일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stadiums" items="${stadiumsList}">
				<tr>
					<td>${stadiums.id}</td>
					<td>${stadiums.name}</td>
					<td>${stadiums.createdAt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</div>

<%@ include file="../layout/footer.jsp"%>
