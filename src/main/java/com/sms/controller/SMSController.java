package com.sms.controller;

import com.sms.dto.SmsDTO;
import com.sms.service.SMSHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    private SMSHistoryService historyService;

    @PostMapping("/send")
    private String send(@RequestBody SmsDTO dto){
        historyService.save(dto);
        System.out.println("---------------------------------------");
        System.out.println("kimga: " + dto.getPhone());
        System.out.println(dto.getMessage());
        System.out.println("---------------------------------------");
        return "Successfully send";
    }

}
