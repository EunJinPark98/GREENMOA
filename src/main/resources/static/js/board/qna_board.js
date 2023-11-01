// 게시글 삭제 버튼
function deleteQnaBoard(qnaBoardNum){
    Swal.fire({
    title: "게시글을 삭제하시겠습니까?",
    icon: 'error',
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

// 답변 삭제 버튼
function deleteQnaReply(qnaBoardNum, qnaReplyNum){
    Swal.fire({
    title: '답변을 삭제하시겠습니까?',
    icon: 'error',
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

//댓글 더보기
function showQnaReplyMore(qnaBoardNum, qnaReplyLimit){
    console.log("리미트 =" + qnaReplyLimit, "@@@" + qnaBoardNum)

    qnaBoardNum = parseInt(qnaBoardNum);
    qnaReplyLimit = parseInt(qnaReplyLimit);

    location.href = `/board/showQnaReplyMore?qnaReplyLimit=${qnaReplyLimit + 3}&qnaBoardNum=${qnaBoardNum}`

}

// //북마크 기능
// document.addEventListener("DOMContentLoaded", function(){
//     const bookCheck = document.querySelector(".bookCheck");
//     const image = document.querySelector(".bookmark");

//     let isBookmarked = false;

//     bookCheck.addEventListener("click", function(){
//         if (isBookmarked) {
//             image.src = '/images/bookmark-off.png'; // 이미지를 다시 원래 이미지로 변경
//         } else {
//             image.src = '/images/bookmark-on.png'; // 이미지를 변경
//         }
//         isBookmarked = !isBookmarked; // 이미지 상태를 토글
//     })
// })


//북마크 기능
function checkBookMark(imageTag ,qnaBoardNum) {
    // 이미 추가되어 있는 경우 삭제를 수행
    if (imageTag.classList.contains('bookmarked')) {
        // ------------------- 삭제 요청 ---------------//
        fetch('/book/deleteBookMark', {
            method: 'POST',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            body: new URLSearchParams({
                qnaBoardNum : qnaBoardNum
            })
        })
        .then((response) => {
            if (!response.ok) {
                alert('fetch error!\n데이터 삭제 중 오류가 발생했습니다.');
                return;
            }
            // 데이터 삭제가 성공한 경우
            imageTag.classList.remove('bookmarked'); // 버튼 상태 변경
            imageTag.src = '/images/bookmark-off.png';
            console.log('데이터 삭제 성공');


        })
        .catch(err => {
            alert('fetch error!\n데이터 삭제 중 오류가 발생했습니다.');
            console.log(err);
        });
    } else { // 아직 추가되지 않은 경우 추가를 수행
        // ------------------- 추가 요청 ---------------//
        fetch('/book/insertBookMark', {
            method: 'POST',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            body: new URLSearchParams({
                qnaBoardNum : qnaBoardNum
            })
        })
        .then((response) => {
            if (!response.ok) {
                alert('fetch error!\n데이터 추가 중 오류가 발생했습니다.');
                return;
            }
            // 데이터 추가가 성공한 경우
            imageTag.classList.add('bookmarked'); // 버튼 상태 변경
            imageTag.src = '/images/bookmark-on.png';
            console.log('데이터 추가 성공');
        })
        .catch(err => {
            alert('fetch error!\n데이터 추가 중 오류가 발생했습니다.');
            console.log(err);
        });
    }
}

function goQnaBoardDetail(qnaBoardNum){
    location.href=`/board/qnaBoardDetail?qnaBoardNum=${qnaBoardNum}`;
}