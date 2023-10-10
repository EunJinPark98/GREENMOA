// 웹 소켓 연결 설정
var stompClient = null;


function connect() {
    var socket = new SockJS('/chat');

   // var socket = new WebSocket('ws://localhost:8081/chat'); // WebSocket 연결 URL 
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/', function (message) {
            showMessage(JSON.parse(message.body).content);
        });
    });
}

// 메시지 전송
function sendMessage() {
    var messageInput = document.getElementById('message');
    var message = messageInput.value;
    stompClient.send("/app/chat", {}, JSON.stringify({ 'content': message }));
    messageInput.value = '';
}

// 메시지 표시
function showMessage(message) {
    var chatMessages = document.getElementById('chat-messages');
    var messageElement = document.createElement('p');
    messageElement.appendChild(document.createTextNode(message));
    chatMessages.appendChild(messageElement);
}

// 페이지 로드 시 연결
document.addEventListener('DOMContentLoaded', function () {
    connect();
    
    var messageForm = document.getElementById('message-form');
    messageForm.addEventListener('submit', function (e) {
        e.preventDefault();
        sendMessage();
    });
});
