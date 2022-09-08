package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Radar STANAG 4607 (GMTI) reporting.
 *
 * <p>The Radar4607 class provides Radar feature-related data pertinent to a single detection.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"revisitIndex", "dwellIndex"})
public class Radar4607 {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private int reportIndex;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private short hrrType;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes the report index and HRR type.
     */
    private Radar4607() {}

    /**
     * Constructor.
     *
     * <p>The report requires the report index and HRR type.
     *
     * <p>The report index corresponds to field D32.1 in STANAG 4607 Edition 3 document. The
     * sequential count of this Moving Target Indication (MTI) report within the dwell.
     *
     * <p>The HRR type corresponds to field H23 in STANAG 4607 Edition 3 document. H23 is an
     * enumeration field which designates the type of data being delivered. Acceptable values for
     * enumeration are:
     *
     * <ul>
     *   <li>0=Other
     *   <li>1=1-D HRR Profile - An HRR chip having samples in a single doppler bin, multiple range
     *       samples and corresponding to a single detected entity
     *   <li>2=2-D HRR Chip - An HRR chip with samples in both dimensions and corresponding to a
     *       single detected entity
     *   <li>3= Sparse HRR Chip - An HRR chip with scattered records sparsely (noncontiguous range
     *       and doppler) representing the range- doppler space of a single detected entity
     *   <li>4= Oversized HRR Chip - A 2-D HRR chip with excess range/doppler beyond the extent of
     *       the detected entity to which the chip corresponds (this is basically a partial RDM that
     *       is correlated to an entity by the MTI Report Index)
     *   <li>5= Full RDM - A Range Doppler Map with Contiguous Samples in range and doppler
     *       corresponding to the full detection space of the radar system
     *   <li>6= Partial RDM - A Range Doppler Map with Contiguous Samples in range and doppler
     *       corresponding to a small portion of the detection space of the radar system
     *   <li>7= Full Range Pulse Data - A data block of data in pulse-range space following range
     *       processing without any doppler processing performed
     *   <li>8 - 255=Reserved
     * </ul>
     *
     * @param reportIndex the revisit index
     * @param hrrType the HRR type (enumerated value)
     */
    public Radar4607(int reportIndex, short hrrType) {
        this.reportIndex = reportIndex;
        this.hrrType = hrrType;
    }

    /**
     * Report index.
     *
     * <p>The report index corresponds to field D32.1 in STANAG 4607 Edition 3 document. The
     * sequential count of this Moving Target Indication (MTI) report within the dwell.
     *
     * @return the report index
     */
    public int getReportIndex() {
        return reportIndex;
    }

    /**
     * Set the report index.
     *
     * <p>The report index corresponds to field D32.1 in STANAG 4607 Edition 3 document. The
     * sequential count of this Moving Target Indication (MTI) report within the dwell.
     *
     * @param reportIndex the report index
     */
    public void setReportIndex(int reportIndex) {
        this.reportIndex = reportIndex;
    }

    /**
     * HRR type.
     *
     * <p>The HRR type corresponds to field H23 in STANAG 4607 Edition 3 document. H23 is an
     * enumeration field which designates the type of data being delivered. Acceptable values for
     * enumeration are:
     *
     * <ul>
     *   <li>0=Other
     *   <li>1=1-D HRR Profile - An HRR chip having samples in a single doppler bin, multiple range
     *       samples and corresponding to a single detected entity
     *   <li>2=2-D HRR Chip - An HRR chip with samples in both dimensions and corresponding to a
     *       single detected entity
     *   <li>3= Sparse HRR Chip - An HRR chip with scattered records sparsely (noncontiguous range
     *       and doppler) representing the range- doppler space of a single detected entity
     *   <li>4= Oversized HRR Chip - A 2-D HRR chip with excess range/doppler beyond the extent of
     *       the detected entity to which the chip corresponds (this is basically a partial RDM that
     *       is correlated to an entity by the MTI Report Index)
     *   <li>5= Full RDM - A Range Doppler Map with Contiguous Samples in range and doppler
     *       corresponding to the full detection space of the radar system
     *   <li>6= Partial RDM - A Range Doppler Map with Contiguous Samples in range and doppler
     *       corresponding to a small portion of the detection space of the radar system
     *   <li>7= Full Range Pulse Data - A data block of data in pulse-range space following range
     *       processing without any doppler processing performed
     *   <li>8 - 255=Reserved
     * </ul>
     *
     * @return the HRR type as an enumerated integer value
     */
    public short getHrrType() {
        return hrrType;
    }

    /**
     * Set the HRR type.
     *
     * <p>The HRR type corresponds to field H23 in STANAG 4607 Edition 3 document. H23 is an
     * enumeration field which designates the type of data being delivered. Acceptable values for
     * enumeration are:
     *
     * <ul>
     *   <li>0=Other
     *   <li>1=1-D HRR Profile - An HRR chip having samples in a single doppler bin, multiple range
     *       samples and corresponding to a single detected entity
     *   <li>2=2-D HRR Chip - An HRR chip with samples in both dimensions and corresponding to a
     *       single detected entity
     *   <li>3= Sparse HRR Chip - An HRR chip with scattered records sparsely (noncontiguous range
     *       and doppler) representing the range- doppler space of a single detected entity
     *   <li>4= Oversized HRR Chip - A 2-D HRR chip with excess range/doppler beyond the extent of
     *       the detected entity to which the chip corresponds (this is basically a partial RDM that
     *       is correlated to an entity by the MTI Report Index)
     *   <li>5= Full RDM - A Range Doppler Map with Contiguous Samples in range and doppler
     *       corresponding to the full detection space of the radar system
     *   <li>6= Partial RDM - A Range Doppler Map with Contiguous Samples in range and doppler
     *       corresponding to a small portion of the detection space of the radar system
     *   <li>7= Full Range Pulse Data - A data block of data in pulse-range space following range
     *       processing without any doppler processing performed
     *   <li>8 - 255=Reserved
     * </ul>
     *
     * @param hrrType the HRR type as an enumerated integer value
     */
    public void setHrrType(short hrrType) {
        this.hrrType = hrrType;
    }
}
