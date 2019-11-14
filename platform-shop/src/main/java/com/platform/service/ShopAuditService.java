package com.platform.service;

import com.platform.entity.NideshopShopaudit;
import com.platform.utils.Query;

import java.util.List;
import java.util.Map;

public interface ShopAuditService {
    List<NideshopShopaudit> findAll();
    void update(String userId,Integer state);
    Integer judge(String userId);

    List<NideshopShopaudit> queryList(Map<String,Object> map);

    int queryTotal(Map<String,Object> map);
}
