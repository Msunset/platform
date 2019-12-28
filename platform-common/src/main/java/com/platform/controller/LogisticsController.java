package com.platform.controller;
import com.platform.utils.HttpUtils;
import com.platform.utils.RedisUtils;
import com.platform.utils.ResultState;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("logistics")
public class LogisticsController {
    @RequestMapping("/findLogistics")
    public ResultState findLogistics(@RequestParam String logistics){
        String host = "https://ali-deliver.showapi.com";
        String path = "/showapi_expInfo";
        String method = "GET";
        String appcode = "c4a6b622d8e2440885192bf7071d5bd9";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("com", "auto");
        querys.put("nu", logistics);
//        querys.put("receiverPhone", "receiverPhone");
//        querys.put("senderPhone", "senderPhone");
        try {
            if (RedisUtils.get(logistics) != null){
                System.out.println("----------缓存读取");
                String redisData = RedisUtils.get(logistics);
                return new ResultState("查询成功",true,ResultState.OK,redisData);

            }
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            String s = EntityUtils.toString(response.getEntity());
            System.out.printf(s);
            System.out.println("-------开始存入缓存");
            RedisUtils.set(logistics,s,60);
            System.out.println("----缓存存入成功");

            return new ResultState("查询成功",true,ResultState.OK,s);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultState("数据异常",false,ResultState.ERROR);
        }


    }
}
