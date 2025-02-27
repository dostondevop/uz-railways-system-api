package uz.pdp.userservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserGetResponseDto {
    private int userId;
    private String name;
    private String email;
    private String phone;
}
