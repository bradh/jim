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
import java.util.UUID;
import net.frogmouth.rnd.jim.s4676.sensor.ModalityType;
import net.frogmouth.rnd.jim.s4676.sensor.SensorInformation;
import net.frogmouth.rnd.jim.s4676.tracker.TrackerInformation;
import net.frogmouth.rnd.jim.s4676.tracker.TrackerType;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class ProductIdentificationTest extends TestSupport {

    public ProductIdentificationTest() {}

    @Test
    public void testProductIdentification() throws JsonProcessingException {
        ProductIdentification uut =
                new ProductIdentification("Annex B-3", "System X Motion Imagery Track Product");
        uut.setShortName("XMTP");
        uut.setEffectivity("Ver 2022.1");
        NitsRoot rootElement = new NitsRoot();
        setJunkSecurity(rootElement);
        rootElement.setProduct(uut);
        rootElement.addProfile("STANDALONE");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(LocalDateTime.of(2022, Month.MAY, 6, 10, 28, 37), ZoneOffset.UTC));
        rootElement.setNitsVersion("B.1");
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
                                                .getResourceAsStream(
                                                        "productidentification_1.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testParse() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("productidentification_1.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getProduct());
        assertTrue(rootElement.getProduct() instanceof ProductIdentification);
        ProductIdentification product = rootElement.getProduct();
        assertEquals(product.getId(), "Annex B-3");
        assertEquals(product.getName(), "System X Motion Imagery Track Product");
        assertEquals(product.getShortName(), "XMTP");
        assertEquals(product.getEffectivity(), "Ver 2022.1");
        assertNull(product.getUniqueID());
        assertNull(product.getLid());
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }

    @Test
    public void testProductIdentificationWithUidLid() throws JsonProcessingException {
        ProductIdentification uut =
                new ProductIdentification("Annex B-3", "System X Motion Imagery Track Product");
        uut.setShortName("XMTP");
        uut.setEffectivity("Ver 2022.1");
        uut.setLid(287L);
        uut.setUidFromUUID(UUID.fromString("a0d50939-3ef0-442e-9664-dffba9b86cb1"));
        NitsRoot rootElement = new NitsRoot();
        setJunkSecurity(rootElement);
        rootElement.setProduct(uut);
        SensorInformation sensorInformation =
                new SensorInformation("test sensor", ModalityType.OTHER);
        rootElement.addSensor(sensorInformation);
        TrackerInformation trackerInformation =
                new TrackerInformation(TrackerType.SEMIAUTOMATIC_TRACKER, "test tracker", "0.1");
        rootElement.addTracker(trackerInformation);
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
                                                .getResourceAsStream(
                                                        "productidentification_2.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testParse2() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("productidentification_2.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getProduct());
        assertTrue(rootElement.getProduct() instanceof ProductIdentification);
        ProductIdentification product = rootElement.getProduct();
        assertEquals(
                product.getUniqueIDAsUUID(),
                UUID.fromString("a0d50939-3ef0-442e-9664-dffba9b86cb1"));
        assertEquals(product.getLid(), 287L);
        assertEquals(product.getId(), "Annex B-3");
        assertEquals(product.getName(), "System X Motion Imagery Track Product");
        assertEquals(product.getShortName(), "XMTP");
        assertEquals(product.getEffectivity(), "Ver 2022.1");
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
