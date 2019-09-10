package com.siyu.em.Util;

import java.util.List;

public class PageUtil {
    private int currentPageNum;
    private int pageSize=10;
    private int totalSize;
    private int totalPageNum;
    private int index;
    private int prePageNum;
    private int nextPageNum;

    private List resultList;

    private int startPage;
    private int endPage;

    public PageUtil(int currentPageNum,int totalSize){
        this.currentPageNum=currentPageNum;
        this.totalSize=totalSize;
        index=(currentPageNum-1)*pageSize;
        totalPageNum=(totalSize%pageSize==0)?totalSize/pageSize:totalSize/pageSize+1;
        prePageNum=(currentPageNum==1)?currentPageNum:currentPageNum-1;
        nextPageNum=(currentPageNum==totalPageNum)?totalPageNum:totalPageNum+1;

        if(currentPageNum>=5){
            if(currentPageNum+4<totalPageNum){
                startPage=currentPageNum;
                endPage=currentPageNum+4;
            }
            else{
                startPage=currentPageNum-4;
                endPage=totalPageNum;
            }
        }
        else{
            startPage=1;
            endPage=5;
        }
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPrePageNum() {
        return prePageNum;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public List getResultList() {
        return resultList;
    }

    public void setResultList(List resultList) {
        this.resultList = resultList;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
