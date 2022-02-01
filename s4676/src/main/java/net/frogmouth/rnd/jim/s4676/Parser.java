package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;

public class Parser {
    private final XmlMapper mapper;

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

    public NitsRoot parse(String xml) throws JsonProcessingException, IOException {
        NitsRoot rootElement = mapper.readValue(xml, NitsRoot.class);
        return rootElement;
    }

    public String serialise(NitsRoot rootElement) throws JsonProcessingException {
        return mapper.writeValueAsString(rootElement);
    }
}
