package net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Radar Information.
 *
 * <p>The RadarInformation class specifies pointers into the source STANAG 4607 data for a single
 * revisit and dwell.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"revisitIndex", "dwellIndex"})
public class RadarInformation {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private int revisitIndex;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private int dwellIndex;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes the revisit and dwell indexes.
     */
    private RadarInformation() {}

    /**
     * Constructor.
     *
     * <p>The Radar Information requires revisit and dwell indexes.
     *
     * <p>The revisit index corresponds to field D2 in STANAG 4607 Edition 3 document. The
     * sequential count of a revisit of the bounding area in the last sent Job Definition Segment,
     * where a Revisit Index of 0 indicates the first revisit. In other words, if the sensor on that
     * job actually is revisiting the last Job Definition Segment's bounding area, increment the
     * count, otherwise reset to 0.
     *
     * <p>The dwell index corresponds to field D3 in STANAG 4607 Edition 3 document. The temporally
     * sequential count of a dwell within the revisit of a particular bounding area for a given job
     * ID. A dwell index of 0 indicates the first dwell of the revisit. (Note: Revisit counts are
     * allowed to “wrap” when the allowable range of revisits is exceeded.)
     *
     * @param revisitIndex the revisit index
     * @param dwellIndex the dwell index
     */
    public RadarInformation(int revisitIndex, int dwellIndex) {
        this.revisitIndex = revisitIndex;
        this.dwellIndex = dwellIndex;
    }

    /**
     * Revisit index.
     *
     * <p>The revisit index corresponds to field D2 in STANAG 4607 Edition 3 document. The
     * sequential count of a revisit of the bounding area in the last sent Job Definition Segment,
     * where a Revisit Index of 0 indicates the first revisit. In other words, if the sensor on that
     * job actually is revisiting the last Job Definition Segment's bounding area, increment the
     * count, otherwise reset to 0.
     *
     * @return revisit index
     */
    public int getRevisitIndex() {
        return revisitIndex;
    }

    /**
     * Set the revisit index.
     *
     * <p>The revisit index corresponds to field D2 in STANAG 4607 Edition 3 document. The
     * sequential count of a revisit of the bounding area in the last sent Job Definition Segment,
     * where a Revisit Index of 0 indicates the first revisit. In other words, if the sensor on that
     * job actually is revisiting the last Job Definition Segment's bounding area, increment the
     * count, otherwise reset to 0.
     *
     * @param revisitIndex revisit index
     */
    public void setRevisitIndex(int revisitIndex) {
        this.revisitIndex = revisitIndex;
    }

    /**
     * Dwell index.
     *
     * <p>The dwell index corresponds to field D3 in STANAG 4607 Edition 3 document. The temporally
     * sequential count of a dwell within the revisit of a particular bounding area for a given job
     * ID. A dwell index of 0 indicates the first dwell of the revisit. (Note: Revisit counts are
     * allowed to “wrap” when the allowable range of revisits is exceeded.)
     *
     * @return the dwell index
     */
    public int getDwellIndex() {
        return dwellIndex;
    }

    /**
     * Set the dwell index.
     *
     * <p>The dwell index corresponds to field D3 in STANAG 4607 Edition 3 document. The temporally
     * sequential count of a dwell within the revisit of a particular bounding area for a given job
     * ID. A dwell index of 0 indicates the first dwell of the revisit. (Note: Revisit counts are
     * allowed to “wrap” when the allowable range of revisits is exceeded.)
     *
     * @param dwellIndex the dwell index
     */
    public void setDwellIndex(int dwellIndex) {
        this.dwellIndex = dwellIndex;
    }
}
