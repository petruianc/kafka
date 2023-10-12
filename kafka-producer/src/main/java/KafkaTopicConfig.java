import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic(){
        Optional<Integer> numberOfPartitions = Optional.of(2);
        short replicas = 1;
        return new NewTopic("wikimedia", 2, replicas);
    }
}
