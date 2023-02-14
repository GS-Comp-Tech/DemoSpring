package com.gscomptech.DemoSpring;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    public List<User> users;

        public UsersController() {
        users = new ArrayList<>();
        User user1 = new User(1, "abc");
        User user2 = new User(2, "xyz");
        User user3 = new User(3, "pqr");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User target = null;
        for(User user : users) {
            if(user.id == id) {
                target = user;
                break;
            }
        }
        if(target == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Resource not available here");
        }
        return target;
    }
}
