package com.mail.mapping;

import com.mail.model.Context;
import com.mail.model.ContextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContextMapper {
    int countByExample(ContextExample example);

    int deleteByExample(ContextExample example);

    int insert(Context record);

    int insertSelective(Context record);

    List<Context> selectByExample(ContextExample example);

    int updateByExampleSelective(@Param("record") Context record, @Param("example") ContextExample example);

    int updateByExample(@Param("record") Context record, @Param("example") ContextExample example);
}