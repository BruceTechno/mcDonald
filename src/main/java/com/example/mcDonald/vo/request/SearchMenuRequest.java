package com.example.mcDonald.vo.request;

public class SearchMenuRequest {
    private String keyword;
    private int limitNum;
//==

    public SearchMenuRequest() {
    }
//==
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }
}
