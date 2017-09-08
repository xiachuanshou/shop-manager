package com.xialiu.shop.exception;

import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;

import com.xialiu.shop.common.dto.StringUtils;

public class XiaLiuException extends BasicRuntimeException{
	private static final long serialVersionUID = -856748734106714570L;
	private final CodeMeta errorCode;
	private final Object[] params;
	
	/** 
	 * 构造函数
	 * @param errorCode 错误代码
	 **/
	public XiaLiuException(CodeMeta errorCode){
		super();
		this.errorCode = errorCode;
		this.params = null;
	}
	
	/** 
	 * 构造函数 
	 * @param errorCode 错误代码
	 * @param args 占位符参数--[ 变长参数，用于替换message字符串里面的占位符"{}" ]
	 */
	public XiaLiuException(CodeMeta errorCode, Object... args){
		super();
		this.errorCode = errorCode;
		this.params = args;
	}

	@Override
	public String getMessage(){
		return getMessage(Locale.CHINA);
	}
	
	public String getMessage(Locale localLocale){
		return  StringUtils.replaceParams( errorCode.getMsg(localLocale.toString()) , params);
	}
	
	public String getMessage(String localLocale){
		return  StringUtils.replaceParams( errorCode.getMsg(LocaleUtils.toLocale(localLocale).toString()), params);
	}
	
	/**
	 * 获取组装好的完整信息：错误类+错误代码+错误信息，用于调试或View层展示
	 * @return
	 */
	@Override
	public String toString(){
		return getMessage(Locale.US);
	}
	
	public CodeMeta getErrorCode() {
		return errorCode;
	}
	
	public Object[] getParams() {
        if (params != null && params.length > 0) {
            return params.clone();
        }
        return params;
    }
}
