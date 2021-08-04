package learning.service;

import learning.entity.dto.request.UserRequest;
import learning.entity.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User insertUser(UserRequest user);

    void deleteUser(int id);

    User findById(int id);

    User editUser(int id, UserRequest param);
}
