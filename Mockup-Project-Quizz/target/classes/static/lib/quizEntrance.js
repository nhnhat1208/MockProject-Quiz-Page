function mainPage() {
	window.location.href = "/home";
}
function quizPage(test_id) {
	$(location).attr('href', "/quizpage?test_id=" + test_id);
}