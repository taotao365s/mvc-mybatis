package com.spy.mvc.mybatis.test.mina.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author spy
 *
 * @datetime 2015年10月26日 上午11:17:10
 */
public class CustomIoHandler extends IoHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(CustomIoHandler.class);

	@Override
	public void sessionCreated(IoSession session) throws Exception {
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		logger.error(cause.getMessage());
		session.close(true);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		logger.info("receive msg is {}", message);
		if ("bye".equals(message)) {
			session.write("bye");
			return;
		}
		session.write("this is server message, " + message);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		logger.info("send msg is {}", message);
	}

}
