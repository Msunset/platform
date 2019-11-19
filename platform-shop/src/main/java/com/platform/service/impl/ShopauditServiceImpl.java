package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ShopauditMapper;
import com.platform.entity.ShopauditEntity;
import com.platform.service.ShopauditService;

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
}
