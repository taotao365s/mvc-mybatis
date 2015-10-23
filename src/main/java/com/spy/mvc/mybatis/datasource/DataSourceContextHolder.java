package com.spy.mvc.mybatis.datasource;

/**
 * 上下文变量
 * 
 * @author spy
 *
 * @datetime 2015年10月23日 上午11:24:38
 */
public class DataSourceContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setContextType(String type) {
		contextHolder.set(type);
	}

	public static String getContextType() {
		return contextHolder.get();
	}

	public static void removeContextType() {
		contextHolder.remove();
	}

}
