package com.test.mysql.dao;

import com.test.mysql.model.SystemFile;

public interface SystemFileMapper {
    int deleteByPrimaryKey(Integer contractStepId);

    int insert(SystemFile record);

    int insertSelective(SystemFile record);

    SystemFile selectByPrimaryKey(Integer contractStepId);

    int updateByPrimaryKeySelective(SystemFile record);

    int updateByPrimaryKey(SystemFile record);
}