package com.project.nyvia380server.common.user;


import com.project.nyvia380server.util.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final Utils utils;

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

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

    public Member getUser(String id) {
        return userRepository.findUserOrThrowNotFound(id);
    }

    public Member findUserByAlias(String alias) {
        return userRepository.findUserByAliasOrThrowNotFound(alias);
    }

    public Member insertUser(Member newUser) {
         return userRepository.insert(newUser);
    }


    public void deleteUser(String id) {
        userRepository.deleteById(userRepository.findUserOrThrowNotFound(id).getId());
    }

    public void updateUser(Member member) {
        userRepository.deleteById(userRepository.findUserOrThrowNotFound(member.getId())
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
