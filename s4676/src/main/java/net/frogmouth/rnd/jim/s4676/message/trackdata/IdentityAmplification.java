package net.frogmouth.rnd.jim.s4676.message.trackdata;

/**
 * Identity amplification.
 *
 * <p>Provides additional identity/status information (amplification) of an object being tracked.
 * Values in accordance with STANAG 1241 Edition 5.
 */
public enum IdentityAmplification {
    /**
     * Faker.
     *
     * <p>Friendly track, object or entity acting as exercise hostile.
     */
    FAKER,
    /**
     * Joker.
     *
     * <p>Friendly track, object or entity acting as exercise suspect.
     */
    JOKER,
    /**
     * Kilo.
     *
     * <p>Friendly high-value object.
     */
    KILO,
    /**
     * Traveller.
     *
     * <p>A suspect surface track following a recognized surface traffic route.
     */
    TRAVELER,
    /**
     * Zombie.
     *
     * <p>A suspect track, object or entity of special interest.
     */
    ZOMBIE
}
