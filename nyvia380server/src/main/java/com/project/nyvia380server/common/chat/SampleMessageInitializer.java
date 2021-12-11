package com.project.nyvia380server.common.chat;

import com.project.nyvia380server.common.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MessageRepository.class)
@Configuration
public class SampleMessageInitializer {

    @Bean("messages")
    CommandLineRunner commandLineRunner(MessageRepository repository){
        repository.deleteAll();

        return args -> {};
    }
}
