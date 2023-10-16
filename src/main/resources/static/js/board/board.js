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

// 댓글 이모지 드롭다운 선택
function changeEmoji(emojiURL, emojiValue){
    let selectImg = document.querySelector('.selectImg');
    selectImg.src = emojiURL;
    let resultEmoji = document.querySelector('.resultEmoji');
    resultEmoji.value = emojiValue;
}