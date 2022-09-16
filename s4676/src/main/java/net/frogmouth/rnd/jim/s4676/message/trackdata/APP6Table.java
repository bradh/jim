package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * APP-6 Table.
 *
 * <p>Numerical code referring to one or more of the 14 different tables in APP-6 that list
 * NATO-standardized encodings for a variety of objects, activities, and locations. This attribute
 * specifies a code for the categorization.
 */
public enum APP6Table {
    /**
     * Air.
     *
     * <p>Value: 01.
     *
     * <p>APP-6 Tables A-10, A-11, A-12.
     */
    AIR,

    /**
     * Air Missile.
     *
     * <p>Value: 02.
     *
     * <p>APP-6 Tables A-13, A-14, A-15
     */
    AIR_MISSILE,

    /**
     * Space.
     *
     * <p>Value: 05.
     *
     * <p>APP-6 Tables A-16, A-17, A-18
     */
    SPACE,

    /**
     * Land unit.
     *
     * <p>Value: 10
     *
     * <p>APP-6 Tables A-19, A-20, A-21.
     */
    LAND_UNIT,

    /**
     * Land civilian unit / organisation.
     *
     * <p>Value: 11.
     *
     * <p>APP-6 Tables A-22, A-23, A-24.
     */
    @JsonProperty("LAND_CIVILIAN_UNIT/ORGANIZATION")
    LAND_CIVILIAN_UNIT_ORGANIZATION,

    /**
     * Land equipment.
     *
     * <p>Value: 15.
     *
     * <p>APP-6 Tables A-25, A-26.
     */
    LAND_EQUIPMENT,

    /**
     * Land installation.
     *
     * <p>Value: 20.
     *
     * <p>APP-6 Tables A-27, A-28, A-29.
     */
    LAND_INSTALLATION,

    /**
     * Control measure.
     *
     * <p>Value: 25.
     *
     * <p>APP-6 Table A-30.
     */
    CONTROL_MEASURE,

    /**
     * Dismounted individual.
     *
     * <p>Value: 27.
     *
     * <p>APP-6 Tables A-31, A-32, A-33.
     */
    DISMOUNTED_INDIVIDUAL,

    /**
     * Sea surface.
     *
     * <p>Value: 30.
     *
     * <p>APP-6 Tables A-34, A-35, A-36.
     */
    SEA_SURFACE,

    /**
     * Sea subsurface.
     *
     * <p>Value: 35.
     *
     * <p>APP-6 Tables A-37, A-38, A-39.
     */
    SEA_SUBSURFACE,

    /**
     * Mine warfare.
     *
     * <p>Value: 36.
     *
     * <p>APP-6 Table A-40.
     */
    MINE_WARFARE,

    /**
     * Activities.
     *
     * <p>Value: 40.
     *
     * <p>APP-6 Tables A-41, A-42.
     */
    ACTIVITIES,

    /**
     * Atmospheric.
     *
     * <p>Value: 45.
     *
     * <p>APP-6 Table A-43.
     */
    ATMOSPHERIC
}
