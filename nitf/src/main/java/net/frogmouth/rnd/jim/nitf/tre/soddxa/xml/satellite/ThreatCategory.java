package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ThreatCategory {
    /**
     * Bandit.
     *
     * <p>A {@link SUSPECT} whose orbital parameters are such that it may become a collection and/or
     * counterspace concern to a spacecraft in the relative near-term, therefore limiting decision
     * space.
     */
    @JsonProperty("bandit")
    BANDIT,

    /**
     * Bogey.
     *
     * <p>An element (e.g., contact, track) whose identity is unknown. Some databases of space
     * object information refer to this threat category as “Pending”.
     */
    @JsonProperty("bogey")
    BOGEY,

    /**
     * Friend.
     *
     * <p>A satellite that does not pose a threat or present any danger.
     */
    @JsonProperty("friend")
    FRIEND,

    /**
     * Furball.
     *
     * <p>A group of satellites that have come together such that off-board sensors (e.g., radar,
     * optical) cannot distinguish relative positions. Some databases of space object information
     * refer to this threat category as "Merge".
     */
    @JsonProperty("furball")
    FURBALL,

    /**
     * Intruder.
     *
     * <p>A collection system in or near an operational or exercise area, which represents the
     * threat of intelligence gathering or disruptive activity.
     */
    @JsonProperty("intruder")
    INTRUDER,

    /**
     * Stalker.
     *
     * <p>A bandit with counterspace capability that has significantly refined orbital parameters
     * required to engage a satellite.
     */
    @JsonProperty("stalker")
    STALKER,

    /**
     * Suspect.
     *
     * <p>A known or suspected R&amp;D or operational counterspace capability or collection
     * capability.
     */
    @JsonProperty("suspect")
    SUSPECT
}
