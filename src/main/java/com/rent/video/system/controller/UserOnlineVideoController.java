package com.rent.video.system.controller;


import com.rent.video.system.exchnage.*;
import com.rent.video.system.exchnage.GetUserLoginResponse;
import com.rent.video.system.services.UserService;
import com.rent.video.system.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserOnlineVideoController {
    @Autowired
    UserService userService;

    @GetMapping("/ping")
    public String ping()
    {
        return "pong";
    }

    @PostMapping("/user/registration")
    public ResponseEntity<GetUserRegistrationResponse> UserRegistration(@RequestBody GetUserRegistrationRequest getUserRegistrationRequest)
    {
        GetUserRegistrationResponse getRegistrationResponse = userService.registerUserintoVideoAppln(getUserRegistrationRequest);
        return ResponseEntity.ok().body(getRegistrationResponse);
    }

    @PostMapping("/user/login")
    public ResponseEntity<GetUserLoginResponse> UserLogin(@RequestBody GetUserLoginRequest getUserLoginRequest)
    {
         com.rent.video.system.exchnage.GetUserLoginResponse loginResponse = userService.loginUserToApplication(getUserLoginRequest);
        return ResponseEntity.ok().body(loginResponse);

    }

}
