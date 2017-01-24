package com.sv.sendsms.model;

/**
 * Created by anton
 */
public class SmppRequest {

    private String from;
    private String to;
    private String text;
    private String api_key;
    private String api_secret;

    public SmppRequest() {
    }

    public SmppRequest(String from, String to, String text, String api_key, String api_secret) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.api_key = api_key;
        this.api_secret = api_secret;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getApi_secret() {
        return api_secret;
    }

    public void setApi_secret(String api_secret) {
        this.api_secret = api_secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmppRequest that = (SmppRequest) o;

        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (api_key != null ? !api_key.equals(that.api_key) : that.api_key != null) return false;
        return api_secret != null ? api_secret.equals(that.api_secret) : that.api_secret == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (api_key != null ? api_key.hashCode() : 0);
        result = 31 * result + (api_secret != null ? api_secret.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SmppRequest{");
        sb.append("from='").append(from).append('\'');
        sb.append(", to='").append(to).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", api_key='").append(api_key).append('\'');
        sb.append(", api_secret='").append(api_secret).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
