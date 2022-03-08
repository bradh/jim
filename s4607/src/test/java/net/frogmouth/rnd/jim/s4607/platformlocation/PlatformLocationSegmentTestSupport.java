package net.frogmouth.rnd.jim.s4607.platformlocation;

import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.ByteArrayParseContext;
import net.frogmouth.rnd.jim.s4607.IParseContext;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

public class PlatformLocationSegmentTestSupport {

    protected PlatformLocationSegment doParse() {
        byte[] bytes = getTestBytes();
        IParseContext parseContext = new ByteArrayParseContext(bytes);
        PlatformLocationSegmentParser parser = new PlatformLocationSegmentParser();
        parser.setParseContext(parseContext);
        SegmentHeader segmentHeader =
                new SegmentHeader(SegmentType.PlatformLocationSegment, bytes.length + 5);
        Segment segment = parser.parse(segmentHeader);
        assertTrue(segment instanceof PlatformLocationSegment);
        PlatformLocationSegment platformLocationSegment = (PlatformLocationSegment) segment;
        return platformLocationSegment;
    }

    protected byte[] getTestBytes() {
        byte[] bytes =
                new byte[] {
                    0x00,
                    0x00,
                    0x00,
                    0x03,
                    (byte) 0xEF,
                    0x7C,
                    0x02,
                    0x07,
                    (byte) 0x63,
                    0x45,
                    (byte) 0x92,
                    0x37,
                    0x00,
                    0x12,
                    0x4F,
                    (byte) 0x80,
                    0x10,
                    0x30,
                    0x00,
                    0x00,
                    0x00,
                    (byte) 0xCD,
                    0x14
                };
        return bytes;
    }
}
