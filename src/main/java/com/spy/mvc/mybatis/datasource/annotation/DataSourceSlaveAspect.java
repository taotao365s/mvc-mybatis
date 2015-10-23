package com.spy.mvc.mybatis.datasource.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spy.mvc.mybatis.common.Const;
import com.spy.mvc.mybatis.datasource.DataSourceContextHolder;

/**
 * @author spy
 *
 * @datetime 2015年10月23日 下午2:26:38
 */
@Aspect
@Component
@Order(0)
// 优先于@Transactional
public class DataSourceSlaveAspect {
	private final static Logger logger = LoggerFactory.getLogger(DataSourceSlaveAspect.class);

	@Pointcut("@annotation(com.spy.mvc.mybatis.datasource.annotation.Slave)")
	public void dataSourceSlave() {
	}

	@Around("dataSourceSlave()")
	public Object arround(ProceedingJoinPoint jp) throws Throwable {
		logger.debug("around");
		Object ret = jp.proceed();
		logger.debug("will return ret");
		return ret;
	}

	@Before("dataSourceSlave()")
	public void before(JoinPoint jp) {
		logger.debug("set datasource context type slave");

		DataSourceContextHolder.setContextType(Const.DATASOURCE_SLAVE);
	}

	@After("dataSourceSlave()")
	public void after(JoinPoint jp) {
		logger.debug("remove datasource context type slave");

		DataSourceContextHolder.removeContextType();
	}

}
