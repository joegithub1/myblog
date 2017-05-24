package com.joe.myblog.oa.po;

public class TDictionary {
    private Integer id;

    private String dName;

    private Integer dValue;

    private Integer dType;

    private Integer dStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Integer getdValue() {
        return dValue;
    }

    public void setdValue(Integer dValue) {
        this.dValue = dValue;
    }

    public Integer getdType() {
        return dType;
    }

    public void setdType(Integer dType) {
        this.dType = dType;
    }

    public Integer getdStatus() {
        return dStatus;
    }

    public void setdStatus(Integer dStatus) {
        this.dStatus = dStatus;
    }
}