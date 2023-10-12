// 게시글 삭제 버튼
function deleteQnaBoard(qnaBoardNum){
    const result = confirm("삭제하시겠습니까??")
    if(result){
        location.href=`/board/deleteQnaBoard?qnaBoardNum=${qnaBoardNum}`;
    };
}

// 게시글 수정 버튼
function updateQnaBoard(qnaBoardNum){
    location.href=`/board/updateQnaBoardPage?qnaBoardNum=${qnaBoardNum}`;
}

// 댓글 삭제 버튼
// function deleteReply(boardNum){
//     var replyNum=document.getElementById("replyNum");
//     replyNum=replyNum.dataset.replyNum;
//     const result = confirm('정말 삭제하시겠습니까?');
//     if(result){
//         location.href=`/board/deleteReply?replyNum=${replyNum}&boardNum=${boardNum}`;
//     };
// };