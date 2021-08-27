<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<html lang="en">

<head>
<title>Trang chính</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script defer src="../lib/landingPage.js"></script>
<link rel="stylesheet" href="../css/global.css">
<link rel="stylesheet" href="../css/landingPage.css">

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
</head>
<body>

	<header>
		<a href="/"> <img class="logo"
			style="object-fit: scale-down; margin: 5px 0px 10px 50px; height: 55px; width: 55px;"
			src="../images/logo.png" alt="Logo">
		</a> <a href="/logout"
			style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 30px 20px 0px; float: right;">Đăng
			xuất</a> <a href="/home"
			style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 20px 20px 0px; float: right;">Thông
			tin</a>
	</header>


	<div class="container" id="container">
		<c:forEach items="${quizInfo}" var="test">
			<div class="card" id="${ test.id }">
			<div class="imgwrapper">
				<img src="../images/avatar.jpg" class="quizimg">
			</div>
			<div class="quizinfo">
				<div class="quizinfofield">
					<p class="quiztext">
						<b>Tên Quiz</b>
					</p>
					<p class="quiztext">${ test.description }</p>
				</div>
				<div class="quizinfofield">
					<p class="quiztext">
						<b>Chủ đề</b>
					</p>
					<p class="quiztext">${ test.name }</p>
				</div>
				<div class="quizinfofield">
					<p class="quiztext">
						<b>Người đăng</b>
					</p>
					<p class="quiztext">${ test.username }</p>
				</div>
			</div>
			<div>
				<button class="doquizbtn" onclick="doTest(${test.id})">Làm quiz</button>
			</div>
			<div class="clearfix"></div>
		</div>
		</c:forEach>

		
	</div>


</body>
</html>