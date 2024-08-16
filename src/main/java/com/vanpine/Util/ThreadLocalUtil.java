package com.vanpine.Util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ThreadLocalUtil {

    private static final ThreadLocal threadLocal = new ThreadLocal();

    /*
     *  设置set方法
     * */
    public static void set(Map<String, Object> value) {
        threadLocal.set(value);
    }

    public static Map<String, Object> get() {
        return (Map<String, Object>) threadLocal.get();
    }

    public static void delete() {
        threadLocal.remove();
    }

}
