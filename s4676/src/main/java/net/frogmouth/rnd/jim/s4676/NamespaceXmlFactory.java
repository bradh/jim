package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

class NamespaceXmlFactory extends XmlFactory {

    private final String defaultNamespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1";
    private final Map<String, String> additionalNamespaces = new HashMap<>();

    public NamespaceXmlFactory() {
        additionalNamespaces.put("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        additionalNamespaces.put("sec", "urn:nato:stanag:4774:confidentialitymetadatalabel:1:0");
    }

    @Override
    protected XMLStreamWriter _createXmlWriter(IOContext ctxt, Writer w) throws IOException {
        XMLStreamWriter writer = super._createXmlWriter(ctxt, w);
        try {
            writer.setDefaultNamespace(defaultNamespace);
            for (Map.Entry<String, String> e : additionalNamespaces.entrySet()) {
                writer.setPrefix(e.getKey(), e.getValue());
            }
        } catch (XMLStreamException e) {
            StaxUtil.throwAsGenerationException(e, null);
        }
        return writer;
    }
}
