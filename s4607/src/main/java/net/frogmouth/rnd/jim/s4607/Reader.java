package net.frogmouth.rnd.jim.s4607;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.Packet.Packet;
import net.frogmouth.rnd.jim.s4607.Packet.PacketHeader;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentParser;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentParserManager;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

/** STANAG 4607 / AEDP-7 GMTI Reader. */
public class Reader {

    private ParseContext context;
    private List<Packet> packets = new ArrayList<>();

    public Reader(String filename) throws IOException {
        this(Paths.get(filename));
    }

    public Reader(Path path) throws IOException {
        context = new ParseContext(path);
        int packetStartOffset = 0;

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