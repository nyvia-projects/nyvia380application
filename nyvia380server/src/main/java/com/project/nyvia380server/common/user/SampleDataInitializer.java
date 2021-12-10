package com.project.nyvia380server.common.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SampleDataInitializer {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        userRepository.deleteAll();
//        return args -> {
//            userRepository.saveAll(supplyUsersForDB.apply(10));
            /*
            userRepository.save(moderatorSupplier.get()); //FIXME this
            userRepository.save(adminSupplier.get()); //FIXME this

             */
        //};
        return args -> {};
    }

//    Supplier<Member> userSupplier = () -> Member.builder()
//            //.id(UUID.randomUUID())
//            .firstName("Char " + Character.toString((new Random().nextInt(26) + 'A')))
//            .lastName("Last " + Character.toString((new Random().nextInt(26) + 'A')))
//            .age(16 + new Random().nextInt(22))
//            .alias("Mr. " + Character.toString((new Random().nextInt(26) + 'A')))
//            .password("password")
//            .build();

    /*
    Supplier<Moderator> moderatorSupplier = () -> Moderator.builder()
            .firstName("Moderator 00" + Character.toString((new Random().nextInt(26) + 'A')))
            .lastName("Last " + Character.toString((new Random().nextInt(26) + 'A')))
            .age(16 + new Random().nextInt(22))
            .build();

    Supplier<Moderator> adminSupplier = () -> Admin.builder()
            .firstName("ADMIN " + Character.toString((new Random().nextInt(26) + 'A')))
            .lastName("Alfa " + Character.toString((new Random().nextInt(26) + 'A')))
            .age(16 + new Random().nextInt(22))
            .build();
     */

//    Function<Integer, List<Member>> supplyUsersForDB = integer -> Stream.generate(() -> userSupplier.get())
//            .limit(integer)
//            .collect(Collectors.toList());



}
