package com.app.repo;

import com.app.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(int id);
    void saveUser(User user);
    void deleteUser(int id);
    String savePhoto(MultipartFile file, Long id, String type);


}
