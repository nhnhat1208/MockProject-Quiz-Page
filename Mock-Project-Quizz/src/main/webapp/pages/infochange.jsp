<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thay đổi thông tin</title>
    <link rel="stylesheet" href="../css/signUp.css">
    <link rel="stylesheet" href="../css/global.css">
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
</head>

<body>
    <header>
            <a href="/">
                <img class="logo" style="object-fit: scale-down; margin:5px 0px 10px 50px; height: 55px; width: 55px;" src="../images/logo.png" alt="Logo">
            </a>
            <a href="/logout" style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 30px 20px 0px; float: right;">Đăng xuất</a>
            <a href="/home" style="color: white; text-decoration: none; font-size: 20pt; margin: 20px 20px 20px 0px; float: right;">Thông tin</a>
        </header>
    <div class="signUp">
        <div id="bannerForm">
            Chỉnh sửa thông tin cá nhân
        </div>
        <div id="signUpForm">
            <form id="theform" method="post" style="margin-left: 10%;" onsubmit="changeInfo()">
                <div class="row">
                    <div class="colTitle">
                        <label for="lname">Mật khẩu</label>
                    </div>
                    <div class="colInput">
                        <input type="password" id="password" name="password" required>
                        <span id='message'></span>
                    </div>
                </div>
                <div class="row">
                    <div class="colTitle">
                        <label for="lname">Nhập mật khẩu mới</label>
                    </div>
                    <div class="colInput">
                        <input type="password" id="newpassword" name="newpassword" onkeyup="check();">
                        <span id='message'></span>
                    </div>
                </div>
                 <div class="row">
                    <div class="colTitle">
                        <label for="lname">Nhập lại mật khẩu</label>
                    </div>
                    <div class="colInput">
                        <input type="password" id="repassword" name="repassword" onkeyup="check();">
                        <span id='message'></span>
                    </div>
                </div>
                <div class="row">
                    <div class="colTitle">
                        <label for="lname">Địa chỉ email</label>
                    </div>
                    <div class="colInput">
                        <input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" id="email" name="email">
                    </div>
                </div>
                <div class="row">
                    <div class="colTitle">
                        <label for="lname">Nghề nghiệp</label>
                    </div>
                    <div class="colInput">
                        <input type="text" id="job" name="job" >
                    </div>
                </div>
                <div class="row">
                    <div class="colTitle">
                        <label for="fname">Ngày sinh</label>
                    </div>
                    <div class="colInput" style="padding: 0;" >
                        <input type="date" id="birthday" name="birthday" style="border: 0px solid;" required>
                    </div>
                </div>
                <div class="row">
                    <div class="colTitle">
                        <label for="img">Ảnh đại diện</label>
                    </div>
                    <div class="colInput" >
                        <input id="image-file" type="file" >
                    </div>
                </div>
                
                <input type="submit" id="submitBtn" value="Submit">
            </form>
        </div>
    </div>
    <script src="../lib/infochange.js"></script>
</body>



</html>