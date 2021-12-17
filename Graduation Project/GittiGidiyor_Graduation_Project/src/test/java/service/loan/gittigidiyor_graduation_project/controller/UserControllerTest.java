package service.loan.gittigidiyor_graduation_project.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.loan.gittigidiyor_graduation_project.dto.UserDTO;
import service.loan.gittigidiyor_graduation_project.model.User;
import service.loan.gittigidiyor_graduation_project.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

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
        // given
        User user = new User();
        user.setIdentityNumber("2543534535");
        Optional<User> expected = Optional.of(user);
        when(mockUserService.saveUser(any())).thenReturn(expected);

        // when
        UserDTO dto = new UserDTO();
        User actual = this.userController.saveUser(dto).getBody();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.get(), actual),
                () -> assertEquals(user.getIdentityNumber(), actual.getIdentityNumber())
        );
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}