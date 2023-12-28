package br.com.rmservicos.hoc.controllers;

import br.com.rmservicos.hoc.converters.UserMapper;
import br.com.rmservicos.hoc.converters.UserMapperImpl;
import br.com.rmservicos.hoc.dto.UserDto;
import br.com.rmservicos.hoc.entities.User;
import br.com.rmservicos.hoc.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @GetMapping()
    public ResponseEntity<List<UserDto>> listUsers(){
        List<UserDto> users = new ArrayList<UserDto>();
        List<User> usersDb = userService.findAll();
        toListDto(usersDb, users);
        return ResponseEntity.ok(users);
    }
    @PostMapping()
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){

        if(!Objects.isNull(userDto) && !Objects.isNull(userDto.getName())) {
            User user = userMapper.dtoToUser(userDto);
            userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void toListDto(List<User> usersDb, List<UserDto> users) {
        if(!usersDb.isEmpty()) {
            usersDb.forEach((user ->
                    users.add(userMapper.entityToUserDto(user)
                    )));
        }
    }
}
