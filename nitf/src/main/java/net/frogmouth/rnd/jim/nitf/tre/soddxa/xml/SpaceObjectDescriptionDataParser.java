package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;

public class SpaceObjectDescriptionDataParser {

    private final XmlMapper mapper;

    /** Constructor. */
    public SpaceObjectDescriptionDataParser() {

        mapper =
                XmlMapper.builder(new NamespaceXmlFactory())
                        .defaultUseWrapper(false)
                        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                        .enable(SerializationFeature.INDENT_OUTPUT)
                        .build();
        mapper.registerModule(new JavaTimeModule());
        registerDeserialisers(mapper);
    }

    /**
     * Parse XML string into a SpaceObjectDescriptionData object.
     *
     * @param xml the XML to parse.
     * @return the corresponding SpaceObjectDescriptionData object.
     * @throws JsonProcessingException if parsing fails
     * @throws IOException if the XML is not valid.
     */
    public SpaceObjectDescriptionData parse(String xml)
            throws JsonProcessingException, IOException {
        SpaceObjectDescriptionData rootElement =
                mapper.readValue(xml, SpaceObjectDescriptionData.class);
        return rootElement;
    }

    /**
     * Serialise a SpaceObjectDescriptionData object to XML.
     *
     * @param rootElement the root object to serialise
     * @return the corresponding XML, as a String.
     * @throws JsonProcessingException if serialisation fails.
     */
    public String serialise(SpaceObjectDescriptionData rootElement) throws JsonProcessingException {
        return mapper.writeValueAsString(rootElement);
    }

    private void registerDeserialisers(XmlMapper mapper) {
        SimpleModule module = new SimpleModule();
        mapper.registerModule(module);
    }
}
