package net.frogmouth.rnd.jim.nitf.image;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

public class ImageLocation {

    private static final int RRRRR_LEN = 5;
    private static final int CCCCC_LEN = 5;
    private int rowOffset;
    private int columnOffset;

    byte[] asBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(WriterUtils.toBCS_N(rowOffset, RRRRR_LEN));
        baos.writeBytes(WriterUtils.toBCS_N(columnOffset, CCCCC_LEN));
        return baos.toByteArray();
    }
}
