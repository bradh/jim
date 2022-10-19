package net.frogmouth.rnd.jim.s4676.message.motionevent;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.NitsRoot;
import net.frogmouth.rnd.jim.s4676.Parser;
import net.frogmouth.rnd.jim.s4676.common.CertaintyStatisticType;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.CoordinateSystemType;
import net.frogmouth.rnd.jim.s4676.common.Dimensionality;
import net.frogmouth.rnd.jim.s4676.common.Polygon;
import net.frogmouth.rnd.jim.s4676.common.PositionPoints;
import net.frogmouth.rnd.jim.s4676.message.TrackMessage;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class MotionEventTest {

    public MotionEventTest() {}

    @Test
    public void testMotionEventWithTripwire() throws JsonProcessingException {
        MotionEvent uut = new MotionEvent(MotionEventType.CROSSING_TRIPWIRE, 21477000000L);
        uut.setLid(123L);
        uut.addTrackLID(234L);
        uut.setConfidence(new Confidence(CertaintyStatisticType.PROBABILITY, 65));
        PositionPoints tripwirePoints =
                new PositionPoints(
                        Dimensionality.TWO_D,
                        CoordinateSystemType.WGS_84,
                        new Double[] {-34.0, 140.0, -36.0, 142.0});
        uut.setTripwire(tripwirePoints);
        NitsRoot rootElement = new NitsRoot();
        TrackMessage message =
                new TrackMessage(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC), 0.001);
        message.addMotionEvent(uut);
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
                                                .getResourceAsStream("motionevent.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testMotionEventWithROI() throws JsonProcessingException {
        MotionEvent uut = new MotionEvent(MotionEventType.ENTERING_ROI, 21477000000L);
        uut.setLid(123L);
        uut.addTrackLID(234L);
        uut.setConfidence(new Confidence(CertaintyStatisticType.PROBABILITY, 65));
        Polygon polygon = new Polygon(Dimensionality.TWO_D, CoordinateSystemType.WGS_84);
        // TODO: polygon needs vertices
        uut.setRegion(polygon);
        NitsRoot rootElement = new NitsRoot();
        TrackMessage message =
                new TrackMessage(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC), 0.001);
        message.addMotionEvent(uut);
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
                                                .getResourceAsStream("motionevent_roi.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testParseMerge() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("motionevent.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getMessages().get(0).getMotionEvents());
        assertTrue(rootElement.getMessages().get(0).getMotionEvents() instanceof List<MotionEvent>);
        List<MotionEvent> motionEvents = rootElement.getMessages().get(0).getMotionEvents();
        assertEquals(motionEvents.size(), 1);
        MotionEvent motionEvent = motionEvents.get(0);
        assertEquals(motionEvent.getType(), MotionEventType.CROSSING_TRIPWIRE);
        assertNull(motionEvent.getUniqueID());
        assertEquals(motionEvent.getLid(), 123L);
        assertNotNull(motionEvent.getConfidence());
        Confidence confidence = motionEvent.getConfidence();
        assertEquals(confidence.getType(), CertaintyStatisticType.PROBABILITY);
        assertEquals(confidence.getValue(), 65);
        assertNull(confidence.getSourceReliability());
        assertNotNull(motionEvent.getTripwire());
        PositionPoints tripwire = motionEvent.getTripwire();
        assertEquals(tripwire.getDims(), Dimensionality.TWO_D);
        assertEquals(tripwire.getCoordinateSystemType(), CoordinateSystemType.WGS_84);
        List<Double> expectedPoints = Arrays.asList(-34.0, 140.0, -36.0, 142.0);
        assertEquals(tripwire.getPoints(), expectedPoints);
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
