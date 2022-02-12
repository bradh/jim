package net.frogmouth.rnd.jim.ccinfa.tre;

import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.nitf.tre.TREParserManager;
import org.testng.annotations.Test;

public class TREParserManagerTest {

    public TREParserManagerTest() {}

    @Test
    public void parserDiscovery() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("CCINFA") instanceof CCINFAParser);
    }
}
