package backend.com.backend.user.controller;

import backend.com.backend.user.dto.UserPatchDto;
import backend.com.backend.user.dto.UserPostDto;
import backend.com.backend.user.entity.User;
import backend.com.backend.user.mapper.UserMapper;
import backend.com.backend.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity postUser(@Valid @RequestBody UserPostDto userPostDto){
        User user = userMapper.UserPostDtoToUser(userPostDto);
        User data= userService.createUser(user);
        return new ResponseEntity<>(userMapper.UserToResponseDto(data), HttpStatus.CREATED);
    }
    @PatchMapping("/{user_Id}")
    public ResponseEntity patchUser(@PathVariable("user_Id") @Positive Long userId,
                                    @Valid @RequestBody UserPatchDto userPatchDto){
        userPatchDto.setUserid(userId);
        User user = userMapper.UserPatchDtoToUser(userPatchDto);
        User data = userService.updateUser(userId,user);

        return new ResponseEntity<>(userMapper.UserToResponseDto(data),HttpStatus.OK);
    }
    @GetMapping("/{user_Id}")
    public ResponseEntity getUser(@PathVariable("user_Id") @Positive Long userId){
        User data = userService.findUser(userId);

        return new ResponseEntity<>(userMapper.UserToResponseDto(data),HttpStatus.OK);
    }
    @DeleteMapping("/{user_ID}")
    public ResponseEntity deleteUser(@PathVariable("user_Id") @Positive Long userID){
        User data = userService.deleteUser(userID);

        return new ResponseEntity<>(userMapper.UserToResponseDto(data),HttpStatus.OK);
    }
}
