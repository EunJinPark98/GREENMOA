
//첨부된 파일ㅇ 우측의 x버튼 클릭 시 첨부된 파일 삭제
function deleteFile(qnaBoardNum){
    Swal.fire({
        icon: 'question',
        title: '첨부된 파일을 삭제하시겠습니까?',
        showCancelButton: true,
        confirmButtonText: 'Confirm',
    }).then((result) => {
        if (result.isConfirmed) {
            location.href=`/board/deleteFile?qnaBoardNum=${qnaBoardNum}`;
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