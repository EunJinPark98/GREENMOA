//과제 말풍선
let utilMenu = document.querySelector('.utilMenu');
window.onload = function(){
  utilMenu.classList.add('bounce');
}

// 등록 클릭시 todoList insert
function insertTodo(){
    const result = confirm('등록하시겠습니까?');
    let todoContent =document.querySelector('#todoContent').value;
    let todoFinishDate =document.querySelector('#todoFinishDate').value;

    if(result){
        location.href=`/room/insertTodo?todoContent=${todoContent}&todoFinishDate=${todoFinishDate}`
    };
};
// 삭제버튼 클릭시 todoList delete
function deleteTodo(todoNum){
    const result = confirm('정말 삭제하시겠습니까?');
    if(result){
        location.href=`/room/deleteTodoList?todoNum=${todoNum}`;
    };
};



// // todo 리스트 리스트 등록 버튼 클릭시, 내용 눈에 보이기
// let save = document.querySelector('#save');
// save.addEventListener('click',function(e){
//     e.preventDefault();
//     let li = document.createElement('li');
//     let inputContent = document.querySelector('#todoContent').value;
//     li.innerHTML=inputContent;
    
//     let p = document.createElement('p');
//     let inputfinishDate = document.querySelector('#todoFinishDate').value;
//     p.innerHTML = inputfinishDate;

//     let ul = document.querySelector('.todoOutput ul');
//     li.appendChild(p);
//     ul.appendChild(li);
// });
// function insertTodo() {
//     const ul = document.getElementById('todoUl');
//     ul.innerHTML="";
//     const todoContent = document.getElementById('todoContent');
//     todoContent.value=null;
//     const todoFinishDate = document.getElementById('todoFinishDate');
//     todoFinishDate.value=null;
// }

// //todo 리스트 비동기 통신(insert , html상의 리스트 지우기)
// function insertTodo(){
//     let todoContent =document.querySelector('#todoContent').value;
//     let todoFinishDate =document.querySelector('#todoFinishDate').value;
//     let todoWriter =document.querySelector('#todoWriter').value;
//     let memberId =document.querySelector('#memberId').value;

//     // 확인 버튼 클릭시 화면에 표시된 리스트 지우기
//     const ul = document.getElementById('todoUl');
//     ul.innerHTML="";
//     const todoContent1 = document.getElementById('todoContent');
//     todoContent1.value=null;
//     const todoFinishDate1 = document.getElementById('todoFinishDate');
//     todoFinishDate1.value=null;
//     fetch('/room/insertTodo', { //요청경로
//         method: 'POST',
//         cache: 'no-cache',
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
//         },
//         //컨트롤러로 전달할 데이터
//         body: new URLSearchParams({
//             // 데이터명 : 데이터값
//             'todoContent' : todoContent,
//             'todoFinishDate' : todoFinishDate,
//             'todoWriter' : todoWriter,
//             'memberId' : memberId
//         })
//     })
//     .then((response) => {
//         // if(!response.ok){
//         //     alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
//         //     return ;
//         // }
    
//         return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
//         //return response.json(); //나머지 경우에 사용
//     })
//     //fetch 통신 후 실행 영역
//     .then((data) => {//data -> controller에서 리턴되는 데이터!
//         // data는 컨트롤러에서 boolen 으로 받아오기 때문에 data에는 true 혹은 false 이 들어 있다.
//         location.href='/room/myRoom'

//     })
//     //fetch 통신 실패 시 실행 영역
//     .catch(err=>{
//         alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
//         console.log(err);
//     });
// }

// // 선택삭제 버튼 클릭시 실행
// function deleteTodo(){
//     // 체크된 체크박스들
//     const checkedChks = document.querySelectorAll('.chk:checked');
//     // 선택된 상품이 없을 경우
//     if(checkedChks.length==0){
//         alert('삭제할 할 일을 선택하세요.');
//         // 아무것도 없는 return 을 만나면 함수가 끝난다.
//         return ;
//     }
//     if(confirm('선택한 할 일을 삭제하시겠습니까?')){
//         // 모든 todoNums 가져갈 배열 생성
//         let todoListArr=[];

//         // 삭제하고자하는 todoNums 가져오기
//         checkedChks.forEach(function(chk,index){
//             todoListArr[index]=chk.value;
//         });
//         // 삭제하러 이동
//         location.href=`/room/deleteTodoList?todoNums=${todoListArr}`;
//     }
// }


