package edu.qingtai.personalmessage.mapper;

import edu.qingtai.personalmessage.domain.Impression;
import edu.qingtai.personalmessage.domain.ImpressionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpressionMapper {
    long countByExample(ImpressionExample example);

    int deleteByExample(ImpressionExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(Impression record);

    int insertSelective(Impression record);

    List<Impression> selectByExampleWithBLOBs(ImpressionExample example);

    List<Impression> selectByExample(ImpressionExample example);

    Impression selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") Impression record, @Param("example") ImpressionExample example);

    int updateByExampleWithBLOBs(@Param("record") Impression record, @Param("example") ImpressionExample example);

    int updateByExample(@Param("record") Impression record, @Param("example") ImpressionExample example);

    int updateByPrimaryKeySelective(Impression record);

    int updateByPrimaryKeyWithBLOBs(Impression record);

    int updateByPrimaryKey(Impression record);

    List<String> selectUuidByPageIndex(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    List<Impression> selectImpressionByUuidlist(@Param("uuidList") List<String> uuidList);
}