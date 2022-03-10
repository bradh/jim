package net.frogmouth.rnd.jim.s4607.processinghistory;

import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.ByteArrayParseContext;
import net.frogmouth.rnd.jim.s4607.IParseContext;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

public class ProcessingHistorySegmentTestSupport {

    protected ProcessingHistorySegment doParse() {
        byte[] bytes = getTestBytes();
        IParseContext parseContext = new ByteArrayParseContext(bytes);
        ProcessingHistorySegmentParser parser = new ProcessingHistorySegmentParser();
        parser.setParseContext(parseContext);
        SegmentHeader segmentHeader =
                new SegmentHeader(SegmentType.ProcessingHistorySegment, bytes.length + 5);
        Segment segment = parser.parse(segmentHeader);
        assertTrue(segment instanceof ProcessingHistorySegment);
        ProcessingHistorySegment processingHistorySegment = (ProcessingHistorySegment) segment;
        return processingHistorySegment;
    }

    protected byte[] getTestBytes() {
        byte[] bytes =
                new byte[] {
                    // TODO
                    0x02,
                    0x41,
                    0x53,
                    0x41,
                    0x34,
                    0x37,
                    0x2D,
                    0x30,
                    0x31,
                    0x32,
                    0x20,
                    0x20,
                    0x20,
                    0x00,
                    0x00,
                    0x01,
                    0x02,
                    0x00,
                    0x00,
                    0x00,
                    0x07,
                    // First processing record
                    0x01,
                    0x41,
                    0x53,
                    0x44,
                    0x47,
                    0x53,
                    0x2D,
                    0x41,
                    0x55,
                    0x53,
                    0x20,
                    0x20,
                    0x20,
                    0x00,
                    0x00,
                    0x02,
                    0x03,
                    0x00,
                    0x00,
                    0x00,
                    0x02,
                    0x02,
                    (byte) 0x81,
                    // Second processing record
                    0x02,
                    0x55,
                    0x4B,
                    0x41,
                    0x62,
                    0x62,
                    0x65,
                    0x79,
                    0x20,
                    0x52,
                    0x6F,
                    0x61,
                    0x64,
                    0x00,
                    0x08,
                    0x02,
                    0x08,
                    0x00,
                    0x03,
                    0x04,
                    0x05,
                    (byte) 0x09,
                    0x20
                };
        return bytes;
    }
}
