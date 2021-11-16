package com.project.nyvia380server.common.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SampleDataInitializer {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        userRepository.deleteAll();
        return args -> userRepository.saveAll(supplyUsersForDB.apply(10));
    }

    Supplier<Member> userSupplier = () -> Member.builder()
            //.id(UUID.randomUUID())
            .firstName("Char " + Character.toString((new Random().nextInt(26) + 'A')))
            .lastName("Last " + Character.toString((new Random().nextInt(26) + 'A')))
            .age(16 + new Random().nextInt(22))
            .build();

    Function<Integer, List<Member>> supplyUsersForDB = integer ->
        Stream.generate(() -> userSupplier.get())
                .limit(integer)
                .collect(Collectors.toList());



}
