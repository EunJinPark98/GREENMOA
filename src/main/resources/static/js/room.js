//과제 말풍선
let utilMenu = document.querySelector('.utilMenu');
window.onload = function(){
  utilMenu.classList.add('bounce');
}

//todo 리스트 비동기 통신
function insertTodo(){
  let todoContent =document.querySelector('#todoContent').value;
  let todoFinishDate =document.querySelector('#todoFinishDate').value;
  let todoWriter =document.querySelector('#todoWriter').value;
  fetch('/room/insertTodo', { //요청경로
      method: 'POST',
      cache: 'no-cache',
      headers: {
          'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
      },
      //컨트롤러로 전달할 데이터
      body: new URLSearchParams({
         // 데이터명 : 데이터값
         'todoContent' : todoContent,
         'todoFinishDate' : todoFinishDate,
         'todoWriter' : todoWriter
      })
  })
  .then((response) => {
      if(!response.ok){
          alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
          return ;
      }
  
      //return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
      return response.json(); //나머지 경우에 사용
  })
  //fetch 통신 후 실행 영역
  .then((data) => {//data -> controller에서 리턴되는 데이터!
      // data는 컨트롤러에서 boolen 으로 받아오기 때문에 data에는 true 혹은 false 이 들어 있다.


  })
  //fetch 통신 실패 시 실행 영역
  .catch(err=>{
      alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
      console.log(err);
  });
}
