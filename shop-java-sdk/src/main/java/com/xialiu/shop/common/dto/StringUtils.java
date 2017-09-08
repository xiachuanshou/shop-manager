package com.xialiu.shop.common.dto;

public class StringUtils {
	private static final String REPLACE_LABEL = "{}";

    /**
     * 用objs[]的值去替换字符串s中的{}符号
     */
    public static String replaceParams(String s, Object... objs) {
        if (s == null)
            return s;
        if (objs == null || objs.length == 0)
            return s;
        if (s.indexOf(REPLACE_LABEL) == -1) {
            StringBuilder result = new StringBuilder();
            result.append(s);
            for (Object obj : objs) {
                result.append(" ").append(obj);
            }
            return result.toString();
        }

        String[] stra = new String[objs.length];
        int len = s.length();
        for (int i = 0; i < objs.length; i++) {
            if (objs[i] != null)
                stra[i] = objs[i].toString();
            else {
                stra[i] = "null";
            }
            len += stra[i].length();
        }

        StringBuilder result = new StringBuilder(len);
        int cursor = 0;
        int index = 0;
        for (int start; (start = s.indexOf(REPLACE_LABEL, cursor)) != -1;) {
            result.append(s.substring(cursor, start));
            if (index < stra.length)
                result.append(stra[index]);
            else
                result.append(REPLACE_LABEL);
            cursor = start + 2;
            index++;
        }
        result.append(s.substring(cursor, s.length()));
        if (index < objs.length) {
            for (int i = index; i < objs.length; i++) {
                result.append(" ").append(objs[i]);
            }
        }
        return result.toString();
    }

    /**
     * @see #replaceParams(String, Object...)
     */
    public static String replaceParams(String s, String... objs) {
        return StringUtils.replaceParams(s, (Object[]) objs);
    }
}
