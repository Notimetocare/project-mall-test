package com.darren.project.util;

public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    USERNAME_ERROR(501, "usernameError"),
    PASSWORD_ERROR(503, "passwordError"),
    NOT_login(504, "NOTlogin"),
    USERNAME_USED(505, "userrepeat");

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}