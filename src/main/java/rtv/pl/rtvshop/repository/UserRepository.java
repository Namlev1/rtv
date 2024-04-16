package rtv.pl.rtvshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtv.pl.rtvshop.security.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
