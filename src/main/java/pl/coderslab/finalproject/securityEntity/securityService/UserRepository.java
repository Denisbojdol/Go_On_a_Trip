package pl.coderslab.finalproject.securityEntity.securityService;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.securityEntity.Role;
import pl.coderslab.finalproject.securityEntity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
