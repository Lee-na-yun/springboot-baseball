<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="height: 70%">
	<br /> <br />
	<br> <input id="id" type="hidden" value="${id}" />
	<div class="d-flex justify-content-center">
		<h2 style="font-weight: bold">퇴출선수 목록</h2>
	</div>

	<br /> <br />
	<table class="table table-striped text-center table-light table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀이름</th>
				<th>선수이름</th>
				<th>포지션</th>
				<th>사유</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expulsions" items="${expulsionsList}">
				<tr>
					<td>${expulsions.no}</td>
					<td>${expulsions.teamname}</td>
					<td>${expulsions.name}</td>
					<td>${expulsions.position}</td>
					<td>${expulsions.reason}</td>
					<td>${expulsions.createDate}</td>
					<td><button onclick="deleteById(${expulsions.id})" class="btn btn-danger" style="font-size:15px;
	padding:2px 8px;">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="d-flex justify-content-end">
		<button type="button" id="btnDeleteSelect" class="btn btn-dark" name="checkdelete" value="1">선택삭제</button>
	</div>
	
	<script>
		function deleteById(id) {		
			$.ajax("/expulsionsList/"+id,{
				type: "DELETE",
				dataType: "json" // 응답 데이터
			}).done((res) => {
				if (res.code == 1) {
					alert("퇴출선수 삭제 성공");
					location.reload();
				} else {
					alert("퇴출선수 삭제 실패");
				}
			});
		}


</script>

</div>

<%@ include file="../layout/footer.jsp"%>
