package service.loan.gittigidiyor_graduation_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.loan.gittigidiyor_graduation_project.dto.UserDTO;
import service.loan.gittigidiyor_graduation_project.model.User;
import service.loan.gittigidiyor_graduation_project.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userDTO) {
        Optional<User> resultOptional = userService.saveUser(userDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDTO userDTO) {
        Optional<User> resultOptional = userService.updateUser(userDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable @Valid int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted with id: " + id ,HttpStatus.OK);
    }
}
