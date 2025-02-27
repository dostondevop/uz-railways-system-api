package uz.pdp.userservice.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateRequest {
    private String username;
    private String password;
    private int age;
}
