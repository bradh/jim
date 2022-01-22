package net.frogmouth.rnd.jim.s4607.FreeTextSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

/**
 * Free Text Segment.
 *
 * <p>The Free Text Segment provides a means of sending Basic Character Set (BCS) alphanumeric text
 * messages. The Free Text Segment shall be sent as required.
 *
 * <p>The free text segment can be used as a means by which amplifying information is added to
 * information already contained within an existing GMTIF message. It is not intended to be a means
 * by which developers are able to circumvent the segments provided within STANAG 4607. The
 * free-text capability provides a long-term flexibility for capturing information, comments, and
 * additional data pertaining to STANAG 4607 messages, and provides the capability for
 * bandwidth-challenged users, or users without collaboration opportunities, to include information
 * relevant to the data files. It enables the recording of situational data relevant to future use
 * of the information, including multi-platform collection scenario information. Free-text also
 * allows the capability for the independent search of parameters with keywords, unstructured text
 * searches, etc. as applications are web-enabled. An additional use of free- text is to provide
 * annotation information on MTI products. There is currently no standard format for “exploited”
 * MTI, and the Free Text Segment provides an interim means for passing exploitation and annotation
 * information with the data files for further use.
 *
 * <p>Examples of the recommended use of this free text segment include:
 *
 * <ul>
 *   <li>Operational Context Information: "Movement on Route Zulu corresponds to ingress by Task
 *       Force Delta at 1045Z"
 *   <li>Historical Context Information: "Flow through checkpoint Bravo highest from 0700Z to 1000Z
 *       – 10 vehicles/min – Suspected movement to assembly area Charlie"
 * </ul>
 */
public class FreeTextSegment extends Segment {

    private String originatorId;
    private String recipientId;
    private String freeText;

    /** Constructor. */
    public FreeTextSegment() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.FreeTextSegment;
    }

    /**
     * Originator ID (F1).
     *
     * <p>Alphanumeric field that identifies the originator of the Free Text message.
     *
     * <p>This field is mandatory.
     *
     * @return originator ID
     */
    public String getOriginatorId() {
        return originatorId;
    }

    /**
     * Originator ID (F1).
     *
     * <p>Alphanumeric field that identifies the originator of the Free Text message.
     *
     * <p>This field is mandatory.
     *
     * @param originatorId originator identifier, 10 characters max
     */
    public void setOriginatorId(String originatorId) {
        validateBCS(originatorId, 10);
        this.originatorId = originatorId;
    }

    /**
     * Recipient ID (F2).
     *
     * <p>Alphanumeric field that identifies the recipient for which the Free Text message is
     * intended.
     *
     * <p>This field is mandatory.
     *
     * @return recipient identifier
     */
    public String getRecipientId() {
        return recipientId;
    }

    /**
     * Recipient ID (F2).
     *
     * <p>Alphanumeric field that identifies the recipient for which the Free Text message is
     * intended.
     *
     * <p>This field is mandatory.
     *
     * @param recipientId recipient identifier, 10 characters maximum.
     */
    public void setRecipientId(String recipientId) {
        validateBCS(recipientId, 10);
        this.recipientId = recipientId;
    }

    /**
     * Free Text (F3).
     *
     * <p>Alphanumeric field for the entry of free-text data.
     *
     * <p>This field is mandatory.
     *
     * @return free text content
     */
    public String getFreeText() {
        return freeText;
    }

    /**
     * Free Text (F3).
     *
     * <p>Alphanumeric field for the entry of free-text data.
     *
     * <p>This field is mandatory.
     *
     * @param freeText free text content, 1 to 65515 characters
     */
    public void setFreeText(String freeText) {
        validateBCS(recipientId, 66515);
        this.freeText = freeText;
    }
}
