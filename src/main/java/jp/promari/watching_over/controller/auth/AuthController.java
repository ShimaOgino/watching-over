package jp.promari.watching_over.controller.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jp.promari.watching_over.application.request.LoginRequest;
import jp.promari.watching_over.application.service.auth.UserService;
import jp.promari.watching_over.domain.model.auth.UserModel;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/auth")
    public String authenticate(@RequestBody LoginRequest loginRequest) {
        Optional<UserModel> user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user.isPresent()) {
            return "forward:/main";
        } else {
            return "forward:/login";
        }
    }
}
