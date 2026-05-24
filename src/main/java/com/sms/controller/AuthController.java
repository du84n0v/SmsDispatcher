package com.sms.controller;

import com.sms.dto.LoginDTO;
import com.sms.dto.ProfileDTO;
import com.sms.entity.Profile;
import com.sms.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class    AuthController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/register")
    public ResponseEntity<Profile> create(@RequestBody ProfileDTO dto){
        return ResponseEntity.ok(profileService.create(dto));
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto){
        return profileService.login(dto);
    }

}
