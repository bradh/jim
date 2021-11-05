package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Track {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String uid;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private TrackSegment segment;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
