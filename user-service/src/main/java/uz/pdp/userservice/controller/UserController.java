package uz.pdp.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.userservice.controller.converter.UserConverter;
import uz.pdp.userservice.controller.dto.JwtResponseDto;
import uz.pdp.userservice.controller.dto.UserCreateRequest;
import uz.pdp.userservice.controller.dto.UserCreateResponseDto;
import uz.pdp.userservice.controller.dto.UserGetResponseDto;
import uz.pdp.userservice.entity.UserEntity;
import uz.pdp.userservice.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserCreateResponseDto saveUser(@RequestBody UserCreateRequest request) {
        UserEntity userEntity = userService.save(UserConverter.toUserEntity(request));
        return UserConverter.fromUserEntity(userEntity);
    }

    @PostMapping("/login")
    public JwtResponseDto login(@RequestBody UserCreateRequest request) throws JsonProcessingException {
        return userService.login(request.getUsername(), request.getPassword());
    }

    @GetMapping("/{id}")
    public UserGetResponseDto getUser(@PathVariable Integer id) {
        UserEntity userEntity = userService.getUserById(id);
        return UserConverter.toUserGetResponseDto(userEntity);
    }
}
