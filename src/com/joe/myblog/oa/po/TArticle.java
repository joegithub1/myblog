package com.joe.myblog.oa.po;

public class TArticle {
    private Integer id;

    private String title;

    private String smaillTitle;

    private Integer articleType;

    private String content;

    private String crateDate;

    private Integer readNum;

    private Integer status;

    private Integer publishUseId;

    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSmaillTitle() {
        return smaillTitle;
    }

    public void setSmaillTitle(String smaillTitle) {
        this.smaillTitle = smaillTitle == null ? null : smaillTitle.trim();
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCrateDate() {
        return crateDate;
    }

    public void setCrateDate(String crateDate) {
        this.crateDate = crateDate == null ? null : crateDate.trim();
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPublishUseId() {
        return publishUseId;
    }

    public void setPublishUseId(Integer publishUseId) {
        this.publishUseId = publishUseId;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}