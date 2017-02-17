package com.test.mysql.dao;

import com.test.mysql.model.GoodsInfo;
import com.test.mysql.model.GoodsInfoExample;
import java.util.List;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Integer goodsid);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    List<GoodsInfo> selectByExampleWithBLOBs(GoodsInfoExample example);

    List<GoodsInfo> selectByExample(GoodsInfoExample example);

    GoodsInfo selectByPrimaryKey(Integer goodsid);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKeyWithBLOBs(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}