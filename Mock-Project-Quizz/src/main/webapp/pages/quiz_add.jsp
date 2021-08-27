<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>

<head>
<title>Main</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/addQuiz.css">
<link rel="stylesheet" href="../css/global.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
<style>
input {
	height: 40px;
	width: 100%;
	padding: 0;
	position: relative;
	margin-bottom: 14px;
	border-radius: 35px;
	border-color: lightgray;
	display: inline-block;
	box-sizing: border-box;
}

input[type=submit] {
	height: 45px;
	background-color: #4f5466;
	color: white;
	margin: auto;
}
</style>
<script src="../lib/addQuiz.js"></script>
</head>
<body
	style="font-family: Arial, Helvetica, sans-serif; background-color: white">

	<header>
		<nav>
			<a href="/">
                <img class="logo" style="object-fit: scale-down; margin:5px 0px 10px 50px; height: 55px; width: 55px;" src="../images/logo.png" alt="Logo">
            </a>
			<a href="/logout" style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 20px 20px 0px; float: right;">Đăng xuất</a>
		</nav>
	</header>


	<section
		style="height: 876px; width: 1573px; min-width: 250px; margin: 50px auto; border: lightgray solid 2px; border-radius: 35px; overflow: auto;">
		<div
			style="background-color: #4F5466; font-size: 16px; color: white; height: 30px; padding: 25px; border-bottom: lightgray solid 1px; border-radius: 3px 3px 0 0;">
			<p style="margin: -10px 0px 0px 20px">
				<b>Tạo quiz</b>
			</p>
		</div>
		<form style="padding: 20px;" action="#">

			<p>Chủ đề</p>
			<textarea id="quiztopic" class="ansquiz"></textarea>

			<p>Tên quiz</p>
			<textarea id="quizname" class="ansquiz"></textarea>
			
			<p>Mô tả</p>
			<textarea id="quizdescription" class="ansquiz"></textarea>
			
			<div class="listquiz" id="listquiz">
				<fieldset id="ques1">
					<legend>Câu </legend>
					<div class=field>
						<div class="namefield">Câu hỏi</div>
						<div class="inputfield">
							<textarea id="questionquiz1" class="quesquiz"></textarea>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class=field>
						<div class="namefield">Câu trả lời 1</div>
						<div class="inputfield">
							<textarea id="ans11" class="ansquiz"></textarea>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class=field>
						<div class="namefield">Câu trả lời 2</div>
						<div class="inputfield">
							<textarea id="ans12" class="ansquiz"></textarea>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class=field>
						<div class="namefield">Câu trả lời 3</div>
						<div class="inputfield">
							<textarea id="ans13" class="ansquiz"></textarea>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class=field>
						<div class="namefield">Câu trả lời 4</div>
						<div class="inputfield">
							<textarea id="ans14" class="ansquiz"></textarea>
						</div>
						<div class="clearfix"></div>
					</div>

					<div class=field>
						<div class="namefield">Đáp án đúng</div>
						<div class="inputfield">
							<select name="rightanswer1" id="rightanswer1">
								<option value="1">Câu trả lời 1</option>
								<option value="2">Câu trả lời 2</option>
								<option value="3">Câu trả lời 3</option>
								<option value="4">Câu trả lời 4</option>
							</select>
						</div>
						<div class="clearfix"></div>
					</div>

					<div>
						<button type='button' id="1" class="floatright "
							onclick="deleteQuestion(this.id)">Xóa</button>
					</div>
				</fieldset>

			</div>
			<div>
				<input class="floatright submitbtn" type="submit" id="submitButton"
					value="Submit" onclick="addTest()">
				<button type='button' class="floatright addbtn"
					onclick="addQuestion()">Thêm câu hỏi</button>
				<br> <br>
			</div>
		</form>
	</section>

</body>
</html>