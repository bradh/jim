package net.frogmouth.rnd.jim.s4607;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.packet.Packet;
import net.frogmouth.rnd.jim.s4607.packet.PacketHeader;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.SegmentParserManager;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/** STANAG 4607 / AEDP-7 GMTI Reader. */
public class Reader {

    private ParseContext context;
    private List<Packet> packets = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param filename the file name to read from
     * @throws IOException if parsing of the file fails
     */
    public Reader(String filename) throws IOException {
        this(Paths.get(filename));
    }

    /**
     * Constructor.
     *
     * @param path the path to the file to read from
     * @throws IOException if parsing of the file fails
     */
    public Reader(Path path) throws IOException {
        context = new ParseContext(path);
        long packetStartOffset = 0;

        while (context.hasRemaining()) {
            Packet packet = new Packet();
            PacketHeader packetHeader = readPacketHeader();
            packet.setPacketHeader(packetHeader);
            while (context.position() < (packetStartOffset + packetHeader.getPacketSize())) {
                packet.addSegment(readSegment());
            }
            packets.add(packet);
            packetStartOffset += packetHeader.getPacketSize();
        }
    }

    /**
     * Get the packets that were read from the file.
     *
     * <p>Each packet will consist of zero or more Segments, which is usually what you are looking
     * for.
     *
     * @return the list of packets.
     */
    public List<Packet> getPackets() {
        return new ArrayList<>(packets);
    }

    private PacketHeader readPacketHeader() {
        PacketHeader ph = new PacketHeader();
        ph.setVersionId(context.readASCII(2));
        ph.setPacketSize(context.readI32());
        ph.setNationality(context.readASCII(2));
        ph.setClassification(context.readE8());
        ph.setClassificationSystem(context.readASCII(2));
        ph.setClassificationCodeFlags(context.readFL16());
        ph.setExerciseIndicator(context.readE8());
        ph.setPlatformId(context.readASCII(10));
        ph.setMissionId(context.readI32());
        ph.setJobId(context.readI32());
        return ph;
    }

    private Segment readSegment() {
        SegmentType segmentType = SegmentType.lookupByIdent(context.readE8());
        long segmentSize = context.readI32();
        SegmentHeader segmentHeader = new SegmentHeader(segmentType, segmentSize);
        SegmentParser segmentParser = SegmentParserManager.getInstance().getParser(segmentType);
        segmentParser.setParseContext(context);
        return segmentParser.parse(segmentHeader);
    }
}
