package com.project.nyvia380server.common.user;

import com.project.nyvia380server.exception.ResourceNotFoundException;
import com.project.nyvia380server.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final Utils utils;

    private final UserRepository userRepository;

    public Member findUserOrThrowNotFound(UUID id, List<Member> members) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Anime Not Found!"));
    }

  /*  @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    public String getMessage() {
        return "Message from RestController";
    }

    public List<Member> getUsers() {
        return userRepository.findAll();
    }

    public Optional<Member> getUser(UUID id) {
        return userRepository.findById(id); //Optional
    }

    public Member insertUser(Member member) {
        return userRepository.insert(member);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Member member) {
        userRepository.deleteById(userRepository.findUserOrThrowNotFound(member.getId(), userRepository.findAll())
                .getId());
        userRepository.save(member);
    }

    public Long getUserCount() {
        return userRepository.count();
    }

    /*public String getUsers(){
        List<User> usersList= userRepository.findAll();
        List<String> userData = usersList.stream().map((User::toString)).collect(Collectors.toList());
        return userData.stream().map(String::valueOf).collect(Collectors.joining("-----"));
    }*/
}
