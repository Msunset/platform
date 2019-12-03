package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_wallet
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-12-03 11:13:19
 */
public class WalletEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //商铺id
    private Long shopId;
    //商铺名称
    private String shopName;
    //商铺余额
    private BigDecimal shopBalance;
    //结算方式
    private String shopType;
    //登录名
    private String loginName;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：商铺id
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取：商铺id
     */
    public Long getShopId() {
        return shopId;
    }
    /**
     * 设置：商铺名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 获取：商铺名称
     */
    public String getShopName() {
        return shopName;
    }
    /**
     * 设置：商铺余额
     */
    public void setShopBalance(BigDecimal shopBalance) {
        this.shopBalance = shopBalance;
    }

    /**
     * 获取：商铺余额
     */
    public BigDecimal getShopBalance() {
        return shopBalance;
    }
    /**
     * 设置：结算方式
     */
    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    /**
     * 获取：结算方式
     */
    public String getShopType() {
        return shopType;
    }
    /**
     * 设置：登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取：登录名
     */
    public String getLoginName() {
        return loginName;
    }
}
