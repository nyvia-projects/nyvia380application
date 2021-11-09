package com.project.nyvia380server.common.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String printUserPageMessage(){
        return "This is Users/People Page!";
    }

    public void insertUser(User user) {
        userRepository.insert(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    /*public String getUsers(){
        List<User> usersList= userRepository.findAll();
        List<String> userData = usersList.stream().map((User::toString)).collect(Collectors.toList());
        return userData.stream().map(String::valueOf).collect(Collectors.joining("-----"));
    }*/

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return String.format("User with #ID: %s was deleted!", id);
    }
}
