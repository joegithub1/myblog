package com.joe.myblog.oa.po;

public class TAdminAuthRef {
    private Integer adminAuthId;

    private Integer adminAuthAuthId;

    private Integer adminAuthRoleId;

    private Integer adminAuthAdminId;

    private String adminAuthCreateDate;

    private Integer adminAuthOperatorid;

    public Integer getAdminAuthId() {
        return adminAuthId;
    }

    public void setAdminAuthId(Integer adminAuthId) {
        this.adminAuthId = adminAuthId;
    }

    public Integer getAdminAuthAuthId() {
        return adminAuthAuthId;
    }

    public void setAdminAuthAuthId(Integer adminAuthAuthId) {
        this.adminAuthAuthId = adminAuthAuthId;
    }

    public Integer getAdminAuthRoleId() {
        return adminAuthRoleId;
    }

    public void setAdminAuthRoleId(Integer adminAuthRoleId) {
        this.adminAuthRoleId = adminAuthRoleId;
    }

    public Integer getAdminAuthAdminId() {
        return adminAuthAdminId;
    }

    public void setAdminAuthAdminId(Integer adminAuthAdminId) {
        this.adminAuthAdminId = adminAuthAdminId;
    }

    public String getAdminAuthCreateDate() {
        return adminAuthCreateDate;
    }

    public void setAdminAuthCreateDate(String adminAuthCreateDate) {
        this.adminAuthCreateDate = adminAuthCreateDate == null ? null : adminAuthCreateDate.trim();
    }

    public Integer getAdminAuthOperatorid() {
        return adminAuthOperatorid;
    }

    public void setAdminAuthOperatorid(Integer adminAuthOperatorid) {
        this.adminAuthOperatorid = adminAuthOperatorid;
    }
}