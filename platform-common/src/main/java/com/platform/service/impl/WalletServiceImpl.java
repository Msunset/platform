package com.platform.service.impl;

import com.platform.dao.WalletMapper;
import com.platform.entity.WalletEntity;
import com.platform.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-12-03 11:13:19
 */
@Service("walletService")
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletMapper walletMapper;

    @Override
    public WalletEntity queryObject(Integer id) {
        return walletMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<WalletEntity> queryList(Map<String, Object> map) {
        return walletMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return walletMapper.queryTotal(map);
    }

    @Override
    public int save(WalletEntity wallet) {
        return walletMapper.insertSelective(wallet);
    }

    @Override
    public int update(WalletEntity wallet) {
        return walletMapper.updateByPrimaryKeySelective(wallet);
    }

    @Override
    public int delete(Integer id) {
        return walletMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return walletMapper.deleteBatch(ids);
    }

    @Override
    public WalletEntity findByShopId(Integer merchant_id) {
       return walletMapper.findByShopId(merchant_id);
    }
}
