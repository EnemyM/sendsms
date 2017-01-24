package com.sv.sendsms.rest;

import com.sv.sendsms.model.SendSmsData;
import com.sv.sendsms.service.SendSmsService;
import com.sv.sendsms.service.SendSmsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

/**
 * Created by anton
 */

@RestController
@RequestMapping(value = "/send")
public class RestSender {

    private static final Logger logger = LoggerFactory.getLogger(SendSmsServiceImpl.class);

    @Autowired
    SendSmsService sendSmsService;

    @PostMapping(value = {"/sms"})
    public Callable<ResponseEntity<?>> sendSms(@RequestBody SendSmsData smsUserRequest) {
        return () -> {
            logger.info("Obtained data to send sms = " + smsUserRequest);
            try {
                com.sv.sendsms.model.ResponseEntity responseEntity = (com.sv.sendsms.model.ResponseEntity) sendSmsService.sendSms(smsUserRequest.getPhone(), smsUserRequest.getMessage());
                return new ResponseEntity<Object>(responseEntity.getContent(), HttpStatus.valueOf(responseEntity.getCode()));
            } catch (Exception e) {
                logger.error("Error sending sms due to ", e);
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }
}
