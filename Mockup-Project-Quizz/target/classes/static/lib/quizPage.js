function answer(id) {
	var quiz_id = document.getElementsByClassName("question")[0].getAttribute("id");
	var ans = document.getElementById(id).children[1].textContent;
	
	$.ajax({
		type: "POST",
		url: "/answerQuestion",
		data: {
			"quiz_id": quiz_id,
			"answer": ans,
		},
		success: function(data) {
			if (data == -1) {
				$(location).attr('href', '/quiz_entrance');
			}
			else {
				$(location).attr('href', '/quizpage?quiz_id=' + data);
			}
		}
	});
}