package com.management.tools;

public enum ResultCode {
    SUCCESS(200,"操作成功"),
    FAIL(400,"操作失败");
    private Integer code;
    private String msg;

    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
