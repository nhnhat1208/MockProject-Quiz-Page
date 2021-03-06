var idnew = 1;
function deleteQuestion(id) {
	var quesRemove = document.getElementById("ques" + id);
	quesRemove.remove();
}
function addQuestion() {
	idnew = idnew + 1;

	var listquiz = document.getElementById("listquiz");
	var newques = document.createElement("FIELDSET");
	newques.id = 'ques' + idnew;
	var option = "";
	for (var i = 1; i <= 4; i++) {
		option = option + "<div class = 'field'> \n";
		option = option + "<div class = 'namefield'>Câu trả lời " + i + "</div> \n";
		option = option + "<div class = 'inputfield' > <textarea id='ans" + idnew + "" + i + "' class = 'ansquiz'></textarea> </div>"
		option = option + "<div class = 'clearfix'></div> \n";
		option = option + "</div>";
	}
	newques.innerHTML = newques.innerHTML// +"<fieldset id ='ques"+idnew+"'>"
		+ "<legend>Câu </legend>"
		+ "<div class = 'field'>"
		+ "<div class = 'namefield'>Câu hỏi</div>"
		+ "<div class = 'inputfield'> <textarea id='questionquiz" + idnew + "' class = 'quesquiz'></textarea></div>"
		+ "<div class = 'clearfix'></div>"
		+ "</div>"
		+ option
		+ "<div class = field>"
		+ "<div class = 'namefield'>Đáp án đúng</div>"
		+ "<div class = 'inputfield'>"
		+ "<select name='rightanswer" + idnew + "' id='rightanswer" + idnew + "'>"
		+ "<option value=1>Câu trả lời 1</option>"
		+ "<option value=2>Câu trả lời 2</option>"
		+ "<option value=3>Câu trả lời 3</option>"
		+ "<option value=4>Câu trả lời 4</option>"
		+ "</select></div><div class = 'clearfix'></div></div>"
		+ "<div><button type='button' id='" + idnew + "'  class='floatright ' onclick='deleteQuestion(this.id)'>Xóa</button></div>";
	//+ "</fieldset>";
	newques.append();
	listquiz.appendChild(newques);
}

function addTest() {
	pushData();
}

function pushData() {
	var quizlist = {};
	var rightanswerlist = {};
	var quizlist_body = document.getElementById('listquiz');
	var quiz_amount = quizlist_body.childElementCount;

	for (var i = 0; i < quiz_amount; i++) {
		var e = document.getElementById("rightanswer" + (i + 1));
		var correctAnsw = e.options[e.selectedIndex].text;
		
		var data = {
			"question": quizlist_body.children[i].children[1].children[1].children[0].value,
			"correctAnsw": quizlist_body.children[i].children[2].children[1].children[0].value,
			"incorrectAnsw_1": quizlist_body.children[i].children[3].children[1].children[0].value,
			"incorrectAnsw_2": quizlist_body.children[i].children[4].children[1].children[0].value,
			"incorrectAnsw_3": quizlist_body.children[i].children[5].children[1].children[0].value,
		}
		quizlist[i] = data;
		rightanswerlist[i] = correctAnsw;
		//console.log(document.getElementById('quiztopic').value)
	}

	console.log(quizlist);

	$.ajax({
		type: "POST",
		url: "/addQuiz",
		data: {
			"topic": document.getElementById('quiztopic').value,
			"name": document.getElementById('quizname').value,
			"description": document.getElementById('quizdescription').value,
			"quizlist": JSON.stringify(quizlist),
			"rightanswerlist": JSON.stringify(rightanswerlist),
		},
		success: function(data) {
			if (data == 1) {
				alert('Thêm thành công');
				//$(location).attr('href', '/addQuiz');
			}
			else if (data == 0) {
				alert('Tên của test đã tồn tại');
			}
			else {
				alert('Thêm không thành công (Unknown ERROR)')
			}
		}
	});

}
