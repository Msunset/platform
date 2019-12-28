package com.platform.service.impl;

import com.platform.dao.ShopauditMapper;
import com.platform.entity.ShopauditEntity;
import com.platform.entity.example.ShopauditExample;
import com.platform.service.ShopauditService;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-11-19 15:53:32
 */
@Service("shopauditService")
public class ShopauditServiceImpl implements ShopauditService {
    @Autowired
    private ShopauditMapper shopauditMapper;

    @Override
    public ShopauditEntity queryObject(Integer id) {
        return shopauditMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ShopauditEntity> queryList(Map<String, Object> map) {
        return shopauditMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return shopauditMapper.queryTotal(map);
    }

    @Override
    public int save(ShopauditEntity shopaudit) {
        int mobile  = shopauditMapper.selectMobile(shopaudit.getPhone());
        if (mobile>0){
            return mobile;
        }
        int ShopAccount  = shopauditMapper.selectShopAccount(shopaudit.getShopAccount());
        if (ShopAccount>0){
            return ShopAccount;
        }
        int ShopName  = shopauditMapper.selectShopName(shopaudit.getShopname());
        if (ShopName>0){
            return ShopName;
        }
        return shopauditMapper.insertSelective(shopaudit);
    }

    @Override
    public int update(ShopauditEntity shopaudit,Integer state) {
        shopaudit.setState(state);
        return shopauditMapper.updateByPrimaryKeySelective(shopaudit);
    }

    @Override
    public int delete(Integer id) {
        return shopauditMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopauditMapper.deleteBatch(ids);
    }

    @Override
    public ShopauditEntity queryByUserId(String userId) {
        ShopauditExample example = new ShopauditExample();
        ShopauditExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<ShopauditEntity> shopauditEntities = shopauditMapper.selectByExample(example);
        if (shopauditEntities.size()==1){
            return shopauditEntities.get(0);
        }
        return null;
    }

    @Override
    public List<ShopauditEntity> findByShopName(String shopName) {
        if ("".equals(shopName) || shopName == null){
            return shopauditMapper.selectByExample(null);
        }
        ShopauditExample example = new ShopauditExample();
        ShopauditExample.Criteria criteria = example.createCriteria();
        criteria.andShopnameLike("%"+shopName+"%");
       return shopauditMapper.selectByExample(example);
    }

    @Override
    public List<ShopauditEntity> findByPhone(String phone) {
        ShopauditExample example = new ShopauditExample();
        ShopauditExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneLike("%"+phone+"%");
        return shopauditMapper.selectByExample(example);

    }

    @Override
    public List<ShopauditEntity> findByUserId(String userId) {
        ShopauditExample example = new ShopauditExample();
        ShopauditExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<ShopauditEntity> shopauditEntities = shopauditMapper.selectByExample(example);
        return shopauditEntities;

    }
}
