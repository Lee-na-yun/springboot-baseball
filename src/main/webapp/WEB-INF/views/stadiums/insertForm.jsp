<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
<br /> <br /><br>
	<div class="d-flex justify-content-center">
		<h2 style="font-weight:bold">경기장 등록</h2>
	</div>
	<br>
	<div class="d-flex justify-content-center">
	<div style="width: 600px;">
	<form class="d-flex" style="height:50px">
        <input class="form-control"  id="name" type="text" placeholder="홈구장 이름을 적어주세요." maxlength="20" name="name">
        <button id="btnStadiumSave" class="btn btn-dark type" type="button" style="width:100px">등록</button>
      </form>
      </div>
      </div>
<br /> <br />
</div>

<script src="/js/stadiums.js"></script>

<%@ include file="../layout/footer.jsp"%>