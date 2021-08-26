<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/global.css">
    <link rel="stylesheet" href="/css/admin_info.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Thông tin</title>
   
</head>

<body>
    <header>
            <a href="#">
                <img class="logo" style="object-fit: scale-down; margin:5px 0px 10px 50px; height: 55px; width: 55px;" src="../images/logo.png" alt="Logo">
            </a>
            <a href="/logout" style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 30px 20px 0px; float: right;">Đăng xuất</a>
            <a href="/add_quiz" style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 20px 20px 0px; float: right;">Tạo đề</a>
            <a href="/home" style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 20px 20px 0px; float: right;">Thông tin</a>
           
        </header>
    <div>
        <div class="userinfo">
            <div style="width: 100%; height: 300px; display: flex;justify-content: center;  align-items: center;  position:relative; margin-bottom: 20px;">
                <img id="avatar" src="../images/avatar.jpg" alt="" style="border-radius: 100%; width: 200px; height: 200px;">
                <span id="username" style="position:absolute; width:100%;  bottom:0; text-align:center; font-size: 25px; font-weight: 350; color: #4F5466;"></span>
            </div>
            <div style="margin-left: 50px;">   
                <div style="font-size: 25px; font-weight: 500; color: black; margin-bottom: 10px;">Thông tin</div>
                <div style="margin-left: 5px;">   
                    <div class="infoLabel">Ngày sinh: <span class="information" id="birthdate">${userInfo.dateBirth}</span></div>
                    <div class="infoLabel">Nghề nghiệp: <span class="information" id="job">${userInfo.job}</span></div>
                    <div class="infoLabel">Email: <span class="information" id="email">${userInfo.email}</span></div>
                </div>
                <div style="margin: 10px 0 0 5px;">   
                    <a href="">Chỉnh sửa thông tin cá nhân</a>
                </div>
            </div>
        </div>
        <div class="dashboard">
            <div id="history" style="width: 100; height: auto;">
                <div id="column" style="height: 55px;">
                    <div style="width: 50%; float:left">
                        <h1 style="margin:10px 0 0 0;">Quiz đã thêm</h1>
                    </div>

                </div>
                <div id="scrollVertical" style="height: auto; margin-top: 15px;">
					<c:forEach items="${quizInfo}" var="quiz">
						<div id="historyItem">
							<img src="../images/testimg.png" alt=""
								style="object-fit: cover; float: left;">
							<div style="float: left; margin-left: 15px; width: 50%;">
								<div>
									<h2 style="margin: 10px 0 15px 0;">${quiz.name}</h2>
								</div>
								<div style="height: 65px;">
									<p style="max-height: 50px; width: auto; margin-right: 20px;">${quiz.description}</p>
								</div>
							</div>
						</div>
	                </div>
					</c:forEach>
				</div>
            </div>
            
        </div>


    </div>
    <script src="../lib/admin_info.js"></script>
    <script>
        function GoQuiz(index) {
            console.log(index);
            $.ajax({
                type: "GET",
                url: "./quizEntrance.html?index=" + index,
                data: "quizId=" + index,
                success: function(msg){
                    window.open("./quizEntrance.html?index=" + index,"_self");
                }
            });
        }
    </script>
</body>

</html>










