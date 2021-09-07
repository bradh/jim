package com.sigmabravo.rnd.jim.nitf.tre;

import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.nitf.tre.camsda.CAMSDAParser;
import org.testng.annotations.Test;

/** Unit tests for TREParserManager. */
public class TREParserManagerTest {

    public TREParserManagerTest() {}

    @Test
    public void camsda() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("CAMSDA") instanceof CAMSDAParser);
    }

    @Test
    public void mimcsa() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("MIMCSA") instanceof MIMCSAParser);
    }

    @Test
    public void tminta() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("TMINTA") instanceof TMINTAParser);
    }
}
