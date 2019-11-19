package com.platform.api;

import com.platform.dao.NideshopShopauditMapper;
import com.platform.entity.NideshopShopaudit;
import com.platform.service.ApiShopAuditService;
import com.platform.utils.R;
import com.platform.utils.ResultState;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "商户管理")
@RestController
@RequestMapping("/api/audit")
public class ApiShopAuditController {
    @Autowired
    private ApiShopAuditService shopAuditService;
    @ApiOperation("商户添加")
    @PostMapping("/save")
    public ResultState saveShop(@RequestBody NideshopShopaudit nideshopShopaudit){
        System.out.printf(String.valueOf(nideshopShopaudit));
        try {
            shopAuditService.save(nideshopShopaudit);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultState("未知错误,联系管理员",false,ResultState.ERROR);
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



}
