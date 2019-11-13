package com.platform.service;
import com.platform.dao.NideshopShopauditMapper;
import com.platform.entity.NideshopShopaudit;
import com.platform.entity.NideshopShopauditExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApiShopAuditService {
    @Autowired
    private NideshopShopauditMapper shopauditMapper;

    //保存商户
    public void save(NideshopShopaudit shopaudit){
        shopaudit.setState(0);
        shopaudit.setCreattime(new Date());
        shopauditMapper.insert(shopaudit);
    }
    //单个查询商户
    public NideshopShopaudit findOne(String userId){
        NideshopShopauditExample example = new NideshopShopauditExample();
        NideshopShopauditExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<NideshopShopaudit> nideshopShopaudits = shopauditMapper.selectByExample(example);
        if (nideshopShopaudits.size() !=0){
            return nideshopShopaudits.get(0);
        }else {
            return null;
        }
    }
}
