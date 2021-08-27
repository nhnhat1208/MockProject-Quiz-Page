<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>

<html lang="en">
<head>
<title>quiz page</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/global.css">
<link rel="stylesheet" href="../css/quizPage.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
<script src="/lib/quizPage.js"></script>
</head>

<body
	style="margin: 0px; padding: 0px; width: auto; height: 1080px; max-width: 1920px; display: block;">
	<header
		style="width: auto; min-height: 70px; background-color: #4F5466; margin: 0px; padding: 0px; display: block;">
		<a href="/"> <img class="logo"
			style="object-fit: scale-down; margin: 5px 0px 10px 50px; height: 55px; width: 55px;"
			src="../images/logo.png" alt="Logo">
		</a> <a href="/logout"
			style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 30px 20px 0px; float: right;">Đăng
			xuất</a> 
	</header>
	<section class="body">
		<div class="body-header"></div>
		<div class="body-body">
			<div class="quiz">
				<div id="${quiz_id}" class="question">
					<label><b>Câu hỏi:</b>${question}</label>
				</div>
				<hr style="width: 80%">
				<div class="answer">
					<table>
						<body>
						<tr>
							<td><button class="A" id="A" onclick="answer(${test_id},this.id)">
									<div class="A">
										<div class="circle">
											<b>A</b>
										</div>
									</div>
									<div class="right">${answer[0]}</div>
								</button></td>
							<td><button class="B" id="B" onclick="answer(${test_id},this.id)">
									<div class="B">
										<div class="circle">
											<b>B</b>
										</div>
									</div>
									<div class="right">${answer[1]}</div>
								</button></td>
						</tr>
						<tr>
							<td><button class="C" id="C" onclick="answer(${test_id},this.id)">
									<div class="C">
										<div class="circle">
											<b>C</b>
										</div>
									</div>
									<div class="right">${answer[2]}</div>
								</button></td>
							<td><button class="D" id="D" onclick="answer(${test_id},this.id)">
									<div class="D">
										<div class="circle">
											<b>D</b>
										</div>
									</div>
									<div class="right">${answer[3]}</div>
								</button></td>
						</tr>
</body>
</table>
</div>
</div>
</div>
</section>
</body>