package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequiresPermissions("shopaudit:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ShopauditEntity> shopauditList = shopauditService.queryList(query);
        int total = shopauditService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(shopauditList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

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
    @RequiresPermissions("shopaudit:save")
    public R save(@RequestBody ShopauditEntity shopaudit) {
        shopauditService.save(shopaudit);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shopaudit:update")
    public R update(@RequestBody ShopauditEntity shopaudit) {
        shopauditService.update(shopaudit);

        return R.ok();
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
