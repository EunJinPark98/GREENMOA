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


// var messageForm = document.getElementById('message-form');
// messageForm.addEventListener('submit', function (e) {
//         e.preventDefault();
//         sendMessage();
//         scrollToBottom()
// });


// 메시지 전송
function submitMsg(){
    sendMessage();
    scrollToBottom()
}

function sendMessage() {
    var message = document.getElementById('message').value;
    socket.send(JSON.stringify({'content': message}));
    messageInput.value = '';
}

// 메시지 표시

socket.onmessage = function(event) {
    var message = JSON.parse(event.data);
    showMessage(message.content, message.sender);
};


function showMessage(message, sender) {
    console.log("보내는사람 : " + sender);
    console.log("메세지 : " + message);
    
    var chatMessages = document.getElementById('chat-messages');
    var cenderEl = document.createElement('p');
    cenderEl.appendChild(document.createTextNode(sender));
    var msgEl = document.createElement('p');
    msgEl.appendChild(document.createTextNode(message));

    chatMessages.appendChild(cenderEl);
    chatMessages.appendChild(msgEl);
}


// 채팅 스크롤바 항상 밑에 있도록
function scrollToBottom() {
    var chatMessages = document.getElementById('chat-messages');
    chatMessages.scrollTop = chatMessages.scrollHeight;
}
