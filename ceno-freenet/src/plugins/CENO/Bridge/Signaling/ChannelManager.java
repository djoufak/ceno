package plugins.CENO.Bridge.Signaling;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import freenet.support.Logger;

public class ChannelManager {
	private List<Channel> channelList;
	private static volatile ChannelManager instance;

	private ChannelManager() {
		channelList = new ArrayList<Channel>();
	}

	public static ChannelManager getInstance() {
		if (instance == null) {
			synchronized(ChannelManager.class) {
				instance = new ChannelManager();
			}
		}
		return instance;
	}

	public Channel getChannel(String signalSSK) {
		for (Channel channel : channelList) {
			if (channel.getInsertSSK().equals(signalSSK))
				return channel;
		}
		return null;
	}

	public void addChannel(Channel channel) throws MalformedURLException {
		if (channel != null) {
			if (!channelList.contains(channel)) {
				channelList.add(channel);
				subscribeToChannel(channel);
			}
		}
	}

	public int addChannels(List<Channel> extraChannelsList) {
		int counter = 0;
		if (extraChannelsList != null) {
			for (Channel channel : extraChannelsList) {
				try {
					addChannel(channel);
					counter++;
				} catch (MalformedURLException e) {
					Logger.normal(this, "Could not add channel with insert SSK: " + channel.getInsertSSK());
				}
			}
		}
		return counter;
	}

	public void addChannel(String signalSSK) {
		Channel channel;
		try {
			channel = new Channel(signalSSK);
			addChannel(channel);
		} catch (MalformedURLException e) {
			Logger.warning(this, "Could not subscribe to SSK during channel creation for key: " + signalSSK);
			return;
		}
	}

	public boolean removeChannel(Channel channel) {
		if (channel != null && channelList.contains(channel)) {
			channelList.remove(channel);
			return true;
		}
		return false;
	}

	public List<Channel> getAllChannels() {
		return channelList;
	}

	private void subscribeToChannel(Channel channel) throws MalformedURLException {
		channel.subscribeToChannelUpdates();
	}


}
