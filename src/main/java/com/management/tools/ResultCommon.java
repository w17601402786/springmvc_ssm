package com.management.tools;

import io.swagger.annotations.ApiModelProperty;

/**
 * 返回结果类
 */
public class ResultCommon<T> {
    @ApiModelProperty(value = "返回码",name = "code",example = "200")
    private Integer code;

    @ApiModelProperty(value = "返回信息",name = "msg",example = "登录成功")
    private String msg;

    @ApiModelProperty(value = "返回数据",name = "data")
    private T data;

    public ResultCommon() {
    }

    public ResultCommon(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultCommon(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultCommon<T> success(T data){
        return new ResultCommon<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),data);
    }

    public static <T> ResultCommon<T> fail(T data){
        return new ResultCommon<T>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg(),data);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
