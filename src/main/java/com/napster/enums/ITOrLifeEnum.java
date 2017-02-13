package com.napster.enums;

import java.util.stream.Stream;

/**
 * 技术/随笔 枚举类
 */
public enum ITOrLifeEnum {

    IT("01"),
    LIFE("02");

    private String value;

    ITOrLifeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ITOrLifeEnum getByValue(String value) {
        return Stream.of(ITOrLifeEnum.values()).filter((ITOrLife) -> ITOrLife.value.equals(value)).findFirst().orElse(null);
    }

}
