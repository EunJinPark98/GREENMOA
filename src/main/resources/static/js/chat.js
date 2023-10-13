// // STOMP
// var stompClient = null;


// function connect() {
//     //var socket = new SockJS('/chat');
//     var socket = new SockJS('http://192.168.30.55:8081/chat');
//     stompClient = Stomp.over(socket);
//     stompClient.connect({}, function (frame) {
//         console.log('연결상태: ' + frame);
//         stompClient.subscribe('/topic', function (message) {
//             showMessage(JSON.parse(message.body).content);
//         });

//     }); 
// }

// // 메시지 전송
// function sendMessage() {
//     var messageInput = document.getElementById('message');
//     var message = messageInput.value;
//     stompClient.send("/app/chat", {}, JSON.stringify({'content': message, 'sender': "익명" }));


//     messageInput.value = '';
// }

// // 메시지 표시
// function showMessage(message) {
//     var chatMessages = document.getElementById('chat-messages');
//     var msgEl = document.createElement('p');
//     msgEl.appendChild(document.createTextNode(message));
//     chatMessages.appendChild(msgEl);

//     scrollToBottom();
// }

// // 페이지 로드 시 채팅 연결
// document.addEventListener('DOMContentLoaded', function () {
//     connect();
    
//     var messageForm = document.getElementById('message-form');
//     messageForm.addEventListener('submit', function (e) {
//         e.preventDefault();
//         sendMessage();
//     });
// });








//WebSocketConfigurer


//var socket = new SockJS('http://192.168.30.55:8081/chat');
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

// 페이지 로드 시 WebSocket 연결
window.onload = function() {
    connect();
    var messageForm = document.getElementById('message-form');
    messageForm.addEventListener('submit', function (e) {
        e.preventDefault();
        sendMessage();
    });
        
};







// 채팅 스크롤바 항상 밑에 있도록
function scrollToBottom() {
    var chatMessages = document.getElementById('chat-messages');
    chatMessages.scrollTop = chatMessages.scrollHeight;
}
