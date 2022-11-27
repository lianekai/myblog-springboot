package com.lianekai.myblog.exception;

import com.lianekai.myblog.common.ResultEnum;

/**
 * @author lianekai
 * @date 2022/5/26 23:51
 * @version: 1.0
 * @description 业务异常
 */
public class BizException extends RuntimeException{
    private String code;

    private String message;

    private transient  Object data;

    public BizException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }


    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(String code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public BizException(String message) {
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
