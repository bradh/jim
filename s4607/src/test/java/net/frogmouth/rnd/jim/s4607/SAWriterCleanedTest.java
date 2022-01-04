package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.Packet.Packet;
import org.testng.annotations.Test;

public class SAWriterCleanedTest extends TestSupport {

    public SAWriterCleanedTest() {}

    @Test
    public void write() throws IOException {
        Reader reader = new Reader(get10TargetsSACleaned());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 194);
        Writer writer = new Writer();
        for (Packet packet : packets) {
            writer.writePacket(packet);
        }
        byte[] bytes = writer.getBytes();
        byte[] referenceBytes = Files.readAllBytes(get10TargetsSACleaned());
        assertEquals(bytes, referenceBytes);
    }
}
