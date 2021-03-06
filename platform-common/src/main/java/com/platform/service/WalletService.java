package com.platform.service;

import com.platform.entity.WalletEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-12-03 11:13:19
 */
public interface WalletService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    WalletEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<WalletEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param wallet 实体
     * @return 保存条数
     */
    int save(WalletEntity wallet);

    /**
     * 根据主键更新实体
     *
     * @param wallet 实体
     * @return 更新条数
     */
    int update(WalletEntity wallet);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);

    /**
     * 根据商铺id查询出商铺钱包信息
     * @param merchant_id
     * @return
     */
    WalletEntity findByShopId(Integer merchant_id);
}
