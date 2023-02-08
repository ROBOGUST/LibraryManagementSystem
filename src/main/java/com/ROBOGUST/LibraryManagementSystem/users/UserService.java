package com.ROBOGUST.LibraryManagementSystem.users;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity delete(long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);

        }else {
            throw new RuntimeException("user does not exist");
        }
        return null;
    }

    public ResponseEntity<User> update(String username, Role role, int id) {
        return null;
    }
}
