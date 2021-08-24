var idnew = 1;
function deleteQuestion(id) {
 var quesRemove = document.getElementById("ques"+id);
 quesRemove.remove();
}
function addQuestion() {
  idnew = idnew +1;
var newques = document.getElementById("listquiz");
  var option ="";
     for(var i=1;i<=4;i++){
    option = option+ "<div class = 'field'> \n";
    option = option+ "<div class = 'namefield'>Câu trả lời "+i+"</div> \n";
    option = option+ "<div class = 'inputfield' > <textarea id='ans"+idnew+""+i+"' class = 'ansquiz'></textarea> </div>"
    option = option+"<div class = 'clearfix'></div> \n";
    option =option+"</div>";
    }
    newques.innerHTML =  newques.innerHTML + "<fieldset id ='ques"+idnew+"'>"
    + "<legend>Câu </legend>"
    + "<div class = 'field'>"
    + "<div class = 'namefield'>Câu hỏi</div>"
    + "<div class = 'inputfield'> <textarea id='questionquiz"+idnew+"' class = 'quesquiz'></textarea></div>"
    + "<div class = 'clearfix'></div>"
    + "</div>"
    +option
    + "<div><button id='"+idnew+"'  class='floatright ' onclick='deleteQuestion(this.id)'>Xóa</button></div>"
    + "</fieldset>";

}
