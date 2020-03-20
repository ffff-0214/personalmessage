package edu.qingtai.personalmessage.event;

import edu.qingtai.personalmessage.domain.Impression;
import edu.qingtai.personalmessage.domain.Infer;
import edu.qingtai.personalmessage.domain.Interview;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    EventHandler(){}

    @RabbitListener(queues = "infer")
    void handleInfer(final Infer infer){
        System.out.println(infer.getUuid());
        System.out.println(infer.getTitle());
        System.out.println(infer.getImages());
        System.out.println(infer.getInserttime());
        System.out.println(infer.getLabel());
        System.out.println(infer.getFavorite());
        System.out.println(infer.getContent());
    }

    @RabbitListener(queues = "impression")
    void handleImpression(final Impression impression){
        System.out.println(impression);
    }

    @RabbitListener(queues = "interview")
    void handleInterview(final Interview interview){
        System.out.println(interview);
    }
}
