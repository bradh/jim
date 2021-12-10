package net.frogmouth.rnd.jim.nitf.tre.csdida;

import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.nitf.tre.TREParserManager;
import org.testng.annotations.Test;

public class ServiceLoaderTest {

    public ServiceLoaderTest() {}

    @Test
    public void matesa() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("CSDIDA") instanceof CSDIDAParser);
    }
}
