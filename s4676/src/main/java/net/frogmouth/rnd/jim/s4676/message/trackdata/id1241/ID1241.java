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

    /**
     * Constructor.
     *
     * <p>No parts of ID1241 are mandatory, but that may not be a very useful identity element.
     */
    public ID1241() {}

    /**
     * Identity.
     *
     * <p>Provides the estimated identity/status of an object being tracked. Values in accordance
     * with STANAG 1241, Edition 5.
     *
     * @return standard identity as an enumerated value
     */
    public Identity getIdentity() {
        return identity;
    }

    /**
     * Set the identity.
     *
     * <p>Provides the estimated identity/status of an object being tracked. Values in accordance
     * with STANAG 1241, Edition 5.
     *
     * @param identity standard identity.
     */
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    /**
     * Identity amplification.
     *
     * <p>Provides additional identity/status information (amplification) of an object being
     * tracked. Values in accordance with STANAG 1241 Edition 5.
     *
     * @return identity amplification as an enumerated value
     */
    public IdentityAmplification getIdentityAmplification() {
        return identityAmplification;
    }

    /**
     * Set the identity amplification.
     *
     * <p>Provides additional identity/status information (amplification) of an object being
     * tracked. Values in accordance with STANAG 1241 Edition 5.
     *
     * @param identityAmplification identity amplification as an enumerated value
     */
    public void setIdentityAmplification(IdentityAmplification identityAmplification) {
        this.identityAmplification = identityAmplification;
    }

    /**
     * Modality type.
     *
     * <p>Provides the source used to determine/estimate the identity. Transmitted only if identity
     * is provided.
     *
     * @return the source modality type.
     */
    public ModalityType getIdentitySourceModality() {
        return identitySourceModality;
    }

    /**
     * Set the modality type.
     *
     * <p>Provides the source used to determine/estimate the identity. Transmitted only if identity
     * is provided.
     *
     * @param identitySourceModality the source modality type.
     */
    public void setIdentitySourceModality(ModalityType identitySourceModality) {
        this.identitySourceModality = identitySourceModality;
    }

    /**
     * Track environment.
     *
     * <p>Provides an estimate of the type of environment in which a track is computed. Accepted
     * values for TrackEnvironment are derived from STANAG 1241. They indicate subsets of tactical
     * information (e.g. air tracks, maritime tracks) and are used in combination with other
     * information to determine Identity Amplification.
     *
     * @return the track environment
     */
    public TrackEnvironment getEnvironment() {
        return environment;
    }

    /**
     * Set the track environment.
     *
     * <p>Provides an estimate of the type of environment in which a track is computed. Accepted
     * values for TrackEnvironment are derived from STANAG 1241. They indicate subsets of tactical
     * information (e.g. air tracks, maritime tracks) and are used in combination with other
     * information to determine Identity Amplification.
     *
     * @param environment the track environment
     */
    public void setEnvironment(TrackEnvironment environment) {
        this.environment = environment;
    }
}
