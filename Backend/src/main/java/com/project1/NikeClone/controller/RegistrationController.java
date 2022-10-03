package com.project1.NikeClone.controller;

import com.project1.NikeClone.model.RegistrationRequest;
import com.project1.NikeClone.service.implService.ImplRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/registration")
@CrossOrigin
@AllArgsConstructor
public class RegistrationController {

    private final ImplRegistrationService implRegistrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return implRegistrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return implRegistrationService.confirmToken(token);
    }
}
