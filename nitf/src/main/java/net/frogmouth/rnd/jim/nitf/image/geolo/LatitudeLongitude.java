package net.frogmouth.rnd.jim.nitf.image.geolo;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class LatitudeLongitude {

    private final double latitude;
    private final double longitude;
    private static final int LATITUDE_FORMAT_LEN = 7;
    private static final int LONGITUDE_FORMAT_LEN = 8;

    public LatitudeLongitude(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public byte[] asBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(encode(latitude, LATITUDE_FORMAT_LEN));
        baos.writeBytes(encode(longitude, LONGITUDE_FORMAT_LEN));
        return baos.toByteArray();
    }

    private byte[] encode(double value, int numCharacters) {
        String s = String.format("%+0" + numCharacters + ".3f", value);
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length != numCharacters) {
            throw new IllegalStateException("Incorrect encoding implementation (internal error)");
        }
        return bytes;
    }
}
