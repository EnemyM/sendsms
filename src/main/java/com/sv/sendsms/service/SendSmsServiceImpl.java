package com.sv.sendsms.service;

import com.sv.sendsms.api.HttpInvoke;
import com.sv.sendsms.model.ResponseEntity;
import com.sv.sendsms.model.SmppRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by anton on
 */
@Service
public class SendSmsServiceImpl implements SendSmsService<ResponseEntity, String> {

    private static final Logger logger = LoggerFactory.getLogger(SendSmsServiceImpl.class);

    @Value("${from}")
    private String from;

    @Value("${api_key}")
    private String apiKey;

    @Value("${api_secret}")
    private String apiSecret;

    @Value("${api_url}")
    private String url;


    @Override
    public ResponseEntity sendSms(String phone, String message) {
        logger.info("Send sms with phone = " + phone + ", message = " + message);
        if (phone == null || message == null) {
            logger.error("Invalid body = " + message + " to phone = " + phone);
            return new ResponseEntity(500, "Body cannot be null");
        }
        try {
            if (from == null || apiKey == null || apiSecret == null && url == null) {
                logger.debug("Bad credentials : from = " + from + ", api_key = " + apiKey + ", api_secret = " + apiSecret);
            }

            ResponseEntity response = new HttpInvoke<SmppRequest>().httpPost(new SmppRequest(from, phone, message, apiKey, apiSecret), url);

            if (response.getContent().contains("error-text")) {
                logger.info("Error sent data = " + response.getContent());
                return new ResponseEntity(500, "Internal server error");
            } else {
                logger.info("Successfully sent");
                return new ResponseEntity(200, "Successful");
            }
        } catch (IOException e) {
            logger.error("Error sending post ", e);
            return new ResponseEntity(500, "Bad entered data");
        }
    }
}
