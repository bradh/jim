package com.sigmabravo.rnd.jim.nitf.tre.illumb;

import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.nitf.tre.TREParserManager;
import org.testng.annotations.Test;

public class ServiceLoaderTest {

    public ServiceLoaderTest() {}

    @Test
    public void matesa() {
        TREParserManager tpm = TREParserManager.getInstance();
        assertTrue(tpm.getParser("ILLUMB") instanceof ILLUMBParser);
    }
}
