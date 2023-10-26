package jp.promari.watching_over.application.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.promari.watching_over.config.auth.AuthProperties;
import jp.promari.watching_over.domain.model.auth.User;
import jp.promari.watching_over.domain.repository.auth.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthProperties authProperties;

    public User authenticate(String username, String password) {
        if (authProperties.getUsername().equals(username) && authProperties.getPassword().equals(password)) {
            // 認証が成功した場合の処理（例：Userオブジェクトを返すなど）
            return new User(); // この部分は具体的な認証成功時の処理に合わせて変更する。
        }
        return null;
    }

    public void register(User user) {
        userRepository.save(user);
    }
}
