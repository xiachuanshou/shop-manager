package com.xialiu.shop.exception;

import com.xialiu.shop.common.dto.StringUtils;

public class BasicRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 4668460935887569748L;

    public BasicRuntimeException() {
        super();
    }

    /**
     * @param message 支持占位符{}，例如 "error, userID={}, opt={}."
     * @param args 对应message占位符{}的值
     */
    public BasicRuntimeException(String message, String... args) {
        super(StringUtils.replaceParams(message, args));
    }

    public BasicRuntimeException(Throwable e) {
        super(e);
    }

    /**
     * @param e 原始异常
     * @param message 支持占位符{}，例如 "error, userID={}, opt={}."
     * @param args 对应message占位符{}的值
     */
    public BasicRuntimeException(Throwable e, String message, String... args) {
        super(StringUtils.replaceParams(message, args), e);
    }
}
