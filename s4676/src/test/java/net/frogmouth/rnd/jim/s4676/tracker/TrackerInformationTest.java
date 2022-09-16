package net.frogmouth.rnd.jim.s4676.tracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.NitsRoot;
import net.frogmouth.rnd.jim.s4676.Parser;
import net.frogmouth.rnd.jim.s4676.common.IDData;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class TrackerInformationTest {

    public TrackerInformationTest() {}

    @Test
    public void testTrackerInformation() throws JsonProcessingException {
        TrackerInformation uut =
                new TrackerInformation(TrackerType.SEMIAUTOMATIC_TRACKER, "Tracker 4", "0.1alpha");
        uut.setLid(9L);
        uut.setDescription("Test description of tracker 4");
        uut.setTrackerID(new IDData("TRACKER 4 ", "AUS"));
        SupplementaryData supplementaryData =
                new SupplementaryData(
                        SupplementaryDataType.ILLUMINATION_SHADOW_MAP, "Shadow map", "0.3b");
        supplementaryData.setDescription("This is a demo shadow map entry");
        uut.addSupplementaryData(supplementaryData);
        NitsRoot rootElement = new NitsRoot();
        rootElement.addTracker(uut);
        rootElement.addProfile("STANDALONE");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(
                        LocalDateTime.of(2022, Month.SEPTEMBER, 3, 4, 4, 0), ZoneOffset.UTC));
        rootElement.setNitsVersion("B.2");
        String serialisedXml = new Parser().serialise(rootElement);
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("trackerInformation.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testTwoTrackerInformation() throws JsonProcessingException {
        TrackerInformation trackerInfo1 =
                new TrackerInformation(TrackerType.SEMIAUTOMATIC_TRACKER, "Tracker 4", "0.1alpha");
        trackerInfo1.setLid(9L);
        trackerInfo1.setDescription("Test description of tracker 4");
        trackerInfo1.setTrackerID(new IDData("TRACKER 4 ", "AUS"));
        SupplementaryData supplementaryData =
                new SupplementaryData(
                        SupplementaryDataType.ILLUMINATION_SHADOW_MAP, "Shadow map", "0.3b");
        supplementaryData.setDescription("This is a demo shadow map entry");
        trackerInfo1.addSupplementaryData(supplementaryData);
        NitsRoot rootElement = new NitsRoot();
        rootElement.addTracker(trackerInfo1);
        rootElement.addTracker(
                new TrackerInformation(TrackerType.AUTOMATIC_TRACKER, "Autotracker", "103.8"));
        rootElement.addProfile("STANDALONE");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(
                        LocalDateTime.of(2022, Month.SEPTEMBER, 3, 4, 4, 0), ZoneOffset.UTC));
        rootElement.setNitsVersion("B.2");
        String serialisedXml = new Parser().serialise(rootElement);
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("twoTrackerInformation.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testParse() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("trackerInformation.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getTrackers());
        assertTrue(rootElement.getTrackers() instanceof List<TrackerInformation>);
        List<TrackerInformation> trackers = rootElement.getTrackers();
        assertEquals(trackers.size(), 1);
        TrackerInformation tracker = trackers.get(0);
        assertNull(tracker.getUniqueID());
        assertEquals(tracker.getLid(), 9L);
        assertEquals(tracker.getName(), "Tracker 4");
        assertEquals(tracker.getVersion(), "0.1alpha");
        assertEquals(tracker.getDescription(), "Test description of tracker 4");
        assertEquals(tracker.getType(), TrackerType.SEMIAUTOMATIC_TRACKER);
        assertNotNull(tracker.getSupplementaryData());
        assertEquals(tracker.getSupplementaryData().size(), 1);
        assertEquals(
                tracker.getSupplementaryData().get(0).getType(),
                SupplementaryDataType.ILLUMINATION_SHADOW_MAP);
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
