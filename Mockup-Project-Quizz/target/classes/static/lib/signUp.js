var check = function() {
    if (document.getElementById('password').value ==
      document.getElementById('repassword').value) {
      document.getElementById('message').style.color = 'green';
      document.getElementById('message').innerHTML = 'matching';
    } else {
      document.getElementById('message').style.color = 'red';
      document.getElementById('message').innerHTML = 'not matching';
    }
}

function logSubmit(event) {
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8000/";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json",'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            console.log(json.username + ", " + json.password + ", " + json.email + ", " + json.job + ", " + json.birthday + ", " +json.password);
        }
    };
    const username = document.getElementById('username');
    const password = document.getElementById('password');
    const email = document.getElementById('email');
    const job = document.getElementById('job');
    const birthday = document.getElementById('birthday');
    const image = document.querySelector('image-file');
    var data = JSON.stringify({ "username": username,"password": password,"username": email,"job": job,"birthday": birthday});
    xhr.send(data);
    log.textContent = 'done send';
    event.preventDefault();
}

const form = document.getElementById('theform');
form.addEventListener('submit', logSubmit);