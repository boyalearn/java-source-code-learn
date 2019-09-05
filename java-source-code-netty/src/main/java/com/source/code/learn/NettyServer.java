package com.source.code.learn;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;

public class NettyServer {
	public void start(int port){
		NioEventLoopGroup bossGroup=new NioEventLoopGroup(1);
		NioEventLoopGroup workGroup=new NioEventLoopGroup();
		ServerBootstrap server=new ServerBootstrap();
		server.group(bossGroup, workGroup).channel(NioServerSocketChannel.class);
		server.childHandler(new ChannelInitializer<SocketChannel>(){

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
				ch.pipeline().addLast(new DellHander());
			}
			
		});
		try {
			ChannelFuture f=server.bind(port).sync();
			System.out.println("捲暦匂尼強。。。。。。。。。。。。");
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
