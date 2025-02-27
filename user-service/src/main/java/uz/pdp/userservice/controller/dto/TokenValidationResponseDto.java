package uz.pdp.userservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Builder
@Data
public class TokenValidationResponseDto {
    private String username;
    private Set<String> authorities;
}
