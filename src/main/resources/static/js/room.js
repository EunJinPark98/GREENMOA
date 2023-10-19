//과제 말풍선
let utilMenu = document.querySelector('.utilMenu');
window.onload = function(){
  utilMenu.classList.add('bounce');
}

// 등록 클릭시 todoList insert
function insertTodo(){
    const result = confirm('등록하시겠습니까?');
    let todoContent =document.querySelector('#todoContent').value;
    let todoFinishDate =document.querySelector('#todoFinishDate').value;

    if(result){
        location.href=`/room/insertTodo?todoContent=${todoContent}&todoFinishDate=${todoFinishDate}`
    };
};
// 삭제버튼 클릭시 todoList delete
function deleteTodo(todoNum){
    const result = confirm('정말 삭제하시겠습니까?');
    if(result){
        location.href=`/room/deleteTodoList?todoNum=${todoNum}`;
    };
};

// 상태 메세지 변경
function updateStatusMsg(memberId){
    let statusMsg =document.querySelector('#statusMsg').value;
    location.href=`/room/updateStatusMsg?memberId=${memberId}&statusMsg=${statusMsg}`;
};


