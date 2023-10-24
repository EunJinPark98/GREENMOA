// 게시글 삭제 버튼
function deleteQnaBoard(qnaBoardNum){
    Swal.fire({
    title: "게시글을 삭제하시겠습니까?",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#9c8277',
    cancelButtonColor: '#767f87',
    confirmButtonText: '삭제',
    cancelButtonText: '취소',
    }).then((result) => {
    if (result.isConfirmed) {
        location.href=`/board/deleteQnaBoard?qnaBoardNum=${qnaBoardNum}`;
    }
})
}

// 게시글 수정 버튼
function updateQnaBoard(qnaBoardNum){
    location.href=`/board/updateQnaBoardPage?qnaBoardNum=${qnaBoardNum}`;
}

// 댓글 삭제 버튼
function deleteQnaReply(qnaBoardNum, qnaReplyNum){
    Swal.fire({
    title: "댓글을 삭제하시겠습니까?",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#9c8277',
    cancelButtonColor: '#767f87',
    confirmButtonText: '삭제',
    cancelButtonText: '취소',
    }).then((result) => {
    if (result.isConfirmed) {
        location.href=`/board/deleteQnaReply?qnaReplyNum=${qnaReplyNum}&qnaBoardNum=${qnaBoardNum}`;
    }
})
}


// 댓글 이모지 드롭다운 선택
function changeEmoji(emojiURL){
    let selectImg = document.querySelector('.selectImg');
    selectImg.src = emojiURL;

    let qnaReplyEmojiInput = document.querySelector(".resultQnaEmoji[name='qnaReplyEmoji']");
    qnaReplyEmojiInput.value = emojiURL;
}