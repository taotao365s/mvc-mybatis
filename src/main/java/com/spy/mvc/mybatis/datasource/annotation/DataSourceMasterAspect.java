package com.spy.mvc.mybatis.datasource.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
@Order(0) //优先于@Transactional
public class DataSourceMasterAspect {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceMasterAspect.class);

	@Pointcut("@annotation(com.spy.mvc.mybatis.datasource.annotation.Master)")
	public void dataSourceMaster() {
	}

	@Before(value = "dataSourceMaster()")
	public void before(JoinPoint jp) {
		logger.debug("set datasource context type master");
		
		DataSourceContextHolder.setContextType(Const.DATASOURCE_MASTER);
	}

	@After(value = "dataSourceMaster()")
	public void after(JoinPoint jp) {
		logger.debug("remove datasource context type master");

		DataSourceContextHolder.removeContextType();
	}

}
