package com.source.code.learn;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class SendHandler extends SimpleChannelInboundHandler<ByteBuf>{

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		for(int i=0;i<100;i++)
		ctx.writeAndFlush(Unpooled.copiedBuffer("����һ��Nettyʾ������\r\n", CharsetUtil.UTF_8));
	}
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		System.out.println("�ͻ��˽��յ���Ϣ�� " + in.toString(CharsetUtil.UTF_8));
	}

}
