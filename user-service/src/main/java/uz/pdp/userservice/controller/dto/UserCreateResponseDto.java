package uz.pdp.userservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import uz.pdp.userservice.entity.enums.UserRole;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class UserCreateResponseDto {
    private int id;
    private String username;
    private int age;
    private List<UserRole> roles;
}
