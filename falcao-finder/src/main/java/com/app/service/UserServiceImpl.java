package com.app.service;


import com.app.model.User;
import com.app.repo.UserRepository;
import com.app.repo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById((long) id).get();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById((long) id);
    }

    @Override
    public String savePhoto(MultipartFile file, Long id, String type) {
        try {
            Optional<User> userOptional = userRepository.findById((long) Math.toIntExact(id));

            if (userOptional.isPresent()) {
                User user = userOptional.get();

                if (type.equals("profile")) {
                    user.setProfilePhoto(file.getBytes()); // Salva foto de perfil
                } else if (type.equals("cover")) {
                    user.setCoverPhoto(file.getBytes()); // Salva foto de capa
                }

                userRepository.save(user); // Salva no banco
                return "Imagem salva com sucesso!";
            } else {
                return "Usuário não encontrado!";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao salvar imagem!";
        }
    }
}
