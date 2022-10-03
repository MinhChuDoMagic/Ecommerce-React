package com.project1.NikeClone.controller;

import com.project1.NikeClone.entity.User;
import com.project1.NikeClone.model.LoginForm;
import com.project1.NikeClone.service.implService.ImplLoginService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "login")
@AllArgsConstructor
@CrossOrigin
public class LoginController {
    private final ImplLoginService implLoginService;

    @PostMapping
    public boolean login(@RequestBody LoginForm loginForm){
        return implLoginService.checkAccount(loginForm.getUsername(), loginForm.getPassword());
    }

    @GetMapping(path = "find/{username}")
    public User findUsername(@PathVariable  String username){
        return implLoginService.userInfo(username);
    }
}
