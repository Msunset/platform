package com.platform.service;

import com.github.pagehelper.Page;
import com.platform.entity.NideshopShopaudit;
import com.platform.page.PageResult;

import java.util.List;
import java.util.Map;

public interface ShopAuditService {
    List<NideshopShopaudit> findAll();
    void update(String userId,Integer state);
    Integer judge(String userId);
    List<NideshopShopaudit> findSearch(Map<String,Object> params);
}
