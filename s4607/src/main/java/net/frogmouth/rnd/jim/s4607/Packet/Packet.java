package net.frogmouth.rnd.jim.s4607.Packet;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;

public class Packet {
    private PacketHeader packetHeader;
    private final List<Segment> segments = new ArrayList<>();

    public PacketHeader getPacketHeader() {
        return new PacketHeader(packetHeader);
    }

    public void setPacketHeader(PacketHeader packetHeader) {
        this.packetHeader = new PacketHeader(packetHeader);
    }

    public List<Segment> getSegments() {
        return new ArrayList<>(segments);
    }

    public void addSegment(Segment segment) {
        this.segments.add(segment);
    }
}
