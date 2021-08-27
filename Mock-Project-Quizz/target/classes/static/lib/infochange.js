var check = function() {
    if (document.getElementById('newpassword').value ==
      document.getElementById('repassword').value) {
      document.getElementById('message').style.color = 'green';
      document.getElementById('message').innerHTML = 'matching';
    } else {
      document.getElementById('message').style.color = 'red';
      document.getElementById('message').innerHTML = 'not matching';
    }
}

var form = document.getElementById("theform");
function handleForm(event) { event.preventDefault(); } 
form.addEventListener('submit', handleForm);

function changeInfo(){
	pushData();
	uploadImage();	
}

function pushData() {
    const password =  $('#password').val();
    const newpassword =  $('#newpassword').val();
    const email =  $('#email').val();
    const job =  $('#job').val();
    const birthday = $('#birthday').val();
    const image = $('input[type=file]').val().split('\\').pop();
	$.ajax({
		type: "POST",
		url: "/changeInfo",
		data: {
			"password": password,
			"newpassword": newpassword,
			"email": email,
			"job": job,
			"birthday": birthday,
			"image": image
		},
		success: function(data) {
			if (data == 1) {
				alert('Thay đổi thành công');
				$(location).attr('href', '/logout');
			} else if (data == 0) {
				alert('Mật khẩu sai');
			}
			else{
				alert('Thay đổi không thành công (Unknown ERROR)')
			}
		}
	});
}

function uploadImage() {
	var fd = new FormData();
	var file_data = $('input[type="file"]')[0].files; 
	for (var i = 0; i < file_data.length; i++) {
		fd.append("file_" + i, file_data[i]);
	}

	$.ajax({
		type: "POST",
		url: "/uploadChangedImage",
		enctype: 'multipart/form-data',
		cache: false,
		processData: false,
		contentType: false,
		data: fd
	});
}