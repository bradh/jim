package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Image chip.
 *
 * <p>An image "chip" of a moving object, generally extracted from a frame of the source motion
 * imagery. The image must be one of the Internet Assigned Numbers Authority (IANA) image media
 * subtypes.
 *
 * <p>The image chip may be “embedded” within the Track Message. (However, XML encoding does not
 * lend itself to inclusion of such binary data.)
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uri", "image"})
public class ImageChip {
    @JacksonXmlProperty(isAttribute = true)
    private IImageFormat type;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String uri;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private byte[] image;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Provide either the URI or image along with the format.
     */
    private ImageChip() {}

    /**
     * Constructor.
     *
     * @param type the image format
     * @param uri the URI
     */
    public ImageChip(IImageFormat type, String uri) {
        this.type = type;
        this.uri = uri;
    }

    /**
     * Constructor.
     *
     * @param type the image format
     * @param image the image chip as a byte array
     */
    public ImageChip(IImageFormat type, byte[] image) {
        this.type = type;
        this.image = image;
    }

    /**
     * Image format.
     *
     * <p>Internet Assigned Numbers Authority (IANA) image media subtype specifying the image type.
     *
     * <p>Note: MISB ST 0903.4 limits image type to "jpeg" and "png". The jpeg and png image types
     * are chosen because they are common formats for compressing a still image. The most
     * significant advantage of jpeg is that it is ubiquitous. A disadvantage is that it is lossy,
     * although the degree of compression (and, hence, quality) is adjustable. The primary advantage
     * of png is that it is lossless. Moreover, it provides RGB bit depths up to 48 bits per pixel
     * (16 bits per colour component) and, therefore provides a format that can preserve “raw” pixel
     * values.
     *
     * <p>Unless extended, this will be one of the values from {@link ImageFormat}.
     *
     * @return the image format.
     */
    public IImageFormat getType() {
        return type;
    }

    /**
     * Image URI.
     *
     * <p>A Uniform Resource Identifier (URI) or a Uniform Resource Locator (URL) that refers to an
     * image of the type specified by the type attribute of this class, stored on a network or a
     * file system.
     *
     * @return the URI/URL as a String.
     */
    public String getUri() {
        return uri;
    }

    /**
     * Image content.
     *
     * <p>An image implemented in compliance with the IANA media image subtype specified by the type
     * attribute of this class.
     *
     * @return the image as a byte array.
     */
    public byte[] getImage() {
        return image;
    }
}
