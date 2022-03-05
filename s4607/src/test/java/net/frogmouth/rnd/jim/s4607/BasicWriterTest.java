package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.packet.Packet;
import org.testng.annotations.Test;

public class BasicWriterTest extends TestSupport {

    public BasicWriterTest() {}

    @Test
    public void write() throws IOException {
        Reader reader = new Reader(getList1());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 2);
        Writer writer = new Writer();
        for (Packet packet : packets) {
            writer.writePacket(packet);
        }
        byte[] bytes = writer.getBytes();
        byte[] referenceBytes = Files.readAllBytes(getList1());
        assertEquals(bytes, referenceBytes);
    }
}
