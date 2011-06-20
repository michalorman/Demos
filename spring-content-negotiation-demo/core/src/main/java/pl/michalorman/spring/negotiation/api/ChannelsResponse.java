package pl.michalorman.spring.negotiation.api;

import pl.michalorman.spring.negotiation.model.Channel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement 
public class ChannelsResponse {

    @XmlElementWrapper
    @XmlElement(name = "channel")
    private Collection<Channel> channels = new ArrayList<Channel>();

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public Collection<Channel> getChannels() {
        return channels;
    }
}
