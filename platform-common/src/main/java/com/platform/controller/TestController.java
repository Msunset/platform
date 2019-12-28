package com.platform.controller;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.rmi.ServerException;

public class TestController {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIhkQwiSstWe1w", "PMjl3lWhib6eSxGpwVoyHA4ynWfu2p");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendBatchSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumberJson", "[\"18955783725\"]");
        request.putQueryParameter("SignNameJson", "[\"品优\"]");
        request.putQueryParameter("TemplateCode", "SMS_170841743");
        request.putQueryParameter("TemplateParamJson", "[{\"code\":\"33699\"}]");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}