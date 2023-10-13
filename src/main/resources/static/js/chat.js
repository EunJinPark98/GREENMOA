var socket = new WebSocket('ws://192.168.30.55:8081/chat');


socket.onopen = function() {
    console.log('연결이 열렸습니다.');
};

socket.onmessage = function(event) {
    var message = JSON.parse(event.data);
    showMessage(message.content);
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

// 메시지 전송 함수
function sendMessage() {
    var messageInput = document.getElementById('message');
    var message = messageInput.value;
    socket.send(JSON.stringify({'content': message, 'sender': '익명'}));
    messageInput.value = '';
}

// 메시지 표시 함수
function showMessage(message) {
    var chatMessages = document.getElementById('chat-messages');
    var msgEl = document.createElement('p');
    msgEl.appendChild(document.createTextNode(message));
    chatMessages.appendChild(msgEl);
}



window.onload = function() {
    
        
};


var messageForm = document.getElementById('message-form');
    messageForm.addEventListener('submit', function (e) {
        e.preventDefault();
        sendMessage();

        scrollToBottom()
    });


    

// 채팅 스크롤바 항상 밑에 있도록
function scrollToBottom() {
    var chatMessages = document.getElementById('chat-messages');
    chatMessages.scrollTop = chatMessages.scrollHeight;
}
