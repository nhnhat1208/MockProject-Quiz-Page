function answer(test_id, id) {
	var quiz_id = document.getElementsByClassName("question")[0].getAttribute("id");
	var ans = document.getElementById(id).children[1].textContent;
	
	$.ajax({
		type: "POST",
		url: "/answerQuestion",
		data: {
			"test_id": test_id,
			"quiz_id": quiz_id,
			"answer": ans,
		},
		success: function(data) {
			if (data == -1) {
				$(location).attr('href', '/quiz_entrance?test_id=' + test_id);
			}
			else {
				$(location).attr('href', '/quizpage' + data);
			}
		}
	});
}