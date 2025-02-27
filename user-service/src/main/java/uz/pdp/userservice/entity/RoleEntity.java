package uz.pdp.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import uz.pdp.userservice.entity.enums.UserRole;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public String getAuthority() {
        return "ROLE_" + role.name();
    }

    public RoleEntity(UserRole role) {
        this.role = role;
    }
}