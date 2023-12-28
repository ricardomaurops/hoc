package br.com.rmservicos.hoc.converters;

import br.com.rmservicos.hoc.dto.UserDto;
import br.com.rmservicos.hoc.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User dtoToUser(UserDto userDto);
    UserDto entityToUserDto(User user);
}

