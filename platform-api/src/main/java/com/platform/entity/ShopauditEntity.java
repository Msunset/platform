package com.platform.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 实体
 * 表名 nideshop_shopaudit
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-11-23 15:14:27
 */
public class ShopauditEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //店铺名称
    private String shopname;
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
    //联系方式
    private String phone;
    //邮箱
    private String email;
    //店铺审核状态，0代表未审核，1代表审核处理中，2代表审核失败，3代表审核通过
    private Integer state;
    //申请审核时间
    private Date creattime;
    //用户登录的id唯一标识 
    private String userid;
    //身份证号
    private String idcard;
    //身份证图片
    private String idcardimage;
    //店铺账号
    private String shopAccount;
    //店铺账号密码
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIdcardimage() {
        return idcardimage;
    }

    public void setIdcardimage(String idcardimage) {
        this.idcardimage = idcardimage;
    }

    public String getShopAccount() {
        return shopAccount;
    }

    public void setShopAccount(String shopAccount) {
        this.shopAccount = shopAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
