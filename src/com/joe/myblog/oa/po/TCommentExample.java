package com.joe.myblog.oa.po;

import java.util.ArrayList;
import java.util.List;

public class TCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCommentExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andPlUserIsNull() {
            addCriterion("pl_user is null");
            return (Criteria) this;
        }

        public Criteria andPlUserIsNotNull() {
            addCriterion("pl_user is not null");
            return (Criteria) this;
        }

        public Criteria andPlUserEqualTo(String value) {
            addCriterion("pl_user =", value, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserNotEqualTo(String value) {
            addCriterion("pl_user <>", value, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserGreaterThan(String value) {
            addCriterion("pl_user >", value, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserGreaterThanOrEqualTo(String value) {
            addCriterion("pl_user >=", value, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserLessThan(String value) {
            addCriterion("pl_user <", value, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserLessThanOrEqualTo(String value) {
            addCriterion("pl_user <=", value, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserLike(String value) {
            addCriterion("pl_user like", value, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserNotLike(String value) {
            addCriterion("pl_user not like", value, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserIn(List<String> values) {
            addCriterion("pl_user in", values, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserNotIn(List<String> values) {
            addCriterion("pl_user not in", values, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserBetween(String value1, String value2) {
            addCriterion("pl_user between", value1, value2, "plUser");
            return (Criteria) this;
        }

        public Criteria andPlUserNotBetween(String value1, String value2) {
            addCriterion("pl_user not between", value1, value2, "plUser");
            return (Criteria) this;
        }

        public Criteria andUserUrlIsNull() {
            addCriterion("user_url is null");
            return (Criteria) this;
        }

        public Criteria andUserUrlIsNotNull() {
            addCriterion("user_url is not null");
            return (Criteria) this;
        }

        public Criteria andUserUrlEqualTo(String value) {
            addCriterion("user_url =", value, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlNotEqualTo(String value) {
            addCriterion("user_url <>", value, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlGreaterThan(String value) {
            addCriterion("user_url >", value, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlGreaterThanOrEqualTo(String value) {
            addCriterion("user_url >=", value, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlLessThan(String value) {
            addCriterion("user_url <", value, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlLessThanOrEqualTo(String value) {
            addCriterion("user_url <=", value, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlLike(String value) {
            addCriterion("user_url like", value, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlNotLike(String value) {
            addCriterion("user_url not like", value, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlIn(List<String> values) {
            addCriterion("user_url in", values, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlNotIn(List<String> values) {
            addCriterion("user_url not in", values, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlBetween(String value1, String value2) {
            addCriterion("user_url between", value1, value2, "userUrl");
            return (Criteria) this;
        }

        public Criteria andUserUrlNotBetween(String value1, String value2) {
            addCriterion("user_url not between", value1, value2, "userUrl");
            return (Criteria) this;
        }

        public Criteria andPlContentIsNull() {
            addCriterion("pl_content is null");
            return (Criteria) this;
        }

        public Criteria andPlContentIsNotNull() {
            addCriterion("pl_content is not null");
            return (Criteria) this;
        }

        public Criteria andPlContentEqualTo(String value) {
            addCriterion("pl_content =", value, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentNotEqualTo(String value) {
            addCriterion("pl_content <>", value, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentGreaterThan(String value) {
            addCriterion("pl_content >", value, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentGreaterThanOrEqualTo(String value) {
            addCriterion("pl_content >=", value, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentLessThan(String value) {
            addCriterion("pl_content <", value, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentLessThanOrEqualTo(String value) {
            addCriterion("pl_content <=", value, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentLike(String value) {
            addCriterion("pl_content like", value, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentNotLike(String value) {
            addCriterion("pl_content not like", value, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentIn(List<String> values) {
            addCriterion("pl_content in", values, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentNotIn(List<String> values) {
            addCriterion("pl_content not in", values, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentBetween(String value1, String value2) {
            addCriterion("pl_content between", value1, value2, "plContent");
            return (Criteria) this;
        }

        public Criteria andPlContentNotBetween(String value1, String value2) {
            addCriterion("pl_content not between", value1, value2, "plContent");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("create_date like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("create_date not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
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