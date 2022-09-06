package net.frogmouth.rnd.jim.s4676.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;

/**
 * Motion Event.
 *
 * <p>The TrackMotionEvent class specifies a particular manoeuvre involving one or more tracks that
 * is of interest to the producer. Since the ability to measure these events is dependent upon the
 * data producer’s capabilities, the definition of each motion event is largely left to the data
 * producer (for example, what speed constitutes a “START” or “STOP” event).
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "trackUID",
    "trackLID",
    "startRelTime",
    "endRelTime",
    "confidence",
    "region",
    "tripwire"
})
public class MotionEvent extends IdentifiedElement {

    // TODO: MotionEventType : type
    // TODO: "trackUID",
    // TODO: "trackLID",
    // TODO: "startRelTime",
    // TODO: "endRelTime",
    // TODO: "confidence",
    // TODO: "region,
    // TODO: tripwire"

}
