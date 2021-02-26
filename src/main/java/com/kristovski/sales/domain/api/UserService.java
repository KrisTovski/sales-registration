package com.kristovski.sales.domain.api;

import com.kristovski.sales.domain.user.User;
import com.kristovski.sales.domain.user.UserDao;

import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void register(UserRegistrationDto userRegistration) {
        User userToSave = UserMapper.map(userRegistration);
        userDao.save(userToSave);
    }

    private static class UserMapper {
        static User map(UserRegistrationDto userRegistration) {
            return new User(
                    userRegistration.getUsername(),
                    userRegistration.getEmail(),
                    userRegistration.getPassword(),
                    LocalDateTime.now()
            );
        }
    }


}
