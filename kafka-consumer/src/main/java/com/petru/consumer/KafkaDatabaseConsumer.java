package com.petru.consumer;

import com.petru.consumer.entity.WikimediaDatabase;
import com.petru.consumer.repository.WikimediaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @Autowired
    private WikimediaRepo wikimediaRepo;

    @KafkaListener(
            topics= "wikimedia",
            groupId = "myGroup",
            topicPartitions = @TopicPartition(topic = "wikimedia", partitions = {"1", "0"} )
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("message received -> %s", eventMessage));
        WikimediaDatabase wikimediaDatabase = new WikimediaDatabase();
        wikimediaDatabase.setWikiEventData(eventMessage);
        wikimediaRepo.save(wikimediaDatabase);
    }
}
