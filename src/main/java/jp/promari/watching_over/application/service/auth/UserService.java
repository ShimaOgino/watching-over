package jp.promari.watching_over.application.service.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.promari.watching_over.config.PromariProperties;
import jp.promari.watching_over.domain.model.auth.User;
import jp.promari.watching_over.domain.repository.auth.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PromariProperties properties;

    public Optional<User> authenticate(String username, String password) {
        if (properties.getUsername().equals(username) && properties.getPassword().equals(password)) {
            User user = userRepository.findByUsername(username);
            return Optional.ofNullable(user);
        }
        return Optional.empty();
    }

    public void register(User user) {
        userRepository.save(user);
    }
}
