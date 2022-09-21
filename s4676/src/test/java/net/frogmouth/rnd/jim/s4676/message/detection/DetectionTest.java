package net.frogmouth.rnd.jim.s4676.message.detection;

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
import net.frogmouth.rnd.jim.s4676.common.CoordinateSystemType;
import net.frogmouth.rnd.jim.s4676.common.Dimensionality;
import net.frogmouth.rnd.jim.s4676.common.PositionPoints;
import net.frogmouth.rnd.jim.s4676.message.TrackMessage;
import net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation.DynamicSourceInformation;
import net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation.RadarInformation;
import net.frogmouth.rnd.jim.s4676.message.tracksource.TrackSource;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class DetectionTest {

    public DetectionTest() {}

    @Test
    public void testDetection() throws JsonProcessingException {
        Detection uut = new Detection();
        uut.setLid(128L);
        uut.setEsm(new ESM());
        uut.setSensorLID(808L);
        uut.setRelativeTime(8242);
        PositionPoints centroid =
                new PositionPoints(
                        Dimensionality.TWO_D,
                        CoordinateSystemType.WGS_84,
                        new Double[] {-35.4, 136.8});
        uut.addCentroid(centroid);
        TrackSource trackSource = new TrackSource();
        trackSource.addSensorLID(808L);
        uut.setSource(trackSource);
        NitsRoot rootElement = new NitsRoot();
        TrackMessage message =
                new TrackMessage(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC), 0.001);
        message.addDetection(uut);
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
                                                .getResourceAsStream("detection.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testParse() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("detection.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getMessages().get(0).getDetections());
        assertTrue(rootElement.getMessages().get(0).getDetections() instanceof List<Detection>);
        List<Detection> detections = rootElement.getMessages().get(0).getDetections();
        assertEquals(detections.size(), 1);
        Detection detection = detections.get(0);
        assertEquals(detection.getLid(), 128L);
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }

    @Test
    public void testDetectionRadar() throws JsonProcessingException {
        Detection uut = new Detection();
        uut.setLid(128L);
        Radar4607 radar = new Radar4607(3, (short) 0);
        uut.setRadar(radar);
        uut.setSensorLID(808L);
        uut.setDynSrcLID(367L);
        uut.setRelativeTime(8242);
        PositionPoints centroid =
                new PositionPoints(
                        Dimensionality.TWO_D,
                        CoordinateSystemType.WGS_84,
                        new Double[] {-35.4, 136.8});
        uut.addCentroid(centroid);
        TrackSource trackSource = new TrackSource();
        trackSource.addSensorLID(808L);
        uut.setSource(trackSource);
        NitsRoot rootElement = new NitsRoot();
        TrackMessage message =
                new TrackMessage(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC), 0.001);
        message.addDetection(uut);
        DynamicSourceInformation dynSrcInfo = new DynamicSourceInformation();
        dynSrcInfo.setLid(367L);
        dynSrcInfo.setRelativeTime(8108);
        dynSrcInfo.setSensorLID(808L);
        dynSrcInfo.setSensorLocation(
                new PositionPoints(
                        Dimensionality.THREE_D,
                        CoordinateSystemType.WGS_84,
                        new Double[] {-35.42, 126.81}));
        dynSrcInfo.setNumDetections(3);
        dynSrcInfo.setNumReportedDetections(1);
        RadarInformation sourceRadar = new RadarInformation(865, 0);
        dynSrcInfo.setSourceRadar(sourceRadar);
        message.addDynamicSourceInformation(dynSrcInfo);
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
                                                .getResourceAsStream("detection_gmti.xml")))
                        .ignoreWhitespace());
    }
}
