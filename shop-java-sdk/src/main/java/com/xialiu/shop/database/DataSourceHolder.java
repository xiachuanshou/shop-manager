package com.xialiu.shop.database;

/**
 * 
 * @author XiaChuanshou
 * @since 2017年9月8日
 */
public class DataSourceHolder {
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSouce() {
        return holder.get();
    }
}
