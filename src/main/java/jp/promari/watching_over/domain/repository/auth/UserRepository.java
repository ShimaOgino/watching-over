package jp.promari.watching_over.domain.repository.auth;

import org.springframework.stereotype.Repository;

import jp.promari.watching_over.domain.model.auth.User;

@Repository
public interface UserRepository {
    User findByUsername(String username);
    void save(User user);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
