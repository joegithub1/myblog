package com.joe.myblog.oa.po;

public class TAdmin {
    private Integer backuserId;

    private String backuserName;

    private String backuserPwd;

    private Integer backuserRoleId;

    private String backuserMobliePhone;

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
}