package edu.qingtai.personalmessage.mapper;

import edu.qingtai.personalmessage.domain.Interview;
import edu.qingtai.personalmessage.domain.InterviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewMapper {
    long countByExample(InterviewExample example);

    int deleteByExample(InterviewExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(Interview record);

    int insertSelective(Interview record);

    List<Interview> selectByExampleWithBLOBs(InterviewExample example);

    List<Interview> selectByExample(InterviewExample example);

    Interview selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") Interview record, @Param("example") InterviewExample example);

    int updateByExampleWithBLOBs(@Param("record") Interview record, @Param("example") InterviewExample example);

    int updateByExample(@Param("record") Interview record, @Param("example") InterviewExample example);

    int updateByPrimaryKeySelective(Interview record);

    int updateByPrimaryKeyWithBLOBs(Interview record);

    int updateByPrimaryKey(Interview record);

    List<String> selectUuidByPageIndex(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    List<Interview> selectInterviewByUuidlist(@Param("uuidList") List<String> uuidList);
}