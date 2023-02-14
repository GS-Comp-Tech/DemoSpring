package com.gscomptech.DemoSpring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    public List<User> users;
    public UsersService() {
        users = new ArrayList<>();
        User user1 = new User(1, "abc");
        User user2 = new User(2, "xyz");
        User user3 = new User(3, "pqr");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        User target = null;
        for(User user : users) {
            if(user.id == id) {
                target = user;
                break;
            }
        }
        return target;
    }
}
