package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.Packet.Packet;
import org.testng.annotations.Test;

/**
 * Test for writing a file.
 *
 * <p>This uses a cleaned-up version of the AFRL "Ten Targets Precision Targeting plus RCS" test
 * data. The cleaning fixes some strings that are not appropriately padded (e.g. uses nulls instead
 * of spaces).
 */
public class PrecisionWriterCleanedTest extends TestSupport {

    public PrecisionWriterCleanedTest() {}

    @Test
    // @Ignore
    public void write() throws IOException {
        Reader reader = new Reader(get10TargetsPrecisionTargetingCleaned());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 194);
        Writer writer = new Writer();
        for (Packet packet : packets) {
            writer.writePacket(packet);
        }
        byte[] bytes = writer.getBytes();
        byte[] referenceBytes = Files.readAllBytes(get10TargetsPrecisionTargetingCleaned());
        assertEquals(bytes, referenceBytes);
    }
}
