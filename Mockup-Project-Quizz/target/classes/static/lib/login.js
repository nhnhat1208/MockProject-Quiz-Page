const loginForm = document.getElementById("login_form");
const loginButton = document.getElementById("submitButton");
loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;
	var role=0;
	var usr = "admin",pass="123";
    if (username === usr && password === pass) {
        alert("You have successfully logged in.");
		if(role==1)
        	window.location.href = "mainPage.html";
		window.location.href = "admin_info.html";
    } else {
        
        alert("Wrong!");
    }
})
