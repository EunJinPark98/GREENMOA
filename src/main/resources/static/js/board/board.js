function goDelete(boardNum){
    const result = confirm('정말 삭제하시겠습니까?');
    if(result){
        location.href=`/board/deleteBoard?boardNum=${boardNum}`;
    };
};

function goUpdate(boardNum){
    location.href=`/board/updateBoardForm?boardNum=${boardNum}`;
}

// 댓글 체크박스 해제시 전체 체크박스 해제
function checkSelectAll(){
    // 제목줄의 체크박스
    const selectAll = document.querySelector('input[name="allCheck"]')
    // 내용부에 있는 모든 체크박스
    const checkboxes = document.querySelectorAll('input[name="innerCheck"]');
    // 내용부에 체크되어 있는 체크박스
    const checked = document.querySelectorAll('input[name="innerCheck"]:checked');
    

    if(checkboxes.length==checked.length){
        selectAll.checked = true;
    }
    else{
        selectAll.checked =false;
    }

} 

// 댓글 체크박스 선택시 전체 체크박스 선택
function selectAll(selectAll){
    const checkboxes = document.getElementsByName('innerCheck');

    checkboxes.forEach((checkbox)=>{
        checkbox.checked =selectAll.checked
    })

}

// 선택삭제 버튼 클릭시 실행
function deleteReply(boardNum){
    // 체크된 체크박스들
    const checkedChks = document.querySelectorAll('.chk:checked');
    // 선택된 상품이 없을 경우
    if(checkedChks.length==0){
        alert('삭제할 댓글을 선택하세요.');
        // 아무것도 없는 return 을 만나면 함수가 끝난다.
        return ;
    }
    if(confirm('선택한 댓글을 삭제하시겠습니까?')){
        // 모든 replyNum 가져갈 배열 생성
        let replyNumArr=[];

        // 삭제하고자하는 replyNum 가져오기
        checkedChks.forEach(function(chk,index){
            replyNumArr[index]=chk.value;
        });
        // 삭제하러 이동
        location.href=`/board/deleteReply?replyNums=${replyNumArr}&boardNum=${boardNum}`;
    }
}