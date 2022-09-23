$("#btnStadiumSave").click(()=>{

	let data = {
		name: $("#name").val()
	}
		$.ajax("/insertForm", {
		type: "POST",
		dataType: "json",
		data:JSON.stringify(data),
		headers:{
			"Content-Type":"application/json; charset=utf8"
		}
	}).done((res)=>{

		if(res.code == 1){
			alert("경기장이 생성되었습니다.");
			location.href="/";
		}else{
			alert("경기장 생성에 실패 했습니다.");
		}
	});

});