package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_shopdata
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-12-11 16:06:48
 */
public class ShopdataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //店铺申请经营类目,可以选择多类别
    private String type;
    //企业或个体户营业执照
    private String business;
    //商标或品牌商业授权
    private String brand;
    //特殊行业资质上传
    private String aptitude;
    //商铺管理者姓名
    private String adminname;
    //用户的唯一id
    private String userid;
    //身份证号
    private String idcard;
    //身份证图片
    private String idcardimage;
    //商户id
    private Long shopId;
    //保证金
    private BigDecimal cash;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：店铺申请经营类目,可以选择多类别
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：店铺申请经营类目,可以选择多类别
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：企业或个体户营业执照
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * 获取：企业或个体户营业执照
     */
    public String getBusiness() {
        return business;
    }
    /**
     * 设置：商标或品牌商业授权
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取：商标或品牌商业授权
     */
    public String getBrand() {
        return brand;
    }
    /**
     * 设置：特殊行业资质上传
     */
    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }

    /**
     * 获取：特殊行业资质上传
     */
    public String getAptitude() {
        return aptitude;
    }
    /**
     * 设置：商铺管理者姓名
     */
    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    /**
     * 获取：商铺管理者姓名
     */
    public String getAdminname() {
        return adminname;
    }
    /**
     * 设置：用户的唯一id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取：用户的唯一id
     */
    public String getUserid() {
        return userid;
    }
    /**
     * 设置：身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取：身份证号
     */
    public String getIdcard() {
        return idcard;
    }
    /**
     * 设置：身份证图片
     */
    public void setIdcardimage(String idcardimage) {
        this.idcardimage = idcardimage;
    }

    /**
     * 获取：身份证图片
     */
    public String getIdcardimage() {
        return idcardimage;
    }
    /**
     * 设置：商户id
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取：商户id
     */
    public Long getShopId() {
        return shopId;
    }
    /**
     * 设置：保证金
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    /**
     * 获取：保证金
     */
    public BigDecimal getCash() {
        return cash;
    }
}
