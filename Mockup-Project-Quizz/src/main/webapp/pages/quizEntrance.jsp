<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">

    <head>
        <title>quiz entrance</title>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="../css/global.css">
        <link rel="stylesheet" href= "../css/quizEntrance.css">
        <script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
    </head>

    <body>
        <header>
            <a href="#">
                <img class="logo" style="object-fit: scale-down; margin:5px 0px 10px 50px; height: 55px; width: 55px;" src="../images/logo.png" alt="Logo">
            </a>
            <a href="/logout" style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 30px 20px 0px; float: right;">Đăng xuất</a>
            <a href="/home" style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 20px 20px 0px; float: right;">Thông tin</a>
        </header>
        <section class="body">
            <div class="body-header">

            </div>
            <div class="body-body">
                <div class="alert">
                    <div class="alert-header">
                        <label>Làm bài kiểm tra</label>
                    </div>
                    <div class="alert-body">
                        <label>Bạn sẽ bắt đầu làm bài kiểm tra này </label>
                        <br>
                        <br>
                        <label>Điểm kiểm tra lần trước: </label>
                        <label>1000</label>
                        <br>
                        <br>
                        <button id="cancel" onclick="mainPage()">Hủy bỏ</button>
                        <button id="ok" onclick="quizPage(${test_id})">Xác nhận</button>
                    </div>
                </div>
            </div>
        </section>
    <script src="../lib/quizEntrance.js"></script>
    </body>