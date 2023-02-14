package com.gscomptech.DemoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {

        User target = userService.getUserById(id);
        if(target == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Resource not available here");
        }
        return target;
    }
}
