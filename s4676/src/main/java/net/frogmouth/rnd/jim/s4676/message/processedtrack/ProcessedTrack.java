package net.frogmouth.rnd.jim.s4676.message.processedtrack;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;

/**
 * Processed Track.
 *
 * <p>The ProcessedTrack class records when one or more tracks (referenced via their UIDs/LIDs) are
 * processed to create a single output track that subsumes the input tracks. There are currently
 * only two ProcessedTrackType (“FUSED” and “SMOOTHED”).
 *
 * <p>This class can also be used to invalidate previously-reported track processes (for example, if
 * the tracker decides – based on some new information – that a previously- reported fused track
 * should not have included track 15 because that track is now moving independently). To do so, the
 * data producer must report a ProcessedTrack with the same UUID as the now-invalid ProcessedTrack,
 * along with an appropriate new confidence value (for example, a confidence value of 0, and a
 * confidence validity of FALSE). There is no need to repeat the LIDs or UUIDs of the tracks
 * involved in the previously-reported ProcessedTrack. This feature can only be used if the data
 * producer utilizes LIDs or UUIDs in the ProcessedTrack class.
 *
 * <p>Regardless, of how it is specified (UID/LID), at least one input and one output must be
 * included.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uid", "lid", "confidence", "inputUID", "inputLID", "outputUID", "outputLID"})
public class ProcessedTrack extends IdentifiedElement {

    @JacksonXmlProperty(isAttribute = true)
    private IProcessedTrackType type;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "inputUID")
    private List<UniqueID> inputUIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "inputLID")
    private List<Long> inputLIDs;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private UniqueID outputUID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long outputLID;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a track type.
     */
    private ProcessedTrack() {}

    /**
     * Constructor.
     *
     * @param type the type of processing
     */
    public ProcessedTrack(IProcessedTrackType type) {
        this.type = type;
    }

    /**
     * Processed track type.
     *
     * <p>The type of the processed track being documented.
     *
     * @return the processing type
     */
    public IProcessedTrackType getType() {
        return type;
    }

    /**
     * Set the processed track type.
     *
     * <p>The type of the processed track being documented.
     *
     * @param type the processing type
     */
    public void setType(IProcessedTrackType type) {
        this.type = type;
    }

    /**
     * Confidence.
     *
     * <p>The producer’s estimate of the confidence that the input tracks represent the output
     * track. The intended use case for this information is for when the producer is generating data
     * products in a stream and decides that a previously-reported track process is no longer valid.
     * In this case, the producer would report that the ProcessedTrack.uid now has a validity of
     * FALSE. When declaring a relationship invalid, only the trackProcess.uid/trackProcess.lid and
     * trackProcess.confidence attributes need to be reported.
     *
     * @return the confidence estimate
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /**
     * Set the confidence.
     *
     * <p>The producer’s estimate of the confidence that the input tracks represent the output
     * track. The intended use case for this information is for when the producer is generating data
     * products in a stream and decides that a previously-reported track process is no longer valid.
     * In this case, the producer would report that the ProcessedTrack.uid now has a validity of
     * FALSE. When declaring a relationship invalid, only the trackProcess.uid/trackProcess.lid and
     * trackProcess.confidence attributes need to be reported.
     *
     * @param confidence the confidence estimate
     */
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    /**
     * Input track unique identifiers.
     *
     * @return list of unique identifiers for input tracks used in processing
     */
    public List<UniqueID> getInputUIDs() {
        return inputUIDs;
    }

    /**
     * Add an input track unique identifier.
     *
     * @param inputUID unique identifier
     */
    public void addInputUID(UniqueID inputUID) {
        if (this.inputUIDs == null) {
            this.inputUIDs = new ArrayList<>();
        }
        inputUIDs.add(inputUID);
    }

    /**
     * Input track local identifiers.
     *
     * @return list of local identifiers for input tracks used in processing
     */
    public List<Long> getInputLIDs() {
        return inputLIDs;
    }

    /**
     * Add an input track local identifier.
     *
     * @param inputLID local identifier
     */
    public void addInputLID(long inputLID) {
        if (this.inputLIDs == null) {
            this.inputLIDs = new ArrayList<>();
        }
        inputLIDs.add(inputLID);
    }

    /**
     * Output track UID.
     *
     * @return unique identifier
     */
    public UniqueID getOutputUID() {
        return outputUID;
    }

    /**
     * Set output track UID.
     *
     * @param outputUID unique identifier
     */
    public void setOutputUID(UniqueID outputUID) {
        this.outputUID = outputUID;
    }

    /**
     * Output track LID.
     *
     * @return local identifier
     */
    public Long getOutputLID() {
        return outputLID;
    }

    /**
     * Set output track LID.
     *
     * @param outputLID local identifier
     */
    public void setOutputLID(Long outputLID) {
        this.outputLID = outputLID;
    }
}
