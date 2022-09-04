package net.frogmouth.rnd.jim.s4676;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class TestMessage {

    public TestMessage() {}

    @Test
    public void testParseNoTracks() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("message_no_tracks.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertEquals(rootElement.getProfile().size(), 1);
        assertEquals(rootElement.getProfile().get(0), "STANDALONE");
        assertEquals(rootElement.getNitsVersion(), "B.1");
        ZonedDateTime expectedDateTime =
                ZonedDateTime.of(
                        LocalDateTime.of(2021, 10, 10, 22, 24, 33, 733000000), ZoneId.of("UTC"));
        assertEquals(rootElement.getMsgCreatedTime(), expectedDateTime);
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }

    @Test
    public void testMessageGeneration() throws JsonProcessingException {
        TrackMessage uut =
                new TrackMessage(
                        ZonedDateTime.of(
                                LocalDateTime.of(2022, Month.MAY, 6, 10, 28, 36), ZoneOffset.UTC),
                        0.001);
        NitsRoot rootElement = new NitsRoot();
        rootElement.addMessage(uut);
        rootElement.addProfile("STANDALONE");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(LocalDateTime.of(2022, Month.MAY, 6, 10, 28, 37), ZoneOffset.UTC));
        rootElement.setNitsVersion("B.1");
        String serialisedXml = new Parser().serialise(rootElement);
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("message_1.xml")))
                        .ignoreWhitespace());
    }
}
