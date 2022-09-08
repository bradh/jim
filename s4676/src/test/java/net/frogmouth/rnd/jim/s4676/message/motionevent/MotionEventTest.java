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
import java.util.List;
import net.frogmouth.rnd.jim.s4676.NitsRoot;
import net.frogmouth.rnd.jim.s4676.Parser;
import net.frogmouth.rnd.jim.s4676.common.CertaintyStatisticType;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.message.TrackMessage;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class MotionEventTest {

    public MotionEventTest() {}

    @Test
    public void testMotionEvent() throws JsonProcessingException {
        MotionEvent uut = new MotionEvent(MotionEventType.ENTERING_ROI, 21477000000L);
        uut.setLid(123L);
        uut.setConfidence(new Confidence(CertaintyStatisticType.PROBABILITY, 65));
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
        System.out.println(serialisedXml);
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
        assertEquals(motionEvent.getType(), MotionEventType.ENTERING_ROI);
        assertNull(motionEvent.getUid());
        assertEquals(motionEvent.getLid(), 123L);
        assertNotNull(motionEvent.getConfidence());
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
