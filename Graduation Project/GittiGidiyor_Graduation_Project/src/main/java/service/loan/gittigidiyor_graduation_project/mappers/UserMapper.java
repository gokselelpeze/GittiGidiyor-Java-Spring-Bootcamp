package service.loan.gittigidiyor_graduation_project.mappers;

import org.mapstruct.Mapper;
import service.loan.gittigidiyor_graduation_project.dto.UserDTO;
import service.loan.gittigidiyor_graduation_project.model.User;

@Mapper(componentModel = "spring")

public abstract class UserMapper {

    public abstract User mapFromUserDTOToUser(UserDTO userDTO);

    public abstract UserDTO mapFromUserToUserDTO(User user);
}
