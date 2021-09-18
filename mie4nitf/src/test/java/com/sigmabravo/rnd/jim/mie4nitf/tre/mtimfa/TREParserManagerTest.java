package com.sigmabravo.rnd.jim.mie4nitf.tre.mtimfa;

import com.sigmabravo.rnd.jim.nitf.tre.TREParserManager;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TREParserManagerTest {

    public TREParserManagerTest() {}

    @Test
    public void parserDiscovery() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("MTIMFA") instanceof MTIMFAParser);
    }
}
