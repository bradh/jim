package net.frogmouth.rnd.jim.ccinfa.tre;

import net.frogmouth.rnd.jim.ccinfa.tre.CCINFAParser;
import net.frogmouth.rnd.jim.nitf.tre.TREParserManager;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TREParserManagerTest {

    public TREParserManagerTest() {}

    @Test
    public void parserDiscovery() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("CCINFA") instanceof CCINFAParser);
    }
}
