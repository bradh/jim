/**
 * Processing History Segment.
 *
 * <p>The Processing History Segment provides information concerning changes or modifications made
 * to the original or modified sensor data. It references the Nationality, Platform, Mission, and
 * Job ID values of the original radar job and describes subsequent processing operations performed
 * on the data from that radar job. It provides notification that the original data values may have
 * been altered and provides a record of one or more processing operations performed on the original
 * radar data by one or more systems. If the processing performed by a system is based on data which
 * has been previously processed or modified, the system shall be responsible for maintaining the
 * previous processing history and for adding information pertaining to the current processing which
 * it has applied. Within the Processing History Segment, the system providing the additional
 * processing shall develop a new Processing Record to provide information pertaining to the
 * processed data which it is sending. The Processing Record shall include Nationality, Platform,
 * Mission, and Job ID information that identifies the processing system as the originator of the
 * processed data. The systems shall also provide a record of the processing which has been
 * performed and shall define a new radar job with which the modified data is associated. The
 * Processing History Segment shall be transmitted every 3 minutes.
 */
package net.frogmouth.rnd.jim.s4607.processinghistory;
