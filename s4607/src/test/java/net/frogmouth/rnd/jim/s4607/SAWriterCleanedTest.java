package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.packet.Packet;
import org.testng.annotations.Test;

/**
 * Test for writing a file.
 *
 * <p>This uses a cleaned-up version of the AFRL "Ten Targets Situational Awareness" test data. The
 * cleaning fixes some strings that are not appropriately padded (e.g. uses nulls instead of
 * spaces).
 */
public class SAWriterCleanedTest extends TestSupport {

    public SAWriterCleanedTest() {}

    @Test
    public void write() throws IOException {
        Reader reader = new Reader(get10TargetsSACleaned());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 194);
        SerialisationContext serialisationContext = new SerialisationContext();
        serialisationContext.setUseSAProfileForEmptyDwellTargetMask(true);
        Writer writer = new Writer();
        for (Packet packet : packets) {
            writer.writePacket(packet, serialisationContext);
        }
        byte[] bytes = writer.getBytes();
        byte[] referenceBytes = Files.readAllBytes(get10TargetsSACleaned());
        assertEquals(bytes, referenceBytes);
    }
}
