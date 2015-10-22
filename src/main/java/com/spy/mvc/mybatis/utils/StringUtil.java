package com.spy.mvc.mybatis.utils;

import java.util.List;

/**
 * StringUtil
 * 
 * @author spy
 * @since 2015年1月22日上午10:33:08
 */
public final class StringUtil {

	public StringUtil() {
	}

	/**
	 * 将对象转换成String
	 * 
	 * @param val
	 *            Object
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	public static String toString(Object val) {
		if (val == null) {
			return "";
		}
		if (val.getClass().isArray()) {
			return arrayToString((Object[]) val);
		}

		if (val instanceof java.util.List) {
			return listToString((List) val, null);
		}
		return val.toString();
	}

	/**
	 * 将对象数组转换成String
	 * 
	 * @param objs
	 *            Object[]
	 * @param itemName
	 *            String
	 * @return String
	 */
	public static String arrayToString(Object[] objs) {
		if (objs == null) {
			return "";
		} else {
			int size = objs.length;
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < size; i++) {
				buff.append(objs[i].toString()).append("\n");
			}
			return buff.toString();
		}
	}

	/**
	 * 将List列表转换成字符串,取得列表里的每个对象调用其toString()方法
	 * 
	 * @param list
	 *            List
	 * @param itemName
	 *            String 列表条目名称
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	public static String listToString(List list, String itemName) {
		if (list == null) {
			return "";
		} else {
			int size = list.size();
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < size; i++) {
				buff.append(list.get(i).toString()).append("\n");
			}
			return buff.toString();
		}
	}

}
