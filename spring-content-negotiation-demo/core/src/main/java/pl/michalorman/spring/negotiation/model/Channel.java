package pl.michalorman.spring.negotiation.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.net.MalformedURLException;
import java.net.URL;

public class Channel {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private URL streamUrl;

    @XmlAttribute
    private String currentlyPlaying;

    public Channel() {
    }

    public Channel(String name, String streamUrl, String currentlyPlaying) {
        try {
            this.name = name;
            this.streamUrl = new URL(streamUrl);
            this.currentlyPlaying = currentlyPlaying;
        } catch (MalformedURLException e) {
            // ignore that
        }
    }

    public String getName() {
        return name;
    }

    public URL getStreamUrl() {
        return streamUrl;
    }

    public String getCurrentlyPlaying() {
        return currentlyPlaying;
    }
}
