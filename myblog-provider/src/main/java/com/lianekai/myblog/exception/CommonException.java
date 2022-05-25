package com.lianekai.myblog.exception;

/**
 * @author lianekai
 * @date 2022/5/25 23:29
 * @version: 1.0
 * @description TODO
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -82937182623472423L;

    private String code;

    private String msg;

    public CommonException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
