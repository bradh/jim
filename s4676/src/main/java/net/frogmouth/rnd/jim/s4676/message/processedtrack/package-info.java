/**
 * Processed track information.
 *
 * <p>The {@link ProcessedTrack} class records when one or more tracks are processed to create a
 * single output track that subsumes the input tracks. There are currently only two
 * ProcessedTrackType (“FUSED” and “SMOOTHED”).
 *
 * <p>This class can also be used to invalidate previously-reported track processes (for example, if
 * the tracker decides – based on some new information – that a previously- reported fused track
 * should not have included track 15 because that track is now moving independently).
 */
package net.frogmouth.rnd.jim.s4676.message.processedtrack;
