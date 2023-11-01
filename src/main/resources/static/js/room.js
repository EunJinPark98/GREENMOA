//미니미 초기 위치 랜덤
document.addEventListener("DOMContentLoaded", function () {
    const memberElements = document.querySelectorAll(".member");
    
    memberElements.forEach(function (element) {
        // 랜덤한 위치 값 설정
        const randomLeftValue = Math.floor(Math.random() * 1021); // 0~1020px 범위에서 랜덤값
        const randomTopValue = Math.floor(Math.random() * 381) + 400; // 400~780px 범위에서 랜덤값

        // 스타일 설정
        element.style.left = randomLeftValue + "px";
        element.style.top = randomTopValue + "px";
    });
});


//과제 말풍선
// let utilMenu = document.querySelector('.utilMenu');
// window.onload = function(){
//   utilMenu.classList.add('bounce');
// }



// 미니미 클릭시 각각의 말풍선 나타남
var lastClickedBubble = null;

$('.minime-img').click(function() {
    var currentBubble = $(this).siblings('.minmeBubble');
    let imageMemberId = $(this).data('memberid');
    let imageLoginId = $(this).siblings('.minmeBubble').find('.loginId').val();

    if(imageMemberId != imageLoginId){
        if (lastClickedBubble !== null && !lastClickedBubble.is(currentBubble)) {
            lastClickedBubble.hide();
        }
    
        currentBubble.toggle();
        lastClickedBubble = currentBubble;
    }
});


