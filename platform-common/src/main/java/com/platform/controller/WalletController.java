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

import com.platform.entity.WalletEntity;
import com.platform.service.WalletService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-11-21 16:15:09
 */
@RestController
@RequestMapping("wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wallet:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WalletEntity> walletList = walletService.queryList(query);
        int total = walletService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(walletList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wallet:info")
    public R info(@PathVariable("id") Integer id) {
        WalletEntity wallet = walletService.queryObject(id);

        return R.ok().put("wallet", wallet);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wallet:save")
    public R save(@RequestBody WalletEntity wallet) {
        walletService.save(wallet);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wallet:update")
    public R update(@RequestBody WalletEntity wallet) {
        walletService.update(wallet);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wallet:delete")
    public R delete(@RequestBody Integer[] ids) {
        walletService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WalletEntity> list = walletService.queryList(params);

        return R.ok().put("list", list);
    }
}
