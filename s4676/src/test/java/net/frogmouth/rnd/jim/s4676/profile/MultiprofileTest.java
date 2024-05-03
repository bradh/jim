package net.frogmouth.rnd.jim.s4676.profile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.s4676.NitsRoot;
import net.frogmouth.rnd.jim.s4676.Parser;
import net.frogmouth.rnd.jim.s4676.TestSupport;
import net.frogmouth.rnd.jim.s4676.sensor.ModalityType;
import net.frogmouth.rnd.jim.s4676.sensor.SensorInformation;
import net.frogmouth.rnd.jim.s4676.tracker.TrackerInformation;
import net.frogmouth.rnd.jim.s4676.tracker.TrackerType;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class MultiprofileTest extends TestSupport {

    public MultiprofileTest() {}

    @Test
    public void testCreate() throws JsonProcessingException {
        NitsRoot rootElement = new NitsRoot();
        setJunkSecurity(rootElement);
        rootElement.addProfile("STANDALONE");
        rootElement.addProfile("EXTENSION_ABCD");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(
                        LocalDateTime.of(2021, Month.OCTOBER, 10, 22, 24, 33, 733000000),
                        ZoneOffset.UTC));
        rootElement.setNitsVersion("B.2");
        SensorInformation sensorInformation =
                new SensorInformation("test sensor", ModalityType.OTHER);
        rootElement.addSensor(sensorInformation);
        TrackerInformation trackerInformation =
                new TrackerInformation(TrackerType.SEMIAUTOMATIC_TRACKER, "test tracker", "0.1");
        rootElement.addTracker(trackerInformation);
        String serialisedXml = new Parser().serialise(rootElement);
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("multiprofile.xml")))
                        .ignoreWhitespace());
    }

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
                        LocalDateTime.of(2021, 10, 10, 22, 24, 33, 733000000), ZoneOffset.UTC);
        assertEquals(rootElement.getMsgCreatedTime(), expectedDateTime);
        String serialisedXml = parser.serialise(rootElement);
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
