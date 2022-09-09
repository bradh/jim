package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import net.frogmouth.rnd.jim.s4676.collection.CollectionEssenceTypeDeserialiser;
import net.frogmouth.rnd.jim.s4676.collection.CollectionIntentTypeDeserialiser;
import net.frogmouth.rnd.jim.s4676.collection.ICollectionEssenceType;
import net.frogmouth.rnd.jim.s4676.collection.ICollectionIntentType;
import net.frogmouth.rnd.jim.s4676.common.CoordinateSystemTypeDeserialiser;
import net.frogmouth.rnd.jim.s4676.common.ICoordinateSystemType;
import net.frogmouth.rnd.jim.s4676.message.motionevent.IMotionEventType;
import net.frogmouth.rnd.jim.s4676.message.motionevent.MotionEventTypeDeserialiser;
import net.frogmouth.rnd.jim.s4676.message.processedtrack.IProcessedTrackType;
import net.frogmouth.rnd.jim.s4676.message.processedtrack.ProcessedTrackTypeDeserialiser;
import net.frogmouth.rnd.jim.s4676.message.tracklinkage.ITrackLinkageType;
import net.frogmouth.rnd.jim.s4676.message.tracklinkage.TrackLinkageTypeDeserialiser;
import net.frogmouth.rnd.jim.s4676.sensor.IModalityType;
import net.frogmouth.rnd.jim.s4676.sensor.ModalityTypeDeserialiser;
import net.frogmouth.rnd.jim.s4676.tracker.ISupplementaryDataType;
import net.frogmouth.rnd.jim.s4676.tracker.ITrackerType;
import net.frogmouth.rnd.jim.s4676.tracker.SupplementaryDataTypeDeserialiser;
import net.frogmouth.rnd.jim.s4676.tracker.TrackerTypeDeserialiser;

/**
 * Parser and Serialiser for AEDP-12 Edition B formatted files.
 *
 * <p>The concept is that you create the Parser, then provide either XML to parse into a NitsRoot
 * object, or provide a NitsRoot object to serialise out to XML.
 */
public class Parser {
    private final XmlMapper mapper;

    /** Constructor. */
    public Parser() {
        mapper =
                XmlMapper.builder()
                        .defaultUseWrapper(false)
                        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                        .enable(SerializationFeature.INDENT_OUTPUT)
                        .build();
        mapper.registerModule(new JavaTimeModule());
        registerDeserialisers(mapper);
    }

    /**
     * Parse XML string into a NitsRoot object.
     *
     * @param xml the XML to parse.
     * @return the corresponding NitsRoot object.
     * @throws JsonProcessingException if parsing fails
     * @throws IOException if the XML is not valid.
     */
    public NitsRoot parse(String xml) throws JsonProcessingException, IOException {
        NitsRoot rootElement = mapper.readValue(xml, NitsRoot.class);
        return rootElement;
    }

    /**
     * Serialise a NitsRoot object to XML.
     *
     * @param rootElement the root object to serialise
     * @return the corresponding XML, as a String.
     * @throws JsonProcessingException if serialisation fails.
     */
    public String serialise(NitsRoot rootElement) throws JsonProcessingException {
        return mapper.writeValueAsString(rootElement);
    }

    private void registerDeserialisers(XmlMapper mapper) {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(
                ICollectionEssenceType.class, new CollectionEssenceTypeDeserialiser());
        module.addDeserializer(ICollectionIntentType.class, new CollectionIntentTypeDeserialiser());
        module.addDeserializer(ICoordinateSystemType.class, new CoordinateSystemTypeDeserialiser());
        module.addDeserializer(IModalityType.class, new ModalityTypeDeserialiser());
        module.addDeserializer(IMotionEventType.class, new MotionEventTypeDeserialiser());
        module.addDeserializer(IProcessedTrackType.class, new ProcessedTrackTypeDeserialiser());
        module.addDeserializer(
                ISupplementaryDataType.class, new SupplementaryDataTypeDeserialiser());
        module.addDeserializer(ITrackLinkageType.class, new TrackLinkageTypeDeserialiser());
        module.addDeserializer(ITrackerType.class, new TrackerTypeDeserialiser());
        mapper.registerModule(module);
    }
}
