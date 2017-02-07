package com.napster.common.response;

import com.napster.enums.ResultCodeEnum;

/**
 * 后台标准返回体
 */
public class ResponseResult<T> {

    private ResultCodeEnum code;
    private String message;
    private T data;

    public ResponseResult() {
        this.code = ResultCodeEnum.SYS_ERROR;
    }

    public ResponseResult(ResultCodeEnum code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(ResultCodeEnum code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(T data) {
        this.code = ResultCodeEnum.SUCCESS;
        this.data = data;
    }

    public ResultCodeEnum getCode() {
        return code;
    }

    public void setCode(ResultCodeEnum code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
