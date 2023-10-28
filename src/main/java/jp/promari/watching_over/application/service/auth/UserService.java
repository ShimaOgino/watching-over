package jp.promari.watching_over.application.service.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.promari.watching_over.domain.entity.auth.User;
import jp.promari.watching_over.domain.model.auth.UserModel;
import jp.promari.watching_over.domain.repository.auth.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserModel> authenticate(String username, String password) {
        return Optional.empty();
    }

    private UserModel convertToModel(User entityUser) {
        UserModel modelUser = new UserModel();
        modelUser.setId(entityUser.getId());
        modelUser.setUsername(entityUser.getUsername());
        modelUser.setEmail(entityUser.getEmail());
        return modelUser;
    }
}
