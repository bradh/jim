package net.frogmouth.rnd.jim.nitf.image.geolo;

public abstract class ImageCoordinates {

    /**
     * Get the image coordinates as bytes.
     *
     * <p>This is the encoded values of ICORDS and IGEOLO (if applicable) fields in the image
     * segment subheader.
     *
     * @return the byte array encoding
     */
    public abstract byte[] toBytes();

    /**
     * Coordinate representation (ICORDS).
     *
     * <p>Indicates the type of coordinate coordinateRepresentation used.
     *
     * @return the coordinate coordinateRepresentation
     */
    public abstract CoordinateRepresentation getCoordinateRepresentation();
}
