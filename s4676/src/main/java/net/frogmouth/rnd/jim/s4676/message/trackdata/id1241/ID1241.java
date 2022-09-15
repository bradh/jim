package net.frogmouth.rnd.jim.s4676.message.trackdata.id1241;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.frogmouth.rnd.jim.s4676.sensor.ModalityType;

/**
 * STANAG 1241 Identity.
 *
 * <p>Class of attributes drawn from STANAG 1241 to be used in conjunction with other available
 * information for the purpose of threat identification when exchanging tactical information in
 * NATO. It should be noted the attribute values in the associated tables are populated directly
 * from STANAG 1241 as agreed upon and cannot be extended or changed without approved changes to
 * STANAG 1241.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"identity", "identityAmplification", "identitySourceModality", "environment"})
public class ID1241 {
    private Identity identity;
    private IdentityAmplification identityAmplification;
    private ModalityType identitySourceModality;
    private TrackEnvironment environment;

    // TODO: constructors
    // TODO: getters and setters
}
