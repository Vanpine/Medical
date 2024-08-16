package com.vanpine.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum UserPaymentEnums {

    UN_COMPLETE_PAYMENT(0, "未支付"),
    COMPLETE_PAYMENT(1, "已支付");

    @EnumValue
    private final int status;
    private final String desc;

    UserPaymentEnums(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
