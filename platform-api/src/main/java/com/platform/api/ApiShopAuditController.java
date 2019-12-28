package com.platform.api;

import com.platform.annotation.LoginUser;
import com.platform.dao.SysUserDao;
import com.platform.entity.ShopauditEntity;
import com.platform.entity.UserVo;
import com.platform.service.ApiShopAuditService;
import com.platform.utils.ResultState;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商户管理")
@RestController
@RequestMapping("/api/audit")
public class ApiShopAuditController {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private ApiShopAuditService shopAuditService;
    @Transactional
    @ApiOperation("商户添加")
    @PostMapping("/save")
    public ResultState saveShop(@LoginUser UserVo loginUser, @RequestBody ShopauditEntity nideshopShopaudit){

//        List<ShopauditEntity> userIdList = shopAuditService.findByUserId(nideshopShopaudit.getUserid());
//        if (nideshopShopaudit.getUserid() != null) {
//            if (userIdList.size() > 0) {
//                for (ShopauditEntity shopauditEntity : userIdList) {
//                    if ("0".equals(shopauditEntity.getState()+"") || "1".equals(shopauditEntity.getState()+"") || "3".equals(shopauditEntity.getState()+"")) {
//                        return new ResultState("重复提交", false, ResultState.ERROR);
//                    }
//                }
//            }
//        }
            ResultState exit = isExit(nideshopShopaudit);
            if (exit==null){
            shopAuditService.save(nideshopShopaudit);
            }else {
                return exit;
            }

        return new ResultState("提交审核成功",true,ResultState.OK);
    }
    @GetMapping("/findOne")
    public ResultState findByOne(@RequestParam String userId){
        shopAuditService.findOne(userId);
        try {
            return new ResultState("查询成功",true,ResultState.OK,shopAuditService.findOne(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultState("未知错误,联系管理员",false,ResultState.ERROR);
        }

    }

    private ResultState isExit(ShopauditEntity shopAudit){
        int count =sysUserDao.mlsPhoneCount(shopAudit.getPhone());
        if(count>0) {
            return new ResultState("手机号已经存在",false,ResultState.ERROR);
        }
        int shopNameCount = sysUserDao.mlsMerchantNameCount(shopAudit.getShopname());
        if (shopNameCount>0){
            return new ResultState("店铺名已经存在",false,ResultState.ERROR);
        }
        int shopAccountCount = sysUserDao.mlsShopAccountCount(shopAudit.getShopAccount());
        if (shopAccountCount>0){
            return new ResultState("店铺账号已经存在",false,ResultState.ERROR);
        }
        return null;

    };



}
