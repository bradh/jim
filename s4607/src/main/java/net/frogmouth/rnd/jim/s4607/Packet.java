package net.frogmouth.rnd.jim.s4607;

import java.util.ArrayList;
import java.util.List;

public class Packet {
    private PacketHeader packetHeader;
    private List<Segment> segments = new ArrayList<>();

    public PacketHeader getPacketHeader() {
        return packetHeader;
    }

    public void setPacketHeader(PacketHeader packetHeader) {
        this.packetHeader = packetHeader;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void addSegment(Segment segment) {
        this.segments.add(segment);
    }
}
