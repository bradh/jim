package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class TenTargetsSATest extends TestSupport {

    public TenTargetsSATest() {}

    @Test
    public void instantiate() {
        PacketHeader packetHeader = new PacketHeader();
        assertNotNull(packetHeader);
    }

    @Test
    public void read() throws IOException {
        Reader reader = new Reader(get10TargetsSA());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 194);
        // TODO: work through this.
    }
}
