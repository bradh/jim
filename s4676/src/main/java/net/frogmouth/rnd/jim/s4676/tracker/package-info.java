/**
 * Tracker related information.
 *
 * <p>The primary class is {@link TrackerInformation}, which is mostly self-explanatory. There are
 * two extensible enumerations, which are modelled as {@link ISupplementaryDataType} and {@link
 * ITrackerType}. The standard values for those are provided in {@link SupplementaryDataType} and
 * {@link TrackerType}.
 *
 * <p>The {@code TrackerInformation} class contains high-level information specific to a tracker
 * used to form detections into tracks. If a system has multiple trackers that are used to generate
 * tracks, each tracker's information must be recorded as a separate instance of this class.
 */
package net.frogmouth.rnd.jim.s4676.tracker;
