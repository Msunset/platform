package com.platform.config;

public class WXpayConfig {
    public static String APPID = "wxd906a683f345c322";//微信公众号APPID
    public static String WXPAYMENTACCOUNT = "1564876961";//微信公众号的商户号
    public static String APIKEY = "a48736a8f035b0d6808dcf1712569966";//微信公众号的商户支付密钥
    public static String basePath = "https://api.mch.weixin.qq.com/pay/unifiedorder";//统一下单请求地址
    public static String notify_url = "http://shop.wenyouwang.com/pay/result";//回调地址

}
