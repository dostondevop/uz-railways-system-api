package uz.pdp.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.userservice.controller.dto.JwtResponseDto;
import uz.pdp.userservice.controller.dto.UserCreateRequest;
import uz.pdp.userservice.entity.RoleEntity;
import uz.pdp.userservice.entity.UserEntity;
import uz.pdp.userservice.entity.enums.UserRole;
import uz.pdp.userservice.repository.RoleRepository;
import uz.pdp.userservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;


    public UserEntity save(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(List.of(getUserRole()));
        return userRepository.save(userEntity);
    }

    public JwtResponseDto login(String username, String password) throws JsonProcessingException {
        Optional<UserEntity> optionalUserEntity =
                userRepository.findByUsername(username);
        if (optionalUserEntity.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        UserEntity userEntity = optionalUserEntity.get();
        boolean matches = passwordEncoder.matches(password, userEntity.getPassword());
        if (!matches) {
           throw new UsernameNotFoundException(username);
        }

        String accessToken = jwtService.generateAccessToken(userEntity);
        String refreshToken = jwtService.generateRefreshToken(userEntity);
        return new JwtResponseDto("Bearer " + accessToken, refreshToken);
    }

    private RoleEntity getUserRole() {
        return roleRepository.findByRole(UserRole.USER);
    }

    public UserEntity getUserById(int userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (optionalUserEntity.isEmpty()) {
            throw new IllegalStateException(String.format("User with id %s not found", userId));
        }
        return optionalUserEntity.get();
    }
}
