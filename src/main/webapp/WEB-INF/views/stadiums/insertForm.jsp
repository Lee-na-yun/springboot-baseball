<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="height:640px">
<br /> <br /><br>
	<div class="d-flex justify-content-center">
		<h3>경기장 등록</h3>
	</div>
	<br>
	<div class="d-flex justify-content-center">
	<div style="width: 600px;">
	<form class="d-flex" method="post" action="/stadiums" style="height:50px">
        <input class="form-control me-2" type="text" placeholder="홈구장 이름을 적어주세요." maxlength="20" name="name">
        <button class="btn btn-dark type" type="submit" style="width:100px">등록</button>
      </form>
      </div>
      </div>
<br /> <br />
</div>

<%@ include file="../layout/footer.jsp"%>