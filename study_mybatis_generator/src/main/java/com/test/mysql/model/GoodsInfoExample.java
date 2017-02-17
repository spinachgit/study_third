package com.test.mysql.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsInfoExample() {
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

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNull() {
            addCriterion("barcode is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNotNull() {
            addCriterion("barcode is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeEqualTo(String value) {
            addCriterion("barcode =", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            addCriterion("barcode <>", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThan(String value) {
            addCriterion("barcode >", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("barcode >=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThan(String value) {
            addCriterion("barcode <", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            addCriterion("barcode <=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLike(String value) {
            addCriterion("barcode like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotLike(String value) {
            addCriterion("barcode not like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIn(List<String> values) {
            addCriterion("barcode in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            addCriterion("barcode not in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            addCriterion("barcode between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            addCriterion("barcode not between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsname is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsname is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsname =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsname <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsname >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsname >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsname <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsname <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsname like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsname not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsname in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsname not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsname between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsname not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnickIsNull() {
            addCriterion("goodsnick is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnickIsNotNull() {
            addCriterion("goodsnick is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnickEqualTo(String value) {
            addCriterion("goodsnick =", value, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickNotEqualTo(String value) {
            addCriterion("goodsnick <>", value, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickGreaterThan(String value) {
            addCriterion("goodsnick >", value, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickGreaterThanOrEqualTo(String value) {
            addCriterion("goodsnick >=", value, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickLessThan(String value) {
            addCriterion("goodsnick <", value, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickLessThanOrEqualTo(String value) {
            addCriterion("goodsnick <=", value, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickLike(String value) {
            addCriterion("goodsnick like", value, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickNotLike(String value) {
            addCriterion("goodsnick not like", value, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickIn(List<String> values) {
            addCriterion("goodsnick in", values, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickNotIn(List<String> values) {
            addCriterion("goodsnick not in", values, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickBetween(String value1, String value2) {
            addCriterion("goodsnick between", value1, value2, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andGoodsnickNotBetween(String value1, String value2) {
            addCriterion("goodsnick not between", value1, value2, "goodsnick");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidIsNull() {
            addCriterion("platformgoodsid is null");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidIsNotNull() {
            addCriterion("platformgoodsid is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidEqualTo(Integer value) {
            addCriterion("platformgoodsid =", value, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidNotEqualTo(Integer value) {
            addCriterion("platformgoodsid <>", value, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidGreaterThan(Integer value) {
            addCriterion("platformgoodsid >", value, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("platformgoodsid >=", value, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidLessThan(Integer value) {
            addCriterion("platformgoodsid <", value, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("platformgoodsid <=", value, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidIn(List<Integer> values) {
            addCriterion("platformgoodsid in", values, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidNotIn(List<Integer> values) {
            addCriterion("platformgoodsid not in", values, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidBetween(Integer value1, Integer value2) {
            addCriterion("platformgoodsid between", value1, value2, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andPlatformgoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("platformgoodsid not between", value1, value2, "platformgoodsid");
            return (Criteria) this;
        }

        public Criteria andBusinessidIsNull() {
            addCriterion("businessid is null");
            return (Criteria) this;
        }

        public Criteria andBusinessidIsNotNull() {
            addCriterion("businessid is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessidEqualTo(Integer value) {
            addCriterion("businessid =", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidNotEqualTo(Integer value) {
            addCriterion("businessid <>", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidGreaterThan(Integer value) {
            addCriterion("businessid >", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidGreaterThanOrEqualTo(Integer value) {
            addCriterion("businessid >=", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidLessThan(Integer value) {
            addCriterion("businessid <", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidLessThanOrEqualTo(Integer value) {
            addCriterion("businessid <=", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidIn(List<Integer> values) {
            addCriterion("businessid in", values, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidNotIn(List<Integer> values) {
            addCriterion("businessid not in", values, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidBetween(Integer value1, Integer value2) {
            addCriterion("businessid between", value1, value2, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidNotBetween(Integer value1, Integer value2) {
            addCriterion("businessid not between", value1, value2, "businessid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(Integer value) {
            addCriterion("categoryid =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(Integer value) {
            addCriterion("categoryid <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(Integer value) {
            addCriterion("categoryid >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("categoryid >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(Integer value) {
            addCriterion("categoryid <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(Integer value) {
            addCriterion("categoryid <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<Integer> values) {
            addCriterion("categoryid in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<Integer> values) {
            addCriterion("categoryid not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(Integer value1, Integer value2) {
            addCriterion("categoryid between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(Integer value1, Integer value2) {
            addCriterion("categoryid not between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCostpriceIsNull() {
            addCriterion("costprice is null");
            return (Criteria) this;
        }

        public Criteria andCostpriceIsNotNull() {
            addCriterion("costprice is not null");
            return (Criteria) this;
        }

        public Criteria andCostpriceEqualTo(BigDecimal value) {
            addCriterion("costprice =", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotEqualTo(BigDecimal value) {
            addCriterion("costprice <>", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceGreaterThan(BigDecimal value) {
            addCriterion("costprice >", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("costprice >=", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceLessThan(BigDecimal value) {
            addCriterion("costprice <", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("costprice <=", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceIn(List<BigDecimal> values) {
            addCriterion("costprice in", values, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotIn(List<BigDecimal> values) {
            addCriterion("costprice not in", values, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costprice between", value1, value2, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costprice not between", value1, value2, "costprice");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andOnpriceIsNull() {
            addCriterion("onprice is null");
            return (Criteria) this;
        }

        public Criteria andOnpriceIsNotNull() {
            addCriterion("onprice is not null");
            return (Criteria) this;
        }

        public Criteria andOnpriceEqualTo(BigDecimal value) {
            addCriterion("onprice =", value, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceNotEqualTo(BigDecimal value) {
            addCriterion("onprice <>", value, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceGreaterThan(BigDecimal value) {
            addCriterion("onprice >", value, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("onprice >=", value, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceLessThan(BigDecimal value) {
            addCriterion("onprice <", value, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("onprice <=", value, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceIn(List<BigDecimal> values) {
            addCriterion("onprice in", values, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceNotIn(List<BigDecimal> values) {
            addCriterion("onprice not in", values, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("onprice between", value1, value2, "onprice");
            return (Criteria) this;
        }

        public Criteria andOnpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("onprice not between", value1, value2, "onprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceIsNull() {
            addCriterion("offprice is null");
            return (Criteria) this;
        }

        public Criteria andOffpriceIsNotNull() {
            addCriterion("offprice is not null");
            return (Criteria) this;
        }

        public Criteria andOffpriceEqualTo(BigDecimal value) {
            addCriterion("offprice =", value, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceNotEqualTo(BigDecimal value) {
            addCriterion("offprice <>", value, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceGreaterThan(BigDecimal value) {
            addCriterion("offprice >", value, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("offprice >=", value, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceLessThan(BigDecimal value) {
            addCriterion("offprice <", value, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("offprice <=", value, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceIn(List<BigDecimal> values) {
            addCriterion("offprice in", values, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceNotIn(List<BigDecimal> values) {
            addCriterion("offprice not in", values, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("offprice between", value1, value2, "offprice");
            return (Criteria) this;
        }

        public Criteria andOffpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("offprice not between", value1, value2, "offprice");
            return (Criteria) this;
        }

        public Criteria andCashIsNull() {
            addCriterion("cash is null");
            return (Criteria) this;
        }

        public Criteria andCashIsNotNull() {
            addCriterion("cash is not null");
            return (Criteria) this;
        }

        public Criteria andCashEqualTo(BigDecimal value) {
            addCriterion("cash =", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotEqualTo(BigDecimal value) {
            addCriterion("cash <>", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThan(BigDecimal value) {
            addCriterion("cash >", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash >=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThan(BigDecimal value) {
            addCriterion("cash <", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash <=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashIn(List<BigDecimal> values) {
            addCriterion("cash in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotIn(List<BigDecimal> values) {
            addCriterion("cash not in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash not between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andStandIsNull() {
            addCriterion("stand is null");
            return (Criteria) this;
        }

        public Criteria andStandIsNotNull() {
            addCriterion("stand is not null");
            return (Criteria) this;
        }

        public Criteria andStandEqualTo(String value) {
            addCriterion("stand =", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotEqualTo(String value) {
            addCriterion("stand <>", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandGreaterThan(String value) {
            addCriterion("stand >", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandGreaterThanOrEqualTo(String value) {
            addCriterion("stand >=", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLessThan(String value) {
            addCriterion("stand <", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLessThanOrEqualTo(String value) {
            addCriterion("stand <=", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLike(String value) {
            addCriterion("stand like", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotLike(String value) {
            addCriterion("stand not like", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandIn(List<String> values) {
            addCriterion("stand in", values, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotIn(List<String> values) {
            addCriterion("stand not in", values, "stand");
            return (Criteria) this;
        }

        public Criteria andStandBetween(String value1, String value2) {
            addCriterion("stand between", value1, value2, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotBetween(String value1, String value2) {
            addCriterion("stand not between", value1, value2, "stand");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andStoreIsNull() {
            addCriterion("store is null");
            return (Criteria) this;
        }

        public Criteria andStoreIsNotNull() {
            addCriterion("store is not null");
            return (Criteria) this;
        }

        public Criteria andStoreEqualTo(Integer value) {
            addCriterion("store =", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotEqualTo(Integer value) {
            addCriterion("store <>", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreGreaterThan(Integer value) {
            addCriterion("store >", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("store >=", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreLessThan(Integer value) {
            addCriterion("store <", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreLessThanOrEqualTo(Integer value) {
            addCriterion("store <=", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreIn(List<Integer> values) {
            addCriterion("store in", values, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotIn(List<Integer> values) {
            addCriterion("store not in", values, "store");
            return (Criteria) this;
        }

        public Criteria andStoreBetween(Integer value1, Integer value2) {
            addCriterion("store between", value1, value2, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotBetween(Integer value1, Integer value2) {
            addCriterion("store not between", value1, value2, "store");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andIsappIsNull() {
            addCriterion("isapp is null");
            return (Criteria) this;
        }

        public Criteria andIsappIsNotNull() {
            addCriterion("isapp is not null");
            return (Criteria) this;
        }

        public Criteria andIsappEqualTo(Byte value) {
            addCriterion("isapp =", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappNotEqualTo(Byte value) {
            addCriterion("isapp <>", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappGreaterThan(Byte value) {
            addCriterion("isapp >", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappGreaterThanOrEqualTo(Byte value) {
            addCriterion("isapp >=", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappLessThan(Byte value) {
            addCriterion("isapp <", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappLessThanOrEqualTo(Byte value) {
            addCriterion("isapp <=", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappIn(List<Byte> values) {
            addCriterion("isapp in", values, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappNotIn(List<Byte> values) {
            addCriterion("isapp not in", values, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappBetween(Byte value1, Byte value2) {
            addCriterion("isapp between", value1, value2, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappNotBetween(Byte value1, Byte value2) {
            addCriterion("isapp not between", value1, value2, "isapp");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNull() {
            addCriterion("imgurl is null");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNotNull() {
            addCriterion("imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andImgurlEqualTo(String value) {
            addCriterion("imgurl =", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotEqualTo(String value) {
            addCriterion("imgurl <>", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThan(String value) {
            addCriterion("imgurl >", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgurl >=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThan(String value) {
            addCriterion("imgurl <", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThanOrEqualTo(String value) {
            addCriterion("imgurl <=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLike(String value) {
            addCriterion("imgurl like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotLike(String value) {
            addCriterion("imgurl not like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlIn(List<String> values) {
            addCriterion("imgurl in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotIn(List<String> values) {
            addCriterion("imgurl not in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlBetween(String value1, String value2) {
            addCriterion("imgurl between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotBetween(String value1, String value2) {
            addCriterion("imgurl not between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return (Criteria) this;
        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return (Criteria) this;
        }

        public Criteria andSalesEqualTo(Integer value) {
            addCriterion("sales =", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotEqualTo(Integer value) {
            addCriterion("sales <>", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThan(Integer value) {
            addCriterion("sales >", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales >=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThan(Integer value) {
            addCriterion("sales <", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThanOrEqualTo(Integer value) {
            addCriterion("sales <=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesIn(List<Integer> values) {
            addCriterion("sales in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotIn(List<Integer> values) {
            addCriterion("sales not in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesBetween(Integer value1, Integer value2) {
            addCriterion("sales between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotBetween(Integer value1, Integer value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andMoodsIsNull() {
            addCriterion("moods is null");
            return (Criteria) this;
        }

        public Criteria andMoodsIsNotNull() {
            addCriterion("moods is not null");
            return (Criteria) this;
        }

        public Criteria andMoodsEqualTo(Integer value) {
            addCriterion("moods =", value, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsNotEqualTo(Integer value) {
            addCriterion("moods <>", value, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsGreaterThan(Integer value) {
            addCriterion("moods >", value, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("moods >=", value, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsLessThan(Integer value) {
            addCriterion("moods <", value, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsLessThanOrEqualTo(Integer value) {
            addCriterion("moods <=", value, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsIn(List<Integer> values) {
            addCriterion("moods in", values, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsNotIn(List<Integer> values) {
            addCriterion("moods not in", values, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsBetween(Integer value1, Integer value2) {
            addCriterion("moods between", value1, value2, "moods");
            return (Criteria) this;
        }

        public Criteria andMoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("moods not between", value1, value2, "moods");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidIsNull() {
            addCriterion("businessgoodsauditid is null");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidIsNotNull() {
            addCriterion("businessgoodsauditid is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidEqualTo(Integer value) {
            addCriterion("businessgoodsauditid =", value, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidNotEqualTo(Integer value) {
            addCriterion("businessgoodsauditid <>", value, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidGreaterThan(Integer value) {
            addCriterion("businessgoodsauditid >", value, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidGreaterThanOrEqualTo(Integer value) {
            addCriterion("businessgoodsauditid >=", value, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidLessThan(Integer value) {
            addCriterion("businessgoodsauditid <", value, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidLessThanOrEqualTo(Integer value) {
            addCriterion("businessgoodsauditid <=", value, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidIn(List<Integer> values) {
            addCriterion("businessgoodsauditid in", values, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidNotIn(List<Integer> values) {
            addCriterion("businessgoodsauditid not in", values, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidBetween(Integer value1, Integer value2) {
            addCriterion("businessgoodsauditid between", value1, value2, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andBusinessgoodsauditidNotBetween(Integer value1, Integer value2) {
            addCriterion("businessgoodsauditid not between", value1, value2, "businessgoodsauditid");
            return (Criteria) this;
        }

        public Criteria andStatisticsIsNull() {
            addCriterion("statistics is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsIsNotNull() {
            addCriterion("statistics is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsEqualTo(Byte value) {
            addCriterion("statistics =", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsNotEqualTo(Byte value) {
            addCriterion("statistics <>", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsGreaterThan(Byte value) {
            addCriterion("statistics >", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsGreaterThanOrEqualTo(Byte value) {
            addCriterion("statistics >=", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsLessThan(Byte value) {
            addCriterion("statistics <", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsLessThanOrEqualTo(Byte value) {
            addCriterion("statistics <=", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsIn(List<Byte> values) {
            addCriterion("statistics in", values, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsNotIn(List<Byte> values) {
            addCriterion("statistics not in", values, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsBetween(Byte value1, Byte value2) {
            addCriterion("statistics between", value1, value2, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsNotBetween(Byte value1, Byte value2) {
            addCriterion("statistics not between", value1, value2, "statistics");
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

        public Criteria andSafeStoreIsNull() {
            addCriterion("safe_store is null");
            return (Criteria) this;
        }

        public Criteria andSafeStoreIsNotNull() {
            addCriterion("safe_store is not null");
            return (Criteria) this;
        }

        public Criteria andSafeStoreEqualTo(Integer value) {
            addCriterion("safe_store =", value, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreNotEqualTo(Integer value) {
            addCriterion("safe_store <>", value, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreGreaterThan(Integer value) {
            addCriterion("safe_store >", value, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("safe_store >=", value, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreLessThan(Integer value) {
            addCriterion("safe_store <", value, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreLessThanOrEqualTo(Integer value) {
            addCriterion("safe_store <=", value, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreIn(List<Integer> values) {
            addCriterion("safe_store in", values, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreNotIn(List<Integer> values) {
            addCriterion("safe_store not in", values, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreBetween(Integer value1, Integer value2) {
            addCriterion("safe_store between", value1, value2, "safeStore");
            return (Criteria) this;
        }

        public Criteria andSafeStoreNotBetween(Integer value1, Integer value2) {
            addCriterion("safe_store not between", value1, value2, "safeStore");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderIsNull() {
            addCriterion("is_auto_order is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderIsNotNull() {
            addCriterion("is_auto_order is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderEqualTo(Boolean value) {
            addCriterion("is_auto_order =", value, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderNotEqualTo(Boolean value) {
            addCriterion("is_auto_order <>", value, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderGreaterThan(Boolean value) {
            addCriterion("is_auto_order >", value, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_auto_order >=", value, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderLessThan(Boolean value) {
            addCriterion("is_auto_order <", value, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("is_auto_order <=", value, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderIn(List<Boolean> values) {
            addCriterion("is_auto_order in", values, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderNotIn(List<Boolean> values) {
            addCriterion("is_auto_order not in", values, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("is_auto_order between", value1, value2, "isAutoOrder");
            return (Criteria) this;
        }

        public Criteria andIsAutoOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_auto_order not between", value1, value2, "isAutoOrder");
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