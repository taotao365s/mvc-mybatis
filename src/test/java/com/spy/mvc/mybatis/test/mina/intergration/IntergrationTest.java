package com.spy.mvc.mybatis.test.mina.intergration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spy.mvc.mybatis.test.service.BaseSpringTest;

/**
 * @author spy
 *
 * @datetime 2015年10月26日 下午2:08:26
 */
public class IntergrationTest extends BaseSpringTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("spring/spring-mina.xml");
	}
}
