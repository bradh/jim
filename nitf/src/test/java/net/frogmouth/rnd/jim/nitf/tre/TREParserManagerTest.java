package net.frogmouth.rnd.jim.nitf.tre;

import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.nitf.tre.blocka.BLOCKAParser;
import net.frogmouth.rnd.jim.nitf.tre.engrda.ENGRDAParser;
import org.testng.annotations.Test;

/** Unit tests for TREParserManager. */
public class TREParserManagerTest {

    public TREParserManagerTest() {}

    @Test
    public void blocka() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("BLOCKA") instanceof BLOCKAParser);
    }

    @Test
    public void engrda() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("ENGRDA") instanceof ENGRDAParser);
    }
}
