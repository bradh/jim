/**
 * Track message information.
 *
 * <p>The main class in this package is {@link TrackMessage} which contains objects specifying the
 * actual detections, tracks, and information derived from the tracks.
 *
 * <p>A data provider may include any number of TrackMessage objects within a single NITSRoot
 * object. However, depending on the individual data syntax being used, the data provider can be
 * restricted both in number of messages and whether messages can be interleaved with the other
 * contents of the containing NITSRoot object.
 */
package net.frogmouth.rnd.jim.s4676.message;
