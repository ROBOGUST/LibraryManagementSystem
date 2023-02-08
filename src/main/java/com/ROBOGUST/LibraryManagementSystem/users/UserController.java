package com.ROBOGUST.LibraryManagementSystem.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/delete_user/{id}")
    private void deleteUserById(@PathVariable("id") long id) {
        userService.delete(id);
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return userService.update(user.getUsername(), user.getRole(), id);
    }
}

