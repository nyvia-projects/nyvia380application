package com.project.nyvia380server.common.user;

import com.project.nyvia380server.exception.ResourceNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<Member, String> {

    default Member findUserOrThrowNotFound(String id) {
        return findAll().stream()
                .filter(member -> member.getId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found!"));
    }


    default Member findUserByAliasOrThrowNotFound(String alias) {
        List<Member> members = findAll();
        return members.stream()
                .filter(member -> member.getAlias()
                        .equals(alias))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No User under that Alias!")
                );
    }
}
