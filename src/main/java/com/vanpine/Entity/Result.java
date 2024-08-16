package com.vanpine.Entity;

import com.vanpine.enums.StatusEnums;
import lombok.Data;

@Data
public class Result<V> {
    private int code;
    private String msg;
    private V data;

    public Result() {
    }

    public Result(StatusEnums statusEnums, String msg, V data) {
        this.code = statusEnums.getCode();
        this.msg = msg;
        this.data = data;
    }

    /*
     *  处理正确信息，无具体data
     * */
    public static Result<String> success() {
        return new Result<>(StatusEnums.SUCCESS, "操作成功", null);
    }

    /*
     *  处理正确信息，响应具体的data
     * */
    public static <V> Result<V> success(V data) {
        return new Result<>(StatusEnums.SUCCESS, "操作成功", data);
    }

    /*
     *  处理错误信息，返回错误消息
     * */
    public static <V> Result<V> error(String msg) {
        return new Result<>(StatusEnums.INTERNAL_SERVER_ERROR, msg, null);
    }

}
