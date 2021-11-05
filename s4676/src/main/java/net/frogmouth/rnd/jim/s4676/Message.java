package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.time.ZonedDateTime;

public class Message {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ZonedDateTime baseTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private double relTimeIncrement;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Track track;

    public ZonedDateTime getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(ZonedDateTime baseTime) {
        this.baseTime = baseTime;
    }

    public double getRelTimeIncrement() {
        return relTimeIncrement;
    }

    public void setRelTimeIncrement(double relTimeIncrement) {
        this.relTimeIncrement = relTimeIncrement;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
