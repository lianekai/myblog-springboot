package com.lianekai.myblog.common;

import lombok.Getter;

/**
 * 操作枚举
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 00:26
 */
@Getter
public enum OperationTypeEnum {

    CREATE("created", " 进行了创建 "),
    EDIT("edited", " 进行了编辑 "),
    DELETE("deleted", " 删除了 "),
    LOGIN("login","登录了 "),
    LOGOUT("logout","退出登录了 ")
    ;

    String operationEn;

    String operationZh;

    OperationTypeEnum(String operationEn, String operationZh) {
        this.operationEn = operationEn;
        this.operationZh = operationZh;
    }
}
