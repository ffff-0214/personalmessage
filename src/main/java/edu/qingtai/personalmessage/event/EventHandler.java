package edu.qingtai.personalmessage.event;

import edu.qingtai.personalmessage.domain.Impression;
import edu.qingtai.personalmessage.domain.Infer;
import edu.qingtai.personalmessage.domain.Interview;
import edu.qingtai.personalmessage.service.ImpressionService;
import edu.qingtai.personalmessage.service.InferService;
import edu.qingtai.personalmessage.service.InterviewService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {
    private ImpressionService impressionService;
    private InferService inferService;
    private InterviewService interviewService;

    EventHandler(final ImpressionService impressionService,
                 final InferService inferService,
                 final InterviewService interviewService){
        this.impressionService = impressionService;
        this.inferService = inferService;
        this.interviewService = interviewService;
    }

    @RabbitListener(queues = "infer")
    void handleInfer(final Infer infer){
        inferService.handleInfer(infer);
    }

    @RabbitListener(queues = "impression")
    void handleImpression(final Impression impression){
        impressionService.handleImpression(impression);
    }

    @RabbitListener(queues = "interview")
    void handleInterview(final Interview interview){
        interviewService.handleInterview(interview);
    }
}
