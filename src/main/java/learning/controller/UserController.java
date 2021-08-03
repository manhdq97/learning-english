package learning.controller;

import learning.entity.dto.request.UserRequest;
import learning.entity.models.User;
import learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<User> user(@PathVariable int id) throws Exception {
        User user = userService.findById(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody UserRequest user) {
        User response = userService.insertUser(user);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
