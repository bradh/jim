package net.frogmouth.rnd.jim.s4676.message.trackpoint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;

/**
 * Evidence.
 *
 * <p>The Evidence class specifies that the tracker believes a detection is indeed an indicator for
 * the tracked object, whether that detection provides direct or circumstantial evidence of the
 * tracked object, and the confidence of the tracker in that conclusion.
 *
 * <p>Each piece of evidence can be described by an outlined area (most likely a polygon area).
 * CIRCUMSTANTIAL evidence can also be assigned a subtype.
 *
 * <p>When the producer reports both the UUID and a validity, the producer can modify the
 * association between previously-reported track points and previously-reported evidence by simply
 * reissuing a minimal TrackPoint object with the same ID as previously specified for that
 * TrackPoint, and including a minimal Evidence object containing only an updated Confidence object.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uid", "lid", "detectionUID", "detectionLID", "confidence"})
public class Evidence extends IdentifiedElement {
    @JacksonXmlProperty(isAttribute = true)
    private EvidenceType type;

    @JacksonXmlProperty(isAttribute = true)
    private IEvidenceSubtype subType;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "detectionUID")
    private List<UniqueID> detectionUIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "detectionLID")
    private List<Long> detectionLIDs;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    /**
     * Constructor.
     *
     * <p>No part of the Evidence is mandatory, however an empty Evidence instance may not be very
     * useful.
     */

    /**
     * Evidence type.
     *
     * <p>A categorization of the evidence. The evidence is either DIRECT or CIRCUMSTANTIAL.
     *
     * @return the evidence type as an enumerated value.
     */
    public EvidenceType getType() {
        return type;
    }

    /**
     * Set the evidence type.
     *
     * <p>A categorization of the evidence. The evidence is either DIRECT or CIRCUMSTANTIAL.
     *
     * @param type the evidence type
     */
    public void setType(EvidenceType type) {
        this.type = type;
    }

    /**
     * The evidence subtype.
     *
     * <p>A subtype of the evidence, such as “WAKE”, “DUST_PLUME”, "TIRE_TRACKS", or “SHADOW”. Only
     * used when the Evidence type is CIRCUMSTANTIAL.
     *
     * @return the evidence subtype as an enumerated value.
     */
    public IEvidenceSubtype getSubType() {
        return subType;
    }

    /**
     * Set the evidence subtype.
     *
     * <p>A subtype of the evidence, such as “WAKE”, “DUST_PLUME”, TIRE_TRACKS, or “SHADOW”. Only
     * used when the Evidence type is CIRCUMSTANTIAL.
     *
     * @param subType the evidence subtype
     */
    public void setSubType(IEvidenceSubtype subType) {
        this.subType = subType;
    }

    /**
     * Add detection unique identifier.
     *
     * <p>A unique ID reference to a detection that form part or all of the basis for this evidence.
     * Either detectionUID or detectionLID must be specified if the data producer wants to report
     * evidence.
     *
     * @param uid the unique identifier to add
     */
    public void addDetectionUID(UniqueID uid) {
        if (this.detectionUIDs == null) {
            this.detectionUIDs = new ArrayList<>();
        }
        this.detectionUIDs.add(uid);
    }

    /**
     * Detection unique identifiers.
     *
     * <p>A unique ID reference to the detection(s) that form the basis for this evidence. Either
     * detectionUID or detectionLID must be specified if the data producer wants to report evidence.
     *
     * @return list of unique identifiers.
     */
    @JsonIgnore
    public List<UniqueID> getDetectionUIDs() {
        return this.detectionUIDs;
    }

    /**
     * Add detection local identifier.
     *
     * <p>A local ID reference to a detection that form part or all of the basis for this evidence.
     * Either detectionUID or detectionLID must be specified if the data producer wants to report
     * evidence.
     *
     * @param lid the local identifier to add
     */
    public void addDetectionLID(long lid) {
        if (this.detectionLIDs == null) {
            this.detectionLIDs = new ArrayList<>();
        }
        this.detectionLIDs.add(lid);
    }

    /**
     * Detection local identifiers.
     *
     * <p>A local ID reference to the detection(s) that form the basis for this evidence. Either
     * detectionUID or detectionLID must be specified if the data producer wants to report evidence.
     *
     * @return list of local identifiers.
     */
    @JsonIgnore
    public List<Long> getDetectionLIDs() {
        return this.detectionLIDs;
    }

    /**
     * Confidence.
     *
     * <p>An optional confidence assessment for the association between the track point and the
     * detection detailed in this evidence.
     *
     * @return the confidence type and value
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /**
     * Set confidence.
     *
     * <p>An optional confidence assessment for the association between the track point and the
     * detection detailed in this evidence.
     *
     * @param confidence the confidence type and value
     */
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }
}
