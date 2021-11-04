package com.sigmabravo.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class BasicWriterTest extends TestSupport {

    public BasicWriterTest() {}

    @Test
    public void read() throws IOException {
        Reader reader = new Reader(getList1());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 2);
        Packet packet0 = packets.get(0);
        PacketHeader packetHeader = packet0.getPacketHeader();
        Writer writer = new Writer();
        // TODO: check the results
        writer.writePacketHeader(packetHeader);
    }
}
