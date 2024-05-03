package net.frogmouth.rnd.jim.s4676;

import static org.testng.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.testng.annotations.Test;

public class TestParse {

    public TestParse() {}

    @Test
    public void testTagTrack() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("tagtrack_2021_10_11.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertEquals(rootElement.getProfile().size(), 1);
        assertEquals(rootElement.getProfile().get(0), "STANDALONE");
        assertEquals(rootElement.getNitsVersion(), "B.1");
        ZonedDateTime expectedDateTime =
                ZonedDateTime.of(
                        LocalDateTime.of(2021, 10, 10, 22, 24, 33, 733000000), ZoneOffset.UTC);
        assertEquals(rootElement.getMsgCreatedTime(), expectedDateTime);
    }
}
