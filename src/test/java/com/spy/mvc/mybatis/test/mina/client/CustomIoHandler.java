package com.spy.mvc.mybatis.test.mina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author spy
 *
 * @datetime 2015年10月26日 上午11:23:17
 */
public class CustomIoHandler extends IoHandlerAdapter {

	public static final Logger logger = LoggerFactory.getLogger(CustomIoHandler.class);

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub

		for (int i = 0; i < 20; i++) {
			session.write("hello world " + i);
		}
		session.write("bye");
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		logger.error(cause.getMessage());
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		logger.info("received msg is {}", message);
		if (message.toString().equalsIgnoreCase("bye")) {
			session.close(true);
		}
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		logger.info("sent msg is {}", message);
	}


}
