package learning.service.impl;

import learning.entity.dto.request.UserRequest;
import learning.entity.models.User;
import learning.repositories.UserRepository;
import learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User insertUser(UserRequest userRequest) {
        User user = User.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .createTime(LocalDateTime.now())
                .build();
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) throws Exception{
        User user = userRepository.getById(id);
        userRepository.delete(user);
    }

    @Override
    public User findById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
}
