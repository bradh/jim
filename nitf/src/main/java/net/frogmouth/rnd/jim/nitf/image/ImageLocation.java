package net.frogmouth.rnd.jim.nitf.image;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

/**
 * Image location (ILOC).
 *
 * <p>This describes an image pixel location (in row/column).
 */
public class ImageLocation {

    private static final int RRRRR_LEN = 5;
    private static final int CCCCC_LEN = 5;
    private int rowOffset;
    private int columnOffset;

    /**
     * Serialise this image location to the corresponding byte array.
     *
     * @return the image location as bytes
     */
    byte[] asBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(WriterUtils.toBCS_N(rowOffset, RRRRR_LEN));
        baos.writeBytes(WriterUtils.toBCS_N(columnOffset, CCCCC_LEN));
        return baos.toByteArray();
    }
}
