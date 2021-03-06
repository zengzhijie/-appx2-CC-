package com.dreawer.customer.domain;


import com.dreawer.customer.lang.member.Expiration;
import com.dreawer.customer.lang.member.Status;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * <CODE>Hierarchy</CODE>
 * 会员等级制度
 *
 * @author fenrir
 * @Date 18-3-26
 */
public class Hierarchy implements Serializable {

    private static final long serialVersionUID = 4779570023792487491L;

    public String id = null; //主键

    private String storeId; //店铺ID

    private String name; //会员等级名称

    private Integer sequence; //会员等级Level 1-7

    private Integer growthValue; //成长值

    private Boolean freeShipping; //是否免运费

    private Boolean discount; //是否开启会员折扣

    private String discountAmount; //折扣率 1-10

    private Expiration expiration; //有效期类型 LIMITED 有限制, UNLIMITED 永久有效

    private Integer period; //有效期时长

    private Integer expireDeduction = null; //过期后扣减成长值

    private Status status; //状态 ENABLE启用 DISABLE 禁用

    private Timestamp createTime; // 创建时间

    private Timestamp updateTime; // 更新时间

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getGrowthValue() {
        return growthValue;
    }

    public void setGrowthValue(Integer growthValue) {
        this.growthValue = growthValue;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Expiration getExpiration() {
        return expiration;
    }

    public void setExpiration(Expiration expiration) {
        this.expiration = expiration;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getExpireDeduction() {
        return expireDeduction;
    }

    public void setExpireDeduction(Integer expireDeduction) {
        this.expireDeduction = expireDeduction;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Hierarchy{" +
                "id='" + id + '\'' +
                ", storeId='" + storeId + '\'' +
                ", name='" + name + '\'' +
                ", sequence=" + sequence +
                ", growthValue=" + growthValue +
                ", freeShipping=" + freeShipping +
                ", discount=" + discount +
                ", discountAmount='" + discountAmount + '\'' +
                ", expiration=" + expiration +
                ", period='" + period + '\'' +
                ", expireDeduction=" + expireDeduction +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

