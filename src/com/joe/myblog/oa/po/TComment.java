package com.joe.myblog.oa.po;

public class TComment {
    private Integer id;

    private Integer articleId;

    private String plUser;

    private String userUrl;

    private String plContent;

    private String createDate;

    private Integer status;

    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getPlUser() {
        return plUser;
    }

    public void setPlUser(String plUser) {
        this.plUser = plUser == null ? null : plUser.trim();
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl == null ? null : userUrl.trim();
    }

    public String getPlContent() {
        return plContent;
    }

    public void setPlContent(String plContent) {
        this.plContent = plContent == null ? null : plContent.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}