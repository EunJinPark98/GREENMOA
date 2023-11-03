//summer-note
$(document).ready(function() {
    $('#summernote').summernote({
        height : 300,
        minHeight : null,
        maxHeight : null,
        focus : true,
        lang : "ko-KR",
        toolbar: [
            // [groupName, [list of button]]
            ['fontname', ['fontname']],
            ['fontsize', ['fontsize']],
            ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
            ['color', ['forecolor','color']],
            ['table', ['table']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
           // ['insert',['picture','link','video']],
            ['view', ['fullscreen', 'help']]
        ],
        fontNames: ['Dovemayo_gothic', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
        fontNameIgnoreCheck : ['Dovemayo_gothic', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
        fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
    });
});

//첨부된 파일ㅇ 우측의 x버튼 클릭 시 첨부된 파일 삭제
function deleteFile(qnaBoardNum){
    Swal.fire({
        icon: 'question',
        title: '첨부된 파일을 삭제하시겠습니까?',
        showCancelButton: true,
        confirmButtonText: 'Delete',
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                title: "삭제되었습니다.",
                icon: 'success'
            }).then(() => {
                // 확인을 누르면 페이지 이동
                location.href=`/board/deleteFile?qnaBoardNum=${qnaBoardNum}`;
            });
        }
    });





    // Swal.fire({
    //     icon: 'question',
    //     title: 'Do you want to save the changes?',
    //     showDenyButton: true,
    //     showCancelButton: true,
    //     confirmButtonText: 'Save',
    //     denyButtonText: `Don't save`,
    //   }).then((result) => {
    //     /* Read more about isConfirmed, isDenied below */
    //     if (result.isConfirmed) {
    //       Swal.fire('Saved!', '', 'success')
    //     } else if (result.isDenied) {
    //       Swal.fire('Changes are not saved', '', 'info')
    //     }
    //   })




   // if(confirm('첨부된 파일을 삭제하시겠습니까?')){
  //      location.href=`/board/updateFile?qnaBoardNum=${qnaBoardNum}`;
   // }
    
}