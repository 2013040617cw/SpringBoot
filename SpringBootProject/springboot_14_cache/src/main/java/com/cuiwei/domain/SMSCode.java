package com.cuiwei.domain;

public class SMSCode {
    private String tele;
    private String code;

    public SMSCode() {
    }

    public SMSCode(String tele, String code) {
        this.tele = tele;
        this.code = code;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SMSCode{" +
                "tele='" + tele + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
