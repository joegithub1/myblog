package com.joe.myblog.oa.po;

import java.util.ArrayList;
import java.util.List;

public class TMenuAdminRefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMenuAdminRefExample() {
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

        public Criteria andMenuRoleIdIsNull() {
            addCriterion("menu_role_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdIsNotNull() {
            addCriterion("menu_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdEqualTo(Integer value) {
            addCriterion("menu_role_id =", value, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdNotEqualTo(Integer value) {
            addCriterion("menu_role_id <>", value, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdGreaterThan(Integer value) {
            addCriterion("menu_role_id >", value, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_role_id >=", value, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdLessThan(Integer value) {
            addCriterion("menu_role_id <", value, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_role_id <=", value, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdIn(List<Integer> values) {
            addCriterion("menu_role_id in", values, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdNotIn(List<Integer> values) {
            addCriterion("menu_role_id not in", values, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_role_id between", value1, value2, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_role_id not between", value1, value2, "menuRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeIsNull() {
            addCriterion("menu_admin_type is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeIsNotNull() {
            addCriterion("menu_admin_type is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeEqualTo(Integer value) {
            addCriterion("menu_admin_type =", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeNotEqualTo(Integer value) {
            addCriterion("menu_admin_type <>", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeGreaterThan(Integer value) {
            addCriterion("menu_admin_type >", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_type >=", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeLessThan(Integer value) {
            addCriterion("menu_admin_type <", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeLessThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_type <=", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeIn(List<Integer> values) {
            addCriterion("menu_admin_type in", values, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeNotIn(List<Integer> values) {
            addCriterion("menu_admin_type not in", values, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_type between", value1, value2, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_type not between", value1, value2, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdIsNull() {
            addCriterion("menu_admin_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdIsNotNull() {
            addCriterion("menu_admin_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdEqualTo(Integer value) {
            addCriterion("menu_admin_admin_id =", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdNotEqualTo(Integer value) {
            addCriterion("menu_admin_admin_id <>", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdGreaterThan(Integer value) {
            addCriterion("menu_admin_admin_id >", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_admin_id >=", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdLessThan(Integer value) {
            addCriterion("menu_admin_admin_id <", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_admin_id <=", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdIn(List<Integer> values) {
            addCriterion("menu_admin_admin_id in", values, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdNotIn(List<Integer> values) {
            addCriterion("menu_admin_admin_id not in", values, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_admin_id between", value1, value2, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_admin_id not between", value1, value2, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdIsNull() {
            addCriterion("menu_role_menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdIsNotNull() {
            addCriterion("menu_role_menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdEqualTo(Integer value) {
            addCriterion("menu_role_menu_id =", value, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_role_menu_id <>", value, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdGreaterThan(Integer value) {
            addCriterion("menu_role_menu_id >", value, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_role_menu_id >=", value, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdLessThan(Integer value) {
            addCriterion("menu_role_menu_id <", value, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_role_menu_id <=", value, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdIn(List<Integer> values) {
            addCriterion("menu_role_menu_id in", values, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_role_menu_id not in", values, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_role_menu_id between", value1, value2, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_role_menu_id not between", value1, value2, "menuRoleMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdIsNull() {
            addCriterion("menu_role_role_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdIsNotNull() {
            addCriterion("menu_role_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdEqualTo(Integer value) {
            addCriterion("menu_role_role_id =", value, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdNotEqualTo(Integer value) {
            addCriterion("menu_role_role_id <>", value, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdGreaterThan(Integer value) {
            addCriterion("menu_role_role_id >", value, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_role_role_id >=", value, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdLessThan(Integer value) {
            addCriterion("menu_role_role_id <", value, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_role_role_id <=", value, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdIn(List<Integer> values) {
            addCriterion("menu_role_role_id in", values, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdNotIn(List<Integer> values) {
            addCriterion("menu_role_role_id not in", values, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_role_role_id between", value1, value2, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_role_role_id not between", value1, value2, "menuRoleRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateIsNull() {
            addCriterion("menu_role_create_date is null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateIsNotNull() {
            addCriterion("menu_role_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateEqualTo(String value) {
            addCriterion("menu_role_create_date =", value, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateNotEqualTo(String value) {
            addCriterion("menu_role_create_date <>", value, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateGreaterThan(String value) {
            addCriterion("menu_role_create_date >", value, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("menu_role_create_date >=", value, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateLessThan(String value) {
            addCriterion("menu_role_create_date <", value, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateLessThanOrEqualTo(String value) {
            addCriterion("menu_role_create_date <=", value, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateLike(String value) {
            addCriterion("menu_role_create_date like", value, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateNotLike(String value) {
            addCriterion("menu_role_create_date not like", value, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateIn(List<String> values) {
            addCriterion("menu_role_create_date in", values, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateNotIn(List<String> values) {
            addCriterion("menu_role_create_date not in", values, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateBetween(String value1, String value2) {
            addCriterion("menu_role_create_date between", value1, value2, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleCreateDateNotBetween(String value1, String value2) {
            addCriterion("menu_role_create_date not between", value1, value2, "menuRoleCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridIsNull() {
            addCriterion("menu_role_operatorid is null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridIsNotNull() {
            addCriterion("menu_role_operatorid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridEqualTo(Integer value) {
            addCriterion("menu_role_operatorid =", value, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridNotEqualTo(Integer value) {
            addCriterion("menu_role_operatorid <>", value, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridGreaterThan(Integer value) {
            addCriterion("menu_role_operatorid >", value, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_role_operatorid >=", value, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridLessThan(Integer value) {
            addCriterion("menu_role_operatorid <", value, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridLessThanOrEqualTo(Integer value) {
            addCriterion("menu_role_operatorid <=", value, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridIn(List<Integer> values) {
            addCriterion("menu_role_operatorid in", values, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridNotIn(List<Integer> values) {
            addCriterion("menu_role_operatorid not in", values, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridBetween(Integer value1, Integer value2) {
            addCriterion("menu_role_operatorid between", value1, value2, "menuRoleOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuRoleOperatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_role_operatorid not between", value1, value2, "menuRoleOperatorid");
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