package net.frogmouth.rnd.jim.s4676;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class MultiprofileTest {

    public MultiprofileTest() {}

    @Test
    public void testParse() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("multiprofile.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertEquals(rootElement.getProfile().size(), 2);
        assertEquals(rootElement.getProfile().get(0), "STANDALONE");
        assertEquals(rootElement.getProfile().get(1), "EXTENSION_ABCD");
        assertEquals(rootElement.getNitsVersion(), "B.2");
        ZonedDateTime expectedDateTime =
                ZonedDateTime.of(
                        LocalDateTime.of(2021, 10, 10, 22, 24, 33, 733000000), ZoneId.of("UTC"));
        assertEquals(rootElement.getMsgCreatedTime(), expectedDateTime);
        String serialisedXml = parser.serialise(rootElement);
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
