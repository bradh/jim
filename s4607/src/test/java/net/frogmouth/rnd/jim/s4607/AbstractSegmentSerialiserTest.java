package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.assertEquals;

import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;
import org.testng.annotations.Test;

/** Unit tests for AbstractSegmentSerialiser. */
public class AbstractSegmentSerialiserTest {

    private TestSerialiser testHarness = new TestSerialiser();

    class TestSerialiser extends AbstractSegmentSerialiser {

        @Override
        public SegmentType getSegmentType() {
            throw new UnsupportedOperationException("Should not be called.");
        }

        @Override
        public byte[] serialise(Segment segment) {
            throw new UnsupportedOperationException("Should not be called.");
        }

        public byte[] writeB16Forwarder(double value) {
            return writeB16(value);
        }
    }

    public AbstractSegmentSerialiserTest() {}

    @Test
    public void checkB16_Simple() {
        assertEquals(testHarness.writeB16Forwarder(0.0), new byte[] {(byte) 0x00, (byte) 0x00});
        assertEquals(testHarness.writeB16Forwarder(1.0), new byte[] {(byte) 0x00, (byte) 0x80});
        assertEquals(testHarness.writeB16Forwarder(2.0), new byte[] {(byte) 0x01, (byte) 0x00});
        assertEquals(testHarness.writeB16Forwarder(3.0), new byte[] {(byte) 0x01, (byte) 0x80});
        assertEquals(testHarness.writeB16Forwarder(126.0), new byte[] {(byte) 0x3F, (byte) 0x00});
        assertEquals(testHarness.writeB16Forwarder(255.0), new byte[] {(byte) 0x7F, (byte) 0x80});
    }

    @Test
    public void checkB16_Fractional() {
        assertEquals(testHarness.writeB16Forwarder(0.5), new byte[] {(byte) 0x00, (byte) 0x40});
        assertEquals(testHarness.writeB16Forwarder(0.25), new byte[] {(byte) 0x00, (byte) 0x20});
        assertEquals(testHarness.writeB16Forwarder(0.125), new byte[] {(byte) 0x00, (byte) 0x10});
        assertEquals(
                testHarness.writeB16Forwarder(1.0 / 128.0), new byte[] {(byte) 0x00, (byte) 0x01});
        assertEquals(testHarness.writeB16Forwarder(1.5), new byte[] {(byte) 0x00, (byte) 0xC0});
    }

    @Test
    public void checkB16_Negative() {
        assertEquals(testHarness.writeB16Forwarder(-0.0), new byte[] {(byte) 0x00, (byte) 0x00});
        assertEquals(testHarness.writeB16Forwarder(-1.0), new byte[] {(byte) 0x80, (byte) 0x80});
        assertEquals(testHarness.writeB16Forwarder(-2.0), new byte[] {(byte) 0x81, (byte) 0x00});
        assertEquals(testHarness.writeB16Forwarder(-3.0), new byte[] {(byte) 0x81, (byte) 0x80});
        assertEquals(testHarness.writeB16Forwarder(-126.0), new byte[] {(byte) 0xBF, (byte) 0x00});
        assertEquals(testHarness.writeB16Forwarder(-255.0), new byte[] {(byte) 0xFF, (byte) 0x80});
        assertEquals(
                testHarness.writeB16Forwarder(-1.0 / 128.0), new byte[] {(byte) 0x80, (byte) 0x01});
        assertEquals(testHarness.writeB16Forwarder(-1.5), new byte[] {(byte) 0x80, (byte) 0xC0});
    }
}
