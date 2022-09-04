package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Track Linkage.
 *
 * <p>The TrackLinkage class describes a relationship between two or more tracks (referenced via
 * their UIDs/LIDs). Possible relationships include split, merge, and stitch. This class can also be
 * used to invalidate previously-reported track relationships (for example, if the tracker decides –
 * based on some new information – that a previously- reported stitch linkage between tracks 1 and 2
 * cannot be correct, because the cars are different colors). To do so, the data producer must
 * report a TrackLinkage with the same UUID as the now-invalid TrackLinkage, along with an
 * appropriate new confidence value (for example, a confidence value of 0, and a confidence validity
 * of FALSE). There is no need to repeat the LIDs or UUIDs of the tracks involved in the
 * previously-reported TrackLinkage., This feature can only be used if the data producer utilizes
 * LIDs or UUIDs in the TrackLinkage class.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "relTime",
    "confidence",
    "preUID",
    "preLID",
    "postUID",
    "postLID"
})
public class TrackLinkage extends IdentifiedElement {

    // TODO: TrackLinkageType : type
    // TODO: relTime
    // TODO:     "confidence",
    // TODO: "preUID",
    // TODO: "preLID",
    // TODO: "postUID",
    // TODO: "postLID"

}
