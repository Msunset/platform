package com.platform.service.impl;

import com.platform.dao.ShopauditMapper;
import com.platform.entity.ShopauditEntity;
import com.platform.entity.example.ShopauditExample;
import com.platform.service.ShopauditService;
import com.platform.utils.ResultState;
import io.swagger.annotations.Example;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-11-15 20:03:40
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
        return shopauditMapper.insertSelective(shopaudit);
    }

    @Override
    public int update(ShopauditEntity shopaudit) {
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
    public void updateState(Integer states, String[] userIds) {
        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < userIds.length; i++) {
            map.put("userId",userIds[i]);
            ShopauditExample example = new ShopauditExample();
            ShopauditExample.Criteria criteria = example.createCriteria();
            criteria.andUseridEqualTo(userIds[i]);
            List<ShopauditEntity> shopauditEntities = shopauditMapper.selectByExample(example);
            if (shopauditEntities.size()>0){
                ShopauditEntity shopauditEntity = shopauditEntities.get(0);
                shopauditEntity.setState(states);
                shopauditMapper.updateByPrimaryKeySelective(shopauditEntity);
            }


        }

    }
}
