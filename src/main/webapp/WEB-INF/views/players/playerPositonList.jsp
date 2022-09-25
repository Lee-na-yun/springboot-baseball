<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="height: 70%">
	<br /> <br />
	<br> <input id="id" type="hidden" value="${id}" />
	<div class="d-flex justify-content-center">
		<h2 style="font-weight: bold">팀별 포지션 목록</h2>
	</div>

	<br /> <br />
	<table class="table table-striped text-center table-light table-hover">
		<thead>
			<tr>
				<th>포지션</th>
				<th>롯데자이언츠</th>
				<th>LG트윈스</th>
				<th>키움히어로즈</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="players" items="${playerList2}">
				<tr>
					<td>${players.position}</td>
					<td>${players.group1}</td>
					<td>${players.group2}</td>
					<td>${players.group3}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	
	

</div>

<%@ include file="../layout/footer.jsp"%>
