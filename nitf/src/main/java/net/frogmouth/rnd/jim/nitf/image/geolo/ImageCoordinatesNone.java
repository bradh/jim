package net.frogmouth.rnd.jim.nitf.image.geolo;

import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ICORDS_LEN;

import net.frogmouth.rnd.jim.nitf.WriterUtils;

public class ImageCoordinatesNone extends ImageCoordinates {

    @Override
    public byte[] toBytes() {
        return WriterUtils.toBCS_A(CoordinateRepresentation.None.getEncodedValue(), ICORDS_LEN);
    }

    @Override
    public CoordinateRepresentation getCoordinateRepresentation() {
        return CoordinateRepresentation.None;
    }
}
