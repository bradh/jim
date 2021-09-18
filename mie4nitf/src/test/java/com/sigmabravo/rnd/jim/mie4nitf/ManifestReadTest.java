package com.sigmabravo.rnd.jim.mie4nitf;

import com.sigmabravo.rnd.jim.nitf.Reader;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

/** Basic tests for Reader. */
public class ManifestReadTest extends TestSupport {

    public ManifestReadTest() {}

    @Test
    public void mie4nitfManifest() throws IOException {
        Reader reader = new Reader(getMIE4NITFManifestTestData());
        assertTrue(reader.isNitf());
        assertEquals(reader.getCLEVEL(), 3);
        assertEquals(reader.getOSTAID(), "MRDC      ");
        assertEquals(reader.getFileDateTime(), "20181101160919");
        assertEquals(reader.getONAME(), "                        ");
        assertEquals(reader.getOPHONE(), "                  ");
        assertEquals(reader.getNumberOfImageSegments(), 0);
        assertEquals(reader.getNumberOfGraphicSegments(), 0);
        assertEquals(reader.getNumberOfTextSegments(), 1);
        assertEquals(reader.getNumberOfDES(), 0);
        assertEquals(reader.getUserDefinedHeaderData().length, 1380);
        assertEquals(
                reader.getTextSegmentBody(0),
                "wpr-h264.r0t0q0c0i0.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i1.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i1.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i1.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i1.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i2.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i2.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i2.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i2.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i3.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i3.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i3.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i3.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i4.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i4.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i4.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i4.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i5.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i5.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i5.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i5.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i6.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i6.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i6.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i6.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i7.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i7.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i7.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i7.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i8.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i8.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i8.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i8.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i9.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i9.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i9.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i9.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i10.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i10.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i10.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i10.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i11.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i11.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i11.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i11.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i12.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i12.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i12.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i12.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i13.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i13.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i13.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i13.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i14.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i14.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i14.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i14.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i15.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i15.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i15.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i15.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i16.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i16.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i16.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i16.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i17.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i17.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i17.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i17.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i18.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i18.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i18.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i18.NTF\r\n"
                        + "wpr-h264.r0t0q0c1i19.NTF\r\n"
                        + "wpr-h264.r1t0q0c1i19.NTF\r\n"
                        + "wpr-h264.r2t0q0c1i19.NTF\r\n"
                        + "wpr-h264.r3t0q0c1i19.NTF\r\n");
    }
}
