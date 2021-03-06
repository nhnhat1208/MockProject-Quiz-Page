<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign up</title>
    <link rel="stylesheet" href="/css/signUp.css">
    <link rel="stylesheet" href="/css/global.css">
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
    
</head>

<body>
    <header>
		<a href="/"> <img class="logo"
			style="object-fit: scale-down; margin: 5px 0px 10px 50px; height: 55px; width: 55px;"
			src="../images/logo.png" alt="Logo">
		</a> 
	</header>

    <div class="signUp">
        <div id="bannerForm">
            Đăng ký
        </div>
        <div id="signUpForm">
            <form id="theform" style="margin-left: 10%;" onsubmit="addUser()">
                <div class="row">
                    <div class="colTitle">
                        <label for="fname">Tên đăng nhập</label>
                    </div>
                    <div class="colInput">
                        <input type="text" id="username" name="username" required>
                    </div>
                </div>
                <div class="row">
                    <div class="colTitle">
                        <label for="lname">Mật khẩu</label>
                    </div>
                    <div class="colInput">
                        <input type="password" id="password" name="password"  onkeyup="check();" required>
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
                        <input id="image-file" type="file" accept="image/jpeg" required >
                    </div>
                </div>
                <div class="row"  style="margin-left:100px; height: 40px;">
                    <div class="colInput" style="margin-left: 80px;">
                        <input type="checkbox" style="margin-top: 4px;" required>
                        <span class="checkmark">I agree with terms conditions and privacy policy.</span>
                    </div>
                </div>
                <script src="/lib/signUp.js"></script>
                <input type="Submit" id="submitBtn" value="Submit">
            </form>
        </div>
    </div>


  	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</body>



</html>