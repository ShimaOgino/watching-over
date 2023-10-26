package jp.promari.watching_over.domain.repository.auth;

import jp.promari.watching_over.domain.model.auth.User;

public interface UserRepository {
    User findByUsername(String username);
    void save(User user);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
