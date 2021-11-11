package com.project.nyvia380server.common.user;

import com.project.nyvia380server.exception.ResourceNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<Member, UUID> {


    default Member findUserOrThrowNotFound(UUID id, List<Member> members) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found!"));
    }


}
