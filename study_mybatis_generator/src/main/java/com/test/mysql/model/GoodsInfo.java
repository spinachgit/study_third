package com.test.mysql.model;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsInfo {
    private Integer goodsid;

    private String barcode;

    private String goodsname;

    private String goodsnick;

    private Integer platformgoodsid;

    private Integer businessid;

    private Integer categoryid;

    private BigDecimal costprice;

    private BigDecimal price;

    private BigDecimal onprice;

    private BigDecimal offprice;

    private BigDecimal cash;

    private String stand;

    private String unit;

    private Integer store;

    private Integer weight;

    private Byte isapp;

    private String imgurl;

    private Integer sales;

    private Integer moods;

    private Integer businessgoodsauditid;

    private Byte statistics;

    private Date ctime;

    private Integer safeStore;

    private Boolean isAutoOrder;

    private String describes;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodsnick() {
        return goodsnick;
    }

    public void setGoodsnick(String goodsnick) {
        this.goodsnick = goodsnick == null ? null : goodsnick.trim();
    }

    public Integer getPlatformgoodsid() {
        return platformgoodsid;
    }

    public void setPlatformgoodsid(Integer platformgoodsid) {
        this.platformgoodsid = platformgoodsid;
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOnprice() {
        return onprice;
    }

    public void setOnprice(BigDecimal onprice) {
        this.onprice = onprice;
    }

    public BigDecimal getOffprice() {
        return offprice;
    }

    public void setOffprice(BigDecimal offprice) {
        this.offprice = offprice;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand == null ? null : stand.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Byte getIsapp() {
        return isapp;
    }

    public void setIsapp(Byte isapp) {
        this.isapp = isapp;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getMoods() {
        return moods;
    }

    public void setMoods(Integer moods) {
        this.moods = moods;
    }

    public Integer getBusinessgoodsauditid() {
        return businessgoodsauditid;
    }

    public void setBusinessgoodsauditid(Integer businessgoodsauditid) {
        this.businessgoodsauditid = businessgoodsauditid;
    }

    public Byte getStatistics() {
        return statistics;
    }

    public void setStatistics(Byte statistics) {
        this.statistics = statistics;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getSafeStore() {
        return safeStore;
    }

    public void setSafeStore(Integer safeStore) {
        this.safeStore = safeStore;
    }

    public Boolean getIsAutoOrder() {
        return isAutoOrder;
    }

    public void setIsAutoOrder(Boolean isAutoOrder) {
        this.isAutoOrder = isAutoOrder;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }
}