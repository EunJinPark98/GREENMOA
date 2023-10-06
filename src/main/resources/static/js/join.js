//주소검색
function searchAddr(){
    new daum.Postcode({
        oncomplete: function(data) {
         document.querySelector('#memberAddr').value = data.roadAddress;
        }
    }).open();
}

//회원가입페이지 가입버튼 누르면
function joinValidate(){
    
    const joinForm = document.querySelector('#joinForm');    

    if(joinForm.memberId.value == ''){
        inputInvalidate('#id-error-div', '아이디를 입력해주세요.');
        return;
    }else if(joinForm.memberId.value.length < 4){
        inputInvalidate('#id-error-div', '아이디는 4자 이상 입력해주세요.');
        return;
    }

    // 정규식 테스트
    var telRegex = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
    const tel = joinForm.memberTels[0].value + '-' + joinForm.memberTels[1].value + '-' + joinForm.memberTels[2].value;
    if(!(telRegex.test(tel))){
        inputInvalidate('#tel-error-div', '연락처를 다시 입력해주세요.');
        return;
    }

    var emailRegex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    const email = joinForm.memberEmails[0].value + joinForm.memberEmails[1].value
    if(!(emailRegex.test(email))){
        inputInvalidate('#email-error-div', '이메일을 다시 입력해주세요.');
        return;
    }

    joinForm.submit();
}

//validate 실패 시 메세지 설정
function inputInvalidate(tagId, msg){
    document.querySelector(tagId).style.display = 'block';
    document.querySelector(tagId).textContent = msg;
}


//아이디 중복확인
function checkId(){
    fetch('/member/checkIdFetch', { 		
        method: 'POST', 		
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        body: new URLSearchParams({
            'memberId' : document.querySelector('#memberId').value
        })
    })
    .then((response) => {
        if(!response.ok){
            return;
        }
        //return response.text();		//컨트롤러에서 return하는 데이터가 없거나 int, String 일 때
        return response.json(); 		//위의 경우 뺀 나머지 (객체, 리스트)
    })
    .then((data) => {
        if(data){
            alert('사용 가능한 아이디입니다.');
            document.querySelector('#joinBtn').disabled = false;
        }else{
            alert('사용 불가능한 아이디입니다.');
        }
    })
    .catch(err=>{
    });
}

//가입버튼 비활성화
function setDisabled(){
    document.querySelector('#joinBtn').disabled = true;
}



//미니미 선택
// 토끼
$('.minimeA').click(function(){
    $('.minimeA_slideList').css({
        display : 'block'
    });
    $('.minime_AB').css({
        display : 'none'
    });
    $('.minimeA_btn').css({
        display : 'flex'
    })

})

$('.minimeA_slideList').slick({
    dots : false,
    prevArrow : '.prev_btnA',
    nextArrow : '.next_btnA',
    slidesToShow : 1,
    centerMode : true,
    variableWidth: true
})

$('.minimeA_1').click(function(){
    var srcValue = $(this).find('img').attr('src');
    $('.my-minime img').attr('src', srcValue);
    $('.minimeInfo').val('minimeA_1');
});
$('.minimeA_2').click(function(){
    var srcValue = $(this).find('img').attr('src');
    $('.my-minime img').attr('src', srcValue);
    $('.minimeInfo').val('minimeA_2');
});
$('.minimeA_3').click(function(){
    var srcValue = $(this).find('img').attr('src');
    $('.my-minime img').attr('src', srcValue);
    $('.minimeInfo').val('minimeA_3');
});
$('.minimeA_4').click(function(){
    var srcValue = $(this).find('img').attr('src');
    $('.my-minime img').attr('src', srcValue);
    $('.minimeInfo').val('minimeA_4');
});


// 여우
$('.minimeB').click(function(){
    $('.minimeB_slideList').css({
        display : 'block'
    });
    $('.minime_AB').css({
        display : 'none'
    });
    $('.minimeB_btn').css({
        display : 'flex'
    })

})

$('.minimeB_slideList').slick({
    dots : false,
    prevArrow : '.prev_btnB',
    nextArrow : '.next_btnB',
    slidesToShow : 1,
    centerMode : true,
    variableWidth: true
})

$('.minimeB_1').click(function(){
    var srcValue = $(this).find('img').attr('src');
    $('.my-minime img').attr('src', srcValue);
    $('.minimeInfo').val('minimeB_1');
});
$('.minimeB_2').click(function(){
    var srcValue = $(this).find('img').attr('src');
    $('.my-minime img').attr('src', srcValue);
    $('.minimeInfo').val('minimeB_2');
});
$('.minimeB_3').click(function(){
    var srcValue = $(this).find('img').attr('src');
    $('.my-minime img').attr('src', srcValue);
    $('.minimeInfo').val('minimeB_3');
});
$('.minimeB_4').click(function(){
    var srcValue = $(this).find('img').attr('src');
    $('.my-minime img').attr('src', srcValue);
    $('.minimeInfo').val('minimeB_4');
});


$('.minime-choice').click(function(){
    $('.minimeA_slideList').css({
        display : 'none'
    });
    $('.minimeB_slideList').css({
        display : 'none'
    });
    $('.minime_AB').css({
        display : 'flex'
    });
})