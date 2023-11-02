//게시글 삭제 버튼
function goDelete(boardNum){
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
        Swal.fire({
            title: "삭제되었습니다.",
            icon: 'success'
        }).then(() => {
            // 확인을 누르면 페이지 이동
        location.href=`/board/deleteBoard?boardNum=${boardNum}`
        });
    }
    })
}


// 게시글 수정 버튼
function goUpdate(boardNum){
    location.href=`/board/updateBoardForm?boardNum=${boardNum}`;
}

// 댓글 삭제 버튼
function deleteReply(boardNum, replyNum){
    Swal.fire({
    title: '댓글을 삭제하시겠습니까?',
    icon: 'error',
    showCancelButton: true,
    confirmButtonColor: '#9c8277',
    cancelButtonColor: '#767f87',
    confirmButtonText: '삭제',
    cancelButtonText: '취소',
    }).then((result) => {
    if (result.isConfirmed) {
        Swal.fire({
            title: "삭제되었습니다.",
            icon: 'success'
        }).then(() => {
            // 확인을 누르면 페이지 이동
        location.href=`/board/deleteReply?replyNum=${replyNum}&boardNum=${boardNum}`;
        });
    }
    })
};

// 댓글 이모지 드롭다운 선택
function changeEmoji(emojiURL){
    let selectImg = document.querySelector('.selectImg');
    selectImg.src = emojiURL;

    let replyEmojiInput = document.querySelector(".resultEmoji[name='replyEmoji']");
    replyEmojiInput.value = emojiURL;
}



// 공지 삭제
function noticeDelete(noticeBoardNum){
    Swal.fire({
        title: "공지를 삭제하시겠습니까?",
        icon: 'error',
        showCancelButton: true,
        confirmButtonColor: '#9c8277',
        cancelButtonColor: '#767f87',
        confirmButtonText: '삭제',
        cancelButtonText: '취소',
        }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                title: "삭제되었습니다.",
                icon: 'success'
            }).then(() => {
                // 확인을 누르면 페이지 이동
            location.href=`/board/deleteNotice?noticeBoardNum=${noticeBoardNum}`
            });
        }
    })
}

//댓글 더보기
function showReplyMore(boardNum, limitUp){
   console.log("리미트 =" + limitUp + "@@@"+ boardNum)

    boardNum = parseInt(boardNum);
    limitUp = parseInt(limitUp);

    location.href = `/board/showReplyMore?limit=${limitUp + 3}&boardNum=${boardNum}`;
    
}

//자유게시판 북마크 기능
function checkFreeBookMark(imageTag ,BoardNum) {
    // 이미 추가되어 있는 경우 삭제를 수행
    if (imageTag.classList.contains('bookmarked')) {
        // ------------------- 삭제 요청 ---------------//
        fetch('/book/deleteFreeBookMark', {
            method: 'POST',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            body: new URLSearchParams({
                BoardNum : BoardNum
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
        fetch('/book/insertFreeBookMark', {
            method: 'POST',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            body: new URLSearchParams({
                BoardNum : BoardNum
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

//공지사항 북마크 기능
function checkNoticeBookMark(imageTag, noticeBoardNum) {
    // 이미 추가되어 있는 경우 삭제를 수행
    if (imageTag.classList.contains('bookmarks')) {
        // ------------------- 삭제 요청 ---------------//
        fetch('/book/deleteNoticeBookMark', {
            method: 'POST',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            body: new URLSearchParams({
                noticeBoardNum : noticeBoardNum
            })
        })
        .then((response) => {
            if (!response.ok) {
                alert('fetch error!\n데이터 삭제 중 오류가 발생했습니다.');
                return;
            }
            // 데이터 삭제가 성공한 경우
            imageTag.classList.remove('bookmarks'); // 버튼 상태 변경
            imageTag.src = '/images/bookmark-off.png';
            console.log('데이터 삭제 성공');


        })
        .catch(err => {
            alert('fetch error!\n데이터 삭제 중 오류가 발생했습니다.');
            console.log(err);
        });
    } else { // 아직 추가되지 않은 경우 추가를 수행
        // ------------------- 추가 요청 ---------------//
        fetch('/book/insertNoticeBookMark', {
            method: 'POST',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            body: new URLSearchParams({
                noticeBoardNum : noticeBoardNum
            })
        })
        .then((response) => {
            if (!response.ok) {
                alert('fetch error!\n데이터 추가 중 오류가 발생했습니다.');
                return;
            }
            // 데이터 추가가 성공한 경우
            imageTag.classList.add('bookmarks'); // 버튼 상태 변경
            imageTag.src = '/images/bookmark-on.png';
            console.log('데이터 추가 성공');
        })
        .catch(err => {
            alert('fetch error!\n데이터 추가 중 오류가 발생했습니다.');
            console.log(err);
        });
    }
}

//자유게시판 Detail로 가기
function goFreeBoardDetail(boardNum){
    location.href=`/board/freeBoardDetail?boardNum=${boardNum}`;
}

//공지사항 Detail로 가기
function goNoticeBoardDetail(noticeBoardNum){
    location.href=`/board/noticeBoardDetail?noticeBoardNum=${noticeBoardNum}`;
}