package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * NITS Root.
 *
 * <p>NITSRoot is the root class of the data model. A conformant instantiation of the model shall
 * contain one and only one NITSRoot object. If the data producer is transmitting a sequence of
 * NITSRoot objects, then it must define the mechanism to differentiate those separate objects in
 * compliance with the underlying data syntax.
 *
 * <p>For example, using the XML Schema form of the data model defined in Annex B, a single XML
 * instance document may contain only one &lt;xml ...&gt; declaration and only one root element.
 * Concatenating multiple independent NITSRoot objects into a single XML instance document results
 * in non-conformant XML; data producers that need to perform a concatenation such as this to
 * generate a single data stream must ensure that the data consumers realize that the stream must be
 * broken apart in order to parse individual NITSRoot objects using standard XML parsers. One
 * possible (but certainly not the only) mechanism would be to encapsulate the entire stream using
 * Multipart MIME headers as defined in IETF RFC 1341.
 */
@JacksonXmlRootElement(
        namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
        localName = "nitsRoot")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "profile",
    "streamUID",
    "fileUID",
    "fileLID",
    "lidScopeUID",
    "numFiles",
    "msgCreatedTime",
    "nitsVersion",
    "product",
    "collection",
    "sensor",
    "tracker",
    "message"
})
public class NitsRoot {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private List<String> profile;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ZonedDateTime msgCreatedTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String nitsVersion;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ProductIdentification product;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "collection")
    private List<CollectionInformation> collections;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "sensor")
    private List<SensorInformation> sensors;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "tracker")
    private List<TrackerInformation> trackers;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "message")
    private List<Message> messages;

    /**
     * Compliance Profile.
     *
     * <p>The name of a compliance profile to which this STANAG 4676 file conforms. A single file
     * can be conformant to multiple profiles. The indication of a conformance profile provides a
     * hint to the data consumer that the file can be consumed under specific constraints.
     *
     * <p>However, the data consumer shall not infer that a file is not conformant with a profile if
     * that profile is not explicitly indicated within the data; for example, a new conformance
     * profile can be defined in the future to reflect commonly used set of features of the
     * standard. Additional profiles should be proposed to and registered with the Custodian and
     * Editor.
     *
     * @return the compliance profiles
     */
    public List<String> getProfile() {
        return profile;
    }

    /**
     * Set the compliance profile(s).
     *
     * <p>The name of a compliance profile to which this STANAG 4676 file conforms. A single file
     * can be conformant to multiple profiles. The indication of a conformance profile provides a
     * hint to the data consumer that the file can be consumed under specific constraints.
     *
     * <p>.
     *
     * @param profiles the compliance profiles.
     */
    public void setProfile(List<String> profiles) {
        this.profile = profiles;
    }

    /**
     * Add a compliance profile.
     *
     * @param prof the profile;
     */
    public void addProfile(String prof) {
        if (this.profile == null) {
            this.profile = new ArrayList<>();
        }
        this.profile.add(prof);
    }

    /**
     * NITS Version.
     *
     * <p>A string of the AEDP-12 Edition letter and Version number, separated by a period. For
     * example, if the object is generated under the guidelines and organization of Edition B
     * Version 1, then this string should be "B.1".
     *
     * @return the NITS version as a String.
     */
    public String getNitsVersion() {
        return nitsVersion;
    }

    /**
     * Set the NITS Version.
     *
     * <p>A string of the AEDP-12 Edition letter and Version number, separated by a period. For
     * example, if the object is generated under the guidelines and organization of Edition B
     * Version 1, then this string should be "B.1".
     *
     * @param nitsVersion the NITS version as a String.
     */
    public void setNitsVersion(String nitsVersion) {
        this.nitsVersion = nitsVersion;
    }

    /**
     * Message creation time.
     *
     * <p>The date and time that the transmitted data were written to a STANAG 4676-formatted
     * object. This variable should be reported in Coordinated Universal Time (UTC).
     *
     * @return message creation time
     */
    public ZonedDateTime getMsgCreatedTime() {
        return msgCreatedTime;
    }

    /**
     * Set the message creation time.
     *
     * <p>The date and time that the transmitted data were written to a STANAG 4676-formatted
     * object. This variable should be reported in Coordinated Universal Time (UTC).
     *
     * @param msgCreatedTime message creation time
     */
    public void setMsgCreatedTime(ZonedDateTime msgCreatedTime) {
        this.msgCreatedTime = msgCreatedTime;
    }

    /**
     * Product identification.
     *
     * <p>Information that identifies this instance of NITSRoot as a specifically identified data
     * product associated with a specific system or program.
     *
     * <p>This field is optional.
     *
     * @return the product identification.
     */
    public ProductIdentification getProduct() {
        return product;
    }

    /**
     * Set the product identification.
     *
     * <p>Information that identifies this instance of NITSRoot as a specifically identified data
     * product associated with a specific system or program.
     *
     * <p>This field is optional.
     *
     * @param product the product identification.
     */
    public void setProduct(ProductIdentification product) {
        this.product = product;
    }

    /**
     * Add a collection.
     *
     * @param collection the collection information to add.
     */
    public void addCollection(CollectionInformation collection) {
        if (this.collections == null) {
            this.collections = new ArrayList<>();
        }
        this.collections.add(collection);
    }

    /**
     * Collection Information.
     *
     * <p>Information specific to the collection(s) that only needs to be reported once per NITS
     * product. If data from multiple collections were used to generate this NITF file, information
     * about each collection must be recorded as a separate instance of the CollectionInformation
     * class. For each collection, this currently includes the intent of the collection, the essence
     * of the collection, and the targetID.
     *
     * @return List of collections.
     */
    @JsonIgnore
    public List<CollectionInformation> getCollections() {
        return collections;
    }

    /**
     * Add a sensor.
     *
     * @param sensor the sensor information to add.
     */
    public void addSensor(SensorInformation sensor) {
        if (this.sensors == null) {
            this.sensors = new ArrayList<>();
        }
        this.sensors.add(sensor);
    }

    /**
     * Sensor Information.
     *
     * <p>Top-level information specific to the sensor(s) used to detect track points. If a system
     * has multiple sensors that are used to produce detections, each sensor's information must be
     * recorded as a separate instance of the SensorInformation class.
     *
     * @return List of sensors.
     */
    @JsonIgnore
    public List<SensorInformation> getSensors() {
        return sensors;
    }

    /**
     * Add a tracker.
     *
     * @param tracker the tracker information to add.
     */
    public void addTracker(TrackerInformation tracker) {
        if (this.trackers == null) {
            this.trackers = new ArrayList<>();
        }
        this.trackers.add(tracker);
    }

    /**
     * Tracker Information.
     *
     * <p>Top-level information specific to the tracker(s) used to group detections into tracks. If
     * a system has multiple trackers that are used to generate tracks, each tracker's information
     * must be recorded as a separate instance of the TrackerInformation class.
     *
     * @return List of trackers.
     */
    @JsonIgnore
    public List<TrackerInformation> getTrackers() {
        return trackers;
    }

    /**
     * Messages.
     *
     * <p>The portion of the NITSRoot that contains tracks and their constituent information.
     *
     * @return List of messages.
     */
    @JsonIgnore
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Set the messages.
     *
     * <p>The portion of the NITSRoot that contains tracks and their constituent information. This
     * is the main payload contents.
     *
     * @param messages list of messages.
     */
    public void setMessage(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Add a message.
     *
     * @param message the message to add.
     */
    public void addMessage(Message message) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        this.messages.add(message);
    }
}
