package com.lianekai.myblog.exception;

import com.lianekai.myblog.common.ResultEnum;

/**
 * @author lianekai
 * @date 2022/5/26 23:52
 * @version: 1.0
 * @description 异常构造器
 */
public class ExceptionConstructor {

    public static RuntimeException runtimeBusExpConstructor(String code, String msg) {
        throw new BizException(code, msg);
    }
    public static RuntimeException runtimeBusExpConstructor(ResultEnum resultEnum) {
        throw new BizException(resultEnum.getCode(), resultEnum.getMessage());
    }
    private ExceptionConstructor(){}
}
