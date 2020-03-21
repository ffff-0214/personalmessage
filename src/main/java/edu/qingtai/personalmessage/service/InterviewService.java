package edu.qingtai.personalmessage.service;

import edu.qingtai.personalmessage.domain.Interview;

import java.util.List;

public interface InterviewService {
    List<Interview> queryInterviews(int pageSize);
    void handleInterview(Interview interview);
}
