package com.spy.mvc.mybatis.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author spy
 *
 * @datetime 2015年10月26日 下午2:00:48
 */
public class CustomProtocolHandler extends IoHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(CustomProtocolHandler.class);

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		super.messageReceived(session, message);

		logger.info("received msg is {}", message);

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}

}
