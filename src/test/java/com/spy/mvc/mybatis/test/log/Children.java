package com.spy.mvc.mybatis.test.log;

import org.junit.Test;

/**
 * @author spy
 *
 * @datetime 2015年11月13日 下午2:51:00
 */
public class Children extends Parent {

	public void cc() {
		super.cc();
		logger.debug("this is children cc");
	}

	@Test
	public void test() {
		logger.debug("this is children, let us invoke cc method.");
		cc();
	}
}
