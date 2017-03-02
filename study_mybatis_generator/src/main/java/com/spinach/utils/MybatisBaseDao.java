package com.spinach.utils;

import java.util.List;
import java.util.Map;

public interface MybatisBaseDao<T> {
	public T selectByPrimaryKey(Integer id);  
	  
    public int deleteByPrimaryKey(Integer id);  
  
    public int insertSelective(T t);  
  
    public int updateByPrimaryKeySelective(T t);  
  
    public List<T> getList(T t);  
  
    // 获取数量  
    public int getCountSelective(T t);  
  
    /** 
     *  
     * @Title: findPage 
     * @Description: TODO() 
     * @param page 分页参数 
     * @param sql  mybatis sql语句 
     * @param values  命名参数,按名称绑定 
     * @return 分页查询结果, 附带结果列表及所有查询时的参数. 
     * @author YangChao 
     * @date 2016年9月7日 下午5:30:28 
     */  
    public Page<T> findPage(final Page<T> page, final String sql, final Map<String, Object> values); 
}
