package com.sigmabravo.rnd.jim.nitf;

import static org.testng.Assert.assertEquals;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

/** Basic tests for Reader. */
public class MIE4NITFTREs extends TestSupport {

    public MIE4NITFTREs() {}

    @Test
    public void mie4nitfManifest() throws IOException {
        Reader reader = new Reader(getMIE4NITFManifestTestData());
        byte[] udhd = reader.getUserDefinedHeaderData();
        assertEquals(udhd.length, 1380);
        List<TRE> tres = reader.getFileTREs();
        assertEquals(tres.size(), 3);
    }
}
