package com.platform.dao;

import com.platform.entity.NideshopShopaudit;
import com.platform.entity.NideshopShopauditExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NideshopShopauditMapper {
    long countByExample(NideshopShopauditExample example);

    int deleteByExample(NideshopShopauditExample example);

    int insert(NideshopShopaudit record);

    int insertSelective(NideshopShopaudit record);

    List<NideshopShopaudit> selectByExample(NideshopShopauditExample example);

    int updateByExampleSelective(@Param("record") NideshopShopaudit record, @Param("example") NideshopShopauditExample example);

    int updateByExample(@Param("record") NideshopShopaudit record, @Param("example") NideshopShopauditExample example);
}