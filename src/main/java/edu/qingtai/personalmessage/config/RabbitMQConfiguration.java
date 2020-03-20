package edu.qingtai.personalmessage.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class RabbitMQConfiguration implements RabbitListenerConfigurer {
    @Bean
    public TopicExchange topicExchange(@Value("${topicExchangeName}") final String exchangeName){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue inferQueue(){
        return new Queue("infer", true);
    }

    @Bean
    public Queue impressionQueue(){
        return new Queue("impression",true);
    }

    @Bean
    public Queue interviewQueue(){
        return new Queue("interview", true);
    }

    @Bean
    public Binding bindinginfer(Queue inferQueue, TopicExchange exchange){
        return BindingBuilder.bind(inferQueue).to(exchange).with("*.infer");
    }

    @Bean
    public Binding bindingimpression(Queue impressionQueue, TopicExchange exchange){
        return BindingBuilder.bind(impressionQueue).to(exchange).with("*.impression");
    }

    @Bean
    public Binding bindinginterview(Queue interviewQueue, TopicExchange exchange){
        return BindingBuilder.bind(interviewQueue).to(exchange).with("*.interview");
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }


}
