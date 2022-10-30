package net.frogmouth.rnd.jim.nitf.image;

import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IFC_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IMFLT_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IREPBAND_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ISUBCAT_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.NLUTS_LEN;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

public class ImageSegmentBand {

    private String bandRepresentation = "";
    private String subCategory = "";
    private String imageFilterCondition = "N";
    private String imageFilterCode = "";
    private List<LookupTable> luts = new ArrayList<>();

    public byte[] asBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(WriterUtils.toBCS_A(bandRepresentation, IREPBAND_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(subCategory, ISUBCAT_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(imageFilterCondition, IFC_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(imageFilterCode, IMFLT_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(luts.size(), NLUTS_LEN));
        // TODO: NELUTS / LUTD
        return baos.toByteArray();
    }
}
