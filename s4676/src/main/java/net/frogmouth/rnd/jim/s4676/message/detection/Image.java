package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.serde.IntegerArrayDeserializer;
import net.frogmouth.rnd.jim.s4676.serde.IntegerArraySerialiser;
import net.frogmouth.rnd.jim.s4676.serde.SupplementalDeserialisationInfo;

/**
 * Image.
 *
 * <p>The Image class provides details of a single detection derived from imagery.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"chip", "pixelMask", "centroidPixel", "color"})
public class Image {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ImageChip chip;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private PixelMask pixelMask;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonSerialize(using = IntegerArraySerialiser.class)
    @JsonDeserialize(using = IntegerArrayDeserializer.class)
    @SupplementalDeserialisationInfo(elementName = "centroidPixel")
    private Integer[] centroidPixel;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private byte[] color;

    /** Constructor. */
    public Image() {}

    /**
     * Image chip.
     *
     * <p>Provides an embedded or linked JPEG or PNG image chip of an object being tracked.
     *
     * @return the image chip, or null if not set.
     */
    public ImageChip getChip() {
        return chip;
    }

    /**
     * Set the image chip.
     *
     * <p>Provides an embedded or linked JPEG or PNG image chip of an object being tracked.
     *
     * @param chip the image chip
     */
    public void setChip(ImageChip chip) {
        this.chip = chip;
    }

    /**
     * Pixel mask.
     *
     * <p>The pixel mask identifies the pixels within a motion imagery frame that are subtended by
     * the detected object.
     *
     * <p>This can be specified by either (1) a series of pixel numbers that represent the vertices
     * of a polygon encompassing the object, or (2) a bit mask that identifies the pixels subtended
     * by the target.
     *
     * <p>In contrast to the outline attribute in TrackPoint, which specifies a polygon using
     * double-precision coordinates of any coordinate system, the PixelMask polygon specifies
     * coordinates in integer pixel space. Also, the PixelMask bit mask can provide a more refined
     * description of the pixels subtended by the object.
     *
     * <p>Reference: VMask Local Set in MISB ST 0903.4.
     *
     * @return the pixel mask, or null if not set.
     */
    public PixelMask getPixelMask() {
        return pixelMask;
    }

    /**
     * Set the pixel mask.
     *
     * <p>The pixel mask identifies the pixels within a motion imagery frame that are subtended by
     * the detected object.
     *
     * <p>This can be specified by either (1) a series of pixel numbers that represent the vertices
     * of a polygon encompassing the object, or (2) a bit mask that identifies the pixels subtended
     * by the target.
     *
     * <p>In contrast to the outline attribute in TrackPoint, which specifies a polygon using
     * double-precision coordinates of any coordinate system, the PixelMask polygon specifies
     * coordinates in integer pixel space. Also, the PixelMask bit mask can provide a more refined
     * description of the pixels subtended by the object.
     *
     * <p>Reference: VMask Local Set in MISB ST 0903.4.
     *
     * @param pixelMask the pixel mask.
     */
    public void setPixelMask(PixelMask pixelMask) {
        this.pixelMask = pixelMask;
    }

    /**
     * Centroid pixel.
     *
     * <p>The pixel that is at the centre of this piece of evidence, specified by its x- and
     * y-coordinates on the image. The top-left pixel in a frame corresponds to (row, column) =
     * (0,0). The order of this list of integers is [row, column].
     *
     * @return the centroid pixel
     */
    public Integer[] getCentroidPixel() {
        return centroidPixel;
    }

    /**
     * Set the centroid pixel.
     *
     * <p>The pixel that is at the centre of this piece of evidence, specified by its x- and
     * y-coordinates on the image. The top-left pixel in a frame corresponds to (row, column) =
     * (0,0). The order of this list of integers is [row, column].
     *
     * @param centroidPixel the centroid pixel
     */
    public void setCentroidPixel(Integer[] centroidPixel) {
        this.centroidPixel = centroidPixel;
    }

    /**
     * Colour.
     *
     * <p>The dominant colour of the tracked object, expressed using 3 RGB colour values. A general
     * mapping of any multispectral dataset to an RGB value.
     *
     * <p>Reference: Target Color in MISB ST 0903.4.
     *
     * @return the colour as an RGB triple
     */
    public byte[] getColor() {
        return color;
    }

    /**
     * Set the colour.
     *
     * <p>The dominant colour of the tracked object, expressed using 3 RGB colour values. A general
     * mapping of any multispectral dataset to an RGB value.
     *
     * <p>Reference: Target Color in MISB ST 0903.4.
     *
     * @param color the colour as an RGB triple
     */
    public void setColor(byte[] color) {
        this.color = color;
    }
}
