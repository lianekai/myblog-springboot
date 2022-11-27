package com.lianekai.myblog.common;

import lombok.Getter;

/**
 * @author lianekai
 * @date 2022/5/26 23:53
 * @version: 1.0
 * @description TODO
 */
@Getter
public enum ResultEnum {

    DATA_IS_ERROR("500", "数据错误！"),
    DATA_NOT_FOUND("404", "物料校验重复");
    // 错误码
    private String code;
    //错误信息
    private String message;

    private ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
