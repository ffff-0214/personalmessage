package edu.qingtai.personalmessage.controller;

import edu.qingtai.personalmessage.domain.Interview;
import edu.qingtai.personalmessage.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/interview")
public class InterviewController {
    private InterviewService interviewService;

    @Autowired
    public InterviewController(final InterviewService interviewService){
        this.interviewService = interviewService;
    }

    @GetMapping
    public List<Interview> getInterviewsByPageIndex(@RequestParam("pageIndex") int pageIndex){
        return interviewService.queryInterviews(pageIndex);
    }
}
