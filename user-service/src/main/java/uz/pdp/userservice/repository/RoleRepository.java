package uz.pdp.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.userservice.entity.RoleEntity;
import uz.pdp.userservice.entity.enums.UserRole;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByRole(UserRole role);
}
