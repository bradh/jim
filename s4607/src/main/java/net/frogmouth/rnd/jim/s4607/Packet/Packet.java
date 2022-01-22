package net.frogmouth.rnd.jim.s4607.Packet;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;

/**
 * Model for a GMTI Packet.
 *
 * <p>The packet conceptually consists of a header, and a number of segments.
 */
public class Packet {
    private PacketHeader packetHeader;
    private final List<Segment> segments = new ArrayList<>();

    /**
     * Get the packet header.
     *
     * @return the packet header.
     */
    public PacketHeader getPacketHeader() {
        return new PacketHeader(packetHeader);
    }

    /**
     * Set the packet header.
     *
     * @param packetHeader the packet header.
     */
    public void setPacketHeader(PacketHeader packetHeader) {
        this.packetHeader = new PacketHeader(packetHeader);
    }

    /**
     * Get the segments.
     *
     * <p>It is not clear if there can be zero segments in a valid Packet. At least, it isn't
     * obviously prohibited, so implementations should be prepared to handle that case.
     *
     * @return the segments in the packet.
     */
    public List<Segment> getSegments() {
        return new ArrayList<>(segments);
    }

    /**
     * Add a segment to the packet.
     *
     * <p>Segments will be appended, and order matters, so ensure that segments are added in the
     * correct sequence.
     *
     * @param segment the segment to add.
     */
    public void addSegment(Segment segment) {
        this.segments.add(segment);
    }
}
