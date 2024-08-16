package com.vanpine.enums;

import lombok.Getter;

@Getter
public enum StatusEnums {
    SUCCESS(200, "Success"), NOT_FOUND(404, "Not Found"), INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String desc;

    StatusEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
