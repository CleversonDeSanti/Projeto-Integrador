package com.app.repo;

import com.app.model.User;
import com.app.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    List<User> getAllUser();

    User getUserById(int id);

    void saveUser(User user);

    void deleteUser(int id);

}
