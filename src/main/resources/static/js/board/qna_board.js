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
function deleteQnaReply(qnaBoardNum){
     // qnaReplyNum 요소를 선택
     var qnaReplyNumElement = document.querySelector('#qnaReplyNum');
    
     //이거는 define이 뜨는데 왜? 
     //alert(qnaReplyNumElement.dataset.dataReplyNum);

     // data-reply-num 속성의 값을 가져옴
     var dataReplyNumValue = qnaReplyNumElement.getAttribute('data-reply-num');

    if(confirm('삭제하시겠습니까?')){
        location.href=`/board/deleteQnaReply?qnaReplyNum=${dataReplyNumValue}&qnaBoardNum=${qnaBoardNum}`;
    };

};

