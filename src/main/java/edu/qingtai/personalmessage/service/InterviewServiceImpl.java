package edu.qingtai.personalmessage.service;

import edu.qingtai.personalmessage.domain.Impression;
import edu.qingtai.personalmessage.domain.Interview;
import edu.qingtai.personalmessage.mapper.InterviewMapper;
import edu.qingtai.personalmessage.utils.ConstData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService{
    private InterviewMapper interviewMapper;

    @Autowired
    public InterviewServiceImpl(final InterviewMapper interviewMapper){
        this.interviewMapper=interviewMapper;
    }

    @Override
    public List<Interview> queryInterviews(int pageSize){
        int startIndex = (pageSize - 1) * ConstData.pageSize;
        List<String> uuidList = interviewMapper.selectUuidByPageIndex(startIndex, ConstData.pageSize);
        if(uuidList.isEmpty()){
            return null;
        }
        return interviewMapper.selectInterviewByUuidlist(uuidList);
    }
}
