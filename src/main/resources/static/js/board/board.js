//게시글 삭제 버튼
function goDelete(boardNum){
    const result = confirm('정말 삭제하시겠습니까?');
    if(result){
        location.href=`/board/deleteBoard?boardNum=${boardNum}`;
    };
};
// 게시글 수정 버튼
function goUpdate(boardNum){
    location.href=`/board/updateBoardForm?boardNum=${boardNum}`;
}

// 댓글 삭제 버튼
function deleteReply(boardNum){
    var replyNum=document.getElementById("replyNum");
    replyNum=replyNum.dataset.replyNum;
    const result = confirm('정말 삭제하시겠습니까?');
    if(result){
        location.href=`/board/deleteReply?replyNum=${replyNum}&boardNum=${boardNum}`;
    };
};



// 엔터키 누르면 자동 댓글 등록버튼 동작실행
// 시프트+엔터해야 줄바꿈되도록
let replyText = document.getElementById('replyText');
replyText.addEventListener('keydown', function(event){
    if(event.key === 'Enter' && !event.shiftKey){
        event.preventDefault();
        submitToForm();
    }

});
function submitToForm(){
    const replyForm = document.getElementById('replyForm');
    replyForm.addEventListener('submit', function(event){
        event.preventDefault();
    })
    replyForm.submit();
};