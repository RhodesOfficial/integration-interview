package com.calpis.interview.jdk.enums;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/13 17:25
 */
public enum DemoEnums {

    TEST(1, "hello");

    private final int code;
    private final String message;

    DemoEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
