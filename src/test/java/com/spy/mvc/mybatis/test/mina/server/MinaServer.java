package com.spy.mvc.mybatis.test.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spy.mvc.mybatis.test.mina.Const;

/**
 * @author spy
 *
 * @datetime 2015年10月26日 上午11:09:23
 */
public class MinaServer {
	private static final Logger logger = LoggerFactory.getLogger(MinaServer.class);

	public static void main(String[] args) {
		IoAcceptor acceptor = new NioSocketAcceptor();

		//TODO还是手动控制比较方便
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		acceptor.setHandler(new CustomIoHandler());
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);

		try {
			acceptor.bind(new InetSocketAddress(Const.PORT));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		logger.debug("Mina Server started");
	}

}
