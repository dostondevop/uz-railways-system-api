package uz.pdp.userservice.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RefreshTokenDto {
    private String refreshToken;
}
