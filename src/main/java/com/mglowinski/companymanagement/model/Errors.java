package com.mglowinski.companymanagement.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Errors {

    ENUM_INVALID_TYPE(400, "Invalid enum value");

    private final int code;
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
