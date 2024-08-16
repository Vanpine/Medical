package com.vanpine.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum UserRegisterEnums {
    UN_MEDICAL(0, "未就诊"),
    MEDICAL(1, "已就诊"),
    PROCESS_MEDICAL(2, "就诊中");

    @EnumValue
    private final int status;
    private final String desc;

    UserRegisterEnums(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
