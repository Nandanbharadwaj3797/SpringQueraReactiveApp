package com.example.quoraapp.producers;

import com.example.quoraapp.config.kafkaConfig;
import com.example.quoraapp.events.ViewCountEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishViewCountEvent(ViewCountEvent viewCountEvent) {
        kafkaTemplate.send(kafkaConfig.Topic_Name, viewCountEvent.getTargetId(), viewCountEvent)
                .whenComplete((result,err) -> {
                    if (err != null) {
                        System.out.println("Error publishing view count event"+err.getMessage());
                    }
                });
    }

}
