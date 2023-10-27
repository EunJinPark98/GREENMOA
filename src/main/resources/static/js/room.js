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


// 쪽지 보내기 클릭시 쪽지 보내기 창 열리기 닫히기
function openLetterBox(element) {
    var memberName = element.getAttribute('data-membername');
    var memberId = element.getAttribute('data-memberid');
    
    document.querySelector('.letter h3').setAttribute('data-membername', memberName);
    document.querySelector('#memberId').setAttribute('data-memberid', memberId);

    document.querySelector('.letter h3').textContent = memberName + '에게 쪽지보내기';
    document.querySelector('.getMemberId input').value = memberId;
    
    document.querySelector('.letter').style.display = 'block';
}

function closeLetterBox() {

    document.querySelector('.letter h3').removeAttribute('data-membername');
    document.querySelector('#memberId').removeAttribute('data-memberid');
    
    document.querySelector('.letter h3').textContent = '';
    
    document.querySelector('.letter').style.display = 'none';
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

// 투두리스트 체크 온오프 표시만
function addlinethrough(){
    let todoName = document.querySelector('.todoName');
    let Dday = document.querySelector('.Dday');
    if(todoName.style.textDecoration == '' && Dday.style.textDecoration == ''){
        todoName.style.textDecoration = 'line-through';
        Dday.style.textDecoration = 'line-through';
    }else{
        todoName.style.textDecoration = '';
        Dday.style.textDecoration = '';

    }
};

// 상태 메세지 변경
function showInput(){
    let inputStatus =document.getElementById('input-status-msg');
    inputStatus.style.display='block';

    // 인풋 포커스될때만 취소버튼 보이게
    let btnClose = document.querySelector('.btnClose');
    btnClose.style.display = 'block';

};
// 상태 메세지 input 닫기
function closeInput(){
    let inputStatus =document.getElementById('input-status-msg');
    inputStatus.style.display='none';
    
    let btnClose = document.querySelector('.btnClose');
    btnClose.style.display = 'none';

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

// 쪽지함 체크박스 선택
function checkLetter(){

    // 내용부에 있는 모든 체크박스
    const checkboxes = document.querySelectorAll('input[name="innerCheck"]');
    // 내용부에 체크되어 있는 체크박스
    const checked = document.querySelectorAll('input[name="innerCheck"]:checked');
    

    if(checkboxes.length==checked.length){
        selectAll.checked = true;
    }
    else{
        selectAll.checked =false;
    }

}

// 선택삭제 버튼 클릭시 실행
function deleteletter(){
    // 체크된 체크박스들
    const checkedChks = document.querySelectorAll('.chk:checked');
    // 선택된 상품이 없을 경우
    if(checkedChks.length==0){
        alert('삭제할 쪽지를 선택하세요.');
        // 아무것도 없는 return 을 만나면 함수가 끝난다.
        return ;
    }
    if(confirm('선택한 쪽지를 삭제하시겠습니까?')){
        // 모든 CART_CODE를 가져갈 배열 생성
        let letterNumArr=[];

        // 삭제하고자하는 CART_CODE들 가져오기
        checkedChks.forEach(function(chk,index){
            letterNumArr[index]=chk.value;
        });
        // 삭제하러 이동
        location.href=`/room/deleteLetter?letterNums=${letterNumArr}`;
    }
}
// 답장 input 보이게 하기

function showinput() {
    var clickedButton = event.target;
    var letterCast = clickedButton.closest('.letterCast');
    var answerLetterDiv = letterCast.nextElementSibling;
    if (answerLetterDiv.style.display === 'none' || answerLetterDiv.style.display === '') {
        answerLetterDiv.style.display = 'block';
    } else {
        answerLetterDiv.style.display = 'none';
    }
}





// 채팅

var socket = new WebSocket('ws://192.168.30.55:8081/chat');


socket.onopen = function() {
    console.log('채팅 연결되었습니다.');
};

socket.onclose = function(event) {
    if (event.wasClean) {
        console.log('연결이 정상적으로 닫힘, 코드=' + event.code + ' 이유=' + event.reason);
    } else {
        console.error('연결이 끊어짐');
    }
};

socket.onerror = function(error) {
    console.error('오류 발생: ' + error);
};



// 메시지 전송
var messageForm = document.getElementById('message-form');
messageForm.addEventListener('submit', function (e) {
    e.preventDefault();
    sendMessage();
});

function sendMessage() {
    var messageInput = document.getElementById('message').value;
    var sender = "외부인"
    var senderElement = document.getElementById('sender');
    var idElement = document.getElementById('memId');
    var id = "외부인"

    if(senderElement){
        var name = senderElement.getAttribute('data-sender');
        if (name){
            sender = name;
        } 
    }
    if(idElement){
        id = idElement.getAttribute('data-id');
    }
        


    socket.send(JSON.stringify({'content': messageInput, 'sender' : sender, 'id' : id}));

    document.getElementById('message').value = '';
}

// 메시지 표시
socket.onmessage = function(event) {
    var message = JSON.parse(event.data);
    showMessage(message.content, message.sender, message.id);
    scrollToBottom();
};


function showMessage(message, sender, id) {
    console.log("보내는사람 : " + sender);
    console.log("메세지 : " + message);
    
    var chatMessages = document.getElementById('chat-messages');
    var msg = document.createElement('p');
    msg.appendChild(document.createTextNode(sender + " : " + message));

    chatMessages.appendChild(msg);

    // 채팅 말풍선 나타나기
    if(id != '없음'){
        let chatBubble = document.querySelector('.member-' + id);
        chatBubble.style.display = 'block';
        chatBubble.innerHTML = message;
        setTimeout(function() {
            chatBubble.style.display = 'none';
        }, 1000); // 2초는 2000 밀리초로 표현
    }

}


// 채팅 스크롤바 항상 밑에 있도록
function scrollToBottom() {
    var chatMessages = document.getElementById('chat-messages');
    chatMessages.scrollTop = chatMessages.scrollHeight;
}





// 풀캘린더 (main.html)
var openCalender = document.querySelector('#openCalender');
openCalender.addEventListener('click', function() {

    // 캘린더 크기 조정
  $('#calenderModal').on('shown.bs.modal', function() {           
    calendar.updateSize(); 
  });

  var calendarEl = document.getElementById('calendar');
  var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    editable: true,
    events: {
      url: '/getEvents', 
      method: 'GET'
    },
  });

  calendar.render();


});




