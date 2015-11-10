package com.spy.mvc.mybatis.test.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author spy
 *
 * @datetime 2015年11月6日 下午2:27:36
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("dateformat", new DateFormatBeanDefinitionParser());
	}

}
