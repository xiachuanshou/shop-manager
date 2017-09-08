package com.xialiu.shop.exception;

import org.apache.commons.lang.StringUtils;

public class ExceptionUtils {
	private static final String MSG_SPLIT = " |- ";
	
	/**
     * 获取精简过的错误信息，(错误类型+错误描述)，默认截取440个字符（前320个+后120个）
     * 
     * @param prompt 附加提示，可为 null
     */
    public static String getExceptionProfile(Throwable e) {
        return getExceptionProfile(e, null, 440); // 默认440个字符
    }
	
	/**
     * 获取精简过的错误信息，(错误类型+错误描述)，截取 errorLen 个字符。
     * 
     * @param prompt
     *            附加提示，可为 null
     * @param errorLen
     *            截取错误字符串的最大长度，比如 500
     */
    public static String getExceptionProfile(Throwable e, String prompt, int errorLen) {
        // 如果error过长,则精简到errorLen个字符
        String error = errorMsgCut(e.toString(), errorLen);
        // getErrorDescription
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(prompt)) {
            sb.append(prompt);
            sb.append(MSG_SPLIT);
        }
        sb.append(error);

        return sb.toString();
    }
    
    /**
     * 裁剪错误信息，最多只取 maxLen 个字符(maxLen>=200)，规则如下： <br>
     * 【只保留前面8/11的字符+后面3/11的字符】 <br>
     * 例如一个数据库的errorMessage长度可达1000个字符，用此方法裁剪后, <br>
     * 假设maxLen=550，那就只保留前400个字符+后150个字符。
     * 
     * @param maxLen
     *            截取错误字符串的最大长度，比如500
     * @return 精简后的错误信息字符串
     * @author XiaChuanshou 2017-9-8
     */
    public static String errorMsgCut(String errorMsg, int maxLen) {
        if (errorMsg == null) {
            return null;
        }
        int strLen = errorMsg.length();
        if (strLen < 200 || strLen < maxLen) { // 小于200的字符，不做处理
            return errorMsg;
        }
        int front = maxLen * 8 / 11;
        errorMsg = errorMsg.substring(0, front) + "......" + errorMsg.substring(strLen - maxLen + front, strLen);
        return errorMsg;
    }
}
