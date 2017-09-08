package com.xialiu.shop.center.dao.shop.entity;

import java.util.ArrayList;
import java.util.List;

public class ManagerUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagerUserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserpasswdIsNull() {
            addCriterion("userPasswd is null");
            return (Criteria) this;
        }

        public Criteria andUserpasswdIsNotNull() {
            addCriterion("userPasswd is not null");
            return (Criteria) this;
        }

        public Criteria andUserpasswdEqualTo(String value) {
            addCriterion("userPasswd =", value, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdNotEqualTo(String value) {
            addCriterion("userPasswd <>", value, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdGreaterThan(String value) {
            addCriterion("userPasswd >", value, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdGreaterThanOrEqualTo(String value) {
            addCriterion("userPasswd >=", value, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdLessThan(String value) {
            addCriterion("userPasswd <", value, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdLessThanOrEqualTo(String value) {
            addCriterion("userPasswd <=", value, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdLike(String value) {
            addCriterion("userPasswd like", value, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdNotLike(String value) {
            addCriterion("userPasswd not like", value, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdIn(List<String> values) {
            addCriterion("userPasswd in", values, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdNotIn(List<String> values) {
            addCriterion("userPasswd not in", values, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdBetween(String value1, String value2) {
            addCriterion("userPasswd between", value1, value2, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andUserpasswdNotBetween(String value1, String value2) {
            addCriterion("userPasswd not between", value1, value2, "userpasswd");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNull() {
            addCriterion("loginTime is null");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNotNull() {
            addCriterion("loginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimeEqualTo(String value) {
            addCriterion("loginTime =", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotEqualTo(String value) {
            addCriterion("loginTime <>", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThan(String value) {
            addCriterion("loginTime >", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThanOrEqualTo(String value) {
            addCriterion("loginTime >=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThan(String value) {
            addCriterion("loginTime <", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThanOrEqualTo(String value) {
            addCriterion("loginTime <=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLike(String value) {
            addCriterion("loginTime like", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotLike(String value) {
            addCriterion("loginTime not like", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeIn(List<String> values) {
            addCriterion("loginTime in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotIn(List<String> values) {
            addCriterion("loginTime not in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeBetween(String value1, String value2) {
            addCriterion("loginTime between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotBetween(String value1, String value2) {
            addCriterion("loginTime not between", value1, value2, "logintime");
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