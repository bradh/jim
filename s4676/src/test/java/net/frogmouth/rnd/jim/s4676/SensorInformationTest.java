package net.frogmouth.rnd.jim.s4676;

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
import net.frogmouth.rnd.jim.s4676.common.IDData;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class SensorInformationTest {

    public SensorInformationTest() {}

    @Test
    public void testSensorInformation() throws JsonProcessingException {
        SensorInformation uut = new SensorInformation("sensor 3", "AIS");
        uut.setLid(29L);
        uut.setSensorID(new IDData("SENSOR 3  ", "AUS"));
        uut.setCollectionMode("Channel A only");
        uut.setComment("Channel B antenna was offline for a while");
        uut.setDescription("Fixed surface AIS receiver at Pt Barren.");
        uut.setUrl("https://jericho.edgsespark.net/sensor3");
        NitsRoot rootElement = new NitsRoot();
        rootElement.addSensor(uut);
        rootElement.addProfile("STANDALONE");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(
                        LocalDateTime.of(2022, Month.SEPTEMBER, 1, 10, 43, 8), ZoneOffset.UTC));
        rootElement.setNitsVersion("B.1");
        String serialisedXml = new Parser().serialise(rootElement);
        System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("sensorInformation.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testParse() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("sensorInformation.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getSensors());
        assertTrue(rootElement.getSensors() instanceof List<SensorInformation>);
        List<SensorInformation> sensors = rootElement.getSensors();
        assertEquals(sensors.size(), 1);
        SensorInformation sensor = sensors.get(0);
        assertNotNull(sensor.getSensorID());
        assertEquals(sensor.getSensorID().getStationID(), "SENSOR 3  ");
        assertEquals(sensor.getSensorID().getStationID().length(), 10);
        assertEquals(sensor.getSensorID().getNationalityTrigraph(), "AUS");
        assertEquals(sensor.getName(), "sensor 3");
        assertEquals(sensor.getDescription(), "Fixed surface AIS receiver at Pt Barren.");
        assertEquals(sensor.getUrl(), "https://jericho.edgsespark.net/sensor3");
        assertEquals(sensor.getComment(), "Channel B antenna was offline for a while");
        assertEquals(sensor.getCollectionMode(), "Channel A only");
        assertNull(sensor.getUid());
        assertEquals(sensor.getLid(), 29L);
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
