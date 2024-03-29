package com.lianekai.myblog.exception;

/**
 * @author lianekai
 * @date 2022/5/25 23:29
 * @version: 1.0
 * @description TODO
 */
public class CommonException extends RuntimeException {

    private String code;

    private String message;

    private transient  Object data;


    public CommonException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(String code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public CommonException(String message) {
        super(message);
        this.code = "500";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }
}
