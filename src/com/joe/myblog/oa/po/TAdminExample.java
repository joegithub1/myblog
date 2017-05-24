package com.joe.myblog.oa.po;

import java.util.ArrayList;
import java.util.List;

public class TAdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAdminExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBackuserIdIsNull() {
            addCriterion("backuser_id is null");
            return (Criteria) this;
        }

        public Criteria andBackuserIdIsNotNull() {
            addCriterion("backuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackuserIdEqualTo(Integer value) {
            addCriterion("backuser_id =", value, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdNotEqualTo(Integer value) {
            addCriterion("backuser_id <>", value, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdGreaterThan(Integer value) {
            addCriterion("backuser_id >", value, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("backuser_id >=", value, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdLessThan(Integer value) {
            addCriterion("backuser_id <", value, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdLessThanOrEqualTo(Integer value) {
            addCriterion("backuser_id <=", value, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdIn(List<Integer> values) {
            addCriterion("backuser_id in", values, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdNotIn(List<Integer> values) {
            addCriterion("backuser_id not in", values, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdBetween(Integer value1, Integer value2) {
            addCriterion("backuser_id between", value1, value2, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("backuser_id not between", value1, value2, "backuserId");
            return (Criteria) this;
        }

        public Criteria andBackuserNameIsNull() {
            addCriterion("backuser_name is null");
            return (Criteria) this;
        }

        public Criteria andBackuserNameIsNotNull() {
            addCriterion("backuser_name is not null");
            return (Criteria) this;
        }

        public Criteria andBackuserNameEqualTo(String value) {
            addCriterion("backuser_name =", value, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameNotEqualTo(String value) {
            addCriterion("backuser_name <>", value, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameGreaterThan(String value) {
            addCriterion("backuser_name >", value, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameGreaterThanOrEqualTo(String value) {
            addCriterion("backuser_name >=", value, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameLessThan(String value) {
            addCriterion("backuser_name <", value, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameLessThanOrEqualTo(String value) {
            addCriterion("backuser_name <=", value, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameLike(String value) {
            addCriterion("backuser_name like", value, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameNotLike(String value) {
            addCriterion("backuser_name not like", value, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameIn(List<String> values) {
            addCriterion("backuser_name in", values, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameNotIn(List<String> values) {
            addCriterion("backuser_name not in", values, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameBetween(String value1, String value2) {
            addCriterion("backuser_name between", value1, value2, "backuserName");
            return (Criteria) this;
        }

        public Criteria andBackuserNameNotBetween(String value1, String value2) {
            addCriterion("backuser_name not between", value1, value2, "backuserName");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andShowNameIsNull() {
            addCriterion("show_name is null");
            return (Criteria) this;
        }

        public Criteria andShowNameIsNotNull() {
            addCriterion("show_name is not null");
            return (Criteria) this;
        }

        public Criteria andShowNameEqualTo(String value) {
            addCriterion("show_name =", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotEqualTo(String value) {
            addCriterion("show_name <>", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameGreaterThan(String value) {
            addCriterion("show_name >", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameGreaterThanOrEqualTo(String value) {
            addCriterion("show_name >=", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLessThan(String value) {
            addCriterion("show_name <", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLessThanOrEqualTo(String value) {
            addCriterion("show_name <=", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLike(String value) {
            addCriterion("show_name like", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotLike(String value) {
            addCriterion("show_name not like", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameIn(List<String> values) {
            addCriterion("show_name in", values, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotIn(List<String> values) {
            addCriterion("show_name not in", values, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameBetween(String value1, String value2) {
            addCriterion("show_name between", value1, value2, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotBetween(String value1, String value2) {
            addCriterion("show_name not between", value1, value2, "showName");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdIsNull() {
            addCriterion("backuser_pwd is null");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdIsNotNull() {
            addCriterion("backuser_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdEqualTo(String value) {
            addCriterion("backuser_pwd =", value, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdNotEqualTo(String value) {
            addCriterion("backuser_pwd <>", value, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdGreaterThan(String value) {
            addCriterion("backuser_pwd >", value, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("backuser_pwd >=", value, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdLessThan(String value) {
            addCriterion("backuser_pwd <", value, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdLessThanOrEqualTo(String value) {
            addCriterion("backuser_pwd <=", value, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdLike(String value) {
            addCriterion("backuser_pwd like", value, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdNotLike(String value) {
            addCriterion("backuser_pwd not like", value, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdIn(List<String> values) {
            addCriterion("backuser_pwd in", values, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdNotIn(List<String> values) {
            addCriterion("backuser_pwd not in", values, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdBetween(String value1, String value2) {
            addCriterion("backuser_pwd between", value1, value2, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserPwdNotBetween(String value1, String value2) {
            addCriterion("backuser_pwd not between", value1, value2, "backuserPwd");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdIsNull() {
            addCriterion("backuser_role_id is null");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdIsNotNull() {
            addCriterion("backuser_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdEqualTo(Integer value) {
            addCriterion("backuser_role_id =", value, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdNotEqualTo(Integer value) {
            addCriterion("backuser_role_id <>", value, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdGreaterThan(Integer value) {
            addCriterion("backuser_role_id >", value, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("backuser_role_id >=", value, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdLessThan(Integer value) {
            addCriterion("backuser_role_id <", value, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("backuser_role_id <=", value, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdIn(List<Integer> values) {
            addCriterion("backuser_role_id in", values, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdNotIn(List<Integer> values) {
            addCriterion("backuser_role_id not in", values, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("backuser_role_id between", value1, value2, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("backuser_role_id not between", value1, value2, "backuserRoleId");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneIsNull() {
            addCriterion("backuser_moblie_phone is null");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneIsNotNull() {
            addCriterion("backuser_moblie_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneEqualTo(String value) {
            addCriterion("backuser_moblie_phone =", value, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneNotEqualTo(String value) {
            addCriterion("backuser_moblie_phone <>", value, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneGreaterThan(String value) {
            addCriterion("backuser_moblie_phone >", value, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("backuser_moblie_phone >=", value, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneLessThan(String value) {
            addCriterion("backuser_moblie_phone <", value, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneLessThanOrEqualTo(String value) {
            addCriterion("backuser_moblie_phone <=", value, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneLike(String value) {
            addCriterion("backuser_moblie_phone like", value, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneNotLike(String value) {
            addCriterion("backuser_moblie_phone not like", value, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneIn(List<String> values) {
            addCriterion("backuser_moblie_phone in", values, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneNotIn(List<String> values) {
            addCriterion("backuser_moblie_phone not in", values, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneBetween(String value1, String value2) {
            addCriterion("backuser_moblie_phone between", value1, value2, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andBackuserMobliePhoneNotBetween(String value1, String value2) {
            addCriterion("backuser_moblie_phone not between", value1, value2, "backuserMobliePhone");
            return (Criteria) this;
        }

        public Criteria andImgPathIsNull() {
            addCriterion("img_path is null");
            return (Criteria) this;
        }

        public Criteria andImgPathIsNotNull() {
            addCriterion("img_path is not null");
            return (Criteria) this;
        }

        public Criteria andImgPathEqualTo(String value) {
            addCriterion("img_path =", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotEqualTo(String value) {
            addCriterion("img_path <>", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathGreaterThan(String value) {
            addCriterion("img_path >", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("img_path >=", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLessThan(String value) {
            addCriterion("img_path <", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLessThanOrEqualTo(String value) {
            addCriterion("img_path <=", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLike(String value) {
            addCriterion("img_path like", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotLike(String value) {
            addCriterion("img_path not like", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathIn(List<String> values) {
            addCriterion("img_path in", values, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotIn(List<String> values) {
            addCriterion("img_path not in", values, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathBetween(String value1, String value2) {
            addCriterion("img_path between", value1, value2, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotBetween(String value1, String value2) {
            addCriterion("img_path not between", value1, value2, "imgPath");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}