function eventReg(){
    var title = $('#calTitle').val();
    var date = $('#calDate').val();


    if (title && date) {
        var eventData = {
            calTitle: title,
            calDate: date,
        };

        $.ajax({
            url: '/addEvent', 
            type: 'POST',
            data: JSON.stringify(eventData),
            contentType: 'application/json',
            success: function(response) {
                // 서버에서 응답을 받으면 필요한 동작 수행
                alert(response);
                
                calendar.refetchEvents();
            }
        });
    }
    calendar.refetchEvents();
}



//일정 등록 (myRoom.html)
// $('#eventForm1').on('click', function(e) {
// //$('#asdef').on('click', function(e) {
//     e.preventDefault();
//     alert('클릭했다');
//     var title = $('#calTitle').val();
//     var date = $('#calDate').val();


//     if (title && date) {
//         var eventData = {
//             calTitle: title,
//             calDate: date,
//         };

//         $.ajax({
//             url: '/addEvent', 
//             type: 'POST',
//             data: JSON.stringify(eventData),
//             contentType: 'application/json',
//             success: function(response) {
//                 // 서버에서 응답을 받으면 필요한 동작 수행
//                 alert(response);
                
//                 calendar.refetchEvents();
//             }
//         });
//     }
//     calendar.refetchEvents();

// });

function openCalendar() {
    var calendarFormDiv = document.querySelector('.calendarForm');
    calendarFormDiv.style.display = 'block';
}
function closeCalender() {
    var calendarFormDiv = document.querySelector('.calendarForm');
    calendarFormDiv.style.display = 'none';
}


