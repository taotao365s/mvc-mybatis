package com.spy.mvc.mybatis.test.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author spy
 *
 * @datetime 2015年10月20日 下午1:47:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring/spring.xml",
		"classpath:spring/spring-mvc.xml" })
public class BaseSpringTest {
	@Autowired
	protected ApplicationContext ctx;
}
