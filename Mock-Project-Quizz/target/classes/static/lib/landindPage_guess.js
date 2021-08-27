function DisplayQuizItem(item) {
	var contain = document.getElementById("container");
	contain.innerHTML = contain.innerHTML + '<div class = "card" id="card' + item.quizId + '"><div class = "imgwrapper">'
		+ ' <img src="' + test.quiz_image + '" class = "quizimg"></div>'
		+ '<div class = "quizinfo">'
		+ ' <div class = "quizinfofield">'
		+ '<p class ="quiztext"><b>Tên Quiz</b></p>'
		+ '<p class ="quiztext">' + test.quiz_name + '</p></div>'
		+ '<div class = "quizinfofield">'
		+ '<p class ="quiztext"><b>Chủ đề</b></p>'
		+ '<p class ="quiztext">' + test.quiz_topic + '</p></div>'
		+ '<div class = "quizinfofield">'
		+ '<p class ="quiztext"><b>Người đăng</b></p>'
		+ '<p class ="quiztext">' + test.Owner + '</p></div></div>'
		+ '<div ><button class = "doquizbtn">Làm quiz</button></div><div class = "clearfix"></div></div>';
}

var test = {
	"quiz_image": "../images/avatar.jpg", //image file in object
	"quiz_name": "Phân giải tổ hợp",
	"quiz_topic": "djhvhdfebr",
	"quizId": "CABD",
	"Owner": "NTD"
}
function loaditem() {
	DisplayQuizItem(test);
	const test1 = [test, test];
	test1.forEach(element => DisplayQuizItem(element));

}