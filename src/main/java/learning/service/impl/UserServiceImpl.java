package learning.service.impl;

import learning.entity.dto.request.UserRequest;
import learning.entity.models.Role;
import learning.entity.models.User;
import learning.exceptions.NotFoundException;
import learning.repositories.RoleRepository;
import learning.repositories.UserRepository;
import learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public User insertUser(UserRequest userRequest) {
        User user = User.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .createAt(LocalDateTime.now())
                .build();
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User editUser(int id, UserRequest param) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        user.setEmail(param.getEmail());
        user.setUsername(param.getUsername());
        user.setPassword(param.getPassword());
        Role role = roleRepository.findById(param.getRole()).orElseThrow(NotFoundException::new);
        user.setRole(role);
        userRepository.save(user);
        return user;
    }
}
