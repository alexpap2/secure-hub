package authproject.secure_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import authproject.secure_backend.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
