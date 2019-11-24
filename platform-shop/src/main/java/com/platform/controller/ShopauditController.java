package com.platform.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.dao.SysUserDao;
import com.platform.entity.MlsUserEntity2;
import com.platform.entity.ShopdataEntity;
import com.platform.entity.SysUserEntity;
import com.platform.service.SysUserService;
import com.platform.utils.ResultState;
import com.platform.validator.ValidatorUtils;
import com.platform.validator.group.AddGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.ShopauditEntity;
import com.platform.service.ShopauditService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

import static com.platform.utils.ShiroUtils.getUserId;

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
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserDao sysUserDao;

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

    /**
     * 根据手机号查询商家
     * @param phone
     * @return
     */
    @RequestMapping("findByPhone")
    //    @RequiresPermissions("shopaudit:findByPhone")
    public ResultState findByPhone(@RequestParam(defaultValue = "") String phone){
        try {
            List<ShopauditEntity> shopauditEntities = shopauditService.findByPhone(phone);
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
            //1.创建账号
            if (state==1){//审核通过正常登陆
            int count=sysUserDao.mlsUseCount(shopaudit.getPhone());
            if(count>0) {
                return new ResultState("手机号已经存在",false,ResultState.ERROR);
            }
            SysUserEntity user = new SysUserEntity();
                user.setUsername(shopaudit.getShopAccount());//店铺账号
                user.setPassword(shopaudit.getPassword());
                user.setEmail(shopaudit.getEmail());
                user.setMobile(shopaudit.getPhone());
                user.setStatus(shopaudit.getState());
                user.setCreateUserId(getUserId());//
                user.setCreateTime(new Date());
                sysUserService.save(user);
                //把主键id设置到merchantId
                sysUserDao.updateMerchantId(user);

                //审核成功，把审核纪录的数据设置进来
                ShopdataEntity shopdataEntity = new ShopdataEntity();
                shopdataEntity.setAdminname(shopaudit.getAdminname());
                shopdataEntity.setAptitude(shopaudit.getAptitude());
                shopdataEntity.setBrand(shopaudit.getBrand());
                shopdataEntity.setBusiness(shopaudit.getBusiness());
                shopdataEntity.setIdcard(shopaudit.getIdcard());
                shopdataEntity.setIdcardimage(shopaudit.getIdcardimage());
                shopdataEntity.setType(shopaudit.getType());



            }
            return new ResultState("已更改审核状态",true,ResultState.OK);
        } catch (Exception e) {
            return new ResultState("更改审核状态失败",false,ResultState.ERROR);
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