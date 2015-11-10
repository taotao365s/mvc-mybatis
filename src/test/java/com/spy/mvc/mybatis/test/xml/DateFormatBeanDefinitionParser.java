package com.spy.mvc.mybatis.test.xml;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author spy
 *
 * @datetime 2015年11月6日 下午2:20:17
 */
public class DateFormatBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return SimpleDateFormat.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		super.doParse(element, builder);
		// builder is bean

		String pattern = element.getAttribute("pattern");
		// String id = element.getAttribute("id");
		// if (StringUtils.hasText(id)) {
		// builder.addPropertyValue("id", id);
		// }
		if (StringUtils.hasText(pattern)) {
			builder.addPropertyValue("pattern", pattern);
		}
	}

}
