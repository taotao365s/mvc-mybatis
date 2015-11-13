package com.spy.mvc.mybatis.test.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author spy
 *
 * @datetime 2015年11月13日 下午2:45:53
 */
public class Parent {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public void cc() {
		logger.debug("this is parent cc");
	}
}
