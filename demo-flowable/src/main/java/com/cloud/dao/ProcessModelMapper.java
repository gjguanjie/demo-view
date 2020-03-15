package com.cloud.dao;

import com.cloud.entity.ProcessModel;
import com.cloud.entity.ProcessModelExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProcessModelMapper {
    long countByExample(ProcessModelExample example);

    int deleteByExample(ProcessModelExample example);

    int insert(ProcessModel record);

    int insertSelective(ProcessModel record);

    List<ProcessModel> selectByExample(ProcessModelExample example);

    int updateByExampleSelective(@Param("record") ProcessModel record, @Param("example") ProcessModelExample example);

    int updateByExample(@Param("record") ProcessModel record, @Param("example") ProcessModelExample example);
}