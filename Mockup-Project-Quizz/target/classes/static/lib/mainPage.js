function createHistoryItem(item) {
    return `<div id="historyItem">
                <img src= "${item.quiz_image}" alt="" style="object-fit: cover; float: left;">
                <div style="float:left; margin-left: 15px; width: 50%;">
                    <div>
                        <h2 style="margin: 10px 0 15px 0;">${item.quiz_name}</h2>
                    </div>
                    <div style="height: 65px;">
                        <p style="max-height: 50px; max-width: 800px; margin-bottom: 0px;">${item.quiz_description}</p>
                    </div>
                    <div>
                        <div id='currentScore' style="float: left;">
                            Kết quả hiện tại: <span> ${item.curentScore}</span> 
                        </div>
                    </div>
                </div>
                <div id="quiz">
                    <figure>
                        <button name="play" onclick="GoQuiz(${item.quizId})"></button>
                    </figure>
                </div>
            </div>`
}

function addToHistory(jsonItem) {
    var item = createHistoryItem(jsonItem);
    $('#scrollVertical').append(item);
}


function createRecommendedItem(item) {
    return `<div id="recommendedItem" style="background-image: linear-gradient(to top, rgba(245, 246, 252, 0.52), rgba(51, 48, 50, 0.911)), url('${item.quiz_image}');">
                <div id="QuizTitle">
                    ${item.quiz_name}
                </div>
                <div id="PlayQuizRecommend">
                    <a href="./quizEntrance.html?index=${item.quizId}" class="gg-play-button-o"><i class="fa fa-play fa-2x"></i></a>
                </div>
            </div>`
}

function addToRecommended(jsonItem) {
    var item = createRecommendedItem(jsonItem);
    $('#scrollHorizontal').append(item);
}

function addToInformationSection(info) {
    // $('#avatar').append(info.avatar);
    $('#username').append(info.username);
    $('#birthdate').append(info.birthdate);
    $('#job').append(info.job);
    $('#email').append(info.email);
}

var test = {
    "quiz_image": null, //image file in object
    "quiz_name":"Phân giải tổ hợp",
    "quiz_description": "Description",
    "curentScore": "10/10",
    "quizId": "CABD"

}

var infor = {
    "avatar":null,
    "username":"Ka-el no",
    "birthdate":"22/2/2222",
    "job":"criminal",
    "email":"somemail@mail.en"
}


var test2 = {
    "a":"a",
    "b":[test,test]
}
test2.b.forEach(element => {
    addToHistory(element);
    addToRecommended(element)
});

addToInformationSection(infor)
