package com.lianekai.myblog.cache;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.apache.logging.log4j.util.Strings;

/**
 * 用户本地信息缓存
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 01:30
 */
public class UserLocalCache {

    /**
     * ThreadLocal 用于存储用户信息的本地缓存
     */
    private static final ThreadLocal<String> THREAD_LOCAL = new TransmittableThreadLocal<>();

    public static String get() {
        String operator = THREAD_LOCAL.get();
        if (operator != null) {
            return operator;
        }
        return Strings.EMPTY;
    }

    public static void set(String operator) {
        THREAD_LOCAL.set(operator);
    }

    public static void unload() {
        THREAD_LOCAL.remove();
    }

}
