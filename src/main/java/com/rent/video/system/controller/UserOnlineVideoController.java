package com.rent.video.system.controller;

import com.rent.video.system.dto.User;
import com.rent.video.system.exchnage.GetRegistrationRequest;
import com.rent.video.system.exchnage.GetRegistrationResponse;
import com.rent.video.system.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserOnlineVideoController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/ping")
    public String ping()
    {
        return "pong";
    }

    @PostMapping("/usr/registration")
    public ResponseEntity<GetRegistrationResponse> UserRegistration(@RequestBody GetRegistrationRequest getRegistrationRequest)
    {
        GetRegistrationResponse getRegistrationResponse = userService.registerUserintoVideoAppln(getRegistrationRequest);
        return ResponseEntity.ok().body(getRegistrationResponse);
    }

}
