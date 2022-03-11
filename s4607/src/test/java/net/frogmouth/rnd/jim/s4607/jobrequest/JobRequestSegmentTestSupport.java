package net.frogmouth.rnd.jim.s4607.jobrequest;

import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.ByteArrayParseContext;
import net.frogmouth.rnd.jim.s4607.IParseContext;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentParserManager;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

public class JobRequestSegmentTestSupport {

    protected JobRequestSegment doParse() {
        byte[] bytes = getTestBytes();
        IParseContext parseContext = new ByteArrayParseContext(bytes);
        JobRequestSegmentParser parser = new JobRequestSegmentParser();
        parser.setParseContext(parseContext);
        SegmentHeader segmentHeader =
                new SegmentHeader(SegmentType.JobRequestSegment, bytes.length + 5);
        Segment segment = parser.parse(segmentHeader);
        assertTrue(segment instanceof JobRequestSegment);
        JobRequestSegment jobRequestSegment = (JobRequestSegment) segment;
        return jobRequestSegment;
    }

    protected JobRequestSegment doFactoryParse() {
        byte[] bytes = getTestBytes();
        IParseContext parseContext = new ByteArrayParseContext(bytes);
        AbstractSegmentParser parser =
                SegmentParserManager.getInstance().getParser(SegmentType.JobRequestSegment);
        assertTrue(parser instanceof JobRequestSegmentParser);
        parser.setParseContext(parseContext);
        SegmentHeader segmentHeader =
                new SegmentHeader(SegmentType.JobRequestSegment, bytes.length + 5);
        Segment segment = parser.parse(segmentHeader);
        assertTrue(segment instanceof JobRequestSegment);
        JobRequestSegment jobRequestSegment = (JobRequestSegment) segment;
        return jobRequestSegment;
    }

    protected byte[] getTestBytes() {
        byte[] bytes =
                new byte[] {
                    0x42,
                    0x72,
                    0x61,
                    0x64,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x54,
                    0x61,
                    0x73,
                    0x6B,
                    0x20,
                    0x34,
                    0x43,
                    0x20,
                    0x20,
                    0x20,
                    0x32,
                    // Start of bounding box
                    (byte) 0xCF,
                    0x5C,
                    0x28,
                    (byte) 0xF6,
                    0x59,
                    0x75,
                    0x30,
                    (byte) 0xEC,
                    (byte) 0xCF,
                    0x5C,
                    0x28,
                    (byte) 0xF6,
                    0x59,
                    (byte) 0xAB,
                    (byte) 0xCD,
                    (byte) 0xF0,
                    (byte) 0xCF,
                    0x25,
                    (byte) 0x8B,
                    (byte) 0xF3,
                    0x59,
                    (byte) 0xAB,
                    (byte) 0xCD,
                    (byte) 0xF0,
                    (byte) 0xCF,
                    0x25,
                    (byte) 0x8B,
                    (byte) 0xF3,
                    0x59,
                    0x75,
                    0x30,
                    (byte) 0xEC,
                    0x01,
                    0x07,
                    (byte) 0xD0,
                    0x01,
                    (byte) 0xF4,
                    0x07,
                    (byte) 0xE6,
                    0x03,
                    0x0D,
                    0x09,
                    0x0C,
                    0x26,
                    0x07,
                    0x08,
                    0x04,
                    (byte) 0xB0,
                    0x00,
                    0x64,
                    (byte) 0xFF,
                    0x4E,
                    0x6F,
                    0x6E,
                    0x65,
                    0x20,
                    0x20,
                    0x00
                };
        return bytes;
    }
}
