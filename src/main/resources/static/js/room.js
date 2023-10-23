//과제 말풍선
let utilMenu = document.querySelector('.utilMenu');
window.onload = function(){
  utilMenu.classList.add('bounce');
}



// 미니미 클릭시 각각의 말풍선 나타남
var lastClickedBubble = null;

$('.minime-img').click(function() {
    var currentBubble = $(this).siblings('.minmeBubble');

    if (lastClickedBubble !== null && !lastClickedBubble.is(currentBubble)) {
        lastClickedBubble.hide();
    }

    currentBubble.toggle();
    lastClickedBubble = currentBubble;
});

// 쪽지보내기 버튼을 클릭할 때 이벤트 처리
$('.minmeBubble p.letterText').click(function() {
    // 클릭된 .minmeBubble 요소의 부모인 .member에서 클래스가 .name인 요소의 텍스트 값을 가져오기
    var memberName = $(this).closest('.member').find('.name').text();
    
    // 모달 창 안의 #memberName 입력 필드에 선택된 회원의 이름 할당
    $('#letterModal #memberName').val(memberName);
});

$(document).ready(function() {
    // 쪽지보내기 버튼을 클릭할 때 이벤트 처리
    $('.minmeBubble p.letterText').click(function() {
        // data-membername 속성을 통해 memberName 값을 가져옴
        var memberName = $(this).data('membername');
        
        // sendLetter 함수 호출
        sendLetter(memberName);
    });
    
    // sendLetter 함수 정의
    function sendLetter(memberName) {
        // 여기서 memberName을 사용하여 모달 창의 제목과 input 값 업데이트
        $('#letterModal h3').text(memberName + '에게 쪽지보내기'); // 모달 창 제목 업데이트
        $('#memberName').val(memberName); // 숨겨진 input 값 업데이트

        // 모달 창을 보이게 변경
        $('#letterModal').removeClass('fade');
        $('#letterModal').addClass('show');
        $('#letterModal').css('display', 'block');
        
    }
});
// Bootstrap 모달 창을 닫음
 function closeLetterBox(){
    $('#letterModal').removeClass('show');
    $('#letterModal').addClass('fade');
    $('#letterModal').css('display', 'none');
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
function showInput(){
    let inputStatus =document.getElementById('input-status-msg');
    inputStatus.style.display='block';

};
// 상태 메세지 input 닫기
function closeInput(){
    let inputStatus =document.getElementById('input-status-msg');
    inputStatus.style.display='none';

};

// 상태 메세지 update
function updateStatusMsg(memberId){
    let inputStatus =document.getElementById('input-status-msg');
    let inputStatusValue =document.getElementById('input-status-msg').value;
    
        if(window.event.keyCode==13){
            inputStatus.style.display='none';
            location.href=`/room/updateStatusMsg?memberId=${memberId}&statusMsg=${inputStatusValue}`;
        };
};






