package hr.bitman.babbleHub.redis;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import redis.clients.jedis.JedisPubSub;
/**
 * Redis subscriber, extends JedisPubSub
 * @author vsrdarevic
 *
 */
public class RedisSubscriber extends JedisPubSub{

	private ChannelGroup channelGroup = new DefaultChannelGroup();
	private static RedisSubscriber instance = null;
	private final static Logger log = Logger.getLogger(RedisSubscriber.class);
	
	private RedisSubscriber(){
		
	}
	public static RedisSubscriber getInstance(){
		if (instance == null){
			instance = new RedisSubscriber();
		}
		return instance;
	}
	@Override
	public void onMessage(String channel, String msg) {
		channelGroup.write(new TextWebSocketFrame(msg));
		
	}

	@Override
	public void onPMessage(String arg0, String arg1, String arg2) {
		
		
	}

	@Override
	public void onPSubscribe(String arg0, int arg1) {
		
	}

	@Override
	public void onPUnsubscribe(String arg0, int arg1) {
	
		
	}

	@Override
	public void onSubscribe(String arg0, int arg1) {
		
		
	}

	@Override
	public void onUnsubscribe(String arg0, int arg1) {
		
	}
	
	public void addChannel(Channel channel){
		log.info("Channel added: " + channel.getId());
		this.channelGroup.add(channel);
	}

	
	
	
	
}
