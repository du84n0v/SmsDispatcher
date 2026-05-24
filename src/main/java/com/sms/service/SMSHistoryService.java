package com.sms.service;

import com.sms.dto.SmsDTO;
import com.sms.entity.SMSHistory;
import com.sms.repository.SMSHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SMSHistoryService {

    @Autowired
    private SMSHistoryRepository historyRepository;
    @Autowired
    private ProfileService profileService;

    public void save(SmsDTO dto) {
        profileService.existToken(dto.getUserToken());
        SMSHistory history = new SMSHistory();
        history.setPhone(dto.getPhone());
        history.setUserToken(dto.getUserToken());
        history.setMessage(dto.getMessage());
        history.setCreatedDate(LocalDateTime.now());

        historyRepository.save(history);
    }
}