// 쪽지 보내기 클릭시 쪽지 보내기 창 열리기 닫히기
function openLetterBox(element) {
    element.closest('.minmeBubble').style.display = 'none';
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

// 답장 얼럿 창
function showAlert() {
    let sendLetterForm = document.getElementById("sendLetterForm");
    let letterContent = document.getElementById("letterContent").value;
    Swal.fire({
        title: "답장 보내기 완료",
        icon: 'success'
    }).then(() => {
        sendLetterForm.elements["letterContent"].value = letterContent;
        sendLetterForm.submit();
    });
}

// 쪽지 보내기 얼럿창 
function mainLetterAlert() {
    let insertLetterForm = document.getElementById("insertLetterForm");
    let memberId = document.querySelector('#memberId').value;
    console.log("#######"+memberId);
    Swal.fire({
        title: `"${memberId}"님께 쪽지를 보냈습니다.`,
        icon: 'success'
    }).then(() => {
        insertLetterForm.submit();
        document.querySelector('.letter').style.display = 'none';
    });
}

// 과제 등록 얼럿창 
function todoListAlert() {
    let todoListForm = document.getElementById("todoListForm");
    console.log("#######"+memberId);
    Swal.fire({
        title: "과제를 등록 했습니다.",
        icon: 'success'
    }).then(() => {
        todoListForm.submit();
    });
}

// 과제버튼 삭제 클릭시 workList delete
function deleteWork(workNum){
    Swal.fire({
        title: "정말 삭제하시겠습니까?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#9c8277',
        cancelButtonColor: '#767f87',
        confirmButtonText: '삭제',
        cancelButtonText: '취소',
    }).then((result) => {
        if (result.isConfirmed) {
            location.href = `/room/deleteWork?workNum=${workNum}`;
        }
    });
};




// // 등록 클릭시 todoList insert
function insertTodo() {
    let todoContent = document.querySelector('#todoContent').value;
    let todoFinishDate = document.querySelector('#todoFinishDate').value;
    
    // 현재 날짜 가져오기
    let today = new Date();
    today.setHours(0, 0, 0, 0); // 현재 시간을 00:00:00 으로 설정

    // 입력한 날짜를 Date 객체로 변환
    let selectedDate = new Date(todoFinishDate);

    // 입력한 날짜가 오늘 날짜보다 이전이면 얼럿 메시지 표시
    if (selectedDate < today) {
        Swal.fire({
            title: "지난 날짜입니다.",
            icon: 'error'
        });
        return;
    }

    // todoFinishDate가 비어있을 때 얼럿 메시지 표시
    if (!todoFinishDate) {
        Swal.fire({
            title: "날짜 및 내용을 입력하세요.",
            icon: 'error'
        });
        return;
    }

    // todoList의 길이 확인
    let todoListLength = document.querySelectorAll('.realTodoList ul').length;

    // todoList의 길이가 10개 이상인 경우 얼럿 메시지 표시하고 등록을 막음
    if (todoListLength >= 9) {
        Swal.fire({
            title: "9개 이상 등록할 수 없습니다.",
            icon: 'error'
        });
        return;
    }

    Swal.fire({
        title: "등록하시겠습니까?",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#9c8277',
        cancelButtonColor: '#767f87',
        confirmButtonText: '등록',
        cancelButtonText: '취소'
    }).then((result) => {
        // 확인을 눌렀을 때만 실행
        if (result.isConfirmed) {
            Swal.fire({
                title: "등록되었습니다.",
                icon: 'success'
            }).then(() => {
                // 확인을 누르면 페이지 이동
                location.href = `/room/insertTodo?todoContent=${todoContent}&todoFinishDate=${todoFinishDate}`;
            });
        }
    });
}

// 삭제버튼 클릭시 todoList delete
function deleteTodo(todoNum){
    Swal.fire({
        title: "정말 삭제하시겠습니까?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#9c8277',
        cancelButtonColor: '#767f87',
        confirmButtonText: '삭제',
        cancelButtonText: '취소',
    }).then((result) => {
        if (result.isConfirmed) {
            location.href = `/room/deleteTodoList?todoNum=${todoNum}`;
        }
    });
};

// 투두리스트 체크 가로줄
function addlinethrough(checkbox){
    let check = checkbox.parentElement;
    let todoName = check.querySelector('.todoName');
    let Dday = check.querySelector('.Dday');
    if(todoName.style.textDecoration == '' && Dday.style.textDecoration == ''){
        todoName.style.textDecoration = 'line-through';
        Dday.style.textDecoration = 'line-through';
    }else{
        todoName.style.textDecoration = '';
        Dday.style.textDecoration = '';

    }
};

// 상태 메세지 변경
function updateStatusMsg(){
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
    if (checkedChks.length == 0) {
        Swal.fire({
            title: "삭제할 쪽지를 선택하세요.",
            icon: 'error'
        });
        // 함수 종료
        return;
    }

    // SweetAlert로 확인 창 표시
    Swal.fire({
        title: "선택한 쪽지를 삭제하시겠습니까?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#9c8277',
        cancelButtonColor: '#767f87',
        confirmButtonText: '삭제',
        cancelButtonText: '취소'
    }).then((result) => {
        // 확인을 눌렀을 때만 실행
        if (result.isConfirmed) {
            // 모든 쪽지 번호를 가져갈 배열 생성
            let letterNumArr = [];

            // 삭제하고자 하는 쪽지 번호들 가져오기
            checkedChks.forEach(function(chk, index) {
                letterNumArr[index] = chk.value;
            });

            // SweetAlert로 성공 메시지 표시 후 삭제하러 이동
            Swal.fire({
                title: "삭제되었습니다.",
                icon: 'success'
            }).then(() => {
                // 확인을 누르면 페이지 이동
                location.href = `/room/deleteLetter?letterNums=${letterNumArr}`;
            });
        }
    });
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
// 답장 보내기
function submitAnswer(event) {
    Swal.fire({
        title: "답장 보내기 완료",
        icon: 'success'
    }).then(() => {

        let button = event.target;
        let form = button.closest(".answerLetterForm"); // 클릭된 버튼의 부모 폼 찾기
        form.submit(); // 폼 제출
    });
}




///////////////// 소켓통신 /////////////////////////////////////
var socket = new WebSocket('ws://192.168.30.55:8081/chat');

//로그인 한 정보 태그
var idElement = document.getElementById('memId'); 
var srcElement = document.getElementById('miniSrc'); 

socket.onopen = function() {
    console.log('연결되었습니다.');
    if(idElement){
        console.log('로그인 되었습니다.');
        socket.send(JSON.stringify({
            'connectId' : idElement.getAttribute('data-id')
        }));
    };
};


socket.onclose = function(event) {
    if(idElement){
        console.log('로그아웃 되었습니다.');
        socket.send(JSON.stringify({
            'disConnectId' : idElement.getAttribute('data-id')
        }));
    };

    if (event.wasClean) {
        console.log('연결이 정상적으로 닫힘, 코드=' + event.code + ' 이유=' + event.reason);
    } else {
        console.error('연결이 끊어짐');
    }
};

socket.onerror = function(error) {
    console.error('오류 발생: ' + error);
};





if(idElement){ //로그인 했을 경우
    var myId = idElement.getAttribute('data-id');
    var minimeSrc = srcElement.getAttribute('data-minime');


    const movingElement = document.querySelector('#my-minime-'+ myId);

    // 나의 미니미 클릭
    movingElement.addEventListener('click', () => {
        movingElement.classList.add('active');
            let connectTag = document.getElementById('memId');
    if(connectTag){
        let connectId = connectTag.getAttribute('data-id');
        socket.send(JSON.stringify({
            'connectId' : connectId,
        }));
    } 
    });

    //  미니미 키보드로 동작
    document.addEventListener('keydown', (event) => {
    if (movingElement.classList.contains('active')) { //클릭 했을 경우에만 
        event.preventDefault();

        const style = getComputedStyle(movingElement);
        let left = parseFloat(style.left) || 0;
        let top = parseFloat(style.top) || 0;
    
        // 이동 범위
        movingElement.style.left = left + 'px';
        movingElement.style.top = top + 'px';
        
        // 소켓 전달
        socket.send(JSON.stringify({
            'moveId' : myId,
            'left' : left,
            'top' : top,
            'eventKey' : event.key,
            'minimeSrc' : minimeSrc
        }));

    }
    });


  //바탕 클릭하면 이제 안움직이게
  document.addEventListener('mousedown', (event) => {
    if (movingElement.classList.contains('active') && event.target !== movingElement) {
        movingElement.classList.remove('active');
    }
  });
}





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


// 로그아웃 버튼 누르면 접속 비활성화
$('.disConnectBtn').click(function(){
    let idEl = document.getElementById('memId'); 
    let disConnectId = idEl.getAttribute('data-id');
    socket.send(JSON.stringify({
        'disConnectId' : disConnectId,
    }));
})

// 접속중 불들어오게
window.addEventListener('load', function() {
    let connectTag = document.getElementById('memId');
    if(connectTag){
        let connectId = connectTag.getAttribute('data-id');
        socket.send(JSON.stringify({
            'connectId' : connectId,
        }));
    } 
});

window.addEventListener('scroll', function() {
    let connectTag = document.getElementById('memId');
    if(connectTag){
        let connectId = connectTag.getAttribute('data-id');
        socket.send(JSON.stringify({
            'connectId' : connectId,
        }));
    } 
});

window.addEventListener('mousemove', function(event) {
    let connectTag = document.getElementById('memId');
    if(connectTag){
        let connectId = connectTag.getAttribute('data-id');
        socket.send(JSON.stringify({
            'connectId' : connectId,
        }));
    } 
});

window.addEventListener('keydown', function(event) {
    let connectTag = document.getElementById('memId');
    if(connectTag){
        let connectId = connectTag.getAttribute('data-id');
        socket.send(JSON.stringify({
            'connectId' : connectId,
        }));
    } 
});


// 소켓으로 받은 데이터
socket.onmessage = function(event) {
    var data = JSON.parse(event.data);
    
    // 접속 활성화
    if(data.connectId){
        let connectId = document.querySelector('#my-minime-'+ data.connectId);
        connectId.querySelector('.connect-state').src = '/images/connectOn.png';
    }

    // 접속 비활성화
    if(data.disConnectId){
        let disConnectId = document.querySelector('#my-minime-'+ data.disConnectId);
        disConnectId.querySelector('.connect-state').src = '/images/connectOff.png';
    }

    // 채팅 전송
    if(data.content != null){
        showMessage(data.content, data.sender, data.id);
        scrollToBottom();
    }

    // 미니미 이동
    if(data.moveId){
        let moveMini = document.querySelector('#my-minime-'+ data.moveId);

        switch (data.eventKey) {
            case 'ArrowUp':
                if(data.top>400){
                    moveMini.style.top = (data.top-10) + 'px';
                }
            break;
            case 'ArrowDown':
                if(data.top<780){
                    moveMini.style.top = (data.top+10) + 'px';
                }
            break;
            case 'ArrowLeft':
                if(data.left>0){
                    moveMini.style.left = (data.left-10) + 'px';
                    moveMini.querySelector('.minime-img').src = `/images/${data.minimeSrc}left.png`;
                }
            break;
            case 'ArrowRight':
            if(data.left<1020){
                    moveMini.style.left = (data.left+10) + 'px';
                    moveMini.querySelector('.minime-img').src = `/images/${data.minimeSrc}right.png`;
            }
            break;
        }
    }
   
};

//채팅 띄우기
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





/////////////////////////////////////////////////////////////////////////////////////











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
                Swal.fire({
                    title: "일정이 추가 되었습니다.",
                    icon: 'success'
                })
                calendar.refetchEvents();
            }
        });
    }
    calendar.refetchEvents();
}


function openCalendar() {
    let calendarFormDiv = document.querySelector('.calendarForm');
    calendarFormDiv.style.display = 'block';
}
function closeCalender() {
    let calendarFormDiv = document.querySelector('.calendarForm');
    calendarFormDiv.style.display = 'none';
}

// 북마크 모달창 Close 버튼 클릭 시 모달 닫고 페이지 새로고침
function reload(){
    location.reload();
}




