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

addToInformationSection(infor)