package com.spy.mvc.mybatis.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author spy
 *
 * @datetime 2015年11月13日 上午11:14:20
 */
public class SpringApplicationListener implements ApplicationListener<ApplicationEvent> {

	private static final Logger logger = LoggerFactory.getLogger(SpringApplicationListener.class);

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		logger.debug(event.toString());
		if (event instanceof ContextRefreshedEvent) {
			// 在这种场景下，会触发两次，一个Root ctx，一个是Web Root ctx
			// event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")
			logger.debug("context refresh event {}", event.getSource());
		}
	}

}
