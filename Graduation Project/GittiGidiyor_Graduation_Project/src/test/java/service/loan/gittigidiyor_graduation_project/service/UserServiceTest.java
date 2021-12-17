package service.loan.gittigidiyor_graduation_project.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.loan.gittigidiyor_graduation_project.controller.UserController;
import service.loan.gittigidiyor_graduation_project.dto.UserDTO;
import service.loan.gittigidiyor_graduation_project.exceptions.BadRequestException;
import service.loan.gittigidiyor_graduation_project.mappers.UserMapper;
import service.loan.gittigidiyor_graduation_project.model.User;
import service.loan.gittigidiyor_graduation_project.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository mockUserRepository;

    @Mock
    UserMapper mockUserMapper;

    @Mock
    UserService mockUserService;

    @InjectMocks
    UserController userController;

    UserDTO exampleUserDTO;
    List<UserDTO> exampleUserDTOList;

    @BeforeEach
    void initialize() {
        exampleUserDTO = new UserDTO();
        exampleUserDTOList = new ArrayList<>();
    }

    @AfterEach
    void nullifier() {
        exampleUserDTO = null;
        exampleUserDTOList = null;
    }

    @Test
    void applyCredit() {
    }

    @Test
    void saveUser() {

    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void findById() {
    }
}