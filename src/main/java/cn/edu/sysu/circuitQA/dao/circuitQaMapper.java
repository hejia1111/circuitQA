package cn.edu.sysu.circuitQA.dao;

import cn.edu.sysu.circuitQA.model.circuitQa;
import cn.edu.sysu.circuitQA.model.circuitQaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface circuitQaMapper {
    long countByExample(circuitQaExample example);

    int deleteByExample(circuitQaExample example);

    int insert(circuitQa record);

    int insertSelective(circuitQa record);

    List<circuitQa> selectByExample(circuitQaExample example);

    int updateByExampleSelective(@Param("record") circuitQa record, @Param("example") circuitQaExample example);

    int updateByExample(@Param("record") circuitQa record, @Param("example") circuitQaExample example);
}