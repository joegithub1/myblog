package com.joe.myblog.oa.po;

public class TConfig {
    private Integer tId;

    private String tName;

    private String tValue;

    private String tMark;

    private Integer tStatus;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettValue() {
        return tValue;
    }

    public void settValue(String tValue) {
        this.tValue = tValue == null ? null : tValue.trim();
    }

    public String gettMark() {
        return tMark;
    }

    public void settMark(String tMark) {
        this.tMark = tMark == null ? null : tMark.trim();
    }

    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
    }
}