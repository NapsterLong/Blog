package com.napster.enums;

/**
 * 后台返回结果枚举类
 */
public enum ResultCodeEnum {
    SUCCESS(200),
    ARGUMENT_ERROR(666),
    SYS_ERROR(999);

    private int code;

    ResultCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
