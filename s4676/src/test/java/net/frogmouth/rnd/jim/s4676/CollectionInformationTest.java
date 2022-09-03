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
import net.frogmouth.rnd.jim.s4676.enumeration.CollectionEssenceType;
import net.frogmouth.rnd.jim.s4676.enumeration.CollectionIntentType;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class CollectionInformationTest {

    public CollectionInformationTest() {}

    @Test
    public void testCollectionInformation() throws JsonProcessingException {
        CollectionInformation uut =
                new CollectionInformation(
                        CollectionIntentType.ENGINEERING, CollectionEssenceType.SYNTHETIC);
        uut.setLid(8L);
        uut.setTargetId("Target1234-345");
        NitsRoot rootElement = new NitsRoot();
        rootElement.addCollection(uut);
        rootElement.addProfile("STANDALONE");
        rootElement.setMsgCreatedTime(
                ZonedDateTime.of(
                        LocalDateTime.of(2022, Month.SEPTEMBER, 3, 1, 52, 30), ZoneOffset.UTC));
        rootElement.setNitsVersion("B.2");
        String serialisedXml = new Parser().serialise(rootElement);
        System.out.println(serialisedXml);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(
                                Input.fromStream(
                                        getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("collectionInformation.xml")))
                        .ignoreWhitespace());
    }

    @Test
    public void testParse() throws IOException {
        Parser parser = new Parser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("collectionInformation.xml")
                                .readAllBytes());
        NitsRoot rootElement = parser.parse(xml);
        assertNotNull(rootElement.getCollections());
        assertTrue(rootElement.getCollections() instanceof List<CollectionInformation>);
        List<CollectionInformation> collections = rootElement.getCollections();
        assertEquals(collections.size(), 1);
        CollectionInformation collection = collections.get(0);
        assertNull(collection.getUid());
        assertEquals(collection.getLid(), 8L);
        assertEquals(collection.getTargetId(), "Target1234-345");
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
