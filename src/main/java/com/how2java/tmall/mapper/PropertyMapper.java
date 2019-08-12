package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}