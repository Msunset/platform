package com.platform.dao;

import com.platform.entity.WalletEntity;
import com.platform.entity.example.WalletExample;

/**
 * Dao
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2019-12-03 11:13:19
 */
public interface WalletMapper extends BaseMapper<WalletEntity, WalletExample> {
    WalletEntity findByShopId(Integer merchant_id);

}
