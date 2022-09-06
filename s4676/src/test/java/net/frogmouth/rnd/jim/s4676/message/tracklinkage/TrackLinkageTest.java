package net.frogmouth.rnd.jim.s4676.message.tracklinkage;

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
import net.frogmouth.rnd.jim.s4676.common.CertaintyStatisticType;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.message.TrackMessage;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class TrackLinkageTest {

    public TrackLinkageTest() {}

    @Test
    public void testTrackLinkageMerge() throws JsonProcessingException {
        TrackLinkage uut = new TrackLinkage(TrackLinkageType.MERGE);
        uut.setLid(123L);
        uut.setRelTime(21477000000L);
        uut.setConfidence(new Confidence(CertaintyStatisticType.PROBABILITY, 80));
        uut.addPreLinkageLocalId(80);
        uut.addPreLinkageLocalId(82);
        uut.addPostLinkageLocalId(162);
        NitsRoot rootElement = new NitsRoot();
        TrackMessage message =
                new TrackMessage(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC), 0.001);
        message.addTrackLinkage(uut);
        rootElement.addMessage(message);
        rootElement.addProfile("STANDALONE");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(
                        LocalDateTime.of(2022, Month.SEPTEMBER, 6, 3, 50, 8), ZoneOffset.UTC));
        rootElement.setNitsVersion("B.2");
        String serialisedXml = new Parser().serialise(rootElement);
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("tracklinkage.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testParseMerge() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("tracklinkage.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getMessages().get(0).getTrackLinkages());
        assertTrue(
                rootElement.getMessages().get(0).getTrackLinkages() instanceof List<TrackLinkage>);
        List<TrackLinkage> linkages = rootElement.getMessages().get(0).getTrackLinkages();
        assertEquals(linkages.size(), 1);
        TrackLinkage trackLinkage = linkages.get(0);
        assertEquals(trackLinkage.getType(), TrackLinkageType.MERGE);
        assertNull(trackLinkage.getUid());
        assertEquals(trackLinkage.getLid(), 123L);
        assertEquals(trackLinkage.getPreLinkageLocalIds().size(), 2);
        assertEquals(trackLinkage.getPreLinkageLocalIds().get(0), 80L);
        assertEquals(trackLinkage.getPreLinkageLocalIds().get(1), 82L);
        assertEquals(trackLinkage.getPostLinkageLocalIds().get(0), 162L);
        assertNotNull(trackLinkage.getConfidence());
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }

    @Test
    public void testTrackLinkageSplit() throws JsonProcessingException {
        TrackLinkage uut = new TrackLinkage(TrackLinkageType.SPLIT);
        uut.setLid(123L);
        uut.setRelTime(21477000000L);
        uut.setConfidence(new Confidence(CertaintyStatisticType.PROBABILITY, 80));
        uut.addPreLinkageLocalId(82);
        uut.addPostLinkageLocalId(42);
        uut.addPostLinkageLocalId(40);
        NitsRoot rootElement = new NitsRoot();
        TrackMessage message =
                new TrackMessage(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC), 0.001);
        message.addTrackLinkage(uut);
        rootElement.addMessage(message);
        rootElement.addProfile("STANDALONE");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(
                        LocalDateTime.of(2022, Month.SEPTEMBER, 6, 3, 50, 8), ZoneOffset.UTC));
        rootElement.setNitsVersion("B.2");
        String serialisedXml = new Parser().serialise(rootElement);
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("tracklinkage_split.xml")))
                        .ignoreWhitespace());
    }
}
