package com.joe.myblog.oa.po;

public class TMenuAdminRef {
    private Integer menuRoleId;

    private Integer menuAdminType;

    private Integer menuAdminAdminId;

    private Integer menuRoleMenuId;

    private Integer menuRoleRoleId;

    private String menuRoleCreateDate;

    private Integer menuRoleOperatorid;

    public Integer getMenuRoleId() {
        return menuRoleId;
    }

    public void setMenuRoleId(Integer menuRoleId) {
        this.menuRoleId = menuRoleId;
    }

    public Integer getMenuAdminType() {
        return menuAdminType;
    }

    public void setMenuAdminType(Integer menuAdminType) {
        this.menuAdminType = menuAdminType;
    }

    public Integer getMenuAdminAdminId() {
        return menuAdminAdminId;
    }

    public void setMenuAdminAdminId(Integer menuAdminAdminId) {
        this.menuAdminAdminId = menuAdminAdminId;
    }

    public Integer getMenuRoleMenuId() {
        return menuRoleMenuId;
    }

    public void setMenuRoleMenuId(Integer menuRoleMenuId) {
        this.menuRoleMenuId = menuRoleMenuId;
    }

    public Integer getMenuRoleRoleId() {
        return menuRoleRoleId;
    }

    public void setMenuRoleRoleId(Integer menuRoleRoleId) {
        this.menuRoleRoleId = menuRoleRoleId;
    }

    public String getMenuRoleCreateDate() {
        return menuRoleCreateDate;
    }

    public void setMenuRoleCreateDate(String menuRoleCreateDate) {
        this.menuRoleCreateDate = menuRoleCreateDate == null ? null : menuRoleCreateDate.trim();
    }

    public Integer getMenuRoleOperatorid() {
        return menuRoleOperatorid;
    }

    public void setMenuRoleOperatorid(Integer menuRoleOperatorid) {
        this.menuRoleOperatorid = menuRoleOperatorid;
    }
}