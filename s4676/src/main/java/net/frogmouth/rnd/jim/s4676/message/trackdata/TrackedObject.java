package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;
import net.frogmouth.rnd.jim.s4676.message.trackdata.id1241.ID1241;

/**
 * Tracked object.
 *
 * <p>The TrackedObject class specifies time-invariant information about the tracked object, such as
 * the type of object (e.g., an Automobile or an Open-bed truck), its colour, and its identity
 * (“FRIEND”, “HOSTILE”).
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "description",
    "numberOfObjects",
    "objectColor",
    "confidence",
    "dims",
    "priority",
    "iffCode",
    "objectClass",
    "idSourceInformation",
    "id1241",
    "exampleDetectionUID",
    "exampleDetectionLID"
})
public class TrackedObject extends IdentifiedElement {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String description;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long numberOfObjects;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "objectColor")
    private List<Short[]> objectColours;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Double[] dims;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Short priority;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "iffCode")
    private List<IFFCode> iffCodes;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private List<ObjectClass> objectClasses;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private IDSourceInformation idSourceInformation;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ID1241 id1241;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "exampleDetectionUID")
    private List<UniqueID> exampleDetectionUIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "exampleDetectionLID")
    private List<Long> exampleDetectionLIDs;

    /**
     * Constructor.
     *
     * <p>No part of the TrackedObject is required, however that may not be a very useful instance.
     */
    public TrackedObject() {}

    /**
     * Description.
     *
     * <p>A string that the data producer can use to describe the tracked object in greater detail
     * than is otherwise allowed by the other attributes of this class.
     *
     * @return text description, or null if not set.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description.
     *
     * <p>A string that the data producer can use to describe the tracked object in greater detail
     * than is otherwise allowed by the other attributes of this class.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Number of objects.
     *
     * <p>The number of objects in the track (for example, if two vehicles are so close to each
     * other that they are indistinguishable for the duration of the track).
     *
     * @return the number of objects, or null if not set.
     */
    public Long getNumberOfObjects() {
        return numberOfObjects;
    }

    /**
     * Set the number of objects.
     *
     * <p>The number of objects in the track (for example, if two vehicles are so close to each
     * other that they are indistinguishable for the duration of the track).
     *
     * @param numberOfObjects the number of objects
     */
    public void setNumberOfObjects(Long numberOfObjects) {
        this.numberOfObjects = numberOfObjects;
    }

    /**
     * Object colours.
     *
     * <p>The RGB colour of the object(s) in the track, listed in order from most dominant to least
     * dominant.
     *
     * @return the list of colour triplets
     */
    public List<Short[]> getObjectColours() {
        return objectColours;
    }

    /**
     * Add an object colour.
     *
     * <p>The RGB colour of the object(s) in the track. When adding, they should be added in order
     * from most dominant to least dominant.
     *
     * @param objectColour colour triplets (Red, Green, Blue)
     */
    public void addObjectColour(Short[] objectColour) {
        if (this.objectColours == null) {
            this.objectColours = new ArrayList<>();
        }
        this.objectColours.add(objectColour);
    }

    /**
     * Confidence.
     *
     * <p>The producer’s confidence that the tracked object is described accurately by the
     * information contained within the TrackedObject class.
     *
     * <p>Confidence applies to all attributes in this TrackedObject instance. If the producer would
     * like to assign unique confidence values to specific TrackedObject attributes, they must be
     * listed as separate TrackedObject instances.
     *
     * <p>For example, if the “identity” and “environment” have different levels of confidence, then
     * two TrackedObjects should be reported for the two respective attributes.
     *
     * @return the confidence
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /**
     * Set the confidence.
     *
     * <p>The producer’s confidence that the tracked object is described accurately by the
     * information contained within the TrackedObject class.
     *
     * <p>Confidence applies to all attributes in this TrackedObject instance. If the producer would
     * like to assign unique confidence values to specific TrackedObject attributes, they must be
     * listed as separate TrackedObject instances.
     *
     * <p>For example, if the “identity” and “environment” have different levels of confidence, then
     * two TrackedObjects should be reported for the two respective attributes.
     *
     * @param confidence the confidence
     */
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    /**
     * Object dimensions.
     *
     * <p>Provides a list of the dimensions of an object, as well as the associated covariance
     * matrix. The order of this list is [length, width, height, covLL, covLW, covLH, covWW, covWH,
     * covHH]. Any dimensions that are not measured should be assigned the value -1. Any covariance
     * values that are not applicable should be assigned the value 0, and the data consumer should
     * know to ignore them because of the value of the length, width, or height.
     *
     * @return list of object dimensions and error covariances
     */
    public Double[] getDims() {
        return dims;
    }

    /**
     * Set the object dimensions.
     *
     * <p>Provides a list of the dimensions of an object, as well as the associated covariance
     * matrix. The order of this list is [length, width, height, covLL, covLW, covLH, covWW, covWH,
     * covHH]. Any dimensions that are not measured should be assigned the value -1. Any covariance
     * values that are not applicable should be assigned the value 0, and the data consumer should
     * know to ignore them because of the value of the length, width, or height.
     *
     * @param dims list of object dimensions and error covariances
     */
    public void setDims(Double[] dims) {
        this.dims = dims;
    }

    /**
     * Priority.
     *
     * <p>A producer-assigned priority for the tracked object. Valid range is 1-255, where 1 is the
     * highest priority. Multiple tracked objects may have the same priority.
     *
     * @return the priority level.
     */
    public Short getPriority() {
        return priority;
    }

    /**
     * Set the priority.
     *
     * <p>A producer-assigned priority for the tracked object. Valid range is 1-255, where 1 is the
     * highest priority. Multiple tracked objects may have the same priority.
     *
     * @param priority the priority level.
     */
    public void setPriority(Short priority) {
        this.priority = priority;
    }

    /**
     * IFF codes.
     *
     * <p>Provides the identification friend foe (IFF) information associated with the object.
     *
     * @return list of IFF codes
     */
    public List<IFFCode> getIffCodes() {
        return iffCodes;
    }

    /**
     * Add IFF code.
     *
     * @param iffCode IFF code to add
     */
    public void addIffCodes(IFFCode iffCode) {
        if (this.iffCodes == null) {
            this.iffCodes = new ArrayList<>();
        }
        this.iffCodes.add(iffCode);
    }

    /**
     * Get object classes.
     *
     * <p>The class of the object(s) in the track (e.g., an Automobile or an Open- bed truck). The
     * object class must conform to the APP-6 table of corresponding type.
     *
     * @return the object classes as a list
     */
    public List<ObjectClass> getObjectClass() {
        return objectClasses;
    }

    /**
     * Add object class.
     *
     * @param objectClass the object class to add.
     */
    public void addObjectClass(ObjectClass objectClass) {
        if (this.objectClasses == null) {
            this.objectClasses = new ArrayList<>();
        }
        this.objectClasses.add(objectClass);
    }

    /**
     * ID source information.
     *
     * <p>Extension of IDCP (Identification Data Combining Process) as described in STANAG 4162,
     * applied to the 4676 track environment.
     *
     * @return IDCP information
     */
    public IDSourceInformation getIdSourceInformation() {
        return idSourceInformation;
    }

    /**
     * Set the ID source information.
     *
     * <p>Extension of IDCP (Identification Data Combining Process) as described in STANAG 4162,
     * applied to the 4676 track environment.
     *
     * @param idSourceInformation IDCP information
     */
    public void setIdSourceInformation(IDSourceInformation idSourceInformation) {
        this.idSourceInformation = idSourceInformation;
    }

    /**
     * Standard identity and affiliation.
     *
     * <p>Group of identity-related attributes all populated from STANAG 1241, associated in order
     * to clarify origin, purpose, and usage.
     *
     * @return identity and affiliation of the tracked object, or null if not set
     */
    public ID1241 getId1241() {
        return id1241;
    }

    /**
     * Set the standard identity and affiliation.
     *
     * <p>Group of identity-related attributes all populated from STANAG 1241, associated in order
     * to clarify origin, purpose, and usage.
     *
     * @param id1241 identity and affiliation of the tracked object.
     */
    public void setId1241(ID1241 id1241) {
        this.id1241 = id1241;
    }

    /**
     * Example detection unique identifiers.
     *
     * <p>UID of a detection that exemplifies the tracked object.
     *
     * @return unique identifiers, or null if not set
     */
    public List<UniqueID> getExampleDetectionUIDs() {
        return exampleDetectionUIDs;
    }

    /**
     * Add an example detection unique identifier.
     *
     * <p>UID of a detection that exemplifies the tracked object.
     *
     * @param exampleDetectionUID the unique identifier.
     */
    public void addExampleDetectionUID(UniqueID exampleDetectionUID) {
        if (this.exampleDetectionUIDs == null) {
            this.exampleDetectionUIDs = new ArrayList<>();
        }
        this.exampleDetectionUIDs.add(exampleDetectionUID);
    }

    /**
     * Example detection local identifiers.
     *
     * <p>LID of a detection that exemplifies the tracked object.
     *
     * @return local identifiers, or null if not set
     */
    public List<Long> getExampleDetectionLIDs() {
        return exampleDetectionLIDs;
    }

    /**
     * Add an example detection local identifier.
     *
     * <p>LID of a detection that exemplifies the tracked object.
     *
     * @param exampleDetectionLID the local identifier.
     */
    public void addExampleDetectionLIDs(Long exampleDetectionLID) {
        if (this.exampleDetectionLIDs == null) {
            this.exampleDetectionLIDs = new ArrayList<>();
        }
        this.exampleDetectionLIDs.add(exampleDetectionLID);
    }
}
