package com.platform.utils;

public class ResultState {
    public final static Integer OK=10000;
    public final static Integer ERROR=20000;
    private String message;
    private boolean flag;
    private Integer code;
    private Object data;

    public Integer getOK() {
        return OK;
    }

    public Integer getERROR() {
        return ERROR;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultState(String message, boolean flag, Integer code, Object data) {
        this.message = message;
        this.flag = flag;
        this.code = code;
        this.data = data;
    }

    public ResultState(String message, boolean flag, Integer code) {
        this.message = message;
        this.flag = flag;
        this.code = code;
    }
}
