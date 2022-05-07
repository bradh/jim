package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;

/**
 * Parser and Serialiser for AEDP-12 Edition B formatted files.
 *
 * <p>The concept is that you create the Parser, then provide either XML to parse into a NitsRoot
 * object, or provide a NitsRoot object to serialise out to XML.
 *
 * @author bradh
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
}
