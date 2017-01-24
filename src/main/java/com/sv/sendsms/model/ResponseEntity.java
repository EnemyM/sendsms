package com.sv.sendsms.model;

/**
 * Created by anton on 23.01.17.
 */
public class ResponseEntity {

    private Integer code;
    private String content;

    public ResponseEntity() {
    }

    public ResponseEntity(Integer code, String content) {
        this.code = code;
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseEntity{");
        sb.append("code=").append(code);
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
