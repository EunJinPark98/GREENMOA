package com.green.GreenClassRoom.board.vo;

public class QnaPageVO {
    private int nowPage; //현재 페이지 번호
    private int totalDataCnt; //전체 데이터 개수
    private int displayDataCnt; //한 페이지에 보여지는 데이터의 수
    private int beginPage; // 화면에 보이는 첫번째 페이지 번호
    private int endPage; // 화면에 보이는 마지막 페이지 번호
    private int displayPageCnt; // 한번에 보여지는 페이지 수
    private boolean prev; // 이전 버튼의 유무
    private boolean next; // 다음 버튼의 유무

    public QnaPageVO(){
        nowPage = 1;
        displayPageCnt = 10;
        displayDataCnt = 10;
    }

    //마지막 페이지
    public void setPageInfo(){
        endPage = (int) Math.ceil(nowPage / (double)displayPageCnt) * displayPageCnt;
        beginPage = endPage - displayPageCnt + 1;

        //전체 페이지 수
        int totalPageCnt = (int) Math.ceil(totalDataCnt / (double)displayDataCnt);

        //next 버튼 유무
        if(endPage < totalPageCnt){
            next = true;
        }
        else {
            next = false;
            endPage = totalPageCnt;
        }

        //prev 버튼 유무
        if(beginPage == 1){
            prev = false;
        }
        else {
            prev = true;
        }
    }

    //전체 데이터 수 setter
    public void setTotalDataCnt(int totalDataCnt){
        this.totalDataCnt = totalDataCnt;
    }

    //현재 페이지 getter
    public int getNowPage(){
        return nowPage;
    }

    //현재페이지 setter
    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    //displayDataCnt getter
    public int getDisplayDataCnt() {
        return displayDataCnt;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean getNext(){
        return next;
    }

    public boolean getPrev(){
        return prev;
    }
}
