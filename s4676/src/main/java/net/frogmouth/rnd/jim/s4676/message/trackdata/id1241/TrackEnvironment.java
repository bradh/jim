package net.frogmouth.rnd.jim.s4676.message.trackdata.id1241;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Track Environment.
 *
 * <p>Provides an estimate of the type of environment in which a track is computed. Accepted values
 * for TrackEnvironment are derived from STANAG 1241. They indicate subsets of tactical information
 * (e.g. air tracks, maritime tracks) and are used in combination with other information to
 * determine Identity Amplification.
 */
public enum TrackEnvironment {
    /**
     * Land.
     *
     * <p>The track is on a dry land surface.
     */
    LAND,
    /**
     * Surface.
     *
     * <p>The track is on the water surface.
     */
    SURFACE,
    /**
     * Sub-surface.
     *
     * <p>The track is under the water surface.
     */
    @JsonProperty("SUB-SURFACE")
    SUB_SURFACE,
    /**
     * Air.
     *
     * <p>The track is in the air, between sea level and the Kármán line, which is the altitude of
     * 100 kilometres (62 mi).
     */
    AIR,
    /**
     * Space.
     *
     * <p>The track is above the Kármán line, which is the altitude of 100 kilometres (62 mi).
     */
    SPACE,
    /**
     * Unknown.
     *
     * <p>The track environment is not known.
     */
    UNKNOWN
}
