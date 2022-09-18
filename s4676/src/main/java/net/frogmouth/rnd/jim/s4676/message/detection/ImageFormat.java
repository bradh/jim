package net.frogmouth.rnd.jim.s4676.message.detection;
/**
 * Image format.
 *
 * <p>Internet Assigned Numbers Authority (IANA) image media subtype specifying the image type.
 *
 * <p>Note: MISB ST 0903.4 limits image type to "jpeg" and "png". The jpeg and png image types are
 * chosen because they are common formats for compressing a still image. The most significant
 * advantage of jpeg is that it is ubiquitous. A disadvantage is that it is lossy, although the
 * degree of compression (and, hence, quality) is adjustable. The primary advantage of png is that
 * it is lossless. Moreover, it provides RGB bit depths up to 48 bits per pixel (16 bits per color
 * component) and, therefore provides a format that can preserve “raw” pixel values.
 */
public enum ImageFormat implements IImageFormat {
    /**
     * JPEG.
     *
     * <p>Corresponds to {@code image/jpeg}.
     */
    JPEG,
    /**
     * PNG.
     *
     * <p>Corresponds to {@code image/png}.
     */
    PNG,
}
