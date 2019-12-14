package com.platform.controller;

import java.util.List;
import java.util.Map;

import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.ShopdataEntity;
import com.platform.service.ShopdataService;

/**
 * Controller
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-12-11 16:06:48
 */
@RestController
@RequestMapping("shopdata")
public class ShopdataController {
    @Autowired
    private ShopdataService shopdataService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shopdata:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ShopdataEntity> shopdataList = shopdataService.queryList(query);
        int total = shopdataService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(shopdataList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shopdata:info")
    public R info(@PathVariable("id") Integer id) {
        ShopdataEntity shopdata = shopdataService.queryObject(id);

        return R.ok().put("shopdata", shopdata);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shopdata:save")
    public R save(@RequestBody ShopdataEntity shopdata) {
        shopdataService.save(shopdata);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shopdata:update")
    public R update(@RequestBody ShopdataEntity shopdata) {
        shopdataService.update(shopdata);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shopdata:delete")
    public R delete(@RequestBody Integer[] ids) {
        shopdataService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopdataEntity> list = shopdataService.queryList(params);

        return R.ok().put("list", list);
    }
}
