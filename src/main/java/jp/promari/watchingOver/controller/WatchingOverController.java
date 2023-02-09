package jp.promari.watchingOver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    // このクラスを Controller にする
public class WatchingOverController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
