package com.test.mysql.dao;

import com.test.mysql.model.ttt;
import com.test.mysql.model.tttExample;
import java.util.List;

public interface tttMapper {
    int deleteByPrimaryKey(Integer messageMerchantInfoId);

    int insert(ttt record);

    int insertSelective(ttt record);

    List<ttt> selectByExample(tttExample example);

    ttt selectByPrimaryKey(Integer messageMerchantInfoId);

    int updateByPrimaryKeySelective(ttt record);

    int updateByPrimaryKey(ttt record);
}