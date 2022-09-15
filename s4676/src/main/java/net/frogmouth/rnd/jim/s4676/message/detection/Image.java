package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Image.
 *
 * <p>The Image class provides details of a single detection derived from imagery.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"chip", "pixelMask", "centroidPixel", "color"})
public class Image {
    // TODO: private ImageChip chip;
    // TODO: pixelMask
    // TODO: centroidPixel
    // TODO: color

    /** Constructor. */
    public Image() {}

    // TODO: getters and setters.
}
