package learning.service;

import learning.entity.dto.request.UserRequest;
import learning.entity.models.User;

public interface UserService {
    User insertUser(UserRequest user);

    void deleteUser(int id) throws Exception;

    User findById(int id) throws Exception;
}
