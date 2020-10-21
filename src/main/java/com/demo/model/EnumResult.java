package com.demo.model;

public enum EnumResult {
    SUCCESS(200,"请求成功"),
    FAIL(400,"请求失败")
    ;
    private int code;
    private String message;

    EnumResult() {
    }

    EnumResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}