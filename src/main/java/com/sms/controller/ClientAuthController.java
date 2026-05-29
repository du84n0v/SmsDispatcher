package com.sms.controller;

import com.sms.dto.ClientLoginDTO;
import com.sms.dto.ClientRegisterDTO;
import com.sms.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client/auth")
public class ClientAuthController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/registration")
    public ResponseEntity<String> register(@Valid @RequestBody ClientRegisterDTO dto){
        return ResponseEntity.ok(clientService.save(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody ClientLoginDTO dto){
        return ResponseEntity.ok(clientService.login(dto));
    }
}
