<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>

<head>
<title>Add Quiz</title>
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
	<!--
				<header style="width: 100%;    height: 50px ;    min-height: 50px ;    background-color: #4f5466	;    vertical-align: middle;">


		        <p class="guess"style="color: white;  padding: 5px 10px 10px 10px; float: right; margin: 1% 10px auto auto;"  >
		        	<a href="login.html"style="color: white;">
		            ÄÄng nhÃ¢Ì£p
		            </a>
		        </p>
		        <p class="guess" style="color: white;  padding: 5px 10px 10px 10px; float: right; margin: 1% 10px auto auto;"  >
		        	<a href="signUp.html"style="color: white;">
		            ÄÄng kyÌ
		            </a>
		        </p>
		        <a href="main.html">
		        	<img id="icon" src="../img/logo.jpg" style="width: 100px;height:50px" />
				</a>
		    </header>
  -->


	<header>

		<Nav>
			<a href="#"> <img class="logo" src="../imgages/logo.jpg"
				alt="Logo"> <!-- image or something logo -->
			</a>
		</Nav>
		<p class="guess"
			style="color: white; padding: 5px 10px 10px 10px; float: right; margin: 10px -1105px auto 1050px;">
			<a href="quiz_add.html" style="color: white;"> Tạo Quiz </a>
		</p>
		<p class="guess"
			style="color: white; padding: 5px 10px 10px 10px; float: right; margin: 10px -1105px auto auto;">
			<a href="admin_info.html" style="color: white;"> Thông tin </a>
		</p>
		<p class="guess"
			style="color: white; padding: 5px 10px 10px 10px; float: right; margin: 10px 10px auto auto;">
			<a href="login.html" style="color: white;"> Đăng xuất </a>
		</p>
	</header>
	<img style="min-width: 100%" class="logo" src="../img/web_image.jpg"
		alt="Logo">


	<section
		style="height: 876px; width: 1080px; min-width: 250px; margin: 50px auto; border: lightgray solid 2px; border-radius: 35px; overflow: auto;">
		<div
			style="background-color: #4F5466; font-size: 16px; color: white; height: 30px; padding: 25px; border-bottom: lightgray solid 1px; border-radius: 3px 3px 0 0;">
			<p style="margin: -10px 0px 0px 20px">
				<b>Tạo quiz</b>
			</p>
		</div>
		<form id="quizform" style="padding: 20px;" action="#">

			<p>Chủ đề</p>
			<input style="padding: 10px" id="quiztopic" name="topic" placeholder="Topic"><br>

			<p>Tên quiz</p>
			<input style="padding: 10px" id="quizname" name="name" placeholder="Name">
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
					<div>
						<button id="1" class="floatright "
							onclick="deleteQuestion(this.id)">Xóa</button>
					</div>
				</fieldset>

			</div>
			<div>
				<input class="floatright submitbtn" type="submit" id="submitButton"
					value="Submit" onclick="addTest()">
				<button class="floatright addbtn" onclick="addQuestion()">Thêm
					câu hỏi</button>
				<br> <br>
			</div>
		</form>
	</section>





</body>
</html>









