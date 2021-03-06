package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

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
     * 设置：店铺名称
     */
    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    /**
     * 获取：店铺名称
     */
    public String getShopname() {
        return shopname;
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
     * 设置：联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：联系方式
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 设置：邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：邮箱
     */
    public String getEmail() {
        return email;
    }
    /**
     * 设置：店铺审核状态，0代表未审核，1代表审核处理中，2代表审核失败，3代表审核通过
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取：店铺审核状态，0代表未审核，1代表审核处理中，2代表审核失败，3代表审核通过
     */
    public Integer getState() {
        return state;
    }
    /**
     * 设置：申请审核时间
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    /**
     * 获取：申请审核时间
     */
    public Date getCreattime() {
        return creattime;
    }
    /**
     * 设置：用户登录的id唯一标识 
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取：用户登录的id唯一标识 
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
     * 设置：店铺账号
     */
    public void setShopAccount(String shopAccount) {
        this.shopAccount = shopAccount;
    }

    /**
     * 获取：店铺账号
     */
    public String getShopAccount() {
        return shopAccount;
    }
    /**
     * 设置：店铺账号密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：店铺账号密码
     */
    public String getPassword() {
        return password;
    }
}
