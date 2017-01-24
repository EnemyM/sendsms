package com.sv.sendsms.service;

/**
 * Created by anton
 */
public interface SendSmsService<T, V> {

    T sendSms(V phone, V message);
}
