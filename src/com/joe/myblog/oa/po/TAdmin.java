package com.joe.myblog.oa.po;

public class TAdmin {
    private Integer backuserId;

    private String backuserName;

    private String userEmail;

    private String showName;

    private String backuserPwd;

    private Integer backuserRoleId;

    private String backuserMobliePhone;

    private String imgPath;

    private Integer status;

    public Integer getBackuserId() {
        return backuserId;
    }

    public void setBackuserId(Integer backuserId) {
        this.backuserId = backuserId;
    }

    public String getBackuserName() {
        return backuserName;
    }

    public void setBackuserName(String backuserName) {
        this.backuserName = backuserName == null ? null : backuserName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getBackuserPwd() {
        return backuserPwd;
    }

    public void setBackuserPwd(String backuserPwd) {
        this.backuserPwd = backuserPwd == null ? null : backuserPwd.trim();
    }

    public Integer getBackuserRoleId() {
        return backuserRoleId;
    }

    public void setBackuserRoleId(Integer backuserRoleId) {
        this.backuserRoleId = backuserRoleId;
    }

    public String getBackuserMobliePhone() {
        return backuserMobliePhone;
    }

    public void setBackuserMobliePhone(String backuserMobliePhone) {
        this.backuserMobliePhone = backuserMobliePhone == null ? null : backuserMobliePhone.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}