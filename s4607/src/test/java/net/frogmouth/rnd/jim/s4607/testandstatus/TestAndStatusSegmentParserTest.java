package net.frogmouth.rnd.jim.s4607.testandstatus;

import static org.testng.Assert.*;

import java.util.List;
import net.frogmouth.rnd.jim.s4607.ByteArrayParseContext;
import net.frogmouth.rnd.jim.s4607.IParseContext;
import net.frogmouth.rnd.jim.s4607.Reader;
import net.frogmouth.rnd.jim.s4607.packet.Packet;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class TestAndStatusSegmentParserTest {

    public TestAndStatusSegmentParserTest() {}

    @Test
    public void simpleParse() {
        byte[] bytes =
                new byte[] {
                    0x00, 0x00, 0x00, 0x03, 0x00, 0x05, 0x00, 0x07, 0x02, 0x04, 0x08, 0x0F, 0x10,
                    0x20
                };
        IParseContext parseContext = new ByteArrayParseContext(bytes);
        TestAndStatusSegmentParser parser = new TestAndStatusSegmentParser();
        parser.setParseContext(parseContext);
        SegmentHeader segmentHeader =
                new SegmentHeader(SegmentType.TestAndStatusSegment, bytes.length + 5);
        Segment segment = parser.parse(segmentHeader);
        assertTrue(segment instanceof TestAndStatusSegment);
        TestAndStatusSegment testAndStatusSegment = (TestAndStatusSegment) segment;
        assertEquals(testAndStatusSegment.getJobId(), 3);
        assertEquals(testAndStatusSegment.getRevisitIndex(), 5);
        assertEquals(testAndStatusSegment.getDwellIndex(), 7);
        assertEquals(testAndStatusSegment.getDwellTime(), 33818639);
        assertEquals(testAndStatusSegment.getHardwareStatus().toByte(), 0x10);
        assertEquals(testAndStatusSegment.getModeStatus().toByte(), 0x20);
    }

    @Test
    public void parseUsingReader() {
        byte[] bytes =
                new byte[] {
                    0x34,
                    0x31,
                    0x00,
                    0x00,
                    0x00,
                    0x33,
                    0x41,
                    0x53,
                    0x05,
                    0x41,
                    0x53,
                    0x00,
                    0x00,
                    (byte) 0x81,
                    0x4A,
                    0x49,
                    0x4D,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x00,
                    0x00,
                    0x00,
                    0x01,
                    0x00,
                    0x00,
                    0x00,
                    0x00,
                    0x0A,
                    0x00,
                    0x00,
                    0x00,
                    0x13,
                    0x00,
                    0x00,
                    0x00,
                    0x03,
                    0x00,
                    0x05,
                    0x00,
                    0x07,
                    0x02,
                    0x04,
                    0x08,
                    0x0F,
                    0x10,
                    0x20
                };
        Reader reader = new Reader(bytes);
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 1);
        Packet packet = packets.get(0);
        assertEquals(packet.getPacketHeader().getVersionId(), "41");
        assertEquals(packet.getPacketHeader().getNationality(), "AS");
        assertEquals(packet.getPacketHeader().getMissionId(), 1);
        assertEquals(packet.getPacketHeader().getJobId(), 0);
        assertEquals(packet.getSegments().size(), 1);
        Segment segment = packet.getSegments().get(0);
        assertTrue(segment instanceof TestAndStatusSegment);
        TestAndStatusSegment testAndStatusSegment = (TestAndStatusSegment) segment;
        assertEquals(testAndStatusSegment.getSegmentType(), SegmentType.TestAndStatusSegment);
        assertEquals(testAndStatusSegment.getJobId(), 3);
        assertEquals(testAndStatusSegment.getRevisitIndex(), 5);
        assertEquals(testAndStatusSegment.getDwellIndex(), 7);
        assertEquals(testAndStatusSegment.getDwellTime(), 33818639);
        assertEquals(testAndStatusSegment.getHardwareStatus().toByte(), 0x10);
        assertEquals(testAndStatusSegment.getModeStatus().toByte(), 0x20);
    }
}
