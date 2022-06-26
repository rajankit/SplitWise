package services;

import models.User;
import repository.UserRepository;

import java.util.Map;

public class UserService {
    private static Map<String, User> userRepo = UserRepository.getUserMap();

    public void addUser(String id, String name, String email, String number) {
        User user = new User(id, name, email, number);
        userRepo.put(id, user);
    }
}
