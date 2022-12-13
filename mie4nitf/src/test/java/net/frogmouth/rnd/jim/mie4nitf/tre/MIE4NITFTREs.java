package net.frogmouth.rnd.jim.mie4nitf.tre;

import static org.testng.Assert.assertEquals;

import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;
import net.frogmouth.rnd.jim.nitf.Reader;
import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.mie4nitf.TestSupport;
import org.testng.annotations.Test;

/** Basic tests for Reader. */
public class MIE4NITFTREs extends TestSupport {

    public MIE4NITFTREs() {}

    @Test
    public void mie4nitfManifest() throws IOException {
        Reader reader = new Reader(getMIE4NITFManifestTestData());
        byte[] udhd = reader.getUserDefinedHeaderData();
        assertEquals(udhd.length, 1380);
        List<TaggedRecordExtension> tres = reader.getFileTREs();
        assertEquals(tres.size(), 3);
    }
}
