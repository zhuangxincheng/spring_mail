package com.mail.model;

import java.util.ArrayList;
import java.util.List;

public class ContextExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContextExample() {
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

        public Criteria andContextIdIsNull() {
            addCriterion("context_id is null");
            return (Criteria) this;
        }

        public Criteria andContextIdIsNotNull() {
            addCriterion("context_id is not null");
            return (Criteria) this;
        }

        public Criteria andContextIdEqualTo(Integer value) {
            addCriterion("context_id =", value, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdNotEqualTo(Integer value) {
            addCriterion("context_id <>", value, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdGreaterThan(Integer value) {
            addCriterion("context_id >", value, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("context_id >=", value, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdLessThan(Integer value) {
            addCriterion("context_id <", value, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdLessThanOrEqualTo(Integer value) {
            addCriterion("context_id <=", value, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdIn(List<Integer> values) {
            addCriterion("context_id in", values, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdNotIn(List<Integer> values) {
            addCriterion("context_id not in", values, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdBetween(Integer value1, Integer value2) {
            addCriterion("context_id between", value1, value2, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextIdNotBetween(Integer value1, Integer value2) {
            addCriterion("context_id not between", value1, value2, "contextId");
            return (Criteria) this;
        }

        public Criteria andContextNameIsNull() {
            addCriterion("context_name is null");
            return (Criteria) this;
        }

        public Criteria andContextNameIsNotNull() {
            addCriterion("context_name is not null");
            return (Criteria) this;
        }

        public Criteria andContextNameEqualTo(String value) {
            addCriterion("context_name =", value, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameNotEqualTo(String value) {
            addCriterion("context_name <>", value, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameGreaterThan(String value) {
            addCriterion("context_name >", value, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameGreaterThanOrEqualTo(String value) {
            addCriterion("context_name >=", value, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameLessThan(String value) {
            addCriterion("context_name <", value, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameLessThanOrEqualTo(String value) {
            addCriterion("context_name <=", value, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameLike(String value) {
            addCriterion("context_name like", value, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameNotLike(String value) {
            addCriterion("context_name not like", value, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameIn(List<String> values) {
            addCriterion("context_name in", values, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameNotIn(List<String> values) {
            addCriterion("context_name not in", values, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameBetween(String value1, String value2) {
            addCriterion("context_name between", value1, value2, "contextName");
            return (Criteria) this;
        }

        public Criteria andContextNameNotBetween(String value1, String value2) {
            addCriterion("context_name not between", value1, value2, "contextName");
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