package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.ZonedDateTime;

@JacksonXmlRootElement(
        namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
        localName = "nitsRoot")
public class NitsRoot {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String profile;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String nitsVersion;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ZonedDateTime msgCreatedTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Message message;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNitsVersion() {
        return nitsVersion;
    }

    public void setNitsVersion(String nitsVersion) {
        this.nitsVersion = nitsVersion;
    }

    public ZonedDateTime getMsgCreatedTime() {
        return msgCreatedTime;
    }

    public void setMsgCreatedTime(ZonedDateTime msgCreatedTime) {
        this.msgCreatedTime = msgCreatedTime;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
