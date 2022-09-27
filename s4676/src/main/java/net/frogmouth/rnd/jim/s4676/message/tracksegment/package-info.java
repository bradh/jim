/**
 * Track segment information.
 *
 * <p>The main class in this package is {@link TrackSegment} which encapsulates zero or more track
 * points adjacent in time. This provides a way for a data producer to later refer to a group of
 * points in order (for example) to update the confidence of or invalidate the points, without
 * restating or referring to each individual point. TrackSegment is also the class that allows the
 * data producer to report the track status of the included track points. In addition, TrackSegment
 * allows the data producer to associate different track source information with just a specific
 * portion of the track than specified for the track as a whole.
 */
package net.frogmouth.rnd.jim.s4676.message.tracksegment;
