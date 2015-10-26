package com.spy.mvc.mybatis.test.mina.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spy.mvc.mybatis.test.mina.Const;

/**
 * @author spy
 *
 * @datetime 2015年10月26日 上午11:09:34
 */
public class MinaClient {
	private static final Logger logger = LoggerFactory.getLogger(MinaClient.class);

	public static void main(String[] args) {
		IoConnector connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(10 * 1000);

		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		connector.setHandler(new CustomIoHandler());

		IoSession session = null;

		ConnectFuture future = connector.connect(new InetSocketAddress(Const.PORT));
		future.awaitUninterruptibly();
		session = future.getSession();

		session.getCloseFuture().awaitUninterruptibly();
		connector.dispose();

		logger.info("client end");
	}
}
