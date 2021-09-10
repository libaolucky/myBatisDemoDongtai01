package com.xue.dao;

import com.xue.bean.City;
import com.xue.bean.CityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CityDAO {
    long countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
    //写出两张表  city--- 郑州， 区表 中原区，管城区， 开发区， 写出 1 对多的动态sql
    List<City> selectAndCantonal(Map map);
}