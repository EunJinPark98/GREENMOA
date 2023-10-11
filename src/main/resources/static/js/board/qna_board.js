function deleteQnaBoard(qnaBoardNum){
    const result = confirm("삭제하시겠습니까??")
    if(result){
        location.href=`/board/deleteQnaBoard?qnaBoardNum=${qnaBoardNum}`;
    };
}

function updateQnaBoard(qnaBoardNum){
    location.href=`/board/updateQnaBoardPage?qnaBoardNum=${qnaBoardNum}`;
}