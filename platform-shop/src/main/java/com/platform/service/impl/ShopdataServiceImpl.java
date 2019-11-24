package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ShopdataMapper;
import com.platform.entity.ShopdataEntity;
import com.platform.service.ShopdataService;

/**
 * Service实现类
 *
 * @author sunset
 * @email 1451795113@qq.com
 * @date 2019-11-24 11:48:42
 */
@Service("shopdataService")
public class ShopdataServiceImpl implements ShopdataService {
    @Autowired
    private ShopdataMapper shopdataMapper;

    @Override
    public ShopdataEntity queryObject(Integer id) {
        return shopdataMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ShopdataEntity> queryList(Map<String, Object> map) {
        return shopdataMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return shopdataMapper.queryTotal(map);
    }

    @Override
    public int save(ShopdataEntity shopdata) {
        return shopdataMapper.insertSelective(shopdata);
    }

    @Override
    public int update(ShopdataEntity shopdata) {
        return shopdataMapper.updateByPrimaryKeySelective(shopdata);
    }

    @Override
    public int delete(Integer id) {
        return shopdataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopdataMapper.deleteBatch(ids);
    }
}
