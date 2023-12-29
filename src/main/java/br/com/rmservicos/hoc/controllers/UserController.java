package br.com.rmservicos.hoc.controllers;

import br.com.rmservicos.hoc.converters.UserMapper;
import br.com.rmservicos.hoc.dto.UserDto;
import br.com.rmservicos.hoc.entities.User;
import br.com.rmservicos.hoc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id){

        Optional<User> user =  userService.findById(id);
        return user.map(value -> ResponseEntity.ok(userMapper.entityToUserDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping()
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){

        if(!Objects.isNull(userDto) && !Objects.isNull(userDto.getName())
                                            && !Objects.isNull(userDto.getEmail())) {
            User user = userMapper.dtoToUser(userDto);
            user = userService.save(user);
            return ResponseEntity.ok(userMapper.entityToUserDto(user));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.dtoToUser(userDto);
        user = userService.update(user);
        return ResponseEntity.ok(userMapper.entityToUserDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    private void toListDto(List<User> usersDb, List<UserDto> users) {
        if(!usersDb.isEmpty()) {
            usersDb.forEach((user ->
                    users.add(userMapper.entityToUserDto(user)
                    )));
        }
    }
}
