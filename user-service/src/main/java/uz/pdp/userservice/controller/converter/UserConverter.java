package uz.pdp.userservice.controller.converter;

import uz.pdp.userservice.controller.dto.UserCreateRequest;
import uz.pdp.userservice.controller.dto.UserCreateResponseDto;
import uz.pdp.userservice.controller.dto.UserGetResponseDto;
import uz.pdp.userservice.entity.RoleEntity;
import uz.pdp.userservice.entity.UserEntity;

public class UserConverter {

    public static UserCreateResponseDto fromUserEntity(UserEntity userEntity) {
        return UserCreateResponseDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .age(userEntity.getAge())
                .roles(userEntity.getRoles().stream().map(RoleEntity::getRole).toList())
                .build();
    }

    public static UserEntity toUserEntity(UserCreateRequest request) {
        return UserEntity.builder()
                .age(request.getAge())
                .username(request.getUsername())
                .password(request.getPassword())
                .build();
    }

    public static UserGetResponseDto toUserGetResponseDto(UserEntity userEntity) {
        return UserGetResponseDto.builder()
                .userId(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phone(userEntity.getUsername())
                .build();
    }
}
