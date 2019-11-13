package com.platform.service;

import com.github.pagehelper.Page;
import com.platform.entity.NideshopShopaudit;
import com.platform.page.PageResult;

import java.util.List;

public interface ShopAuditService {
    List<NideshopShopaudit> findAll();
    void update(String userId,Integer state);
    Integer judge(String userId);

    PageResult findSearch(Integer state, Integer page, Integer size);
}
