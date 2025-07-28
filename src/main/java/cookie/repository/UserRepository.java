package cookie.repository;

import cookie.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String mail);
	Optional<User> findByUsername(String username);
}
