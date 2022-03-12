package net.frogmouth.rnd.jim.s4607.jobacknowledge;

import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.ByteArrayParseContext;
import net.frogmouth.rnd.jim.s4607.IParseContext;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentParserManager;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

public class JobAcknowledgeSegmentTestSupport {

    protected JobAcknowledgeSegment doParse() {
        byte[] bytes = getTestBytes();
        IParseContext parseContext = new ByteArrayParseContext(bytes);
        JobAcknowledgeSegmentParser parser = new JobAcknowledgeSegmentParser();
        parser.setParseContext(parseContext);
        SegmentHeader segmentHeader =
                new SegmentHeader(SegmentType.JobAcknowledgeSegment, bytes.length + 5);
        Segment segment = parser.parse(segmentHeader);
        assertTrue(segment instanceof JobAcknowledgeSegment);
        JobAcknowledgeSegment jobAcknowledgeSegment = (JobAcknowledgeSegment) segment;
        return jobAcknowledgeSegment;
    }

    protected JobAcknowledgeSegment doFactoryParse() {
        byte[] bytes = getTestBytes();
        IParseContext parseContext = new ByteArrayParseContext(bytes);
        AbstractSegmentParser parser =
                SegmentParserManager.getInstance().getParser(SegmentType.JobAcknowledgeSegment);
        assertTrue(parser instanceof JobAcknowledgeSegmentParser);
        parser.setParseContext(parseContext);
        SegmentHeader segmentHeader =
                new SegmentHeader(SegmentType.JobAcknowledgeSegment, bytes.length + 5);
        Segment segment = parser.parse(segmentHeader);
        assertTrue(segment instanceof JobAcknowledgeSegment);
        JobAcknowledgeSegment jobAcknowledgeSegment = (JobAcknowledgeSegment) segment;
        return jobAcknowledgeSegment;
    }

    protected byte[] getTestBytes() {
        byte[] bytes =
                new byte[] {
                    0x02,
                    0x03,
                    0x04,
                    0x08,
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
                    0x12,
                    0x41,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x20,
                    0x08,
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
                    0x66,
                    0x09,
                    0x60,
                    0x00,
                    0x64,
                    0x02,
                    0x07,
                    (byte) 0xE6,
                    0x03,
                    0x0D,
                    0x09,
                    0x0C,
                    0x26,
                    0x41,
                    0x53
                };
        return bytes;
    }
}
