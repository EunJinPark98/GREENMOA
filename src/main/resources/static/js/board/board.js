function goDelete(boardNum){
    const result = confirm('정말 삭제하시겠습니까?');
    if(result){
        location.href=`/board/deleteBoard?boardNum=${boardNum}`;
    };
};

function goUpdate(boardNum){
    location.href=`/board/updateBoardForm?boardNum=${boardNum}`;
}