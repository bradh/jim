package net.frogmouth.rnd.jim.s4676.product;

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
import net.frogmouth.rnd.jim.s4676.NitsRoot;
import net.frogmouth.rnd.jim.s4676.Parser;
import net.frogmouth.rnd.jim.s4676.ProductIdentification;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class ProductIdentificationTest {

    public ProductIdentificationTest() {}

    @Test
    public void testProductIdentification() throws JsonProcessingException {
        ProductIdentification uut =
                new ProductIdentification("Annex B-3", "System X Motion Imagery Track Product");
        uut.setShortName("XMTP");
        uut.setEffectivity("Ver 2022.1");
        NitsRoot rootElement = new NitsRoot();
        rootElement.setProduct(uut);
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
        assertNull(product.getUid());
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
        rootElement.setProduct(uut);
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
                product.getUidAsUUID(), UUID.fromString("a0d50939-3ef0-442e-9664-dffba9b86cb1"));
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
