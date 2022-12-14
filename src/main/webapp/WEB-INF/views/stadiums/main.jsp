<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<br /> <br /><br>
	<input id="id" type="hidden" value="${id}" />
	<div class="d-flex justify-content-center">
		<h2 style="font-weight: bold">경기장 목록</h2>
	</div>

	<br /> <br />
	<table class="table table-striped text-center table-light table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>홈구장</th>
				<th>경기일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stadiums" items="${stadiumList}">
				<tr>
					<td>${stadiums.id}</td>
					<td>${stadiums.name}</td>
					<td>${stadiums.createDate}</td>
					<td><button onclick="deleteById(${stadiums.id})" class="btn btn-danger delete_btn" style="font-size:15px;
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
			$.ajax("/stadiums/"+id,{
				type: "DELETE",
				dataType: "json" // 응답 데이터
			}).done((res) => {
				if (res.code == 1) {
					alert("경기장 삭제 성공");
					location.href="/stadiums";
				} else {
					alert("경기장 삭제 실패");
				}
			});
		}


		
</script>


</div>

<%@ include file="../layout/footer.jsp"%>
