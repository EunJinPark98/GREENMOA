//게시글 삭제 버튼
function goDelete(boardNum){
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
            location.href=`/board/deleteBoard?boardNum=${boardNum}`
        }
    })
}


// 게시글 수정 버튼
function goUpdate(boardNum){
    location.href=`/board/updateBoardForm?boardNum=${boardNum}`;
}

// 댓글 삭제 버튼
function deleteReply(boardNum, replyNum){

    const result = confirm('정말 삭제하시겠습니까?');
    if(result){
        location.href=`/board/deleteReply?replyNum=${replyNum}&boardNum=${boardNum}`;
    };
};

// 댓글 이모지 드롭다운 선택
function changeEmoji(emojiURL){
    let selectImg = document.querySelector('.selectImg');
    selectImg.src = emojiURL;

    let replyEmojiInput = document.querySelector(".resultEmoji[name='replyEmoji']");
    replyEmojiInput.value = emojiURL;
}