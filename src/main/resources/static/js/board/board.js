//게시글 삭제 버튼
function goDelete(boardNum){
    const result = confirm('정말 삭제하시겠습니까?');
    if(result){
        location.href=`/board/deleteBoard?boardNum=${boardNum}`;
    };
};

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