package jp.promari.watching_over.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.promari.watching_over.application.service.auth.UserService;
import jp.promari.watching_over.domain.model.auth.User;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            return "redirect:/home";
        } else {
            return "Home";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }
}
