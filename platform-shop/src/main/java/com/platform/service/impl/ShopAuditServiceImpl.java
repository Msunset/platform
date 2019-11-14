package com.platform.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.platform.dao.NideshopShopauditMapper;
import com.platform.entity.NideshopShopaudit;
import com.platform.entity.NideshopShopauditExample;
import com.platform.page.PageResult;
import com.platform.service.ShopAuditService;
import com.platform.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopAuditServiceImpl implements ShopAuditService {
    @Autowired
    private NideshopShopauditMapper shopAuditMapper;
    @Override
    public List<NideshopShopaudit> findAll() {
        List<NideshopShopaudit> nideshopShopaudits = shopAuditMapper.selectByExample(null);
        return nideshopShopaudits;
    }

    @Override
    public void update(String userId, Integer state) {
        NideshopShopauditExample example = new NideshopShopauditExample();
        NideshopShopauditExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        NideshopShopaudit nideshopShopaudit1 = new NideshopShopaudit();
        nideshopShopaudit1.setState(state);
        shopAuditMapper.updateByExampleSelective(nideshopShopaudit1,example);
    }

    @Override
    public Integer judge(String userId) {

        NideshopShopauditExample example = new NideshopShopauditExample();
        NideshopShopauditExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<NideshopShopaudit> nideshopShopaudits = shopAuditMapper.selectByExample(example);
        if (nideshopShopaudits.size()==1){
            //存在该用户，正常情况
            return 1;
        }else if (nideshopShopaudits.size() >1){
            //用户异常
            return 2;
        }else {
            //用户不再存在
            return 0;
        }
    }

    @Override
    public List<NideshopShopaudit> queryList(Map<String,Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String,Object> map) {
        return 0;
    }


}
