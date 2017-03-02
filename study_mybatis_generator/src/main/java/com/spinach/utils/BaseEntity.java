package com.spinach.utils;

import java.io.Serializable;

/** 
 * @项目名称：project-common 
 * @类名称：BaseEntity 
 * @类描述：所有实体类的父类。可将公共的属性所有类序列化集中在此类中 
 * @创建人：YangChao 
 * @作者单位：北京宝库在线网络技术有限公司 
 * @联系方式：YangChao@baoku.com 
 * @创建时间：2016年9月5日 上午11:37:02 
 * @version 1.0.0 
 */  
public abstract class BaseEntity implements Serializable,Cloneable{  
    private static final long serialVersionUID = 1L;  
    private Integer id;  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
} 