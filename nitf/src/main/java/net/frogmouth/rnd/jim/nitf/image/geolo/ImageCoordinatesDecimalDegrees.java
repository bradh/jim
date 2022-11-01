package net.frogmouth.rnd.jim.nitf.image.geolo;

import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ICORDS_LEN;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

public class ImageCoordinatesDecimalDegrees extends ImageCoordinates {
    private final LatitudeLongitude upperLeft;
    private final LatitudeLongitude upperRight;
    private final LatitudeLongitude lowerRight;
    private final LatitudeLongitude lowerLeft;

    public ImageCoordinatesDecimalDegrees(
            LatitudeLongitude upperLeft,
            LatitudeLongitude upperRight,
            LatitudeLongitude lowerRight,
            LatitudeLongitude lowerLeft) {
        this.upperLeft = upperLeft;
        this.upperRight = upperRight;
        this.lowerRight = lowerRight;
        this.lowerLeft = lowerLeft;
    }

    @Override
    public byte[] toBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(
                WriterUtils.toBCS_A(getCoordinateRepresentation().getEncodedValue(), ICORDS_LEN));
        baos.writeBytes(upperLeft.asBytes());
        baos.writeBytes(upperRight.asBytes());
        baos.writeBytes(lowerRight.asBytes());
        baos.writeBytes(lowerLeft.asBytes());
        return baos.toByteArray();
    }

    @Override
    public CoordinateRepresentation getCoordinateRepresentation() {
        return CoordinateRepresentation.DecimalDegrees;
    }
}
