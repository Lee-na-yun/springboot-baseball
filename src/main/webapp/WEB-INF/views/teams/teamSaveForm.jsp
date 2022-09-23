<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="height:65%">
<br /> <br /><br>
	<div class="d-flex justify-content-center">
		<h2 style="font-weight:bold">팀 등록</h2>
	</div>
	<br>
	<div class="d-flex justify-content-center" >
	<form>
		<div class="stadiumSelect">
			<label for="stadiumName">야구장 이름  </label>
			<select id="stadiumsList" name="stadiumName"  style="width:250px; height:34px;">
				<c:forEach var="stadiums" items="${stadiumsList}">
     				<option value="${stadiums.id}">${stadiums.name}</option>
   				</c:forEach>
			</select>
		</div>

		<div class="stadiumSelect" >
		    <label for="teamName">팀 이름  </label>
	        <input id="teamName"  type="text" placeholder="팀 이름을 적어주세요." maxlength="20" name="teamName" required>	   
      </div>

      <button id="btnTeamInsert" class="btn btn-dark"  type="button"  >등록</button>
</form>	


      </div>
      </div>
<br /> <br />

<script>
$("#btnTeamInsert").click(() => {
	teamSave();
});
	function teamSave(){
		let data = {
				stadiumId: $("#stadiumsList").val(),
				name: $("#teamName").val()
		//let data = $("#fst").serialize();
		};
		$.ajax("/teamSaveForm", {
			type: "POST",
			dataType: "json", 
			data: JSON.stringify(data), 
			headers: {
				"Content-Type": "application/json"
			}
		}).done((res) => {
			if (res.code == 1) {
				alert("팀 등록 성공");
				location.href = "/teamList";
			} else {
				alert("팀 등록 실패");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>