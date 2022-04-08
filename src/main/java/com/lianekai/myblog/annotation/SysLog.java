package com.lianekai.myblog.annotation;

import com.lianekai.myblog.common.OperationTypeEnum;

import java.lang.annotation.*;

/**
 * 志记录注解
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 00:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**对应的业务类型*/
    String bizType();

    /**操作类型记录枚举*/
    OperationTypeEnum type();
}
