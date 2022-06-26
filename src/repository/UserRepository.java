package repository;

import models.User;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Map<String, User> userMap;

    private UserRepository() {}

    public static Map<String, User> getUserMap() {
        if (userMap == null) {
            userMap = new HashMap<>();
        }

        return userMap;
    }
}
