package com.mail.mapping;

import com.mail.model.Context;
import com.mail.model.ContextExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContextMapper {
    int countByExample(ContextExample example);

    int deleteByExample(ContextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Context record);

    int insertSelective(Context record);

    List<Context> selectByExample(ContextExample example);

    Context selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Context record, @Param("example") ContextExample example);

    int updateByExample(@Param("record") Context record, @Param("example") ContextExample example);

    int updateByPrimaryKeySelective(Context record);

    int updateByPrimaryKey(Context record);
}