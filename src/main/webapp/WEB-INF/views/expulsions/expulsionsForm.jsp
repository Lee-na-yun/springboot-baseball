<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="height:65%">
<br /> <br /><br>
	<div class="d-flex justify-content-center">
		<h2 style="font-weight:bold">퇴출 사유 등록</h2>
	</div>
	<br>
	<div class="d-flex justify-content-center" >
	<form>
		<div class="stadiumSelect">
			<label for="teamName">팀 이름  </label>
			<select id="teamList" name="teamName"  style="width:250px; height:34px;">
				<c:forEach var="teams" items="${teamList}">
     				<option value="${teams.id}">${teams.name}</option>
   				</c:forEach>
			</select>
		</div>

		<div class="stadiumSelect" >
	        <label for="playerName">선수 이름  </label>
			<select id="playerList" name="playerName"  style="width:250px; height:34px;">
				<c:forEach var="players" items="${playerList}">
     				<option value="${players.id}">${players.name}</option>
   				</c:forEach>
			</select>	   
      	</div>
      	<div class="stadiumSelect" >
		    <label for="reason">퇴출 사유  </label>
	        <input id="reason"  type="text" placeholder="퇴출사유를 적어주세요." maxlength="20" name="positionName" required>	   
      	</div>


      <button id="btnExpulsionsInsert" class="btn btn-dark"  type="button"  >등록</button>
</form>	


      </div>
      </div>
<br /> <br />

<script>
$("#btnExpulsionsInsert").click(() => {
	expulsionsSave();
});
	function expulsionsSave(){
		let data = {
				teamId: $("#teamList").val(),
				name: $("#playerList").val(),
				reason: $("#reason").val()
		};
		
		$.ajax("/explusionsForm", {
			type: "POST",
			dataType: "json", 
			data: JSON.stringify(data), 
			headers: {
				"Content-Type": "application/json"
			}
		}).done((res) => {
			if (res.code == 1) {
				alert("퇴출선수 등록 성공");
				location.href = "/explusionsList";
			} else {
				alert("퇴출선수 등록 실패");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>