package edu.qingtai.personalmessage.mapper;

import edu.qingtai.personalmessage.domain.Infer;
import edu.qingtai.personalmessage.domain.InferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InferMapper {
    long countByExample(InferExample example);

    int deleteByExample(InferExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(Infer record);

    int insertSelective(Infer record);

    List<Infer> selectByExampleWithBLOBs(InferExample example);

    List<Infer> selectByExample(InferExample example);

    Infer selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") Infer record, @Param("example") InferExample example);

    int updateByExampleWithBLOBs(@Param("record") Infer record, @Param("example") InferExample example);

    int updateByExample(@Param("record") Infer record, @Param("example") InferExample example);

    int updateByPrimaryKeySelective(Infer record);

    int updateByPrimaryKeyWithBLOBs(Infer record);

    int updateByPrimaryKey(Infer record);

    List<String> selectUuidByPageIndex(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    List<Infer> selectInferByUuidlist(@Param("uuidList") List<String> uuidList);
}