package ir.ac.sbu.hodhod.hodhod.models;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}
