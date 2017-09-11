package com.kou.dao;

import com.kou.entity.HouseItem;

import java.util.List;
import java.util.Map;

public interface HouseItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseItem record);

    int insertSelective(HouseItem record);

    HouseItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseItem record);

    int updateByPrimaryKey(HouseItem record);

    List<HouseItem> selectByCondition(Map<String, Object> condition);

    List<HouseItem> selectAll();
}