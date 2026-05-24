package com.sms.repository;

import com.sms.entity.SMSHistory;
import org.springframework.data.repository.CrudRepository;

public interface SMSHistoryRepository extends CrudRepository<SMSHistory, Integer> {
}
