package com.spy.mvc.mybatis.utils;

public final class EqualsUtil {

	/** 同一个对象. */
	public static final int SAME_OBJECT = 1;

	/** 同一种类. */
	public static final int SAME_CLASS = 2;

	/** 不同对象和不同类. */
	public static final int NOT_SAME_OBJECT_AND_CLASS = 0;

	/** 真值的int型表示. */
	private static final int TRUE = 1;

	/**
	 * 构造器.
	 */
	private EqualsUtil() {
	}

	/**
	 * 比较两个int值是否相等.
	 * 
	 * @param a
	 *            int
	 * @param b
	 *            int
	 * @return boolean true-相等, false-不相等
	 */
	public static boolean equals(int a, int b) {
		return (a == b);
	}

	/**
	 * 比较两个long值是否相等.
	 * 
	 * @param a
	 *            long
	 * @param b
	 *            long
	 * @return boolean true-相等, false-不相等
	 */
	public static boolean equals(long a, long b) {
		return (a == b);
	}

	/**
	 * 比较两个float值是否相等.
	 * 
	 * @param a
	 *            float
	 * @param b
	 *            float
	 * @return boolean true-相等, false-不相等
	 */
	public static boolean equals(float a, float b) {
		return (a == b);
	}

	/**
	 * 比较两个short值是否相等.
	 * 
	 * @param a
	 *            short
	 * @param b
	 *            short
	 * @return boolean true-相等, false-不相等
	 */
	public static boolean equals(short a, short b) {
		return (a == b);
	}

	/**
	 * 比较两个double值是否相等.
	 * 
	 * @param a
	 *            double
	 * @param b
	 *            double
	 * @return boolean true-相等, false-不相等
	 */
	public static boolean equals(double a, double b) {
		return (a == b);
	}

	/**
	 * 比较字符串是否相等(去掉首尾的空格之后再比较),调用对象的equals()方法来比较.
	 * 当对象为null时不会抛出NullPointerException异常.
	 * 
	 * @param a
	 *            String
	 * @param b
	 *            String
	 * @return boolean true-相等, false-不相等
	 */
	public static boolean equalsTrim(String a, String b) {
		if (a == b) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		return (a.trim().equals(b.trim()));
	}

	/**
	 * 比较两个字符串是否相等, 忽略大小写.调用对象的equalsIgnoreCase()方法来比较.
	 * 当对象为null时不会抛出NullPointerException异常.
	 * 
	 * @param a
	 *            String
	 * @param b
	 *            String
	 * @return boolean true-相等, false-不相等
	 */
	public static boolean equalsIgnoreCase(String a, String b) {
		if (a == b) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		return (a.equalsIgnoreCase(b));
	}

	/**
	 * 比较对象数组
	 * 
	 * @param a
	 *            Object[]
	 * @param b
	 *            Object[]
	 * @return boolean
	 */
	public static boolean equals(Object[] a, Object[] b) {
		if (a == b) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (!equals(a[i], b[i]))
				return false;
		}
		return true;
	}

	/**
	 * 比价对象
	 * 
	 * @param a
	 *            Object
	 * @param b
	 *            Object
	 * @return boolean
	 */
	public static boolean equals(Object a, Object b) {
		if (a == b) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		return a.equals(b);
	}

	/**
	 * 预比较, 判断顺序和返回值班如下: <br>
	 * 1. 如果两个对象只要有一个为null返回0 <br>
	 * 2. 如果是同一个对象实例返回1 <br>
	 * 3. 如果属于同一个类但不是同一实例返回2 <br>
	 * 4. 如果不是同一个对象且都不为null返回0 <br>
	 * <p>
	 * 当比较两个对象时候, 如果返回值为0则表示对象已经不相同,不用再比较,如果返回
	 * 1表示两个对象相同,也不用再比较,如果返回2表示两个对象属于一个类,还需进一步比较.
	 * </p>
	 * 
	 * @param a
	 *            Object
	 * @param b
	 *            Object
	 * @return int
	 */
	public static int preEquals(Object a, Object b) {
		if (a == null || b == null) {
			return NOT_SAME_OBJECT_AND_CLASS;
		} else if (a == b) {
			return SAME_OBJECT;
		} else if (a.getClass() == b.getClass()) {
			return SAME_CLASS;
		}

		return NOT_SAME_OBJECT_AND_CLASS;
	}

	/**
	 * int数据类型转换成boolean类型,1-true,其他-false;
	 * 
	 * @param val
	 *            int 要转换的值
	 * 
	 * @return boolean
	 */
	@SuppressWarnings("unused")
	private static boolean int2Bool(int val) {
		return (val == TRUE);
	}

}
