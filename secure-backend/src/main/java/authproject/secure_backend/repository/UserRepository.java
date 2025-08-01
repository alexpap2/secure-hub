package authproject.secure_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import authproject.secure_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
