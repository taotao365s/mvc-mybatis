package com.spy.mvc.mybatis.test.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author spy
 *
 * @datetime 2015年11月6日 下午2:49:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-my.xml" })
public class MyXMLTest {

	@Autowired
	ApplicationContext ctx;

	@Test
	public void test() {
		SimpleDateFormat sdf = (SimpleDateFormat) ctx.getBean("myDateFormatBean");
		System.out.println(sdf.getPattern());
	}
}
