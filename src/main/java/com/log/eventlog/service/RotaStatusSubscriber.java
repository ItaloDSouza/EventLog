package com.log.eventlog.service;

import com.log.eventlog.model.Log;
import com.log.eventlog.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RotaStatusSubscriber {
    @Autowired
    LogRepository logRepository;
    @KafkaListener(topics = "rota-status-topic", groupId = "log-group")
    public void receiveStatusUpdate(Log log) {
        try {
            logRepository.save(log);
        }catch (Exception e){
            System.out.println("Log failed: " + log);
        }
        System.out.println("Log received: " + log);
    }
}
