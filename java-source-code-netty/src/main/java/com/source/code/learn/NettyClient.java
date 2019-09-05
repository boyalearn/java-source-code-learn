package com.source.code.learn;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

public class NettyClient {
	public void start(){
		NioEventLoopGroup group=new NioEventLoopGroup();
		Bootstrap client=new Bootstrap();
		client.group(group).channel(NioSocketChannel.class);
		client.option(ChannelOption.TCP_NODELAY, true);
		client.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
            	
                ch.pipeline().addLast(new SendHandler());
                ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                
            }
        });
		
		try {
			ChannelFuture f=client.connect("127.0.0.1", 8080);
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			group.shutdownGracefully();
		}
	}
}
