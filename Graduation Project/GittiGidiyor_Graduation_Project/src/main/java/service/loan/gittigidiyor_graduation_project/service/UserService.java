package service.loan.gittigidiyor_graduation_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.loan.gittigidiyor_graduation_project.dto.UserDTO;
import service.loan.gittigidiyor_graduation_project.exceptions.UserIsExistException;
import service.loan.gittigidiyor_graduation_project.exceptions.UserIsNotExistException;
import service.loan.gittigidiyor_graduation_project.mappers.UserMapper;
import service.loan.gittigidiyor_graduation_project.model.User;
import service.loan.gittigidiyor_graduation_project.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public Optional<User> saveUser(UserDTO userDTO) {

        boolean isExists = userRepository.existsByIdentityNumber(userDTO.getIdentityNumber());

        if (isExists) {
            throw new UserIsExistException("User with identity number: " + userDTO.getIdentityNumber() + " is already exists!");
        }

        User user = userMapper.mapFromUserDTOToUser(userDTO);

        return Optional.of(userRepository.save(user));
    }

    @Transactional
    public Optional<User> updateUser(UserDTO userDTO) {

        boolean isExists = userRepository.existsByIdentityNumber(userDTO.getIdentityNumber());

        if (!isExists) {
            throw new UserIsNotExistException("User with identity number: " + userDTO.getIdentityNumber() + " is not exists!");
        }
        User user = userMapper.mapFromUserDTOToUser(userDTO);
        userRepository.updateUser(user.getFullName(), user.getIdentityNumber(), user.getMonthlyIncome(), user.getPhoneNumber(), user.getId());
        return findById(user.getId());
    }

    @Transactional
    public void deleteUser(int id) {

        boolean isExists = userRepository.existsById(id);

        if (!isExists) {
            throw new UserIsNotExistException("User with id : " + id + " is not exists!");
        }
        userRepository.deleteUserById(id);
    }

    @Transactional
    public Optional<User> findById(int id) {

        boolean isExists = userRepository.existsById(id);

        if (!isExists) {
            throw new UserIsExistException("User with id : " + id + " is not exists!");
        }

        return userRepository.findById(id);
    }}
