package com.platform.controller;

import com.github.pagehelper.Page;
import com.platform.entity.GoodsEntity;
import com.platform.entity.NideshopShopaudit;
import com.platform.entity.SysUserEntity;
import com.platform.page.PageResult;
import com.platform.service.ShopAuditService;
import com.platform.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shopAudit")
public class ShopAuditController {
    @Autowired
    private ShopAuditService shopAuditService;
    @GetMapping("findAll")
    public ResultState findAll(){
        try {
            return new ResultState("查询成功",true,ResultState.OK,shopAuditService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultState("未知错误，请联系管理员",false,ResultState.ERROR);

        }

    }
    @RequestMapping("/findAllByPage")
    public ResultState findAllByPage(@RequestParam(value = "state",required = false,defaultValue = "null") Integer state,@RequestParam Integer page, @RequestParam Integer size){
        PageResult pageList = shopAuditService.findSearch(state,page,size);
        return new ResultState("查询成功",true,ResultState.OK,pageList);

    }
    //更新店铺审核状态
    @GetMapping("/updateState")
    public ResultState updateState(@RequestParam String userId ,@RequestParam Integer state){
        try {
            Integer judge = shopAuditService.judge(userId);

            if (judge == 0){
                return new ResultState("用户名不存在",false,ResultState.ERROR);

            }
            if (judge == 2){
                return new ResultState("用户数据异常",false,ResultState.ERROR);
            }else {
                return new ResultState("更新成功",true,ResultState.OK);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultState("更新失败",false,ResultState.ERROR);
        }
    }
}
