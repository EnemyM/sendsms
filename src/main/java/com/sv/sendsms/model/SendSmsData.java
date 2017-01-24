package com.sv.sendsms.model;

/**
 * Created by anton
 */
public class SendSmsData {

    private String phone;
    private String message;

    public SendSmsData() {
    }

    public SendSmsData(String phone, String message) {
        this.phone = phone;
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SendSmsData{");
        sb.append("phone='").append(phone).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
