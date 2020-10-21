package com.demo.model;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID=1L;

    private int code;
    private String message;
    private T date;

    public ResultBean() {
    }

    public ResultBean(int code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }
    public int getCode() {
        return code;
    }

    public ResultBean(EnumResult enumResult,T date){
        this.code=enumResult.getCode();
        this.message=enumResult.getMessage();
        this.date=date;
    }
    public ResultBean(EnumResult enumResult){
        this.code=enumResult.getCode();
        this.message=enumResult.getMessage();
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

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
