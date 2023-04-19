package backend.com.backend.user.repository;

import backend.com.backend.user.entity.Member;
import backend.com.backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    Member findByDisplayName(String displayName);
}
