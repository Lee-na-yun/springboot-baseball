<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="height:65%">
<br /> <br /><br>
	<div class="d-flex justify-content-center">
		<h2 style="font-weight:bold">선수 등록</h2>
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
	        <input id="playerName"  type="text" placeholder="선수 이름을 적어주세요." maxlength="20" name="playerName" required>	   
      	</div>
      	<div class="stadiumSelect" >
		    <label for="positionName">포지션  </label>
	        <input id="positionName"  type="text" placeholder="포지션을 적어주세요." maxlength="20" name="positionName" required>	   
      	</div>
      	<div class="stadiumSelect" >
		    <label for="playerNum">등번호  </label>
	        <input id="playerNum"  type="text" placeholder="등번호를 적어주세요." maxlength="20" name="playerNum" required>	   
      	</div>

      <button id="btnPlayerInsert" class="btn btn-dark"  type="button"  >등록</button>
</form>	


      </div>
      </div>
<br /> <br />

<script>
$("#btnPlayerInsert").click(() => {
	playerSave();
});
	function playerSave(){
		let data = {
				teamId: $("#teamList").val(),
				name: $("#playerName").val(),
				position: $("#positionName").val(),
				playerNum: $("#playerNum").val()
		};
		
		$.ajax("/playerSaveForm", {
			type: "POST",
			dataType: "json", 
			data: JSON.stringify(data), 
			headers: {
				"Content-Type": "application/json"
			}
		}).done((res) => {
			if (res.code == 1) {
				alert("선수 등록 성공");
				location.href = "/playerList";
			} else {
				alert("선수 등록 실패");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>