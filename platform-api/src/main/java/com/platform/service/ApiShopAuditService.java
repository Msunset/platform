package com.platform.service;
import com.platform.dao.NideshopShopauditMapper;
import com.platform.dao.ShopauditMapper;
import com.platform.entity.NideshopShopaudit;
import com.platform.entity.NideshopShopauditExample;
import com.platform.entity.ShopauditEntity;
import com.platform.entity.example.ShopauditExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApiShopAuditService {
    @Autowired
    private ShopauditMapper shopauditMapper;

    //保存商户
    public void save(ShopauditEntity shopaudit){
        shopaudit.setState(0);
        shopaudit.setCreattime(new Date());
        shopauditMapper.insert(shopaudit);
    }
    //单个查询商户
    public ShopauditEntity findOne(String userId){
        ShopauditExample example = new ShopauditExample();
        ShopauditExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<ShopauditEntity> shopauditEntities = shopauditMapper.selectByExample(example);
        if (shopauditEntities.size() ==1){
            return shopauditEntities.get(0);
        }else {
            return null;
        }
    }
}
