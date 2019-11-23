package com.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.utils.ResultState;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.ShopauditEntity;
import com.platform.service.ShopauditService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-11-19 15:53:32
 */
@RestController
@RequestMapping("shopaudit")
public class ShopauditController {
    @Autowired
    private ShopauditService shopauditService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("shopaudit:list")
    public R list(@RequestParam Map<String, Object> params,
                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                  @RequestParam(value = "limit", defaultValue = "10") Integer size) {
        //查询列表数据
        params.put("page",page);
        params.put("limit",size);
        Query query = new Query(params);

        List<ShopauditEntity> shopauditList = shopauditService.queryList(query);
        int total = shopauditService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(shopauditList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 根据商家唯一标识查询商家信息
     * @param userId 用户唯一标识
     * @return
     */
    @RequestMapping("/findByUserId")
    //    @RequiresPermissions("shopaudit:findByUserId")
    public ResultState findByUserId(@RequestParam String userId){
        ShopauditEntity shopauditEntity = shopauditService.queryByUserId(userId);

        try {
            return new ResultState("查询成功",true,ResultState.OK,shopauditEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultState("数据查询异常",false,ResultState.ERROR);
        }
    };

    /**
     * 根据商家店铺名称模糊查询商铺
     * @param shopName
     * @return
     */
    @RequestMapping("/findByShopName")
    //    @RequiresPermissions("shopaudit:findByShopName")
    public ResultState findByShopName(@RequestParam(value = "shopName",defaultValue = "") String shopName){
        try {
            List<ShopauditEntity> shopauditEntities = shopauditService.findByShopName(shopName);
            return new ResultState("查询成功",true,ResultState.OK,shopauditEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultState("查询失败",false,ResultState.ERROR);
        }
    }



//    @RequestMapping("/updateState/{state}/{id}")
//    //    @RequiresPermissions("shopaudit:updateState")
//    public ResultState updateState(@PathVariable ("state") Integer state,@PathVariable("id") Integer id){
//        shopauditService.update()
//
//
//    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shopaudit:info")
    public R info(@PathVariable("id") Integer id) {
        ShopauditEntity shopaudit = shopauditService.queryObject(id);

        return R.ok().put("shopaudit", shopaudit);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("shopaudit:save")
    public R save(@RequestBody ShopauditEntity shopaudit) {
        shopauditService.save(shopaudit);

        return R.ok();
    }

    /**
     * 根据主键修改商家审核状态
     */
    @RequestMapping("/update")
//    @RequiresPermissions("shopaudit:update")
    public ResultState update(@RequestBody ShopauditEntity shopaudit,@RequestParam Integer state) {
        System.out.printf(shopaudit.toString());
        try {
            shopauditService.update(shopaudit,state);
            return new ResultState("审核成功",true,ResultState.OK);
        } catch (Exception e) {
            return new ResultState("审核失败",false,ResultState.ERROR);
        }
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shopaudit:delete")
    public R delete(@RequestBody Integer[] ids) {
        shopauditService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopauditEntity> list = shopauditService.queryList(params);

        return R.ok().put("list", list);
    }
}
