package com.test.mysql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class tttExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public tttExample() {
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

        public Criteria andMessageMerchantInfoIdIsNull() {
            addCriterion("message_merchant_info_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdIsNotNull() {
            addCriterion("message_merchant_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdEqualTo(Integer value) {
            addCriterion("message_merchant_info_id =", value, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdNotEqualTo(Integer value) {
            addCriterion("message_merchant_info_id <>", value, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdGreaterThan(Integer value) {
            addCriterion("message_merchant_info_id >", value, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_merchant_info_id >=", value, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdLessThan(Integer value) {
            addCriterion("message_merchant_info_id <", value, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_merchant_info_id <=", value, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdIn(List<Integer> values) {
            addCriterion("message_merchant_info_id in", values, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdNotIn(List<Integer> values) {
            addCriterion("message_merchant_info_id not in", values, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("message_merchant_info_id between", value1, value2, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageMerchantInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_merchant_info_id not between", value1, value2, "messageMerchantInfoId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdIsNull() {
            addCriterion("admin_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdIsNotNull() {
            addCriterion("admin_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdEqualTo(Integer value) {
            addCriterion("admin_user_id =", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdNotEqualTo(Integer value) {
            addCriterion("admin_user_id <>", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdGreaterThan(Integer value) {
            addCriterion("admin_user_id >", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_user_id >=", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdLessThan(Integer value) {
            addCriterion("admin_user_id <", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_user_id <=", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdIn(List<Integer> values) {
            addCriterion("admin_user_id in", values, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdNotIn(List<Integer> values) {
            addCriterion("admin_user_id not in", values, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_user_id between", value1, value2, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_user_id not between", value1, value2, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameIsNull() {
            addCriterion("admin_user_name is null");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameIsNotNull() {
            addCriterion("admin_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameEqualTo(String value) {
            addCriterion("admin_user_name =", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameNotEqualTo(String value) {
            addCriterion("admin_user_name <>", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameGreaterThan(String value) {
            addCriterion("admin_user_name >", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_user_name >=", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameLessThan(String value) {
            addCriterion("admin_user_name <", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameLessThanOrEqualTo(String value) {
            addCriterion("admin_user_name <=", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameLike(String value) {
            addCriterion("admin_user_name like", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameNotLike(String value) {
            addCriterion("admin_user_name not like", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameIn(List<String> values) {
            addCriterion("admin_user_name in", values, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameNotIn(List<String> values) {
            addCriterion("admin_user_name not in", values, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameBetween(String value1, String value2) {
            addCriterion("admin_user_name between", value1, value2, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameNotBetween(String value1, String value2) {
            addCriterion("admin_user_name not between", value1, value2, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andIsautoIsNull() {
            addCriterion("isauto is null");
            return (Criteria) this;
        }

        public Criteria andIsautoIsNotNull() {
            addCriterion("isauto is not null");
            return (Criteria) this;
        }

        public Criteria andIsautoEqualTo(Boolean value) {
            addCriterion("isauto =", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoNotEqualTo(Boolean value) {
            addCriterion("isauto <>", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoGreaterThan(Boolean value) {
            addCriterion("isauto >", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isauto >=", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoLessThan(Boolean value) {
            addCriterion("isauto <", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoLessThanOrEqualTo(Boolean value) {
            addCriterion("isauto <=", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoIn(List<Boolean> values) {
            addCriterion("isauto in", values, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoNotIn(List<Boolean> values) {
            addCriterion("isauto not in", values, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoBetween(Boolean value1, Boolean value2) {
            addCriterion("isauto between", value1, value2, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isauto not between", value1, value2, "isauto");
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