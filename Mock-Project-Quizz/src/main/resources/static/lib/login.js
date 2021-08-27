var form = document.getElementById("login_form");
function handleForm(event) { event.preventDefault(); } 
form.addEventListener('submit', handleForm);

function login() {
	var user = $('#username').val();
	var pwd = $('#password').val();
	$.ajax({
		type: "POST",
		url: "/checkLogin",
		data: { "user": user, "password": pwd },
		success: function(data) {
			if (data == 1) {
				$(location).attr('href', '/');
			}
			else if (data == 0) {
				alert('The Username or Password is Incorrect');
			}
		}
	});
}