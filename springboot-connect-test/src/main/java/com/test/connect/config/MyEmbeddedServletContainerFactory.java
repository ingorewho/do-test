package com.test.connect.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

/**
 * @Author: ingore1992
 * @Description: 实验得知，
 * springboot-内置tomcat 允许接入的tcp连接数=最大连接数+（accpet/最大线程数 这两个参数其中的最大值）
 *  超过允许接入的tcp连接数后，服务端就会断开客户端新接入的连接
 * @Date: Created In 14:25 2019/1/23
 */
@Component
public class MyEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {
    @Override
    public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers){
        //设置端口
        this.setPort(8081);
        return super.getEmbeddedServletContainer(initializers);
    }

    @Override
    protected void customizeConnector(Connector connector){
        super.customizeConnector(connector);
        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
        //设置最大连接数
        protocol.setMaxConnections(50);
        protocol.setSessionTimeout(1);
        //设置全连接队列大小
        protocol.setAcceptCount(50);
        //设置长连接下保活时间
        protocol.setKeepAliveTimeout(5000);
        //设置长连接下保活发送次数
        protocol.setMaxKeepAliveRequests(5);
        //设置最大线程数
        protocol.setMaxThreads(99);
        //设置数据上传超时，默认5分钟
        protocol.setConnectionUploadTimeout(100);
        //设置连接超时，默认20秒
        protocol.setConnectionTimeout(100);
    }
}
