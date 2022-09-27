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
import net.frogmouth.rnd.jim.s4676.common.CertaintyStatisticType;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.CoordinateSystemType;
import net.frogmouth.rnd.jim.s4676.common.Dimensionality;
import net.frogmouth.rnd.jim.s4676.common.PositionPoints;
import net.frogmouth.rnd.jim.s4676.message.TrackMessage;
import net.frogmouth.rnd.jim.s4676.message.TrackSource;
import net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation.DynamicSourceInformation;
import net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation.RadarInformation;
import net.frogmouth.rnd.jim.s4676.message.sensormeasurement.MeasurementMethod;
import net.frogmouth.rnd.jim.s4676.message.sensormeasurement.MeasurementType;
import net.frogmouth.rnd.jim.s4676.message.sensormeasurement.SensorMeasurement;
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
        // System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("detection_gmti.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testDetectionMotionImageryPixelRun() throws JsonProcessingException {
        Detection uut = new Detection();
        uut.setLid(128L);
        Image im = new Image();
        im.setCentroidPixel(new Integer[] {4, 3});
        PixelMask pixelMask = new PixelMask();
        PixelRun pixelRun = new PixelRun();
        pixelRun.addColumnSequence(new Integer[] {2, 3, 5});
        pixelRun.addRowSequence(new Integer[] {3, 1, 6});
        pixelRun.addRowSequence(new Integer[] {4, 3, 3});
        pixelMask.setPixelRun(pixelRun);
        im.setPixelMask(pixelMask);
        ImageChip chip = new ImageChip(ImageFormat.PNG, "https://github.com/bradh/jim/");
        im.setChip(chip);
        uut.setImage(im);
        uut.setSensorLID(808L);
        uut.setRelativeTime(8242);
        Confidence confidence = new Confidence(CertaintyStatisticType.PROBABILITY, 60);
        uut.setConfidence(confidence);
        SensorMeasurement sensorMeasurement1 =
                new SensorMeasurement(MeasurementType.SNR, MeasurementMethod.MEAN, 12.3);
        uut.addSensorMeasurement(sensorMeasurement1);
        SensorMeasurement sensorMeasurement2 =
                new SensorMeasurement(MeasurementType.RADIANCE, MeasurementMethod.MAX, 0.3);
        uut.addSensorMeasurement(sensorMeasurement2);
        PositionPoints centroid =
                new PositionPoints(
                        Dimensionality.TWO_D,
                        CoordinateSystemType.WGS_84,
                        new Double[] {-35.4, 136.8});
        uut.addCentroid(centroid);
        PositionPoints centroid3d =
                new PositionPoints(
                        Dimensionality.THREE_D,
                        CoordinateSystemType.WGS_84,
                        new Double[] {-35.4, 136.8, 653.2});
        uut.addCentroid(centroid3d);
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
                                                .getResourceAsStream(
                                                        "detection_motionimagery_pixel_run.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testRoundTripMotionImageryPixelRun() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("detection_motionimagery_pixel_run.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getMessages().get(0).getDetections());
        assertTrue(rootElement.getMessages().get(0).getDetections() instanceof List<Detection>);
        List<Detection> detections = rootElement.getMessages().get(0).getDetections();
        assertEquals(detections.size(), 1);
        Detection detection = detections.get(0);
        assertNotNull(detection);
        Image image = detection.getImage();
        assertNotNull(image);
        assertEquals(image.getCentroidPixel(), new Integer[] {4, 3});
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }

    @Test
    public void testDetectionMotionImageryPixelPolygon() throws JsonProcessingException {
        Detection uut = new Detection();
        uut.setLid(128L);
        Image im = new Image();
        im.setCentroidPixel(new Integer[] {4, 3});
        PixelMask pixelMask = new PixelMask();
        PixelPolygon pixelPolygon = new PixelPolygon();
        pixelPolygon.setNumRings(1);
        pixelPolygon.addCoordinate(3, 1);
        pixelPolygon.addCoordinate(3, 3);
        pixelPolygon.addCoordinate(2, 3);
        pixelPolygon.addCoordinate(3, 3);
        pixelPolygon.addCoordinate(3, 6);
        pixelPolygon.addCoordinate(3, 5);
        pixelPolygon.addCoordinate(4, 5);
        pixelPolygon.addCoordinate(4, 3);
        pixelPolygon.addCoordinate(6, 3);
        pixelPolygon.addCoordinate(3, 3);
        pixelMask.setPixelPolygon(pixelPolygon);
        im.setPixelMask(pixelMask);
        uut.setImage(im);
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
                                                .getResourceAsStream(
                                                        "detection_motionimagery_pixel_polygon.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testRoundTripMotionImageryPixelPolygon() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("detection_motionimagery_pixel_polygon.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getMessages().get(0).getDetections());
        assertTrue(rootElement.getMessages().get(0).getDetections() instanceof List<Detection>);
        List<Detection> detections = rootElement.getMessages().get(0).getDetections();
        assertEquals(detections.size(), 1);
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
