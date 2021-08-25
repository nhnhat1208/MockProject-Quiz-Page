<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">
<head>
  <title>Login</title>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script defer src="/lib/login.js"></script>
  <link rel="stylesheet" href="/css/global.css">
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
        

        input[type=submit]{
            height: 45px;
            background-color: #4f5466;
            color: white;
            margin: auto;
        } 

    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
	
</head>
<body style="font-family: Arial, Helvetica, sans-serif;background-color:white">
<!-- 
				<header style="width: 100%;    height: 50px ;    min-height: 50px ;    background-color: #4f5466	;    vertical-align: middle;">

		        
		        <p class="guess"style="color: white;  padding: 5px 10px 10px 10px; float: right; margin: 1% 10px auto auto;"  >
		        	<a href="login.html"style="color: white;">
		            Đăng nhập
		            </a>
		        </p>
		        <p class="guess" style="color: white;  padding: 5px 10px 10px 10px; float: right; margin: 1% 10px auto auto;"  >
		        	<a href="signUp.html"style="color: white;">
		            Đăng ký
		            </a>
		        </p>
		        <a href="main.html">
		        	<img id="icon" src="../img/logo.jpg" style="width: 100px;height:50px" />
				</a>
		    </header>
  -->   
  
  
  		<header>
  			
	        <Nav>
	        <a href="#">
	            <img class="logo" src="/img/logo.jpg" alt="Logo">
	            <!-- image or something logo -->
	        </a>
	        </Nav>
	        <p class="guess"style="color: white;  padding: 5px 10px 10px 10px; float: right; margin: 10px -1100px auto auto;"  >
		        <a href="/login"style="color: white;">
		            Đăng nhập
		        </a>
		    </p>
		    <p class="guess" style="color: white;  padding: 5px 10px 10px 10px; float: right; margin: 10px 10px auto auto;"  >
		      	<a href="/signup"style="color: white;">
		            Đăng ký
		        </a>
		    </p>
	    </header>
        <section style="height:450px; width: 420px; min-width: 250px; margin:100px 2px 2px 562px; 
            border: lightgray solid 2px;
            border-radius: 35px;
            overflow: auto;">
            <div style="background-color: #4F5466;font-size: 16px;color: white; height: 40px;width: 100%; padding:25px; border-bottom: lightgray solid 1px; border-radius: 3px 3px 0 0;">
            	<p style="margin:-10px 220px 20px 20px"><b>Đăng nhập</b></p>
            </div>
                <form id="login_form"style="padding: 20px;" onsubmit="login()">
                	<p>Tên đăng nhập</p>
                    <input style="padding: 10px" type="text" name="username" id="username" placeholder="Username" required>  <br>
                	<p>Mật khẩu</p>
                    <input style="padding: 10px" type = "password" name="password" id="password" placeholder="Password" required>
                    <p ><a href="#" style="margin:0px 0px 0px 250px"><u>Quên mật khẩu?</u></a></p>
                    <input style="margin	:20px 0px 0px 0px" type="submit" id="submitButton" value="Đăng nhập"><br><br>
                    <p sytle="padding:20px 0px 20px 20px"><a href="/signUp"><u>Chưa có tài khoản? Đăng ký ngay</u></a></p>
                </form>
                    
  	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

</body>
</html>










